package com.jacob.fruitoftek.safecrop.sustain.pentry;

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
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

public class PEDoneActivity extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private PeAdapter adapter;
    private List<PeModel> peList;
    private PeDbHelper dbHelper;
    private TextView noRecordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedone);
        
        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        recyclerView = findViewById(R.id.peRecyclerView);
        noRecordsTextView = findViewById(R.id.noRecordsTextView); // Initialize the TextView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new PeDbHelper(this);
        peList = fetchSurveyData();

        if (peList.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE); // Show "No Record Found" message
            recyclerView.setVisibility(View.GONE);         // Hide RecyclerView
        } else {
            noRecordsTextView.setVisibility(View.GONE);    // Hide the message
            recyclerView.setVisibility(View.VISIBLE);      // Show RecyclerView
        }

        adapter = new PeAdapter(this, peList);
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
                    filterPeList(query); // Apply the search filter
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterPeList(newText); // Apply the search filter
                    return false;
                }
            });
        }
    }

    private void filterPeList(String query) {
        List<PeModel> filteredList = new ArrayList<>();
        for (PeModel pen : peList) {
            if (pen.getPequestion1().toLowerCase().contains(query.toLowerCase()) ||
                    pen.getPequestion2().toLowerCase().contains(query.toLowerCase()) ||
                    pen.getPequestion3().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(pen);
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

    private List<PeModel> fetchSurveyData() {
        List<PeModel> list = new ArrayList<>();
        Cursor cursor = dbHelper.getPESurveyData();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String pequestion1 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion1"));
                String pequestion2 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion2"));
                String pequestion3 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion3"));
                String pequestion4 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion4"));
                String pequestion5 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion5"));
                String pequestion6 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion6"));
                String pequestion7 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion7"));
                String pequestion8 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion8"));
                String pequestion9 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion9"));
                String pequestion10 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion10"));
                String pequestion11 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion11"));
                String pequestion12 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion12"));
                String pequestion13 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion13"));
                String pequestion14 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion14"));
                Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                        ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                        : null;
                String user_fname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String user_lname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                list.add(new PeModel(id, pequestion1, pequestion2, pequestion3, pequestion4, pequestion5,
                        pequestion6, pequestion7, pequestion8, pequestion9, pequestion10, pequestion11,
                        pequestion12, pequestion13, pequestion14, farmer_photo, user_fname, user_email,
                        user_lname, onCreate, onUpdate));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.farmers_entered);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}