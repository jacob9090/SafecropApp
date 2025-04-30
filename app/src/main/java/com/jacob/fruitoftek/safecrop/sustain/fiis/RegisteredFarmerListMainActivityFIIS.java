package com.jacob.fruitoftek.safecrop.sustain.fiis;

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jacob.fruitoftek.safecrop.R;

public class RegisteredFarmerListMainActivityFIIS extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterRecordFIIS adapterRecordFIIS;
    private MyFIISDbHelper dbHelper;
    private SwipeRefreshLayout swipeRefreshLayout;
    FloatingActionButton addRecordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registered_farmer_list_main_fiis);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Inspected Farmers");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        swipeRefreshLayout = findViewById(R.id.fiisSwipeRefreshLayout);
        recyclerView = findViewById(R.id.fiisRecordsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new MyFIISDbHelper(this);

        //loadRecords();

        swipeRefreshLayout.setOnRefreshListener(() -> {
            // Refresh the records
            //loadRecords();
        });

//        addRecordBtn = findViewById(R.id.fiisAddRecordBtn);
//        addRecordBtn.setOnClickListener(view -> startActivity(new Intent(RegisteredFarmerListMainActivityFIIS.this, ProfileExistingFarmerOneFIIS.class)));

    }

//    private void loadRecords() {
//        ArrayList<ModelRecordFIIS> recordsList = new ArrayList<>(dbHelper.getAllRecords(ConstansGMRS.COLUMN_CREATION_DATE + " DESC"));
//        adapterRecordFIIS = new AdapterRecordFIIS(this, recordsList);
//        recyclerView.setAdapter(adapterRecordFIIS);
//        swipeRefreshLayout.setRefreshing(false); // Stop the refreshing animation
//    }
}