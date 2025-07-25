package com.jacob.fruitoftek.safecrop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
//import com.jacob.fruitoftek.safecrop.facerecognition.AddFaceActivity;
import com.jacob.fruitoftek.safecrop.login.AccountBottomSheet;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;
import com.jacob.fruitoftek.safecrop.sustain.SusCertDashboard;

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
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            int left = insets.getInsets(WindowInsetsCompat.Type.systemBars()).left;
            int top = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            int right = insets.getInsets(WindowInsetsCompat.Type.systemBars()).right;
            int bottom = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
            v.setPadding(left, top, right, bottom);
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

        // CardView access surveyAccess
        TextView surveyAccess = findViewById(R.id.dashboardMenu);
        CardView certSusCv = findViewById(R.id.certSusCv);
        CardView comDevCv = findViewById(R.id.comDevCv);
        CardView environmentalCV = findViewById(R.id.environmentalCV);
        CardView orgProCV = findViewById(R.id.orgProCV);

        certSusCv.setVisibility(View.GONE);
        comDevCv.setVisibility(View.GONE);
        environmentalCV.setVisibility(View.GONE);
        orgProCV.setVisibility(View.GONE);


        String access = preferenceHelper.getSurveyAccess();
        if (access != null && !access.trim().isEmpty()) {
            access = access.trim();
            Log.d("SurveyAccess", "access = " + access);

            if (access.contains(",")) {
                String[] accessList = access.split(",");
                for (String a : accessList) {
                    showCardByAccess(a.trim());
                }
            } else {
                showCardByAccess(access);
            }
        } else {
            surveyAccess.setText("No survey access granted");
            Toast.makeText(this, "No survey access granted", Toast.LENGTH_SHORT).show();
        }

        // Card click actions
        certSusCv.setOnClickListener(v -> startActivity(new Intent(this, SusCertDashboard.class)));
        comDevCv.setOnClickListener(v -> startActivity(new Intent(this, ComDevDashboard.class)));
//        environmentalCV.setOnClickListener(v -> startActivity(new Intent(this, EnvironmentalDashboard.class)));
//        orgProCV.setOnClickListener(v -> startActivity(new Intent(this, OrgProDashboard.class)));


        scheduleDailyExport();
        scheduleDailySync();
    }

    private void showCardByAccess(String access) {
        switch (access) {
            case "Sustainability":
                findViewById(R.id.certSusCv).setVisibility(View.VISIBLE);
                break;
            case "CLMRS":
                findViewById(R.id.comDevCv).setVisibility(View.VISIBLE);
                break;
            case "Environmental":
                findViewById(R.id.environmentalCV).setVisibility(View.VISIBLE);
                break;
            case "Organic":
                findViewById(R.id.orgProCV).setVisibility(View.VISIBLE);
                break;
            case "All":
                findViewById(R.id.certSusCv).setVisibility(View.VISIBLE);
                findViewById(R.id.comDevCv).setVisibility(View.VISIBLE);
                findViewById(R.id.environmentalCV).setVisibility(View.VISIBLE);
                findViewById(R.id.orgProCV).setVisibility(View.VISIBLE);
                break;
            default:
                Log.w("SurveyAccess", "Unknown card: " + access);
        }
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
