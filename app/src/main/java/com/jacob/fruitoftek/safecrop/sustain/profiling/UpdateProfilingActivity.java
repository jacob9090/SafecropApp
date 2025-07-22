package com.jacob.fruitoftek.safecrop.sustain.profiling;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
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
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;
import com.jacob.fruitoftek.safecrop.R;

import java.io.File;
import java.io.FileInputStream;

import android.view.KeyEvent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;

public class UpdateProfilingActivity extends AppCompatActivity {

    private WebView updateSusProfilingWebView;
    private ProgressBar updateSusProfilingProgressBar;
    private SusProfilingDbHelper dbHelper;
    private SusProfilingModel susProfilingModel;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;
    private Uri farmerPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_profiling);

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

        dbHelper = new SusProfilingDbHelper(this);

        updateSusProfilingWebView = findViewById(R.id.updateSusProfilingWebView);
        updateSusProfilingProgressBar = findViewById(R.id.updateSusProfilingProgressBar);

        updateSusProfilingWebView.getSettings().setJavaScriptEnabled(true);
        updateSusProfilingWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        updateSusProfilingWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                updateSusProfilingProgressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                updateSusProfilingProgressBar.setVisibility(View.GONE);
                // Now inject saved data
                runOnUiThread(() -> {
                    updateSusProfilingWebView.evaluateJavascript("window.prefillSusProfiling(" + getSavedDataJson() + ");", null);
                });
            }
        });

        updateSusProfilingWebView.loadUrl("file:///android_asset/susprofiling/update_susprofiling.html");

        // Retrieve the SusProfilingModel from the intent
        susProfilingModel = getIntent().getParcelableExtra("susprofiling_model");
        if (susProfilingModel == null) {
            Toast.makeText(this, "No profiled data available.", Toast.LENGTH_SHORT).show();
            finish();
        }

        photoFarmerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String farmerPhotoPath = result.getData().getStringExtra("FarmerPhotoPath");
                        if (farmerPhotoPath != null) {
                            farmerPhotoUri = Uri.parse(farmerPhotoPath);
                            updateSusProfilingWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                            Log.d("UpdateProfilingActivity", "Captured Farmer Photo: " + farmerPhotoUri);
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
        public void updateSusProfiling(String farmer_id, String district, String community, String suspro_question1,
                                       String suspro_question2, String suspro_question3, String suspro_question4, String suspro_question4b,
                                       String suspro_question4c, String suspro_question5, String suspro_question6, String suspro_question7,
                                       String suspro_question7b, String suspro_question8, String suspro_question8b, String suspro_question9,
                                       String suspro_question10, String suspro_question11, String suspro_question11b, String suspro_question11c,
                                       String suspro_question12, String suspro_question12b, String suspro_question13, String suspro_question14,
                                       String suspro_question14b, String suspro_question14c, String suspro_question14d, String suspro_question15,
                                       String suspro_question15b, String suspro_question16, String suspro_question16b, String suspro_question17,
                                       String suspro_question17b, String suspro_question17c, String suspro_question18, String suspro_question19,
                                       String suspro_question20, String suspro_question21, String suspro_location, String farmer_photo,
                                       String signature, String is_sync, String is_draft) {
            // Fallback: If JS sends blank, use old values!
            if (farmer_photo == null || farmer_photo.isEmpty()) {
                farmer_photo = susProfilingModel.getFarmer_photo() != null ? susProfilingModel.getFarmer_photo().toString() : "";
            }
            if (signature == null || signature.isEmpty()) {
                signature = susProfilingModel.getSignature();
            }

            susProfilingModel.setFarmer_id(farmer_id);
            susProfilingModel.setDistrict(district);
            susProfilingModel.setCommunity(community);
            susProfilingModel.setSuspro_question1(suspro_question1);
            susProfilingModel.setSuspro_question2(suspro_question2);
            susProfilingModel.setSuspro_question3(suspro_question3);
            susProfilingModel.setSuspro_question4(suspro_question4);
            susProfilingModel.setSuspro_question4b(suspro_question4b);
            susProfilingModel.setSuspro_question4c(suspro_question4c);
            susProfilingModel.setSuspro_question5(suspro_question5);
            susProfilingModel.setSuspro_question6(suspro_question6);
            susProfilingModel.setSuspro_question7(suspro_question7);
            susProfilingModel.setSuspro_question7b(suspro_question7b);
            susProfilingModel.setSuspro_question8(suspro_question8);
            susProfilingModel.setSuspro_question8b(suspro_question8b);
            susProfilingModel.setSuspro_question9(suspro_question9);
            susProfilingModel.setSuspro_question10(suspro_question10);
            susProfilingModel.setSuspro_question11(suspro_question11);
            susProfilingModel.setSuspro_question11b(suspro_question11b);
            susProfilingModel.setSuspro_question11c(suspro_question11c);
            susProfilingModel.setSuspro_question12(suspro_question12);
            susProfilingModel.setSuspro_question12b(suspro_question12b);
            susProfilingModel.setSuspro_question13(suspro_question13);
            susProfilingModel.setSuspro_question14(suspro_question14);
            susProfilingModel.setSuspro_question14b(suspro_question14b);
            susProfilingModel.setSuspro_question14c(suspro_question14c);
            susProfilingModel.setSuspro_question14d(suspro_question14d);
            susProfilingModel.setSuspro_question15(suspro_question15);
            susProfilingModel.setSuspro_question15b(suspro_question15b);
            susProfilingModel.setSuspro_question16(suspro_question16);
            susProfilingModel.setSuspro_question16b(suspro_question16b);
            susProfilingModel.setSuspro_question17(suspro_question17);
            susProfilingModel.setSuspro_question17b(suspro_question17b);
            susProfilingModel.setSuspro_question17c(suspro_question17c);
            susProfilingModel.setSuspro_question18(suspro_question18);
            susProfilingModel.setSuspro_question19(suspro_question19);
            susProfilingModel.setSuspro_question20(suspro_question20);
            susProfilingModel.setSuspro_question21(suspro_question21);
            susProfilingModel.setSuspro_location(suspro_location);
            susProfilingModel.setFarmer_photo(farmer_photo != null && !farmer_photo.isEmpty() ? Uri.parse(farmer_photo) : null);
            susProfilingModel.setSignature(signature);
            susProfilingModel.setIs_sync(is_sync);
            susProfilingModel.setIs_draft(is_draft);

            boolean success = dbHelper.updateSusProfiling(
                    String.valueOf(susProfilingModel.getId()),
                    farmer_id, district, community, suspro_question1, suspro_question2, suspro_question3, suspro_question4,
                    suspro_question4b, suspro_question4c, suspro_question5, suspro_question6, suspro_question7, suspro_question7b,
                    suspro_question8, suspro_question8b, suspro_question9, suspro_question10, suspro_question11, suspro_question11b,
                    suspro_question11c, suspro_question12, suspro_question12b, suspro_question13, suspro_question14, suspro_question14b,
                    suspro_question14c, suspro_question14d, suspro_question15, suspro_question15b, suspro_question16, suspro_question16b,
                    suspro_question17, suspro_question17b, suspro_question17c, suspro_question18, suspro_question19, suspro_question20,
                    suspro_question21, suspro_location, farmer_photo, signature, is_sync, is_draft
            );

            runOnUiThread(() -> {
                if (success) {
                    Toast.makeText(UpdateProfilingActivity.this, "Data updated successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateProfilingActivity.this, SusProfilingCompletedActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(UpdateProfilingActivity.this, "Failed to update data.", Toast.LENGTH_SHORT).show();
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
            runOnUiThread(() -> updateSusProfilingWebView.evaluateJavascript(js, null));
        }

        @JavascriptInterface
        public void openFarmerPhotoActivity() {
            Intent intent = new Intent(context, GetSusFarmerPhotoActivity.class);
            photoFarmerLauncher.launch(intent);
        }
    }

    // Convert model to JSON string for JS
    private String getSavedDataJson() {
        return new Gson().toJson(susProfilingModel);
    }

    @Override
    protected void onDestroy() {
        if (updateSusProfilingWebView != null) {
            updateSusProfilingWebView.destroy();
        }
        super.onDestroy();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.farmer_profiling);
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
                if (updateSusProfilingWebView.canGoBack()) {
                    updateSusProfilingWebView.goBack();
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