package com.jacob.fruitoftek.safecrop.sustain.training;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;

import android.app.Activity;
import android.os.Handler;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TrainingActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;
    private WebView TrainingWebView;
    private TrainingDbHelper dbHelper;
    private ProgressBar TrainingProgressBar;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;
    private ActivityResultLauncher<Intent> locationLauncher;
    private Uri farmerPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        // Set the status bar appearance
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
        injectDependencies();

        dbHelper = new TrainingDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);

        TrainingWebView = findViewById(R.id.trainingWebView);
        TrainingProgressBar = findViewById(R.id.trainingProgressBar);

        TrainingWebView.getSettings().setJavaScriptEnabled(true);
        TrainingWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        TrainingWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                TrainingProgressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                TrainingProgressBar.setVisibility(View.GONE);
                Intent intent = getIntent();
                String training_code = intent.getStringExtra("training_code");
                if (training_code != null && !training_code.isEmpty()) {
                    TrainingWebView.evaluateJavascript("settraining_code('" + escapeJs(training_code) + "');", null);
                } else {
                    String uniqueCode = generateUniqueCode();
                    TrainingWebView.evaluateJavascript("settraining_code('" + escapeJs(uniqueCode) + "');", null);
                }
            }
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                TrainingProgressBar.setVisibility(View.GONE);
            }
        });

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (TrainingProgressBar.getVisibility() == View.VISIBLE) {
                TrainingProgressBar.setVisibility(View.GONE);
            }
        }, 5000);

        TrainingWebView.loadUrl("file:///android_asset/training/add_training.html");

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            TrainingWebView.evaluateJavascript("updateTrainingLocation('" + location + "');", null);
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
                            TrainingWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                        }
                    }
                }
        );
    }

    private String generateUniqueCode() {
        String fname = preferenceHelper.getFirstName();
        long timestamp = System.currentTimeMillis();
        return fname + "_" + timestamp;
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.draft_menu, menu);
        MenuItem draftSurvey = menu.findItem(R.id.draft_menu);
        if (draftSurvey != null) {
            draftSurvey.setOnMenuItemClickListener(menuItem -> {
                new AlertDialog.Builder(TrainingActivity.this)
                        .setTitle("Save As Draft")
                        .setMessage("Do you want to save the current training as a draft?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            TrainingWebView.post(() ->
                                    TrainingWebView.evaluateJavascript("saveTraining(true);", null)
                            );
                        })
                        .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                        .setCancelable(false)
                        .show();
                return true;
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    public class WebAppInterface {
        Context context;
        TrainingDbHelper dbHelper;
        WebAppInterface(Context c) {
            context = c;
            dbHelper = new TrainingDbHelper(context);
        }

        @JavascriptInterface
        public void insertOrUpdateTraining(String training_code, String district, String community, 
                                           String training_question1, String training_question2, String training_question3,
                                           String training_question4, String training_question5, String training_question6,
                                           String training_question7, String training_question8, String training_question9,
                                           String training_question10, String training_question11, String training_question12,
                                           String training_question13, String training_question14, String training_question15,
                                           String training_question16, String training_location, String farmer_photo,
                                           String signature, String is_sync, String is_draft) {

            Log.d("WebAppInterface", "--- insertOrUpdateTraining CALLED ---");
            Log.d("WebAppInterface", "Raw input Q1: " + training_question1 + ", Q2: " + training_question2);
            Log.d("WebAppInterface", "Raw input Q3: " + training_question3 + ", Q4: " + training_question4);
            Log.d("WebAppInterface", "Raw input Q5: " + training_question5 + ", Q6: " + training_question6);
            Log.d("WebAppInterface", "Raw input location: " + training_location + ", photo: " + farmer_photo + ", signature: " + signature);

            training_code = isNull(training_code);
            district = isNull(district);
            community = isNull(community);
            training_question1 = isNull(training_question1);
            training_question2 = isNull(training_question2);
            training_question3 = isNull(training_question3);
            training_question4 = isNull(training_question4);
            training_question5 = isNull(training_question5);
            training_question6 = isNull(training_question6);
            training_question7 = isNull(training_question7);
            training_question8 = isNull(training_question8);
            training_question9 = isNull(training_question9);
            training_question10 = isNull(training_question10);
            training_question11 = isNull(training_question11);
            training_question12 = isNull(training_question12);
            training_question13 = isNull(training_question13);
            training_question14 = isNull(training_question14);
            training_question15 = isNull(training_question15);
            training_question16 = isNull(training_question16);
            training_location = isNull(training_location);
            farmer_photo = isNull(farmer_photo);
            signature = isNull(signature);
            is_sync = "0";

            Log.d("WebAppInterface", "After isNull: training_code: " + training_code + ", Q1: " + training_question1);

            boolean draftMode = "1".equals(is_draft);

            if (!draftMode) {
                if (TextUtils.isEmpty(training_code) ||
                        TextUtils.isEmpty(district) ||
                        TextUtils.isEmpty(community) ||
                        TextUtils.isEmpty(training_question1) ||
                        TextUtils.isEmpty(training_question2) ||
                        TextUtils.isEmpty(training_question3) ||
                        TextUtils.isEmpty(training_question4) ||
                        TextUtils.isEmpty(training_question5) ||
                        TextUtils.isEmpty(training_question6) ||
                        TextUtils.isEmpty(training_question7) ||
                        TextUtils.isEmpty(training_question8) ||
                        TextUtils.isEmpty(training_question9) ||
                        TextUtils.isEmpty(training_question10) ||
                        TextUtils.isEmpty(training_question11) ||
                        TextUtils.isEmpty(training_question12) ||
                        TextUtils.isEmpty(training_question13) ||
                        TextUtils.isEmpty(training_question14) ||
                        TextUtils.isEmpty(training_question15) ||
                        TextUtils.isEmpty(training_question16)) {

                    Log.e("WebAppInterface", "Validation FAILED: Required fields are empty for non-draft save.");
                    runOnUiThread(() ->
                            Toast.makeText(context, "All required fields must be filled!", Toast.LENGTH_LONG).show()
                    );
                    TrainingWebView.post(() ->
                            TrainingWebView.evaluateJavascript("alert('Please fill all required fields!');", null)
                    );
                    return;
                } else {
                    Log.d("WebAppInterface", "Draft mode is ON. Skipping strict validation.");
                }
            }

            String userFname = preferenceHelper.getFirstName();
            String userLname = preferenceHelper.getLastName();
            String userEmail = preferenceHelper.getEmail();

            Log.d("WebAppInterface", "User: " + userFname + " " + userLname + " (" + userEmail + ")");

            String onCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String onUpdate = onCreate;

            if (farmerPhotoUri != null) farmer_photo = farmerPhotoUri.toString();

            Log.d("WebAppInterface", "Attempting to insert/update into DB...");
            boolean success = dbHelper.insertOrUpdateTraining(
                    training_code, district, community, training_question1, training_question2,
                    training_question3, training_question4, training_question5, training_question6,
                    training_question7, training_question8, training_question9, training_question10,
                    training_question11, training_question12, training_question13, training_question14,
                    training_question15, training_question16, training_location, farmer_photo,
                    signature, is_sync, is_draft, userFname, userLname, userEmail, onCreate, onUpdate
            );

            if (success) {
                Log.d("WebAppInterface", "DATABASE INSERT/UPDATE SUCCESS!");
                if ("1".equals(is_draft)) {
                    runOnUiThread(() ->
                            Toast.makeText(context, "Draft saved! You may continue editing.", Toast.LENGTH_LONG).show()
                    );
                }
            } else {
                Log.e("WebAppInterface", "DATABASE INSERT/UPDATE FAILED! Check TrainingDbHelper logs.");
                TrainingWebView.post(() ->
                        TrainingWebView.evaluateJavascript("alert('Failed to save data. Please try again.');", null)
                );
            }
        }

        private String isNull(String s) {
            return (s == null || s.equals("undefined")) ? "" : s;
        }

        @JavascriptInterface
        public void completeSurvey() {
            runOnUiThread(() -> {
                TrainingWebView.loadUrl("about:blank");
                TrainingWebView.clearHistory();
                TrainingWebView.clearCache(true);
                TrainingWebView.destroy();
            });

            Intent intent = new Intent(context, TrainingCompletedActivity.class);
            context.startActivity(intent);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }, 500);
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

        @JavascriptInterface
        public void notifyPageLoaded() {
            runOnUiThread(() -> TrainingProgressBar.setVisibility(View.GONE));
        }
    }

    private String escapeJs(String s) {
        if (s == null) return "";
        return s.replace("'", "\\'").replace("\n", "\\n").replace("\r", "");
    }

    private void injectDependencies() {
        preferenceHelper = new PreferenceHelper(this);
    }

    @Override
    protected void onDestroy() {
        if (TrainingWebView != null) {
            TrainingWebView.destroy();
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
                if (TrainingWebView.canGoBack()) {
                    TrainingWebView.goBack();
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