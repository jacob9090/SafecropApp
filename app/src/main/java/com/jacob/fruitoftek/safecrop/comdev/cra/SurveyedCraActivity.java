package com.jacob.fruitoftek.safecrop.comdev.cra;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SurveyedCraActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CraAdapter adapter;
    private List<CraModel> craList;
    private CraDbHelper dbHelper;
    private TextView noRecordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_surveyed_cra);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        recyclerView = findViewById(R.id.craRecyclerView);
        noRecordsTextView = findViewById(R.id.noRecordsTextView); // Initialize the TextView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new CraDbHelper(this);
        craList = fetchSurveyData();

        if (craList.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE); // Show "No Record Found" message
            recyclerView.setVisibility(View.GONE);         // Hide RecyclerView
        } else {
            noRecordsTextView.setVisibility(View.GONE);    // Hide the message
            recyclerView.setVisibility(View.VISIBLE);      // Show RecyclerView
        }

        adapter = new CraAdapter(this, craList);
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
                    filterGraList(query); // Apply the search filter
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterGraList(newText); // Apply the search filter
                    return false;
                }
            });
        }
    }

    private void filterGraList(String query) {
        List<CraModel> filteredList = new ArrayList<>();
        for (CraModel school : craList) {
            if (school.getCraquestion1().toLowerCase().contains(query.toLowerCase()) ||
                    school.getCraquestion2().toLowerCase().contains(query.toLowerCase()) ||
                    school.getCraquestion3().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(school);
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

    private List<CraModel> fetchSurveyData() {
        List<CraModel> list = new ArrayList<>();
        Cursor cursor = dbHelper.getGraSurveyData();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String craquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion1"));
                String craquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion2"));
                String craquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion3"));
                String craquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion4"));
                String craquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion5"));
                String craquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion6"));
                String craquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion7"));
                String craquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion8"));
                String craquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion9"));
                String craquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion10"));
                String craquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion11"));
                String craquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion12"));
                String craquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion13"));
                String cra_location = cursor.getString(cursor.getColumnIndexOrThrow("cra_location"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String user_fname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String user_lname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                list.add(new CraModel(id, craquestion1, craquestion2, craquestion3, craquestion4, craquestion5,
                        craquestion6, craquestion7, craquestion8, craquestion9, craquestion10, craquestion11,
                        craquestion12, craquestion13, cra_location, signature, user_fname, user_email,
                        user_lname, onCreate, onUpdate));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.community_assessment);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}