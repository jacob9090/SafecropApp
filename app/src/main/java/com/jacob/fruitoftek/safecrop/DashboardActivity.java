package com.jacob.fruitoftek.safecrop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.jacob.fruitoftek.safecrop.comdev.ComDevDashboard;
import com.jacob.fruitoftek.safecrop.comdev.ExportCsvWorker;
import com.jacob.fruitoftek.safecrop.comdev.SyncDataWorker;
import com.jacob.fruitoftek.safecrop.farmertrain.TrainingDashboard;
import com.jacob.fruitoftek.safecrop.hrdd.HrddDashboard;
import com.jacob.fruitoftek.safecrop.login.AccountBottomSheet;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class DashboardActivity extends AppCompatActivity {

    @Inject
    PreferenceHelper preferenceHelper;

    private AccountBottomSheet profileBottomSheet;
    private InfoBottomSheet infoBottomSheet;
    private SettingsBottomSheet settingsBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

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

        TextView userFNameTv = findViewById(R.id.userFNameTv);
        TextView userEmailTv = findViewById(R.id.userEmailTv);
        userFNameTv.setText(getString(R.string.greeting, requireNotNull(preferenceHelper).getFirstName()));
        userEmailTv.setText(requireNotNull(preferenceHelper).getEmail());

        profileBottomSheet = new AccountBottomSheet();
        infoBottomSheet = new InfoBottomSheet();
        settingsBottomSheet = new SettingsBottomSheet();

        ImageView userProfileBtn = findViewById(R.id.userProfileBtn);
        userProfileBtn.setOnClickListener(view -> {
            profileBottomSheet.show(getSupportFragmentManager(), "accountBottomSheet");
        });

        ImageView infoBtn = findViewById(R.id.infoBtn);
        infoBtn.setOnClickListener(view -> {
            infoBottomSheet.show(getSupportFragmentManager(), "infoBottomSheet");
        });

        ImageView settingsBtn = findViewById(R.id.settingseBtn);
        settingsBtn.setOnClickListener(view -> {
            settingsBottomSheet.show(getSupportFragmentManager(), "settingsBottomSheet");
        });

        CardView comDevCv = findViewById(R.id.comDevCv);
        comDevCv.setOnClickListener(view -> startActivity(new Intent(DashboardActivity.this, ComDevDashboard.class)));

        CardView trainCV = findViewById(R.id.trainingCV);
        trainCV.setOnClickListener(view -> startActivity(new Intent(DashboardActivity.this, TrainingDashboard.class)));

        CardView hrddCV = findViewById(R.id.hrddCV);
        hrddCV.setOnClickListener(view -> startActivity(new Intent(DashboardActivity.this, HrddDashboard.class)));

        scheduleDailyExport();
        scheduleDailySync();
    }

    private void scheduleDailySync() {
        WorkManager workManager = WorkManager.getInstance(this);

        // Timer
        Calendar calendar = Calendar.getInstance();
        long currentTime = System.currentTimeMillis();

        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // If it's already past 18:00, schedule for next day
        if(calendar.getTimeInMillis() <= currentTime) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        long initialDelay = calendar.getTimeInMillis() - currentTime;

        PeriodicWorkRequest syncWork = new PeriodicWorkRequest.Builder(
                SyncDataWorker.class,
                24,
                TimeUnit.HOURS
        )
                .setInitialDelay(initialDelay, TimeUnit.MILLISECONDS)
                .setConstraints(
                        new Constraints.Builder()
                                .setRequiredNetworkType(NetworkType.CONNECTED)
                                .build()
                )
                .build();

        workManager.enqueueUniquePeriodicWork(
                "daily_server_sync",
                ExistingPeriodicWorkPolicy.KEEP,
                syncWork
        );
    }

    private void scheduleDailyExport() {
        WorkManager workManager = WorkManager.getInstance(this);

        // Calculate initial delay to 18:00
        Calendar calendar = Calendar.getInstance();
        long currentTime = System.currentTimeMillis();

        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // If it's already past, schedule for next day
        if(calendar.getTimeInMillis() <= currentTime) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        long initialDelay = calendar.getTimeInMillis() - currentTime;

        PeriodicWorkRequest exportWork = new PeriodicWorkRequest.Builder(
                ExportCsvWorker.class,
                24,
                TimeUnit.HOURS
        ).setInitialDelay(initialDelay, TimeUnit.MILLISECONDS).build();

        workManager.enqueueUniquePeriodicWork(
                "daily_csv_export",
                ExistingPeriodicWorkPolicy.KEEP,
                exportWork
        );
    }

    private <T> T requireNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException("Required value was null.");
        }
        return obj;
    }

    private void injectDependencies() {
        // Dagger/Hilt setup
        preferenceHelper = new PreferenceHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Register callback for back press handling
        OnBackPressedDispatcher dispatcher = this.getOnBackPressedDispatcher();
        dispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed()
            {
                // Show exit bottom sheet dialog
                ExitBottomSheet exitBottomSheet = new ExitBottomSheet();
                exitBottomSheet.show(getSupportFragmentManager(), "ExitBottomSheet");
            }
        });
    }
}
