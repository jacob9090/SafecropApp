package com.jacob.fruitoftek.safecrop.organic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jacob.fruitoftek.safecrop.R;

public class OrgCloudBottomSheet extends BottomSheetDialogFragment {

//    @Inject
//    ComDbHelper comdbHelper;
//
//    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_org_cloud_bottom_sheet, container, false);

//        ImageView closeCloudBackupBtn = view.findViewById(R.id.comDevCloudCloseBackupBtn);
//        closeCloudBackupBtn.setOnClickListener(v -> dismiss());
//
//        comdbHelper = new ComDbHelper(getActivity());
//
//        progressDialog = new ProgressDialog(getActivity());
//        progressDialog.setMessage("Syncing data...");
//        progressDialog.setCancelable(false);
//
//        TextView cdbsCloudBackupComTv = view.findViewById(R.id.cdbsCloudBackupComTv);
//
//        cdbsCloudBackupComTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendComDataToServer();
//            }
//        });

        return view;
    }


//    private void sendSchDataToServer() {
//        if (!isNetworkConnected()) {
//            Toast.makeText(getActivity(), "No internet connection. Please check your connection and try again.", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        getActivity().runOnUiThread(() -> progressDialog.show());
//
//        new Thread(() -> {
//            List<SchoolModel> schoolList = schdbHelper.getAllSchools();
//            int batchSize = 10;
//            int totalRecords = schoolList.size();
//            int totalBatches = (int) Math.ceil((double) totalRecords / batchSize);
//
//            OkHttpClient client = new OkHttpClient();
//
//            try {
//                for (int i = 0; i < totalBatches; i++) {
//                    int start = i * batchSize;
//                    int end = Math.min(start + batchSize, totalRecords);
//                    List<SchoolModel> batch = schoolList.subList(start, end);
//
//                    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder()
//                            .setType(MultipartBody.FORM);
//
//                    for (SchoolModel school : batch) {
//                        // Add school data to form
//                        multipartBuilder.addFormDataPart("school_name[]", school.getSch_name());
//                        multipartBuilder.addFormDataPart("school_district[]", school.getSch_district());
//                        multipartBuilder.addFormDataPart("school_community[]", school.getSch_community());
//                        multipartBuilder.addFormDataPart("schquestion4[]", school.getSchquestion4());
//                        multipartBuilder.addFormDataPart("schquestion5[]", school.getSchquestion5());
//                        multipartBuilder.addFormDataPart("schquestion6[]", school.getSchquestion6());
//                        multipartBuilder.addFormDataPart("schquestion7[]", school.getSchquestion7());
//                        multipartBuilder.addFormDataPart("schquestion8[]", school.getSchquestion8());
//                        multipartBuilder.addFormDataPart("schquestion9[]", school.getSchquestion9());
//                        multipartBuilder.addFormDataPart("schquestion10[]", school.getSchquestion10());
//                        multipartBuilder.addFormDataPart("schquestion11[]", school.getSchquestion11());
//                        multipartBuilder.addFormDataPart("schquestion12[]", school.getSchquestion12());
//                        multipartBuilder.addFormDataPart("schquestion13[]", school.getSchquestion13());
//                        multipartBuilder.addFormDataPart("schquestion14[]", school.getSchquestion14());
//                        multipartBuilder.addFormDataPart("schquestion15[]", school.getSchquestion15());
//                        multipartBuilder.addFormDataPart("schquestion16[]", school.getSchquestion16());
//                        multipartBuilder.addFormDataPart("schquestion17[]", school.getSchquestion17());
//                        multipartBuilder.addFormDataPart("schquestion18[]", school.getSchquestion18());
//                        multipartBuilder.addFormDataPart("schquestion19[]", school.getSchquestion19());
//                        multipartBuilder.addFormDataPart("schquestion20[]", school.getSchquestion20());
//                        multipartBuilder.addFormDataPart("schquestion21[]", school.getSchquestion21());
//                        multipartBuilder.addFormDataPart("schquestion22[]", school.getSchquestion22());
//                        multipartBuilder.addFormDataPart("schquestion23[]", school.getSchquestion23());
//                        multipartBuilder.addFormDataPart("schquestion24[]", school.getSchquestion24());
//                        multipartBuilder.addFormDataPart("schquestion25[]", school.getSchquestion25());
//                        multipartBuilder.addFormDataPart("schquestion26[]", school.getSchquestion26());
//                        multipartBuilder.addFormDataPart("schquestion27[]", school.getSchquestion27());
//                        multipartBuilder.addFormDataPart("schquestion28[]", school.getSchquestion28());
//                        multipartBuilder.addFormDataPart("schquestion29[]", school.getSchquestion29());
//                        multipartBuilder.addFormDataPart("schquestion30[]", school.getSchquestion30());
//                        multipartBuilder.addFormDataPart("schquestion31[]", school.getSchquestion31());
//                        multipartBuilder.addFormDataPart("schquestion32[]", school.getSchquestion32());
//                        multipartBuilder.addFormDataPart("schquestion33[]", school.getSchquestion33());
//                        multipartBuilder.addFormDataPart("schquestion34[]", school.getSchquestion34());
//                        multipartBuilder.addFormDataPart("school_location[]", school.getSch_location());
//                        multipartBuilder.addFormDataPart("user_fname[]", school.getUserFname());
//                        multipartBuilder.addFormDataPart("user_lname[]", school.getUserLname());
//                        multipartBuilder.addFormDataPart("on_create[]", school.getOnCreate());
//                        multipartBuilder.addFormDataPart("on_update[]", school.getOnUpdate());
//
//                        // Add signature file
//                        String signaturePath = school.getSignature();
//                        if (signaturePath != null) {
//                            File signatureFile = new File(signaturePath);
//                            if (signatureFile.exists()) {
//                                multipartBuilder.addFormDataPart(
//                                        "signature[]",
//                                        school.getId() + "_signature.png",
//                                        RequestBody.create(signatureFile, MediaType.parse("image/png"))
//                                );
//                                Log.d("FileUpload", "Added signature for school: " + school.getSch_name());
//                            } else {
//                                Log.e("FileUpload", "Signature file does not exist for school: " + school.getSch_name());
//                            }
//                        }
//
//                        // Add farmer photo file using utility method
////                        if (school.getFarmer_photo() != null) {
////                            Log.d("FileUpload", "Farmer photo URI: " + school.getFarmer_photo().toString());
////                        } else {
////                            Log.e("FileUpload", "Farmer photo URI is null for school: " + school.getSch_name());
////                        }
//                        if (school.getFarmer_photo() != null) {
//                            Log.d("FileUpload", "Farmer photo URI: " + school.getFarmer_photo().toString());
//                            addFileToMultipart(multipartBuilder, "farmer_photo[]", school.getFarmer_photo(), school.getId() + "_photo.jpg");
//                        } else {
//                            Log.e("FileUpload", "Farmer photo URI is null for school: " + school.getSch_name());
//                            // Optionally add a default placeholder or skip this field
//                        }
//                    }
//
//                    // Build and execute the request
//                    RequestBody requestBody = multipartBuilder.build();
//                    Request request = new Request.Builder()
//                            .url("https://app.safecropgh.org/sync/clmrs/asankragwa_agona_amenfi_school.php")
//                            .post(requestBody)
//                            .build();
//
//                    Response response = client.newCall(request).execute();
//                    if (!response.isSuccessful()) {
//                        Log.e("CloudBackup", "Failed to upload batch " + (i + 1) + ": " + response.message());
//                        break;
//                    } else {
//                        Log.d("CloudBackup", "Batch " + (i + 1) + " uploaded successfully.");
//                    }
//                }
//
//                getActivity().runOnUiThread(() -> {
//                    progressDialog.dismiss();
//                    Toast.makeText(getActivity(), "Data synced successfully", Toast.LENGTH_SHORT).show();
//                });
//
//            } catch (Exception e) {
//                Log.e("CloudBackup", "Error syncing data", e);
//                getActivity().runOnUiThread(() -> {
//                    progressDialog.dismiss();
//                    Toast.makeText(getActivity(), "Error syncing data", Toast.LENGTH_SHORT).show();
//                });
//            }
//        }).start();
//    }
//
//
//
//
//
//
//
//    private void addFileToMultipart(MultipartBody.Builder multipartBuilder, String fieldName, Uri fileUri, String fileName) {
//        try {
//            // Check if URI is null
//            if (fileUri == null) {
//                Log.e("FileUpload", "File URI is null. Skipping upload for " + fieldName);
//                return;
//            }
//
//            // Try to open the file using ContentResolver
//            InputStream inputStream = requireContext().getContentResolver().openInputStream(fileUri);
//            if (inputStream != null) {
//                byte[] fileBytes = readBytesFromStream(inputStream);
//                multipartBuilder.addFormDataPart(
//                        fieldName,
//                        fileName,
//                        RequestBody.create(fileBytes, MediaType.parse("image/jpeg"))
//                );
//                Log.d("FileUpload", "Added file to multipart: " + fileName);
//            } else {
//                Log.e("FileUpload", "InputStream is null for URI: " + fileUri.toString());
//            }
//        } catch (FileNotFoundException e) {
//            Log.e("FileUpload", "File not found for URI: " + fileUri.toString(), e);
//        } catch (Exception e) {
//            Log.e("FileUpload", "Error adding file to multipart", e);
//        }
//    }
//
//    private byte[] readBytesFromStream(InputStream inputStream) throws IOException {
//        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int bytesRead;
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//            byteBuffer.write(buffer, 0, bytesRead);
//        }
//        return byteBuffer.toByteArray();
//    }
//
//    private boolean isNetworkConnected() {
//        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        if (cm != null) {
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//                NetworkCapabilities networkCapabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
//                return networkCapabilities != null &&
//                        (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
//                                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
//                                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET));
//            } else {
//                // Fallback for older devices
//                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//                return activeNetwork != null && activeNetwork.isConnected();
//            }
//        }
//        return false;
//    }
}