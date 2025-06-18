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
import com.jacob.fruitoftek.safecrop.sustain.inspection.InspectionDbHelper;
import com.jacob.fruitoftek.safecrop.sustain.inspection.InspectionModel;
import com.jacob.fruitoftek.safecrop.sustain.pentry.PeDbHelper;
import com.jacob.fruitoftek.safecrop.sustain.profiling.GMRDbHelper;
import com.jacob.fruitoftek.safecrop.sustain.profiling.GMRModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SusCertCloudBottomSheet extends BottomSheetDialogFragment {

    public InspectionDbHelper inspectionDbHelper;
    private ProgressDialog progressDialog;
    private boolean isSyncing = false;

    private static final String SERVER_URL = "https://app.safecropgh.org/sus_cert/safecrop_inspection.php";
    private static final int BATCH_SIZE = 10;
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 2000;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_sus_cert_cloud, container, false);

        inspectionDbHelper = new InspectionDbHelper(getActivity());

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
            startSyncProcess();
        });

        return view;
    }

    private void startSyncProcess() {
        if (!isNetworkConnected()) {
            showToast("No internet connection");
            return;
        }

        progressDialog.show();
        isSyncing = true;

        syncInspectionsToServer(requireContext(), SERVER_URL, new SyncCallback() {
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
                        message = String.format("Sync completed with %d successes and %d failures",
                                totalSynced, totalFailed);
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
                        obj.put("farmer_id", inspection.getFarmer_id());
                        obj.put("farmer_name", inspection.getFarmer_name());
                        obj.put("district", inspection.getDistrict());
                        obj.put("community", inspection.getCommunity());
                        obj.put("inspection_question1", inspection.getInspection_question1());
                        obj.put("inspection_question2", inspection.getInspection_question2());
                        obj.put("inspection_question3", inspection.getInspection_question3());
                        obj.put("inspection_question4", inspection.getInspection_question4());
                        obj.put("inspection_question5", inspection.getInspection_question5());
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
