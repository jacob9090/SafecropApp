package com.jacob.fruitoftek.safecrop.comdev.hh;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.WindowCompat;

import com.jacob.fruitoftek.safecrop.R;

import java.io.File;

public class HhSurveyedDetailsActivity extends AppCompatActivity {

    private WebView hhSurveyDetailsWebView;
    private HhModel hhModel;
    private HhDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hh_surveyed_details);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        hhSurveyDetailsWebView = findViewById(R.id.hhSurveyDetailsWebView);
        hhSurveyDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new HhDbHelper(this);

        // Retrieve SchoolModel from the Intent
        hhModel = getIntent().getParcelableExtra("hh_model");

        if (hhModel != null) {
            loadSurveyDetails();
        } else {
            Toast.makeText(this, "School details are missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        hhSurveyDetailsWebView.loadUrl("file:///android_asset/hh/hhsurveydetails.html");

        // Inject survey details after the page loads
        hhSurveyDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        if (hhModel == null) return;

        String signaturePath = hhModel.getSignature();
        String signatureUri = "";

        if (signaturePath != null && !signaturePath.isEmpty()) {
            File signatureFile = new File(signaturePath);
            if (signatureFile.exists()) {
                signatureUri = FileProvider.getUriForFile(this,
                        getPackageName() + ".fileprovider", signatureFile).toString();
            }
        }

        String js = String.format("javascript:" +
                        "document.getElementById('hh_name').textContent = '%s';" +
                        "document.getElementById('hh_district').textContent = '%s';" +
                        "document.getElementById('hh_community').textContent = '%s';" +
                        "document.getElementById('hhquestion4').textContent = '%s';" +
                        "document.getElementById('hhquestion5').textContent = '%s';" +
                        "document.getElementById('hhquestion6').textContent = '%s';" +
                        "document.getElementById('hhquestion7').textContent = '%s';" +
                        "document.getElementById('hhquestion8').textContent = '%s';" +
                        "document.getElementById('hhquestion9').textContent = '%s';" +
                        "document.getElementById('hhquestion10').textContent = '%s';" +
                        "document.getElementById('hhquestion11').textContent = '%s';" +
                        "document.getElementById('hhquestion12').textContent = '%s';" +
                        "document.getElementById('hhquestion13').textContent = '%s';" +
                        "document.getElementById('hhquestion14').textContent = '%s';" +
                        "document.getElementById('hhquestion15').textContent = '%s';" +
                        "document.getElementById('hhquestion16').textContent = '%s';" +
                        "document.getElementById('hhquestion17').textContent = '%s';" +
                        "document.getElementById('hhquestion18').textContent = '%s';" +
                        "document.getElementById('hhquestion19').textContent = '%s';" +
                        "document.getElementById('hhquestion20').textContent = '%s';" +
                        "document.getElementById('hhquestion21').textContent = '%s';" +
                        "document.getElementById('hhquestion22').textContent = '%s';" +
                        "document.getElementById('hhquestion23').textContent = '%s';" +
                        "document.getElementById('hhquestion24').textContent = '%s';" +
                        "document.getElementById('hhquestion25').textContent = '%s';" +
                        "document.getElementById('hhquestion26').textContent = '%s';" +
                        "document.getElementById('hhquestion27').textContent = '%s';" +
                        "document.getElementById('hhquestion28').textContent = '%s';" +
                        "document.getElementById('hhquestion29').textContent = '%s';" +
                        "document.getElementById('hhquestion30').textContent = '%s';" +
                        "document.getElementById('hhquestion31').textContent = '%s';" +
                        "document.getElementById('hhquestion32').textContent = '%s';" +
                        "document.getElementById('hhquestion36').textContent = '%s';" +
                        "document.getElementById('hhquestion37').textContent = '%s';" +
                        "document.getElementById('hh_location').textContent = '%s';" +
                        "document.getElementById('farmer_photo').src = '%s';" +
                        "document.getElementById('on_create').textContent = '%s';" +
                        "document.getElementById('on_update').textContent = '%s';" +
                        "document.getElementById('user_fname').textContent = '%s';" +
                        "document.getElementById('user_oname').textContent = '%s';" +
                        "document.getElementById('user_email').textContent = '%s';" +
                        "document.getElementById('signature').src = '%s';",
                sanitize(hhModel.getHh_name()),
                sanitize(hhModel.getHh_district()),
                sanitize(hhModel.getHh_community()),
                sanitize(hhModel.getHhquestion4()),
                sanitize(hhModel.getHhquestion5()),
                sanitize(hhModel.getHhquestion6()),
                sanitize(hhModel.getHhquestion7()),
                sanitize(hhModel.getHhquestion8()),
                sanitize(hhModel.getHhquestion9()),
                sanitize(hhModel.getHhquestion10()),
                sanitize(hhModel.getHhquestion11()),
                sanitize(hhModel.getHhquestion12()),
                sanitize(hhModel.getHhquestion13()),
                sanitize(hhModel.getHhquestion14()),
                sanitize(hhModel.getHhquestion15()),
                sanitize(hhModel.getHhquestion16()),
                sanitize(hhModel.getHhquestion17()),
                sanitize(hhModel.getHhquestion18()),
                sanitize(hhModel.getHhquestion19()),
                sanitize(hhModel.getHhquestion20()),
                sanitize(hhModel.getHhquestion21()),
                sanitize(hhModel.getHhquestion22()),
                sanitize(hhModel.getHhquestion23()),
                sanitize(hhModel.getHhquestion24()),
                sanitize(hhModel.getHhquestion25()),
                sanitize(hhModel.getHhquestion26()),
                sanitize(hhModel.getHhquestion27()),
                sanitize(hhModel.getHhquestion28()),
                sanitize(hhModel.getHhquestion29()),
                sanitize(hhModel.getHhquestion30()),
                sanitize(hhModel.getHhquestion31()),
                sanitize(hhModel.getHhquestion32()),
                sanitize(hhModel.getHhquestion36()),
                sanitize(hhModel.getHhquestion37()),
                sanitize(hhModel.getHh_location()),
                hhModel.getFarmer_photo() != null ? sanitize(hhModel.getFarmer_photo().toString()) : "",
                sanitize(hhModel.getOnCreate()),
                sanitize(hhModel.getOnUpdate()),
                sanitize(hhModel.getUserFname()),
                sanitize(hhModel.getUserOname()),
                sanitize(hhModel.getUserEmail()),
                sanitize(signatureUri));

        hhSurveyDetailsWebView.evaluateJavascript(js, null);
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