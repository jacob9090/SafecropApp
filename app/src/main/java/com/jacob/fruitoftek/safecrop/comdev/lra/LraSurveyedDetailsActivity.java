package com.jacob.fruitoftek.safecrop.comdev.lra;

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

public class LraSurveyedDetailsActivity extends AppCompatActivity {
    
    private WebView lraSurveyDetailsWebView;
    private LraModel lraModel;
    private LraDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lra_surveyed_details);
        
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        lraSurveyDetailsWebView = findViewById(R.id.lraSurveyDetailsWebView);
        lraSurveyDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new LraDbHelper(this);

        // Retrieve LraModel from the Intent
        lraModel = getIntent().getParcelableExtra("gra_model");

        if (lraModel != null) {
            loadSurveyDetails();
        } else {
            Toast.makeText(this, "Gra details are missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    private void loadSurveyDetails() {
        // Load the HTML file from assets
        lraSurveyDetailsWebView.loadUrl("file:///android_asset/clflra/clflradetails.html");

        // Inject survey details after the page loads
        lraSurveyDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        if (lraModel == null) return;

        String signaturePath = lraModel.getSignature();
        String signatureUri = "";

        if (signaturePath != null && !signaturePath.isEmpty()) {
            File signatureFile = new File(signaturePath);
            if (signatureFile.exists()) {
                signatureUri = FileProvider.getUriForFile(this,
                        getPackageName() + ".fileprovider", signatureFile).toString();
            }
        }

        String js = String.format("javascript:" +
                        "document.getElementById('lraquestion1').textContent = '%s';" +
                        "document.getElementById('lraquestion2').textContent = '%s';" +
                        "document.getElementById('lraquestion3').textContent = '%s';" +
                        "document.getElementById('lraquestion4').textContent = '%s';" +
                        "document.getElementById('lraquestion5').textContent = '%s';" +
                        "document.getElementById('lraquestion6').textContent = '%s';" +
                        "document.getElementById('lraquestion7').textContent = '%s';" +
                        "document.getElementById('lraquestion8').textContent = '%s';" +
                        "document.getElementById('lraquestion9').textContent = '%s';" +
                        "document.getElementById('lraquestion10').textContent = '%s';" +
                        "document.getElementById('lra_location').textContent = '%s';" +
                        "document.getElementById('on_create').textContent = '%s';" +
                        "document.getElementById('on_update').textContent = '%s';" +
                        "document.getElementById('user_fname').textContent = '%s';" +
                        "document.getElementById('user_lname').textContent = '%s';" +
                        "document.getElementById('user_email').textContent = '%s';" +
                        "document.getElementById('signature').src = '%s';",
                sanitize(lraModel.getLraquestion1()),
                sanitize(lraModel.getLraquestion2()),
                sanitize(lraModel.getLraquestion3()),
                sanitize(lraModel.getLraquestion4()),
                sanitize(lraModel.getLraquestion5()),
                sanitize(lraModel.getLraquestion6()),
                sanitize(lraModel.getLraquestion7()),
                sanitize(lraModel.getLraquestion8()),
                sanitize(lraModel.getLraquestion9()),
                sanitize(lraModel.getLraquestion10()),
                sanitize(lraModel.getLra_location()),
                sanitize(lraModel.getSignature()),
                sanitize(lraModel.getOnCreate()),
                sanitize(lraModel.getOnUpdate()),
                sanitize(lraModel.getUserFname()),
                sanitize(lraModel.getUserLname()),
                sanitize(lraModel.getUserEmail()),
                sanitize(signatureUri));

        lraSurveyDetailsWebView.evaluateJavascript(js, null);
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