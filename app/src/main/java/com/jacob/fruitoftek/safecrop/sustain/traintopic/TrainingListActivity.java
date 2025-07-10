package com.jacob.fruitoftek.safecrop.sustain.traintopic;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TrainingListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TrainingListAdapter trainingAdapter;
    public static ArrayList<TrainingListModal> trainingList = new ArrayList<>();
    private TrainingListDatabaseHelper trainingDbHelper;
    private ProgressBar loadingIndicator;
    private TextView emptyState;
    private TextView totalTrainingLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_training_list);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        initializeUI();
        setupInsets();
        if (trainingList.isEmpty()) {
            loadCachedTraining(this, trainingAdapter, emptyState, totalTrainingLoaded);
        }

        findViewById(R.id.trainBtnUpdate).setOnClickListener(v -> {
            if (isNetworkAvailable()) {
                fetchAndUpdateTraining();
            } else {
                showNoInternetDialog();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) searchItem.getActionView();
        setupSearchView(searchView);
        return super.onCreateOptionsMenu(menu);
    }

    private void setupSearchView(SearchView searchView) {
        if (searchView != null) {
            searchView.setMaxWidth(Integer.MAX_VALUE);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    trainingAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    trainingAdapter.getFilter().filter(newText);
                    return false;
                }
            });
        }
    }

    private void initializeUI() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        trainingDbHelper = new TrainingListDatabaseHelper(this);
//        trainingAdapter = new TrainingListAdapter(trainingList, training -> {
//            Intent intent = new Intent(TrainingListActivity.this, TrainingDetailsActivity.class);
//            intent.putExtra("training", training);
//            startActivity(intent);
//        });
        recyclerView.setAdapter(trainingAdapter);

        loadingIndicator = findViewById(R.id.loadingIndicator);
        emptyState = findViewById(R.id.emptyState);
        totalTrainingLoaded = findViewById(R.id.totalTrainingLoaded);
        totalTrainingLoaded.setText(String.valueOf(trainingList.size()));
    }

    private void setupInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void fetchAndUpdateTraining() {
        loadingIndicator.setVisibility(View.VISIBLE);

        new OkHttpClient().newCall(new Request.Builder()
                .url("https://app.safecropgh.org/training/safecrop_training_topic.php")
                .build()).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                runOnUiThread(() -> {
                    loadingIndicator.setVisibility(View.GONE);
                    Log.e("fetchAndUpdateTraining", "Failed to fetch training", e);
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (!response.isSuccessful() || response.body() == null) {
                    runOnUiThread(() -> {
                        loadingIndicator.setVisibility(View.GONE);
                        Log.e("fetchAndUpdateTraining", "Unsuccessful response or empty body");
                    });
                    return;
                }

                try {
                    JSONArray jsonArray = new JSONArray(response.body().string());
                    List<TrainingListModal> newTraining = new ArrayList<>();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        TrainingListModal training = new TrainingListModal(
                                obj.getString("topic"),
                                obj.getString("description")
                        );
                        newTraining.add(training);
                        trainingDbHelper.insertTraining(training);
                    }

                    trainingList.clear();
                    trainingList.addAll(newTraining);

                    runOnUiThread(() -> {
                        trainingAdapter.updateList(trainingList);
                        emptyState.setVisibility(trainingList.isEmpty() ? View.VISIBLE : View.GONE);
                        loadingIndicator.setVisibility(View.GONE);
                        totalTrainingLoaded.setText(String.valueOf(trainingList.size()));
                    });

                } catch (Exception e) {
                    Log.e("fetchAndUpdateTraining", "Error parsing response", e);
                    runOnUiThread(() -> loadingIndicator.setVisibility(View.GONE));
                }
            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return capabilities != null &&
                (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET));
    }

    private void showNoInternetDialog() {
        new AlertDialog.Builder(this)
                .setTitle("No Internet")
                .setMessage("Connect to the internet and load data")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

    public static void loadCachedTraining(Context context, TrainingListAdapter adapter, TextView emptyView, TextView totalView) {
        TrainingListDatabaseHelper dbHelper = new TrainingListDatabaseHelper(context);
        trainingList.clear();
        trainingList.addAll(dbHelper.getAllTraining());
        adapter.updateList(trainingList);
        emptyView.setVisibility(trainingList.isEmpty() ? View.VISIBLE : View.GONE);
        totalView.setText(String.valueOf(trainingList.size()));
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.train_list);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}