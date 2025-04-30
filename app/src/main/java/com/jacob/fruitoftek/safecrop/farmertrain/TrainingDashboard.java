package com.jacob.fruitoftek.safecrop.farmertrain;

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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jacob.fruitoftek.safecrop.InfoBottomSheet;
import com.jacob.fruitoftek.safecrop.SettingsBottomSheet;

import javax.inject.Inject;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.login.AccountBottomSheet;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;
import com.jacob.fruitoftek.safecrop.traintopic.TrainingListActivity;
import com.jacob.fruitoftek.safecrop.traintopic.TrainingListDatabaseHelper;
import com.jacob.fruitoftek.safecrop.traintopic.TrainingListModal;

import java.util.ArrayList;
import java.util.List;

public class TrainingDashboard extends AppCompatActivity {

    Boolean isAllFabsVisible;

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

        TextView cloudBackupTv = findViewById(R.id.cloudBackupTv);
        TextView localBackupTv = findViewById(R.id.localBackupTv);
        FloatingActionButton comDevBackupFb = findViewById(R.id.comDevBackupFb);
        FloatingActionButton cloudBackupFb = findViewById(R.id.cloudBackupFb);
        FloatingActionButton localBackupFb = findViewById(R.id.localBackupFb);

        cloudBackupFb.setVisibility(View.GONE);
        localBackupFb.setVisibility(View.GONE);
        cloudBackupTv.setVisibility(View.GONE);
        localBackupTv.setVisibility(View.GONE);

        isAllFabsVisible = false;

        comDevBackupFb.setOnClickListener(view -> {
            if (!isAllFabsVisible) {
                // when isAllFabsVisible becomes true make all
                // the action name texts and FABs VISIBLE
                cloudBackupFb.show();
                localBackupFb.show();
                cloudBackupTv.setVisibility(View.VISIBLE);
                localBackupTv.setVisibility(View.VISIBLE);

                // make the boolean variable true as we
                // have set the sub FABs visibility to GONE
                isAllFabsVisible = true;
            } else {
                // when isAllFabsVisible becomes true make
                // all the action name texts and FABs GONE.
                cloudBackupFb.hide();
                localBackupFb.hide();
                cloudBackupTv.setVisibility(View.GONE);
                localBackupTv.setVisibility(View.GONE);

                // make the boolean variable false as we
                // have set the sub FABs visibility to GONE
                isAllFabsVisible = false;
            }
        });

        cloudBackupFb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TrainCloudBottomSheet bottomSheet = new TrainCloudBottomSheet();
                        bottomSheet.show(getSupportFragmentManager(), "ModalBottomSheet");
                    }
                });

        localBackupFb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TrainLocalBottomSheet bottomSheet = new TrainLocalBottomSheet();
                        bottomSheet.show(getSupportFragmentManager(), "ModalBottomSheet");
                    }
                });
    }


    private void initializeUI() {
        trainingRecyclerView = findViewById(R.id.trainingRecyclerView);
//        totalTrainingLoaded = findViewById(R.id.totalTrainingLoaded);
        emptyState = findViewById(R.id.emptyState);

        // Initialize adapter FIRST
        trainingAdapter = new TrainingListAdapter(new ArrayList<>(), farmer -> {
            Intent intent = new Intent(this, NewTrainingActivity.class);
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
//        totalTrainingLoaded.setText(String.valueOf(cachedFarmers.size()));
    }

    private void updateUIWithFarmers() {
        trainingAdapter.updateList(TrainingListActivity.trainingList);
        emptyState.setVisibility(View.GONE);
//        totalTrainingLoaded.setText(String.valueOf(FarmerListActivity.farmerList.size()));
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