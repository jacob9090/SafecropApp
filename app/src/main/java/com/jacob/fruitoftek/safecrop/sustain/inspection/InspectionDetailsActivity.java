package com.jacob.fruitoftek.safecrop.sustain.inspection;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;

import java.io.File;

public class InspectionDetailsActivity extends AppCompatActivity {
    
    private WebView inspectionDetailsWebView;
    private InspectionModel inspectionModel;
    private InspectionDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inspection_details);
        
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        inspectionDetailsWebView = findViewById(R.id.inspectionDetailsWebView);
        inspectionDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new InspectionDbHelper(this);

        // Retrieve InspectionModel from the Intent
        inspectionModel = getIntent().getParcelableExtra("inspection_model");

        if (inspectionModel != null) {
            loadSurveyDetails();
        } else {
            Toast.makeText(this, "Farmer details are missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        inspectionDetailsWebView.loadUrl("file:///android_asset/inspection/inspectiondetails.html");

        // Inject survey details after the page loads
        inspectionDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        if (inspectionModel == null) return;

        String signaturePath = inspectionModel.getSignature();
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
                        "document.getElementById('district').textContent = '%s';" +
                        "document.getElementById('community').textContent = '%s';" +
                        "document.getElementById('inspection_question1').textContent = '%s';" +
                        "document.getElementById('inspection_question2').textContent = '%s';" +
                        "document.getElementById('inspection_question3').textContent = '%s';" +
                        "document.getElementById('inspection_question4').textContent = '%s';" +
                        "document.getElementById('inspection_question5').textContent = '%s';" +
                        "document.getElementById('inspection_location').textContent = '%s';" +
                        "document.getElementById('farmer_photo').src = '%s';" +
                        "document.getElementById('signature').src = '%s';" +
                        "document.getElementById('is_sync').textContent = '%s';" +
                        "document.getElementById('is_draft').textContent = '%s';" +
                        "document.getElementById('on_create').textContent = '%s';" +
                        "document.getElementById('on_update').textContent = '%s';" +
                        "document.getElementById('user_fname').textContent = '%s';" +
                        "document.getElementById('user_lname').textContent = '%s';" +
                        "document.getElementById('user_email').textContent = '%s';",
                sanitize(inspectionModel.getFarmer_id()),
                sanitize(inspectionModel.getFarmer_name()),
                sanitize(inspectionModel.getDistrict()),
                sanitize(inspectionModel.getCommunity()),
                sanitize(inspectionModel.getInspection_question1()),
                sanitize(inspectionModel.getInspection_question2()),
                sanitize(inspectionModel.getInspection_question3()),
                sanitize(inspectionModel.getInspection_question4()),
                sanitize(inspectionModel.getInspection_question5()),
                sanitize(inspectionModel.getInspection_location()),
                inspectionModel.getFarmer_photo() != null ? sanitize(inspectionModel.getFarmer_photo().toString()) : "",
                sanitize(signatureUri),
                sanitize(inspectionModel.getIs_sync()),
                sanitize(inspectionModel.getIs_draft()),
                sanitize(inspectionModel.getOnCreate()),
                sanitize(inspectionModel.getOnUpdate()),
                sanitize(inspectionModel.getUserFname()),
                sanitize(inspectionModel.getUserLname()),
                sanitize(inspectionModel.getUserEmail()));

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