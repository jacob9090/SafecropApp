package com.jacob.fruitoftek.safecrop.comdev.sch;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONException;

public class SyncSchoolInfoActivity extends AppCompatActivity {
    
    private PreferenceHelper preferenceHelper;
    private ProgressBar syncSchInfoProgressBar;
    private TextView syncSchInfoCountTextView;
    private SharedPreferences sharedPreferences;

    private Button syncSchInfoStartDateButton, syncSchInfoEndDateButton, syncSchInfoFilterButton;
    private String syncSchInfoStartDate = "", syncSchInfoEndDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sync_school_info);

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

        preferenceHelper = new PreferenceHelper(this);
        Log.d("SyncSurveyInfo", "PreferenceHelper initialized.");

        // Retrieve user details
        String userEmail = preferenceHelper.getEmail();
        fetchSurveyDataForChart(userEmail, "day");
        Log.d("SyncSurveyInfo", "Retrieved userEmail: [" + userEmail + "]");

        // Setup Filter Spinner
        Spinner chartFilterSpinner = findViewById(R.id.syncSchInfoChartFilterSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Day", "Week", "Month"});
        chartFilterSpinner.setAdapter(adapter);

        chartFilterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedFilter = parent.getItemAtPosition(position).toString().toLowerCase();
                fetchSurveyDataForChart(userEmail, selectedFilter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        syncSchInfoProgressBar = findViewById(R.id.syncSchInfoProgressBar);
        syncSchInfoCountTextView = findViewById(R.id.syncSchInfoCountTV);
        sharedPreferences = getSharedPreferences("SyncCache", MODE_PRIVATE);

        syncSchInfoStartDateButton = findViewById(R.id.syncSchInfoStartDateBtn);
        syncSchInfoEndDateButton = findViewById(R.id.syncSchInfoEndDateBtn);
        syncSchInfoFilterButton = findViewById(R.id.syncSchInfoFilterBtn);

        syncSchInfoStartDateButton.setOnClickListener(view -> showDatePicker(true));
        syncSchInfoEndDateButton.setOnClickListener(view -> showDatePicker(false));

        syncSchInfoFilterButton.setOnClickListener(view -> {
            if (!syncSchInfoStartDate.isEmpty() && !syncSchInfoEndDate.isEmpty()) {
                fetchSyncCount(userEmail, syncSchInfoStartDate, syncSchInfoEndDate);
            } else {
                Toast.makeText(this, "Please select start and end date", Toast.LENGTH_SHORT).show();
            }
        });

        // If user details are missing, show an error
        if (userEmail == null || userEmail.trim().isEmpty()) {
            Log.e("SyncSurveyInfo", "ERROR: Missing userEmail! userEmail=[" + userEmail + "]");
            syncSchInfoCountTextView.setText("Error: Missing Name Data");
        } else {
            if (isNetworkConnected()) {
                fetchSyncCount(userEmail, "", ""); // Added empty startDate & endDate
            } else {
                loadCachedSyncCount();
            }
        }

    }

    private void fetchSyncCount(String userEmail, String startDate, String endDate) {
        runOnUiThread(() -> syncSchInfoProgressBar.setVisibility(View.VISIBLE));
        new Thread(() -> {
            try {
                String urlString = "https://app.safecropgh.org/clmrs/sync_school_info.php?userEmail=" +
                        URLEncoder.encode(userEmail, "UTF-8") +
                        "&startDate=" + URLEncoder.encode(startDate, "UTF-8") +
                        "&endDate=" + URLEncoder.encode(endDate, "UTF-8");

                Log.d("SyncSurveyInfo", "API Request URL: " + urlString);
                HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
                conn.setRequestMethod("GET");

                int responseCode = conn.getResponseCode();
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    Log.e("SyncSurveyInfo", "Server Error: " + responseCode);
                    runOnUiThread(() -> {
                        syncSchInfoProgressBar.setVisibility(View.GONE);
                        syncSchInfoCountTextView.setText("Error fetching sync count");
                    });
                    return;
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                br.close();
                conn.disconnect();

                String responseString = response.toString().trim();
                Log.d("SyncSurveyInfo", "Raw API Response: " + responseString);

                try {
                    JSONObject jsonResponse = new JSONObject(responseString);
                    if (!jsonResponse.has("status") || !jsonResponse.has("totalRecords")) {
                        Log.e("SyncSurveyInfo", "Invalid JSON format received");
                        return;
                    }

                    String status = jsonResponse.getString("status");
                    int totalRecords = jsonResponse.getInt("totalRecords");

                    if ("success".equals(status)) {
                        runOnUiThread(() -> {
                            syncSchInfoProgressBar.setVisibility(View.GONE);
                            syncSchInfoCountTextView.setText("Total Records Synced: " + totalRecords);
                        });
                    } else {
                        runOnUiThread(() -> {
                            syncSchInfoProgressBar.setVisibility(View.GONE);
                            syncSchInfoCountTextView.setText("No records found");
                        });
                    }
                } catch (JSONException e) {
                    Log.e("SyncSurveyInfo", "JSON Parsing Error: " + e.getMessage());
                    runOnUiThread(() -> {
                        syncSchInfoProgressBar.setVisibility(View.GONE);
                        syncSchInfoCountTextView.setText("Error parsing sync count");
                    });
                }

            } catch (Exception e) {
                Log.e("SyncSurveyInfo", "Network Request Error", e);
                runOnUiThread(() -> {
                    syncSchInfoProgressBar.setVisibility(View.GONE);
                    syncSchInfoCountTextView.setText("Error fetching sync count");
                });
            }
        }).start();
    }

    private void showDatePicker(boolean isStartDate) {
        Calendar calendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    String selectedDate = year + "-" + String.format("%02d", (month + 1)) + "-" + String.format("%02d", dayOfMonth);

                    if (isStartDate) {
                        syncSchInfoStartDate = selectedDate;
                        syncSchInfoStartDateButton.setText("Start: " + selectedDate);
                        Log.d("SyncSurveyInfo", "Selected Start Date: " + syncSchInfoStartDate);
                    } else {
                        syncSchInfoEndDate = selectedDate;
                        syncSchInfoEndDateButton.setText("End: " + selectedDate);
                        Log.d("SyncSurveyInfo", "Selected End Date: " + syncSchInfoEndDate);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();
    }

    private void fetchSurveyDataForChart(String userEmail, String filterType) {
        new Thread(() -> {
            try {
                String urlString = "https://app.safecropgh.org/clmrs/sync_school_chart.php?userEmail=" +
                        URLEncoder.encode(userEmail, "UTF-8") +
                        "&filterType=" + URLEncoder.encode(filterType, "UTF-8"); //Pass filter type

                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                int responseCode = conn.getResponseCode();
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    Log.e("BarChart", "Server Error: " + responseCode);
                    return;
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                br.close();
                conn.disconnect();

                Log.d("BarChart", "Server Response: " + response.toString());

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray surveyDataArray = jsonResponse.getJSONArray("surveyData");

                List<BarEntry> entries = new ArrayList<>();
                List<String> labels = new ArrayList<>();

                for (int i = 0; i < surveyDataArray.length(); i++) {
                    JSONObject survey = surveyDataArray.getJSONObject(i);
                    String date = survey.getString("on_create");
                    int totalSurveys = survey.getInt("total");

                    entries.add(new BarEntry(i, totalSurveys));
                    labels.add(date);
                }

                runOnUiThread(() -> updateBarChart(entries, labels));

            } catch (Exception e) {
                Log.e("BarChart", "Error fetching survey chart data", e);
            }
        }).start();
    }

    private void loadCachedSyncCount() {
        int cachedCount = sharedPreferences.getInt("sync_count", 0);
        syncSchInfoCountTextView.setText("Total Records Synced (Cached): " + cachedCount);
        syncSchInfoProgressBar.setVisibility(View.GONE);
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnected();
        }
        return false;
    }

    private void updateBarChart(List<BarEntry> entries, List<String> labels) {
        BarChart barChart = findViewById(R.id.syncSchInfoBarChart);

        BarDataSet barDataSet = new BarDataSet(entries, "Surveys Sync");
        barDataSet.setColor(Color.rgb(148, 15, 15));
        barDataSet.setValueTextSize(12f);
        barDataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) value); // Whole numbers on top of bars
            }
        });

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        // Configure Y-Axis (Left Only, No Decimals)
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setGranularity(1f); // Force step size of 1
        leftAxis.setGranularityEnabled(true);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) value); // Whole numbers only
            }
        });

        // Disable right Y-axis
        barChart.getAxisRight().setEnabled(false);

        // Configure X-Axis Labels
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setLabelRotationAngle(-45);

        barChart.getDescription().setEnabled(false);
        barChart.animateY(1000);
        barChart.invalidate();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.sync_info);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}