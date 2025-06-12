package com.jacob.fruitoftek.safecrop.comdev.cra;

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

public class CraSurveyedDetailsActivity extends AppCompatActivity {
    
    private WebView craSurveyDetailsWebView;
    private CraModel craModel;
    private CraDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cra_surveyed_details);
        
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        craSurveyDetailsWebView = findViewById(R.id.craSurveyDetailsWebView);
        craSurveyDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new CraDbHelper(this);

        // Retrieve CraModel from the Intent
        craModel = getIntent().getParcelableExtra("gra_model");

        if (craModel != null) {
            loadSurveyDetails();
        } else {
            Toast.makeText(this, "Gra details are missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        craSurveyDetailsWebView.loadUrl("file:///android_asset/comra/cradetails.html");

        // Inject survey details after the page loads
        craSurveyDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        if (craModel == null) return;

        String signaturePath = craModel.getSignature();
        String signatureUri = "";

        if (signaturePath != null && !signaturePath.isEmpty()) {
            File signatureFile = new File(signaturePath);
            if (signatureFile.exists()) {
                signatureUri = FileProvider.getUriForFile(this,
                        getPackageName() + ".fileprovider", signatureFile).toString();
            }
        }

        String js = String.format("javascript:" +
                        "document.getElementById('craquestion1').textContent = '%s';" +
                        "document.getElementById('craquestion2').textContent = '%s';" +
                        "document.getElementById('craquestion3').textContent = '%s';" +
                        "document.getElementById('craquestion4').textContent = '%s';" +
                        "document.getElementById('craquestion5').textContent = '%s';" +
                        "document.getElementById('craquestion6').textContent = '%s';" +
                        "document.getElementById('craquestion7').textContent = '%s';" +
                        "document.getElementById('craquestion8').textContent = '%s';" +
                        "document.getElementById('craquestion9').textContent = '%s';" +
                        "document.getElementById('craquestion10').textContent = '%s';" +
                        "document.getElementById('craquestion11').textContent = '%s';" +
                        "document.getElementById('craquestion12').textContent = '%s';" +
                        "document.getElementById('craquestion13').textContent = '%s';" +
                        "document.getElementById('cra_location').textContent = '%s';" +
                        "document.getElementById('on_create').textContent = '%s';" +
                        "document.getElementById('on_update').textContent = '%s';" +
                        "document.getElementById('user_fname').textContent = '%s';" +
                        "document.getElementById('user_lname').textContent = '%s';" +
                        "document.getElementById('user_email').textContent = '%s';" +
                        "document.getElementById('signature').src = '%s';",
                sanitize(craModel.getCraquestion1()),
                sanitize(craModel.getCraquestion2()),
                sanitize(craModel.getCraquestion3()),
                sanitize(craModel.getCraquestion4()),
                sanitize(craModel.getCraquestion5()),
                sanitize(craModel.getCraquestion6()),
                sanitize(craModel.getCraquestion7()),
                sanitize(craModel.getCraquestion8()),
                sanitize(craModel.getCraquestion9()),
                sanitize(craModel.getCraquestion10()),
                sanitize(craModel.getCraquestion11()),
                sanitize(craModel.getCraquestion12()),
                sanitize(craModel.getCraquestion13()),
                sanitize(craModel.getCra_location()),
                sanitize(craModel.getOnCreate()),
                sanitize(craModel.getOnUpdate()),
                sanitize(craModel.getUserFname()),
                sanitize(craModel.getUserLname()),
                sanitize(craModel.getUserEmail()),
                sanitize(signatureUri));

        craSurveyDetailsWebView.evaluateJavascript(js, null);
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