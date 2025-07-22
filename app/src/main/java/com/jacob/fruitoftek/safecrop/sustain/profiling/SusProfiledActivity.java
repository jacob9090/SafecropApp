package com.jacob.fruitoftek.safecrop.sustain.profiling;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.ActionBar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;

public class SusProfiledActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SusProfilingAdapter adapter;
    private List<SusProfilingModel> susProfilingList;
    private SusProfilingDbHelper dbHelper;
    private TextView noRecordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sus_profiled);

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

        recyclerView = findViewById(R.id.susProfilingRecyclerView);
        noRecordsTextView = findViewById(R.id.noRecordsTextView); // Initialize the TextView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new SusProfilingDbHelper(this);
        susProfilingList = fetchSurveyData();

        if (susProfilingList.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            noRecordsTextView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }

        adapter = new SusProfilingAdapter(this, susProfilingList);
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
                    filterSusProfilingList(query); // Apply the search filter
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterSusProfilingList(newText); // Apply the search filter
                    return false;
                }
            });
        }
    }

    private void filterSusProfilingList(String query) {
        List<SusProfilingModel> filteredList = new ArrayList<>();
        for (SusProfilingModel susprofiling : susProfilingList) {
            if (susprofiling.getFarmer_id().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(susprofiling);
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

    private List<SusProfilingModel> fetchSurveyData() {
        List<SusProfilingModel> list = new ArrayList<>();
        Cursor cursor = dbHelper.getSusProfilingSurveyData();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String farmer_id = cursor.getString(cursor.getColumnIndexOrThrow("farmer_id"));
                String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
                String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
                String suspro_question1 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question1"));
                String suspro_question2 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question2"));
                String suspro_question3 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question3"));
                String suspro_question4 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question4"));
                String suspro_question4b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question4b"));
                String suspro_question4c = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question4c"));
                String suspro_question5 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question5"));
                String suspro_question6 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question6"));
                String suspro_question7 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question7"));
                String suspro_question7b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question7b"));
                String suspro_question8 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question8"));
                String suspro_question8b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question8b"));
                String suspro_question9 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question9"));
                String suspro_question10 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question10"));
                String suspro_question11 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question11"));
                String suspro_question11b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question11b"));
                String suspro_question11c = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question11c"));
                String suspro_question12 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question12"));
                String suspro_question12b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question12b"));
                String suspro_question13 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question13"));
                String suspro_question14 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question14"));
                String suspro_question14b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question14b"));
                String suspro_question14c = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question14c"));
                String suspro_question14d = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question14d"));
                String suspro_question15 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question15"));
                String suspro_question15b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question15b"));
                String suspro_question16 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question16"));
                String suspro_question16b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question16b"));
                String suspro_question17 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question17"));
                String suspro_question17b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question17b"));
                String suspro_question17c = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question17c"));
                String suspro_question18 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question18"));
                String suspro_question19 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question19"));
                String suspro_question20 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question20"));
                String suspro_question21 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question21"));
                String suspro_location = cursor.getString(cursor.getColumnIndexOrThrow("suspro_location"));
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

                list.add(new SusProfilingModel(id, farmer_id, district, community, suspro_question1, suspro_question2,
                        suspro_question3, suspro_question4, suspro_question4b, suspro_question4c, suspro_question5,
                        suspro_question6, suspro_question7, suspro_question7b, suspro_question8, suspro_question8b,
                        suspro_question9, suspro_question10, suspro_question11, suspro_question11b, suspro_question11c,
                        suspro_question12, suspro_question12b, suspro_question13, suspro_question14, suspro_question14b,
                        suspro_question14c, suspro_question14d, suspro_question15, suspro_question15b, suspro_question16,
                        suspro_question16b, suspro_question17, suspro_question17b, suspro_question17c, suspro_question18,
                        suspro_question19, suspro_question20, suspro_question21, suspro_location, farmer_photo, signature,
                        is_sync, is_draft, user_fname, user_lname, user_email, onCreate, onUpdate));
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