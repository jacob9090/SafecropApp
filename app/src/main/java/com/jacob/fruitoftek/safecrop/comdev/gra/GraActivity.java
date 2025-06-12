package com.jacob.fruitoftek.safecrop.comdev.gra;

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

public class GraActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;
    private WebView graSurveyWebView;
    private GraDbHelper dbHelper;
    private ProgressBar graProgressBar;
    private ActivityResultLauncher<Intent> locationLauncher;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;

    private Uri farmerPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gra);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        dbHelper = new GraDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);

        graSurveyWebView = findViewById(R.id.graWebView);
        graProgressBar = findViewById(R.id.graProgressBar);

        graSurveyWebView.getSettings().setJavaScriptEnabled(true);
        graSurveyWebView.addJavascriptInterface(new GraActivity.WebAppInterface(this), "Android");

        // Add WebViewClient to handle progress
        graSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                graProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                graProgressBar.setVisibility(View.GONE);
            }
        });

        graSurveyWebView.loadUrl("file:///android_asset/genderra/add_gra.html");

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            graSurveyWebView.evaluateJavascript("updateGraLocation('" + location + "');", null);
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
                            graSurveyWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                            Log.d("CommunityWebSurveyActivity", "Captured Farmer Photo: " + farmerPhotoUri);
                        }
                    }
                }
        );

    }

    // JavaScript interface
    public class WebAppInterface {
        Context context;
        GraDbHelper dbHelper;

        WebAppInterface(Context c) {
            context = c;
            dbHelper = new GraDbHelper(context);
        }

        @JavascriptInterface
        public void insertGra(String graquestion1, String graquestion2, String graquestion3, String graquestion4, 
                              String graquestion5, String graquestion6, String graquestion7, String graquestion8,
                              String gra_location, String farmer_photo, String signature) {

            String userFname = preferenceHelper.getFirstName();
            String userLname = preferenceHelper.getLastName();
            String userEmail = preferenceHelper.getEmail();
            String onCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String onUpdate = onCreate;

            // Use captured URIs if available
            if (farmerPhotoUri != null) farmer_photo = farmerPhotoUri.toString();

            boolean success = dbHelper.insertGra(graquestion1, graquestion2, graquestion3, graquestion4,
                    graquestion5, graquestion6, graquestion7, graquestion8, gra_location, farmer_photo,
                    signature, userFname, userLname, userEmail, onCreate, onUpdate);

            Log.d("GraActivity", "InsertSurveyData called with:");
            Log.d("GraActivity", "graquestion1: " + graquestion1);
            Log.d("GraActivity", "graquestion2: " + graquestion2);
            Log.d("GraActivity", "graquestion3: " + graquestion3);
            Log.d("GraActivity", "signature: " + signature);
            Log.d("GraActivity", "on_create: " + onCreate);
            Log.d("GraActivity", "on_update: " + onUpdate);

            if (success) {
                Log.d("GraActivity", "Data inserted successfully");
            } else {
                Log.e("GraActivity", "Failed to insert data");
            }
        }

        @JavascriptInterface
        public void completeSurvey() {
            Intent intent = new Intent(context, GraSurveyCompletedActivity.class);
            context.startActivity(intent);
            finish();
        }

        @JavascriptInterface
        public void openLocationActivity() {
            Intent intent = new Intent(context, GetGraLocationActivity.class);
            locationLauncher.launch(intent);
        }

        @JavascriptInterface
        public void openFarmerPhotoActivity() {
            Intent intent = new Intent(context, GetGraPhotoActivity.class);
            photoFarmerLauncher.launch(intent);
        }
    }

    @Override
    protected void onDestroy() {
        if (graSurveyWebView != null) {
            graSurveyWebView.destroy();
        }
        super.onDestroy();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.community_assessment);
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
                    if (graSurveyWebView.canGoBack()) {
                        graSurveyWebView.goBack();
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
                    Intent intent = new Intent(GraActivity.this, ComDevDashboard.class);
                    startActivity(intent);
                    finish(); // Finish AddStudentActivity
                })
                .setNegativeButton("No", null) // Dismiss the dialog
                .setCancelable(false)
                .show();
    }
}