package com.jacob.fruitoftek.safecrop.sustain.profiling;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;
import com.jacob.fruitoftek.safecrop.sustain.SusCertDashboard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GMRProfilingWebActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;
    private WebView gmrSurveyWebView;
    private GMRDbHelper dbHelper;
    private ActivityResultLauncher<Intent> photoIdLauncher;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;
    private ActivityResultLauncher<Intent> photoTpLauncher;
    private ActivityResultLauncher<Intent> locationLauncher;
    private ProgressBar progressBar;

    private Uri idPhotoUri, farmerPhotoUri, tpPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gmrprofiling_web);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        dbHelper = new GMRDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);

        gmrSurveyWebView = findViewById(R.id.gmrWebView);
        progressBar = findViewById(R.id.gmrProgressBar);

        gmrSurveyWebView.getSettings().setJavaScriptEnabled(true);
        gmrSurveyWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        // Add WebViewClient to handle progress
        gmrSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }
        });

        gmrSurveyWebView.loadUrl("file:///android_asset/gmr/add_gmr.html");

        photoIdLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String idCardPath = result.getData().getStringExtra("IdCardPath");
                        if (idCardPath != null) {
                            idPhotoUri = Uri.parse(idCardPath);
                            gmrSurveyWebView.evaluateJavascript("updateIdPhoto('" + idPhotoUri.toString() + "');", null);
                            Log.d("GMRProfilingWebActivity", "Captured ID Photo: " + idPhotoUri);
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
                            gmrSurveyWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                            Log.d("GMRProfilingWebActivity", "Captured Farmer Photo: " + farmerPhotoUri);
                        }
                    }
                }
        );

        photoTpLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String tpPhotoPath = result.getData().getStringExtra("TpPhotoPath");
                        if (tpPhotoPath != null) {
                            tpPhotoUri = Uri.parse(tpPhotoPath);
                            gmrSurveyWebView.evaluateJavascript("updateTpPhoto('" + tpPhotoUri.toString() + "');", null);
                            Log.d("GMRProfilingWebActivity", "Captured TP Photo: " + tpPhotoUri);
                        }
                    }
                }
        );

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            gmrSurveyWebView.evaluateJavascript("updateChildLocation('" + location + "');", null);
                        }
                    }
                }
        );

    }

    public class WebAppInterface {
        Context context;
        GMRDbHelper dbHelper;

        WebAppInterface(Context c) {
            context = c;
            dbHelper = new GMRDbHelper(context);
        }

        @JavascriptInterface
        public void insertSurveyData(String gmrquestion1, String gmrquestion2, String gmrquestion3, String gmrquestion4,
                                     String gmrquestion5, String gmrquestion6, String gmrquestion7, String gmrquestion8,
                                     String gmrquestion9, String id_photo, String gmrquestion11, String gmrquestion12,
                                     String gmrquestion13, String gmrquestion14, String gmrquestion15, String gmrquestion16,
                                     String gmrquestion17, String gmrquestion18, String gmrquestion19, String gmrquestion20,
                                     String gmrquestion21, String gmrquestion22, String gmrquestion23, String gmrquestion24,
                                     String gmrquestion25, String gmrquestion26, String gmrquestion27, String gmrquestion28,
                                     String gmrquestion29, String gmrquestion30, String gmrquestion31, String gmrquestion32,
                                     String gmrquestion33, String gmrquestion34, String gmrquestion35, String gmrquestion36,
                                     String gmrquestion37, String gmrquestion38, String gmrquestion39, String farmer_photo,
                                     String tp_photo, String signature, String gmrquestion43) {
            String fname = preferenceHelper.getFirstName();
            String lname = preferenceHelper.getLastName();
            String on_create = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String on_update = on_create;

            // Use captured URIs if available
            if (idPhotoUri != null) id_photo = idPhotoUri.toString();
            if (farmerPhotoUri != null) farmer_photo = farmerPhotoUri.toString();
            if (tpPhotoUri != null) tp_photo = tpPhotoUri.toString();

            boolean success = dbHelper.insertSurveyData(fname, lname,
                    gmrquestion1, gmrquestion2, gmrquestion3, gmrquestion4, gmrquestion5, gmrquestion6, gmrquestion7,
                    gmrquestion8, gmrquestion9, id_photo, gmrquestion11, gmrquestion12, gmrquestion13, gmrquestion14,
                    gmrquestion15, gmrquestion16, gmrquestion17, gmrquestion18, gmrquestion19, gmrquestion20, gmrquestion21,
                    gmrquestion22, gmrquestion23, gmrquestion24, gmrquestion25, gmrquestion26, gmrquestion27, gmrquestion28,
                    gmrquestion29, gmrquestion30, gmrquestion31, gmrquestion32, gmrquestion33, gmrquestion34, gmrquestion35,
                    gmrquestion36, gmrquestion37, gmrquestion38, gmrquestion39, farmer_photo, tp_photo, signature,
                    gmrquestion43, on_create, on_update);

            Log.d("GMRProfilingWebActivity", "InsertSurveyData called with:");
            Log.d("GMRProfilingWebActivity", "user_fname: " + fname);
            Log.d("GMRProfilingWebActivity", "user_lname: " + lname);

            Log.d("GMRProfilingWebActivity", "gmrquestion1: " + gmrquestion1);
            Log.d("GMRProfilingWebActivity", "gmrquestion2: " + gmrquestion2);
            Log.d("GMRProfilingWebActivity", "gmrquestion3: " + gmrquestion3);
            Log.d("GMRProfilingWebActivity", "gmrquestion4: " + gmrquestion4);
            Log.d("GMRProfilingWebActivity", "gmrquestion5: " + gmrquestion5);
            Log.d("GMRProfilingWebActivity", "gmrquestion6: " + gmrquestion6);
            Log.d("GMRProfilingWebActivity", "gmrquestion7: " + gmrquestion7);
            Log.d("GMRProfilingWebActivity", "gmrquestion8: " + gmrquestion8);
            Log.d("GMRProfilingWebActivity", "gmrquestion9: " + gmrquestion9);

            Log.d("GMRProfilingWebActivity", "id_photo: " + id_photo);
            Log.d("GMRProfilingWebActivity", "farmer_photo: " + farmer_photo);
            Log.d("GMRProfilingWebActivity", "tp_photo: " + tp_photo);
            Log.d("GMRProfilingWebActivity", "signature: " + signature);
            Log.d("GMRProfilingWebActivity", "on_create: " + on_create);
            Log.d("GMRProfilingWebActivity", "on_update: " + on_update);

            if (success) {
                Log.d("GMRProfilingWebActivity", "Data inserted successfully");
            } else {
                Log.e("GMRProfilingWebActivity", "Failed to insert data");
            }
        }

        @JavascriptInterface
        public void completeSurvey() {
            Intent intent = new Intent(context, GMRSurveyCompletedActivity.class);
            context.startActivity(intent);
            finish();
        }

        @JavascriptInterface
        public void openIdPhotoActivity() {
            Intent intent = new Intent(context, GetGMRFarmerIdActivity.class);
            photoIdLauncher.launch(intent);
        }

        @JavascriptInterface
        public void openFarmerPhotoActivity() {
            Intent intent = new Intent(context, GetGMRFarmerPhotoActivity.class);
            photoFarmerLauncher.launch(intent);
        }

        @JavascriptInterface
        public void openPhotoTpActivity() {
            Intent intent = new Intent(context, GetGMRFarmerThumbprintActivity.class);
            photoTpLauncher.launch(intent);
        }

        @JavascriptInterface
        public void openLocationActivity() {
            Intent intent = new Intent(context, GetGMRLocationActivity.class);
            locationLauncher.launch(intent);
        }
    }

    @Override
    protected void onDestroy() {
        if (gmrSurveyWebView != null) {
            gmrSurveyWebView.destroy();
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
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (gmrSurveyWebView.canGoBack()) {
                        gmrSurveyWebView.goBack();
                    } else {
                        //finish();
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
                .setPositiveButton("Yes", (dialog, which) -> {
                    Intent intent = new Intent(GMRProfilingWebActivity.this, SusCertDashboard.class);
                    startActivity(intent);
                    finish(); // Finish AddStudentActivity
                })
                .setNegativeButton("No", null) // Dismiss the dialog
                .setCancelable(false)
                .show();
    }
}