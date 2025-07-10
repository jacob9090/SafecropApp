package com.jacob.fruitoftek.safecrop.sustain.training.old;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;

import com.jacob.fruitoftek.safecrop.InfoBottomSheet;
import com.jacob.fruitoftek.safecrop.SettingsBottomSheet;

import javax.inject.Inject;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.login.AccountBottomSheet;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;
import com.jacob.fruitoftek.safecrop.sustain.traintopic.TrainingListActivity;
import com.jacob.fruitoftek.safecrop.sustain.traintopic.TrainingListDatabaseHelper;
import com.jacob.fruitoftek.safecrop.sustain.traintopic.TrainingListModal;

import java.util.ArrayList;
import java.util.List;

public class TrainingDashboard extends AppCompatActivity {

    @Inject
    PreferenceHelper preferenceHelper;

    private AccountBottomSheet profileBottomSheet;
    private InfoBottomSheet infoBottomSheet;
    private SettingsBottomSheet settingsBottomSheet;

    private RecyclerView trainingRecyclerView;
    private TrainingListAdapter trainingAdapter;
    private TextView emptyState;
//    private TextView totalTrainingLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_training_dashboard);

        // Inject dependencies
        injectDependencies();

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initializeUI();

        TextView userFNameTv = findViewById(R.id.userFNameTv);
        TextView userEmailTv = findViewById(R.id.userEmailTv);
        userFNameTv.setText("Hi, " + requireNotNull(preferenceHelper).getFirstName());
        userEmailTv.setText(requireNotNull(preferenceHelper).getEmail());

        profileBottomSheet = new AccountBottomSheet();
        infoBottomSheet = new InfoBottomSheet();
        settingsBottomSheet = new SettingsBottomSheet();

        ImageView userProfileBtn = findViewById(R.id.userProfileBtn);
        userProfileBtn.setOnClickListener(view -> {
            profileBottomSheet.show(getSupportFragmentManager(), "accountBottomSheet"); // Show the fragment
        });

        ImageView infoBtn = findViewById(R.id.infoBtn);
        infoBtn.setOnClickListener(view -> {
            infoBottomSheet.show(getSupportFragmentManager(), "infoBottomSheet"); // Show the fragment
        });

        ImageView settingsBtn = findViewById(R.id.settingseBtn);
        settingsBtn.setOnClickListener(view -> {
            settingsBottomSheet.show(getSupportFragmentManager(), "settingsBottomSheet"); // Show the fragment
        });

    }

    private void initializeUI() {
        trainingRecyclerView = findViewById(R.id.trainingRecyclerView);
        emptyState = findViewById(R.id.emptyState);

        // Initialize adapter FIRST
        trainingAdapter = new TrainingListAdapter(new ArrayList<>(), farmer -> {
            Intent intent = new Intent(this, TrainingAttendance.class);
            intent.putExtra("topic", farmer.getTopic());
            intent.putExtra("description", farmer.getDescription());
            startActivity(intent);
        });

        if (trainingRecyclerView != null) {
            trainingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            trainingRecyclerView.setAdapter(trainingAdapter);
        }

        // Now load data AFTER adapter is initialized
        if (!TrainingListActivity.trainingList.isEmpty()) {
            updateUIWithFarmers();
        } else {
            loadCachedFarmers();
        }
    }

    private void loadCachedFarmers() {
        TrainingListDatabaseHelper dbHelper = new TrainingListDatabaseHelper(this);
        List<TrainingListModal> cachedFarmers = dbHelper.getAllTraining();
        trainingAdapter.updateList(cachedFarmers);
        emptyState.setVisibility(cachedFarmers.isEmpty() ? View.VISIBLE : View.GONE);
    }

    private void updateUIWithFarmers() {
        trainingAdapter.updateList(TrainingListActivity.trainingList);
        emptyState.setVisibility(View.GONE);
    }

    private <T> T requireNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException("Required value was null.");
        }
        return obj;
    }

    private void injectDependencies() {
        preferenceHelper = new PreferenceHelper(this);
    }
}