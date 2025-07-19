package com.jacob.fruitoftek.safecrop.comdev.cra;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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

public class CommunityRiskAssceActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;
    private WebView craSurveyWebView;
    private CraDbHelper dbHelper;
    private ProgressBar craProgressBar;
    
    private ActivityResultLauncher<Intent> locationLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community_risk_assce);

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

        dbHelper = new CraDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);

        craSurveyWebView = findViewById(R.id.craWebView);
        craProgressBar = findViewById(R.id.craProgressBar);

        craSurveyWebView.getSettings().setJavaScriptEnabled(true);
        craSurveyWebView.addJavascriptInterface(new CommunityRiskAssceActivity.WebAppInterface(this), "Android");

        // Add WebViewClient to handle progress
        craSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                craProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                craProgressBar.setVisibility(View.GONE);
            }
        });

        craSurveyWebView.loadUrl("file:///android_asset/comra/add_cra.html");

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            craSurveyWebView.evaluateJavascript("updateCraLocation('" + location + "');", null);
                        }
                    }
                }
        );

    }

    // JavaScript interface
    public class WebAppInterface {
        Context context;
        CraDbHelper dbHelper;

        WebAppInterface(Context c) {
            context = c;
            dbHelper = new CraDbHelper(context);
        }

        @JavascriptInterface
        public void insertCra(String craquestion1, String craquestion2, String craquestion3, String craquestion4,
                              String craquestion5, String craquestion6, String craquestion7, String craquestion8,
                              String craquestion9, String craquestion10, String craquestion11, String craquestion12,
                              String craquestion13, String cra_location, String signature) {

            String userFname = preferenceHelper.getFirstName();
            String userLname = preferenceHelper.getLastName();
            String userEmail = preferenceHelper.getEmail();
            String onCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String onUpdate = onCreate;

            boolean success = dbHelper.insertCra(craquestion1, craquestion2, craquestion3, craquestion4,
                    craquestion5, craquestion6, craquestion7, craquestion8, craquestion9, craquestion10,
                    craquestion11, craquestion12, craquestion13, cra_location, signature, userFname,
                    userLname, userEmail, onCreate, onUpdate);

            Log.d("CommunityRiskAssceActivity", "InsertSurveyData called with:");
            Log.d("CommunityRiskAssceActivity", "craquestion1: " + craquestion1);
            Log.d("CommunityRiskAssceActivity", "craquestion2: " + craquestion2);
            Log.d("CommunityRiskAssceActivity", "craquestion3: " + craquestion3);
            Log.d("CommunityRiskAssceActivity", "signature: " + signature);
            Log.d("CommunityRiskAssceActivity", "on_create: " + onCreate);
            Log.d("CommunityRiskAssceActivity", "on_update: " + onUpdate);

            if (success) {
                Log.d("CommunityRiskAssceActivity", "Data inserted successfully");
            } else {
                Log.e("CommunityRiskAssceActivity", "Failed to insert data");
            }
        }

        @JavascriptInterface
        public void completeSurvey() {
            Intent intent = new Intent(context, CraSurveyCompletedActivity.class);
            context.startActivity(intent);
            finish();
        }

        @JavascriptInterface
        public void openLocationActivity() {
            Intent intent = new Intent(context, GetCraLocationActivity.class);
            locationLauncher.launch(intent);
        }
    }

    @Override
    protected void onDestroy() {
        if (craSurveyWebView != null) {
            craSurveyWebView.destroy();
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
                    if (craSurveyWebView.canGoBack()) {
                        craSurveyWebView.goBack();
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