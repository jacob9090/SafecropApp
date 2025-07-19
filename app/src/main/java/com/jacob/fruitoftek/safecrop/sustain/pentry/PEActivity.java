package com.jacob.fruitoftek.safecrop.sustain.pentry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;
import com.jacob.fruitoftek.safecrop.sustain.SusCertDashboard;

import androidx.appcompat.app.AlertDialog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.Handler;

public class PEActivity extends AppCompatActivity {
    
    private PreferenceHelper preferenceHelper;
    private WebView peWebView;
    private PeDbHelper dbHelper;
    private ProgressBar peProgressBar;
    private ActivityResultLauncher<Intent> photoFarmerLauncher;

    private Uri farmerPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_peactivity);

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

        dbHelper = new PeDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);

        peWebView = findViewById(R.id.peWebView);
        peProgressBar = findViewById(R.id.peProgressBar);

        peWebView.getSettings().setJavaScriptEnabled(true);
        peWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        // Add WebViewClient to handle progress
        peWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                peProgressBar.setVisibility(View.VISIBLE);
                Log.d("WebView", "Page started loading: " + url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                peProgressBar.setVisibility(View.GONE); // Hide progress bar when page finishes
                Log.d("WebView", "Page finished loading: " + url);

                // Your JavaScript execution for unique code and "GHA-"
                String uniqueCode = generateUniqueCode();
                String ghCad = "GHA-";
                peWebView.evaluateJavascript("setPequestion13('" + uniqueCode + "');", null);
                peWebView.evaluateJavascript("setPequestion5('" + ghCad + "');", null);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                peProgressBar.setVisibility(View.GONE);
                Log.e("WebView", "Error loading page: " + error.getDescription().toString());
            }
        });

        // Failsafe: Hide progress bar after 5 seconds (this can remain as a separate safety measure)
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (peProgressBar.getVisibility() == View.VISIBLE) { // Only hide if still visible
                peProgressBar.setVisibility(View.GONE);
            }
        }, 5000);


//        peWebView.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                String uniqueCode = generateUniqueCode();
//                String ghCad = "GHA-";
//                peWebView.evaluateJavascript("setPequestion13('" + uniqueCode + "');", null);
//                peWebView.evaluateJavascript("setPequestion5('" + ghCad + "');", null);
//            }
//        });

        peWebView.loadUrl("file:///android_asset/pentery/add_pentery.html");

        photoFarmerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String farmerPhotoPath = result.getData().getStringExtra("FarmerPhotoPath");
                        if (farmerPhotoPath != null) {
                            farmerPhotoUri = Uri.parse(farmerPhotoPath);
                            peWebView.evaluateJavascript("updateFarmerPhoto('" + farmerPhotoUri.toString() + "');", null);
                            Log.d("PEActivity", "Captured Farmer Photo: " + farmerPhotoUri);
                        }
                    }
                }
        );
    }

    private String generateUniqueCode() {
        String fname = preferenceHelper.getFirstName();
        long timestamp = System.currentTimeMillis();
        return fname + "_" + timestamp;
    }

    // JavaScript interface for launching activities
    public class WebAppInterface {
        Context context;
        PeDbHelper dbHelper;

        WebAppInterface(Context c) {
            context = c;
            dbHelper = new PeDbHelper(context);
        }

        @JavascriptInterface
        public void insertPE(String pequestion1, String pequestion2, String pequestion3, String pequestion4,
                             String pequestion5, String pequestion6, String pequestion7, String pequestion8,
                             String pequestion9, String pequestion10, String pequestion11, String pequestion12,
                             String pequestion13, String pequestion14, String farmer_photo) {

            pequestion1 = pequestion1 == null || pequestion1.equals("undefined") ? "" : pequestion1;
            pequestion2 = pequestion2 == null || pequestion2.equals("undefined") ? "" : pequestion2;
            pequestion3 = pequestion3 == null || pequestion3.equals("undefined") ? "" : pequestion3;
            pequestion4 = pequestion4 == null || pequestion4.equals("undefined") ? "" : pequestion4;
            pequestion5 = pequestion5 == null || pequestion5.equals("undefined") ? "" : pequestion5;
            pequestion6 = pequestion6 == null || pequestion6.equals("undefined") ? "" : pequestion6;
            pequestion7 = pequestion7 == null || pequestion7.equals("undefined") ? "" : pequestion7;
            pequestion8 = pequestion8 == null || pequestion8.equals("undefined") ? "" : pequestion8;
            pequestion9 = pequestion9 == null || pequestion9.equals("undefined") ? "" : pequestion9;
            pequestion10 = pequestion10 == null || pequestion10.equals("undefined") ? "" : pequestion10;
            pequestion11 = pequestion11 == null || pequestion11.equals("undefined") ? "" : pequestion11;
            pequestion12 = pequestion12 == null || pequestion12.equals("undefined") ? "" : pequestion12;
            pequestion13 = pequestion13 == null || pequestion13.equals("undefined") ? "" : pequestion13;
            pequestion14 = pequestion14 == null || pequestion14.equals("undefined") ? "" : pequestion14;

            String userFname = preferenceHelper.getFirstName();
            String userLname = preferenceHelper.getLastName();
            String userEmail = preferenceHelper.getEmail();

            String onCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            String onUpdate = onCreate;

            // Use captured URIs if available
            if (farmerPhotoUri != null) farmer_photo = farmerPhotoUri.toString();

            boolean success = dbHelper.insertPE(pequestion1, pequestion2, pequestion3, pequestion4,
                    pequestion5, pequestion6, pequestion7, pequestion8, pequestion9, pequestion10,
                    pequestion11, pequestion12, pequestion13, pequestion14, farmer_photo, userFname, userLname,
                    userEmail, onCreate, onUpdate);

            if (success) {
                Log.d("PEActivity", "Data inserted successfully");
            } else {
                Log.e("PEActivity", "Failed to insert data");
            }
        }

        @JavascriptInterface
        public void completeSurvey() {
            runOnUiThread(() -> {
                peWebView.loadUrl("about:blank");
                peWebView.clearHistory();
                peWebView.clearCache(true);
                peWebView.destroy(); // Destroy WebView
            });

            Intent intent = new Intent(context, PEnteryCompletedActivity.class);
            context.startActivity(intent);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }, 500);
        }

        @JavascriptInterface
        public void openFarmerPhotoActivity() {
            Intent intent = new Intent(context, GetPEPhotoActivity.class);
            photoFarmerLauncher.launch(intent);
        }

        @JavascriptInterface
        public void notifyPageLoaded() {
            runOnUiThread(() -> peProgressBar.setVisibility(View.GONE));
            Log.d("WebView", "JavaScript confirmed page load.");
        }
    }

    @Override
    protected void onDestroy() {
        if (peWebView != null) {
            peWebView.destroy();
        }
        super.onDestroy();
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
        showExitConfirmationDialog();
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (peWebView.canGoBack()) {
                        peWebView.goBack();
                    } else {
                        //finish();
                        showExitConfirmationDialog();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showExitConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Exiting Survey")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .setCancelable(false)
                .show();
    }
}
