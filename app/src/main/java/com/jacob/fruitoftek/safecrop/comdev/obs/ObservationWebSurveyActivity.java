package com.jacob.fruitoftek.safecrop.comdev.obs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
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

import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ObservationWebSurveyActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;
    private WebView obsSurveyWebView;
    private ObsDbHelper dbHelper;
    private ProgressBar obsProgressBar;
    private ActivityResultLauncher<Intent> locationLauncher;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;

    private Uri farmerPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_observation_web_survey);

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

        // Retrieve passed data from intent
        Intent intent = getIntent();
        String farmer_id = intent.getStringExtra("farmer_id");
        String district = intent.getStringExtra("district");
        String community = intent.getStringExtra("community");
        
        dbHelper = new ObsDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);

        obsSurveyWebView = findViewById(R.id.obsWebView);
        obsProgressBar = findViewById(R.id.obsProgressBar);

        obsSurveyWebView.getSettings().setJavaScriptEnabled(true);
        obsSurveyWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        // Add WebViewClient to handle progress
        obsSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                obsProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                obsProgressBar.setVisibility(View.GONE);
                injectFarmerData();
            }
        });

        obsSurveyWebView.loadUrl("file:///android_asset/obs/add_obs.html");

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            obsSurveyWebView.evaluateJavascript("updateComLocation('" + location + "');", null);
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
                            obsSurveyWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                            Log.d("ObservationWebSurveyActivity", "Captured Farmer Photo: " + farmerPhotoUri);
                        }
                    }
                }
        );
    }

    // JavaScript interface for launching activities
    public class WebAppInterface {
        Context context;
        ObsDbHelper dbHelper;

        WebAppInterface(Context c) {
            context = c;
            dbHelper = new ObsDbHelper(context);
        }
        
        @JavascriptInterface
        public void insertObs(String obs_name, String obs_district, String obs_community,
                              String obsquestion6, String obsquestion7, String obsquestion8, String obsquestion9,
                              String obsquestion10, String obsquestion11, String obsquestion12, String obsquestion13,
                              String obsquestion14, String obsquestion15, String obsquestion16, String obsquestion17,
                              String obsquestion18, String obsquestion19, String obsquestion20, String obsquestion21,
                              String obs_location, String farmer_photo, String signature) {
            String userFname = preferenceHelper.getFirstName();
            String userLname = preferenceHelper.getLastName();
            String userEmail = preferenceHelper.getEmail();
            String onCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String onUpdate = onCreate;

            // Use captured URIs if available
            if (farmerPhotoUri != null) farmer_photo = farmerPhotoUri.toString();

            boolean success = dbHelper.insertObs(obs_name, obs_district, obs_community,
                    obsquestion6, obsquestion7, obsquestion8, obsquestion9, obsquestion10, obsquestion11, obsquestion12,
                    obsquestion13, obsquestion14, obsquestion15, obsquestion16, obsquestion17, obsquestion18,
                    obsquestion19, obsquestion20, obsquestion21, obs_location,
                    farmer_photo, signature, userFname, userLname, userEmail, onCreate, onUpdate);

            Log.d("ObservationWebSurveyActivity", "InsertSurveyData called with:");
            Log.d("ObservationWebSurveyActivity", "obs_name: " + obs_name);
            Log.d("ObservationWebSurveyActivity", "user_lname: " + obs_district);
            Log.d("ObservationWebSurveyActivity", "obs_community: " + obs_community);
            Log.d("ObservationWebSurveyActivity", "obs_location: " + obs_location);
            Log.d("ObservationWebSurveyActivity", "farmer_photo: " + farmer_photo);
            Log.d("ObservationWebSurveyActivity", "signature: " + signature);
            Log.d("ObservationWebSurveyActivity", "on_create: " + onCreate);
            Log.d("ObservationWebSurveyActivity", "on_update: " + onUpdate);

            if (success) {
                Log.d("ObservationWebSurveyActivity", "Data inserted successfully");
            } else {
                Log.e("ObservationWebSurveyActivity", "Failed to insert data");
            }
        }

        @JavascriptInterface
        public void completeSurvey() {
            Intent intent = new Intent(context, ObsSurveyCompletedActivity.class);
            context.startActivity(intent);
            finish();
        }

        @JavascriptInterface
        public void openLocationActivity() {
            Intent intent = new Intent(context, GetObservationLocationActivity.class);
            locationLauncher.launch(intent);
        }

        @JavascriptInterface
        public void openFarmerPhotoActivity() {
            Intent intent = new Intent(context, GetObservationPhotoActivity.class);
            photoFarmerLauncher.launch(intent);
        }
        
    }

    private void injectFarmerData() {
        Intent intent = getIntent();
        String farmer_id = intent.getStringExtra("farmer_id");
        String district = intent.getStringExtra("district");
        String community = intent.getStringExtra("community");

        String jsCode = String.format(
                "populateSurveyFields('%s', '%s', '%s');",
                farmer_id, district, community
        );
        obsSurveyWebView.evaluateJavascript(jsCode, null);
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
        if (obsSurveyWebView != null) {
            obsSurveyWebView.destroy();
        }
        super.onDestroy();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.observation_survey);
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
                    if (obsSurveyWebView.canGoBack()) {
                        obsSurveyWebView.goBack();
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