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
        public void updateInspection(String district, String community, String farmer_id, String farmer_name,
                                     String ghana_card, String farmer_yob, String phone_number, String gender,
                                     String inspection_date, String inspector_name, String inspection_question1,
                                     String inspection_question2, String inspection_question3, String inspection_question4,
                                     String inspection_question5,
                                     String inspection_question6, String inspection_question7, String inspection_question8,
                                     String inspection_question9, String inspection_question10, String inspection_question11,
                                     String inspection_question12, String inspection_question13, String inspection_question14,
                                     String inspection_question15, String inspection_question16, String inspection_question17,
                                     String inspection_question18, String inspection_question19, String inspection_question20,
                                     String inspection_question21, String inspection_question22, String inspection_question23,
                                     String inspection_question24, String inspection_question25, String inspection_question26,
                                     String inspection_question27, String inspection_question28, String inspection_question29,
                                     String inspection_question30, String inspection_question31, String inspection_question32,
                                     String inspection_question33, String inspection_question34, String inspection_question35,
                                     String inspection_question36, String inspection_question37, String inspection_question38,
                                     String inspection_question39, String inspection_question40, String inspection_question41,
                                     String inspection_question42, String inspection_question43, String inspection_question44,
                                     String inspection_question45, String inspection_question46, String inspection_question47,
                                     String inspection_question48, String inspection_question49, String inspection_question50,
                                     String inspection_question51, String inspection_question52, String inspection_question53,
                                     String inspection_question54, String inspection_question55, String inspection_question56,
                                     String inspection_question57, String inspection_question58, String inspection_question59,
                                     String inspection_question60, String inspection_question61, String inspection_question62,
                                     String inspection_question63, String inspection_location, String farmer_photo,
                                     String signature, String is_sync, String is_draft) {
            // Fallback: If JS sends blank, use old values!
            if (farmer_photo == null || farmer_photo.isEmpty()) {
                farmer_photo = inspectionModel.getFarmer_photo() != null ? inspectionModel.getFarmer_photo().toString() : "";
            }
            if (signature == null || signature.isEmpty()) {
                signature = inspectionModel.getSignature();
            }

            inspectionModel.setDistrict(district);
            inspectionModel.setCommunity(community);
            inspectionModel.setFarmer_id(farmer_id);
            inspectionModel.setFarmer_name(farmer_name);
            inspectionModel.setFarmer_name(ghana_card);
            inspectionModel.setFarmer_yob(farmer_yob);
            inspectionModel.setPhone_number(phone_number);
            inspectionModel.setGender(gender);
            inspectionModel.setInspection_date(inspection_date);
            inspectionModel.setInspector_name(inspector_name);
            inspectionModel.setInspection_question1(inspection_question1);
            inspectionModel.setInspection_question2(inspection_question2);
            inspectionModel.setInspection_question3(inspection_question3);
            inspectionModel.setInspection_question4(inspection_question4);
            inspectionModel.setInspection_question5(inspection_question5);
            inspectionModel.setInspection_question6(inspection_question6);
            inspectionModel.setInspection_question7(inspection_question7);
            inspectionModel.setInspection_question8(inspection_question8);
            inspectionModel.setInspection_question9(inspection_question9);
            inspectionModel.setInspection_question10(inspection_question10);
            inspectionModel.setInspection_question11(inspection_question11);
            inspectionModel.setInspection_question12(inspection_question12);
            inspectionModel.setInspection_question13(inspection_question13);
            inspectionModel.setInspection_question14(inspection_question14);
            inspectionModel.setInspection_question15(inspection_question15);
            inspectionModel.setInspection_question16(inspection_question16);
            inspectionModel.setInspection_question17(inspection_question17);
            inspectionModel.setInspection_question18(inspection_question18);
            inspectionModel.setInspection_question19(inspection_question19);
            inspectionModel.setInspection_question20(inspection_question20);
            inspectionModel.setInspection_question21(inspection_question21);
            inspectionModel.setInspection_question22(inspection_question22);
            inspectionModel.setInspection_question23(inspection_question23);
            inspectionModel.setInspection_question24(inspection_question24);
            inspectionModel.setInspection_question25(inspection_question25);
            inspectionModel.setInspection_question26(inspection_question26);
            inspectionModel.setInspection_question27(inspection_question27);
            inspectionModel.setInspection_question28(inspection_question28);
            inspectionModel.setInspection_question29(inspection_question29);
            inspectionModel.setInspection_question30(inspection_question30);
            inspectionModel.setInspection_question31(inspection_question31);
            inspectionModel.setInspection_question32(inspection_question32);
            inspectionModel.setInspection_question33(inspection_question33);
            inspectionModel.setInspection_question34(inspection_question34);
            inspectionModel.setInspection_question35(inspection_question35);
            inspectionModel.setInspection_question36(inspection_question36);
            inspectionModel.setInspection_question37(inspection_question37);
            inspectionModel.setInspection_question38(inspection_question38);
            inspectionModel.setInspection_question39(inspection_question39);
            inspectionModel.setInspection_question40(inspection_question40);
            inspectionModel.setInspection_question41(inspection_question41);
            inspectionModel.setInspection_question42(inspection_question42);
            inspectionModel.setInspection_question43(inspection_question43);
            inspectionModel.setInspection_question44(inspection_question44);
            inspectionModel.setInspection_question45(inspection_question45);
            inspectionModel.setInspection_question46(inspection_question46);
            inspectionModel.setInspection_question47(inspection_question47);
            inspectionModel.setInspection_question48(inspection_question48);
            inspectionModel.setInspection_question49(inspection_question49);
            inspectionModel.setInspection_question50(inspection_question50);
            inspectionModel.setInspection_question51(inspection_question51);
            inspectionModel.setInspection_question52(inspection_question52);
            inspectionModel.setInspection_question53(inspection_question53);
            inspectionModel.setInspection_question54(inspection_question54);
            inspectionModel.setInspection_question55(inspection_question55);
            inspectionModel.setInspection_question56(inspection_question56);
            inspectionModel.setInspection_question57(inspection_question57);
            inspectionModel.setInspection_question58(inspection_question58);
            inspectionModel.setInspection_question59(inspection_question59);
            inspectionModel.setInspection_question60(inspection_question60);
            inspectionModel.setInspection_question61(inspection_question61);
            inspectionModel.setInspection_question62(inspection_question62);
            inspectionModel.setInspection_question63(inspection_question63);
            inspectionModel.setInspection_location(inspection_location);
            inspectionModel.setFarmer_photo(farmer_photo != null && !farmer_photo.isEmpty() ? Uri.parse(farmer_photo) : null);
            inspectionModel.setSignature(signature);
            inspectionModel.setIs_sync(is_sync);
            inspectionModel.setIs_draft(is_draft);

            boolean success = dbHelper.updateInspection(
                    String.valueOf(inspectionModel.getId()),
                    district, community, farmer_id, farmer_name, ghana_card, farmer_yob, phone_number,
                    gender, inspection_date, inspector_name, inspection_question1, inspection_question2,
                    inspection_question3, inspection_question4,
                    inspection_question5, inspection_question6, inspection_question7, inspection_question8,
                    inspection_question9, inspection_question10, inspection_question11, inspection_question12,
                    inspection_question13, inspection_question14, inspection_question15, inspection_question16,
                    inspection_question17, inspection_question18, inspection_question19, inspection_question20,
                    inspection_question21, inspection_question22, inspection_question23, inspection_question24,
                    inspection_question25, inspection_question26, inspection_question27, inspection_question28,
                    inspection_question29, inspection_question30, inspection_question31, inspection_question32,
                    inspection_question33, inspection_question34, inspection_question35, inspection_question36,
                    inspection_question37, inspection_question38, inspection_question39, inspection_question40,
                    inspection_question41, inspection_question42, inspection_question43, inspection_question44,
                    inspection_question45, inspection_question46, inspection_question47, inspection_question48,
                    inspection_question49, inspection_question50, inspection_question51, inspection_question52,
                    inspection_question53, inspection_question54, inspection_question55, inspection_question56,
                    inspection_question57, inspection_question58, inspection_question59, inspection_question60,
                    inspection_question61, inspection_question62, inspection_question63, inspection_location,
                    farmer_photo, signature, is_sync, is_draft
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