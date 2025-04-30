package com.jacob.fruitoftek.safecrop.farmerlist;

import static com.jacob.fruitoftek.safecrop.farmerlist.FarmerListActivity.loadCachedFarmers;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FarmersDayListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FarmerListAdapter farmerAdapter;
    private EditText searchField;
    private TextView emptyState;
    private TextView totalFarmersLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_farmers_day_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeUI();

        if (!FarmerListActivity.farmerList.isEmpty()) {
            farmerAdapter.updateList(FarmerListActivity.farmerList);
            emptyState.setVisibility(FarmerListActivity.farmerList.isEmpty() ? View.VISIBLE : View.GONE);
        } else {
            loadCachedFarmers(this, farmerAdapter, emptyState, totalFarmersLoaded);
        }

        searchField.addTextChangedListener(new TextWatcherAdapter(this::filterList));
    }

    private void initializeUI() {
        recyclerView = findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            farmerAdapter = new FarmerListAdapter(new ArrayList<>(), farmer -> {
                Toast.makeText(this, "Clicked on: " + farmer.getName(), Toast.LENGTH_SHORT).show();
            });
            recyclerView.setAdapter(farmerAdapter);
        } else {
            throw new NullPointerException("RecyclerView is null. Ensure it is defined in the layout file.");
        }

        searchField = findViewById(R.id.searchField);
        emptyState = findViewById(R.id.emptyState);
    }

    private void filterList(String query) {
        List<FarmerListModal> filteredList = FarmerListActivity.farmerList.stream()
                .filter(farmer -> farmer.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
        farmerAdapter.updateList(filteredList);
        emptyState.setVisibility(filteredList.isEmpty() ? View.VISIBLE : View.GONE);
    }

    private static class TextWatcherAdapter implements TextWatcher {
        private final Consumer<String> onTextChanged;

        TextWatcherAdapter(Consumer<String> onTextChanged) {
            this.onTextChanged = onTextChanged;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            onTextChanged.accept(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {}
    }
}