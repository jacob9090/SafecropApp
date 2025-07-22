package com.jacob.fruitoftek.safecrop.sustain.training;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
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

public class TrainingDoneActivity extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private TrainingAdapter adapter;
    private List<TrainingModel> trainingList;
    private TrainingDbHelper dbHelper;
    private TextView noRecordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_done);

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

        recyclerView = findViewById(R.id.trainingRecyclerView);
        noRecordsTextView = findViewById(R.id.noRecordsTextView); // Initialize the TextView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new TrainingDbHelper(this);
        trainingList = fetchSurveyData();

        if (trainingList.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE); // Show "No Record Found" message
            recyclerView.setVisibility(View.GONE);         // Hide RecyclerView
        } else {
            noRecordsTextView.setVisibility(View.GONE);    // Hide the message
            recyclerView.setVisibility(View.VISIBLE);      // Show RecyclerView
        }

        adapter = new TrainingAdapter(this, trainingList);
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
                    filterTrainingList(query); // Apply the search filter
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterTrainingList(newText); // Apply the search filter
                    return false;
                }
            });
        }
    }

    private void filterTrainingList(String query) {
        List<TrainingModel> filteredList = new ArrayList<>();
        for (TrainingModel training : trainingList) {
            if (training.getTraining_code().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(training);
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

    private List<TrainingModel> fetchSurveyData() {
        List<TrainingModel> list = new ArrayList<>();
        Cursor cursor = dbHelper.getInspectopnSurveyData();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String training_code = cursor.getString(cursor.getColumnIndexOrThrow("training_code"));
                String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
                String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
                String training_question1 = cursor.getString(cursor.getColumnIndexOrThrow("training_question1"));
                String training_question2 = cursor.getString(cursor.getColumnIndexOrThrow("training_question2"));
                String training_question3 = cursor.getString(cursor.getColumnIndexOrThrow("training_question3"));
                String training_question4 = cursor.getString(cursor.getColumnIndexOrThrow("training_question4"));
                String training_question5 = cursor.getString(cursor.getColumnIndexOrThrow("training_question5"));
                String training_question6 = cursor.getString(cursor.getColumnIndexOrThrow("training_question6"));
                String training_question7 = cursor.getString(cursor.getColumnIndexOrThrow("training_question7"));
                String training_location = cursor.getString(cursor.getColumnIndexOrThrow("training_location"));
                Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                        ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                        : null;
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String training_question8 = cursor.getString(cursor.getColumnIndexOrThrow("training_question8"));
                String training_question9 = cursor.getString(cursor.getColumnIndexOrThrow("training_question9"));
                String training_question10 = cursor.getString(cursor.getColumnIndexOrThrow("training_question10"));
                String training_question11 = cursor.getString(cursor.getColumnIndexOrThrow("training_question11"));
                String training_question12 = cursor.getString(cursor.getColumnIndexOrThrow("training_question12"));
                String training_question13 = cursor.getString(cursor.getColumnIndexOrThrow("training_question13"));
                String training_question14 = cursor.getString(cursor.getColumnIndexOrThrow("training_question14"));
                String training_question15 = cursor.getString(cursor.getColumnIndexOrThrow("training_question15"));
                String is_sync = cursor.getString(cursor.getColumnIndexOrThrow("is_sync"));
                String is_draft = cursor.getString(cursor.getColumnIndexOrThrow("is_draft"));
                String user_fname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String user_lname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                list.add(new TrainingModel(id, training_code, district, community, training_question1, training_question2,
                        training_question3, training_question4, training_question5, training_question6, training_question7,
                        training_location, farmer_photo, signature, training_question8, training_question9, training_question10,
                        training_question11, training_question12, training_question13, training_question14, training_question15,
                        is_sync, is_draft, user_fname, user_lname, user_email, onCreate, onUpdate));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.farmer_training);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}