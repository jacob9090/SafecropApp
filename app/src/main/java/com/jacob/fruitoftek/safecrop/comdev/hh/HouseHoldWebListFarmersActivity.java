package com.jacob.fruitoftek.safecrop.comdev.hh;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

import android.widget.SearchView;

public class HouseHoldWebListFarmersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FarmerListAdapter farmerAdapter;
    private TextView emptyState;
    private TextView totalFarmersLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_house_hold_web_list_farmers);

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
        recyclerView = findViewById(R.id.recyclerView);
        totalFarmersLoaded = findViewById(R.id.totalFarmersLoaded);
        emptyState = findViewById(R.id.emptyState);

        // Initialize adapter FIRST
        farmerAdapter = new FarmerListAdapter(new ArrayList<>(), farmer -> {
            Intent intent = new Intent(this, HouseHoldWebSurveyActivity.class);
            intent.putExtra("hh_name", farmer.getFid());
            intent.putExtra("hh_district", farmer.getDistrict());
            intent.putExtra("hh_community", farmer.getVillage());
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