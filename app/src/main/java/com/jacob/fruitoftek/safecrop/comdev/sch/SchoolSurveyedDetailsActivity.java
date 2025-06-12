package com.jacob.fruitoftek.safecrop.comdev.sch;

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

public class SchoolSurveyedDetailsActivity extends AppCompatActivity {

    private WebView schoolSurveyDetailsWebView;
    private SchoolModel schoolModel;
    private SchoolDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_school_surveyed_details);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        schoolSurveyDetailsWebView = findViewById(R.id.schoolSurveyDetailsWebView);
        schoolSurveyDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new SchoolDbHelper(this);

        // Retrieve SchoolModel from the Intent
        schoolModel = getIntent().getParcelableExtra("sch_model");

        if (schoolModel != null) {
            loadSurveyDetails();
        } else {
            Toast.makeText(this, "School details are missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        schoolSurveyDetailsWebView.loadUrl("file:///android_asset/sch/schoolsurveydetails.html");

        // Inject survey details after the page loads
        schoolSurveyDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        if (schoolModel == null) return;

        String signaturePath = schoolModel.getSignature();
        String signatureUri = "";

        if (signaturePath != null && !signaturePath.isEmpty()) {
            File signatureFile = new File(signaturePath);
            if (signatureFile.exists()) {
                signatureUri = FileProvider.getUriForFile(this,
                        getPackageName() + ".fileprovider", signatureFile).toString();
            }
        }

        String js = String.format("javascript:" +
                        "document.getElementById('school_name').textContent = '%s';" +
                        "document.getElementById('school_district').textContent = '%s';" +
                        "document.getElementById('school_community').textContent = '%s';" +
                        "document.getElementById('schquestion4').textContent = '%s';" +
                        "document.getElementById('schquestion5').textContent = '%s';" +
                        "document.getElementById('schquestion6').textContent = '%s';" +
                        "document.getElementById('schquestion7').textContent = '%s';" +
                        "document.getElementById('schquestion8').textContent = '%s';" +
                        "document.getElementById('schquestion9').textContent = '%s';" +
                        "document.getElementById('schquestion10').textContent = '%s';" +
                        "document.getElementById('schquestion11').textContent = '%s';" +
                        "document.getElementById('schquestion12').textContent = '%s';" +
                        "document.getElementById('schquestion13').textContent = '%s';" +
                        "document.getElementById('schquestion14').textContent = '%s';" +
                        "document.getElementById('schquestion15').textContent = '%s';" +
                        "document.getElementById('schquestion16').textContent = '%s';" +
                        "document.getElementById('schquestion17').textContent = '%s';" +
                        "document.getElementById('schquestion18').textContent = '%s';" +
                        "document.getElementById('schquestion19').textContent = '%s';" +
                        "document.getElementById('schquestion20').textContent = '%s';" +
                        "document.getElementById('schquestion21').textContent = '%s';" +
                        "document.getElementById('schquestion22').textContent = '%s';" +
                        "document.getElementById('schquestion23').textContent = '%s';" +
                        "document.getElementById('schquestion24').textContent = '%s';" +
                        "document.getElementById('schquestion25').textContent = '%s';" +
                        "document.getElementById('schquestion26').textContent = '%s';" +
                        "document.getElementById('schquestion27').textContent = '%s';" +
                        "document.getElementById('schquestion28').textContent = '%s';" +
                        "document.getElementById('schquestion29').textContent = '%s';" +
                        "document.getElementById('schquestion30').textContent = '%s';" +
                        "document.getElementById('schquestion31').textContent = '%s';" +
                        "document.getElementById('schquestion32').textContent = '%s';" +
                        "document.getElementById('schquestion33').textContent = '%s';" +
                        "document.getElementById('schquestion34').textContent = '%s';" +
                        "document.getElementById('school_location').textContent = '%s';" +
                        "document.getElementById('farmer_photo').src = '%s';" +
                        "document.getElementById('on_create').textContent = '%s';" +
                        "document.getElementById('on_update').textContent = '%s';" +
                        "document.getElementById('user_fname').textContent = '%s';" +
                        "document.getElementById('user_lname').textContent = '%s';" +
                        "document.getElementById('user_email').textContent = '%s';" +
                        "document.getElementById('signature').src = '%s';",
                sanitize(schoolModel.getSch_name()),
                sanitize(schoolModel.getSch_district()),
                sanitize(schoolModel.getSch_community()),
                sanitize(schoolModel.getSchquestion4()),
                sanitize(schoolModel.getSchquestion5()),
                sanitize(schoolModel.getSchquestion6()),
                sanitize(schoolModel.getSchquestion7()),
                sanitize(schoolModel.getSchquestion8()),
                sanitize(schoolModel.getSchquestion9()),
                sanitize(schoolModel.getSchquestion10()),
                sanitize(schoolModel.getSchquestion11()),
                sanitize(schoolModel.getSchquestion12()),
                sanitize(schoolModel.getSchquestion13()),
                sanitize(schoolModel.getSchquestion14()),
                sanitize(schoolModel.getSchquestion15()),
                sanitize(schoolModel.getSchquestion16()),
                sanitize(schoolModel.getSchquestion17()),
                sanitize(schoolModel.getSchquestion18()),
                sanitize(schoolModel.getSchquestion19()),
                sanitize(schoolModel.getSchquestion20()),
                sanitize(schoolModel.getSchquestion21()),
                sanitize(schoolModel.getSchquestion22()),
                sanitize(schoolModel.getSchquestion23()),
                sanitize(schoolModel.getSchquestion24()),
                sanitize(schoolModel.getSchquestion25()),
                sanitize(schoolModel.getSchquestion26()),
                sanitize(schoolModel.getSchquestion27()),
                sanitize(schoolModel.getSchquestion28()),
                sanitize(schoolModel.getSchquestion29()),
                sanitize(schoolModel.getSchquestion30()),
                sanitize(schoolModel.getSchquestion31()),
                sanitize(schoolModel.getSchquestion32()),
                sanitize(schoolModel.getSchquestion33()),
                sanitize(schoolModel.getSchquestion34()),
                sanitize(schoolModel.getSch_location()),
                schoolModel.getFarmer_photo() != null ? sanitize(schoolModel.getFarmer_photo().toString()) : "",
                sanitize(schoolModel.getOnCreate()),
                sanitize(schoolModel.getOnUpdate()),
                sanitize(schoolModel.getUserFname()),
                sanitize(schoolModel.getUserLname()),
                sanitize(schoolModel.getUserEmail()),
                sanitize(signatureUri));

        schoolSurveyDetailsWebView.evaluateJavascript(js, null);
    }

    private String sanitize(String input) {
        return input != null ? input.replace("'", "\\'") : "";
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.surveyed_school);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}