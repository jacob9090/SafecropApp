package com.jacob.fruitoftek.safecrop.comdev.sch;

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
import com.jacob.fruitoftek.safecrop.comdev.ComDevDashboard;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SchoolWebSurveyActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;
    private WebView schSurveyWebView;
    private SchoolDbHelper dbHelper;
    private ProgressBar schProgressBar;
    private ActivityResultLauncher<Intent> locationLauncher;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;

    private Uri farmerPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_school_web_survey);

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

        dbHelper = new SchoolDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);

        schSurveyWebView = findViewById(R.id.schoolWebView);
        schProgressBar = findViewById(R.id.schProgressBar);

        schSurveyWebView.getSettings().setJavaScriptEnabled(true);
        schSurveyWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        // Add WebViewClient to handle progress
        schSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                schProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                schProgressBar.setVisibility(View.GONE);
            }
        });

        schSurveyWebView.loadUrl("file:///android_asset/sch/add_sch.html");

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            schSurveyWebView.evaluateJavascript("updateComLocation('" + location + "');", null);
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
                            schSurveyWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                            Log.d("SchoolWebSurveyActivity", "Captured Farmer Photo: " + farmerPhotoUri);
                        }
                    }
                }
        );
    }

    // JavaScript interface
    public class WebAppInterface {
        Context context;
        SchoolDbHelper dbHelper;

        WebAppInterface(Context c) {
            context = c;
            dbHelper = new SchoolDbHelper(context);
        }

        @JavascriptInterface
        public void insertSchool(String sch_name, String sch_district, String sch_community,
                                 String schquestion4, String schquestion5, String schquestion6, String schquestion7,
                                 String schquestion8, String schquestion9, String schquestion10, String schquestion11,
                                 String schquestion12, String schquestion13, String schquestion14, String schquestion15,
                                 String schquestion16, String schquestion17, String schquestion18, String schquestion19,
                                 String schquestion20, String schquestion21, String schquestion22, String schquestion23,
                                 String schquestion24, String schquestion25, String schquestion26, String schquestion27,
                                 String schquestion28, String schquestion29, String schquestion30, String schquestion31,
                                 String schquestion32, String schquestion33, String schquestion34, String sch_location,
                                 String farmer_photo, String signature) {

            schquestion28 = schquestion28 == null || schquestion28.equals("undefined") ? "" : schquestion28;

            String userFname = preferenceHelper.getFirstName();
            String userLname = preferenceHelper.getLastName();
            String userEmail = preferenceHelper.getEmail();
            String onCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String onUpdate = onCreate;

            // Use captured URIs if available
            if (farmerPhotoUri != null) farmer_photo = farmerPhotoUri.toString();

            boolean success = dbHelper.insertSchool(sch_name, sch_district, sch_community,
                    schquestion4, schquestion5, schquestion6, schquestion7, schquestion8, schquestion9, schquestion10,
                    schquestion11, schquestion12, schquestion13, schquestion14, schquestion15, schquestion16, schquestion17,
                    schquestion18, schquestion19, schquestion20, schquestion21, schquestion22, schquestion23, schquestion24,
                    schquestion25, schquestion26, schquestion27, schquestion28, schquestion29, schquestion30, schquestion31,
                    schquestion32, schquestion33, schquestion34, sch_location, farmer_photo, signature, userFname, userLname,
                    userEmail, onCreate, onUpdate);

            Log.d("SchoolWebSurveyActivity", "InsertSurveyData called with:");
            Log.d("SchoolWebSurveyActivity", "sch_name: " + sch_name);
            Log.d("SchoolWebSurveyActivity", "user_lname: " + sch_district);
            Log.d("SchoolWebSurveyActivity", "sch_community: " + sch_community);
            Log.d("SchoolWebSurveyActivity", "sch_location: " + sch_location);
            Log.d("SchoolWebSurveyActivity", "farmer_photo: " + farmer_photo);
            Log.d("SchoolWebSurveyActivity", "signature: " + signature);
            Log.d("SchoolWebSurveyActivity", "on_create: " + onCreate);
            Log.d("SchoolWebSurveyActivity", "on_update: " + onUpdate);

            if (success) {
                Log.d("SchoolWebSurveyActivity", "Data inserted successfully");
            } else {
                Log.e("SchoolWebSurveyActivity", "Failed to insert data");
            }
        }

        @JavascriptInterface
        public void completeSurvey() {
            Intent intent = new Intent(context, SchoolSurveyCompletedActivity.class);
            context.startActivity(intent);
            finish();
        }

        @JavascriptInterface
        public void openLocationActivity() {
            Intent intent = new Intent(context, GetSchLocationActivity.class);
            locationLauncher.launch(intent);
        }

        @JavascriptInterface
        public void openFarmerPhotoActivity() {
            Intent intent = new Intent(context, GetSchPhotoActivity.class);
            photoFarmerLauncher.launch(intent);
        }
    }

    @Override
    protected void onDestroy() {
        if (schSurveyWebView != null) {
            schSurveyWebView.destroy();
        }
        super.onDestroy();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.sch_survey);
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
                    if (schSurveyWebView.canGoBack()) {
                        schSurveyWebView.goBack();
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
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .setCancelable(false)
                .show();
    }
}