package com.jacob.fruitoftek.safecrop.farmerlist;

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
import android.widget.SearchView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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

public class FarmerListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FarmerListAdapter farmerAdapter;
    public static ArrayList<FarmerListModal> farmerList = new ArrayList<>();
    private FarmerListDatabaseHelper farmerDbHelper;
    private ProgressBar loadingIndicator;
    private TextView emptyState;
    private TextView totalFarmersLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_farmer_list);

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
        if (farmerList.isEmpty()) {
            loadCachedFarmers(this, farmerAdapter, emptyState, totalFarmersLoaded);
        }

        findViewById(R.id.btnUpdate).setOnClickListener(v -> {
            if (isNetworkAvailable()) {
                fetchAndUpdateFarmers();
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
                    farmerAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    farmerAdapter.getFilter().filter(newText);
                    return false;
                }
            });
        }
    }

    private void initializeUI() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        farmerDbHelper = new FarmerListDatabaseHelper(this);
        farmerAdapter = new FarmerListAdapter(farmerList, farmer -> {
            Intent intent = new Intent(FarmerListActivity.this, FarmerDetailsActivity.class);
            intent.putExtra("farmer", farmer);
            startActivity(intent);
        });
        recyclerView.setAdapter(farmerAdapter);

        loadingIndicator = findViewById(R.id.loadingIndicator);
        emptyState = findViewById(R.id.emptyState);
        totalFarmersLoaded = findViewById(R.id.totalFarmersLoaded);
        totalFarmersLoaded.setText(String.valueOf(farmerList.size()));
    }

    private void setupInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void fetchAndUpdateFarmers() {
        loadingIndicator.setVisibility(View.VISIBLE);

        new OkHttpClient().newCall(new Request.Builder()
                .url("https://app.safecropgh.org/registry/safecrop_registry.php")
                .build()).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                runOnUiThread(() -> {
                    loadingIndicator.setVisibility(View.GONE);
                    Log.e("fetchAndUpdateFarmers", "Failed to fetch farmers", e);
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (!response.isSuccessful() || response.body() == null) {
                    runOnUiThread(() -> {
                        loadingIndicator.setVisibility(View.GONE);
                        Log.e("fetchAndUpdateFarmers", "Unsuccessful response or empty body");
                    });
                    return;
                }

                try {
                    JSONArray jsonArray = new JSONArray(response.body().string());
                    List<FarmerListModal> newFarmers = new ArrayList<>();

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        FarmerListModal farmer = new FarmerListModal(
                                obj.getString("district"),
                                obj.getString("village_city"),
                                obj.getString("farm_id"),
                                obj.getString("name"),
                                obj.getString("ghana_card"),
                                obj.getString("yob"),
                                obj.getString("phone_number"),
                                obj.getString("gender"),
                                obj.getString("photo")
                        );
                        newFarmers.add(farmer);
                        farmerDbHelper.insertFarmer(farmer);
                    }

                    farmerList.clear();
                    farmerList.addAll(newFarmers);

                    runOnUiThread(() -> {
                        farmerAdapter.updateList(farmerList);
                        emptyState.setVisibility(farmerList.isEmpty() ? View.VISIBLE : View.GONE);
                        loadingIndicator.setVisibility(View.GONE);
                        totalFarmersLoaded.setText(String.valueOf(farmerList.size()));
                    });

                } catch (Exception e) {
                    Log.e("fetchAndUpdateFarmers", "Error parsing response", e);
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

    public static void loadCachedFarmers(Context context, FarmerListAdapter adapter, TextView emptyView, TextView totalView) {
        FarmerListDatabaseHelper dbHelper = new FarmerListDatabaseHelper(context);
        farmerList.clear();
        farmerList.addAll(dbHelper.getAllFarmers());
        adapter.updateList(farmerList);
        emptyView.setVisibility(farmerList.isEmpty() ? View.VISIBLE : View.GONE);
        totalView.setText(String.valueOf(farmerList.size()));
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.farmer_list);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}