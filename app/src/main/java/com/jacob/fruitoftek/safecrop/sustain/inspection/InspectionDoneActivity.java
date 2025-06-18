package com.jacob.fruitoftek.safecrop.sustain.inspection;

import android.net.Uri;
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

import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class InspectionDoneActivity extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private InspectionAdapter adapter;
    private List<InspectionModel> inspectionLise;
    private InspectionDbHelper dbHelper;
    private TextView noRecordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inspection_done);
        
        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        recyclerView = findViewById(R.id.inspectionRecyclerView);
        noRecordsTextView = findViewById(R.id.noRecordsTextView); // Initialize the TextView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new InspectionDbHelper(this);
        inspectionLise = fetchSurveyData();

        if (inspectionLise.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE); // Show "No Record Found" message
            recyclerView.setVisibility(View.GONE);         // Hide RecyclerView
        } else {
            noRecordsTextView.setVisibility(View.GONE);    // Hide the message
            recyclerView.setVisibility(View.VISIBLE);      // Show RecyclerView
        }

        adapter = new InspectionAdapter(this, inspectionLise);
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
        List<InspectionModel> filteredList = new ArrayList<>();
        for (InspectionModel pen : inspectionLise) {
            if (pen.getCommunity().toLowerCase().contains(query.toLowerCase()) ||
                    pen.getFarmer_name().toLowerCase().contains(query.toLowerCase()) ||
                    pen.getDistrict().toLowerCase().contains(query.toLowerCase())) {
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

    private List<InspectionModel> fetchSurveyData() {
        List<InspectionModel> list = new ArrayList<>();
        Cursor cursor = dbHelper.getInspectopnSurveyData();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String farmer_id = cursor.getString(cursor.getColumnIndexOrThrow("farmer_id"));
                String farmer_name = cursor.getString(cursor.getColumnIndexOrThrow("farmer_name"));
                String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
                String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
                String inspection_question1 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question1"));
                String inspection_question2 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question2"));
                String inspection_question3 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question3"));
                String inspection_question4 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question4"));
                String inspection_question5 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question5"));
                String inspection_location = cursor.getString(cursor.getColumnIndexOrThrow("inspection_location"));
                Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                        ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                        : null;
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String is_sync = cursor.getString(cursor.getColumnIndexOrThrow("is_sync"));
                String is_draft = cursor.getString(cursor.getColumnIndexOrThrow("is_draft"));
                String user_fname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String user_lname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                list.add(new InspectionModel(id, farmer_id, farmer_name, district, community, inspection_question1,
                        inspection_question2, inspection_question3, inspection_question4, inspection_question5,
                        inspection_location, farmer_photo, signature, is_sync, is_draft, user_fname, user_lname, user_email,
                        onCreate, onUpdate));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.inspection_survey);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}