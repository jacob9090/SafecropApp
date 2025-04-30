package com.jacob.fruitoftek.safecrop.comdev.ch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.comdev.ComDevDashboard;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

public class ChildWebSurveyActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;

    private WebView chSurveyWebView;
    private ProgressBar chProgressBar;
    private ActivityResultLauncher<Intent> locationLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child_web_survey);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        // Initialize PreferenceHelper
        injectDependencies();

        TextView tvUserName = findViewById(R.id.chUserFNameTV);
        TextView tvUserName2 = findViewById(R.id.chUserONameTV);
        TextView tvUserEmail = findViewById(R.id.chUserEmailTV);

        // Set TextViews using PreferenceHelper
        tvUserName.setText(requireNotNull(preferenceHelper.getFirstName()));
        tvUserName2.setText(requireNotNull(preferenceHelper.getLastName()));
        tvUserEmail.setText(requireNotNull(preferenceHelper.getEmail()));

        chProgressBar = findViewById(R.id.chProgressBar);
        chSurveyWebView = findViewById(R.id.childWebView);
        chSurveyWebView.getSettings().setJavaScriptEnabled(true);

        chSurveyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                chProgressBar.setVisibility(View.GONE);
                injectFarmerData();
            }
        });

        // Register the JavaScript interface
        chSurveyWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        chProgressBar.setVisibility(View.VISIBLE);
        chSurveyWebView.loadUrl("file:///android_asset/child/add_child.html");

        locationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        String location = result.getData().getStringExtra("location");
                        if (location != null) {
                            chSurveyWebView.evaluateJavascript("updateChildLocation('" + location + "');", null);
                        }
                    }
                }
        );
    }

    public class WebAppInterface {
        Context context;
        ChildSurveyDBHelper dbHelper;

        WebAppInterface(Context c) {
            context = c;
            dbHelper = new ChildSurveyDBHelper(context);
        }

        @JavascriptInterface
        public void insertSurveyData(String farmerId, String farmerDistrict, String farmerVillage,
                                     String childquestion4, String child1question1, String child1question2, String child1question3,
                                     String child1question4, String child1question5, String child1question6, String child1question7,
                                     String child1question8, String child1question9, String child1question10, String child1question11,
                                     String child1question12, String child1question13, String child1question14, String child1question15,
                                     String child1question16, String child1question17, String child1question18, String child1question19,
                                     String child2question1, String child2question2, String child2question3, String child2question4,
                                     String child2question5, String child2question6, String child2question7, String child2question8,
                                     String child2question9, String child2question10, String child2question11, String child2question12,
                                     String child2question13, String child2question14, String child2question15, String child2question16,
                                     String child2question17, String child2question18, String child2question19, String child3question1,
                                     String child3question2, String child3question3, String child3question4, String child3question5,
                                     String child3question6, String child3question7, String child3question8, String child3question9,
                                     String child3question10, String child3question11, String child3question12, String child3question13,
                                     String child3question14, String child3question15, String child3question16, String child3question17,
                                     String child3question18, String child3question19, String child4question1, String child4question2,
                                     String child4question3, String child4question4, String child4question5, String child4question6,
                                     String child4question7, String child4question8, String child4question9, String child4question10,
                                     String child4question11, String child4question12, String child4question13, String child4question14,
                                     String child4question15, String child4question16, String child4question17, String child4question18,
                                     String child4question19, String child5question1, String child5question2, String child5question3,
                                     String child5question4, String child5question5, String child5question6, String child5question7,
                                     String child5question8, String child5question9, String child5question10, String child5question11,
                                     String child5question12, String child5question13, String child5question14, String child5question15,
                                     String child5question16, String child5question17, String child5question18, String child5question19,
                                     String child6question1, String child6question2, String child6question3, String child6question4,
                                     String child6question5, String child6question6, String child6question7, String child6question8,
                                     String child6question9, String child6question10, String child6question11, String child6question12,
                                     String child6question13, String child6question14, String child6question15, String child6question16,
                                     String child6question17, String child6question18, String child6question19, String child7question1,
                                     String child7question2, String child7question3, String child7question4, String child7question5,
                                     String child7question6, String child7question7, String child7question8, String child7question9,
                                     String child7question10, String child7question11, String child7question12, String child7question13,
                                     String child7question14, String child7question15, String child7question16, String child7question17,
                                     String child7question18, String child7question19, String child8question1, String child8question2,
                                     String child8question3, String child8question4, String child8question5, String child8question6,
                                     String child8question7, String child8question8, String child8question9, String child8question10,
                                     String child8question11, String child8question12, String child8question13, String child8question14,
                                     String child8question15, String child8question16, String child8question17, String child8question18,
                                     String child8question19, String child9question1, String child9question2, String child9question3,
                                     String child9question4, String child9question5, String child9question6, String child9question7,
                                     String child9question8, String child9question9, String child9question10, String child9question11,
                                     String child9question12, String child9question13, String child9question14, String child9question15,
                                     String child9question16, String child9question17, String child9question18, String child9question19,
                                     String child10question1, String child10question2, String child10question3, String child10question4,
                                     String child10question5, String child10question6, String child10question7, String child10question8,
                                     String child10question9, String child10question10, String child10question11, String child10question12,
                                     String child10question13, String child10question14, String child10question15, String child10question16, String child10question17,
                                     String child10question18, String child10question19, String childquestion5, String child_location, String signature) {

            child1question13 = child1question13 == null || child1question13.equals("undefined") ? "" : child1question13;
            child2question13 = child2question13 == null || child2question13.equals("undefined") ? "" : child2question13;
            child3question13 = child3question13 == null || child3question13.equals("undefined") ? "" : child3question13;
            child4question13 = child4question13 == null || child4question13.equals("undefined") ? "" : child4question13;
            child5question13 = child5question13 == null || child5question13.equals("undefined") ? "" : child5question13;
            child6question13 = child6question13 == null || child6question13.equals("undefined") ? "" : child6question13;
            child7question13 = child7question13 == null || child7question13.equals("undefined") ? "" : child7question13;
            child8question13 = child8question13 == null || child8question13.equals("undefined") ? "" : child8question13;
            child9question13 = child9question13 == null || child9question13.equals("undefined") ? "" : child9question13;
            child10question13 = child10question13 == null || child10question13.equals("undefined") ? "" : child10question13;

            Log.d("insertSurveyData", "ID: " + farmerId + ", Dis: " + farmerDistrict + ", Vil: " + farmerVillage + ", Loc: " + child_location + ", Signature: " + signature);
            String userFname = preferenceHelper.getFirstName();
            String userOname = preferenceHelper.getLastName();
            String userEmail = preferenceHelper.getEmail();
            String onCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String onUpdate = onCreate;
            dbHelper.insertSurveyData(farmerId, farmerDistrict, farmerVillage,
                    childquestion4, child1question1, child1question2, child1question3, child1question4, child1question5,
                    child1question6, child1question7, child1question8, child1question9, child1question10, child1question11,
                    child1question12, child1question13, child1question14, child1question15, child1question16, child1question17,
                    child1question18, child1question19, child2question1, child2question2, child2question3, child2question4,
                    child2question5, child2question6, child2question7, child2question8, child2question9, child2question10,
                    child2question11, child2question12, child2question13, child2question14, child2question15, child2question16,
                    child2question17, child2question18, child2question19, child3question1, child3question2, child3question3,
                    child3question4, child3question5, child3question6, child3question7, child3question8, child3question9,
                    child3question10, child3question11, child3question12, child3question13, child3question14, child3question15,
                    child3question16, child3question17, child3question18, child3question19, child4question1, child4question2,
                    child4question3, child4question4, child4question5, child4question6, child4question7, child4question8,
                    child4question9, child4question10, child4question11, child4question12, child4question13, child4question14,
                    child4question15, child4question16, child4question17, child4question18, child4question19, child5question1,
                    child5question2, child5question3, child5question4, child5question5, child5question6, child5question7,
                    child5question8, child5question9, child5question10, child5question11, child5question12, child5question13,
                    child5question14, child5question15, child5question16, child5question17, child5question18, child5question19,
                    child6question1, child6question2, child6question3, child6question4, child6question5, child6question6,
                    child6question7, child6question8, child6question9, child6question10, child6question11, child6question12,
                    child6question13, child6question14, child6question15, child6question16, child6question17, child6question18,
                    child6question19, child7question1, child7question2, child7question3, child7question4, child7question5,
                    child7question6, child7question7, child7question8, child7question9, child7question10, child7question11,
                    child7question12, child7question13, child7question14, child7question15, child7question16, child7question17,
                    child7question18, child7question19, child8question1, child8question2, child8question3, child8question4,
                    child8question5, child8question6, child8question7, child8question8, child8question9, child8question10,
                    child8question11, child8question12, child8question13, child8question14, child8question15, child8question16,
                    child8question17, child8question18, child8question19, child9question1, child9question2, child9question3,
                    child9question4, child9question5, child9question6, child9question7, child9question8, child9question9,
                    child9question10, child9question11, child9question12, child9question13, child9question14, child9question15,
                    child9question16, child9question17, child9question18, child9question19, child10question1, child10question2,
                    child10question3, child10question4, child10question5, child10question6, child10question7, child10question8,
                    child10question9, child10question10, child10question11, child10question12, child10question13, child10question14,
                    child10question15, child10question16, child10question17, child10question18, child10question19, childquestion5,
                    child_location, signature, userFname, userOname, userEmail, onCreate, onUpdate);
        }

        @JavascriptInterface
        public void completeSurvey() {
            Intent intent = new Intent(context, ChildSurveyCompletedActivity.class);
            context.startActivity(intent);
            finish();
        }

        @JavascriptInterface
        public void openLocationActivity() {
            Intent intent = new Intent(context, GetChildLocationActivity.class);
            locationLauncher.launch(intent);
        }

    }

    private void injectFarmerData() {
        Intent intent = getIntent();
        String farmerId = intent.getStringExtra("farmer_id");
        String farmerDistrict = intent.getStringExtra("farmer_district");
        String farmerVillage = intent.getStringExtra("farmer_village");

        String jsCode = String.format(
                "populateSurveyFields('%s', '%s', '%s');",
                farmerId, farmerDistrict, farmerVillage
        );
        chSurveyWebView.evaluateJavascript(jsCode, null);
    }

    private void injectDependencies() {
        preferenceHelper = new PreferenceHelper(this);
    }

    private <T> T requireNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException("Required value was null.");
        }
        return obj;
    }

    @Override
    protected void onDestroy() {
        if (chSurveyWebView != null) {
            chSurveyWebView.destroy();
        }
        super.onDestroy();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.ch_survey);
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
                    if (chSurveyWebView.canGoBack()) {
                        chSurveyWebView.goBack();
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
                    Intent intent = new Intent(ChildWebSurveyActivity.this, ComDevDashboard.class);
                    startActivity(intent);
                    finish(); // Finish AddStudentActivity
                })
                .setNegativeButton("No", null) // Dismiss the dialog
                .setCancelable(false)
                .show();
    }
}