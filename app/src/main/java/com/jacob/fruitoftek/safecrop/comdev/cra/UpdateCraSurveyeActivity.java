package com.jacob.fruitoftek.safecrop.comdev.cra;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;
import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.comdev.ComDevDashboard;

public class UpdateCraSurveyeActivity extends AppCompatActivity {
    
    private WebView craSurveyWebView;
    private ProgressBar craProgressBar; // ProgressBar instance
    private CraDbHelper dbHelper;
    private CraModel craModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_cra_surveye);
        
        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        dbHelper = new CraDbHelper(this);

        craSurveyWebView = findViewById(R.id.lraWebView);
        craProgressBar = findViewById(R.id.lraProgressBar); // Initialize ProgressBar

        craSurveyWebView.getSettings().setJavaScriptEnabled(true);
        craSurveyWebView.addJavascriptInterface(new WebAppInterface(), "Android");

        // Set WebViewClient with ProgressBar handling
        craSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                craProgressBar.setVisibility(View.VISIBLE); // Show ProgressBar
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                craProgressBar.setVisibility(View.GONE); // Hide ProgressBar
            }
        });

        craSurveyWebView.loadUrl("file:///android_asset/comra/edit_cra.html");

        // Retrieve the GraoolModel from the intent
        craModel = getIntent().getParcelableExtra("sch_model");
        if (craModel == null) {
            Toast.makeText(this, "No data available.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public class WebAppInterface {
        @JavascriptInterface
        public String getSavedData() {
            return new Gson().toJson(craModel);
        }

        @JavascriptInterface
        public void saveUpdatedData(String craquestion1, String craquestion2, String craquestion3, String craquestion4,
                                    String craquestion5, String craquestion6, String craquestion7, String craquestion8,
                                    String craquestion9, String craquestion10, String craquestion11, String craquestion12,
                                    String craquestion13, String cra_location) {
            craModel.setCraquestion1(craquestion1);
            craModel.setCraquestion2(craquestion2);
            craModel.setCraquestion3(craquestion3);
            craModel.setCraquestion4(craquestion4);
            craModel.setCraquestion5(craquestion5);
            craModel.setCraquestion6(craquestion6);
            craModel.setCraquestion7(craquestion7);
            craModel.setCraquestion8(craquestion8);
            craModel.setCraquestion9(craquestion9);
            craModel.setCraquestion10(craquestion10);
            craModel.setCraquestion11(craquestion11);
            craModel.setCraquestion12(craquestion12);
            craModel.setCraquestion13(craquestion13);
            craModel.setCra_location(cra_location);

            boolean success = dbHelper.updateGra(
                    String.valueOf(craModel.getId()),
                    craquestion1, craquestion2, craquestion3, craquestion4, craquestion5, craquestion6,
                    craquestion7, craquestion8, craquestion9, craquestion10, craquestion11, craquestion12,
                    craquestion13, cra_location
            );

            if (success) {
                // Redirect to GraoolSurveyCompletedActivity
                runOnUiThread(() -> {
                    Toast.makeText(UpdateCraSurveyeActivity.this, "Data updated successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateCraSurveyeActivity.this, CraSurveyCompletedActivity.class);
                    startActivity(intent);
                    finish(); // Close the current activity
                });
            } else {
                runOnUiThread(() -> Toast.makeText(UpdateCraSurveyeActivity.this, "Failed to update data.", Toast.LENGTH_SHORT).show());
            }
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
                .setPositiveButton("Yes", (dialog, which) -> {
                    Intent intent = new Intent(UpdateCraSurveyeActivity.this, ComDevDashboard.class);
                    startActivity(intent);
                    finish(); // Finish AddStudentActivity
                })
                .setNegativeButton("No", null) // Dismiss the dialog
                .setCancelable(false)
                .show();
    }
}