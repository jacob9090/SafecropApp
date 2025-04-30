package com.jacob.fruitoftek.safecrop.sustain;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
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
import com.jacob.fruitoftek.safecrop.sustain.gmrs.GMRDbHelper;
import com.jacob.fruitoftek.safecrop.sustain.gmrs.GMRModel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SusCertCloudBottomSheet extends BottomSheetDialogFragment {

    private GMRDbHelper dbHelper;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_sus_cert_cloud, container, false);

        ImageView closeCloudBackupBtn = view.findViewById(R.id.susCetLocalCloseBackupBtn);
        closeCloudBackupBtn.setOnClickListener(v -> dismiss());

        dbHelper = new GMRDbHelper(requireContext());
        progressDialog = new ProgressDialog(requireContext());
        progressDialog.setMessage("Syncing GMR data...");
        progressDialog.setCancelable(false);

        TextView susCertCloudBackupChTv = view.findViewById(R.id.scbsCloudBackupProfilingTv);
        susCertCloudBackupChTv.setOnClickListener(v -> sendDataToServer());

        TextView scbsCloudBackupInspectionTv = view.findViewById(R.id.scbsCloudBackupInspectionTv);
        TextView scbsCloudBackupTrainingTv = view.findViewById(R.id.scbsCloudBackupTrainingTv);

        scbsCloudBackupInspectionTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //syncDataToServerGMR();
            }
        });

        scbsCloudBackupTrainingTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //syncDataToServerTrain();
            }
        });

        return view;
    }

    private void sendDataToServer() {
        if (!isNetworkConnected()) {
            Toast.makeText(getActivity(), "No internet connection. Please check your connection and try again.", Toast.LENGTH_SHORT).show();
            return;
        }

        getActivity().runOnUiThread(() -> progressDialog.show());

        new Thread(() -> {
            List<GMRModel> gmrList = dbHelper.getAllSurveys();
            int batchSize = 10;
            int totalRecords = gmrList.size();
            int totalBatches = (int) Math.ceil((double) totalRecords / batchSize);

            OkHttpClient client = new OkHttpClient();

            try {
                for (int i = 0; i < totalBatches; i++) {
                    int start = i * batchSize;
                    int end = Math.min(start + batchSize, totalRecords);
                    List<GMRModel> batch = gmrList.subList(start, end);

                    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM);

                    for (GMRModel gmr : batch) {
                        multipartBuilder.addFormDataPart("user_fname[]", gmr.getUserFname());
                        multipartBuilder.addFormDataPart("user_oname[]", gmr.getUserOname());
                        multipartBuilder.addFormDataPart("on_create[]", gmr.getOnCreate());
                        multipartBuilder.addFormDataPart("on_update[]", gmr.getOnUpdate());
                    }

                    RequestBody requestBody = multipartBuilder.build();
                    Request request = new Request.Builder()
                            .url("https://fruitoftek.com/fedco/sync_api/gmr_survey.php")
                            .post(requestBody)
                            .build();

                    Response response = client.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        Log.e("CloudBackup", "Failed to upload batch " + (i + 1) + ": " + response.message());
                        break;
                    }
                }

                getActivity().runOnUiThread(() -> {
                    progressDialog.dismiss();
                    Toast.makeText(getActivity(), "Data synced successfully", Toast.LENGTH_SHORT).show();
                });

            } catch (Exception e) {
                Log.e("CloudBackup", "Error uploading data", e);
                getActivity().runOnUiThread(() -> {
                    progressDialog.dismiss();
                    Toast.makeText(getActivity(), "Error syncing data", Toast.LENGTH_SHORT).show();
                });
            }
        }).start();
    }

    private void addFileToMultipart(MultipartBody.Builder multipartBuilder, String fieldName, Uri fileUri, String fileName) {
        try {
            InputStream inputStream = requireContext().getContentResolver().openInputStream(fileUri);
            if (inputStream != null) {
                byte[] fileBytes = readBytesFromStream(inputStream);
                multipartBuilder.addFormDataPart(
                        fieldName,
                        fileName,
                        RequestBody.create(fileBytes, MediaType.parse("image/png"))
                );
                Log.d("FileUpload", "Added file to multipart: " + fileName);
            } else {
                Log.e("FileUpload", "Unable to open InputStream for URI: " + fileUri.toString());
            }
        } catch (Exception e) {
            Log.e("FileUpload", "Error adding file to multipart", e);
        }
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

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm != null) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                NetworkCapabilities networkCapabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
                return networkCapabilities != null &&
                        (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET));
            } else {
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                return activeNetwork != null && activeNetwork.isConnected();
            }
        }
        return false;
    }
}
