package com.jacob.fruitoftek.safecrop.comdev.com;

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

public class CommunityWebSurveyActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;
    private WebView comSurveyWebView;
    private ComDbHelper dbHelper;
    private ProgressBar comProgressBar;
    private ActivityResultLauncher<Intent> locationLauncher;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;

    private Uri farmerPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community_web_survey);

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

        dbHelper = new ComDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);

        comSurveyWebView = findViewById(R.id.comWebView);
        comProgressBar = findViewById(R.id.comProgressBar);

        comSurveyWebView.getSettings().setJavaScriptEnabled(true);
        comSurveyWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        // Add WebViewClient to handle progress
        comSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                comProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                comProgressBar.setVisibility(View.GONE);
            }
        });

        comSurveyWebView.loadUrl("file:///android_asset/com/add_com.html");

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            comSurveyWebView.evaluateJavascript("updateComLocation('" + location + "');", null);
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
                            comSurveyWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                            Log.d("CommunityWebSurveyActivity", "Captured Farmer Photo: " + farmerPhotoUri);
                        }
                    }
                }
        );
    }

    // JavaScript interface for launching activities
    public class WebAppInterface {
        Context context;
        ComDbHelper dbHelper;

        WebAppInterface(Context c) {
            context = c;
            dbHelper = new ComDbHelper(context);
        }

        @JavascriptInterface
        public void insertCom(String commquestion1, String commquestion2, String commquestion3, String commquestion4,
                              String commquestion5, String commquestion6, String commquestion7, String commquestion8,
                              String commquestion9, String commquestion10, String commquestion11, String commquestion12,
                              String commquestion13, String commquestion14, String commquestion15, String commquestion16,
                              String commquestion17, String commquestion18, String commquestion19, String commquestion20,
                              String commquestion21, String commquestion22, String commquestion23, String commquestion24,
                              String commquestion25, String commquestion26, String commquestion27, String commquestion28,
                              String commquestion29, String commquestion30, String commquestion31, String commquestion32,
                              String commquestion33, String commquestion34, String commquestion35, String commquestion36,
                              String commquestion37, String commquestion38, String commquestion39, String commquestion40,
                              String commquestion41, String commquestion42, String commquestion43, String commquestion44,
                              String commquestion45, String commquestion46, String commquestion47, String commquestion48,
                              String commquestion49, String commquestion50, String commquestion51, String commquestion52,
                              String commquestion53, String commquestion54, String commquestion56, String commquestion57,
                              String commquestion58, String commquestion59, String commquestion60, String commquestion61,
                              String commquestion62, String commquestion63, String commquestion64, String commquestion65,
                              String commquestion66, String commquestion67, String com_location, String farmer_photo, String signature) {

            commquestion10 = commquestion10 == null || commquestion10.equals("undefined") ? "" : commquestion10;
            commquestion29 = commquestion29 == null || commquestion29.equals("undefined") ? "" : commquestion29;
            commquestion31 = commquestion31 == null || commquestion31.equals("undefined") ? "" : commquestion31;
            commquestion48 = commquestion48 == null || commquestion48.equals("undefined") ? "" : commquestion48;
            commquestion57 = commquestion57 == null || commquestion57.equals("undefined") ? "" : commquestion57;

            String userFname = preferenceHelper.getFirstName();
            String userLname = preferenceHelper.getLastName();
            String userEmail = preferenceHelper.getEmail();
            String onCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String onUpdate = onCreate;

            // Use captured URIs if available
            if (farmerPhotoUri != null) farmer_photo = farmerPhotoUri.toString();

            boolean success = dbHelper.insertCom(commquestion1, commquestion2, commquestion3, commquestion4, commquestion5, commquestion6,
                    commquestion7, commquestion8, commquestion9, commquestion10, commquestion11, commquestion12,
                    commquestion13, commquestion14, commquestion15, commquestion16, commquestion17, commquestion18,
                    commquestion19, commquestion20, commquestion21, commquestion22, commquestion23, commquestion24,
                    commquestion25, commquestion26, commquestion27, commquestion28, commquestion29, commquestion30,
                    commquestion31, commquestion32, commquestion33, commquestion34, commquestion35, commquestion36,
                    commquestion37, commquestion38, commquestion39, commquestion40, commquestion41, commquestion42,
                    commquestion43, commquestion44, commquestion45, commquestion46, commquestion47, commquestion48,
                    commquestion49, commquestion50, commquestion51, commquestion52, commquestion53, commquestion54,
                    commquestion56, commquestion57, commquestion58, commquestion59, commquestion60, commquestion61,
                    commquestion62, commquestion63, commquestion64, commquestion65, commquestion66, commquestion67,
                    com_location, farmer_photo, signature, userFname, userLname, userEmail, onCreate, onUpdate);

            Log.d("CommunityWebSurveyActivity", "InsertSurveyData called with:");
            Log.d("CommunityWebSurveyActivity", "commquestion1: " + commquestion1);
            Log.d("CommunityWebSurveyActivity", "commquestion10: " + commquestion10);
            Log.d("CommunityWebSurveyActivity", "commquestion29: " + commquestion29);
            Log.d("CommunityWebSurveyActivity", "commquestion31: " + commquestion31);
            Log.d("CommunityWebSurveyActivity", "commquestion57: " + commquestion57);
            Log.d("CommunityWebSurveyActivity", "userEmail: " + userEmail);
            Log.d("CommunityWebSurveyActivity", "com_location: " + com_location);
            Log.d("CommunityWebSurveyActivity", "farmer_photo: " + farmer_photo);
            Log.d("CommunityWebSurveyActivity", "signature: " + signature);
            Log.d("CommunityWebSurveyActivity", "on_create: " + onCreate);
            Log.d("CommunityWebSurveyActivity", "on_update: " + onUpdate);

            if (success) {
                Log.d("CommunityWebSurveyActivity", "Data inserted successfully");
            } else {
                Log.e("CommunityWebSurveyActivity", "Failed to insert data");
            }
        }

        @JavascriptInterface
        public void completeSurvey() {
            Intent intent = new Intent(context, CommunitySurveyCompletedActivity.class);
            context.startActivity(intent);
            finish();
        }

        @JavascriptInterface
        public void openLocationActivity() {
            Intent intent = new Intent(context, GetComLocationActivity.class);
            locationLauncher.launch(intent);
        }

        @JavascriptInterface
        public void openFarmerPhotoActivity() {
            Intent intent = new Intent(context, GetComPhotoActivity.class);
            photoFarmerLauncher.launch(intent);
        }
    }

    // Clean up WebView resources
    @Override
    protected void onDestroy() {
        if (comSurveyWebView != null) {
            comSurveyWebView.destroy();
        }
        super.onDestroy();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.com_survey);
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
                    if (comSurveyWebView.canGoBack()) {
                        comSurveyWebView.goBack();
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