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
                        "document.getElementById('district').textContent = '%s';" +
                        "document.getElementById('community').textContent = '%s';" +
                        "document.getElementById('farmer_id').textContent = '%s';" +
                        "document.getElementById('farmer_name').textContent = '%s';" +
                        "document.getElementById('ghana_card').textContent = '%s';" +
                        "document.getElementById('farmer_yob').textContent = '%s';" +
                        "document.getElementById('phone_number').textContent = '%s';" +
                        "document.getElementById('gender').textContent = '%s';" +
                        "document.getElementById('inspection_date').textContent = '%s';" +
                        "document.getElementById('inspector_name').textContent = '%s';" +
                        "document.getElementById('inspection_question1').textContent = '%s';" +
                        "document.getElementById('inspection_question2').textContent = '%s';" +
                        "document.getElementById('inspection_question3').textContent = '%s';" +
                        "document.getElementById('inspection_question4').textContent = '%s';" +
                        "document.getElementById('inspection_question5').textContent = '%s';" +
                        "document.getElementById('inspection_question6').textContent = '%s';" +
                        "document.getElementById('inspection_question7').textContent = '%s';" +
                        "document.getElementById('inspection_question8').textContent = '%s';" +
                        "document.getElementById('inspection_question9').textContent = '%s';" +
                        "document.getElementById('inspection_question10').textContent = '%s';" +
                        "document.getElementById('inspection_question11').textContent = '%s';" +
                        "document.getElementById('inspection_question12').textContent = '%s';" +
                        "document.getElementById('inspection_question13').textContent = '%s';" +
                        "document.getElementById('inspection_question14').textContent = '%s';" +
                        "document.getElementById('inspection_question15').textContent = '%s';" +
                        "document.getElementById('inspection_question16').textContent = '%s';" +
                        "document.getElementById('inspection_question17').textContent = '%s';" +
                        "document.getElementById('inspection_question18').textContent = '%s';" +
                        "document.getElementById('inspection_question19').textContent = '%s';" +
                        "document.getElementById('inspection_question20').textContent = '%s';" +
                        "document.getElementById('inspection_question21').textContent = '%s';" +
                        "document.getElementById('inspection_question22').textContent = '%s';" +
                        "document.getElementById('inspection_question23').textContent = '%s';" +
                        "document.getElementById('inspection_question24').textContent = '%s';" +
                        "document.getElementById('inspection_question25').textContent = '%s';" +
                        "document.getElementById('inspection_question26').textContent = '%s';" +
                        "document.getElementById('inspection_question27').textContent = '%s';" +
                        "document.getElementById('inspection_question28').textContent = '%s';" +
                        "document.getElementById('inspection_question29').textContent = '%s';" +
                        "document.getElementById('inspection_question30').textContent = '%s';" +
                        "document.getElementById('inspection_question31').textContent = '%s';" +
                        "document.getElementById('inspection_question32').textContent = '%s';" +
                        "document.getElementById('inspection_question33').textContent = '%s';" +
                        "document.getElementById('inspection_question34').textContent = '%s';" +
                        "document.getElementById('inspection_question35').textContent = '%s';" +
                        "document.getElementById('inspection_question36').textContent = '%s';" +
                        "document.getElementById('inspection_question37').textContent = '%s';" +
                        "document.getElementById('inspection_question38').textContent = '%s';" +
                        "document.getElementById('inspection_question39').textContent = '%s';" +
                        "document.getElementById('inspection_question40').textContent = '%s';" +
                        "document.getElementById('inspection_question41').textContent = '%s';" +
                        "document.getElementById('inspection_question42').textContent = '%s';" +
                        "document.getElementById('inspection_question43').textContent = '%s';" +
                        "document.getElementById('inspection_question44').textContent = '%s';" +
                        "document.getElementById('inspection_question45').textContent = '%s';" +
                        "document.getElementById('inspection_question46').textContent = '%s';" +
                        "document.getElementById('inspection_question47').textContent = '%s';" +
                        "document.getElementById('inspection_question48').textContent = '%s';" +
                        "document.getElementById('inspection_question49').textContent = '%s';" +
                        "document.getElementById('inspection_question50').textContent = '%s';" +
                        "document.getElementById('inspection_question51').textContent = '%s';" +
                        "document.getElementById('inspection_question52').textContent = '%s';" +
                        "document.getElementById('inspection_question53').textContent = '%s';" +
                        "document.getElementById('inspection_question54').textContent = '%s';" +
                        "document.getElementById('inspection_question55').textContent = '%s';" +
                        "document.getElementById('inspection_question56').textContent = '%s';" +
                        "document.getElementById('inspection_question57').textContent = '%s';" +
                        "document.getElementById('inspection_question58').textContent = '%s';" +
                        "document.getElementById('inspection_question59').textContent = '%s';" +
                        "document.getElementById('inspection_question60').textContent = '%s';" +
                        "document.getElementById('inspection_question61').textContent = '%s';" +
                        "document.getElementById('inspection_question62').textContent = '%s';" +
                        "document.getElementById('inspection_question63').textContent = '%s';" +
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
                sanitize(inspectionModel.getDistrict()),
                sanitize(inspectionModel.getCommunity()),
                sanitize(inspectionModel.getFarmer_id()),
                sanitize(inspectionModel.getFarmer_name()),
                sanitize(inspectionModel.getGhana_card()),
                sanitize(inspectionModel.getFarmer_yob()),
                sanitize(inspectionModel.getPhone_number()),
                sanitize(inspectionModel.getGender()),
                sanitize(inspectionModel.getInspection_date()),
                sanitize(inspectionModel.getInspector_name()),
                sanitize(inspectionModel.getInspection_question1()),
                sanitize(inspectionModel.getInspection_question2()),
                sanitize(inspectionModel.getInspection_question3()),
                sanitize(inspectionModel.getInspection_question4()),
                sanitize(inspectionModel.getInspection_question5()),
                sanitize(inspectionModel.getInspection_question6()),
                sanitize(inspectionModel.getInspection_question7()),
                sanitize(inspectionModel.getInspection_question8()),
                sanitize(inspectionModel.getInspection_question9()),
                sanitize(inspectionModel.getInspection_question10()),
                sanitize(inspectionModel.getInspection_question11()),
                sanitize(inspectionModel.getInspection_question12()),
                sanitize(inspectionModel.getInspection_question13()),
                sanitize(inspectionModel.getInspection_question14()),
                sanitize(inspectionModel.getInspection_question15()),
                sanitize(inspectionModel.getInspection_question16()),
                sanitize(inspectionModel.getInspection_question17()),
                sanitize(inspectionModel.getInspection_question18()),
                sanitize(inspectionModel.getInspection_question19()),
                sanitize(inspectionModel.getInspection_question20()),
                sanitize(inspectionModel.getInspection_question21()),
                sanitize(inspectionModel.getInspection_question22()),
                sanitize(inspectionModel.getInspection_question23()),
                sanitize(inspectionModel.getInspection_question24()),
                sanitize(inspectionModel.getInspection_question25()),
                sanitize(inspectionModel.getInspection_question26()),
                sanitize(inspectionModel.getInspection_question27()),
                sanitize(inspectionModel.getInspection_question28()),
                sanitize(inspectionModel.getInspection_question29()),
                sanitize(inspectionModel.getInspection_question30()),
                sanitize(inspectionModel.getInspection_question31()),
                sanitize(inspectionModel.getInspection_question32()),
                sanitize(inspectionModel.getInspection_question33()),
                sanitize(inspectionModel.getInspection_question34()),
                sanitize(inspectionModel.getInspection_question35()),
                sanitize(inspectionModel.getInspection_question36()),
                sanitize(inspectionModel.getInspection_question37()),
                sanitize(inspectionModel.getInspection_question38()),
                sanitize(inspectionModel.getInspection_question39()),
                sanitize(inspectionModel.getInspection_question40()),
                sanitize(inspectionModel.getInspection_question41()),
                sanitize(inspectionModel.getInspection_question42()),
                sanitize(inspectionModel.getInspection_question43()),
                sanitize(inspectionModel.getInspection_question44()),
                sanitize(inspectionModel.getInspection_question45()),
                sanitize(inspectionModel.getInspection_question46()),
                sanitize(inspectionModel.getInspection_question47()),
                sanitize(inspectionModel.getInspection_question48()),
                sanitize(inspectionModel.getInspection_question49()),
                sanitize(inspectionModel.getInspection_question50()),
                sanitize(inspectionModel.getInspection_question51()),
                sanitize(inspectionModel.getInspection_question52()),
                sanitize(inspectionModel.getInspection_question53()),
                sanitize(inspectionModel.getInspection_question54()),
                sanitize(inspectionModel.getInspection_question55()),
                sanitize(inspectionModel.getInspection_question56()),
                sanitize(inspectionModel.getInspection_question57()),
                sanitize(inspectionModel.getInspection_question58()),
                sanitize(inspectionModel.getInspection_question59()),
                sanitize(inspectionModel.getInspection_question60()),
                sanitize(inspectionModel.getInspection_question61()),
                sanitize(inspectionModel.getInspection_question62()),
                sanitize(inspectionModel.getInspection_question63()),
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