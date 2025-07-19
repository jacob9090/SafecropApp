package com.jacob.fruitoftek.safecrop.comdev.lra;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class SurveyedLraActivity extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private LraAdapter adapter;
    private List<LraModel> lraList;
    private LraDbHelper dbHelper;
    private TextView noRecordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_surveyed_lra);

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

        recyclerView = findViewById(R.id.lraRecyclerView);
        noRecordsTextView = findViewById(R.id.noRecordsTextView); // Initialize the TextView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new LraDbHelper(this);
        lraList = fetchSurveyData();

        if (lraList.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE); // Show "No Record Found" message
            recyclerView.setVisibility(View.GONE);         // Hide RecyclerView
        } else {
            noRecordsTextView.setVisibility(View.GONE);    // Hide the message
            recyclerView.setVisibility(View.VISIBLE);      // Show RecyclerView
        }

        adapter = new LraAdapter(this, lraList);
        recyclerView.setAdapter(adapter);

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
        List<LraModel> filteredList = new ArrayList<>();
        for (LraModel school : lraList) {
            if (school.getLraquestion1().toLowerCase().contains(query.toLowerCase()) ||
                    school.getLraquestion2().toLowerCase().contains(query.toLowerCase()) ||
                    school.getLraquestion3().toLowerCase().contains(query.toLowerCase())) {
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

    private List<LraModel> fetchSurveyData() {
        List<LraModel> list = new ArrayList<>();
        Cursor cursor = dbHelper.getLraSurveyData();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String lraquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion1"));
                String lraquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion2"));
                String lraquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion3"));
                String lraquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion4"));
                String lraquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion5"));
                String lraquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion6"));
                String lraquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion7"));
                String lraquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion8"));
                String lraquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion9"));
                String lraquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion10"));
                String lra_location = cursor.getString(cursor.getColumnIndexOrThrow("lra_location"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String user_fname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String user_lname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                list.add(new LraModel(id, lraquestion1, lraquestion2, lraquestion3, lraquestion4, lraquestion5,
                        lraquestion6, lraquestion7, lraquestion8, lraquestion9, lraquestion10, lra_location,
                        signature, user_fname, user_email, user_lname, onCreate, onUpdate));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.gender_risk_assessment);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}