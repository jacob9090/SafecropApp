package com.jacob.fruitoftek.safecrop.sustain.inspection;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;

import android.app.Activity;
import android.os.Looper;
import android.view.KeyEvent;

import androidx.appcompat.app.ActionBar;

import androidx.appcompat.app.AlertDialog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.Handler;
import android.widget.Toast;

public class InspectionActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;
    private WebView InspectionWebView;
    private InspectionDbHelper dbHelper;
    private ProgressBar InspectionProgressBar;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;
    private ActivityResultLauncher<Intent> locationLauncher;
    private Uri farmerPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inspection);

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

        dbHelper = new InspectionDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);

        InspectionWebView = findViewById(R.id.inspectionWebView);
        InspectionProgressBar = findViewById(R.id.inspectionProgressBar);

        InspectionWebView.getSettings().setJavaScriptEnabled(true);
        InspectionWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        InspectionWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                InspectionProgressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                InspectionProgressBar.setVisibility(View.GONE);
                Intent intent = getIntent();
                String farmer_id = intent.getStringExtra("farmer_id");
                String farmer_name = intent.getStringExtra("farmer_name");
                String district = intent.getStringExtra("district");
                String community = intent.getStringExtra("community");
                String js = String.format(
                        "populateSurveyFields('%s', '%s', '%s', '%s');",
                        escapeJs(farmer_id),
                        escapeJs(farmer_name),
                        escapeJs(district),
                        escapeJs(community)
                );
                InspectionWebView.evaluateJavascript(js, null);
            }
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                InspectionProgressBar.setVisibility(View.GONE);
            }
        });

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (InspectionProgressBar.getVisibility() == View.VISIBLE) {
                InspectionProgressBar.setVisibility(View.GONE);
            }
        }, 5000);

        InspectionWebView.loadUrl("file:///android_asset/inspection/add_inspection.html");

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            InspectionWebView.evaluateJavascript("updateInspectionLocation('" + location + "');", null);
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
                            InspectionWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                        }
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.draft_menu, menu);
        MenuItem draftSurvey = menu.findItem(R.id.draft_menu);
        if (draftSurvey != null) {
            draftSurvey.setOnMenuItemClickListener(menuItem -> {
                new AlertDialog.Builder(InspectionActivity.this)
                        .setTitle("Save As Draft")
                        .setMessage("Do you want to save the current inspection as a draft?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            InspectionWebView.post(() ->
                                    InspectionWebView.evaluateJavascript("saveInspection(true);", null)
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
        InspectionDbHelper dbHelper;
        WebAppInterface(Context c) {
            context = c;
            dbHelper = new InspectionDbHelper(context);
        }

        @JavascriptInterface
        public void insertOrUpdateInspection(String farmer_id, String farmer_name, String district, String community,
                                     String inspection_question1, String inspection_question2, String inspection_question3,
                                     String inspection_question4, String inspection_question5, String inspection_location,
                                     String farmer_photo, String signature, String is_sync, String is_draft) {

            farmer_id = isNull(farmer_id);
            farmer_name = isNull(farmer_name);
            district = isNull(district);
            community = isNull(community);
            inspection_question1 = isNull(inspection_question1);
            inspection_question2 = isNull(inspection_question2);
            inspection_question3 = isNull(inspection_question3);
            inspection_question4 = isNull(inspection_question4);
            inspection_question5 = isNull(inspection_question5);
            inspection_location = isNull(inspection_location);
            farmer_photo = isNull(farmer_photo);
            signature = isNull(signature);
            is_sync = "0";

            boolean draftMode = "1".equals(is_draft);

            if (!draftMode) {
                if (TextUtils.isEmpty(farmer_id) ||
                        TextUtils.isEmpty(farmer_name) ||
                        TextUtils.isEmpty(district) ||
                        TextUtils.isEmpty(community) ||
                        TextUtils.isEmpty(inspection_question1) ||
                        TextUtils.isEmpty(inspection_question2) ||
                        TextUtils.isEmpty(inspection_question3) ||
                        TextUtils.isEmpty(inspection_question4) ||
                        TextUtils.isEmpty(inspection_question5)) {

                    runOnUiThread(() ->
                            Toast.makeText(context, "All required fields must be filled!", Toast.LENGTH_LONG).show()
                    );
                    InspectionWebView.post(() ->
                            InspectionWebView.evaluateJavascript("alert('Please fill all required fields!');", null)
                    );
                    return;
                }
            }

            String userFname = preferenceHelper.getFirstName();
            String userLname = preferenceHelper.getLastName();
            String userEmail = preferenceHelper.getEmail();

            String onCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String onUpdate = onCreate;

            if (farmerPhotoUri != null) farmer_photo = farmerPhotoUri.toString();

            boolean success = dbHelper.insertOrUpdateInspection(
                    farmer_id, farmer_name, district, community,
                    inspection_question1, inspection_question2, inspection_question3, inspection_question4,
                    inspection_question5, inspection_location, farmer_photo, signature, is_sync, is_draft,
                    userFname, userLname, userEmail, onCreate, onUpdate
            );

            if (success) {
                if ("1".equals(is_draft)) {
                    runOnUiThread(() ->
                            Toast.makeText(context, "Draft saved! You may continue editing.", Toast.LENGTH_LONG).show()
                    );
                }
            } else {
                InspectionWebView.post(() ->
                        InspectionWebView.evaluateJavascript("alert('Failed to save data. Please try again.');", null)
                );
            }
        }

        private String isNull(String s) {
            return (s == null || s.equals("undefined")) ? "" : s;
        }

        @JavascriptInterface
        public void completeSurvey() {
            runOnUiThread(() -> {
                InspectionWebView.loadUrl("about:blank");
                InspectionWebView.clearHistory();
                InspectionWebView.clearCache(true);
                InspectionWebView.destroy();
            });

            Intent intent = new Intent(context, InspectionCompletedActivity.class);
            context.startActivity(intent);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }, 500);
        }

        @JavascriptInterface
        public void openFarmerPhotoActivity() {
            Intent intent = new Intent(context, GetInspectionPhotoActivity.class);
            photoFarmerLauncher.launch(intent);
        }

        @JavascriptInterface
        public void openLocationActivity() {
            Intent intent = new Intent(context, GetInspectionLocationActivity.class);
            locationLauncher.launch(intent);
        }

        @JavascriptInterface
        public void notifyPageLoaded() {
            runOnUiThread(() -> InspectionProgressBar.setVisibility(View.GONE));
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
        if (InspectionWebView != null) {
            InspectionWebView.destroy();
        }
        super.onDestroy();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.inspection_survey);
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
                if (InspectionWebView.canGoBack()) {
                    InspectionWebView.goBack();
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