package com.jacob.fruitoftek.safecrop.sustain.pentry;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;

import androidx.appcompat.app.ActionBar;

public class PEnteryDetailsActivity extends AppCompatActivity {
    
    private WebView peDetailsWebView;
    private PeModel peModel;
    private PeDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pentery_details);
        
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        peDetailsWebView = findViewById(R.id.peDetailsWebView);
        peDetailsWebView.getSettings().setJavaScriptEnabled(true);

        dbHelper = new PeDbHelper(this);

        // Retrieve PeModel from the Intent
        peModel = getIntent().getParcelableExtra("pe_model");

        if (peModel != null) {
            loadSurveyDetails();
        } else {
            Toast.makeText(this, "Farmer details are missing.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        peDetailsWebView.loadUrl("file:///android_asset/pentery/penterydetails.html");

        // Inject survey details after the page loads
        peDetailsWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

    private void injectSurveyDetails() {
        if (peModel == null) return;

        String js = String.format("javascript:" +
                        "document.getElementById('pequestion1').textContent = '%s';" +
                        "document.getElementById('pequestion2').textContent = '%s';" +
                        "document.getElementById('pequestion3').textContent = '%s';" +
                        "document.getElementById('pequestion4').textContent = '%s';" +
                        "document.getElementById('pequestion5').textContent = '%s';" +
                        "document.getElementById('pequestion6').textContent = '%s';" +
                        "document.getElementById('pequestion7').textContent = '%s';" +
                        "document.getElementById('pequestion8').textContent = '%s';" +
                        "document.getElementById('pequestion9').textContent = '%s';" +
                        "document.getElementById('pequestion10').textContent = '%s';" +
                        "document.getElementById('pequestion11').textContent = '%s';" +
                        "document.getElementById('pequestion12').textContent = '%s';" +
                        "document.getElementById('pequestion13').textContent = '%s';" +
                        "document.getElementById('farmer_photo').src = '%s';" +
                        "document.getElementById('on_create').textContent = '%s';" +
                        "document.getElementById('on_update').textContent = '%s';" +
                        "document.getElementById('user_fname').textContent = '%s';" +
                        "document.getElementById('user_lname').textContent = '%s';" +
                        "document.getElementById('user_email').textContent = '%s';",
                sanitize(peModel.getPequestion1()),
                sanitize(peModel.getPequestion2()),
                sanitize(peModel.getPequestion3()),
                sanitize(peModel.getPequestion4()),
                sanitize(peModel.getPequestion5()),
                sanitize(peModel.getPequestion6()),
                sanitize(peModel.getPequestion7()),
                sanitize(peModel.getPequestion8()),
                sanitize(peModel.getPequestion9()),
                sanitize(peModel.getPequestion10()),
                sanitize(peModel.getPequestion11()),
                sanitize(peModel.getPequestion12()),
                sanitize(peModel.getPequestion13()),
                peModel.getFarmer_photo() != null ? sanitize(peModel.getFarmer_photo().toString()) : "",
                sanitize(peModel.getOnCreate()),
                sanitize(peModel.getOnUpdate()),
                sanitize(peModel.getUserFname()),
                sanitize(peModel.getUserLname()),
                sanitize(peModel.getUserEmail()));

        peDetailsWebView.evaluateJavascript(js, null);
    }

    private String sanitize(String input) {
        return input != null ? input.replace("'", "\\'") : "";
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.producer_entry);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}