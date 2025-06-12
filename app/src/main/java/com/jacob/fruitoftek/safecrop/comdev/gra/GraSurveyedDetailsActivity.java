package com.jacob.fruitoftek.safecrop.comdev.gra;

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

public class GraSurveyedDetailsActivity extends AppCompatActivity {

    private WebView graSurveyDetailsWebView;
    private GraModel graModel;
    private GraDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gra_surveyed_details);
        
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        graSurveyDetailsWebView = findViewById(R.id.graSurveyDetailsWebView);
        graSurveyDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new GraDbHelper(this);

        // Retrieve GraModel from the Intent
        graModel = getIntent().getParcelableExtra("gra_model");

        if (graModel != null) {
            loadSurveyDetails();
        } else {
            Toast.makeText(this, "Gra details are missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        graSurveyDetailsWebView.loadUrl("file:///android_asset/genderra/gradetails.html");

        // Inject survey details after the page loads
        graSurveyDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        if (graModel == null) return;

        String signaturePath = graModel.getSignature();
        String signatureUri = "";

        if (signaturePath != null && !signaturePath.isEmpty()) {
            File signatureFile = new File(signaturePath);
            if (signatureFile.exists()) {
                signatureUri = FileProvider.getUriForFile(this,
                        getPackageName() + ".fileprovider", signatureFile).toString();
            }
        }

        String js = String.format("javascript:" +
                        "document.getElementById('graquestion1').textContent = '%s';" +
                        "document.getElementById('graquestion2').textContent = '%s';" +
                        "document.getElementById('graquestion3').textContent = '%s';" +
                        "document.getElementById('graquestion4').textContent = '%s';" +
                        "document.getElementById('graquestion5').textContent = '%s';" +
                        "document.getElementById('graquestion6').textContent = '%s';" +
                        "document.getElementById('graquestion7').textContent = '%s';" +
                        "document.getElementById('graquestion8').textContent = '%s';" +
                        "document.getElementById('gra_location').textContent = '%s';" +
                        "document.getElementById('farmer_photo').src = '%s';" +
                        "document.getElementById('on_create').textContent = '%s';" +
                        "document.getElementById('on_update').textContent = '%s';" +
                        "document.getElementById('user_fname').textContent = '%s';" +
                        "document.getElementById('user_lname').textContent = '%s';" +
                        "document.getElementById('user_email').textContent = '%s';" +
                        "document.getElementById('signature').src = '%s';",
                sanitize(graModel.getGraquestion1()),
                sanitize(graModel.getGraquestion2()),
                sanitize(graModel.getGraquestion3()),
                sanitize(graModel.getGraquestion4()),
                sanitize(graModel.getGraquestion5()),
                sanitize(graModel.getGraquestion6()),
                sanitize(graModel.getGraquestion7()),
                sanitize(graModel.getGraquestion8()),
                sanitize(graModel.getGra_location()),
                graModel.getFarmer_photo() != null ? sanitize(graModel.getFarmer_photo().toString()) : "",
                sanitize(graModel.getOnCreate()),
                sanitize(graModel.getOnUpdate()),
                sanitize(graModel.getUserFname()),
                sanitize(graModel.getUserLname()),
                sanitize(graModel.getUserEmail()),
                sanitize(signatureUri));

        graSurveyDetailsWebView.evaluateJavascript(js, null);
    }

    private String sanitize(String input) {
        return input != null ? input.replace("'", "\\'") : "";
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.gender_risk_assessment);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}