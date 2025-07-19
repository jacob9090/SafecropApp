package com.jacob.fruitoftek.safecrop.sustain.profiling;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;

import java.io.File;

import androidx.appcompat.app.ActionBar;

public class SusProfilingDetailsActivity extends AppCompatActivity {

    private WebView inspectionDetailsWebView;
    private SusProfilingModel susProfilingModel;
    private SusProfilingDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sus_profiling_details);

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

        inspectionDetailsWebView = findViewById(R.id.susProfilingDetailsWebView);
        inspectionDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new SusProfilingDbHelper(this);

        // Retrieve SusProfilingModel from the Intent
        susProfilingModel = getIntent().getParcelableExtra("inspection_model");

        if (susProfilingModel != null) {
            loadSurveyDetails();
        } else {
            Toast.makeText(this, "Farmer details are missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        inspectionDetailsWebView.loadUrl("file:///android_asset/susprofiling/susprofilingdetails.html");

        // Inject survey details after the page loads
        inspectionDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        if (susProfilingModel == null) return;

        String signaturePath = susProfilingModel.getSignature();
        String signatureUri = "";

        if (signaturePath != null && !signaturePath.isEmpty()) {
            File signatureFile = new File(signaturePath);
            if (signatureFile.exists()) {
                signatureUri = FileProvider.getUriForFile(this,
                        getPackageName() + ".fileprovider", signatureFile).toString();
            }
        }

        String js = String.format("javascript:" +
                        "document.getElementById('farmer_id').textContent = '%s';" +
                        "document.getElementById('farmer_name').textContent = '%s';" +
                        "document.getElementById('farmer_gender').textContent = '%s';" +
                        "document.getElementById('district').textContent = '%s';" +
                        "document.getElementById('community').textContent = '%s';" +
                        "document.getElementById('farmer_dob').textContent = '%s';" +
                        "document.getElementById('ghana_card').textContent = '%s';" +
                        "document.getElementById('suspro_question1').textContent = '%s';" +
                        "document.getElementById('suspro_question2').textContent = '%s';" +
                        "document.getElementById('suspro_question3').textContent = '%s';" +
                        "document.getElementById('suspro_question4').textContent = '%s';" +
                        "document.getElementById('suspro_question5').textContent = '%s';" +
                        "document.getElementById('suspro_question6').textContent = '%s';" +
                        "document.getElementById('suspro_question7').textContent = '%s';" +
                        "document.getElementById('suspro_question8').textContent = '%s';" +
                        "document.getElementById('suspro_question9').textContent = '%s';" +
                        "document.getElementById('suspro_question10').textContent = '%s';" +
                        "document.getElementById('suspro_question11').textContent = '%s';" +
                        "document.getElementById('suspro_question12').textContent = '%s';" +
                        "document.getElementById('suspro_question13').textContent = '%s';" +
                        "document.getElementById('suspro_question14').textContent = '%s';" +
                        "document.getElementById('suspro_question15').textContent = '%s';" +
                        "document.getElementById('suspro_question16').textContent = '%s';" +
                        "document.getElementById('suspro_question17').textContent = '%s';" +
                        "document.getElementById('suspro_question18').textContent = '%s';" +
                        "document.getElementById('suspro_question19').textContent = '%s';" +
                        "document.getElementById('suspro_question20').textContent = '%s';" +
                        "document.getElementById('suspro_question21').textContent = '%s';" +
                        "document.getElementById('suspro_question22').textContent = '%s';" +
                        "document.getElementById('suspro_question23').textContent = '%s';" +
                        "document.getElementById('suspro_question24').textContent = '%s';" +
                        "document.getElementById('suspro_question25').textContent = '%s';" +
                        "document.getElementById('signature').src = '%s';" +
                        "document.getElementById('is_sync').textContent = '%s';" +
                        "document.getElementById('is_draft').textContent = '%s';" +
                        "document.getElementById('on_create').textContent = '%s';" +
                        "document.getElementById('on_update').textContent = '%s';" +
                        "document.getElementById('user_fname').textContent = '%s';" +
                        "document.getElementById('user_lname').textContent = '%s';" +
                        "document.getElementById('user_email').textContent = '%s';",
                sanitize(susProfilingModel.getFarmer_id()),
                sanitize(susProfilingModel.getFarmer_name()),
                sanitize(susProfilingModel.getFarmer_gender()),
                sanitize(susProfilingModel.getDistrict()),
                sanitize(susProfilingModel.getCommunity()),
                sanitize(susProfilingModel.getFarmer_dob()),
                sanitize(susProfilingModel.getGhana_card()),
                sanitize(susProfilingModel.getSuspro_question1()),
                sanitize(susProfilingModel.getSuspro_question2()),
                sanitize(susProfilingModel.getSuspro_question3()),
                sanitize(susProfilingModel.getSuspro_question4()),
                sanitize(susProfilingModel.getSuspro_question5()),
                sanitize(susProfilingModel.getSuspro_question6()),
                sanitize(susProfilingModel.getSuspro_question7()),
                sanitize(susProfilingModel.getSuspro_question8()),
                sanitize(susProfilingModel.getSuspro_question9()),
                sanitize(susProfilingModel.getSuspro_question10()),
                sanitize(susProfilingModel.getSuspro_question11()),
                sanitize(susProfilingModel.getSuspro_question12()),
                sanitize(susProfilingModel.getSuspro_question13()),
                sanitize(susProfilingModel.getSuspro_question14()),
                sanitize(susProfilingModel.getSuspro_question15()),
                sanitize(susProfilingModel.getSuspro_question16()),
                sanitize(susProfilingModel.getSuspro_question17()),
                sanitize(susProfilingModel.getSuspro_question18()),
                sanitize(susProfilingModel.getSuspro_question19()),
                sanitize(susProfilingModel.getSuspro_question20()),
                sanitize(susProfilingModel.getSuspro_question21()),
                sanitize(susProfilingModel.getSuspro_question22()),
                sanitize(susProfilingModel.getSuspro_question23()),
                sanitize(susProfilingModel.getSuspro_question24()),
                sanitize(susProfilingModel.getSuspro_question25()),
                sanitize(signatureUri),
                sanitize(susProfilingModel.getIs_sync()),
                sanitize(susProfilingModel.getIs_draft()),
                sanitize(susProfilingModel.getOnCreate()),
                sanitize(susProfilingModel.getOnUpdate()),
                sanitize(susProfilingModel.getUserFname()),
                sanitize(susProfilingModel.getUserLname()),
                sanitize(susProfilingModel.getUserEmail()));

        inspectionDetailsWebView.evaluateJavascript(js, null);
    }

    private String sanitize(String input) {
        return input != null ? input.replace("'", "\\'") : "";
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
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}