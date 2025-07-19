package com.jacob.fruitoftek.safecrop.comdev.sch;

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

public class UpdateSurveyedSchoolsActivity extends AppCompatActivity {

    private WebView schSurveyWebView;
    private ProgressBar schProgressBar; // ProgressBar instance
    private SchoolDbHelper dbHelper;
    private SchoolModel schoolModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_surveyed_schools);

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

        schSurveyWebView = findViewById(R.id.schoolWebView);
        schProgressBar = findViewById(R.id.schProgressBar); // Initialize ProgressBar

        schSurveyWebView.getSettings().setJavaScriptEnabled(true);
        schSurveyWebView.addJavascriptInterface(new WebAppInterface(), "Android");

        // Set WebViewClient with ProgressBar handling
        schSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                schProgressBar.setVisibility(View.VISIBLE); // Show ProgressBar
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                schProgressBar.setVisibility(View.GONE); // Hide ProgressBar
            }
        });

        schSurveyWebView.loadUrl("file:///android_asset/sch/edit_sch.html");

        // Retrieve the SchoolModel from the intent
        schoolModel = getIntent().getParcelableExtra("sch_model");
        if (schoolModel == null) {
            Toast.makeText(this, "No school data available.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public class WebAppInterface {
        @JavascriptInterface
        public String getSavedData() {
            return new Gson().toJson(schoolModel);
        }

        @JavascriptInterface
        public void saveUpdatedData(String schName, String schDistrict, String schCommunity,
                                    String schquestion4, String schquestion5, String schquestion6, String schquestion7,
                                    String schquestion8, String schquestion9, String schquestion10, String schquestion11,
                                    String schquestion12, String schquestion13, String schquestion14, String schquestion15,
                                    String schquestion16, String schquestion17, String schquestion18, String schquestion19,
                                    String schquestion20, String schquestion21, String schquestion22, String schquestion23,
                                    String schquestion24, String schquestion25, String schquestion26, String schquestion27,
                                    String schquestion28, String schquestion29, String schquestion30, String schquestion31,
                                    String schquestion32, String schquestion33, String schquestion34, String schLocation) {
            schoolModel.setSch_name(schName);
            schoolModel.setSch_district(schDistrict);
            schoolModel.setSch_community(schCommunity);
            schoolModel.setSchquestion4(schquestion4);
            schoolModel.setSchquestion5(schquestion5);
            schoolModel.setSchquestion6(schquestion6);
            schoolModel.setSchquestion7(schquestion7);
            schoolModel.setSchquestion8(schquestion8);
            schoolModel.setSchquestion9(schquestion9);
            schoolModel.setSchquestion10(schquestion10);
            schoolModel.setSchquestion11(schquestion11);
            schoolModel.setSchquestion12(schquestion12);
            schoolModel.setSchquestion13(schquestion13);
            schoolModel.setSchquestion14(schquestion14);
            schoolModel.setSchquestion15(schquestion15);
            schoolModel.setSchquestion16(schquestion16);
            schoolModel.setSchquestion17(schquestion17);
            schoolModel.setSchquestion18(schquestion18);
            schoolModel.setSchquestion19(schquestion19);
            schoolModel.setSchquestion20(schquestion20);
            schoolModel.setSchquestion21(schquestion21);
            schoolModel.setSchquestion22(schquestion22);
            schoolModel.setSchquestion23(schquestion23);
            schoolModel.setSchquestion24(schquestion24);
            schoolModel.setSchquestion25(schquestion25);
            schoolModel.setSchquestion26(schquestion26);
            schoolModel.setSchquestion27(schquestion27);
            schoolModel.setSchquestion28(schquestion28);
            schoolModel.setSchquestion29(schquestion29);
            schoolModel.setSchquestion30(schquestion30);
            schoolModel.setSchquestion31(schquestion31);
            schoolModel.setSchquestion32(schquestion32);
            schoolModel.setSchquestion33(schquestion33);
            schoolModel.setSchquestion34(schquestion34);
            schoolModel.setSch_location(schLocation);

            boolean success = dbHelper.updateSchool(
                    String.valueOf(schoolModel.getId()),
                    schName, schDistrict, schCommunity, schLocation
            );

            if (success) {
                // Redirect to SchoolSurveyCompletedActivity
                runOnUiThread(() -> {
                    Toast.makeText(UpdateSurveyedSchoolsActivity.this, "Data updated successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateSurveyedSchoolsActivity.this, SchoolSurveyCompletedActivity.class);
                    startActivity(intent);
                    finish(); // Close the current activity
                });
            } else {
                runOnUiThread(() -> Toast.makeText(UpdateSurveyedSchoolsActivity.this, "Failed to update data.", Toast.LENGTH_SHORT).show());
            }
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