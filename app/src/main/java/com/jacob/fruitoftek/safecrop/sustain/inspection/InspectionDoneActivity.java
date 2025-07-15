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
                String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
                String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
                String farmer_id = cursor.getString(cursor.getColumnIndexOrThrow("farmer_id"));
                String farmer_name = cursor.getString(cursor.getColumnIndexOrThrow("farmer_name"));
                String ghana_card = cursor.getString(cursor.getColumnIndexOrThrow("ghana_card"));
                String farmer_yob = cursor.getString(cursor.getColumnIndexOrThrow("farmer_yob"));
                String phone_number = cursor.getString(cursor.getColumnIndexOrThrow("phone_number"));
                String gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"));
                String inspection_date = cursor.getString(cursor.getColumnIndexOrThrow("inspection_date"));
                String inspector_name = cursor.getString(cursor.getColumnIndexOrThrow("inspector_name"));
                String inspection_question1 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question1"));
                String inspection_question2 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question2"));
                String inspection_question3 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question3"));
                String inspection_question4 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question4"));
                String inspection_question5 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question5"));
                String inspection_question6 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question6"));
                String inspection_question7 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question7"));
                String inspection_question8 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question8"));
                String inspection_question9 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question9"));
                String inspection_question10 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question10"));
                String inspection_question11 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question11"));
                String inspection_question12 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question12"));
                String inspection_question13 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question13"));
                String inspection_question14 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question14"));
                String inspection_question15 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question15"));
                String inspection_question16 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question16"));
                String inspection_question17 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question17"));
                String inspection_question18 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question18"));
                String inspection_question19 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question19"));
                String inspection_question20 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question20"));
                String inspection_question21 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question21"));
                String inspection_question22 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question22"));
                String inspection_question23 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question23"));
                String inspection_question24 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question24"));
                String inspection_question25 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question25"));
                String inspection_question26 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question26"));
                String inspection_question27 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question27"));
                String inspection_question28 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question28"));
                String inspection_question29 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question29"));
                String inspection_question30 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question30"));
                String inspection_question31 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question31"));
                String inspection_question32 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question32"));
                String inspection_question33 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question33"));
                String inspection_question34 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question34"));
                String inspection_question35 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question35"));
                String inspection_question36 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question36"));
                String inspection_question37 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question37"));
                String inspection_question38 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question38"));
                String inspection_question39 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question39"));
                String inspection_question40 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question40"));
                String inspection_question41 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question41"));
                String inspection_question42 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question42"));
                String inspection_question43 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question43"));
                String inspection_question44 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question44"));
                String inspection_question45 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question45"));
                String inspection_question46 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question46"));
                String inspection_question47 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question47"));
                String inspection_question48 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question48"));
                String inspection_question49 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question49"));
                String inspection_question50 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question50"));
                String inspection_question51 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question51"));
                String inspection_question52 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question52"));
                String inspection_question53 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question53"));
                String inspection_question54 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question54"));
                String inspection_question55 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question55"));
                String inspection_question56 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question56"));
                String inspection_question57 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question57"));
                String inspection_question58 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question58"));
                String inspection_question59 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question59"));
                String inspection_question60 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question60"));
                String inspection_question61 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question61"));
                String inspection_question62 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question62"));
                String inspection_question63 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question63"));
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
                        farmer_yob, phone_number, gender, inspection_date, inspector_name, inspection_question1,
                        inspection_question2, inspection_question3, inspection_question4, inspection_question5,
                        inspection_question6, inspection_question7, inspection_question8, inspection_question9,
                        inspection_question10, inspection_question11, inspection_question12, inspection_question13,
                        inspection_question14, inspection_question15, inspection_question16, inspection_question17,
                        inspection_question18, inspection_question19, inspection_question20, inspection_question21,
                        inspection_question22, inspection_question23, inspection_question24, inspection_question25,
                        inspection_question26, inspection_question27, inspection_question28, inspection_question29,
                        inspection_question30, inspection_question31, inspection_question32, inspection_question33,
                        inspection_question34, inspection_question35, inspection_question36, inspection_question37,
                        inspection_question38, inspection_question39, inspection_question40, inspection_question41,
                        inspection_question42, inspection_question43, inspection_question44, inspection_question45,
                        inspection_question46, inspection_question47, inspection_question48, inspection_question49,
                        inspection_question50, inspection_question51, inspection_question52, inspection_question53,
                        inspection_question54, inspection_question55, inspection_question56, inspection_question57,
                        inspection_question58, inspection_question59, inspection_question60, inspection_question61,
                        inspection_question62, inspection_question63, inspection_location, farmer_photo,
                        signature, is_sync, is_draft, user_fname, user_lname, user_email, onCreate, onUpdate));
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