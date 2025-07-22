package com.jacob.fruitoftek.safecrop.sustain.training;

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
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;

import java.io.File;

public class TrainingDetailsActivity extends AppCompatActivity {
    
    private WebView trainingDetailsWebView;
    private TrainingModel trainingModel;
    private TrainingDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_details);

        // Set the status bar appearance
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            int left = insets.getInsets(WindowInsetsCompat.Type.systemBars()).left;
            int top = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            int right = insets.getInsets(WindowInsetsCompat.Type.systemBars()).right;
            int bottom = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
            v.setPadding(left, top, right, bottom);
            return insets;
        });

        setupActionBar();

        trainingDetailsWebView = findViewById(R.id.trainingDetailsWebView);
        trainingDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new TrainingDbHelper(this);

        // Retrieve TrainingModel from the Intent
        trainingModel = getIntent().getParcelableExtra("training_model");

        if (trainingModel != null) {
            loadSurveyDetails();
        } else {
            Toast.makeText(this, "Farmer details are missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        trainingDetailsWebView.loadUrl("file:///android_asset/training/trainingdetails.html");

        // Inject survey details after the page loads
        trainingDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        if (trainingModel == null) return;

        String signaturePath = trainingModel.getSignature();
        String signatureUri = "";

        if (signaturePath != null && !signaturePath.isEmpty()) {
            File signatureFile = new File(signaturePath);
            if (signatureFile.exists()) {
                signatureUri = FileProvider.getUriForFile(this,
                        getPackageName() + ".fileprovider", signatureFile).toString();
            }
        }

        String js = String.format("javascript:" +
                        "document.getElementById('training_code').textContent = '%s';" +
                        "document.getElementById('district').textContent = '%s';" +
                        "document.getElementById('community').textContent = '%s';" +
                        "document.getElementById('training_question1').textContent = '%s';" +
                        "document.getElementById('training_question2').textContent = '%s';" +
                        "document.getElementById('training_question3').textContent = '%s';" +
                        "document.getElementById('training_question4').textContent = '%s';" +
                        "document.getElementById('training_question5').textContent = '%s';" +
                        "document.getElementById('training_question6').textContent = '%s';" +
                        "document.getElementById('training_question7').textContent = '%s';" +
                        "document.getElementById('training_location').textContent = '%s';" +
                        "document.getElementById('farmer_photo').src = '%s';" +
                        "document.getElementById('signature').src = '%s';" +
                        "document.getElementById('training_question8').textContent = '%s';" +
                        "document.getElementById('training_question9').textContent = '%s';" +
                        "document.getElementById('training_question10').textContent = '%s';" +
                        "document.getElementById('training_question11').textContent = '%s';" +
                        "document.getElementById('training_question12').textContent = '%s';" +
                        "document.getElementById('training_question13').textContent = '%s';" +
                        "document.getElementById('training_question14').textContent = '%s';" +
                        "document.getElementById('training_question15').textContent = '%s';" +
                        "document.getElementById('is_sync').textContent = '%s';" +
                        "document.getElementById('is_draft').textContent = '%s';" +
                        "document.getElementById('on_create').textContent = '%s';" +
                        "document.getElementById('on_update').textContent = '%s';" +
                        "document.getElementById('user_fname').textContent = '%s';" +
                        "document.getElementById('user_lname').textContent = '%s';" +
                        "document.getElementById('user_email').textContent = '%s';",

                sanitize(trainingModel.getTraining_code()),
                sanitize(trainingModel.getDistrict()),
                sanitize(trainingModel.getCommunity()),
                sanitize(trainingModel.getTraining_question1()),
                sanitize(trainingModel.getTraining_question2()),
                sanitize(trainingModel.getTraining_question3()),
                sanitize(trainingModel.getTraining_question4()),
                sanitize(trainingModel.getTraining_question5()),
                sanitize(trainingModel.getTraining_question6()),
                sanitize(trainingModel.getTraining_question7()),
                sanitize(trainingModel.getTraining_location()),
                trainingModel.getFarmer_photo() != null ? sanitize(trainingModel.getFarmer_photo().toString()) : "",
                sanitize(signatureUri),
                sanitize(trainingModel.getTraining_question8()),
                sanitize(trainingModel.getTraining_question9()),
                sanitize(trainingModel.getTraining_question10()),
                sanitize(trainingModel.getTraining_question11()),
                sanitize(trainingModel.getTraining_question12()),
                sanitize(trainingModel.getTraining_question13()),
                sanitize(trainingModel.getTraining_question14()),
                sanitize(trainingModel.getTraining_question15()),
                sanitize(trainingModel.getIs_sync()),
                sanitize(trainingModel.getIs_draft()),
                sanitize(trainingModel.getOnCreate()),
                sanitize(trainingModel.getOnUpdate()),
                sanitize(trainingModel.getUserFname()),
                sanitize(trainingModel.getUserLname()),
                sanitize(trainingModel.getUserEmail()));

        trainingDetailsWebView.evaluateJavascript(js, null);
    }

    private String sanitize(String input) {
        return input != null ? input.replace("'", "\\'") : "";
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.farmer_training);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}