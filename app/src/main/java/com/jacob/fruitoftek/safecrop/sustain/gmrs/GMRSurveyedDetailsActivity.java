package com.jacob.fruitoftek.safecrop.sustain.gmrs;

import android.net.Uri;
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

public class GMRSurveyedDetailsActivity extends AppCompatActivity {

    private WebView gmrSurveyDetailsWebView;
    private GMRModel gmrModel;
    private GMRDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gmrsurveyed_details);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        gmrSurveyDetailsWebView = findViewById(R.id.gmrSurveyDetailsWebView);
        gmrSurveyDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new GMRDbHelper(this);

        // Retrieve farmer code from the Intent
        String gmrquestion5 = getIntent().getStringExtra("farmer_code");

        if (gmrquestion5 != null) {
            gmrModel = dbHelper.getSurveyDetailsByFarmerCode(gmrquestion5);
            if (gmrModel != null) {
                loadSurveyDetails();
            } else {
                Toast.makeText(this, "Survey details not found.", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            Toast.makeText(this, "Farmer code is missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        gmrSurveyDetailsWebView.loadUrl("file:///android_asset/gmr/gmrsurveydetails.html");

        // Inject survey details after the page loads
        gmrSurveyDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        String signaturePath = gmrModel.getSignature();

        if (signaturePath != null && !signaturePath.isEmpty()) {
            File signatureFile = new File(signaturePath);
            Uri signatureUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", signatureFile);

            String js = "javascript:document.getElementById('userFname').textContent = '" + gmrModel.getUserFname() + "';" +
                    "document.getElementById('userOname').textContent = '" + gmrModel.getUserOname() + "';" +
                    "document.getElementById('gmrquestion5').textContent = '" + gmrModel.getGmrquestion5() + "';" +
                    "document.getElementById('idPhoto').src = '" + gmrModel.getIdPhoto().toString() + "';" +
                    "document.getElementById('farmerPhoto').src = '" + gmrModel.getFarmerPhoto().toString() + "';" +
                    "document.getElementById('tpPhoto').src = '" + gmrModel.getTpPhoto().toString() + "';" +
                    "document.getElementById('onCreate').textContent = '" + gmrModel.getOnCreate() + "';" +
                    "document.getElementById('onUpdate').textContent = '" + gmrModel.getOnUpdate() + "';" +
                    "document.getElementById('signature').src = '" + signatureUri.toString() + "';";
            gmrSurveyDetailsWebView.evaluateJavascript(js, null);
        } else {
            String js = "javascript:document.getElementById('userFname').textContent = '" + gmrModel.getUserFname() + "';" +
                    "document.getElementById('userOname').textContent = '" + gmrModel.getUserOname() + "';" +
                    "document.getElementById('gmrquestion5').textContent = '" + gmrModel.getGmrquestion5() + "';" +
                    "document.getElementById('idPhoto').src = '" + gmrModel.getIdPhoto().toString() + "';" +
                    "document.getElementById('farmerPhoto').src = '" + gmrModel.getFarmerPhoto().toString() + "';" +
                    "document.getElementById('tpPhoto').src = '" + gmrModel.getTpPhoto().toString() + "';" +
                    "document.getElementById('onCreate').textContent = '" + gmrModel.getOnCreate() + "';" +
                    "document.getElementById('onUpdate').textContent = '" + gmrModel.getOnUpdate() + "';" +
                    "document.getElementById('signature').alt = 'Signature not available';";
            gmrSurveyDetailsWebView.evaluateJavascript(js, null);
        }
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.farmer_details);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}