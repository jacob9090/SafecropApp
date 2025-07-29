package com.jacob.fruitoftek.safecrop.sustain.training;

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

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;

import java.io.File;
import java.io.FileInputStream;

import androidx.appcompat.app.AlertDialog;

public class UpdateTrainingActivity extends AppCompatActivity {
    
    private WebView updateTrainingWebView;
    private ProgressBar updateTrainingProgressBar;
    private TrainingDbHelper dbHelper;
    private TrainingModel trainingModel;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;
    private ActivityResultLauncher<Intent> locationLauncher;
    private Uri farmerPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_training);

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

        dbHelper = new TrainingDbHelper(this);

        updateTrainingWebView = findViewById(R.id.updateTrainingWebView);
        updateTrainingProgressBar = findViewById(R.id.updateTrainingProgressBar);

        updateTrainingWebView.getSettings().setJavaScriptEnabled(true);
        updateTrainingWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        updateTrainingWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                updateTrainingProgressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                updateTrainingProgressBar.setVisibility(View.GONE);
                // Now inject saved data
                runOnUiThread(() -> {
                    updateTrainingWebView.evaluateJavascript("window.prefillTraining(" + getSavedDataJson() + ");", null);
                });
            }
        });

        updateTrainingWebView.loadUrl("file:///android_asset/training/update_training.html");

        // Retrieve the TrainingModel from the intent
        trainingModel = getIntent().getParcelableExtra("training_model");
        if (trainingModel == null) {
            Toast.makeText(this, "No training data available.", Toast.LENGTH_SHORT).show();
            finish();
        }

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            updateTrainingWebView.evaluateJavascript("updateTrainingLocation('" + location + "');", null);
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
                            updateTrainingWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                            Log.d("UpdateTrainingActivity", "Captured Farmer Photo: " + farmerPhotoUri);
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
        public void updateTraining(String training_code, String district, String community, String training_question1,
                                   String training_question2, String training_question3, String training_question4,
                                   String training_question5, String training_question6, String training_question7,
                                   String training_question8, String training_question9, String training_question10,
                                   String training_question11, String training_question12, String training_question13,
                                   String training_question14, String training_question15, String training_location,
                                   String farmer_photo, String signature, String is_sync, String is_draft) {
            // Fallback: If JS sends blank, use old values!
            if (farmer_photo == null || farmer_photo.isEmpty()) {
                farmer_photo = trainingModel.getFarmer_photo() != null ? trainingModel.getFarmer_photo().toString() : "";
            }
            if (signature == null || signature.isEmpty()) {
                signature = trainingModel.getSignature();
            }

            trainingModel.setTraining_code(training_code);
            trainingModel.setDistrict(district);
            trainingModel.setCommunity(community);
            trainingModel.setTraining_question1(training_question1);
            trainingModel.setTraining_question2(training_question2);
            trainingModel.setTraining_question3(training_question3);
            trainingModel.setTraining_question4(training_question4);
            trainingModel.setTraining_question5(training_question5);
            trainingModel.setTraining_question6(training_question6);
            trainingModel.setTraining_question7(training_question7);
            trainingModel.setTraining_question8(training_question8);
            trainingModel.setTraining_question9(training_question9);
            trainingModel.setTraining_question10(training_question10);
            trainingModel.setTraining_question11(training_question11);
            trainingModel.setTraining_question12(training_question12);
            trainingModel.setTraining_question13(training_question13);
            trainingModel.setTraining_question14(training_question14);
            trainingModel.setTraining_question15(training_question15);
            trainingModel.setTraining_location(training_location);
            trainingModel.setFarmer_photo(farmer_photo != null && !farmer_photo.isEmpty() ? Uri.parse(farmer_photo) : null);
            trainingModel.setSignature(signature);
            trainingModel.setIs_sync(is_sync);
            trainingModel.setIs_draft(is_draft);

            boolean success = dbHelper.updateTraining(
                    String.valueOf(trainingModel.getId()),
                    training_code, district, community, training_question1, training_question2, training_question3,
                    training_question4, training_question5, training_question6, training_question7, training_question8,
                    training_question9, training_question10, training_question11, training_question12, training_question13,
                    training_question14, training_question15, training_location, farmer_photo, signature, is_sync, is_draft
            );

            runOnUiThread(() -> {
                if (success) {
                    Toast.makeText(UpdateTrainingActivity.this, "Data updated successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateTrainingActivity.this, TrainingCompletedActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(UpdateTrainingActivity.this, "Failed to update data.", Toast.LENGTH_SHORT).show();
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
            runOnUiThread(() -> updateTrainingWebView.evaluateJavascript(js, null));
        }

        @JavascriptInterface
        public void openFarmerPhotoActivity() {
            Intent intent = new Intent(context, GetTrainingPhotoActivity.class);
            photoFarmerLauncher.launch(intent);
        }

        @JavascriptInterface
        public void openLocationActivity() {
            Intent intent = new Intent(context, GetTrainingLocationActivity.class);
            locationLauncher.launch(intent);
        }
    }

    // Convert model to JSON string for JS
    private String getSavedDataJson() {
        return new com.google.gson.Gson().toJson(trainingModel);
    }

    @Override
    protected void onDestroy() {
        if (updateTrainingWebView != null) {
            updateTrainingWebView.destroy();
        }
        super.onDestroy();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.farmer_training);
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
                if (updateTrainingWebView.canGoBack()) {
                    updateTrainingWebView.goBack();
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