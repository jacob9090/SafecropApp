package com.jacob.fruitoftek.safecrop.sustain;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
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
import com.jacob.fruitoftek.safecrop.sustain.pentry.PeDbHelper;
import com.jacob.fruitoftek.safecrop.sustain.profiling.GMRDbHelper;
import com.jacob.fruitoftek.safecrop.sustain.profiling.GMRModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SusCertCloudBottomSheet extends BottomSheetDialogFragment {

    public PeDbHelper pedbHelper;

    private ProgressDialog progressDialog;

    private static final int MAX_RETRIES = 3;
    private static final int BATCH_SIZE = 10;
    private static final String PESERVER_URL = "https://app.safecropgh.org/sus_cert/safecrop_prentry.php";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_sus_cert_cloud, container, false);

        ImageView closeCloudBackupBtn = view.findViewById(R.id.susCetLocalCloseBackupBtn);
        closeCloudBackupBtn.setOnClickListener(v -> dismiss());

        pedbHelper = new PeDbHelper(getActivity());

        TextView scbsCloudBackupPeTv = view.findViewById(R.id.scbsCloudBackupPeTv);
        scbsCloudBackupPeTv.setOnClickListener(v -> sendPEDataToServer());

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Syncing data...");
        progressDialog.setCancelable(false);

        return view;
    }

    public void sendPEDataToServer() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        showProgress();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            boolean syncSuccess = true;

            try (SQLiteDatabase db = pedbHelper.getReadableDatabase(); Cursor cursor = db.rawQuery("SELECT * FROM PEntryTbl", null)) {
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
                    jsonObject.put("pequestion1", cursor.getString(cursor.getColumnIndexOrThrow("pequestion1")));
                    jsonObject.put("pequestion2", cursor.getString(cursor.getColumnIndexOrThrow("pequestion2")));
                    jsonObject.put("pequestion3", cursor.getString(cursor.getColumnIndexOrThrow("pequestion3")));
                    jsonObject.put("pequestion4", cursor.getString(cursor.getColumnIndexOrThrow("pequestion4")));
                    jsonObject.put("pequestion5", cursor.getString(cursor.getColumnIndexOrThrow("pequestion5")));
                    jsonObject.put("pequestion6", cursor.getString(cursor.getColumnIndexOrThrow("pequestion6")));
                    jsonObject.put("pequestion7", cursor.getString(cursor.getColumnIndexOrThrow("pequestion7")));
                    jsonObject.put("pequestion8", cursor.getString(cursor.getColumnIndexOrThrow("pequestion8")));
                    jsonObject.put("pequestion9", cursor.getString(cursor.getColumnIndexOrThrow("pequestion9")));
                    jsonObject.put("pequestion10", cursor.getString(cursor.getColumnIndexOrThrow("pequestion10")));
                    jsonObject.put("pequestion11", cursor.getString(cursor.getColumnIndexOrThrow("pequestion11")));
                    jsonObject.put("pequestion12", cursor.getString(cursor.getColumnIndexOrThrow("pequestion12")));
                    jsonObject.put("pequestion13", cursor.getString(cursor.getColumnIndexOrThrow("pequestion13")));
                    jsonObject.put("pequestion14", cursor.getString(cursor.getColumnIndexOrThrow("pequestion14")));
                    jsonObject.put("user_fname", cursor.getString(cursor.getColumnIndexOrThrow("user_fname")));
                    jsonObject.put("user_lname", cursor.getString(cursor.getColumnIndexOrThrow("user_lname")));
                    jsonObject.put("user_email", cursor.getString(cursor.getColumnIndexOrThrow("user_email")));
                    jsonObject.put("on_create", cursor.getString(cursor.getColumnIndexOrThrow("on_create")));
                    jsonObject.put("on_update", cursor.getString(cursor.getColumnIndexOrThrow("on_update")));

                    batchArray.put(jsonObject);
                    recordCount++;

                    if (recordCount % BATCH_SIZE == 0) {
                        updateProgress(currentBatch, totalBatches);
                        if (!sendPeBatch(batchArray, client)) {
                            syncSuccess = false;
                        }
                        batchArray = new JSONArray();
                        currentBatch++;
                    }
                }

                if (batchArray.length() > 0) {
                    updateProgress(currentBatch, totalBatches);
                    if (!sendPeBatch(batchArray, client)) {
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
    private boolean sendPeBatch(JSONArray batchData, OkHttpClient client) {
        return sendBatch(batchData, client, PESERVER_URL, "producer_entry");
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
