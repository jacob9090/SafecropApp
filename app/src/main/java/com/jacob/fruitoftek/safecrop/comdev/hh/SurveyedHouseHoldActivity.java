package com.jacob.fruitoftek.safecrop.comdev.hh;

import android.os.Bundle;
import android.view.MenuItem;
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

import java.util.List;
import android.database.Cursor;
import android.net.Uri;
import android.view.Menu;
import android.widget.SearchView;

import androidx.annotation.NonNull;

import com.jacob.fruitoftek.safecrop.R;

import java.util.ArrayList;

public class SurveyedHouseHoldActivity extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private HhAdapter adapter;
    private List<HhModel> hhList;
    private HhDbHelper dbHelper;
    private TextView noRecordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_surveyed_house_hold);

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
        
        recyclerView = findViewById(R.id.hhRecyclerView);
        noRecordsTextView = findViewById(R.id.hhNoRecordsTextView); // Initialize the TextView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new HhDbHelper(this);
        hhList = fetchSurveyData();

        if (hhList.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE); // Show "No Record Found" message
            recyclerView.setVisibility(View.GONE);         // Hide RecyclerView
        } else {
            noRecordsTextView.setVisibility(View.GONE);    // Hide the message
            recyclerView.setVisibility(View.VISIBLE);      // Show RecyclerView
        }

        adapter = new HhAdapter(this, hhList);
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
                    filterHhList(query); // Apply the search filter
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterHhList(newText); // Apply the search filter
                    return false;
                }
            });
        }
    }

    private void filterHhList(String query) {
        List<HhModel> filteredList = new ArrayList<>();
        for (HhModel hh : hhList) {
            if (hh.getHh_name().toLowerCase().contains(query.toLowerCase()) ||
                    hh.getHh_community().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(hh);
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

    private List<HhModel> fetchSurveyData() {
        List<HhModel> list = new ArrayList<>();
        Cursor cursor = dbHelper.getHhSurveyData();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String hh_name = cursor.getString(cursor.getColumnIndexOrThrow("hh_name"));
                String hh_district = cursor.getString(cursor.getColumnIndexOrThrow("hh_district"));
                String hh_community = cursor.getString(cursor.getColumnIndexOrThrow("hh_community"));
                String hhquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion4"));
                String hhquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion5"));
                String hhquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion6"));
                String hhquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion7"));
                String hhquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion8"));
                String hhquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion9"));
                String hhquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion10"));
                String hhquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion11"));
                String hhquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion12"));
                String hhquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion13"));
                String hhquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion14"));
                String hhquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion15"));
                String hhquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion16"));
                String hhquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion17"));
                String hhquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion18"));
                String hhquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion19"));
                String hhquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion20"));
                String hhquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion21"));
                String hhquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion22"));
                String hhquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion23"));
                String hhquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion24"));
                String hhquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion25"));
                String hhquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion26"));
                String hhquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion27"));
                String hhquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion28"));
                String hhquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion29"));
                String hhquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion30"));
                String hhquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion31"));
                String hhquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion32"));
                String hhquestion36 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion36"));
                String hhquestion37 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion37"));
                String hh_location = cursor.getString(cursor.getColumnIndexOrThrow("hh_location"));
                Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                        ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                        : null;
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String user_fname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String user_lname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                list.add(new HhModel(id, hh_name, hh_district, hh_community,
                        hhquestion4, hhquestion5, hhquestion6, hhquestion7, hhquestion8, hhquestion9, hhquestion10,
                        hhquestion11, hhquestion12, hhquestion13, hhquestion14, hhquestion15, hhquestion16,
                        hhquestion17, hhquestion18, hhquestion19, hhquestion20, hhquestion21, hhquestion22,
                        hhquestion23, hhquestion24, hhquestion25, hhquestion26, hhquestion27, hhquestion28,
                        hhquestion29, hhquestion30, hhquestion31, hhquestion32, hhquestion36, hhquestion37,
                        hh_location, farmer_photo, signature, user_fname, user_lname, user_email,
                        onCreate, onUpdate));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.surveyed_household);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}