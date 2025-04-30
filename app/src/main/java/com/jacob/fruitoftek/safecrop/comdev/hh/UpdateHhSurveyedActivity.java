package com.jacob.fruitoftek.safecrop.comdev.hh;

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

public class UpdateHhSurveyedActivity extends AppCompatActivity {

    private WebView hhSurveyWebView;
    private ProgressBar hhProgressBar; // ProgressBar instance
    private HhDbHelper dbHelper;
    private HhModel hhModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_hh_surveyed);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        dbHelper = new HhDbHelper(this);

        hhSurveyWebView = findViewById(R.id.hhWebView);
        hhProgressBar = findViewById(R.id.hhProgressBar); // Initialize ProgressBar

        hhSurveyWebView.getSettings().setJavaScriptEnabled(true);
        hhSurveyWebView.addJavascriptInterface(new WebAppInterface(), "Android");

        // Set WebViewClient with ProgressBar handling
        hhSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                hhProgressBar.setVisibility(View.VISIBLE); // Show ProgressBar
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hhProgressBar.setVisibility(View.GONE); // Hide ProgressBar
            }
        });

        hhSurveyWebView.loadUrl("file:///android_asset/hh/edit_hh.html");

        // Retrieve the SchoolModel from the intent
        hhModel = getIntent().getParcelableExtra("hh_model");
        if (hhModel == null) {
            Toast.makeText(this, "No household data available.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public class WebAppInterface {
        @JavascriptInterface
        public String getSavedData() {
            return new Gson().toJson(hhModel);
        }

        @JavascriptInterface
        public void saveUpdatedData(String hhName, String hhDistrict, String hhCommunity,
                                    String hhquestion4, String hhquestion5, String hhquestion6, String hhquestion7,
                                    String hhquestion8, String hhquestion9, String hhquestion10, String hhquestion11,
                                    String hhquestion12, String hhquestion13, String hhquestion14, String hhquestion15,
                                    String hhquestion16, String hhquestion17, String hhquestion18, String hhquestion19,
                                    String hhquestion20, String hhquestion21, String hhquestion22, String hhquestion23,
                                    String hhquestion24, String hhquestion25, String hhquestion26, String hhquestion27,
                                    String hhquestion28, String hhquestion29, String hhquestion30, String hhquestion31,
                                    String hhquestion32, String hhquestion36, String hhquestion37, String hhLocation) {
            hhModel.setHh_name(hhName);
            hhModel.setHh_district(hhDistrict);
            hhModel.setHh_community(hhCommunity);
            hhModel.setHhquestion4(hhquestion4);
            hhModel.setHhquestion5(hhquestion5);
            hhModel.setHhquestion6(hhquestion6);
            hhModel.setHhquestion7(hhquestion7);
            hhModel.setHhquestion8(hhquestion8);
            hhModel.setHhquestion9(hhquestion9);
            hhModel.setHhquestion10(hhquestion10);
            hhModel.setHhquestion11(hhquestion11);
            hhModel.setHhquestion12(hhquestion12);
            hhModel.setHhquestion13(hhquestion13);
            hhModel.setHhquestion14(hhquestion14);
            hhModel.setHhquestion15(hhquestion15);
            hhModel.setHhquestion16(hhquestion16);
            hhModel.setHhquestion17(hhquestion17);
            hhModel.setHhquestion18(hhquestion18);
            hhModel.setHhquestion19(hhquestion19);
            hhModel.setHhquestion20(hhquestion20);
            hhModel.setHhquestion21(hhquestion21);
            hhModel.setHhquestion22(hhquestion22);
            hhModel.setHhquestion23(hhquestion23);
            hhModel.setHhquestion24(hhquestion24);
            hhModel.setHhquestion25(hhquestion25);
            hhModel.setHhquestion26(hhquestion26);
            hhModel.setHhquestion27(hhquestion27);
            hhModel.setHhquestion28(hhquestion28);
            hhModel.setHhquestion29(hhquestion29);
            hhModel.setHhquestion30(hhquestion30);
            hhModel.setHhquestion31(hhquestion31);
            hhModel.setHhquestion32(hhquestion32);
            hhModel.setHhquestion36(hhquestion36);
            hhModel.setHhquestion37(hhquestion37);
            hhModel.setHh_location(hhLocation);

            boolean success = dbHelper.updateHh(
                    String.valueOf(hhModel.getId()),
                    hhName, hhDistrict, hhCommunity,
                    hhquestion4, hhquestion5, hhquestion6, hhquestion7, hhquestion8, hhquestion9, hhquestion10,
                    hhquestion11, hhquestion12, hhquestion13, hhquestion14, hhquestion15, hhquestion16, hhquestion17,
                    hhquestion18, hhquestion19, hhquestion20, hhquestion21, hhquestion22, hhquestion23, hhquestion24,
                    hhquestion25, hhquestion26, hhquestion27, hhquestion28, hhquestion29, hhquestion30, hhquestion31,
                    hhquestion32, hhquestion36, hhquestion37, hhLocation
            );

            if (success) {
                // Redirect to SchoolSurveyCompletedActivity
                runOnUiThread(() -> {
                    Toast.makeText(UpdateHhSurveyedActivity.this, "Data updated successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateHhSurveyedActivity.this, HhSurveyCompletedActivity.class);
                    startActivity(intent);
                    finish(); // Close the current activity
                });
            } else {
                runOnUiThread(() -> Toast.makeText(UpdateHhSurveyedActivity.this, "Failed to update data.", Toast.LENGTH_SHORT).show());
            }
        }
    }

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
                    Intent intent = new Intent(UpdateHhSurveyedActivity.this, ComDevDashboard.class);
                    startActivity(intent);
                    finish(); // Finish AddStudentActivity
                })
                .setNegativeButton("No", null) // Dismiss the dialog
                .setCancelable(false)
                .show();
    }
}