package com.jacob.fruitoftek.safecrop.comdev.gra;

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

public class UpdateGraSurveyeActivity extends AppCompatActivity {
    
    private WebView graSurveyWebView;
    private ProgressBar graProgressBar; // ProgressBar instance
    private GraDbHelper dbHelper;
    private GraModel graModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_gra_surveye);
        
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

        graSurveyWebView = findViewById(R.id.graWebView);
        graProgressBar = findViewById(R.id.graProgressBar); // Initialize ProgressBar

        graSurveyWebView.getSettings().setJavaScriptEnabled(true);
        graSurveyWebView.addJavascriptInterface(new WebAppInterface(), "Android");

        // Set WebViewClient with ProgressBar handling
        graSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                graProgressBar.setVisibility(View.VISIBLE); // Show ProgressBar
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                graProgressBar.setVisibility(View.GONE); // Hide ProgressBar
            }
        });

        graSurveyWebView.loadUrl("file:///android_asset/genderra/edit_gra.html");

        // Retrieve the GraoolModel from the intent
        graModel = getIntent().getParcelableExtra("sch_model");
        if (graModel == null) {
            Toast.makeText(this, "No school data available.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public class WebAppInterface {
        @JavascriptInterface
        public String getSavedData() {
            return new Gson().toJson(graModel);
        }

        @JavascriptInterface
        public void saveUpdatedData(String graquestion1, String graquestion2, String graquestion3, String graquestion4,
                                    String graquestion5, String graquestion6, String graquestion7, String graquestion8,
                                    String gra_location) {
            graModel.setGraquestion1(graquestion1);
            graModel.setGraquestion2(graquestion2);
            graModel.setGraquestion3(graquestion3);
            graModel.setGraquestion4(graquestion4);
            graModel.setGraquestion5(graquestion5);
            graModel.setGraquestion6(graquestion6);
            graModel.setGraquestion7(graquestion7);
            graModel.setGraquestion8(graquestion8);
            graModel.setGra_location(gra_location);

            boolean success = dbHelper.updateGra(
                    String.valueOf(graModel.getId()),
                    graquestion1, graquestion2, graquestion3, graquestion4, graquestion5, graquestion6,
                    graquestion7, graquestion8, gra_location
            );

            if (success) {
                // Redirect to GraoolSurveyCompletedActivity
                runOnUiThread(() -> {
                    Toast.makeText(UpdateGraSurveyeActivity.this, "Data updated successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateGraSurveyeActivity.this, GraSurveyCompletedActivity.class);
                    startActivity(intent);
                    finish(); // Close the current activity
                });
            } else {
                runOnUiThread(() -> Toast.makeText(UpdateGraSurveyeActivity.this, "Failed to update data.", Toast.LENGTH_SHORT).show());
            }
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
                    Intent intent = new Intent(UpdateGraSurveyeActivity.this, ComDevDashboard.class);
                    startActivity(intent);
                    finish(); // Finish AddStudentActivity
                })
                .setNegativeButton("No", null) // Dismiss the dialog
                .setCancelable(false)
                .show();
    }
}