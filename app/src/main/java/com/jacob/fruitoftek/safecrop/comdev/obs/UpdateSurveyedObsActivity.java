package com.jacob.fruitoftek.safecrop.comdev.obs;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;

import com.google.gson.Gson;

public class UpdateSurveyedObsActivity extends AppCompatActivity {

    private WebView obsSurveyWebView;
    private ProgressBar obsProgressBar; // ProgressBar instance
    private ObsDbHelper dbHelper;
    private ObsModel obsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_surveyed_obs);
        
        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        dbHelper = new ObsDbHelper(this);

        obsSurveyWebView = findViewById(R.id.obsWebView);
        obsProgressBar = findViewById(R.id.obsProgressBar); // Initialize ProgressBar

        obsSurveyWebView.getSettings().setJavaScriptEnabled(true);
        obsSurveyWebView.addJavascriptInterface(new WebAppInterface(), "Android");

        // Set WebViewClient with ProgressBar handling
        obsSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                obsProgressBar.setVisibility(View.VISIBLE); // Show ProgressBar
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                obsProgressBar.setVisibility(View.GONE); // Hide ProgressBar
            }
        });

        obsSurveyWebView.loadUrl("file:///android_asset/obs/edit_obs.html");

        // Retrieve the SchoolModel from the intent
        obsModel = getIntent().getParcelableExtra("obs_model");
        if (obsModel == null) {
            Toast.makeText(this, "No Observed data available.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public class WebAppInterface {
        @JavascriptInterface
        public String getSavedData() {
            return new Gson().toJson(obsModel);
        }

        @JavascriptInterface
        public void saveUpdatedData(String obsName, String obsDistrict, String obsCommunity,
                                    String obsquestion6, String obsquestion7, String obsquestion8, String obsquestion9,
                                    String obsquestion10, String obsquestion11, String obsquestion12, String obsquestion13,
                                    String obsquestion14, String obsquestion15, String obsquestion16, String obsquestion17,
                                    String obsquestion18, String obsquestion19, String obsquestion20, String obsquestion21,
                                    String obsLocation) {
            obsModel.setObs_name(obsName);
            obsModel.setObs_district(obsDistrict);
            obsModel.setObs_community(obsCommunity);
            obsModel.setObsquestion6(obsquestion6);
            obsModel.setObsquestion7(obsquestion7);
            obsModel.setObsquestion8(obsquestion8);
            obsModel.setObsquestion9(obsquestion9);
            obsModel.setObsquestion10(obsquestion10);
            obsModel.setObsquestion11(obsquestion11);
            obsModel.setObsquestion12(obsquestion12);
            obsModel.setObsquestion13(obsquestion13);
            obsModel.setObsquestion14(obsquestion14);
            obsModel.setObsquestion15(obsquestion15);
            obsModel.setObsquestion16(obsquestion16);
            obsModel.setObsquestion17(obsquestion17);
            obsModel.setObsquestion18(obsquestion18);
            obsModel.setObsquestion19(obsquestion19);
            obsModel.setObsquestion20(obsquestion20);
            obsModel.setObsquestion21(obsquestion21);
            obsModel.setObs_location(obsLocation);

            boolean success = dbHelper.updateObs(
                    String.valueOf(obsModel.getId()),
                    obsName, obsDistrict, obsCommunity,
                    obsquestion6, obsquestion7, obsquestion8, obsquestion9, obsquestion10, obsquestion11,
                    obsquestion12, obsquestion13, obsquestion14, obsquestion15, obsquestion16, obsquestion17,
                    obsquestion18, obsquestion19, obsquestion20, obsquestion21, obsLocation
            );

            if (success) {
                // Redirect to SchoolSurveyCompletedActivity
                runOnUiThread(() -> {
                    Toast.makeText(UpdateSurveyedObsActivity.this, "Data updated successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateSurveyedObsActivity.this, ObsSurveyCompletedActivity.class);
                    startActivity(intent);
                    finish(); // Close the current activity
                });
            } else {
                runOnUiThread(() -> Toast.makeText(UpdateSurveyedObsActivity.this, "Failed to update data.", Toast.LENGTH_SHORT).show());
            }
        }
    }

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
                .setPositiveButton("Yes", (dialog, which) -> {
                    Intent intent = new Intent(UpdateSurveyedObsActivity.this, ObservationWebListFarmersActivity.class);
                    startActivity(intent);
                    finish(); // Finish AddStudentActivity
                })
                .setNegativeButton("No", null) // Dismiss the dialog
                .setCancelable(false)
                .show();
    }
}