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
    private List<InspectionModel> inspectionList;
    private InspectionDbHelper dbHelper;
    private TextView noRecordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inspection_done);

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

        recyclerView = findViewById(R.id.inspectionRecyclerView);
        noRecordsTextView = findViewById(R.id.noRecordsTextView); // Initialize the TextView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new InspectionDbHelper(this);
        inspectionList = fetchSurveyData();

        if (inspectionList.isEmpty()) {
            noRecordsTextView.setVisibility(View.VISIBLE); // Show "No Record Found" message
            recyclerView.setVisibility(View.GONE);         // Hide RecyclerView
        } else {
            noRecordsTextView.setVisibility(View.GONE);    // Hide the message
            recyclerView.setVisibility(View.VISIBLE);      // Show RecyclerView
        }

        adapter = new InspectionAdapter(this, inspectionList);
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
                    filterInspectionList(query); // Apply the search filter
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterInspectionList(newText); // Apply the search filter
                    return false;
                }
            });
        }
    }

    private void filterInspectionList(String query) {
        List<InspectionModel> filteredList = new ArrayList<>();
        for (InspectionModel inspection : inspectionList) {
            if (inspection.getFarmer_id().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(inspection);
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
                String ghana_card = cursor.getString(cursor.getColumnIndexOrThrow("ghana_card"));
                String farmer_yob = cursor.getString(cursor.getColumnIndexOrThrow("farmer_yob"));
                String farmer_phone = cursor.getString(cursor.getColumnIndexOrThrow("farmer_phone"));
                String farmer_gender = cursor.getString(cursor.getColumnIndexOrThrow("farmer_gender"));
                String inspection_date = cursor.getString(cursor.getColumnIndexOrThrow("inspection_date"));
                String inspector_name = cursor.getString(cursor.getColumnIndexOrThrow("inspector_name"));
                String inspection_question1 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question1"));
                String inspection_question1b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question1b"));
                String inspection_question2 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question2"));
                String inspection_question2b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question2b"));
                String inspection_question3 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question3"));
                String inspection_question3b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question3b"));
                String inspection_question4 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question4"));
                String inspection_question4b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question4b"));
                String inspection_question5 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question5"));
                String inspection_question5b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question5b"));
                String inspection_question6 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question6"));
                String inspection_question6b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question6b"));
                String inspection_question7 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question7"));
                String inspection_question7b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question7b"));
                String inspection_question8 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question8"));
                String inspection_question8b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question8b"));
                String inspection_question9 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question9"));
                String inspection_question9b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question9b"));
                String inspection_question10 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question10"));
                String inspection_question10b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question10b"));
                String inspection_question11 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question11"));
                String inspection_question11b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question11b"));
                String inspection_question12 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question12"));
                String inspection_question12b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question12b"));
                String inspection_question13 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question13"));
                String inspection_question13b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question13b"));
                String inspection_question14 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question14"));
                String inspection_question14b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question14b"));
                String inspection_question15 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question15"));
                String inspection_question15b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question15b"));
                String inspection_question16 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question16"));
                String inspection_question16b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question16b"));
                String inspection_question17 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question17"));
                String inspection_question17b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question17b"));
                String inspection_question18 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question18"));
                String inspection_question18b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question18b"));
                String inspection_question19 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question19"));
                String inspection_question19b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question19b"));
                String inspection_question20 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question20"));
                String inspection_question20b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question20b"));
                String inspection_question21 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question21"));
                String inspection_question21b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question21b"));
                String inspection_question22 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question22"));
                String inspection_question22b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question22b"));
                String inspection_question23 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question23"));
                String inspection_question23b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question23b"));
                String inspection_question24 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question24"));
                String inspection_question24b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question24b"));
                String inspection_question25 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question25"));
                String inspection_question25b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question25b"));
                String inspection_question26 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question26"));
                String inspection_question26b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question26b"));
                String inspection_question27 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question27"));
                String inspection_question27b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question27b"));
                String inspection_question28 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question28"));
                String inspection_question28b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question28b"));
                String inspection_question29 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question29"));
                String inspection_question29b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question29b"));
                String inspection_question30 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question30"));
                String inspection_question30b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question30b"));
                String inspection_question31 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question31"));
                String inspection_question31b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question31b"));
                String inspection_question32 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question32"));
                String inspection_question32b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question32b"));
                String inspection_question33 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question33"));
                String inspection_question33b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question33b"));
                String inspection_question34 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question34"));
                String inspection_question34b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question34b"));
                String inspection_question35 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question35"));
                String inspection_question35b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question35b"));
                String inspection_question36 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question36"));
                String inspection_question36b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question36b"));
                String inspection_question37 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question37"));
                String inspection_question37b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question37b"));
                String inspection_question38 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question38"));
                String inspection_question38b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question38b"));
                String inspection_question39 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question39"));
                String inspection_question39b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question39b"));
                String inspection_question40 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question40"));
                String inspection_question40b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question40b"));
                String inspection_question41 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question41"));
                String inspection_question41b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question41b"));
                String inspection_question42 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question42"));
                String inspection_question42b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question42b"));
                String inspection_question43 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question43"));
                String inspection_question43b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question43b"));
                String inspection_question44 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question44"));
                String inspection_question44b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question44b"));
                String inspection_question45 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question45"));
                String inspection_question45b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question45b"));
                String inspection_question46 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question46"));
                String inspection_question46b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question46b"));
                String inspection_question47 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question47"));
                String inspection_question47b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question47b"));
                String inspection_question48 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question48"));
                String inspection_question48b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question48b"));
                String inspection_question49 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question49"));
                String inspection_question49b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question49b"));
                String inspection_question50 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question50"));
                String inspection_question50b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question50b"));
                String inspection_question51 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question51"));
                String inspection_question51b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question51b"));
                String inspection_question52 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question52"));
                String inspection_question52b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question52b"));
                String inspection_question53 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question53"));
                String inspection_question53b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question53b"));
                String inspection_question54 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question54"));
                String inspection_question54b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question54b"));
                String inspection_question55 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question55"));
                String inspection_question55b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question55b"));
                String inspection_question56 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question56"));
                String inspection_question56b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question56b"));
                String inspection_question57 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question57"));
                String inspection_question57b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question57b"));
                String inspection_question58 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question58"));
                String inspection_question58b = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question58b"));
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

                list.add(new InspectionModel(id, district, community, farmer_id, farmer_name, ghana_card,
                        farmer_yob, farmer_phone, farmer_gender, inspection_date, inspector_name, inspection_question1, inspection_question1b,
                        inspection_question2, inspection_question2b, inspection_question3, inspection_question3b, inspection_question4,
                        inspection_question4b, inspection_question5, inspection_question5b, inspection_question6, inspection_question6b,
                        inspection_question7, inspection_question7b, inspection_question8, inspection_question8b, inspection_question9,
                        inspection_question9b, inspection_question10, inspection_question10b, inspection_question11, inspection_question11b,
                        inspection_question12, inspection_question12b, inspection_question13, inspection_question13b, inspection_question14,
                        inspection_question14b, inspection_question15, inspection_question15b, inspection_question16, inspection_question16b,
                        inspection_question17, inspection_question17b, inspection_question18, inspection_question18b, inspection_question19,
                        inspection_question19b, inspection_question20, inspection_question20b, inspection_question21, inspection_question21b,
                        inspection_question22, inspection_question22b, inspection_question23, inspection_question23b, inspection_question24,
                        inspection_question24b, inspection_question25, inspection_question25b, inspection_question26, inspection_question26b,
                        inspection_question27, inspection_question27b, inspection_question28, inspection_question28b, inspection_question29,
                        inspection_question29b, inspection_question30, inspection_question30b, inspection_question31, inspection_question31b,
                        inspection_question32, inspection_question32b, inspection_question33, inspection_question33b, inspection_question34,
                        inspection_question34b, inspection_question35, inspection_question35b, inspection_question36, inspection_question36b,
                        inspection_question37, inspection_question37b, inspection_question38, inspection_question38b, inspection_question39,
                        inspection_question39b, inspection_question40, inspection_question40b, inspection_question41, inspection_question41b,
                        inspection_question42, inspection_question42b, inspection_question43, inspection_question43b, inspection_question44,
                        inspection_question44b, inspection_question45, inspection_question45b, inspection_question46, inspection_question46b,
                        inspection_question47, inspection_question47b, inspection_question48, inspection_question48b, inspection_question49,
                        inspection_question49b, inspection_question50, inspection_question50b, inspection_question51, inspection_question51b,
                        inspection_question52, inspection_question52b, inspection_question53, inspection_question53b, inspection_question54,
                        inspection_question54b, inspection_question55, inspection_question55b, inspection_question56, inspection_question56b,
                        inspection_question57, inspection_question57b, inspection_question58, inspection_question58b, inspection_location,
                        farmer_photo, signature, is_sync, is_draft, user_fname, user_lname, user_email, onCreate, onUpdate));
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