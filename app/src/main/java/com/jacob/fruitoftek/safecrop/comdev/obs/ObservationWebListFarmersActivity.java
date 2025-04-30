package com.jacob.fruitoftek.safecrop.comdev.obs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.farmerlist.FarmerListActivity;
import com.jacob.fruitoftek.safecrop.farmerlist.FarmerListAdapter;
import com.jacob.fruitoftek.safecrop.farmerlist.FarmerListDatabaseHelper;
import com.jacob.fruitoftek.safecrop.farmerlist.FarmerListModal;

import java.util.ArrayList;
import java.util.List;

public class ObservationWebListFarmersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FarmerListAdapter farmerAdapter;
    private TextView emptyState;
    private TextView totalFarmersLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_observation_web_list_farmers);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        initializeUI();

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
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
        recyclerView = findViewById(R.id.obsRecyclerView);
        totalFarmersLoaded = findViewById(R.id.totalFarmersLoaded);
        emptyState = findViewById(R.id.emptyState);

        // Initialize adapter FIRST
        farmerAdapter = new FarmerListAdapter(new ArrayList<>(), farmer -> {
            Intent intent = new Intent(this, ObservationWebSurveyActivity.class);
            intent.putExtra("obs_name", farmer.getFid());
            intent.putExtra("obs_district", farmer.getDistrict());
            intent.putExtra("obs_community", farmer.getVillage());
            startActivity(intent);
        });

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(farmerAdapter);
        }

        // Now load data AFTER adapter is initialized
        if (!FarmerListActivity.farmerList.isEmpty()) {
            updateUIWithFarmers();
        } else {
            loadCachedFarmers();
        }
    }

    private void loadCachedFarmers() {
        FarmerListDatabaseHelper dbHelper = new FarmerListDatabaseHelper(this);
        List<FarmerListModal> cachedFarmers = dbHelper.getAllFarmers();
        farmerAdapter.updateList(cachedFarmers);
        emptyState.setVisibility(cachedFarmers.isEmpty() ? View.VISIBLE : View.GONE);
        totalFarmersLoaded.setText(String.valueOf(cachedFarmers.size()));
    }

    private void updateUIWithFarmers() {
        farmerAdapter.updateList(FarmerListActivity.farmerList);
        emptyState.setVisibility(View.GONE);
        totalFarmersLoaded.setText(String.valueOf(FarmerListActivity.farmerList.size()));
    }

//    private void initializeUI() {
//        recyclerView = findViewById(R.id.obsRecyclerView);
//        if (recyclerView != null) {
//            recyclerView.setLayoutManager(new LinearLayoutManager(this));
//            farmerAdapter = new FarmerListAdapter(new ArrayList<>(), farmer -> {
//                // Navigate to EditFarmerActivity with farmer details
//                Intent intent = new Intent(ObservationWebListFarmersActivity.this, ObservationWebSurveyActivity.class);
//                intent.putExtra("obs_id", farmer.getFid());
//                intent.putExtra("obs_district", farmer.getDistrict());
//                intent.putExtra("obs_village", farmer.getVillage());
//                startActivity(intent);
//            });
//            recyclerView.setAdapter(farmerAdapter);
//        } else {
//            throw new NullPointerException("RecyclerView is null. Ensure it is defined in the layout file.");
//        }
//
//        emptyState = findViewById(R.id.emptyState);
//    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.farmer_list_title);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}