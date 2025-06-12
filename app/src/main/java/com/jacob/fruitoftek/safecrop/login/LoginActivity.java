package com.jacob.fruitoftek.safecrop.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.DashboardActivity;
import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.login.network.HttpRequest;
import com.jacob.fruitoftek.safecrop.login.utils.AndyConstants;
import com.jacob.fruitoftek.safecrop.login.utils.AndyUtils;
import com.jacob.fruitoftek.safecrop.login.utils.ParseContent;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private PreferenceHelper preferenceHelper;
    private AlertDialog progressDialog;
    private ParseContent parseContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN

        );
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        parseContent = new ParseContent(this);
        preferenceHelper = new PreferenceHelper(this);

        // Check existing login using correct method name
        if(preferenceHelper.isLoggedIn()) {
            startActivity(new Intent(this, DashboardActivity.class));
            finish();
        }

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> attemptLogin());
    }

    private void attemptLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)) {
            etEmail.setError("Email required");
            return;
        }

        if(TextUtils.isEmpty(password)) {
            etPassword.setError("Password required");
            return;
        }

        if(!AndyUtils.isNetworkAvailable(this)) {
            Toast.makeText(this, "Internet required", Toast.LENGTH_SHORT).show();
            return;
        }

        showProgressDialog();
        new LoginTask().execute(email, password);
    }

    private class LoginTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                HashMap<String, String> data = new HashMap<>();
                data.put("email", params[0]);
                data.put("password", params[1]);

                HttpRequest request = new HttpRequest(AndyConstants.LOGIN_URL);
                return request.prepare(HttpRequest.METHOD_POST)
                        .withData(data)
                        .sendAndReadString();
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            dismissProgressDialog();

            if (result == null || result.trim().isEmpty()) {
                Toast.makeText(LoginActivity.this,
                        "Login failed: No response from server", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                JSONObject response = new JSONObject(result);

                if (response.optString("status").equalsIgnoreCase("success")) {
                    JSONObject userData = response.getJSONObject("user");
                    preferenceHelper.saveUserData(userData);

                    // Optional: store token
                    String token = response.optString("token");

                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                    finish();

                } else {
                    Toast.makeText(LoginActivity.this,
                            response.optString("message", "Login failed"),
                            Toast.LENGTH_SHORT).show();
                }

            } catch (JSONException e) {
                Log.e("LoginError", "Raw: " + result);
                Toast.makeText(LoginActivity.this,
                        "Login failed: Invalid server response",
                        Toast.LENGTH_LONG).show();
            }
        }

    }

    private void showProgressDialog() {
        if (progressDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();

            builder.setView(inflater.inflate(R.layout.progress_dialog, null))
                    .setCancelable(false);

            progressDialog = builder.create();
            progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    private void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissProgressDialog(); // Prevent window leaks
    }
}
