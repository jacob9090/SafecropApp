package com.jacob.fruitoftek.safecrop.comdev.com;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;

import com.google.gson.Gson;
import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.comdev.ComDevDashboard;

public class UpdateSurveyedCommunitiesActivity extends AppCompatActivity {

    private WebView comSurveyWebView;
    private ProgressBar comProgressBar; // ProgressBar instance
    private ComDbHelper dbHelper;
    private ComModel comModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_surveyed_communities);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        dbHelper = new ComDbHelper(this);

        comSurveyWebView = findViewById(R.id.comWebView);
        comProgressBar = findViewById(R.id.comProgressBar); // Initialize ProgressBar

        comSurveyWebView.getSettings().setJavaScriptEnabled(true);
        comSurveyWebView.addJavascriptInterface(new WebAppInterface(), "Android");

        // Set WebViewClient with ProgressBar handling
        comSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                comProgressBar.setVisibility(View.VISIBLE); // Show ProgressBar
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                comProgressBar.setVisibility(View.GONE); // Hide ProgressBar
            }
        });

        comSurveyWebView.loadUrl("file:///android_asset/com/edit_com.html");

        // Retrieve the ComModel from the intent
        comModel = getIntent().getParcelableExtra("com_model");
        if (comModel == null) {
            Toast.makeText(this, "No community data available.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public class WebAppInterface {
        @JavascriptInterface
        public String getSavedData() {
            return new Gson().toJson(comModel);
        }

        @JavascriptInterface
        public void saveUpdatedData(String commquestion1, String commquestion2, String commquestion3, String commquestion4,
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
                                    String commquestion66, String commquestion67, String comLocation) {
            comModel.setCommquestion1(commquestion1);
            comModel.setCommquestion2(commquestion2);
            comModel.setCommquestion3(commquestion3);
            comModel.setCommquestion4(commquestion4);
            comModel.setCommquestion5(commquestion5);
            comModel.setCommquestion6(commquestion6);
            comModel.setCommquestion7(commquestion7);
            comModel.setCommquestion8(commquestion8);
            comModel.setCommquestion9(commquestion9);
            comModel.setCommquestion10(commquestion10);
            comModel.setCommquestion11(commquestion11);
            comModel.setCommquestion12(commquestion12);
            comModel.setCommquestion13(commquestion13);
            comModel.setCommquestion14(commquestion14);
            comModel.setCommquestion15(commquestion15);
            comModel.setCommquestion16(commquestion16);
            comModel.setCommquestion17(commquestion17);
            comModel.setCommquestion18(commquestion18);
            comModel.setCommquestion19(commquestion19);
            comModel.setCommquestion20(commquestion20);
            comModel.setCommquestion21(commquestion21);
            comModel.setCommquestion22(commquestion22);
            comModel.setCommquestion23(commquestion23);
            comModel.setCommquestion24(commquestion24);
            comModel.setCommquestion25(commquestion25);
            comModel.setCommquestion26(commquestion26);
            comModel.setCommquestion27(commquestion27);
            comModel.setCommquestion28(commquestion28);
            comModel.setCommquestion29(commquestion29);
            comModel.setCommquestion30(commquestion30);
            comModel.setCommquestion31(commquestion31);
            comModel.setCommquestion32(commquestion32);
            comModel.setCommquestion33(commquestion33);
            comModel.setCommquestion34(commquestion34);
            comModel.setCommquestion35(commquestion35);
            comModel.setCommquestion36(commquestion36);
            comModel.setCommquestion37(commquestion37);
            comModel.setCommquestion38(commquestion38);
            comModel.setCommquestion39(commquestion39);
            comModel.setCommquestion40(commquestion40);
            comModel.setCommquestion41(commquestion41);
            comModel.setCommquestion42(commquestion42);
            comModel.setCommquestion43(commquestion43);
            comModel.setCommquestion44(commquestion44);
            comModel.setCommquestion45(commquestion45);
            comModel.setCommquestion46(commquestion46);
            comModel.setCommquestion47(commquestion47);
            comModel.setCommquestion48(commquestion48);
            comModel.setCommquestion49(commquestion49);
            comModel.setCommquestion50(commquestion50);
            comModel.setCommquestion51(commquestion51);
            comModel.setCommquestion52(commquestion52);
            comModel.setCommquestion53(commquestion53);
            comModel.setCommquestion54(commquestion54);
            comModel.setCommquestion56(commquestion56);
            comModel.setCommquestion57(commquestion57);
            comModel.setCommquestion58(commquestion58);
            comModel.setCommquestion59(commquestion59);
            comModel.setCommquestion60(commquestion60);
            comModel.setCommquestion61(commquestion61);
            comModel.setCommquestion62(commquestion62);
            comModel.setCommquestion63(commquestion63);
            comModel.setCommquestion64(commquestion64);
            comModel.setCommquestion65(commquestion65);
            comModel.setCommquestion66(commquestion66);
            comModel.setCommquestion67(commquestion67);
            comModel.setCom_location(comLocation);

            boolean success = dbHelper.updateCom(
                    String.valueOf(comModel.getId()),
                    commquestion1, commquestion2, commquestion3, commquestion4, commquestion5, commquestion6,
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
                    comLocation
            );

            if (success) {
                // Redirect to ComSurveyCompletedActivity
                runOnUiThread(() -> {
                    Toast.makeText(UpdateSurveyedCommunitiesActivity.this, "Data updated successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateSurveyedCommunitiesActivity.this, CommunitySurveyCompletedActivity.class);
                    startActivity(intent);
                    finish(); // Close the current activity
                });
            } else {
                runOnUiThread(() -> Toast.makeText(UpdateSurveyedCommunitiesActivity.this, "Failed to update data.", Toast.LENGTH_SHORT).show());
            }
        }
    }

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
                .setPositiveButton("Yes", (dialog, which) -> {
                    Intent intent = new Intent(UpdateSurveyedCommunitiesActivity.this, ComDevDashboard.class);
                    startActivity(intent);
                    finish(); // Finish AddStudentActivity
                })
                .setNegativeButton("No", null) // Dismiss the dialog
                .setCancelable(false)
                .show();
    }
}