package com.jacob.fruitoftek.safecrop.sustain.fiis;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jacob.fruitoftek.safecrop.R;

import java.util.ArrayList;
import java.util.List;

public class ListFIISFarmersActivity extends AppCompatActivity {

    private ListFIISFarmersAdapter myAdapter;
    private ImageView noResultsImageView;
    FloatingActionButton fiisAddNewRecordBnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_fiisfarmers);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        RecyclerView recyclerView = findViewById(R.id.fiisListFarmersRecylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<ListFIISFarmersModel> modelList = createFarmersModelList();
        myAdapter = new ListFIISFarmersAdapter(this, modelList);
        recyclerView.setAdapter(myAdapter);

        noResultsImageView = findViewById(R.id.noResultsImageView); // Updated ID for consistency
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.farmer_list_title);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private List<ListFIISFarmersModel> createFarmersModelList() {
        List<ListFIISFarmersModel> modelList = new ArrayList<>();
        addFirstBatchFarmers(modelList);
        addSecondBatchFarmers(modelList);
        addThirdBatchFarmers(modelList);
        return modelList;
    }

    private void addFirstBatchFarmers(List< ListFIISFarmersModel> modelList) {
        modelList.add(new ListFIISFarmersModel("FC-AO-AB-048", "Samuel Acheampong", "Akim Ofoase", "Adanso Boi", "GHA-722390830-4", "1990", "7", "Null", "Null", "0247418810", R.drawable.profile));
        modelList.add(new ListFIISFarmersModel("FC-AO-AB-049", "Naomi Amponsah", "Akim Ofoase", "Adanso Boi", "GHA-722053705-1", "1980", "2", "Null", "Null", "0241749666", R.drawable.profile));
        modelList.add(new ListFIISFarmersModel("FC-AO-AB-050", "Patience Anane", "Akim Ofoase", "Adanso Boi", "GHA-722345165-1", "1984", "1", "Null", "Null", "Not Available", R.drawable.profile));
    }

    private void addSecondBatchFarmers(List< ListFIISFarmersModel> modelList) {
        modelList.add(new ListFIISFarmersModel("FC-KD-AOA-016", "Foster Sintim", "Kade", "Asuom A", "GHA-722158659-9", "1972", "1", "Null", "Null", "2409119523", R.drawable.profile));
        modelList.add(new ListFIISFarmersModel("FC-KD-AOA-017", "Felix Kwame Oware", "Kade", "Asuom A", "GHA-721381618-1", "1969", "1", "Null", "Null", "247909010", R.drawable.profile));
        modelList.add(new ListFIISFarmersModel("FC-KD-AOA-018", "Akosua Dokua", "Kade", "Asuom A", "GHA-721934546-1", "1960", "2", "Null", "Null", "546061809", R.drawable.profile));
    }

    private void addThirdBatchFarmers(List< ListFIISFarmersModel> modelList) {
        modelList.add(new ListFIISFarmersModel("FC-OD-AKA-001", "Samuel Kwabena   Appeatu", "Akim Oda", "Akroso A", "GHA-721209848-5", "1984", "3", "Null", "Null", "0543902972", R.drawable.profile));
        modelList.add(new ListFIISFarmersModel("FC-OD-AKA-002", "Edward   Owusu", "Akim Oda", "Akroso A", "GHA-721753975-8", "1985", "2", "Null", "Null", "0540594874", R.drawable.profile));
        modelList.add(new ListFIISFarmersModel("FC-OD-AKA-003", "Christiana   Ampofowaa", "Akim Oda", "Akroso A", "GHA-721859932-8", "1970", "1", "Null", "Null", "0597842487", R.drawable.profile));
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
                    myAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    myAdapter.getFilter().filter(newText);
                    return false;
                }
            });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }

    public void showNoResultsMessage(boolean show) {
        noResultsImageView.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}