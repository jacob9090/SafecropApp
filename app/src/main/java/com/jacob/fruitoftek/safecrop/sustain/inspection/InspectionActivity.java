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
                String ghana_card = intent.getStringExtra("ghana_card");
                String farmer_yob = intent.getStringExtra("farmer_yob");
                String farmer_phone = intent.getStringExtra("farmer_phone");
                String farmer_gender = intent.getStringExtra("farmer_gender");
                String js = String.format(
                        "populateSurveyFields('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                        escapeJs(farmer_id),
                        escapeJs(farmer_name),
                        escapeJs(district),
                        escapeJs(community),
                        escapeJs(ghana_card),
                        escapeJs(farmer_yob),
                        escapeJs(farmer_phone),
                        escapeJs(farmer_gender)
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
        public void insertOrUpdateInspection(String farmer_id, String farmer_name, String district, String community, String ghana_card, String farmer_yob,
                                             String farmer_phone, String farmer_gender, String inspection_date, String inspector_name,
                                             String inspection_question1, String inspection_question1b, String inspection_question2, String inspection_question2b,
                                             String inspection_question3, String inspection_question3b, String inspection_question4, String inspection_question4b,
                                             String inspection_question5, String inspection_question5b, String inspection_question6, String inspection_question6b,
                                             String inspection_question7, String inspection_question7b, String inspection_question8, String inspection_question8b,
                                             String inspection_question9, String inspection_question9b, String inspection_question10, String inspection_question10b,
                                             String inspection_question11, String inspection_question11b, String inspection_question12, String inspection_question12b,
                                             String inspection_question13, String inspection_question13b, String inspection_question14, String inspection_question14b,
                                             String inspection_question15, String inspection_question15b, String inspection_question16, String inspection_question16b,
                                             String inspection_question17, String inspection_question17b, String inspection_question18, String inspection_question18b,
                                             String inspection_question19, String inspection_question19b, String inspection_question20, String inspection_question20b,
                                             String inspection_question21, String inspection_question21b, String inspection_question22, String inspection_question22b,
                                             String inspection_question23, String inspection_question23b, String inspection_question24, String inspection_question24b,
                                             String inspection_question25, String inspection_question25b, String inspection_question26, String inspection_question26b,
                                             String inspection_question27, String inspection_question27b, String inspection_question28, String inspection_question28b,
                                             String inspection_question29, String inspection_question29b, String inspection_question30, String inspection_question30b,
                                             String inspection_question31, String inspection_question31b, String inspection_question32, String inspection_question32b,
                                             String inspection_question33, String inspection_question33b, String inspection_question34, String inspection_question34b,
                                             String inspection_question35, String inspection_question35b, String inspection_question36, String inspection_question36b,
                                             String inspection_question37, String inspection_question37b, String inspection_question38, String inspection_question38b,
                                             String inspection_question39, String inspection_question39b, String inspection_question40, String inspection_question40b,
                                             String inspection_question41, String inspection_question41b, String inspection_question42, String inspection_question42b,
                                             String inspection_question43, String inspection_question43b, String inspection_question44, String inspection_question44b,
                                             String inspection_question45, String inspection_question45b, String inspection_question46, String inspection_question46b,
                                             String inspection_question47, String inspection_question47b, String inspection_question48, String inspection_question48b,
                                             String inspection_question49, String inspection_question49b, String inspection_question50, String inspection_question50b,
                                             String inspection_question51, String inspection_question51b, String inspection_question52, String inspection_question52b,
                                             String inspection_question53, String inspection_question53b, String inspection_question54, String inspection_question54b,
                                             String inspection_question55, String inspection_question55b, String inspection_question56, String inspection_question56b,
                                             String inspection_question57, String inspection_question57b, String inspection_question58, String inspection_question58b,
                                             String inspection_question59, String inspection_question59b, String inspection_question60, String inspection_question60b,
                                             String inspection_question61, String inspection_question61b, String inspection_question62, String inspection_question62b,
                                             String inspection_question63, String inspection_question63b, String inspection_location,
                                             String farmer_photo, String signature, String is_sync, String is_draft) {

            Log.d("WebAppInterface", "--- insertOrUpdateInspection CALLED ---");
            Log.d("WebAppInterface", "Raw input district: " + district + ", community: " + community + ", farmer_id: " + farmer_id);
            Log.d("WebAppInterface", "Raw input ghana_card: " + ghana_card + ", farmer_yob: " + farmer_yob);
            Log.d("WebAppInterface", "Raw input farmer_phone: " + farmer_phone + ", farmer_gender: " + farmer_gender);
            Log.d("WebAppInterface", "Raw input inspection_date: " + inspection_date + ", inspector_name: " + inspector_name);
            Log.d("WebAppInterface", "Raw input Q1: " + inspection_question1 + ", Q1b: " + inspection_question1b);
            Log.d("WebAppInterface", "Raw input Q2: " + inspection_question2 + ", Q2b: " + inspection_question2b);
            Log.d("WebAppInterface", "Raw input Q3: " + inspection_question3 + ", Q3b: " + inspection_question3b);
            Log.d("WebAppInterface", "Raw input location: " + inspection_location + ", photo: " + farmer_photo + ", signature: " + signature);

            farmer_id = isNull(farmer_id);
            farmer_name = isNull(farmer_name);
            district = isNull(district);
            community = isNull(community);
            ghana_card = isNull(ghana_card);
            farmer_yob = isNull(farmer_yob);
            farmer_phone = isNull(farmer_phone);
            farmer_gender = isNull(farmer_gender);
            inspection_date = isNull(inspection_date);
            inspector_name = isNull(inspector_name);
            inspection_question1 = isNull(inspection_question1);
            inspection_question1b = isNull(inspection_question1b);
            inspection_question2 = isNull(inspection_question2);
            inspection_question2b = isNull(inspection_question2b);
            inspection_question3 = isNull(inspection_question3);
            inspection_question3b = isNull(inspection_question3b);
            inspection_question4 = isNull(inspection_question4);
            inspection_question4b = isNull(inspection_question4b);
            inspection_question5 = isNull(inspection_question5);
            inspection_question5b = isNull(inspection_question5b);
            inspection_question6 = isNull(inspection_question6);
            inspection_question6b = isNull(inspection_question6b);
            inspection_question7 = isNull(inspection_question7);
            inspection_question7b = isNull(inspection_question7b);
            inspection_question8 = isNull(inspection_question8);
            inspection_question8b = isNull(inspection_question8b);
            inspection_question9 = isNull(inspection_question9);
            inspection_question9b = isNull(inspection_question9b);
            inspection_question10 = isNull(inspection_question10);
            inspection_question10b = isNull(inspection_question10b);
            inspection_question11 = isNull(inspection_question11);
            inspection_question11b = isNull(inspection_question11b);
            inspection_question12 = isNull(inspection_question12);
            inspection_question12b = isNull(inspection_question12b);
            inspection_question13 = isNull(inspection_question13);
            inspection_question13b = isNull(inspection_question13b);
            inspection_question14 = isNull(inspection_question14);
            inspection_question14b = isNull(inspection_question14b);
            inspection_question15 = isNull(inspection_question15);
            inspection_question15b = isNull(inspection_question15b);
            inspection_question16 = isNull(inspection_question16);
            inspection_question16b = isNull(inspection_question16b);
            inspection_question17 = isNull(inspection_question17);
            inspection_question17b = isNull(inspection_question17b);
            inspection_question18 = isNull(inspection_question18);
            inspection_question18b = isNull(inspection_question18b);
            inspection_question19 = isNull(inspection_question19);
            inspection_question19b = isNull(inspection_question19b);
            inspection_question20 = isNull(inspection_question20);
            inspection_question20b = isNull(inspection_question20b);
            inspection_question21 = isNull(inspection_question21);
            inspection_question21b = isNull(inspection_question21b);
            inspection_question22 = isNull(inspection_question22);
            inspection_question22b = isNull(inspection_question22b);
            inspection_question23 = isNull(inspection_question23);
            inspection_question23b = isNull(inspection_question23b);
            inspection_question24 = isNull(inspection_question24);
            inspection_question24b = isNull(inspection_question24b);
            inspection_question25 = isNull(inspection_question25);
            inspection_question25b = isNull(inspection_question25b);
            inspection_question26 = isNull(inspection_question26);
            inspection_question26b = isNull(inspection_question26b);
            inspection_question27 = isNull(inspection_question27);
            inspection_question27b = isNull(inspection_question27b);
            inspection_question28 = isNull(inspection_question28);
            inspection_question28b = isNull(inspection_question28b);
            inspection_question29 = isNull(inspection_question29);
            inspection_question29b = isNull(inspection_question29b);
            inspection_question30 = isNull(inspection_question30);
            inspection_question30b = isNull(inspection_question30b);
            inspection_question31 = isNull(inspection_question31);
            inspection_question31b = isNull(inspection_question31b);
            inspection_question32 = isNull(inspection_question32);
            inspection_question32b = isNull(inspection_question32b);
            inspection_question33 = isNull(inspection_question33);
            inspection_question33b = isNull(inspection_question33b);
            inspection_question34 = isNull(inspection_question34);
            inspection_question34b = isNull(inspection_question34b);
            inspection_question35 = isNull(inspection_question35);
            inspection_question35b = isNull(inspection_question35b);
            inspection_question36 = isNull(inspection_question36);
            inspection_question36b = isNull(inspection_question36b);
            inspection_question37 = isNull(inspection_question37);
            inspection_question37b = isNull(inspection_question37b);
            inspection_question38 = isNull(inspection_question38);
            inspection_question38b = isNull(inspection_question38b);
            inspection_question39 = isNull(inspection_question39);
            inspection_question39b = isNull(inspection_question39b);
            inspection_question40 = isNull(inspection_question40);
            inspection_question40b = isNull(inspection_question40b);
            inspection_question41 = isNull(inspection_question41);
            inspection_question41b = isNull(inspection_question41b);
            inspection_question42 = isNull(inspection_question42);
            inspection_question42b = isNull(inspection_question42b);
            inspection_question43 = isNull(inspection_question43);
            inspection_question43b = isNull(inspection_question43b);
            inspection_question44 = isNull(inspection_question44);
            inspection_question44b = isNull(inspection_question44b);
            inspection_question45 = isNull(inspection_question45);
            inspection_question45b = isNull(inspection_question45b);
            inspection_question46 = isNull(inspection_question46);
            inspection_question46b = isNull(inspection_question46b);
            inspection_question47 = isNull(inspection_question47);
            inspection_question47b = isNull(inspection_question47b);
            inspection_question48 = isNull(inspection_question48);
            inspection_question48b = isNull(inspection_question48b);
            inspection_question49 = isNull(inspection_question49);
            inspection_question49b = isNull(inspection_question49b);
            inspection_question50 = isNull(inspection_question50);
            inspection_question50b = isNull(inspection_question50b);
            inspection_question51 = isNull(inspection_question51);
            inspection_question51b = isNull(inspection_question51b);
            inspection_question52 = isNull(inspection_question52);
            inspection_question52b = isNull(inspection_question52b);
            inspection_question53 = isNull(inspection_question53);
            inspection_question53b = isNull(inspection_question53b);
            inspection_question54 = isNull(inspection_question54);
            inspection_question54b = isNull(inspection_question54b);
            inspection_question55 = isNull(inspection_question55);
            inspection_question55b = isNull(inspection_question55b);
            inspection_question56 = isNull(inspection_question56);
            inspection_question56b = isNull(inspection_question56b);
            inspection_question57 = isNull(inspection_question57);
            inspection_question57b = isNull(inspection_question57b);
            inspection_question58 = isNull(inspection_question58);
            inspection_question58b = isNull(inspection_question58b);
            inspection_question59 = isNull(inspection_question59);
            inspection_question59b = isNull(inspection_question59b);
            inspection_question60 = isNull(inspection_question60);
            inspection_question60b = isNull(inspection_question60b);
            inspection_question61 = isNull(inspection_question61);
            inspection_question61b = isNull(inspection_question61b);
            inspection_question62 = isNull(inspection_question62);
            inspection_question62b = isNull(inspection_question62b);
            inspection_question63 = isNull(inspection_question63);
            inspection_question63b = isNull(inspection_question63b);
            inspection_location = isNull(inspection_location);
            farmer_photo = isNull(farmer_photo);
            signature = isNull(signature);
            is_sync = "0";

            Log.d("WebAppInterface", "After isNull: farmer_id: " + farmer_id + ", Q1: " + inspection_question1);

            boolean draftMode = "1".equals(is_draft);

            if (!draftMode) {
                if (
                        TextUtils.isEmpty(farmer_id) ||
                        TextUtils.isEmpty(farmer_name) ||
                        TextUtils.isEmpty(district) ||
                        TextUtils.isEmpty(community) ||
                        TextUtils.isEmpty(ghana_card) ||
                        TextUtils.isEmpty(farmer_yob) ||
                        TextUtils.isEmpty(farmer_phone) ||
                        TextUtils.isEmpty(farmer_gender) ||
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

                    Log.e("WebAppInterface", "Validation FAILED: Required fields are empty for non-draft save.");
                    runOnUiThread(() ->
                            Toast.makeText(context, "All required fields must be filled!", Toast.LENGTH_LONG).show()
                    );
                    InspectionWebView.post(() ->
                            InspectionWebView.evaluateJavascript("alert('Please fill all required fields!');", null)
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

            if (farmerPhotoUri != null) farmer_photo = farmerPhotoUri.toString();

            Log.d("WebAppInterface", "Attempting to insert/update into DB...");
            boolean success = dbHelper.insertOrUpdateInspection(
                    farmer_id, farmer_name, district, community, ghana_card, farmer_yob, farmer_phone, farmer_gender,
                    inspection_date, inspector_name, inspection_question1, inspection_question1b, inspection_question2,
                    inspection_question2b, inspection_question3, inspection_question3b, inspection_question4,
                    inspection_question4b, inspection_question5, inspection_question5b, inspection_question6,
                    inspection_question6b, inspection_question7, inspection_question7b, inspection_question8,
                    inspection_question8b, inspection_question9, inspection_question9b, inspection_question10,
                    inspection_question10b, inspection_question11, inspection_question11b, inspection_question12,
                    inspection_question12b, inspection_question13, inspection_question13b, inspection_question14,
                    inspection_question14b, inspection_question15, inspection_question15b, inspection_question16,
                    inspection_question16b, inspection_question17, inspection_question17b, inspection_question18,
                    inspection_question18b, inspection_question19, inspection_question19b, inspection_question20,
                    inspection_question20b, inspection_question21, inspection_question21b, inspection_question22,
                    inspection_question22b, inspection_question23, inspection_question23b, inspection_question24,
                    inspection_question24b, inspection_question25, inspection_question25b, inspection_question26,
                    inspection_question26b, inspection_question27, inspection_question27b, inspection_question28,
                    inspection_question28b, inspection_question29, inspection_question29b, inspection_question30,
                    inspection_question30b, inspection_question31, inspection_question31b, inspection_question32,
                    inspection_question32b, inspection_question33, inspection_question33b, inspection_question34,
                    inspection_question34b, inspection_question35, inspection_question35b, inspection_question36,
                    inspection_question36b, inspection_question37, inspection_question37b, inspection_question38,
                    inspection_question38b, inspection_question39, inspection_question39b, inspection_question40,
                    inspection_question40b, inspection_question41, inspection_question41b, inspection_question42,
                    inspection_question42b, inspection_question43, inspection_question43b, inspection_question44,
                    inspection_question44b, inspection_question45, inspection_question45b, inspection_question46,
                    inspection_question46b, inspection_question47, inspection_question47b, inspection_question48,
                    inspection_question48b, inspection_question49, inspection_question49b, inspection_question50,
                    inspection_question50b, inspection_question51, inspection_question51b, inspection_question52,
                    inspection_question52b, inspection_question53, inspection_question53b, inspection_question54,
                    inspection_question54b, inspection_question55, inspection_question55b, inspection_question56,
                    inspection_question56b, inspection_question57, inspection_question57b, inspection_question58,
                    inspection_question58b, inspection_question59, inspection_question59b, inspection_question60,
                    inspection_question60b, inspection_question61, inspection_question61b, inspection_question62,
                    inspection_question62b, inspection_question63, inspection_question63b, inspection_location,
                    farmer_photo, signature, is_sync, is_draft, userFname, userLname, userEmail, onCreate, onUpdate
            );

            if (success) {
                Log.d("WebAppInterface", "DATABASE INSERT/UPDATE SUCCESS!");
                if ("1".equals(is_draft)) {
                    runOnUiThread(() ->
                            Toast.makeText(context, "Draft saved! You may continue editing.", Toast.LENGTH_LONG).show()
                    );
                }
            } else {
                Log.e("WebAppInterface", "DATABASE INSERT/UPDATE FAILED! Check InspectionDbHelper logs.");
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
