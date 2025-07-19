package com.jacob.fruitoftek.safecrop.comdev.sch;

import android.database.Cursor;
import android.net.Uri;
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

import java.util.ArrayList;
import java.util.List;

public class SurveyedSchoolsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SchoolsAdapter adapter;
    private List<SchoolModel> schoolList;
    private SchoolDbHelper dbHelper;
    private TextView noRecordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_surveyed_schools);

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

        recyclerView = findViewById(R.id.schRecyclerView);
        noRecordsTextView = findViewById(R.id.noRecordsTextView); // Initialize the TextView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new SchoolDbHelper(this);
        schoolList = fetchSurveyData();

        if (schoolList.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE); // Show "No Record Found" message
            recyclerView.setVisibility(View.GONE);         // Hide RecyclerView
        } else {
            noRecordsTextView.setVisibility(View.GONE);    // Hide the message
            recyclerView.setVisibility(View.VISIBLE);      // Show RecyclerView
        }

        adapter = new SchoolsAdapter(this, schoolList);
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
                    filterSchoolList(query); // Apply the search filter
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterSchoolList(newText); // Apply the search filter
                    return false;
                }
            });
        }
    }

    private void filterSchoolList(String query) {
        List<SchoolModel> filteredList = new ArrayList<>();
        for (SchoolModel school : schoolList) {
            if (school.getSch_name().toLowerCase().contains(query.toLowerCase()) ||
                    school.getSch_district().toLowerCase().contains(query.toLowerCase()) ||
                    school.getSch_community().toLowerCase().contains(query.toLowerCase())) {
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

    private List<SchoolModel> fetchSurveyData() {
        List<SchoolModel> list = new ArrayList<>();
        Cursor cursor = dbHelper.getSchSurveyData();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String school_name = cursor.getString(cursor.getColumnIndexOrThrow("school_name"));
                String school_district = cursor.getString(cursor.getColumnIndexOrThrow("school_district"));
                String school_community = cursor.getString(cursor.getColumnIndexOrThrow("school_community"));
                String schquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion4"));
                String schquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion5"));
                String schquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion6"));
                String schquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion7"));
                String schquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion8"));
                String schquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion9"));
                String schquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion10"));
                String schquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion11"));
                String schquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion12"));
                String schquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion13"));
                String schquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion14"));
                String schquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion15"));
                String schquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion16"));
                String schquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion17"));
                String schquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion18"));
                String schquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion19"));
                String schquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion20"));
                String schquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion21"));
                String schquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion22"));
                String schquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion23"));
                String schquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion24"));
                String schquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion25"));
                String schquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion26"));
                String schquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion27"));
                String schquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion28"));
                String schquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion29"));
                String schquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion30"));
                String schquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion31"));
                String schquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion32"));
                String schquestion33 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion33"));
                String schquestion34 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion34"));
                String school_location = cursor.getString(cursor.getColumnIndexOrThrow("school_location"));
                Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                        ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                        : null;
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String user_fname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String user_lname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                list.add(new SchoolModel(id, school_name, school_district, school_community,
                        schquestion4, schquestion5, schquestion6, schquestion7, schquestion8, schquestion9, schquestion10,
                        schquestion11, schquestion12, schquestion13, schquestion14, schquestion15, schquestion16, schquestion17,
                        schquestion18, schquestion19, schquestion20, schquestion21, schquestion22, schquestion23, schquestion24,
                        schquestion25, schquestion26, schquestion27, schquestion28, schquestion29, schquestion30, schquestion31,
                        schquestion32, schquestion33, schquestion34, school_location, farmer_photo, signature, user_fname, user_email,
                        user_lname, onCreate, onUpdate));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.surveyed_schools);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}