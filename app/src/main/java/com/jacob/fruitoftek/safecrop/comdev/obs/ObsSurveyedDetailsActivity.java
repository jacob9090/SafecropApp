package com.jacob.fruitoftek.safecrop.comdev.obs;

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

public class ObsSurveyedDetailsActivity extends AppCompatActivity {

    private WebView obsSurveyDetailsWebView;
    private ObsModel obsModel;
    private ObsDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obs_surveyed_details);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        obsSurveyDetailsWebView = findViewById(R.id.obsSurveyDetailsWebView);
        obsSurveyDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new ObsDbHelper(this);

        // Retrieve ObsModel from the Intent
        obsModel = getIntent().getParcelableExtra("obs_model");

        if (obsModel != null) {
            loadSurveyDetails();
        } else {
            Toast.makeText(this, "Observation details are missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        obsSurveyDetailsWebView.loadUrl("file:///android_asset/obs/obssurveydetails.html");

        // Inject survey details after the page loads
        obsSurveyDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        if (obsModel == null) return;

        String signaturePath = obsModel.getSignature();
        String signatureUri = "";

        if (signaturePath != null && !signaturePath.isEmpty()) {
            File signatureFile = new File(signaturePath);
            if (signatureFile.exists()) {
                signatureUri = FileProvider.getUriForFile(this,
                        getPackageName() + ".fileprovider", signatureFile).toString();
            }
        }

        String js = String.format("javascript:" +
                        "document.getElementById('obs_name').textContent = '%s';" +
                        "document.getElementById('obs_district').textContent = '%s';" +
                        "document.getElementById('obs_community').textContent = '%s';" +
                        "document.getElementById('obsquestion6').textContent = '%s';" +
                        "document.getElementById('obsquestion7').textContent = '%s';" +
                        "document.getElementById('obsquestion8').textContent = '%s';" +
                        "document.getElementById('obsquestion9').textContent = '%s';" +
                        "document.getElementById('obsquestion10').textContent = '%s';" +
                        "document.getElementById('obsquestion11').textContent = '%s';" +
                        "document.getElementById('obsquestion12').textContent = '%s';" +
                        "document.getElementById('obsquestion13').textContent = '%s';" +
                        "document.getElementById('obsquestion14').textContent = '%s';" +
                        "document.getElementById('obsquestion15').textContent = '%s';" +
                        "document.getElementById('obsquestion16').textContent = '%s';" +
                        "document.getElementById('obsquestion17').textContent = '%s';" +
                        "document.getElementById('obsquestion18').textContent = '%s';" +
                        "document.getElementById('obsquestion19').textContent = '%s';" +
                        "document.getElementById('obsquestion20').textContent = '%s';" +
                        "document.getElementById('obsquestion21').textContent = '%s';" +
                        "document.getElementById('obs_location').textContent = '%s';" +
                        "document.getElementById('farmer_photo').src = '%s';" +
                        "document.getElementById('on_create').textContent = '%s';" +
                        "document.getElementById('on_update').textContent = '%s';" +
                        "document.getElementById('user_fname').textContent = '%s';" +
                        "document.getElementById('user_oname').textContent = '%s';" +
                        "document.getElementById('user_email').textContent = '%s';" +
                        "document.getElementById('signature').src = '%s';",
                sanitize(obsModel.getObs_name()),
                sanitize(obsModel.getObs_district()),
                sanitize(obsModel.getObs_community()),
                sanitize(obsModel.getObsquestion6()),
                sanitize(obsModel.getObsquestion7()),
                sanitize(obsModel.getObsquestion8()),
                sanitize(obsModel.getObsquestion9()),
                sanitize(obsModel.getObsquestion10()),
                sanitize(obsModel.getObsquestion11()),
                sanitize(obsModel.getObsquestion12()),
                sanitize(obsModel.getObsquestion13()),
                sanitize(obsModel.getObsquestion14()),
                sanitize(obsModel.getObsquestion15()),
                sanitize(obsModel.getObsquestion16()),
                sanitize(obsModel.getObsquestion17()),
                sanitize(obsModel.getObsquestion18()),
                sanitize(obsModel.getObsquestion19()),
                sanitize(obsModel.getObsquestion20()),
                sanitize(obsModel.getObsquestion21()),
                sanitize(obsModel.getObs_location()),
                obsModel.getFarmer_photo() != null ? sanitize(obsModel.getFarmer_photo().toString()) : "",
                sanitize(obsModel.getOnCreate()),
                sanitize(obsModel.getOnUpdate()),
                sanitize(obsModel.getUserFname()),
                sanitize(obsModel.getUserOname()),
                sanitize(obsModel.getUserEmail()),
                sanitize(signatureUri));

        obsSurveyDetailsWebView.evaluateJavascript(js, null);
    }

    private String sanitize(String input) {
        return input != null ? input.replace("'", "\\'") : "";
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.observation_survey);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}