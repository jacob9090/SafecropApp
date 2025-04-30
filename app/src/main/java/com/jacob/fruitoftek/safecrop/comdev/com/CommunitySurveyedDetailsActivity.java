package com.jacob.fruitoftek.safecrop.comdev.com;

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

public class CommunitySurveyedDetailsActivity extends AppCompatActivity {

    private WebView comSurveyDetailsWebView;
    private ComModel comModel;
    private ComDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community_surveyed_details);
        
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        comSurveyDetailsWebView = findViewById(R.id.comSurveyDetailsWebView);
        comSurveyDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new ComDbHelper(this);

        // Retrieve SchoolModel from the Intent
        comModel = getIntent().getParcelableExtra("com_model");

        if (comModel != null) {
            loadSurveyDetails();
        } else {
            Toast.makeText(this, "Community details are missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        comSurveyDetailsWebView.loadUrl("file:///android_asset/com/comsurveydetails.html");

        // Inject survey details after the page loads
        comSurveyDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        if (comModel == null) return;

        String signaturePath = comModel.getSignature();
        String signatureUri = "";

        if (signaturePath != null && !signaturePath.isEmpty()) {
            File signatureFile = new File(signaturePath);
            if (signatureFile.exists()) {
                signatureUri = FileProvider.getUriForFile(this,
                        getPackageName() + ".fileprovider", signatureFile).toString();
            }
        }

        String js = String.format("javascript:" +
                        "document.getElementById('commquestion1').textContent = '%s';" +
                        "document.getElementById('commquestion2').textContent = '%s';" +
                        "document.getElementById('commquestion3').textContent = '%s';" +
                        "document.getElementById('commquestion4').textContent = '%s';" +
                        "document.getElementById('commquestion5').textContent = '%s';" +
                        "document.getElementById('commquestion6').textContent = '%s';" +
                        "document.getElementById('commquestion7').textContent = '%s';" +
                        "document.getElementById('commquestion8').textContent = '%s';" +
                        "document.getElementById('commquestion9').textContent = '%s';" +
                        "document.getElementById('commquestion10').textContent = '%s';" +
                        "document.getElementById('commquestion11').textContent = '%s';" +
                        "document.getElementById('commquestion12').textContent = '%s';" +
                        "document.getElementById('commquestion13').textContent = '%s';" +
                        "document.getElementById('commquestion14').textContent = '%s';" +
                        "document.getElementById('commquestion15').textContent = '%s';" +
                        "document.getElementById('commquestion16').textContent = '%s';" +
                        "document.getElementById('commquestion17').textContent = '%s';" +
                        "document.getElementById('commquestion18').textContent = '%s';" +
                        "document.getElementById('commquestion19').textContent = '%s';" +
                        "document.getElementById('commquestion20').textContent = '%s';" +
                        "document.getElementById('commquestion21').textContent = '%s';" +
                        "document.getElementById('commquestion22').textContent = '%s';" +
                        "document.getElementById('commquestion23').textContent = '%s';" +
                        "document.getElementById('commquestion24').textContent = '%s';" +
                        "document.getElementById('commquestion25').textContent = '%s';" +
                        "document.getElementById('commquestion26').textContent = '%s';" +
                        "document.getElementById('commquestion27').textContent = '%s';" +
                        "document.getElementById('commquestion28').textContent = '%s';" +
                        "document.getElementById('commquestion29').textContent = '%s';" +
                        "document.getElementById('commquestion30').textContent = '%s';" +
                        "document.getElementById('commquestion31').textContent = '%s';" +
                        "document.getElementById('commquestion32').textContent = '%s';" +
                        "document.getElementById('commquestion33').textContent = '%s';" +
                        "document.getElementById('commquestion34').textContent = '%s';" +
                        "document.getElementById('commquestion35').textContent = '%s';" +
                        "document.getElementById('commquestion36').textContent = '%s';" +
                        "document.getElementById('commquestion37').textContent = '%s';" +
                        "document.getElementById('commquestion38').textContent = '%s';" +
                        "document.getElementById('commquestion39').textContent = '%s';" +
                        "document.getElementById('commquestion40').textContent = '%s';" +
                        "document.getElementById('commquestion41').textContent = '%s';" +
                        "document.getElementById('commquestion42').textContent = '%s';" +
                        "document.getElementById('commquestion43').textContent = '%s';" +
                        "document.getElementById('commquestion44').textContent = '%s';" +
                        "document.getElementById('commquestion45').textContent = '%s';" +
                        "document.getElementById('commquestion46').textContent = '%s';" +
                        "document.getElementById('commquestion47').textContent = '%s';" +
                        "document.getElementById('commquestion48').textContent = '%s';" +
                        "document.getElementById('commquestion49').textContent = '%s';" +
                        "document.getElementById('commquestion50').textContent = '%s';" +
                        "document.getElementById('commquestion51').textContent = '%s';" +
                        "document.getElementById('commquestion52').textContent = '%s';" +
                        "document.getElementById('commquestion53').textContent = '%s';" +
                        "document.getElementById('commquestion54').textContent = '%s';" +
                        "document.getElementById('commquestion56').textContent = '%s';" +
                        "document.getElementById('commquestion57').textContent = '%s';" +
                        "document.getElementById('commquestion58').textContent = '%s';" +
                        "document.getElementById('commquestion59').textContent = '%s';" +
                        "document.getElementById('commquestion60').textContent = '%s';" +
                        "document.getElementById('commquestion61').textContent = '%s';" +
                        "document.getElementById('commquestion62').textContent = '%s';" +
                        "document.getElementById('commquestion63').textContent = '%s';" +
                        "document.getElementById('commquestion64').textContent = '%s';" +
                        "document.getElementById('commquestion65').textContent = '%s';" +
                        "document.getElementById('commquestion66').textContent = '%s';" +
                        "document.getElementById('commquestion67').textContent = '%s';" +
                        "document.getElementById('com_location').textContent = '%s';" +
                        "document.getElementById('farmer_photo').src = '%s';" +
                        "document.getElementById('on_create').textContent = '%s';" +
                        "document.getElementById('on_update').textContent = '%s';" +
                        "document.getElementById('user_fname').textContent = '%s';" +
                        "document.getElementById('user_oname').textContent = '%s';" +
                        "document.getElementById('user_email').textContent = '%s';" +
                        "document.getElementById('signature').src = '%s';",
                sanitize(comModel.getCommquestion1()),
                sanitize(comModel.getCommquestion2()),
                sanitize(comModel.getCommquestion3()),
                sanitize(comModel.getCommquestion4()),
                sanitize(comModel.getCommquestion5()),
                sanitize(comModel.getCommquestion6()),
                sanitize(comModel.getCommquestion7()),
                sanitize(comModel.getCommquestion8()),
                sanitize(comModel.getCommquestion9()),
                sanitize(comModel.getCommquestion10()),
                sanitize(comModel.getCommquestion11()),
                sanitize(comModel.getCommquestion12()),
                sanitize(comModel.getCommquestion13()),
                sanitize(comModel.getCommquestion14()),
                sanitize(comModel.getCommquestion15()),
                sanitize(comModel.getCommquestion16()),
                sanitize(comModel.getCommquestion17()),
                sanitize(comModel.getCommquestion18()),
                sanitize(comModel.getCommquestion19()),
                sanitize(comModel.getCommquestion20()),
                sanitize(comModel.getCommquestion21()),
                sanitize(comModel.getCommquestion22()),
                sanitize(comModel.getCommquestion23()),
                sanitize(comModel.getCommquestion24()),
                sanitize(comModel.getCommquestion25()),
                sanitize(comModel.getCommquestion26()),
                sanitize(comModel.getCommquestion27()),
                sanitize(comModel.getCommquestion28()),
                sanitize(comModel.getCommquestion29()),
                sanitize(comModel.getCommquestion30()),
                sanitize(comModel.getCommquestion31()),
                sanitize(comModel.getCommquestion32()),
                sanitize(comModel.getCommquestion33()),
                sanitize(comModel.getCommquestion34()),
                sanitize(comModel.getCommquestion35()),
                sanitize(comModel.getCommquestion36()),
                sanitize(comModel.getCommquestion37()),
                sanitize(comModel.getCommquestion38()),
                sanitize(comModel.getCommquestion39()),
                sanitize(comModel.getCommquestion40()),
                sanitize(comModel.getCommquestion41()),
                sanitize(comModel.getCommquestion42()),
                sanitize(comModel.getCommquestion43()),
                sanitize(comModel.getCommquestion44()),
                sanitize(comModel.getCommquestion45()),
                sanitize(comModel.getCommquestion46()),
                sanitize(comModel.getCommquestion47()),
                sanitize(comModel.getCommquestion48()),
                sanitize(comModel.getCommquestion49()),
                sanitize(comModel.getCommquestion50()),
                sanitize(comModel.getCommquestion51()),
                sanitize(comModel.getCommquestion52()),
                sanitize(comModel.getCommquestion53()),
                sanitize(comModel.getCommquestion54()),
                sanitize(comModel.getCommquestion56()),
                sanitize(comModel.getCommquestion57()),
                sanitize(comModel.getCommquestion58()),
                sanitize(comModel.getCommquestion59()),
                sanitize(comModel.getCommquestion60()),
                sanitize(comModel.getCommquestion61()),
                sanitize(comModel.getCommquestion62()),
                sanitize(comModel.getCommquestion63()),
                sanitize(comModel.getCommquestion64()),
                sanitize(comModel.getCommquestion65()),
                sanitize(comModel.getCommquestion66()),
                sanitize(comModel.getCommquestion67()),
                sanitize(comModel.getCom_location()),
                comModel.getFarmer_photo() != null ? sanitize(comModel.getFarmer_photo().toString()) : "",
                sanitize(comModel.getOnCreate()),
                sanitize(comModel.getOnUpdate()),
                sanitize(comModel.getUserFname()),
                sanitize(comModel.getUserOname()),
                sanitize(comModel.getUserEmail()),
                sanitize(signatureUri));

        comSurveyDetailsWebView.evaluateJavascript(js, null);
    }

    private String sanitize(String input) {
        return input != null ? input.replace("'", "\\'") : "";
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.surveyed_com);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}