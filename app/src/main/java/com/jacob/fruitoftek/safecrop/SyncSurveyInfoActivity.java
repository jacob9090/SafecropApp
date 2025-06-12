package com.jacob.fruitoftek.safecrop;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

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

public class SyncSurveyInfoActivity extends AppCompatActivity {

    private PreferenceHelper preferenceHelper;
    private ProgressBar syncSurveyInfoProgressBar;
    private TextView syncSurveyInfoCountTextView;
    private SharedPreferences sharedPreferences;

    private Button syncSurveyInfoStartDateButton, syncSurveyInfoEndDateButton, syncSurveyInfoFilterButton;
    private String syncSurveyInfoStartDate = "", syncSurveyInfoEndDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sync_survey_info);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
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
        Spinner chartFilterSpinner = findViewById(R.id.syncSurveyInfoChartFilterSpinner);
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

        syncSurveyInfoProgressBar = findViewById(R.id.syncSurveyInfoProgressBar);
        syncSurveyInfoCountTextView = findViewById(R.id.syncSurveyInfoCountTV);
        sharedPreferences = getSharedPreferences("SyncCache", MODE_PRIVATE);

        syncSurveyInfoStartDateButton = findViewById(R.id.syncSurveyInfoStartDateBtn);
        syncSurveyInfoEndDateButton = findViewById(R.id.syncSurveyInfoEndDateBtn);
        syncSurveyInfoFilterButton = findViewById(R.id.syncSurveyInfoFilterBtn);

        syncSurveyInfoStartDateButton.setOnClickListener(view -> showDatePicker(true));
        syncSurveyInfoEndDateButton.setOnClickListener(view -> showDatePicker(false));

        syncSurveyInfoFilterButton.setOnClickListener(view -> {
            if (!syncSurveyInfoStartDate.isEmpty() && !syncSurveyInfoEndDate.isEmpty()) {
                fetchSyncCount(userEmail, syncSurveyInfoStartDate, syncSurveyInfoEndDate);
            } else {
                Toast.makeText(this, "Please select start and end date", Toast.LENGTH_SHORT).show();
            }
        });

        // If user details are missing, show an error
        if (userEmail == null || userEmail.trim().isEmpty()) {
            Log.e("SyncSurveyInfo", "ERROR: Missing userEmail! userEmail=[" + userEmail + "]");
            syncSurveyInfoCountTextView.setText("Error: Missing Name Data");
        } else {
            if (isNetworkConnected()) {
                fetchSyncCount(userEmail, "", ""); // Added empty startDate & endDate
            } else {
                loadCachedSyncCount();
            }
        }

    }

    private void fetchSyncCount(String userEmail, String startDate, String endDate) {
        runOnUiThread(() -> syncSurveyInfoProgressBar.setVisibility(View.VISIBLE)); // Show ProgressBar

        new Thread(() -> {
            try {
                String urlString = "https://app.safecropgh.org/clmrs/total_sync_info.php?userEmail=" +
                        URLEncoder.encode(userEmail, "UTF-8") +
                        "&startDate=" + URLEncoder.encode(startDate, "UTF-8") +
                        "&endDate=" + URLEncoder.encode(endDate, "UTF-8");

                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                int responseCode = conn.getResponseCode();

                if (responseCode != HttpURLConnection.HTTP_OK) {
                    runOnUiThread(() -> {
                        syncSurveyInfoProgressBar.setVisibility(View.GONE);
                        syncSurveyInfoCountTextView.setText("Error fetching sync count");
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

                JSONObject jsonResponse = new JSONObject(response.toString());
                if (jsonResponse.getString("status").equals("success")) {
                    int totalRecords = jsonResponse.getInt("totalRecords");

                    runOnUiThread(() -> {
                        syncSurveyInfoProgressBar.setVisibility(View.GONE); // Hide ProgressBar
                        syncSurveyInfoCountTextView.setText("Total Records Synced: " + totalRecords);
                    });
                } else {
                    runOnUiThread(() -> {
                        syncSurveyInfoProgressBar.setVisibility(View.GONE);
                        syncSurveyInfoCountTextView.setText("No records found");
                    });
                }

            } catch (Exception e) {
                runOnUiThread(() -> {
                    syncSurveyInfoProgressBar.setVisibility(View.GONE);
                    syncSurveyInfoCountTextView.setText("Error fetching sync count");
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
                        syncSurveyInfoStartDate = selectedDate;
                        syncSurveyInfoStartDateButton.setText("Start: " + selectedDate);
                        Log.d("SyncSurveyInfo", "Selected Start Date: " + syncSurveyInfoStartDate);
                    } else {
                        syncSurveyInfoEndDate = selectedDate;
                        syncSurveyInfoEndDateButton.setText("End: " + selectedDate);
                        Log.d("SyncSurveyInfo", "Selected End Date: " + syncSurveyInfoEndDate);
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
                String urlString = "https://app.safecropgh.org/clmrs/total_sync_chart.php?userEmail=" +
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
        syncSurveyInfoCountTextView.setText("Total Records Synced (Cached): " + cachedCount);
        syncSurveyInfoProgressBar.setVisibility(View.GONE);
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
        BarChart barChart = findViewById(R.id.syncSurveyInfoBarChart);

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