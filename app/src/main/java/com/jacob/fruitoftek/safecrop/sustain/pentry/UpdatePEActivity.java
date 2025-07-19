package com.jacob.fruitoftek.safecrop.sustain.pentry;

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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;
import com.jacob.fruitoftek.safecrop.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;

import com.jacob.fruitoftek.safecrop.comdev.ComDevDashboard;

public class UpdatePEActivity extends AppCompatActivity {
    
    private WebView schSurveyWebView;
    private ProgressBar peProgressBar; // ProgressBar instance
    private PeDbHelper dbHelper;
    private PeModel peModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_peactivity);

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

        dbHelper = new PeDbHelper(this);

        schSurveyWebView = findViewById(R.id.peWebView);
        peProgressBar = findViewById(R.id.peProgressBar); // Initialize ProgressBar

        schSurveyWebView.getSettings().setJavaScriptEnabled(true);
        schSurveyWebView.addJavascriptInterface(new WebAppInterface(), "Android");

        // Set WebViewClient with ProgressBar handling
        schSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                peProgressBar.setVisibility(View.VISIBLE); // Show ProgressBar
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                peProgressBar.setVisibility(View.GONE); // Hide ProgressBar
            }
        });

        schSurveyWebView.loadUrl("file:///android_asset/sch/edit_sch.html");

        // Retrieve the PeModel from the intent
        peModel = getIntent().getParcelableExtra("sch_model");
        if (peModel == null) {
            Toast.makeText(this, "No school data available.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public class WebAppInterface {
        @JavascriptInterface
        public String getSavedData() {
            return new Gson().toJson(peModel);
        }

        @JavascriptInterface
        public void saveUpdatedData(String pequestion1, String pequestion2, String pequestion3, String pequestion4,
                                    String pequestion5, String pequestion6, String pequestion7, String pequestion8,
                                    String pequestion9, String pequestion10, String pequestion11, String pequestion12,
                                    String pequestion13) {
            peModel.setPequestion1(pequestion1);
            peModel.setPequestion2(pequestion2);
            peModel.setPequestion3(pequestion3);
            peModel.setPequestion4(pequestion4);
            peModel.setPequestion5(pequestion5);
            peModel.setPequestion6(pequestion6);
            peModel.setPequestion7(pequestion7);
            peModel.setPequestion8(pequestion8);
            peModel.setPequestion9(pequestion9);
            peModel.setPequestion10(pequestion10);
            peModel.setPequestion11(pequestion11);
            peModel.setPequestion12(pequestion12);
            peModel.setPequestion13(pequestion13);

            boolean success = dbHelper.updatePE(
                    String.valueOf(peModel.getId()),
                    pequestion1, pequestion2, pequestion3, pequestion4, pequestion5, pequestion6,
                    pequestion7, pequestion8, pequestion9, pequestion10, pequestion11, pequestion12,
                    pequestion13
            );

            if (success) {
                // Redirect to PEnteryCompletedActivity
                runOnUiThread(() -> {
                    Toast.makeText(UpdatePEActivity.this, "Data updated successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdatePEActivity.this, PEnteryCompletedActivity.class);
                    startActivity(intent);
                    finish(); // Close the current activity
                });
            } else {
                runOnUiThread(() -> Toast.makeText(UpdatePEActivity.this, "Failed to update data.", Toast.LENGTH_SHORT).show());
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