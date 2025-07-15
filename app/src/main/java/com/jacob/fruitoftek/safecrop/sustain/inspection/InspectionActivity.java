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
                String district = intent.getStringExtra("district");
                String community = intent.getStringExtra("community");
                String farmer_id = intent.getStringExtra("farmer_id");
                String farmer_name = intent.getStringExtra("farmer_name");
                String ghana_card = intent.getStringExtra("ghana_card");
                String farmer_yob = intent.getStringExtra("farmer_yob");
                String phone_number = intent.getStringExtra("phone_number");
                String gender = intent.getStringExtra("gender");
                String inspection_date = intent.getStringExtra("inspection_date");
                String inspector_name = intent.getStringExtra("inspector_name");
                String js = String.format(
                        "populateSurveyFields('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                        escapeJs(farmer_id),
                        escapeJs(farmer_name),
                        escapeJs(district),
                        escapeJs(community),
                        escapeJs(ghana_card),
                        escapeJs(farmer_yob),
                        escapeJs(phone_number),
                        escapeJs(gender),
                        escapeJs(inspection_date),
                        escapeJs(inspector_name)
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
        public void insertOrUpdateInspection(String district, String community, String farmer_id, String farmer_name,
                                             String ghana_card, String farmer_yob, String phone_number, String gender,
                                             String inspection_date, String inspector_name, String inspection_question1,
                                             String inspection_question2, String inspection_question3, String inspection_question4,
                                             String inspection_question5, String inspection_question6, String inspection_question7,
                                             String inspection_question8, String inspection_question9, String inspection_question10,
                                             String inspection_question11, String inspection_question12, String inspection_question13,
                                             String inspection_question14, String inspection_question15, String inspection_question16,
                                             String inspection_question17, String inspection_question18, String inspection_question19,
                                             String inspection_question20, String inspection_question21, String inspection_question22,
                                             String inspection_question23, String inspection_question24, String inspection_question25,
                                             String inspection_question26, String inspection_question27, String inspection_question28,
                                             String inspection_question29, String inspection_question30, String inspection_question31,
                                             String inspection_question32, String inspection_question33, String inspection_question34,
                                             String inspection_question35, String inspection_question36, String inspection_question37,
                                             String inspection_question38, String inspection_question39, String inspection_question40,
                                             String inspection_question41, String inspection_question42, String inspection_question43,
                                             String inspection_question44, String inspection_question45, String inspection_question46,
                                             String inspection_question47, String inspection_question48, String inspection_question49,
                                             String inspection_question50, String inspection_question51, String inspection_question52,
                                             String inspection_question53, String inspection_question54, String inspection_question55,
                                             String inspection_question56, String inspection_question57, String inspection_question58,
                                             String inspection_question59, String inspection_question60, String inspection_question61,
                                             String inspection_question62, String inspection_question63, String inspection_location,
                                             String farmer_photo, String signature, String is_sync, String is_draft) {

            district = isNull(district);
            community = isNull(community);
            farmer_id = isNull(farmer_id);
            farmer_name = isNull(farmer_name);
            ghana_card = isNull(ghana_card);
            farmer_yob = isNull(farmer_yob);
            phone_number = isNull(phone_number);
            gender = isNull(gender);
            inspection_date = isNull(inspection_date);
            inspector_name = isNull(inspector_name);
            inspection_question1 = isNull(inspection_question1);
            inspection_question2 = isNull(inspection_question2);
            inspection_question3 = isNull(inspection_question3);
            inspection_question4 = isNull(inspection_question4);
            inspection_question5 = isNull(inspection_question5);
            inspection_question6 = isNull(inspection_question6);
            inspection_question7 = isNull(inspection_question7);
            inspection_question8 = isNull(inspection_question8);
            inspection_question9 = isNull(inspection_question9);
            inspection_question10 = isNull(inspection_question10);
            inspection_question11 = isNull(inspection_question11);
            inspection_question12 = isNull(inspection_question12);
            inspection_question13 = isNull(inspection_question13);
            inspection_question14 = isNull(inspection_question14);
            inspection_question15 = isNull(inspection_question15);
            inspection_question16 = isNull(inspection_question16);
            inspection_question17 = isNull(inspection_question17);
            inspection_question18 = isNull(inspection_question18);
            inspection_question19 = isNull(inspection_question19);
            inspection_question20 = isNull(inspection_question20);
            inspection_question21 = isNull(inspection_question21);
            inspection_question22 = isNull(inspection_question22);
            inspection_question23 = isNull(inspection_question23);
            inspection_question24 = isNull(inspection_question24);
            inspection_question25 = isNull(inspection_question25);
            inspection_question26 = isNull(inspection_question26);
            inspection_question27 = isNull(inspection_question27);
            inspection_question28 = isNull(inspection_question28);
            inspection_question29 = isNull(inspection_question29);
            inspection_question30 = isNull(inspection_question30);
            inspection_question31 = isNull(inspection_question31);
            inspection_question32 = isNull(inspection_question32);
            inspection_question33 = isNull(inspection_question33);
            inspection_question34 = isNull(inspection_question34);
            inspection_question35 = isNull(inspection_question35);
            inspection_question36 = isNull(inspection_question36);
            inspection_question37 = isNull(inspection_question37);
            inspection_question38 = isNull(inspection_question38);
            inspection_question39 = isNull(inspection_question39);
            inspection_question40 = isNull(inspection_question40);
            inspection_question41 = isNull(inspection_question41);
            inspection_question42 = isNull(inspection_question42);
            inspection_question43 = isNull(inspection_question43);
            inspection_question44 = isNull(inspection_question44);
            inspection_question45 = isNull(inspection_question45);
            inspection_question46 = isNull(inspection_question46);
            inspection_question47 = isNull(inspection_question47);
            inspection_question48 = isNull(inspection_question48);
            inspection_question49 = isNull(inspection_question49);
            inspection_question50 = isNull(inspection_question50);
            inspection_question51 = isNull(inspection_question51);
            inspection_question52 = isNull(inspection_question52);
            inspection_question53 = isNull(inspection_question53);
            inspection_question54 = isNull(inspection_question54);
            inspection_question55 = isNull(inspection_question55);
            inspection_question56 = isNull(inspection_question56);
            inspection_question57 = isNull(inspection_question57);
            inspection_question58 = isNull(inspection_question58);
            inspection_question59 = isNull(inspection_question59);
            inspection_question60 = isNull(inspection_question60);
            inspection_question61 = isNull(inspection_question61);
            inspection_question62 = isNull(inspection_question62);
            inspection_question63 = isNull(inspection_question63);
            inspection_location = isNull(inspection_location);
            farmer_photo = isNull(farmer_photo);
            signature = isNull(signature);
            is_sync = "0";

            boolean draftMode = "1".equals(is_draft);

            if (!draftMode) {
                if (TextUtils.isEmpty(district) ||
                        TextUtils.isEmpty(community) ||
                        TextUtils.isEmpty(farmer_id) ||
                        TextUtils.isEmpty(farmer_name) ||
                        TextUtils.isEmpty(ghana_card) ||
                        TextUtils.isEmpty(farmer_yob) ||
                        TextUtils.isEmpty(phone_number) ||
                        TextUtils.isEmpty(gender) ||
                        TextUtils.isEmpty(inspection_date) ||
                        TextUtils.isEmpty(inspector_name) ||
                        TextUtils.isEmpty(inspection_question1) ||
                        TextUtils.isEmpty(inspection_question2) ||
                        TextUtils.isEmpty(inspection_question3) ||
                        TextUtils.isEmpty(inspection_question4) ||
                        TextUtils.isEmpty(inspection_question5) ||
                        TextUtils.isEmpty(inspection_question6) ||
                        TextUtils.isEmpty(inspection_question7) ||
                        TextUtils.isEmpty(inspection_question8) ||
                        TextUtils.isEmpty(inspection_question9) ||
                        TextUtils.isEmpty(inspection_question10) ||
                        TextUtils.isEmpty(inspection_question11) ||
                        TextUtils.isEmpty(inspection_question12) ||
                        TextUtils.isEmpty(inspection_question13) ||
                        TextUtils.isEmpty(inspection_question14) ||
                        TextUtils.isEmpty(inspection_question15) ||
                        TextUtils.isEmpty(inspection_question16) ||
                        TextUtils.isEmpty(inspection_question17) ||
                        TextUtils.isEmpty(inspection_question18) ||
                        TextUtils.isEmpty(inspection_question19) ||
                        TextUtils.isEmpty(inspection_question20) ||
                        TextUtils.isEmpty(inspection_question21) ||
                        TextUtils.isEmpty(inspection_question22) ||
                        TextUtils.isEmpty(inspection_question23) ||
                        TextUtils.isEmpty(inspection_question24) ||
                        TextUtils.isEmpty(inspection_question25) ||
                        TextUtils.isEmpty(inspection_question26) ||
                        TextUtils.isEmpty(inspection_question27) ||
                        TextUtils.isEmpty(inspection_question28) ||
                        TextUtils.isEmpty(inspection_question29) ||
                        TextUtils.isEmpty(inspection_question30) ||
                        TextUtils.isEmpty(inspection_question31) ||
                        TextUtils.isEmpty(inspection_question32) ||
                        TextUtils.isEmpty(inspection_question33) ||
                        TextUtils.isEmpty(inspection_question34) ||
                        TextUtils.isEmpty(inspection_question35) ||
                        TextUtils.isEmpty(inspection_question36) ||
                        TextUtils.isEmpty(inspection_question37) ||
                        TextUtils.isEmpty(inspection_question38) ||
                        TextUtils.isEmpty(inspection_question39) ||
                        TextUtils.isEmpty(inspection_question40) ||
                        TextUtils.isEmpty(inspection_question41) ||
                        TextUtils.isEmpty(inspection_question42) ||
                        TextUtils.isEmpty(inspection_question43) ||
                        TextUtils.isEmpty(inspection_question44) ||
                        TextUtils.isEmpty(inspection_question45) ||
                        TextUtils.isEmpty(inspection_question46) ||
                        TextUtils.isEmpty(inspection_question47) ||
                        TextUtils.isEmpty(inspection_question48) ||
                        TextUtils.isEmpty(inspection_question49) ||
                        TextUtils.isEmpty(inspection_question50) ||
                        TextUtils.isEmpty(inspection_question51) ||
                        TextUtils.isEmpty(inspection_question52) ||
                        TextUtils.isEmpty(inspection_question53) ||
                        TextUtils.isEmpty(inspection_question54) ||
                        TextUtils.isEmpty(inspection_question55) ||
                        TextUtils.isEmpty(inspection_question56) ||
                        TextUtils.isEmpty(inspection_question57) ||
                        TextUtils.isEmpty(inspection_question58) ||
                        TextUtils.isEmpty(inspection_question59) ||
                        TextUtils.isEmpty(inspection_question60) ||
                        TextUtils.isEmpty(inspection_question61) ||
                        TextUtils.isEmpty(inspection_question62) ||
                        TextUtils.isEmpty(inspection_question63)) {

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
                    district, community, farmer_id, farmer_name, ghana_card, farmer_yob, phone_number,
                    gender, inspection_date, inspector_name, inspection_question1, inspection_question2,
                    inspection_question3, inspection_question4, inspection_question5, inspection_question6,
                    inspection_question7, inspection_question8, inspection_question9, inspection_question10,
                    inspection_question11, inspection_question12, inspection_question13, inspection_question14,
                    inspection_question15, inspection_question16, inspection_question17, inspection_question18,
                    inspection_question19, inspection_question20, inspection_question21, inspection_question22,
                    inspection_question23, inspection_question24, inspection_question25, inspection_question26,
                    inspection_question27, inspection_question28, inspection_question29, inspection_question30,
                    inspection_question31, inspection_question32, inspection_question33, inspection_question34,
                    inspection_question35, inspection_question36, inspection_question37, inspection_question38,
                    inspection_question39, inspection_question40, inspection_question41, inspection_question42,
                    inspection_question43, inspection_question44, inspection_question45, inspection_question46,
                    inspection_question47, inspection_question48, inspection_question49, inspection_question50,
                    inspection_question51, inspection_question52, inspection_question53, inspection_question54,
                    inspection_question55, inspection_question56, inspection_question57, inspection_question58,
                    inspection_question59, inspection_question60, inspection_question61, inspection_question62,
                    inspection_question63, inspection_location, farmer_photo, signature, is_sync, is_draft,
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