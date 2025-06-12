package com.jacob.fruitoftek.safecrop.sustain.profiling;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

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

import java.util.ArrayList;
import java.util.List;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;

public class GMRProfiledFarmersListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GMRAdapter adapter;
    private List<GMRModel> gmrList;
    private GMRDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gmrprofiled_farmers_list);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new GMRDbHelper(this);
        gmrList = fetchSurveyData();

        adapter = new GMRAdapter(this, gmrList);
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
                    adapter.filter(query); // Apply the search filter
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.filter(newText); // Apply the search filter
                    return false;
                }
            });
        }
    }

    private List<GMRModel> fetchSurveyData() {
        List<GMRModel> list = new ArrayList<>();
        Cursor cursor = dbHelper.getSurveyData();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String fname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String lname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String gmrquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion1"));
                String gmrquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion2"));
                String gmrquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion3"));
                String gmrquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion4"));
                String gmrquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion5"));
                String gmrquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion6"));
                String gmrquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion7"));
                String gmrquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion8"));
                String gmrquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion9"));
                Uri idPhoto = cursor.getString(cursor.getColumnIndexOrThrow("id_photo")) != null
                        ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("id_photo")))
                        : null;
                String gmrquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion11"));
                String gmrquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion12"));
                String gmrquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion13"));
                String gmrquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion14"));
                String gmrquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion15"));
                String gmrquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion16"));
                String gmrquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion17"));
                String gmrquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion18"));
                String gmrquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion19"));
                String gmrquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion20"));
                String gmrquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion21"));
                String gmrquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion22"));
                String gmrquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion23"));
                String gmrquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion24"));
                String gmrquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion25"));
                String gmrquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion26"));
                String gmrquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion27"));
                String gmrquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion28"));
                String gmrquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion29"));
                String gmrquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion30"));
                String gmrquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion31"));
                String gmrquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion32"));
                String gmrquestion33 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion33"));
                String gmrquestion34 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion34"));
                String gmrquestion35 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion35"));
                String gmrquestion36 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion36"));
                String gmrquestion37 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion37"));
                String gmrquestion38 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion38"));
                String gmrquestion39 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion39"));
                Uri farmerPhoto = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                        ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                        : null;
                Uri tpPhoto = cursor.getString(cursor.getColumnIndexOrThrow("tp_photo")) != null
                        ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("tp_photo")))
                        : null;
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String gmrquestion43 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion43"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                list.add(new GMRModel(fname, lname,
                        gmrquestion1, gmrquestion2, gmrquestion3, gmrquestion4, gmrquestion5, gmrquestion6,
                        gmrquestion7, gmrquestion8, gmrquestion9, idPhoto, gmrquestion11, gmrquestion12,
                        gmrquestion13, gmrquestion14, gmrquestion15, gmrquestion16, gmrquestion17, gmrquestion18,
                        gmrquestion19, gmrquestion20, gmrquestion21, gmrquestion22, gmrquestion23, gmrquestion24,
                        gmrquestion25, gmrquestion26, gmrquestion27, gmrquestion28, gmrquestion29, gmrquestion30,
                        gmrquestion31, gmrquestion32, gmrquestion33, gmrquestion34, gmrquestion35, gmrquestion36,
                        gmrquestion37, gmrquestion38, gmrquestion39, farmerPhoto, tpPhoto, signature,
                        gmrquestion43, onCreate, onUpdate));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.profiled_farmers);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}