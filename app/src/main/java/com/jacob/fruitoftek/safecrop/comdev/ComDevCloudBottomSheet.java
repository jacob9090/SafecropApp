package com.jacob.fruitoftek.safecrop.comdev;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.comdev.ch.ChildSurveyDBHelper;
import com.jacob.fruitoftek.safecrop.comdev.com.ComDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.cra.CraDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.gra.GraDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.hh.HhDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.lra.LraDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.obs.ObsDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.sch.SchoolDbHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ComDevCloudBottomSheet extends BottomSheetDialogFragment {

    public ComDbHelper comdbHelper;
    public SchoolDbHelper schdbHelper;
    public HhDbHelper hhdbHelper;
    public ObsDbHelper obsdbHelper;
    public ChildSurveyDBHelper chdbHelper;
    public GraDbHelper graDbHelper;
    public CraDbHelper craDbHelper;
    public LraDbHelper lraDbHelper;

    private ProgressDialog progressDialog;

    private static final int MAX_RETRIES = 3;
    private static final int BATCH_SIZE = 10;
    private static final String COMSERVER_URL = "https://app.safecropgh.org/clmrs/safecrop_com.php";
    private static final String SCHOOLSERVER_URL = "https://app.safecropgh.org/clmrs/safecrop_school.php";
    private static final String HHSERVER_URL = "https://app.safecropgh.org/clmrs/safecrop_hh.php";
    private static final String OBSSERVER_URL = "https://app.safecropgh.org/clmrs/safecrop_obs.php";
    private static final String CHILDSERVER_URL = "https://app.safecropgh.org/clmrs/safecrop_child.php";
    private static final String HRDDGRASERVER_URL = "https://app.safecropgh.org/hrdd/safecrop_gra.php";
    private static final String HRDDCRASERVER_URL = "https://app.safecropgh.org/hrdd/safecrop_cra.php";
    private static final String HRDDLRASERVER_URL = "https://app.safecropgh.org/hrdd/safecrop_cflra.php";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_comdev_cloud, container, false);

        ImageView closeCloudBackupBtn = view.findViewById(R.id.comDevCloudCloseBackupBtn);
        closeCloudBackupBtn.setOnClickListener(v -> dismiss());

        comdbHelper = new ComDbHelper(getActivity());
        schdbHelper = new SchoolDbHelper(getActivity());
        hhdbHelper = new HhDbHelper(getActivity());
        obsdbHelper = new ObsDbHelper(getActivity());
        chdbHelper = new ChildSurveyDBHelper(getActivity());
        graDbHelper = new GraDbHelper(getActivity());
        craDbHelper = new CraDbHelper(getActivity());
        lraDbHelper = new LraDbHelper(getActivity());

        TextView cdbsCloudBackupComTv = view.findViewById(R.id.cdbsCloudBackupComTv);
        cdbsCloudBackupComTv.setOnClickListener(v -> sendComDataToServer());

        TextView cdbsCloudBackupSchoolTv = view.findViewById(R.id.cdbsCloudBackupSchoolTv);
        cdbsCloudBackupSchoolTv.setOnClickListener(v -> sendSchDataToServer());

        TextView cdbsCloudBackupHouseholdTv = view.findViewById(R.id.cdbsCloudBackupHouseholdTv);
        cdbsCloudBackupHouseholdTv.setOnClickListener(v -> sendHhDataToServer());

        TextView cdbsCloudBackupObservationTv = view.findViewById(R.id.cdbsCloudBackupObservationTv);
        cdbsCloudBackupObservationTv.setOnClickListener(v -> sendObsDataToServer());

        TextView cdbsCloudBackupChTv = view.findViewById(R.id.cdbsCloudBackupChTv);
        cdbsCloudBackupChTv.setOnClickListener(v -> sendChDataToServer());

        TextView hrddbsCloudBackupGRATv = view.findViewById(R.id.hrddbsCloudBackupGRATv);
        hrddbsCloudBackupGRATv.setOnClickListener(v -> sendHrddGraDataToServer());

        TextView hrddbsCloudBackupCRATv = view.findViewById(R.id.hrddbsCloudBackupCRATv);
        hrddbsCloudBackupCRATv.setOnClickListener(v -> sendHrddCraDataToServer());

        TextView hrddbsCloudBackupCFLATv = view.findViewById(R.id.hrddbsCloudBackupCFLATv);
        hrddbsCloudBackupCFLATv.setOnClickListener(v -> sendHrddCflaDataToServer());

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Syncing data...");
        progressDialog.setCancelable(false);

        return view;
    }

    public void sendComDataToServer() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        showProgress();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            boolean syncSuccess = true;

            try (SQLiteDatabase db = comdbHelper.getReadableDatabase(); Cursor cursor = db.rawQuery("SELECT * FROM ComSurveyTbl", null)) {
                if (cursor.getCount() == 0) {
                    showToast("No data to sync");
                    return;
                }

                OkHttpClient client = new OkHttpClient();
                JSONArray batchArray = new JSONArray();
                int recordCount = 0;
                int totalBatches = (int) Math.ceil((double) cursor.getCount() / BATCH_SIZE);
                int currentBatch = 1;

                while (cursor.moveToNext()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("commquestion1", cursor.getString(cursor.getColumnIndexOrThrow("commquestion1")));
                    jsonObject.put("commquestion2", cursor.getString(cursor.getColumnIndexOrThrow("commquestion2")));
                    jsonObject.put("commquestion3", cursor.getString(cursor.getColumnIndexOrThrow("commquestion3")));
                    jsonObject.put("commquestion4", cursor.getString(cursor.getColumnIndexOrThrow("commquestion4")));
                    jsonObject.put("commquestion5", cursor.getString(cursor.getColumnIndexOrThrow("commquestion5")));
                    jsonObject.put("commquestion6", cursor.getString(cursor.getColumnIndexOrThrow("commquestion6")));
                    jsonObject.put("commquestion7", cursor.getString(cursor.getColumnIndexOrThrow("commquestion7")));
                    jsonObject.put("commquestion8", cursor.getString(cursor.getColumnIndexOrThrow("commquestion8")));
                    jsonObject.put("commquestion9", cursor.getString(cursor.getColumnIndexOrThrow("commquestion9")));
                    jsonObject.put("commquestion10", cursor.getString(cursor.getColumnIndexOrThrow("commquestion10")));
                    jsonObject.put("commquestion11", cursor.getString(cursor.getColumnIndexOrThrow("commquestion11")));
                    jsonObject.put("commquestion12", cursor.getString(cursor.getColumnIndexOrThrow("commquestion12")));
                    jsonObject.put("commquestion13", cursor.getString(cursor.getColumnIndexOrThrow("commquestion13")));
                    jsonObject.put("commquestion14", cursor.getString(cursor.getColumnIndexOrThrow("commquestion14")));
                    jsonObject.put("commquestion15", cursor.getString(cursor.getColumnIndexOrThrow("commquestion15")));
                    jsonObject.put("commquestion16", cursor.getString(cursor.getColumnIndexOrThrow("commquestion16")));
                    jsonObject.put("commquestion17", cursor.getString(cursor.getColumnIndexOrThrow("commquestion17")));
                    jsonObject.put("commquestion18", cursor.getString(cursor.getColumnIndexOrThrow("commquestion18")));
                    jsonObject.put("commquestion19", cursor.getString(cursor.getColumnIndexOrThrow("commquestion19")));
                    jsonObject.put("commquestion20", cursor.getString(cursor.getColumnIndexOrThrow("commquestion20")));
                    jsonObject.put("commquestion21", cursor.getString(cursor.getColumnIndexOrThrow("commquestion21")));
                    jsonObject.put("commquestion22", cursor.getString(cursor.getColumnIndexOrThrow("commquestion22")));
                    jsonObject.put("commquestion23", cursor.getString(cursor.getColumnIndexOrThrow("commquestion23")));
                    jsonObject.put("commquestion24", cursor.getString(cursor.getColumnIndexOrThrow("commquestion24")));
                    jsonObject.put("commquestion25", cursor.getString(cursor.getColumnIndexOrThrow("commquestion25")));
                    jsonObject.put("commquestion26", cursor.getString(cursor.getColumnIndexOrThrow("commquestion26")));
                    jsonObject.put("commquestion27", cursor.getString(cursor.getColumnIndexOrThrow("commquestion27")));
                    jsonObject.put("commquestion28", cursor.getString(cursor.getColumnIndexOrThrow("commquestion28")));
                    jsonObject.put("commquestion29", cursor.getString(cursor.getColumnIndexOrThrow("commquestion29")));
                    jsonObject.put("commquestion30", cursor.getString(cursor.getColumnIndexOrThrow("commquestion30")));
                    jsonObject.put("commquestion31", cursor.getString(cursor.getColumnIndexOrThrow("commquestion31")));
                    jsonObject.put("commquestion32", cursor.getString(cursor.getColumnIndexOrThrow("commquestion32")));
                    jsonObject.put("commquestion33", cursor.getString(cursor.getColumnIndexOrThrow("commquestion33")));
                    jsonObject.put("commquestion34", cursor.getString(cursor.getColumnIndexOrThrow("commquestion34")));
                    jsonObject.put("commquestion35", cursor.getString(cursor.getColumnIndexOrThrow("commquestion35")));
                    jsonObject.put("commquestion36", cursor.getString(cursor.getColumnIndexOrThrow("commquestion36")));
                    jsonObject.put("commquestion37", cursor.getString(cursor.getColumnIndexOrThrow("commquestion37")));
                    jsonObject.put("commquestion38", cursor.getString(cursor.getColumnIndexOrThrow("commquestion38")));
                    jsonObject.put("commquestion39", cursor.getString(cursor.getColumnIndexOrThrow("commquestion39")));
                    jsonObject.put("commquestion40", cursor.getString(cursor.getColumnIndexOrThrow("commquestion40")));
                    jsonObject.put("commquestion41", cursor.getString(cursor.getColumnIndexOrThrow("commquestion41")));
                    jsonObject.put("commquestion42", cursor.getString(cursor.getColumnIndexOrThrow("commquestion42")));
                    jsonObject.put("commquestion43", cursor.getString(cursor.getColumnIndexOrThrow("commquestion43")));
                    jsonObject.put("commquestion44", cursor.getString(cursor.getColumnIndexOrThrow("commquestion44")));
                    jsonObject.put("commquestion45", cursor.getString(cursor.getColumnIndexOrThrow("commquestion45")));
                    jsonObject.put("commquestion46", cursor.getString(cursor.getColumnIndexOrThrow("commquestion46")));
                    jsonObject.put("commquestion47", cursor.getString(cursor.getColumnIndexOrThrow("commquestion47")));
                    jsonObject.put("commquestion48", cursor.getString(cursor.getColumnIndexOrThrow("commquestion48")));
                    jsonObject.put("commquestion49", cursor.getString(cursor.getColumnIndexOrThrow("commquestion49")));
                    jsonObject.put("commquestion50", cursor.getString(cursor.getColumnIndexOrThrow("commquestion50")));
                    jsonObject.put("commquestion51", cursor.getString(cursor.getColumnIndexOrThrow("commquestion51")));
                    jsonObject.put("commquestion52", cursor.getString(cursor.getColumnIndexOrThrow("commquestion52")));
                    jsonObject.put("commquestion53", cursor.getString(cursor.getColumnIndexOrThrow("commquestion53")));
                    jsonObject.put("commquestion54", cursor.getString(cursor.getColumnIndexOrThrow("commquestion54")));
                    jsonObject.put("commquestion56", cursor.getString(cursor.getColumnIndexOrThrow("commquestion56")));
                    jsonObject.put("commquestion57", cursor.getString(cursor.getColumnIndexOrThrow("commquestion57")));
                    jsonObject.put("commquestion58", cursor.getString(cursor.getColumnIndexOrThrow("commquestion58")));
                    jsonObject.put("commquestion59", cursor.getString(cursor.getColumnIndexOrThrow("commquestion59")));
                    jsonObject.put("commquestion60", cursor.getString(cursor.getColumnIndexOrThrow("commquestion60")));
                    jsonObject.put("commquestion61", cursor.getString(cursor.getColumnIndexOrThrow("commquestion61")));
                    jsonObject.put("commquestion62", cursor.getString(cursor.getColumnIndexOrThrow("commquestion62")));
                    jsonObject.put("commquestion63", cursor.getString(cursor.getColumnIndexOrThrow("commquestion63")));
                    jsonObject.put("commquestion64", cursor.getString(cursor.getColumnIndexOrThrow("commquestion64")));
                    jsonObject.put("commquestion65", cursor.getString(cursor.getColumnIndexOrThrow("commquestion65")));
                    jsonObject.put("commquestion66", cursor.getString(cursor.getColumnIndexOrThrow("commquestion66")));
                    jsonObject.put("commquestion67", cursor.getString(cursor.getColumnIndexOrThrow("commquestion67")));
                    jsonObject.put("com_location", cursor.getString(cursor.getColumnIndexOrThrow("com_location")));
                    jsonObject.put("user_fname", cursor.getString(cursor.getColumnIndexOrThrow("user_fname")));
                    jsonObject.put("user_lname", cursor.getString(cursor.getColumnIndexOrThrow("user_lname")));
                    jsonObject.put("user_email", cursor.getString(cursor.getColumnIndexOrThrow("user_email")));
                    jsonObject.put("on_create", cursor.getString(cursor.getColumnIndexOrThrow("on_create")));
                    jsonObject.put("on_update", cursor.getString(cursor.getColumnIndexOrThrow("on_update")));

                    batchArray.put(jsonObject);
                    recordCount++;

                    if (recordCount % BATCH_SIZE == 0) {
                        updateProgress(currentBatch, totalBatches);
                        if (!sendComBatch(batchArray, client)) {
                            syncSuccess = false;
                        }
                        batchArray = new JSONArray();
                        currentBatch++;
                    }
                }

                if (batchArray.length() > 0) {
                    updateProgress(currentBatch, totalBatches);
                    if (!sendComBatch(batchArray, client)) {
                        syncSuccess = false;
                    }
                }
            } catch (Exception e) {
                Log.e("Sync", "Error processing batches", e);
                syncSuccess = false;
            } finally {
                handleCompletion(syncSuccess);
                executor.shutdown();
            }
        });
    }


    private void sendSchDataToServer() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        showProgress();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            boolean syncSuccess = true;
            SQLiteDatabase db = schdbHelper.getReadableDatabase();

            try (Cursor cursor = db.rawQuery("SELECT * FROM SchoolSurveyTbl", null)) {
                if (cursor.getCount() == 0) {
                    showToast("No data to sync");
                    return;
                }

                OkHttpClient client = new OkHttpClient();
                JSONArray batchArray = new JSONArray();
                int recordCount = 0;
                int totalBatches = (int) Math.ceil((double) cursor.getCount() / BATCH_SIZE);
                int currentBatch = 1;

                while (cursor.moveToNext()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("school_name", cursor.getString(cursor.getColumnIndexOrThrow("school_name")));
                    jsonObject.put("school_district", cursor.getString(cursor.getColumnIndexOrThrow("school_district")));
                    jsonObject.put("school_community", cursor.getString(cursor.getColumnIndexOrThrow("school_community")));
                    jsonObject.put("schquestion4", cursor.getString(cursor.getColumnIndexOrThrow("schquestion4")));
                    jsonObject.put("schquestion5", cursor.getString(cursor.getColumnIndexOrThrow("schquestion5")));
                    jsonObject.put("schquestion6", cursor.getString(cursor.getColumnIndexOrThrow("schquestion6")));
                    jsonObject.put("schquestion7", cursor.getString(cursor.getColumnIndexOrThrow("schquestion7")));
                    jsonObject.put("schquestion8", cursor.getString(cursor.getColumnIndexOrThrow("schquestion8")));
                    jsonObject.put("schquestion9", cursor.getString(cursor.getColumnIndexOrThrow("schquestion9")));
                    jsonObject.put("schquestion10", cursor.getString(cursor.getColumnIndexOrThrow("schquestion10")));
                    jsonObject.put("schquestion11", cursor.getString(cursor.getColumnIndexOrThrow("schquestion11")));
                    jsonObject.put("schquestion12", cursor.getString(cursor.getColumnIndexOrThrow("schquestion12")));
                    jsonObject.put("schquestion13", cursor.getString(cursor.getColumnIndexOrThrow("schquestion13")));
                    jsonObject.put("schquestion14", cursor.getString(cursor.getColumnIndexOrThrow("schquestion14")));
                    jsonObject.put("schquestion15", cursor.getString(cursor.getColumnIndexOrThrow("schquestion15")));
                    jsonObject.put("schquestion16", cursor.getString(cursor.getColumnIndexOrThrow("schquestion16")));
                    jsonObject.put("schquestion17", cursor.getString(cursor.getColumnIndexOrThrow("schquestion17")));
                    jsonObject.put("schquestion18", cursor.getString(cursor.getColumnIndexOrThrow("schquestion18")));
                    jsonObject.put("schquestion19", cursor.getString(cursor.getColumnIndexOrThrow("schquestion19")));
                    jsonObject.put("schquestion20", cursor.getString(cursor.getColumnIndexOrThrow("schquestion20")));
                    jsonObject.put("schquestion21", cursor.getString(cursor.getColumnIndexOrThrow("schquestion21")));
                    jsonObject.put("schquestion22", cursor.getString(cursor.getColumnIndexOrThrow("schquestion22")));
                    jsonObject.put("schquestion23", cursor.getString(cursor.getColumnIndexOrThrow("schquestion23")));
                    jsonObject.put("schquestion24", cursor.getString(cursor.getColumnIndexOrThrow("schquestion24")));
                    jsonObject.put("schquestion25", cursor.getString(cursor.getColumnIndexOrThrow("schquestion25")));
                    jsonObject.put("schquestion26", cursor.getString(cursor.getColumnIndexOrThrow("schquestion26")));
                    jsonObject.put("schquestion27", cursor.getString(cursor.getColumnIndexOrThrow("schquestion27")));
                    jsonObject.put("schquestion28", cursor.getString(cursor.getColumnIndexOrThrow("schquestion28")));
                    jsonObject.put("schquestion29", cursor.getString(cursor.getColumnIndexOrThrow("schquestion29")));
                    jsonObject.put("schquestion30", cursor.getString(cursor.getColumnIndexOrThrow("schquestion30")));
                    jsonObject.put("schquestion31", cursor.getString(cursor.getColumnIndexOrThrow("schquestion31")));
                    jsonObject.put("schquestion32", cursor.getString(cursor.getColumnIndexOrThrow("schquestion32")));
                    jsonObject.put("schquestion33", cursor.getString(cursor.getColumnIndexOrThrow("schquestion33")));
                    jsonObject.put("schquestion34", cursor.getString(cursor.getColumnIndexOrThrow("schquestion34")));
                    jsonObject.put("school_location", cursor.getString(cursor.getColumnIndexOrThrow("school_location")));
                    jsonObject.put("user_fname", cursor.getString(cursor.getColumnIndexOrThrow("user_fname")));
                    jsonObject.put("user_lname", cursor.getString(cursor.getColumnIndexOrThrow("user_lname")));
                    jsonObject.put("user_email", cursor.getString(cursor.getColumnIndexOrThrow("user_email")));
                    jsonObject.put("on_create", cursor.getString(cursor.getColumnIndexOrThrow("on_create")));
                    jsonObject.put("on_update", cursor.getString(cursor.getColumnIndexOrThrow("on_update")));

                    batchArray.put(jsonObject);
                    recordCount++;

                    if (recordCount % BATCH_SIZE == 0) {
                        updateProgress(currentBatch, totalBatches);
                        if (!sendSchBatch(batchArray, client)) {
                            syncSuccess = false;
                        }
                        batchArray = new JSONArray();
                        currentBatch++;
                    }
                }

                if (batchArray.length() > 0) {
                    updateProgress(currentBatch, totalBatches);
                    if (!sendSchBatch(batchArray, client)) {
                        syncSuccess = false;
                    }
                }
            } catch (Exception e) {
                Log.e("Sync", "Error processing batches", e);
                syncSuccess = false;
            } finally {
                db.close();
                handleCompletion(syncSuccess);
                executor.shutdown();
            }
        });
    }


    private void sendHhDataToServer() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        showProgress();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            boolean syncSuccess = true;
            SQLiteDatabase db = hhdbHelper.getReadableDatabase();

            try (Cursor cursor = db.rawQuery("SELECT * FROM HouseholdSurveyTbl", null)) {
                if (cursor.getCount() == 0) {
                    showToast("No data to sync");
                    return;
                }

                OkHttpClient client = new OkHttpClient();
                JSONArray batchArray = new JSONArray();
                int recordCount = 0;
                int totalBatches = (int) Math.ceil((double) cursor.getCount() / BATCH_SIZE);
                int currentBatch = 1;

                while (cursor.moveToNext()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("hh_name", cursor.getString(cursor.getColumnIndexOrThrow("hh_name")));
                    jsonObject.put("hh_district", cursor.getString(cursor.getColumnIndexOrThrow("hh_district")));
                    jsonObject.put("hh_community", cursor.getString(cursor.getColumnIndexOrThrow("hh_community")));
                    jsonObject.put("hhquestion4", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion4")));
                    jsonObject.put("hhquestion5", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion5")));
                    jsonObject.put("hhquestion6", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion6")));
                    jsonObject.put("hhquestion7", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion7")));
                    jsonObject.put("hhquestion8", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion8")));
                    jsonObject.put("hhquestion9", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion9")));
                    jsonObject.put("hhquestion10", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion10")));
                    jsonObject.put("hhquestion11", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion11")));
                    jsonObject.put("hhquestion12", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion12")));
                    jsonObject.put("hhquestion13", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion13")));
                    jsonObject.put("hhquestion14", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion14")));
                    jsonObject.put("hhquestion15", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion15")));
                    jsonObject.put("hhquestion16", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion16")));
                    jsonObject.put("hhquestion17", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion17")));
                    jsonObject.put("hhquestion18", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion18")));
                    jsonObject.put("hhquestion19", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion19")));
                    jsonObject.put("hhquestion20", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion20")));
                    jsonObject.put("hhquestion21", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion21")));
                    jsonObject.put("hhquestion22", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion22")));
                    jsonObject.put("hhquestion23", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion23")));
                    jsonObject.put("hhquestion24", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion24")));
                    jsonObject.put("hhquestion25", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion25")));
                    jsonObject.put("hhquestion26", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion26")));
                    jsonObject.put("hhquestion27", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion27")));
                    jsonObject.put("hhquestion28", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion28")));
                    jsonObject.put("hhquestion29", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion29")));
                    jsonObject.put("hhquestion30", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion30")));
                    jsonObject.put("hhquestion31", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion31")));
                    jsonObject.put("hhquestion32", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion32")));
                    jsonObject.put("hhquestion36", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion36")));
                    jsonObject.put("hhquestion37", cursor.getString(cursor.getColumnIndexOrThrow("hhquestion37")));
                    jsonObject.put("hh_location", cursor.getString(cursor.getColumnIndexOrThrow("hh_location")));
                    jsonObject.put("user_fname", cursor.getString(cursor.getColumnIndexOrThrow("user_fname")));
                    jsonObject.put("user_lname", cursor.getString(cursor.getColumnIndexOrThrow("user_lname")));
                    jsonObject.put("user_email", cursor.getString(cursor.getColumnIndexOrThrow("user_email")));
                    jsonObject.put("on_create", cursor.getString(cursor.getColumnIndexOrThrow("on_create")));
                    jsonObject.put("on_update", cursor.getString(cursor.getColumnIndexOrThrow("on_update")));

                    batchArray.put(jsonObject);
                    recordCount++;

                    if (recordCount % BATCH_SIZE == 0) {
                        updateProgress(currentBatch, totalBatches);
                        if (!sendHhBatch(batchArray, client)) {
                            syncSuccess = false;
                        }
                        batchArray = new JSONArray();
                        currentBatch++;
                    }
                }

                if (batchArray.length() > 0) {
                    updateProgress(currentBatch, totalBatches);
                    if (!sendHhBatch(batchArray, client)) {
                        syncSuccess = false;
                    }
                }
            } catch (Exception e) {
                Log.e("Sync", "Error processing batches", e);
                syncSuccess = false;
            } finally {
                db.close();
                handleCompletion(syncSuccess);
                executor.shutdown();
            }
        });
    }


    private void sendObsDataToServer() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        showProgress();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            boolean syncSuccess = true;
            SQLiteDatabase db = obsdbHelper.getReadableDatabase();

            try (Cursor cursor = db.rawQuery("SELECT * FROM ObservationSurveyTbl", null)) {
                if (cursor.getCount() == 0) {
                    showToast("No data to sync");
                    return;
                }

                OkHttpClient client = new OkHttpClient();
                JSONArray batchArray = new JSONArray();
                int recordCount = 0;
                int totalBatches = (int) Math.ceil((double) cursor.getCount() / BATCH_SIZE);
                int currentBatch = 1;

                while (cursor.moveToNext()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("obs_name", cursor.getString(cursor.getColumnIndexOrThrow("obs_name")));
                    jsonObject.put("obs_district", cursor.getString(cursor.getColumnIndexOrThrow("obs_district")));
                    jsonObject.put("obs_community", cursor.getString(cursor.getColumnIndexOrThrow("obs_community")));
                    jsonObject.put("obsquestion6", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion6")));
                    jsonObject.put("obsquestion7", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion7")));
                    jsonObject.put("obsquestion8", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion8")));
                    jsonObject.put("obsquestion9", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion9")));
                    jsonObject.put("obsquestion10", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion10")));
                    jsonObject.put("obsquestion11", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion11")));
                    jsonObject.put("obsquestion12", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion12")));
                    jsonObject.put("obsquestion13", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion13")));
                    jsonObject.put("obsquestion14", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion14")));
                    jsonObject.put("obsquestion15", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion15")));
                    jsonObject.put("obsquestion16", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion16")));
                    jsonObject.put("obsquestion17", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion17")));
                    jsonObject.put("obsquestion18", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion18")));
                    jsonObject.put("obsquestion19", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion19")));
                    jsonObject.put("obsquestion20", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion20")));
                    jsonObject.put("obsquestion21", cursor.getString(cursor.getColumnIndexOrThrow("obsquestion21")));
                    jsonObject.put("obs_location", cursor.getString(cursor.getColumnIndexOrThrow("obs_location")));
                    jsonObject.put("user_fname", cursor.getString(cursor.getColumnIndexOrThrow("user_fname")));
                    jsonObject.put("user_lname", cursor.getString(cursor.getColumnIndexOrThrow("user_lname")));
                    jsonObject.put("user_email", cursor.getString(cursor.getColumnIndexOrThrow("user_email")));
                    jsonObject.put("on_create", cursor.getString(cursor.getColumnIndexOrThrow("on_create")));
                    jsonObject.put("on_update", cursor.getString(cursor.getColumnIndexOrThrow("on_update")));

                    batchArray.put(jsonObject);
                    recordCount++;

                    if (recordCount % BATCH_SIZE == 0) {
                        updateProgress(currentBatch, totalBatches);
                        if (!sendObsBatch(batchArray, client)) {
                            syncSuccess = false;
                        }
                        batchArray = new JSONArray();
                        currentBatch++;
                    }
                }

                if (batchArray.length() > 0) {
                    updateProgress(currentBatch, totalBatches);
                    if (!sendObsBatch(batchArray, client)) {
                        syncSuccess = false;
                    }
                }
            } catch (Exception e) {
                Log.e("Sync", "Error processing batches", e);
                syncSuccess = false;
            } finally {
                db.close();
                handleCompletion(syncSuccess);
                executor.shutdown();
            }
        });
    }


    private void sendChDataToServer() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        showProgress();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            boolean syncSuccess = true;
            SQLiteDatabase db = chdbHelper.getReadableDatabase();

            try (Cursor cursor = db.rawQuery("SELECT * FROM ChildSurveyTbl", null)) {
                if (cursor.getCount() == 0) {
                    showToast("No data to sync");
                    return;
                }

                OkHttpClient client = new OkHttpClient();
                JSONArray batchArray = new JSONArray();
                int recordCount = 0;
                int totalBatches = (int) Math.ceil((double) cursor.getCount() / BATCH_SIZE);
                int currentBatch = 1;

                while (cursor.moveToNext()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("farmer_id", cursor.getString(cursor.getColumnIndexOrThrow("farmer_id")));
                    jsonObject.put("farmer_district", cursor.getString(cursor.getColumnIndexOrThrow("farmer_district")));
                    jsonObject.put("farmer_village", cursor.getString(cursor.getColumnIndexOrThrow("farmer_village")));
                    jsonObject.put("childquestion4", cursor.getString(cursor.getColumnIndexOrThrow("childquestion4")));

                    jsonObject.put("child1question1", cursor.getString(cursor.getColumnIndexOrThrow("child1question1")));
                    jsonObject.put("child1question2", cursor.getString(cursor.getColumnIndexOrThrow("child1question2")));
                    jsonObject.put("child1question3", cursor.getString(cursor.getColumnIndexOrThrow("child1question3")));
                    jsonObject.put("child1question4", cursor.getString(cursor.getColumnIndexOrThrow("child1question4")));
                    jsonObject.put("child1question5", cursor.getString(cursor.getColumnIndexOrThrow("child1question5")));
                    jsonObject.put("child1question6", cursor.getString(cursor.getColumnIndexOrThrow("child1question6")));
                    jsonObject.put("child1question7", cursor.getString(cursor.getColumnIndexOrThrow("child1question7")));
                    jsonObject.put("child1question8", cursor.getString(cursor.getColumnIndexOrThrow("child1question8")));
                    jsonObject.put("child1question9", cursor.getString(cursor.getColumnIndexOrThrow("child1question9")));
                    jsonObject.put("child1question10", cursor.getString(cursor.getColumnIndexOrThrow("child1question10")));
                    jsonObject.put("child1question11", cursor.getString(cursor.getColumnIndexOrThrow("child1question11")));
                    jsonObject.put("child1question12", cursor.getString(cursor.getColumnIndexOrThrow("child1question12")));
                    jsonObject.put("child1question13", cursor.getString(cursor.getColumnIndexOrThrow("child1question13")));
                    jsonObject.put("child1question14", cursor.getString(cursor.getColumnIndexOrThrow("child1question14")));
                    jsonObject.put("child1question15", cursor.getString(cursor.getColumnIndexOrThrow("child1question15")));
                    jsonObject.put("child1question16", cursor.getString(cursor.getColumnIndexOrThrow("child1question16")));
                    jsonObject.put("child1question17", cursor.getString(cursor.getColumnIndexOrThrow("child1question17")));
                    jsonObject.put("child1question18", cursor.getString(cursor.getColumnIndexOrThrow("child1question18")));
                    jsonObject.put("child1question19", cursor.getString(cursor.getColumnIndexOrThrow("child1question19")));

                    jsonObject.put("child2question1", cursor.getString(cursor.getColumnIndexOrThrow("child2question1")));
                    jsonObject.put("child2question2", cursor.getString(cursor.getColumnIndexOrThrow("child2question2")));
                    jsonObject.put("child2question3", cursor.getString(cursor.getColumnIndexOrThrow("child2question3")));
                    jsonObject.put("child2question4", cursor.getString(cursor.getColumnIndexOrThrow("child2question4")));
                    jsonObject.put("child2question5", cursor.getString(cursor.getColumnIndexOrThrow("child2question5")));
                    jsonObject.put("child2question6", cursor.getString(cursor.getColumnIndexOrThrow("child2question6")));
                    jsonObject.put("child2question7", cursor.getString(cursor.getColumnIndexOrThrow("child2question7")));
                    jsonObject.put("child2question8", cursor.getString(cursor.getColumnIndexOrThrow("child2question8")));
                    jsonObject.put("child2question9", cursor.getString(cursor.getColumnIndexOrThrow("child2question9")));
                    jsonObject.put("child2question10", cursor.getString(cursor.getColumnIndexOrThrow("child2question10")));
                    jsonObject.put("child2question11", cursor.getString(cursor.getColumnIndexOrThrow("child2question11")));
                    jsonObject.put("child2question12", cursor.getString(cursor.getColumnIndexOrThrow("child2question12")));
                    jsonObject.put("child2question13", cursor.getString(cursor.getColumnIndexOrThrow("child2question13")));
                    jsonObject.put("child2question14", cursor.getString(cursor.getColumnIndexOrThrow("child2question14")));
                    jsonObject.put("child2question15", cursor.getString(cursor.getColumnIndexOrThrow("child2question15")));
                    jsonObject.put("child2question16", cursor.getString(cursor.getColumnIndexOrThrow("child2question16")));
                    jsonObject.put("child2question17", cursor.getString(cursor.getColumnIndexOrThrow("child2question17")));
                    jsonObject.put("child2question18", cursor.getString(cursor.getColumnIndexOrThrow("child2question18")));
                    jsonObject.put("child2question19", cursor.getString(cursor.getColumnIndexOrThrow("child2question19")));

                    jsonObject.put("child3question1", cursor.getString(cursor.getColumnIndexOrThrow("child3question1")));
                    jsonObject.put("child3question2", cursor.getString(cursor.getColumnIndexOrThrow("child3question2")));
                    jsonObject.put("child3question3", cursor.getString(cursor.getColumnIndexOrThrow("child3question3")));
                    jsonObject.put("child3question4", cursor.getString(cursor.getColumnIndexOrThrow("child3question4")));
                    jsonObject.put("child3question5", cursor.getString(cursor.getColumnIndexOrThrow("child3question5")));
                    jsonObject.put("child3question6", cursor.getString(cursor.getColumnIndexOrThrow("child3question6")));
                    jsonObject.put("child3question7", cursor.getString(cursor.getColumnIndexOrThrow("child3question7")));
                    jsonObject.put("child3question8", cursor.getString(cursor.getColumnIndexOrThrow("child3question8")));
                    jsonObject.put("child3question9", cursor.getString(cursor.getColumnIndexOrThrow("child3question9")));
                    jsonObject.put("child3question10", cursor.getString(cursor.getColumnIndexOrThrow("child3question10")));
                    jsonObject.put("child3question11", cursor.getString(cursor.getColumnIndexOrThrow("child3question11")));
                    jsonObject.put("child3question12", cursor.getString(cursor.getColumnIndexOrThrow("child3question12")));
                    jsonObject.put("child3question13", cursor.getString(cursor.getColumnIndexOrThrow("child3question13")));
                    jsonObject.put("child3question14", cursor.getString(cursor.getColumnIndexOrThrow("child3question14")));
                    jsonObject.put("child3question15", cursor.getString(cursor.getColumnIndexOrThrow("child3question15")));
                    jsonObject.put("child3question16", cursor.getString(cursor.getColumnIndexOrThrow("child3question16")));
                    jsonObject.put("child3question17", cursor.getString(cursor.getColumnIndexOrThrow("child3question17")));
                    jsonObject.put("child3question18", cursor.getString(cursor.getColumnIndexOrThrow("child3question18")));
                    jsonObject.put("child3question19", cursor.getString(cursor.getColumnIndexOrThrow("child3question19")));

                    jsonObject.put("child4question1", cursor.getString(cursor.getColumnIndexOrThrow("child4question1")));
                    jsonObject.put("child4question2", cursor.getString(cursor.getColumnIndexOrThrow("child4question2")));
                    jsonObject.put("child4question3", cursor.getString(cursor.getColumnIndexOrThrow("child4question3")));
                    jsonObject.put("child4question4", cursor.getString(cursor.getColumnIndexOrThrow("child4question4")));
                    jsonObject.put("child4question5", cursor.getString(cursor.getColumnIndexOrThrow("child4question5")));
                    jsonObject.put("child4question6", cursor.getString(cursor.getColumnIndexOrThrow("child4question6")));
                    jsonObject.put("child4question7", cursor.getString(cursor.getColumnIndexOrThrow("child4question7")));
                    jsonObject.put("child4question8", cursor.getString(cursor.getColumnIndexOrThrow("child4question8")));
                    jsonObject.put("child4question9", cursor.getString(cursor.getColumnIndexOrThrow("child4question9")));
                    jsonObject.put("child4question10", cursor.getString(cursor.getColumnIndexOrThrow("child4question10")));
                    jsonObject.put("child4question11", cursor.getString(cursor.getColumnIndexOrThrow("child4question11")));
                    jsonObject.put("child4question12", cursor.getString(cursor.getColumnIndexOrThrow("child4question12")));
                    jsonObject.put("child4question13", cursor.getString(cursor.getColumnIndexOrThrow("child4question13")));
                    jsonObject.put("child4question14", cursor.getString(cursor.getColumnIndexOrThrow("child4question14")));
                    jsonObject.put("child4question15", cursor.getString(cursor.getColumnIndexOrThrow("child4question15")));
                    jsonObject.put("child4question16", cursor.getString(cursor.getColumnIndexOrThrow("child4question16")));
                    jsonObject.put("child4question17", cursor.getString(cursor.getColumnIndexOrThrow("child4question17")));
                    jsonObject.put("child4question18", cursor.getString(cursor.getColumnIndexOrThrow("child4question18")));
                    jsonObject.put("child4question19", cursor.getString(cursor.getColumnIndexOrThrow("child4question19")));

                    jsonObject.put("child5question1", cursor.getString(cursor.getColumnIndexOrThrow("child5question1")));
                    jsonObject.put("child5question2", cursor.getString(cursor.getColumnIndexOrThrow("child5question2")));
                    jsonObject.put("child5question3", cursor.getString(cursor.getColumnIndexOrThrow("child5question3")));
                    jsonObject.put("child5question4", cursor.getString(cursor.getColumnIndexOrThrow("child5question4")));
                    jsonObject.put("child5question5", cursor.getString(cursor.getColumnIndexOrThrow("child5question5")));
                    jsonObject.put("child5question6", cursor.getString(cursor.getColumnIndexOrThrow("child5question6")));
                    jsonObject.put("child5question7", cursor.getString(cursor.getColumnIndexOrThrow("child5question7")));
                    jsonObject.put("child5question8", cursor.getString(cursor.getColumnIndexOrThrow("child5question8")));
                    jsonObject.put("child5question9", cursor.getString(cursor.getColumnIndexOrThrow("child5question9")));
                    jsonObject.put("child5question10", cursor.getString(cursor.getColumnIndexOrThrow("child5question10")));
                    jsonObject.put("child5question11", cursor.getString(cursor.getColumnIndexOrThrow("child5question11")));
                    jsonObject.put("child5question12", cursor.getString(cursor.getColumnIndexOrThrow("child5question12")));
                    jsonObject.put("child5question13", cursor.getString(cursor.getColumnIndexOrThrow("child5question13")));
                    jsonObject.put("child5question14", cursor.getString(cursor.getColumnIndexOrThrow("child5question14")));
                    jsonObject.put("child5question15", cursor.getString(cursor.getColumnIndexOrThrow("child5question15")));
                    jsonObject.put("child5question16", cursor.getString(cursor.getColumnIndexOrThrow("child5question16")));
                    jsonObject.put("child5question17", cursor.getString(cursor.getColumnIndexOrThrow("child5question17")));
                    jsonObject.put("child5question18", cursor.getString(cursor.getColumnIndexOrThrow("child5question18")));
                    jsonObject.put("child5question19", cursor.getString(cursor.getColumnIndexOrThrow("child5question19")));

                    jsonObject.put("child6question1", cursor.getString(cursor.getColumnIndexOrThrow("child6question1")));
                    jsonObject.put("child6question2", cursor.getString(cursor.getColumnIndexOrThrow("child6question2")));
                    jsonObject.put("child6question3", cursor.getString(cursor.getColumnIndexOrThrow("child6question3")));
                    jsonObject.put("child6question4", cursor.getString(cursor.getColumnIndexOrThrow("child6question4")));
                    jsonObject.put("child6question5", cursor.getString(cursor.getColumnIndexOrThrow("child6question5")));
                    jsonObject.put("child6question6", cursor.getString(cursor.getColumnIndexOrThrow("child6question6")));
                    jsonObject.put("child6question7", cursor.getString(cursor.getColumnIndexOrThrow("child6question7")));
                    jsonObject.put("child6question8", cursor.getString(cursor.getColumnIndexOrThrow("child6question8")));
                    jsonObject.put("child6question9", cursor.getString(cursor.getColumnIndexOrThrow("child6question9")));
                    jsonObject.put("child6question10", cursor.getString(cursor.getColumnIndexOrThrow("child6question10")));
                    jsonObject.put("child6question11", cursor.getString(cursor.getColumnIndexOrThrow("child6question11")));
                    jsonObject.put("child6question12", cursor.getString(cursor.getColumnIndexOrThrow("child6question12")));
                    jsonObject.put("child6question13", cursor.getString(cursor.getColumnIndexOrThrow("child6question13")));
                    jsonObject.put("child6question14", cursor.getString(cursor.getColumnIndexOrThrow("child6question14")));
                    jsonObject.put("child6question15", cursor.getString(cursor.getColumnIndexOrThrow("child6question15")));
                    jsonObject.put("child6question16", cursor.getString(cursor.getColumnIndexOrThrow("child6question16")));
                    jsonObject.put("child6question17", cursor.getString(cursor.getColumnIndexOrThrow("child6question17")));
                    jsonObject.put("child6question18", cursor.getString(cursor.getColumnIndexOrThrow("child6question18")));
                    jsonObject.put("child6question19", cursor.getString(cursor.getColumnIndexOrThrow("child6question19")));

                    jsonObject.put("child7question1", cursor.getString(cursor.getColumnIndexOrThrow("child7question1")));
                    jsonObject.put("child7question2", cursor.getString(cursor.getColumnIndexOrThrow("child7question2")));
                    jsonObject.put("child7question3", cursor.getString(cursor.getColumnIndexOrThrow("child7question3")));
                    jsonObject.put("child7question4", cursor.getString(cursor.getColumnIndexOrThrow("child7question4")));
                    jsonObject.put("child7question5", cursor.getString(cursor.getColumnIndexOrThrow("child7question5")));
                    jsonObject.put("child7question6", cursor.getString(cursor.getColumnIndexOrThrow("child7question6")));
                    jsonObject.put("child7question7", cursor.getString(cursor.getColumnIndexOrThrow("child7question7")));
                    jsonObject.put("child7question8", cursor.getString(cursor.getColumnIndexOrThrow("child7question8")));
                    jsonObject.put("child7question9", cursor.getString(cursor.getColumnIndexOrThrow("child7question9")));
                    jsonObject.put("child7question10", cursor.getString(cursor.getColumnIndexOrThrow("child7question10")));
                    jsonObject.put("child7question11", cursor.getString(cursor.getColumnIndexOrThrow("child7question11")));
                    jsonObject.put("child7question12", cursor.getString(cursor.getColumnIndexOrThrow("child7question12")));
                    jsonObject.put("child7question13", cursor.getString(cursor.getColumnIndexOrThrow("child7question13")));
                    jsonObject.put("child7question14", cursor.getString(cursor.getColumnIndexOrThrow("child7question14")));
                    jsonObject.put("child7question15", cursor.getString(cursor.getColumnIndexOrThrow("child7question15")));
                    jsonObject.put("child7question16", cursor.getString(cursor.getColumnIndexOrThrow("child7question16")));
                    jsonObject.put("child7question17", cursor.getString(cursor.getColumnIndexOrThrow("child7question17")));
                    jsonObject.put("child7question18", cursor.getString(cursor.getColumnIndexOrThrow("child7question18")));
                    jsonObject.put("child7question19", cursor.getString(cursor.getColumnIndexOrThrow("child7question19")));

                    jsonObject.put("child8question1", cursor.getString(cursor.getColumnIndexOrThrow("child8question1")));
                    jsonObject.put("child8question2", cursor.getString(cursor.getColumnIndexOrThrow("child8question2")));
                    jsonObject.put("child8question3", cursor.getString(cursor.getColumnIndexOrThrow("child8question3")));
                    jsonObject.put("child8question4", cursor.getString(cursor.getColumnIndexOrThrow("child8question4")));
                    jsonObject.put("child8question5", cursor.getString(cursor.getColumnIndexOrThrow("child8question5")));
                    jsonObject.put("child8question6", cursor.getString(cursor.getColumnIndexOrThrow("child8question6")));
                    jsonObject.put("child8question7", cursor.getString(cursor.getColumnIndexOrThrow("child8question7")));
                    jsonObject.put("child8question8", cursor.getString(cursor.getColumnIndexOrThrow("child8question8")));
                    jsonObject.put("child8question9", cursor.getString(cursor.getColumnIndexOrThrow("child8question9")));
                    jsonObject.put("child8question10", cursor.getString(cursor.getColumnIndexOrThrow("child8question10")));
                    jsonObject.put("child8question11", cursor.getString(cursor.getColumnIndexOrThrow("child8question11")));
                    jsonObject.put("child8question12", cursor.getString(cursor.getColumnIndexOrThrow("child8question12")));
                    jsonObject.put("child8question13", cursor.getString(cursor.getColumnIndexOrThrow("child8question13")));
                    jsonObject.put("child8question14", cursor.getString(cursor.getColumnIndexOrThrow("child8question14")));
                    jsonObject.put("child8question15", cursor.getString(cursor.getColumnIndexOrThrow("child8question15")));
                    jsonObject.put("child8question16", cursor.getString(cursor.getColumnIndexOrThrow("child8question16")));
                    jsonObject.put("child8question17", cursor.getString(cursor.getColumnIndexOrThrow("child8question17")));
                    jsonObject.put("child8question18", cursor.getString(cursor.getColumnIndexOrThrow("child8question18")));
                    jsonObject.put("child8question19", cursor.getString(cursor.getColumnIndexOrThrow("child8question19")));

                    jsonObject.put("child9question1", cursor.getString(cursor.getColumnIndexOrThrow("child9question1")));
                    jsonObject.put("child9question2", cursor.getString(cursor.getColumnIndexOrThrow("child9question2")));
                    jsonObject.put("child9question3", cursor.getString(cursor.getColumnIndexOrThrow("child9question3")));
                    jsonObject.put("child9question4", cursor.getString(cursor.getColumnIndexOrThrow("child9question4")));
                    jsonObject.put("child9question5", cursor.getString(cursor.getColumnIndexOrThrow("child9question5")));
                    jsonObject.put("child9question6", cursor.getString(cursor.getColumnIndexOrThrow("child9question6")));
                    jsonObject.put("child9question7", cursor.getString(cursor.getColumnIndexOrThrow("child9question7")));
                    jsonObject.put("child9question8", cursor.getString(cursor.getColumnIndexOrThrow("child9question8")));
                    jsonObject.put("child9question9", cursor.getString(cursor.getColumnIndexOrThrow("child9question9")));
                    jsonObject.put("child9question10", cursor.getString(cursor.getColumnIndexOrThrow("child9question10")));
                    jsonObject.put("child9question11", cursor.getString(cursor.getColumnIndexOrThrow("child9question11")));
                    jsonObject.put("child9question12", cursor.getString(cursor.getColumnIndexOrThrow("child9question12")));
                    jsonObject.put("child9question13", cursor.getString(cursor.getColumnIndexOrThrow("child9question13")));
                    jsonObject.put("child9question14", cursor.getString(cursor.getColumnIndexOrThrow("child9question14")));
                    jsonObject.put("child9question15", cursor.getString(cursor.getColumnIndexOrThrow("child9question15")));
                    jsonObject.put("child9question16", cursor.getString(cursor.getColumnIndexOrThrow("child9question16")));
                    jsonObject.put("child9question17", cursor.getString(cursor.getColumnIndexOrThrow("child9question17")));
                    jsonObject.put("child9question18", cursor.getString(cursor.getColumnIndexOrThrow("child9question18")));
                    jsonObject.put("child9question19", cursor.getString(cursor.getColumnIndexOrThrow("child9question19")));

                    jsonObject.put("child10question1", cursor.getString(cursor.getColumnIndexOrThrow("child10question1")));
                    jsonObject.put("child10question2", cursor.getString(cursor.getColumnIndexOrThrow("child10question2")));
                    jsonObject.put("child10question3", cursor.getString(cursor.getColumnIndexOrThrow("child10question3")));
                    jsonObject.put("child10question4", cursor.getString(cursor.getColumnIndexOrThrow("child10question4")));
                    jsonObject.put("child10question5", cursor.getString(cursor.getColumnIndexOrThrow("child10question5")));
                    jsonObject.put("child10question6", cursor.getString(cursor.getColumnIndexOrThrow("child10question6")));
                    jsonObject.put("child10question7", cursor.getString(cursor.getColumnIndexOrThrow("child10question7")));
                    jsonObject.put("child10question8", cursor.getString(cursor.getColumnIndexOrThrow("child10question8")));
                    jsonObject.put("child10question9", cursor.getString(cursor.getColumnIndexOrThrow("child10question9")));
                    jsonObject.put("child10question10", cursor.getString(cursor.getColumnIndexOrThrow("child10question10")));
                    jsonObject.put("child10question11", cursor.getString(cursor.getColumnIndexOrThrow("child10question11")));
                    jsonObject.put("child10question12", cursor.getString(cursor.getColumnIndexOrThrow("child10question12")));
                    jsonObject.put("child10question13", cursor.getString(cursor.getColumnIndexOrThrow("child10question13")));
                    jsonObject.put("child10question14", cursor.getString(cursor.getColumnIndexOrThrow("child10question14")));
                    jsonObject.put("child10question15", cursor.getString(cursor.getColumnIndexOrThrow("child10question15")));
                    jsonObject.put("child10question16", cursor.getString(cursor.getColumnIndexOrThrow("child10question16")));
                    jsonObject.put("child10question17", cursor.getString(cursor.getColumnIndexOrThrow("child10question17")));
                    jsonObject.put("child10question18", cursor.getString(cursor.getColumnIndexOrThrow("child10question18")));
                    jsonObject.put("child10question19", cursor.getString(cursor.getColumnIndexOrThrow("child10question19")));

                    jsonObject.put("childquestion5", cursor.getString(cursor.getColumnIndexOrThrow("childquestion5")));
                    jsonObject.put("child_location", cursor.getString(cursor.getColumnIndexOrThrow("child_location")));
                    jsonObject.put("user_fname", cursor.getString(cursor.getColumnIndexOrThrow("user_fname")));
                    jsonObject.put("user_lname", cursor.getString(cursor.getColumnIndexOrThrow("user_lname")));
                    jsonObject.put("user_email", cursor.getString(cursor.getColumnIndexOrThrow("user_email")));
                    jsonObject.put("on_create", cursor.getString(cursor.getColumnIndexOrThrow("on_create")));
                    jsonObject.put("on_update", cursor.getString(cursor.getColumnIndexOrThrow("on_update")));

                    batchArray.put(jsonObject);
                    recordCount++;

                    if (recordCount % BATCH_SIZE == 0) {
                        updateProgress(currentBatch, totalBatches);
                        if (!sendChBatch(batchArray, client)) {
                            syncSuccess = false;
                        }
                        batchArray = new JSONArray();
                        currentBatch++;
                    }
                }

                if (batchArray.length() > 0) {
                    updateProgress(currentBatch, totalBatches);
                    if (!sendChBatch(batchArray, client)) {
                        syncSuccess = false;
                    }
                }
            } catch (Exception e) {
                Log.e("Sync", "Error processing batches", e);
                syncSuccess = false;
            } finally {
                db.close();
                handleCompletion(syncSuccess);
                executor.shutdown();
            }
        });
    }


    public void sendHrddGraDataToServer() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        showProgress();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            boolean syncSuccess = true;

            try (SQLiteDatabase db = graDbHelper.getReadableDatabase(); Cursor cursor = db.rawQuery("SELECT * FROM GraSurveyTbl", null)) {
                if (cursor.getCount() == 0) {
                    showToast("No data to sync");
                    return;
                }

                OkHttpClient client = new OkHttpClient();
                JSONArray batchArray = new JSONArray();
                int recordCount = 0;
                int totalBatches = (int) Math.ceil((double) cursor.getCount() / BATCH_SIZE);
                int currentBatch = 1;

                while (cursor.moveToNext()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("graquestion1", cursor.getString(cursor.getColumnIndexOrThrow("graquestion1")));
                    jsonObject.put("graquestion2", cursor.getString(cursor.getColumnIndexOrThrow("graquestion2")));
                    jsonObject.put("graquestion3", cursor.getString(cursor.getColumnIndexOrThrow("graquestion3")));
                    jsonObject.put("graquestion4", cursor.getString(cursor.getColumnIndexOrThrow("graquestion4")));
                    jsonObject.put("graquestion5", cursor.getString(cursor.getColumnIndexOrThrow("graquestion5")));
                    jsonObject.put("graquestion6", cursor.getString(cursor.getColumnIndexOrThrow("graquestion6")));
                    jsonObject.put("graquestion7", cursor.getString(cursor.getColumnIndexOrThrow("graquestion7")));
                    jsonObject.put("graquestion8", cursor.getString(cursor.getColumnIndexOrThrow("graquestion8")));
                    jsonObject.put("gra_location", cursor.getString(cursor.getColumnIndexOrThrow("gra_location")));
                    jsonObject.put("farmer_photo", cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")));
                    jsonObject.put("signature", cursor.getString(cursor.getColumnIndexOrThrow("signature")));
                    jsonObject.put("user_fname", cursor.getString(cursor.getColumnIndexOrThrow("user_fname")));
                    jsonObject.put("user_lname", cursor.getString(cursor.getColumnIndexOrThrow("user_lname")));
                    jsonObject.put("user_email", cursor.getString(cursor.getColumnIndexOrThrow("user_email")));
                    jsonObject.put("on_create", cursor.getString(cursor.getColumnIndexOrThrow("on_create")));
                    jsonObject.put("on_update", cursor.getString(cursor.getColumnIndexOrThrow("on_update")));

                    batchArray.put(jsonObject);
                    recordCount++;

                    if (recordCount % BATCH_SIZE == 0) {
                        updateProgress(currentBatch, totalBatches);
                        if (!sendHrddGraBatch(batchArray, client)) {
                            syncSuccess = false;
                        }
                        batchArray = new JSONArray();
                        currentBatch++;
                    }
                }

                if (batchArray.length() > 0) {
                    updateProgress(currentBatch, totalBatches);
                    if (!sendHrddGraBatch(batchArray, client)) {
                        syncSuccess = false;
                    }
                }
            } catch (Exception e) {
                Log.e("Sync", "Error processing batches", e);
                syncSuccess = false;
            } finally {
                handleCompletion(syncSuccess);
                executor.shutdown();
            }
        });
    }


    public void sendHrddCraDataToServer() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        showProgress();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            boolean syncSuccess = true;

            try (SQLiteDatabase db = craDbHelper.getReadableDatabase(); Cursor cursor = db.rawQuery("SELECT * FROM CraSurveyTbl", null)) {
                if (cursor.getCount() == 0) {
                    showToast("No data to sync");
                    return;
                }

                OkHttpClient client = new OkHttpClient();
                JSONArray batchArray = new JSONArray();
                int recordCount = 0;
                int totalBatches = (int) Math.ceil((double) cursor.getCount() / BATCH_SIZE);
                int currentBatch = 1;

                while (cursor.moveToNext()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("craquestion1", cursor.getString(cursor.getColumnIndexOrThrow("craquestion1")));
                    jsonObject.put("craquestion2", cursor.getString(cursor.getColumnIndexOrThrow("craquestion2")));
                    jsonObject.put("craquestion3", cursor.getString(cursor.getColumnIndexOrThrow("craquestion3")));
                    jsonObject.put("craquestion4", cursor.getString(cursor.getColumnIndexOrThrow("craquestion4")));
                    jsonObject.put("craquestion5", cursor.getString(cursor.getColumnIndexOrThrow("craquestion5")));
                    jsonObject.put("craquestion6", cursor.getString(cursor.getColumnIndexOrThrow("craquestion6")));
                    jsonObject.put("craquestion7", cursor.getString(cursor.getColumnIndexOrThrow("craquestion7")));
                    jsonObject.put("craquestion8", cursor.getString(cursor.getColumnIndexOrThrow("craquestion8")));
                    jsonObject.put("craquestion9", cursor.getString(cursor.getColumnIndexOrThrow("craquestion9")));
                    jsonObject.put("craquestion10", cursor.getString(cursor.getColumnIndexOrThrow("craquestion10")));
                    jsonObject.put("craquestion11", cursor.getString(cursor.getColumnIndexOrThrow("craquestion11")));
                    jsonObject.put("craquestion12", cursor.getString(cursor.getColumnIndexOrThrow("craquestion12")));
                    jsonObject.put("craquestion13", cursor.getString(cursor.getColumnIndexOrThrow("craquestion13")));
                    jsonObject.put("cra_location", cursor.getString(cursor.getColumnIndexOrThrow("cra_location")));
                    jsonObject.put("signature", cursor.getString(cursor.getColumnIndexOrThrow("signature")));
                    jsonObject.put("user_fname", cursor.getString(cursor.getColumnIndexOrThrow("user_fname")));
                    jsonObject.put("user_lname", cursor.getString(cursor.getColumnIndexOrThrow("user_lname")));
                    jsonObject.put("user_email", cursor.getString(cursor.getColumnIndexOrThrow("user_email")));
                    jsonObject.put("on_create", cursor.getString(cursor.getColumnIndexOrThrow("on_create")));
                    jsonObject.put("on_update", cursor.getString(cursor.getColumnIndexOrThrow("on_update")));

                    batchArray.put(jsonObject);
                    recordCount++;

                    if (recordCount % BATCH_SIZE == 0) {
                        updateProgress(currentBatch, totalBatches);
                        if (!sendHrddCraBatch(batchArray, client)) {
                            syncSuccess = false;
                        }
                        batchArray = new JSONArray();
                        currentBatch++;
                    }
                }

                if (batchArray.length() > 0) {
                    updateProgress(currentBatch, totalBatches);
                    if (!sendHrddCraBatch(batchArray, client)) {
                        syncSuccess = false;
                    }
                }
            } catch (Exception e) {
                Log.e("Sync", "Error processing batches", e);
                syncSuccess = false;
            } finally {
                handleCompletion(syncSuccess);
                executor.shutdown();
            }
        });
    }












    public void sendHrddCflaDataToServer() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        showProgress();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            boolean syncSuccess = true;

            try (SQLiteDatabase db = lraDbHelper.getReadableDatabase(); Cursor cursor = db.rawQuery("SELECT * FROM LraSurveyTbl", null)) {
                if (cursor.getCount() == 0) {
                    showToast("No data to sync");
                    return;
                }

                OkHttpClient client = new OkHttpClient();
                JSONArray batchArray = new JSONArray();
                int recordCount = 0;
                int totalBatches = (int) Math.ceil((double) cursor.getCount() / BATCH_SIZE);
                int currentBatch = 1;

                while (cursor.moveToNext()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("lraquestion1", cursor.getString(cursor.getColumnIndexOrThrow("lraquestion1")));
                    jsonObject.put("lraquestion2", cursor.getString(cursor.getColumnIndexOrThrow("lraquestion2")));
                    jsonObject.put("lraquestion3", cursor.getString(cursor.getColumnIndexOrThrow("lraquestion3")));
                    jsonObject.put("lraquestion4", cursor.getString(cursor.getColumnIndexOrThrow("lraquestion4")));
                    jsonObject.put("lraquestion5", cursor.getString(cursor.getColumnIndexOrThrow("lraquestion5")));
                    jsonObject.put("lraquestion6", cursor.getString(cursor.getColumnIndexOrThrow("lraquestion6")));
                    jsonObject.put("lraquestion7", cursor.getString(cursor.getColumnIndexOrThrow("lraquestion7")));
                    jsonObject.put("lraquestion8", cursor.getString(cursor.getColumnIndexOrThrow("lraquestion8")));
                    jsonObject.put("lraquestion9", cursor.getString(cursor.getColumnIndexOrThrow("lraquestion9")));
                    jsonObject.put("lraquestion10", cursor.getString(cursor.getColumnIndexOrThrow("lraquestion10")));
                    jsonObject.put("lra_location", cursor.getString(cursor.getColumnIndexOrThrow("lra_location")));
                    jsonObject.put("signature", cursor.getString(cursor.getColumnIndexOrThrow("signature")));
                    jsonObject.put("user_fname", cursor.getString(cursor.getColumnIndexOrThrow("user_fname")));
                    jsonObject.put("user_lname", cursor.getString(cursor.getColumnIndexOrThrow("user_lname")));
                    jsonObject.put("user_email", cursor.getString(cursor.getColumnIndexOrThrow("user_email")));
                    jsonObject.put("on_create", cursor.getString(cursor.getColumnIndexOrThrow("on_create")));
                    jsonObject.put("on_update", cursor.getString(cursor.getColumnIndexOrThrow("on_update")));

                    batchArray.put(jsonObject);
                    recordCount++;

                    if (recordCount % BATCH_SIZE == 0) {
                        updateProgress(currentBatch, totalBatches);
                        if (!sendHrddLraBatch(batchArray, client)) {
                            syncSuccess = false;
                        }
                        batchArray = new JSONArray();
                        currentBatch++;
                    }
                }

                if (batchArray.length() > 0) {
                    updateProgress(currentBatch, totalBatches);
                    if (!sendHrddLraBatch(batchArray, client)) {
                        syncSuccess = false;
                    }
                }
            } catch (Exception e) {
                Log.e("Sync", "Error processing batches", e);
                syncSuccess = false;
            } finally {
                handleCompletion(syncSuccess);
                executor.shutdown();
            }
        });
    }


    // Common helper methods
    private boolean sendComBatch(JSONArray batchData, OkHttpClient client) {
        return sendBatch(batchData, client, COMSERVER_URL, "community");
    }

    private boolean sendSchBatch(JSONArray batchData, OkHttpClient client) {
        return sendBatch(batchData, client, SCHOOLSERVER_URL, "school");
    }

    private boolean sendHhBatch(JSONArray batchData, OkHttpClient client) {
        return sendBatch(batchData, client, HHSERVER_URL, "household");
    }

    private boolean sendObsBatch(JSONArray batchData, OkHttpClient client) {
        return sendBatch(batchData, client, OBSSERVER_URL, "observation");
    }

    private boolean sendChBatch(JSONArray batchData, OkHttpClient client) {
        return sendBatch(batchData, client, CHILDSERVER_URL, "child");
    }

    private boolean sendHrddGraBatch(JSONArray batchData, OkHttpClient client) {
        return sendBatch(batchData, client, HRDDGRASERVER_URL, "HRDD GRA");
    }

    private boolean sendHrddCraBatch(JSONArray batchData, OkHttpClient client) {
        return sendBatch(batchData, client, HRDDCRASERVER_URL, "HRDD CRA");
    }

    private boolean sendHrddLraBatch(JSONArray batchData, OkHttpClient client) {
        return sendBatch(batchData, client, HRDDLRASERVER_URL, "HRDD LRA");
    }

    private boolean sendBatch(JSONArray batchData, OkHttpClient client, String url, String type) {
        try {
            RequestBody requestBody = RequestBody.create(
                    batchData.toString(),
                    MediaType.parse("application/json; charset=utf-8")
            );

            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

            return sendRequestWithRetry(request, client);
        } catch (Exception e) {
            Log.e("Sync", "Error sending " + type + " batch", e);
            return false;
        }
    }

    private boolean sendRequestWithRetry(Request request, OkHttpClient client) {
        int attempts = 0;
        while (attempts < MAX_RETRIES) {
            try {
                Response response = client.newCall(request).execute();
                String responseBody = response.body().string();
                Log.d("Sync", "Raw server response: " + responseBody); // Log raw response

                JSONObject jsonResponse = new JSONObject(responseBody);
                Log.d("Sync", "Server response: " + jsonResponse.toString());

                if (response.isSuccessful()) {
                    String status = jsonResponse.getString("status");
                    if (status.equals("success") || status.equals("partial")) {
                        int failed = jsonResponse.optInt("failed", 0);
                        if (failed > 0) {
                            Log.w("Sync", "Partial success: " + failed + " failures");
                        }
                        return true;
                    }
                }
                Log.e("Sync", "Server error: " + jsonResponse.toString());
            } catch (Exception e) {
                Log.e("Sync", "Network error: " + e.getMessage());
            }

            attempts++;
            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        }
        return false;
    }

    // UI Helpers
    private void showProgress() {
        getActivity().runOnUiThread(() -> {
            progressDialog.setMessage("Syncing data...");
            progressDialog.show();
        });
    }

    private void updateProgress(int currentBatch, int totalBatches) {
        getActivity().runOnUiThread(() ->
                progressDialog.setMessage("Syncing batch " + currentBatch + "/" + totalBatches)
        );
    }

    private void handleCompletion(boolean success) {
        getActivity().runOnUiThread(() -> {
            progressDialog.dismiss();
            Toast.makeText(getActivity(),
                    success ? "Sync completed successfully!" : "Partial sync (some batches failed)",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }

    private void showToast(String message) {
        getActivity().runOnUiThread(() ->
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show()
        );
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            NetworkCapabilities caps = cm.getNetworkCapabilities(cm.getActiveNetwork());
            return caps != null && (caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    caps.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET));
        } else {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnected();
        }
    }
}
