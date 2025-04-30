package com.jacob.fruitoftek.safecrop.comdev.obs;

import android.net.Uri;
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

import java.util.List;

import android.database.Cursor;
import android.widget.SearchView;

import java.util.ArrayList;

public class SurveyedObservationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ObsAdapter adapter;
    private List<ObsModel> obsList;
    private ObsDbHelper dbHelper;
    private TextView noRecordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_surveyed_observation);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();
        
        recyclerView = findViewById(R.id.obsRecyclerView);
        noRecordsTextView = findViewById(R.id.noRecordsTextView); // Initialize the TextView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new ObsDbHelper(this);
        obsList = fetchSurveyData();

        if (obsList.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE); // Show "No Record Found" message
            recyclerView.setVisibility(View.GONE);         // Hide RecyclerView
        } else {
            noRecordsTextView.setVisibility(View.GONE);    // Hide the message
            recyclerView.setVisibility(View.VISIBLE);      // Show RecyclerView
        }

        adapter = new ObsAdapter(this, obsList);
        recyclerView.setAdapter(adapter);
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
                    filterObsList(query); // Apply the search filter
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterObsList(newText); // Apply the search filter
                    return false;
                }
            });
        }
    }

    private void filterObsList(String query) {
        List<ObsModel> filteredList = new ArrayList<>();
        for (ObsModel obs : obsList) {
            if (obs.getObs_name().toLowerCase().contains(query.toLowerCase()) ||
                    obs.getObs_district().toLowerCase().contains(query.toLowerCase()) ||
                    obs.getObs_community().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(obs);
            }
        }

        adapter.updateList(filteredList);

        // Show "No Record Found" message if no results match the search
        if (filteredList.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE); // Show the message
            recyclerView.setVisibility(View.GONE);         // Hide RecyclerView
        } else {
            noRecordsTextView.setVisibility(View.GONE);    // Hide the message
            recyclerView.setVisibility(View.VISIBLE);      // Show RecyclerView
        }
    }

    private List<ObsModel> fetchSurveyData() {
        List<ObsModel> list = new ArrayList<>();
        Cursor cursor = dbHelper.getObsSurveyData();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String obs_name = cursor.getString(cursor.getColumnIndexOrThrow("obs_name"));
                String obs_district = cursor.getString(cursor.getColumnIndexOrThrow("obs_district"));
                String obs_community = cursor.getString(cursor.getColumnIndexOrThrow("obs_community"));
                String obsquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion6"));
                String obsquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion7"));
                String obsquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion8"));
                String obsquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion9"));
                String obsquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion10"));
                String obsquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion11"));
                String obsquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion12"));
                String obsquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion13"));
                String obsquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion14"));
                String obsquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion15"));
                String obsquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion16"));
                String obsquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion17"));
                String obsquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion18"));
                String obsquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion19"));
                String obsquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion20"));
                String obsquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion21"));
                String obs_location = cursor.getString(cursor.getColumnIndexOrThrow("obs_location"));
                Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                        ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                        : null;
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String user_fname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String user_oname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                list.add(new ObsModel(id, obs_name, obs_district, obs_community,
                        obsquestion6, obsquestion7, obsquestion8, obsquestion9, obsquestion10, obsquestion11,
                        obsquestion12, obsquestion13, obsquestion14, obsquestion15, obsquestion16, obsquestion17,
                        obsquestion18, obsquestion19, obsquestion20, obsquestion21, obs_location,
                        farmer_photo, signature, user_fname, user_oname, user_email, onCreate, onUpdate));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.observed_farmers);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}