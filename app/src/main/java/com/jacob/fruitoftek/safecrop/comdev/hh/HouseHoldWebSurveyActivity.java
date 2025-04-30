package com.jacob.fruitoftek.safecrop.comdev.hh;

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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HouseHoldWebSurveyActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;
    private WebView hhSurveyWebView;
    private HhDbHelper dbHelper;
    private ProgressBar hhProgressBar;
    private ActivityResultLauncher<Intent> locationLauncher;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;

    private Uri farmerPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_house_hold_web_survey);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        // Initialize PreferenceHelper
        injectDependencies();

        // Retrieve passed data from intent
        Intent intent = getIntent();
        String farmerId = intent.getStringExtra("hh_name");
        String farmerDistrict = intent.getStringExtra("hh_district");
        String farmerVillage = intent.getStringExtra("hh_community");
        
        dbHelper = new HhDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);

        hhSurveyWebView = findViewById(R.id.householdWebView);
        hhProgressBar = findViewById(R.id.hhProgressBar);

        hhSurveyWebView.getSettings().setJavaScriptEnabled(true);
        hhSurveyWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        // Add WebViewClient to handle progress
        hhSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                hhProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                hhProgressBar.setVisibility(View.GONE);
                injectFarmerData();
            }
        });

        hhSurveyWebView.loadUrl("file:///android_asset/hh/add_hh.html");

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            hhSurveyWebView.evaluateJavascript("updateComLocation('" + location + "');", null);
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
                            hhSurveyWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                            Log.d("HouseHoldWebSurveyActivity", "Captured Farmer Photo: " + farmerPhotoUri);
                        }
                    }
                }
        );
    }

    // JavaScript interface for launching activities
    public class WebAppInterface {
        Context context;
        HhDbHelper dbHelper;

        WebAppInterface(Context c) {
            context = c;
            dbHelper = new HhDbHelper(context);
        }
        
        @JavascriptInterface
        public void insertHh(String hh_name, String hh_district, String hh_community,
                             String hhquestion4, String hhquestion5, String hhquestion6, String hhquestion7,
                             String hhquestion8, String hhquestion9, String hhquestion10, String hhquestion11,
                             String hhquestion12, String hhquestion13, String hhquestion14, String hhquestion15,
                             String hhquestion16, String hhquestion17, String hhquestion18, String hhquestion19,
                             String hhquestion20, String hhquestion21, String hhquestion22, String hhquestion23,
                             String hhquestion24, String hhquestion25, String hhquestion26, String hhquestion27,
                             String hhquestion28, String hhquestion29, String hhquestion30, String hhquestion31,
                             String hhquestion32, String hhquestion36, String hhquestion37, String hh_location,
                             String farmer_photo, String signature) {

            String userFname = preferenceHelper.getFirstName();
            String userOname = preferenceHelper.getLastName();
            String userEmail = preferenceHelper.getEmail();
            String onCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String onUpdate = onCreate;

            // Use captured URIs if available
            if (farmerPhotoUri != null) farmer_photo = farmerPhotoUri.toString();

            boolean success = dbHelper.insertHh(hh_name, hh_district, hh_community,
                    hhquestion4, hhquestion5, hhquestion6, hhquestion7, hhquestion8, hhquestion9, hhquestion10,
                    hhquestion11, hhquestion12, hhquestion13, hhquestion14, hhquestion15, hhquestion16, hhquestion17,
                    hhquestion18, hhquestion19, hhquestion20, hhquestion21, hhquestion22, hhquestion23, hhquestion24,
                    hhquestion25, hhquestion26, hhquestion27, hhquestion28, hhquestion29, hhquestion30, hhquestion31,
                    hhquestion32, hhquestion36, hhquestion37, hh_location, farmer_photo, signature, userFname,
                    userOname, userEmail, onCreate, onUpdate);

            Log.d("HouseHoldWebSurveyActivity", "InsertSurveyData called with:");
            Log.d("HouseHoldWebSurveyActivity", "hh_name: " + hh_name);
            Log.d("HouseHoldWebSurveyActivity", "user_oname: " + hh_district);
            Log.d("HouseHoldWebSurveyActivity", "hh_community: " + hh_community);
            Log.d("HouseHoldWebSurveyActivity", "hhquestion4: " + hhquestion4);
            Log.d("HouseHoldWebSurveyActivity", "hh_location: " + hh_location);
            Log.d("HouseHoldWebSurveyActivity", "farmer_photo: " + farmer_photo);
            Log.d("HouseHoldWebSurveyActivity", "signature: " + signature);
            Log.d("HouseHoldWebSurveyActivity", "on_create: " + onCreate);
            Log.d("HouseHoldWebSurveyActivity", "on_update: " + onUpdate);

            if (success) {
                Log.d("HouseHoldWebSurveyActivity", "Data inserted successfully");
            } else {
                Log.e("HouseHoldWebSurveyActivity", "Failed to insert data");
            }
        }

        @JavascriptInterface
        public void completeSurvey() {
            Intent intent = new Intent(context, HhSurveyCompletedActivity.class);
            context.startActivity(intent);
            finish();
        }

        @JavascriptInterface
        public void openLocationActivity() {
            Intent intent = new Intent(context, GetHhLocationActivity.class);
            locationLauncher.launch(intent);
        }

        @JavascriptInterface
        public void openFarmerPhotoActivity() {
            Intent intent = new Intent(context, GetHhPhotoActivity.class);
            photoFarmerLauncher.launch(intent);
        }
        
    }

    private void injectFarmerData() {
        Intent intent = getIntent();
        String farmerId = intent.getStringExtra("hh_name");
        String farmerDistrict = intent.getStringExtra("hh_district");
        String farmerVillage = intent.getStringExtra("hh_community");

        String jsCode = String.format(
                "populateSurveyFields('%s', '%s', '%s');",
                farmerId, farmerDistrict, farmerVillage
        );
        hhSurveyWebView.evaluateJavascript(jsCode, null);
    }

    private void injectDependencies() {
        preferenceHelper = new PreferenceHelper(this);
    }

    private <T> T requireNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException("Required value was null.");
        }
        return obj;
    }

    // Clean up WebView resources
    @Override
    protected void onDestroy() {
        if (hhSurveyWebView != null) {
            hhSurveyWebView.destroy();
        }
        super.onDestroy();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.household_survey);
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
                    if (hhSurveyWebView.canGoBack()) {
                        hhSurveyWebView.goBack();
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
                    Intent intent = new Intent(HouseHoldWebSurveyActivity.this, HouseHoldWebListFarmersActivity.class);
                    startActivity(intent);
                    finish(); // Finish AddStudentActivity
                })
                .setNegativeButton("No", null) // Dismiss the dialog
                .setCancelable(false)
                .show();
    }
}