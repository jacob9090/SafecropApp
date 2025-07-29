package com.jacob.fruitoftek.safecrop.sustain;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
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
import com.jacob.fruitoftek.safecrop.sustain.inspection.InspectionDbHelper;
import com.jacob.fruitoftek.safecrop.sustain.inspection.InspectionModel;
import com.jacob.fruitoftek.safecrop.sustain.profiling.SusProfilingDbHelper;
import com.jacob.fruitoftek.safecrop.sustain.profiling.SusProfilingModel;
import com.jacob.fruitoftek.safecrop.sustain.training.TrainingDbHelper;
import com.jacob.fruitoftek.safecrop.sustain.training.TrainingModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SusCertCloudBottomSheet extends BottomSheetDialogFragment {

    public InspectionDbHelper inspectionDbHelper;
    public SusProfilingDbHelper susProfilingDbHelper;
    public TrainingDbHelper trainingDbHelper;
    private ProgressDialog progressDialog;
    private boolean isSyncing = false;

    private static final String INSPECTIONSERVER_URL = "https://app.safecropgh.org/sus_cert/safecrop_inspection.php";
    private static final String SUSPROFILINGSERVER_URL = "https://app.safecropgh.org/sus_cert/safecrop_susprofiling.php";
    private static final String TRAININGSERVER_URL = "https://app.safecropgh.org/sus_cert/safecrop_training.php";
    private static final int BATCH_SIZE = 10;
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 2000;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_sus_cert_cloud, container, false);

        ImageView closeCloudBackupBtn = view.findViewById(R.id.susCetLocalCloseBackupBtn);
        closeCloudBackupBtn.setOnClickListener(v -> dismiss());

        inspectionDbHelper = new InspectionDbHelper(getActivity());
        susProfilingDbHelper = new SusProfilingDbHelper(getActivity());
        trainingDbHelper = new TrainingDbHelper(getActivity());

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Preparing sync...");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        TextView scbsCloudBackupInspectionTv = view.findViewById(R.id.scbsCloudBackupInspectionTv);
        scbsCloudBackupInspectionTv.setOnClickListener(v -> {
            if (isSyncing) {
                Toast.makeText(getActivity(), "Sync already in progress", Toast.LENGTH_SHORT).show();
                return;
            }
            syncInspectionProcess();
        });

        TextView scbsCloudBackupTrainingTv = view.findViewById(R.id.scbsCloudBackupTrainingTv);
        scbsCloudBackupTrainingTv.setOnClickListener(v -> {
            if (isSyncing) {
                Toast.makeText(getActivity(), "Sync already in progress", Toast.LENGTH_SHORT).show();
                return;
            }
            syncTrainingProcess();
        });

        TextView scbsCloudBackupProfilingTv = view.findViewById(R.id.scbsCloudBackupProfilingTv);
        scbsCloudBackupProfilingTv.setOnClickListener(v -> {
            if (isSyncing) {
                Toast.makeText(getActivity(), "Sync already in progress", Toast.LENGTH_SHORT).show();
                return;
            }
            syncProfilingProcess();
        });

        return view;
    }

    private void syncInspectionProcess() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        progressDialog.show();
        isSyncing = true;

        syncInspectionsToServer(requireContext(), INSPECTIONSERVER_URL, new SyncCallback() {
            @Override
            public void onBatchSynced(int batchNum, int totalBatches, int successCount) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.setMessage(String.format("Syncing batch %d of %d", batchNum, totalBatches));
                    progressDialog.setProgress((batchNum * 100) / totalBatches);
                });
            }

            @Override
            public void onBatchFailed(int batchNum, String errorMessage) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.setMessage(String.format("Failed batch %d: %s", batchNum, errorMessage));
                    showToast("Batch " + batchNum + " failed: " + errorMessage);
                });
            }

            @Override
            public void onSyncComplete(int totalSynced, int totalFailed) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.dismiss();
                    isSyncing = false;
                    String message;
                    if (totalFailed == 0) {
                        message = "Sync complete! " + totalSynced + " records synced";
                    } else {
                        message = String.format("Sync completed with %d successes and %d failures", totalSynced, totalFailed);
                    }
                    showToast(message);
                });
            }
        });
    }

    public void syncInspectionsToServer(Context context, String serverUrl, SyncCallback callback) {
        new Thread(() -> {
            List<InspectionModel> unsyncedInspections = inspectionDbHelper.getUnsyncedInspections();
            if (unsyncedInspections.isEmpty()) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.dismiss();
                    showToast("No unsynced inspections found");
                });
                callback.onSyncComplete(0, 0);
                return;
            }

            int totalBatches = (unsyncedInspections.size() + BATCH_SIZE - 1) / BATCH_SIZE;
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();

            int totalSynced = 0;
            int totalFailed = 0;

            for (int i = 0; i < unsyncedInspections.size(); i += BATCH_SIZE) {
                int end = Math.min(i + BATCH_SIZE, unsyncedInspections.size());
                List<InspectionModel> batch = unsyncedInspections.subList(i, end);
                int batchNum = (i / BATCH_SIZE) + 1;
                String batchError = null;

                // Prepare multipart request
                MultipartBody.Builder multipartBuilder = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM);
                JSONArray batchArray = new JSONArray();

                try {
                    for (InspectionModel inspection : batch) {
                        JSONObject obj = new JSONObject();
                        obj.put("district", inspection.getDistrict());
                        obj.put("community", inspection.getCommunity());
                        obj.put("farmer_id", inspection.getFarmer_id());
                        obj.put("farmer_name", inspection.getFarmer_name());
                        obj.put("ghana_card", inspection.getGhana_card());
                        obj.put("farmer_yob", inspection.getFarmer_yob());
                        obj.put("farmer_phone", inspection.getFarmer_phone());
                        obj.put("gender", inspection.getFarmer_gender());
                        obj.put("inspection_date", inspection.getInspection_date());
                        obj.put("inspector_name", inspection.getInspector_name());
                        obj.put("inspection_question1", inspection.getInspection_question1());
                        obj.put("inspection_question2", inspection.getInspection_question2());
                        obj.put("inspection_question3", inspection.getInspection_question3());
                        obj.put("inspection_question4", inspection.getInspection_question4());
                        obj.put("inspection_question5", inspection.getInspection_question5());
                        obj.put("inspection_question6", inspection.getInspection_question6());
                        obj.put("inspection_question7", inspection.getInspection_question7());
                        obj.put("inspection_question8", inspection.getInspection_question8());
                        obj.put("inspection_question9", inspection.getInspection_question9());
                        obj.put("inspection_question10", inspection.getInspection_question10());
                        obj.put("inspection_question11", inspection.getInspection_question11());
                        obj.put("inspection_question12", inspection.getInspection_question12());
                        obj.put("inspection_question13", inspection.getInspection_question13());
                        obj.put("inspection_question14", inspection.getInspection_question14());
                        obj.put("inspection_question15", inspection.getInspection_question15());
                        obj.put("inspection_question16", inspection.getInspection_question16());
                        obj.put("inspection_question17", inspection.getInspection_question17());
                        obj.put("inspection_question18", inspection.getInspection_question18());
                        obj.put("inspection_question19", inspection.getInspection_question19());
                        obj.put("inspection_question20", inspection.getInspection_question20());
                        obj.put("inspection_question21", inspection.getInspection_question21());
                        obj.put("inspection_question22", inspection.getInspection_question22());
                        obj.put("inspection_question23", inspection.getInspection_question23());
                        obj.put("inspection_question24", inspection.getInspection_question24());
                        obj.put("inspection_question25", inspection.getInspection_question25());
                        obj.put("inspection_question26", inspection.getInspection_question26());
                        obj.put("inspection_question27", inspection.getInspection_question27());
                        obj.put("inspection_question28", inspection.getInspection_question28());
                        obj.put("inspection_question29", inspection.getInspection_question29());
                        obj.put("inspection_question30", inspection.getInspection_question30());
                        obj.put("inspection_question31", inspection.getInspection_question31());
                        obj.put("inspection_question32", inspection.getInspection_question32());
                        obj.put("inspection_question33", inspection.getInspection_question33());
                        obj.put("inspection_question34", inspection.getInspection_question34());
                        obj.put("inspection_question35", inspection.getInspection_question35());
                        obj.put("inspection_question36", inspection.getInspection_question36());
                        obj.put("inspection_question37", inspection.getInspection_question37());
                        obj.put("inspection_question38", inspection.getInspection_question38());
                        obj.put("inspection_question39", inspection.getInspection_question39());
                        obj.put("inspection_question40", inspection.getInspection_question40());
                        obj.put("inspection_question41", inspection.getInspection_question41());
                        obj.put("inspection_question42", inspection.getInspection_question42());
                        obj.put("inspection_question43", inspection.getInspection_question43());
                        obj.put("inspection_question44", inspection.getInspection_question44());
                        obj.put("inspection_question45", inspection.getInspection_question45());
                        obj.put("inspection_question46", inspection.getInspection_question46());
                        obj.put("inspection_question47", inspection.getInspection_question47());
                        obj.put("inspection_question48", inspection.getInspection_question48());
                        obj.put("inspection_question49", inspection.getInspection_question49());
                        obj.put("inspection_question50", inspection.getInspection_question50());
                        obj.put("inspection_question51", inspection.getInspection_question51());
                        obj.put("inspection_question52", inspection.getInspection_question52());
                        obj.put("inspection_question53", inspection.getInspection_question53());
                        obj.put("inspection_question54", inspection.getInspection_question54());
                        obj.put("inspection_question55", inspection.getInspection_question55());
                        obj.put("inspection_question56", inspection.getInspection_question56());
                        obj.put("inspection_question57", inspection.getInspection_question57());
                        obj.put("inspection_question58", inspection.getInspection_question58());
                        obj.put("inspection_location", inspection.getInspection_location());
                        obj.put("is_sync", inspection.getIs_sync());
                        obj.put("is_draft", inspection.getIs_draft());
                        obj.put("user_fname", inspection.getUserFname());
                        obj.put("user_lname", inspection.getUserLname());
                        obj.put("user_email", inspection.getUserEmail());
                        obj.put("on_create", inspection.getOnCreate());
                        obj.put("on_update", inspection.getOnUpdate());

                        // Handle files
                        obj.put("signature_filename",
                                inspection.getSignature() != null ?
                                        inspection.getFarmer_id() + "_signature.png" :
                                        JSONObject.NULL);

                        obj.put("farmer_photo_filename",
                                inspection.getFarmer_photo() != null ?
                                        inspection.getFarmer_id() + "_photo.jpg" :
                                        JSONObject.NULL);

                        batchArray.put(obj);

                        // Add signature file if exists
                        if (inspection.getSignature() != null) {
                            File signatureFile = new File(inspection.getSignature());
                            if (signatureFile.exists()) {
                                multipartBuilder.addFormDataPart(
                                        "signature_files[]",
                                        inspection.getFarmer_id() + "_signature.png",
                                        RequestBody.create(signatureFile, MediaType.parse("image/png"))
                                );
                            }
                        }

                        // Add farmer photo if exists
                        if (inspection.getFarmer_photo() != null) {
                            try (InputStream inputStream = context.getContentResolver()
                                    .openInputStream(inspection.getFarmer_photo())) {
                                if (inputStream != null) {
                                    byte[] fileBytes = readBytesFromStream(inputStream);
                                    multipartBuilder.addFormDataPart(
                                            "farmer_photo_files[]",
                                            inspection.getFarmer_id() + "_photo.jpg",
                                            RequestBody.create(fileBytes, MediaType.parse("image/jpeg"))
                                    );
                                }
                            } catch (Exception e) {
                                Log.e("Sync", "Error reading photo: " + e.getMessage());
                            }
                        }
                    }

                    multipartBuilder.addFormDataPart("batch", batchArray.toString());
                    RequestBody requestBody = multipartBuilder.build();
                    Request request = new Request.Builder()
                            .url(serverUrl)
                            .post(requestBody)
                            .build();

                    boolean batchSuccess = false;
                    int retryCount = 0;

                    while (!batchSuccess && retryCount < MAX_RETRIES) {
                        try (Response response = client.newCall(request).execute()) {
                            if (response.isSuccessful()) {
                                String responseBody = response.body().string();
                                JSONObject jsonResponse = new JSONObject(responseBody);

                                if (jsonResponse.getString("status").equals("success") ||
                                        jsonResponse.getString("status").equals("partial")) {

                                    // Mark successful records as synced
                                    int syncedInBatch = jsonResponse.getInt("synced");
                                    inspectionDbHelper.markBatchAsSynced(batch);
                                    totalSynced += syncedInBatch;
                                    totalFailed += (batch.size() - syncedInBatch);
                                    batchSuccess = true;
                                    callback.onBatchSynced(batchNum, totalBatches, syncedInBatch);
                                } else {
                                    batchError = "Server rejected batch";
                                    retryCount++;
                                    if (retryCount < MAX_RETRIES) {
                                        Thread.sleep(RETRY_DELAY_MS);
                                    }
                                }
                            } else {
                                batchError = "HTTP " + response.code() + ": " + response.message();
                                retryCount++;
                                if (retryCount < MAX_RETRIES) {
                                    Thread.sleep(RETRY_DELAY_MS);
                                }
                            }
                        } catch (Exception e) {
                            batchError = e.getMessage();
                            retryCount++;
                            if (retryCount < MAX_RETRIES) {
                                Thread.sleep(RETRY_DELAY_MS);
                            }
                        }
                    }

                    if (!batchSuccess) {
                        totalFailed += batch.size();
                        callback.onBatchFailed(batchNum, batchError != null ? batchError : "Unknown error");
                    }

                } catch (Exception e) {
                    totalFailed += batch.size();
                    callback.onBatchFailed(batchNum, e.getMessage());
                }
            }

            callback.onSyncComplete(totalSynced, totalFailed);
        }).start();
    }

    private void syncProfilingProcess() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        progressDialog.show();
        isSyncing = true;

        syncProfilingToServer(requireContext(), SUSPROFILINGSERVER_URL, new SyncCallback() {
            @Override
            public void onBatchSynced(int batchNum, int totalBatches, int successCount) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.setMessage(String.format("Syncing batch %d of %d", batchNum, totalBatches));
                    progressDialog.setProgress((batchNum * 100) / totalBatches);
                });
            }

            @Override
            public void onBatchFailed(int batchNum, String errorMessage) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.setMessage(String.format("Failed batch %d: %s", batchNum, errorMessage));
                    showToast("Batch " + batchNum + " failed: " + errorMessage);
                });
            }

            @Override
            public void onSyncComplete(int totalSynced, int totalFailed) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.dismiss();
                    isSyncing = false;
                    String message;
                    if (totalFailed == 0) {
                        message = "Sync complete! " + totalSynced + " records synced";
                    } else {
                        message = String.format("Sync completed with %d successes and %d failures", totalSynced, totalFailed);
                    }
                    showToast(message);
                });
            }
        });
    }

    public void syncProfilingToServer(Context context, String serverUrl, SyncCallback callback) {
        new Thread(() -> {
            List<SusProfilingModel> unsyncedSusprofilings = susProfilingDbHelper.getUnsyncedSusProfiling();
            if (unsyncedSusprofilings.isEmpty()) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.dismiss();
                    showToast("No unsynced profilings found");
                });
                callback.onSyncComplete(0, 0);
                return;
            }

            int totalBatches = (unsyncedSusprofilings.size() + BATCH_SIZE - 1) / BATCH_SIZE;
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();

            int totalSynced = 0;
            int totalFailed = 0;

            for (int i = 0; i < unsyncedSusprofilings.size(); i += BATCH_SIZE) {
                int end = Math.min(i + BATCH_SIZE, unsyncedSusprofilings.size());
                List<SusProfilingModel> batch = unsyncedSusprofilings.subList(i, end);
                int batchNum = (i / BATCH_SIZE) + 1;
                String batchError = null;

                // Prepare multipart request
                MultipartBody.Builder multipartBuilder = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM);
                JSONArray batchArray = new JSONArray();

                try {
                    for (SusProfilingModel profiling : batch) {
                        JSONObject obj = new JSONObject();
                        obj.put("farmer_id", profiling.getFarmer_id());
                        obj.put("district", profiling.getDistrict());
                        obj.put("community", profiling.getCommunity());
                        obj.put("suspro_question1", profiling.getSuspro_question1());
                        obj.put("suspro_question2", profiling.getSuspro_question2());
                        obj.put("suspro_question3", profiling.getSuspro_question3());
                        obj.put("suspro_question4", profiling.getSuspro_question4());
                        obj.put("suspro_question4b", profiling.getSuspro_question4b());
                        obj.put("suspro_question4c", profiling.getSuspro_question4c());
                        obj.put("suspro_question5", profiling.getSuspro_question5());
                        obj.put("suspro_question6", profiling.getSuspro_question6());
                        obj.put("suspro_question7", profiling.getSuspro_question7());
                        obj.put("suspro_question7b", profiling.getSuspro_question7b());
                        obj.put("suspro_question8", profiling.getSuspro_question8());
                        obj.put("suspro_question8b", profiling.getSuspro_question8b());
                        obj.put("suspro_question9", profiling.getSuspro_question9());
                        obj.put("suspro_question10", profiling.getSuspro_question10());
                        obj.put("suspro_question11", profiling.getSuspro_question11());
                        obj.put("suspro_question11b", profiling.getSuspro_question11b());
                        obj.put("suspro_question11c", profiling.getSuspro_question11c());
                        obj.put("suspro_question12", profiling.getSuspro_question12());
                        obj.put("suspro_question12b", profiling.getSuspro_question12b());
                        obj.put("suspro_question13", profiling.getSuspro_question13());
                        obj.put("suspro_question14", profiling.getSuspro_question14());
                        obj.put("suspro_question14b", profiling.getSuspro_question14b());
                        obj.put("suspro_question14c", profiling.getSuspro_question14c());
                        obj.put("suspro_question14d", profiling.getSuspro_question14d());
                        obj.put("suspro_question15", profiling.getSuspro_question15());
                        obj.put("suspro_question15b", profiling.getSuspro_question15b());
                        obj.put("suspro_question16", profiling.getSuspro_question16());
                        obj.put("suspro_question16b", profiling.getSuspro_question16b());
                        obj.put("suspro_question17", profiling.getSuspro_question17());
                        obj.put("suspro_question17b", profiling.getSuspro_question17b());
                        obj.put("suspro_question17c", profiling.getSuspro_question17c());
                        obj.put("suspro_question18", profiling.getSuspro_question18());
                        obj.put("suspro_question19", profiling.getSuspro_question19());
                        obj.put("suspro_question20", profiling.getSuspro_question20());
                        obj.put("suspro_question21", profiling.getSuspro_question21());
                        obj.put("suspro_location", profiling.getSuspro_location());
                        obj.put("is_sync", profiling.getIs_sync());
                        obj.put("is_draft", profiling.getIs_draft());
                        obj.put("user_fname", profiling.getUserFname());
                        obj.put("user_lname", profiling.getUserLname());
                        obj.put("user_email", profiling.getUserEmail());
                        obj.put("on_create", profiling.getOnCreate());
                        obj.put("on_update", profiling.getOnUpdate());

                        // Handle files
                        obj.put("signature_filename",
                                profiling.getSignature() != null ?
                                        profiling.getFarmer_id() + "_signature.png" :
                                        JSONObject.NULL);

                        obj.put("farmer_photo_filename",
                                profiling.getFarmer_photo() != null ?
                                        profiling.getFarmer_id() + "_photo.jpg" :
                                        JSONObject.NULL);

                        batchArray.put(obj);

                        // Add signature file if exists
                        if (profiling.getSignature() != null) {
                            File signatureFile = new File(profiling.getSignature());
                            if (signatureFile.exists()) {
                                multipartBuilder.addFormDataPart(
                                        "signature_files[]",
                                        profiling.getFarmer_id() + "_signature.png",
                                        RequestBody.create(signatureFile, MediaType.parse("image/png"))
                                );
                            }
                        }

                        // Add farmer photo if exists
                        if (profiling.getFarmer_photo() != null) {
                            try (InputStream inputStream = context.getContentResolver()
                                    .openInputStream(profiling.getFarmer_photo())) {
                                if (inputStream != null) {
                                    byte[] fileBytes = readBytesFromStream(inputStream);
                                    multipartBuilder.addFormDataPart(
                                            "farmer_photo_files[]",
                                            profiling.getFarmer_id() + "_photo.jpg",
                                            RequestBody.create(fileBytes, MediaType.parse("image/jpeg"))
                                    );
                                }
                            } catch (Exception e) {
                                Log.e("Sync", "Error reading photo: " + e.getMessage());
                            }
                        }
                    }

                    multipartBuilder.addFormDataPart("batch", batchArray.toString());
                    RequestBody requestBody = multipartBuilder.build();
                    Request request = new Request.Builder()
                            .url(serverUrl)
                            .post(requestBody)
                            .build();

                    boolean batchSuccess = false;
                    int retryCount = 0;

                    while (!batchSuccess && retryCount < MAX_RETRIES) {
                        try (Response response = client.newCall(request).execute()) {
                            if (response.isSuccessful()) {
                                String responseBody = response.body().string();
                                JSONObject jsonResponse = new JSONObject(responseBody);

                                if (jsonResponse.getString("status").equals("success") ||
                                        jsonResponse.getString("status").equals("partial")) {

                                    // Mark successful records as synced
                                    int syncedInBatch = jsonResponse.getInt("synced");
                                    susProfilingDbHelper.markBatchAsSynced(batch);
                                    totalSynced += syncedInBatch;
                                    totalFailed += (batch.size() - syncedInBatch);
                                    batchSuccess = true;
                                    callback.onBatchSynced(batchNum, totalBatches, syncedInBatch);
                                } else {
                                    batchError = "Server rejected batch";
                                    retryCount++;
                                    if (retryCount < MAX_RETRIES) {
                                        Thread.sleep(RETRY_DELAY_MS);
                                    }
                                }
                            } else {
                                batchError = "HTTP " + response.code() + ": " + response.message();
                                retryCount++;
                                if (retryCount < MAX_RETRIES) {
                                    Thread.sleep(RETRY_DELAY_MS);
                                }
                            }
                        } catch (Exception e) {
                            batchError = e.getMessage();
                            retryCount++;
                            if (retryCount < MAX_RETRIES) {
                                Thread.sleep(RETRY_DELAY_MS);
                            }
                        }
                    }

                    if (!batchSuccess) {
                        totalFailed += batch.size();
                        callback.onBatchFailed(batchNum, batchError != null ? batchError : "Unknown error");
                    }

                } catch (Exception e) {
                    totalFailed += batch.size();
                    callback.onBatchFailed(batchNum, e.getMessage());
                }
            }

            callback.onSyncComplete(totalSynced, totalFailed);
        }).start();
    }











    private void syncTrainingProcess() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        progressDialog.show();
        isSyncing = true;

        syncTrainingToServer(requireContext(), TRAININGSERVER_URL, new SyncCallback() {
            @Override
            public void onBatchSynced(int batchNum, int totalBatches, int successCount) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.setMessage(String.format("Syncing batch %d of %d", batchNum, totalBatches));
                    progressDialog.setProgress((batchNum * 100) / totalBatches);
                });
            }

            @Override
            public void onBatchFailed(int batchNum, String errorMessage) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.setMessage(String.format("Failed batch %d: %s", batchNum, errorMessage));
                    showToast("Batch " + batchNum + " failed: " + errorMessage);
                });
            }

            @Override
            public void onSyncComplete(int totalSynced, int totalFailed) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.dismiss();
                    isSyncing = false;
                    String message;
                    if (totalFailed == 0) {
                        message = "Sync complete! " + totalSynced + " records synced";
                    } else {
                        message = String.format("Sync completed with %d successes and %d failures", totalSynced, totalFailed);
                    }
                    showToast(message);
                });
            }
        });
    }

    public void syncTrainingToServer(Context context, String serverUrl, SyncCallback callback) {
        new Thread(() -> {
            List<TrainingModel> unsyncedTraings = trainingDbHelper.getUnsyncedTrainings();
            if (unsyncedTraings.isEmpty()) {
                requireActivity().runOnUiThread(() -> {
                    progressDialog.dismiss();
                    showToast("No unsynced training found");
                });
                callback.onSyncComplete(0, 0);
                return;
            }

            int totalBatches = (unsyncedTraings.size() + BATCH_SIZE - 1) / BATCH_SIZE;
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();

            int totalSynced = 0;
            int totalFailed = 0;

            for (int i = 0; i < unsyncedTraings.size(); i += BATCH_SIZE) {
                int end = Math.min(i + BATCH_SIZE, unsyncedTraings.size());
                List<TrainingModel> batch = unsyncedTraings.subList(i, end);
                int batchNum = (i / BATCH_SIZE) + 1;
                String batchError = null;

                // Prepare multipart request
                MultipartBody.Builder multipartBuilder = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM);
                JSONArray batchArray = new JSONArray();

                try {
                    for (TrainingModel training : batch) {
                        JSONObject obj = new JSONObject();
                        obj.put("training_code", training.getTraining_code());
                        obj.put("district", training.getDistrict());
                        obj.put("community", training.getCommunity());
                        obj.put("training_question1", training.getTraining_question1());
                        obj.put("training_question2", training.getTraining_question2());
                        obj.put("training_question3", training.getTraining_question3());
                        obj.put("training_question4", training.getTraining_question4());
                        obj.put("training_question5", training.getTraining_question5());
                        obj.put("training_question6", training.getTraining_question6());
                        obj.put("training_question7", training.getTraining_question7());
                        obj.put("training_question8", training.getTraining_question8());
                        obj.put("training_question9", training.getTraining_question9());
                        obj.put("training_question10", training.getTraining_question10());
                        obj.put("training_question11", training.getTraining_question11());
                        obj.put("training_question12", training.getTraining_question12());
                        obj.put("training_question13", training.getTraining_question13());
                        obj.put("training_question14", training.getTraining_question14());
                        obj.put("training_question15", training.getTraining_question15());
                        obj.put("training_location", training.getTraining_location());
                        obj.put("is_sync", training.getIs_sync());
                        obj.put("is_draft", training.getIs_draft());
                        obj.put("user_fname", training.getUserFname());
                        obj.put("user_lname", training.getUserLname());
                        obj.put("user_email", training.getUserEmail());
                        obj.put("on_create", training.getOnCreate());
                        obj.put("on_update", training.getOnUpdate());

                        // Handle files
                        obj.put("signature_filename",
                                training.getSignature() != null ?
                                        training.getTraining_code() + "_signature.png" :
                                        JSONObject.NULL);

                        obj.put("farmer_photo_filename",
                                training.getFarmer_photo() != null ?
                                        training.getTraining_code() + "_photo.jpg" :
                                        JSONObject.NULL);

                        batchArray.put(obj);

                        // Add signature file if exists
                        if (training.getSignature() != null) {
                            File signatureFile = new File(training.getSignature());
                            if (signatureFile.exists()) {
                                multipartBuilder.addFormDataPart(
                                        "signature_files[]",
                                        training.getTraining_code() + "_signature.png",
                                        RequestBody.create(signatureFile, MediaType.parse("image/png"))
                                );
                            }
                        }

                        // Add farmer photo if exists
                        if (training.getFarmer_photo() != null) {
                            try (InputStream inputStream = context.getContentResolver()
                                    .openInputStream(training.getFarmer_photo())) {
                                if (inputStream != null) {
                                    byte[] fileBytes = readBytesFromStream(inputStream);
                                    multipartBuilder.addFormDataPart(
                                            "farmer_photo_files[]",
                                            training.getTraining_code() + "_photo.jpg",
                                            RequestBody.create(fileBytes, MediaType.parse("image/jpeg"))
                                    );
                                }
                            } catch (Exception e) {
                                Log.e("Sync", "Error reading photo: " + e.getMessage());
                            }
                        }
                    }

                    multipartBuilder.addFormDataPart("batch", batchArray.toString());
                    RequestBody requestBody = multipartBuilder.build();
                    Request request = new Request.Builder()
                            .url(serverUrl)
                            .post(requestBody)
                            .build();

                    boolean batchSuccess = false;
                    int retryCount = 0;

                    while (!batchSuccess && retryCount < MAX_RETRIES) {
                        try (Response response = client.newCall(request).execute()) {
                            if (response.isSuccessful()) {
                                String responseBody = response.body().string();
                                JSONObject jsonResponse = new JSONObject(responseBody);

                                if (jsonResponse.getString("status").equals("success") ||
                                        jsonResponse.getString("status").equals("partial")) {

                                    // Mark successful records as synced
                                    int syncedInBatch = jsonResponse.getInt("synced");
                                    trainingDbHelper.markBatchAsSynced(batch);
                                    totalSynced += syncedInBatch;
                                    totalFailed += (batch.size() - syncedInBatch);
                                    batchSuccess = true;
                                    callback.onBatchSynced(batchNum, totalBatches, syncedInBatch);
                                } else {
                                    batchError = "Server rejected batch";
                                    retryCount++;
                                    if (retryCount < MAX_RETRIES) {
                                        Thread.sleep(RETRY_DELAY_MS);
                                    }
                                }
                            } else {
                                batchError = "HTTP " + response.code() + ": " + response.message();
                                retryCount++;
                                if (retryCount < MAX_RETRIES) {
                                    Thread.sleep(RETRY_DELAY_MS);
                                }
                            }
                        } catch (Exception e) {
                            batchError = e.getMessage();
                            retryCount++;
                            if (retryCount < MAX_RETRIES) {
                                Thread.sleep(RETRY_DELAY_MS);
                            }
                        }
                    }

                    if (!batchSuccess) {
                        totalFailed += batch.size();
                        callback.onBatchFailed(batchNum, batchError != null ? batchError : "Unknown error");
                    }

                } catch (Exception e) {
                    totalFailed += batch.size();
                    callback.onBatchFailed(batchNum, e.getMessage());
                }
            }

            callback.onSyncComplete(totalSynced, totalFailed);
        }).start();
    }















    private byte[] readBytesFromStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, bytesRead);
        }
        return byteBuffer.toByteArray();
    }

    private void showToast(String message) {
        requireActivity().runOnUiThread(() ->
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show()
        );
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                NetworkCapabilities caps = cm.getNetworkCapabilities(cm.getActiveNetwork());
                return caps != null && (caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                        || caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        || caps.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET));
            } else {
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                return activeNetwork != null && activeNetwork.isConnected();
            }
        }
        return false;
    }

    public interface SyncCallback {
        void onBatchSynced(int batchNum, int totalBatches, int successCount);
        void onBatchFailed(int batchNum, String errorMessage);
        void onSyncComplete(int totalSynced, int totalFailed);
    }

    @Override
    public void onDestroy() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        super.onDestroy();
    }
}
