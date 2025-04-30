package com.jacob.fruitoftek.safecrop.comdev.com;

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
import android.net.Uri;
import android.widget.SearchView;

import java.util.ArrayList;

public class SurveyedCommunitiesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CommunityAdapter adapter;
    private List<ComModel> comList;
    private ComDbHelper dbHelper;
    private TextView noRecordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_surveyed_communities);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        recyclerView = findViewById(R.id.comRecyclerView);
        noRecordsTextView = findViewById(R.id.comNoRecordsTextView); // Initialize the TextView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new ComDbHelper(this);
        comList = fetchSurveyData();

        if (comList.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE); // Show "No Record Found" message
            recyclerView.setVisibility(View.GONE);         // Hide RecyclerView
        } else {
            noRecordsTextView.setVisibility(View.GONE);    // Hide the message
            recyclerView.setVisibility(View.VISIBLE);      // Show RecyclerView
        }

        adapter = new CommunityAdapter(this, comList);
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
                    filterComList(query); // Apply the search filter
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterComList(newText); // Apply the search filter
                    return false;
                }
            });
        }
    }

    private void filterComList(String query) {
        List<ComModel> filteredList = new ArrayList<>();
        for (ComModel com : comList) {
            if (com.getCommquestion1().toLowerCase().contains(query.toLowerCase()) ||
                    com.getCommquestion2().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(com);
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

    private List<ComModel> fetchSurveyData() {
        List<ComModel> list = new ArrayList<>();
        Cursor cursor = dbHelper.getComSurveyData();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String commquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion1"));
                String commquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion2"));
                String commquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion3"));
                String commquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion4"));
                String commquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion5"));
                String commquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion6"));
                String commquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion7"));
                String commquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion8"));
                String commquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion9"));
                String commquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion10"));
                String commquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion11"));
                String commquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion12"));
                String commquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion13"));
                String commquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion14"));
                String commquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion15"));
                String commquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion16"));
                String commquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion17"));
                String commquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion18"));
                String commquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion19"));
                String commquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion20"));
                String commquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion21"));
                String commquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion22"));
                String commquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion23"));
                String commquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion24"));
                String commquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion25"));
                String commquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion26"));
                String commquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion27"));
                String commquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion28"));
                String commquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion29"));
                String commquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion30"));
                String commquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion31"));
                String commquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion32"));
                String commquestion33 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion33"));
                String commquestion34 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion34"));
                String commquestion35 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion35"));
                String commquestion36 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion36"));
                String commquestion37 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion37"));
                String commquestion38 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion38"));
                String commquestion39 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion39"));
                String commquestion40 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion40"));
                String commquestion41 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion41"));
                String commquestion42 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion42"));
                String commquestion43 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion43"));
                String commquestion44 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion44"));
                String commquestion45 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion45"));
                String commquestion46 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion46"));
                String commquestion47 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion47"));
                String commquestion48 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion48"));
                String commquestion49 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion49"));
                String commquestion50 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion50"));
                String commquestion51 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion51"));
                String commquestion52 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion52"));
                String commquestion53 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion53"));
                String commquestion54 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion54"));
                String commquestion56 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion56"));
                String commquestion57 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion57"));
                String commquestion58 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion58"));
                String commquestion59 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion59"));
                String commquestion60 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion60"));
                String commquestion61 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion61"));
                String commquestion62 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion62"));
                String commquestion63 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion63"));
                String commquestion64 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion64"));
                String commquestion65 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion65"));
                String commquestion66 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion66"));
                String commquestion67 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion67"));
                String com_location = cursor.getString(cursor.getColumnIndexOrThrow("com_location"));
                Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                        ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                        : null;
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String user_fname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String user_oname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                list.add(new ComModel(id, commquestion1, commquestion2, commquestion3, commquestion4, commquestion5, commquestion6,
                        commquestion7, commquestion8, commquestion9, commquestion10, commquestion11, commquestion12,
                        commquestion13, commquestion14, commquestion15, commquestion16, commquestion17, commquestion18,
                        commquestion19, commquestion20, commquestion21, commquestion22, commquestion23, commquestion24,
                        commquestion25, commquestion26, commquestion27, commquestion28, commquestion29, commquestion30,
                        commquestion31, commquestion32, commquestion33, commquestion34, commquestion35, commquestion36,
                        commquestion37, commquestion38, commquestion39, commquestion40, commquestion41, commquestion42,
                        commquestion43, commquestion44, commquestion45, commquestion46, commquestion47, commquestion48,
                        commquestion49, commquestion50, commquestion51, commquestion52, commquestion53, commquestion54,
                        commquestion56, commquestion57, commquestion58, commquestion59, commquestion60, commquestion61,
                        commquestion62, commquestion63, commquestion64, commquestion65, commquestion66, commquestion67,
                        com_location, farmer_photo, signature, user_fname, user_oname, user_email, onCreate, onUpdate));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.surveyed_communities);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}