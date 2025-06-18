package com.jacob.fruitoftek.safecrop.sustain.inspection;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;
import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.sustain.SusCertDashboard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;

import java.io.File;
import java.io.FileInputStream;

public class UpdateInspectionActivity extends AppCompatActivity {

    private WebView updateInspectionWebView;
    private ProgressBar updateInspectionProgressBar;
    private InspectionDbHelper dbHelper;
    private InspectionModel inspectionModel;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;
    private ActivityResultLauncher<Intent> locationLauncher;
    private Uri farmerPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_inspection);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            int left = insets.getInsets(WindowInsetsCompat.Type.systemBars()).left;
            int top = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            int right = insets.getInsets(WindowInsetsCompat.Type.systemBars()).right;
            int bottom = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
            v.setPadding(left, top, right, bottom);
            return insets;
        });

        setupActionBar();

        dbHelper = new InspectionDbHelper(this);

        updateInspectionWebView = findViewById(R.id.updateInspectionWebView);
        updateInspectionProgressBar = findViewById(R.id.updateInspectionProgressBar);

        updateInspectionWebView.getSettings().setJavaScriptEnabled(true);
        updateInspectionWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        updateInspectionWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                updateInspectionProgressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                updateInspectionProgressBar.setVisibility(View.GONE);
                // Now inject saved data
                runOnUiThread(() -> {
                    updateInspectionWebView.evaluateJavascript("window.prefillInspection(" + getSavedDataJson() + ");", null);
                });
            }
        });

        updateInspectionWebView.loadUrl("file:///android_asset/inspection/update_inspection.html");

        // Retrieve the InspectionModel from the intent
        inspectionModel = getIntent().getParcelableExtra("inspection_model");
        if (inspectionModel == null) {
            Toast.makeText(this, "No inspection data available.", Toast.LENGTH_SHORT).show();
            finish();
        }

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            updateInspectionWebView.evaluateJavascript("updateInspectionLocation('" + location + "');", null);
                        }
                    }
                }
        );

        photoFarmerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String farmerPhotoPath = result.getData().getStringExtra("FarmerPhotoPath");
                        if (farmerPhotoPath != null) {
                            farmerPhotoUri = Uri.parse(farmerPhotoPath);
                            updateInspectionWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                            Log.d("UpdateInspectionActivity", "Captured Farmer Photo: " + farmerPhotoUri);
                        }
                    }
                }
        );
    }

    // Exposed to JS
    public class WebAppInterface {
        Context context;
        WebAppInterface(Context c) { context = c; }

        @JavascriptInterface
        public void updateInspection(String farmer_id, String farmer_name, String district, String community,
                                     String inspection_question1, String inspection_question2, String inspection_question3,
                                     String inspection_question4, String inspection_question5, String inspection_location,
                                     String farmer_photo, String signature, String is_sync, String is_draft) {
            // Fallback: If JS sends blank, use old values!
            if (farmer_photo == null || farmer_photo.isEmpty()) {
                farmer_photo = inspectionModel.getFarmer_photo() != null ? inspectionModel.getFarmer_photo().toString() : "";
            }
            if (signature == null || signature.isEmpty()) {
                signature = inspectionModel.getSignature();
            }

            inspectionModel.setFarmer_id(farmer_id);
            inspectionModel.setFarmer_name(farmer_name);
            inspectionModel.setDistrict(district);
            inspectionModel.setCommunity(community);
            inspectionModel.setInspection_question1(inspection_question1);
            inspectionModel.setInspection_question2(inspection_question2);
            inspectionModel.setInspection_question3(inspection_question3);
            inspectionModel.setInspection_question4(inspection_question4);
            inspectionModel.setInspection_question5(inspection_question5);
            inspectionModel.setInspection_location(inspection_location);
            inspectionModel.setFarmer_photo(farmer_photo != null && !farmer_photo.isEmpty() ? Uri.parse(farmer_photo) : null);
            inspectionModel.setSignature(signature);
            inspectionModel.setIs_sync(is_sync);
            inspectionModel.setIs_draft(is_draft);

            boolean success = dbHelper.updateInspection(
                    String.valueOf(inspectionModel.getId()),
                    farmer_id, farmer_name, district, community,
                    inspection_question1, inspection_question2, inspection_question3, inspection_question4,
                    inspection_question5, inspection_location, farmer_photo, signature, is_sync, is_draft
            );

            runOnUiThread(() -> {
                if (success) {
                    Toast.makeText(UpdateInspectionActivity.this, "Data updated successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateInspectionActivity.this, InspectionCompletedActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(UpdateInspectionActivity.this, "Failed to update data.", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @JavascriptInterface
        public void getSignatureBase64(String filePath) {
            String base64 = "";
            try {
                File file = new File(filePath);
                if (file.exists()) {
                    FileInputStream fis = new FileInputStream(file);
                    byte[] bytes = new byte[(int) file.length()];
                    fis.read(bytes);
                    fis.close();
                    String encoded = Base64.encodeToString(bytes, Base64.NO_WRAP);
                    base64 = "data:image/png;base64," + encoded;
                }
            } catch (Exception e) {
                Log.e("WebAppInterface", "Error reading signature for JS", e);
            }
            final String js = "survey.setValue('signature', '" + base64 + "');";
            runOnUiThread(() -> updateInspectionWebView.evaluateJavascript(js, null));
        }

        @JavascriptInterface
        public void openFarmerPhotoActivity() {
            Intent intent = new Intent(context, GetInspectionPhotoActivity.class);
            photoFarmerLauncher.launch(intent);
        }

        @JavascriptInterface
        public void openLocationActivity() {
            Intent intent = new Intent(context, GetInspectionLocationActivity.class);
            locationLauncher.launch(intent);
        }
    }

    // Convert model to JSON string for JS
    private String getSavedDataJson() {
        return new com.google.gson.Gson().toJson(inspectionModel);
    }

    @Override
    protected void onDestroy() {
        if (updateInspectionWebView != null) {
            updateInspectionWebView.destroy();
        }
        super.onDestroy();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.inspection_survey);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        showExitConfirmationDialog();
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (updateInspectionWebView.canGoBack()) {
                    updateInspectionWebView.goBack();
                } else {
                    showExitConfirmationDialog();
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showExitConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Exiting Survey")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .setCancelable(false)
                .show();
    }
}