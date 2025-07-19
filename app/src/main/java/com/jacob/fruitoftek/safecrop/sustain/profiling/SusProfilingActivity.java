package com.jacob.fruitoftek.safecrop.sustain.profiling;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.os.Looper;

import androidx.appcompat.app.ActionBar;

import androidx.appcompat.app.AlertDialog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.Handler;
import android.widget.Toast;

public class SusProfilingActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;
    private WebView SusProfilingWebView;
    private SusProfilingDbHelper dbHelper;
    private ProgressBar SusProfilingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sus_profiling);

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
        injectDependencies();

        dbHelper = new SusProfilingDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);

        SusProfilingWebView = findViewById(R.id.susProfilingWebView);
        SusProfilingProgressBar = findViewById(R.id.susProfilingProgressBar);

        SusProfilingWebView.getSettings().setJavaScriptEnabled(true);
        SusProfilingWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        SusProfilingWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                SusProfilingProgressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                SusProfilingProgressBar.setVisibility(View.GONE);
                Intent intent = getIntent();
                String farmer_id = intent.getStringExtra("farmer_id");
                String ghana_card_pre = intent.getStringExtra("ghana_card_pre");
                String js = String.format(
                        "populateSurveyFields('%s', '%s');",
                        escapeJs(farmer_id),
                        escapeJs(ghana_card_pre)
                );
                SusProfilingWebView.evaluateJavascript(js, null);
            }
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                SusProfilingProgressBar.setVisibility(View.GONE);
            }
        });

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (SusProfilingProgressBar.getVisibility() == View.VISIBLE) {
                SusProfilingProgressBar.setVisibility(View.GONE);
            }
        }, 5000);

        SusProfilingWebView.loadUrl("file:///android_asset/susprofiling/add_susprofiling.html");
        
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.draft_menu, menu);
        MenuItem draftSurvey = menu.findItem(R.id.draft_menu);
        if (draftSurvey != null) {
            draftSurvey.setOnMenuItemClickListener(menuItem -> {
                new AlertDialog.Builder(SusProfilingActivity.this)
                        .setTitle("Save As Draft")
                        .setMessage("Do you want to save the current inspection as a draft?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            SusProfilingWebView.post(() ->
                                    SusProfilingWebView.evaluateJavascript("saveInspection(true);", null)
                            );
                        })
                        .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                        .setCancelable(false)
                        .show();
                return true;
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    public class WebAppInterface {
        Context context;
        SusProfilingDbHelper dbHelper;
        WebAppInterface(Context c) {
            context = c;
            dbHelper = new SusProfilingDbHelper(context);
        }

        @JavascriptInterface
        public void insertOrUpdateSusProfiling(String farmer_id, String farmer_name, String farmer_gender, String district,
                                               String community, String farmer_dob, String ghana_card, String suspro_question1,
                                               String suspro_question2, String suspro_question3, String suspro_question4,
                                               String suspro_question5, String suspro_question6, String suspro_question7,
                                               String suspro_question8, String suspro_question9, String suspro_question10,
                                               String suspro_question11, String suspro_question12, String suspro_question13,
                                               String suspro_question14, String suspro_question15, String suspro_question16,
                                               String suspro_question17, String suspro_question18, String suspro_question19,
                                               String suspro_question20, String suspro_question21, String suspro_question22,
                                               String suspro_question23, String suspro_question24, String suspro_question25,
                                               String signature, String is_sync, String is_draft) {

            Log.d("WebAppInterface", "--- insertOrUpdateSusProfiling CALLED ---");
            Log.d("WebAppInterface", "Raw input farmer_id: " + farmer_id + ", farmer_name: " + farmer_name + ", is_draft: " + is_draft);
            Log.d("WebAppInterface", "Raw input Q1: " + farmer_gender + ", Q1b: " + district);
            Log.d("WebAppInterface", "Raw input Q2: " + community + ", Q2b: " + farmer_dob);
            Log.d("WebAppInterface", "Raw input Q3: " + ghana_card + ", Q3b: " + suspro_question1);
            Log.d("WebAppInterface", "Raw input location: " + suspro_question2 + ",  signature: " + signature);

            farmer_id = isNull(farmer_id);
            farmer_name = isNull(farmer_name);
            farmer_gender = isNull(farmer_gender);
            district = isNull(district);
            community = isNull(community);
            farmer_dob = isNull(farmer_dob);
            ghana_card = isNull(ghana_card);
            suspro_question1 = isNull(suspro_question1);
            suspro_question2 = isNull(suspro_question2);
            suspro_question3 = isNull(suspro_question3);
            suspro_question4 = isNull(suspro_question4);
            suspro_question5 = isNull(suspro_question5);
            suspro_question6 = isNull(suspro_question6);
            suspro_question7 = isNull(suspro_question7);
            suspro_question8 = isNull(suspro_question8);
            suspro_question9 = isNull(suspro_question9);
            suspro_question10 = isNull(suspro_question10);
            suspro_question11 = isNull(suspro_question11);
            suspro_question12 = isNull(suspro_question12);
            suspro_question13 = isNull(suspro_question13);
            suspro_question14 = isNull(suspro_question14);
            suspro_question15 = isNull(suspro_question15);
            suspro_question16 = isNull(suspro_question16);
            suspro_question17 = isNull(suspro_question17);
            suspro_question18 = isNull(suspro_question18);
            suspro_question19 = isNull(suspro_question19);
            suspro_question20 = isNull(suspro_question20);
            suspro_question21 = isNull(suspro_question21);
            suspro_question22 = isNull(suspro_question22);
            suspro_question23 = isNull(suspro_question23);
            suspro_question24 = isNull(suspro_question24);
            suspro_question25 = isNull(suspro_question25);
            signature = isNull(signature);
            is_sync = "0";

            Log.d("WebAppInterface", "After isNull: farmer_id: " + farmer_id + ", Q1: " + suspro_question1);

            boolean draftMode = "1".equals(is_draft);

            if (!draftMode) {
                if (TextUtils.isEmpty(farmer_id) ||
                        TextUtils.isEmpty(farmer_name) ||
                        TextUtils.isEmpty(farmer_gender) ||
                        TextUtils.isEmpty(district) ||
                        TextUtils.isEmpty(community) ||
                        TextUtils.isEmpty(farmer_dob) ||
                        TextUtils.isEmpty(ghana_card) ||
                        TextUtils.isEmpty(suspro_question1) ||
                        TextUtils.isEmpty(suspro_question2) ||
                        TextUtils.isEmpty(suspro_question3) ||
                        TextUtils.isEmpty(suspro_question4) ||
                        TextUtils.isEmpty(suspro_question5) ||
                        TextUtils.isEmpty(suspro_question6) ||
                        TextUtils.isEmpty(suspro_question7) ||
                        TextUtils.isEmpty(suspro_question8) ||
                        TextUtils.isEmpty(suspro_question9) ||
                        TextUtils.isEmpty(suspro_question10) ||
                        TextUtils.isEmpty(suspro_question11) ||
                        TextUtils.isEmpty(suspro_question12) ||
                        TextUtils.isEmpty(suspro_question13) ||
                        TextUtils.isEmpty(suspro_question14) ||
                        TextUtils.isEmpty(suspro_question15) ||
                        TextUtils.isEmpty(suspro_question16) ||
                        TextUtils.isEmpty(suspro_question17) ||
                        TextUtils.isEmpty(suspro_question18) ||
                        TextUtils.isEmpty(suspro_question19) ||
                        TextUtils.isEmpty(suspro_question20) ||
                        TextUtils.isEmpty(suspro_question21) ||
                        TextUtils.isEmpty(suspro_question22) ||
                        TextUtils.isEmpty(suspro_question23) ||
                        TextUtils.isEmpty(suspro_question24) ||
                        TextUtils.isEmpty(suspro_question25)) {

                    Log.e("WebAppInterface", "Validation FAILED: Required fields are empty for non-draft save.");
                    runOnUiThread(() ->
                            Toast.makeText(context, "All required fields must be filled!", Toast.LENGTH_LONG).show()
                    );
                    SusProfilingWebView.post(() ->
                            SusProfilingWebView.evaluateJavascript("alert('Please fill all required fields!');", null)
                    );
                    return;
                } else {
                    Log.d("WebAppInterface", "Draft mode is ON. Skipping strict validation.");
                }
            }

            String userFname = preferenceHelper.getFirstName();
            String userLname = preferenceHelper.getLastName();
            String userEmail = preferenceHelper.getEmail();

            Log.d("WebAppInterface", "User: " + userFname + " " + userLname + " (" + userEmail + ")");

            String onCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String onUpdate = onCreate;
            
            Log.d("WebAppInterface", "Attempting to insert/update into DB...");
            boolean success = dbHelper.insertOrUpdateSusProfiling(
                    farmer_id, farmer_name, farmer_gender, district, community, farmer_dob, ghana_card,
                    suspro_question1, suspro_question2, suspro_question3, suspro_question4, suspro_question5,
                    suspro_question6, suspro_question7, suspro_question8, suspro_question9, suspro_question10,
                    suspro_question11, suspro_question12, suspro_question13, suspro_question14, suspro_question15,
                    suspro_question16, suspro_question17, suspro_question18, suspro_question19, suspro_question20,
                    suspro_question21, suspro_question22, suspro_question23, suspro_question24, suspro_question25,
                    signature, is_sync, is_draft, userFname, userLname, userEmail, onCreate, onUpdate
            );

            if (success) {
                Log.d("WebAppInterface", "DATABASE INSERT/UPDATE SUCCESS!");
                if ("1".equals(is_draft)) {
                    runOnUiThread(() ->
                            Toast.makeText(context, "Draft saved! You may continue editing.", Toast.LENGTH_LONG).show()
                    );
                }
            } else {
                Log.e("WebAppInterface", "DATABASE INSERT/UPDATE FAILED! Check SusProfilingDbHelper logs.");
                SusProfilingWebView.post(() ->
                        SusProfilingWebView.evaluateJavascript("alert('Failed to save data. Please try again.');", null)
                );
            }
        }

        private String isNull(String s) {
            return (s == null || s.equals("undefined")) ? "" : s;
        }

        @JavascriptInterface
        public void completeSurvey() {
            runOnUiThread(() -> {
                SusProfilingWebView.loadUrl("about:blank");
                SusProfilingWebView.clearHistory();
                SusProfilingWebView.clearCache(true);
                SusProfilingWebView.destroy();
            });

            Intent intent = new Intent(context, SusProfilingCompletedActivity.class);
            context.startActivity(intent);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }, 500);
        }

        @JavascriptInterface
        public void notifyPageLoaded() {
            runOnUiThread(() -> SusProfilingProgressBar.setVisibility(View.GONE));
        }
    }

    private String escapeJs(String s) {
        if (s == null) return "";
        return s.replace("'", "\\'").replace("\n", "\\n").replace("\r", "");
    }

    private void injectDependencies() {
        preferenceHelper = new PreferenceHelper(this);
    }

    @Override
    protected void onDestroy() {
        if (SusProfilingWebView != null) {
            SusProfilingWebView.destroy();
        }
        super.onDestroy();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.farmer_profiling);
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
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (SusProfilingWebView.canGoBack()) {
                    SusProfilingWebView.goBack();
                } else {
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