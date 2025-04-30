package com.jacob.fruitoftek.safecrop.sustain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jacob.fruitoftek.safecrop.InfoBottomSheet;
import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.SettingsBottomSheet;
import com.jacob.fruitoftek.safecrop.login.AccountBottomSheet;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;
import com.jacob.fruitoftek.safecrop.sustain.gmrs.GMRDbHelper;
import com.jacob.fruitoftek.safecrop.sustain.gmrs.GMRProfiledFarmersListActivity;
import com.jacob.fruitoftek.safecrop.sustain.gmrs.GMRProfilingWebActivity;

import javax.inject.Inject;

public class SusCertDashboard extends AppCompatActivity {

    // to check whether sub FAB buttons are visible or not.
    Boolean isAllFabsVisible;

    @Inject
    GMRDbHelper dbHelper;

    @Inject
    PreferenceHelper preferenceHelper;

    private AccountBottomSheet profileBottomSheet;
    private InfoBottomSheet infoBottomSheet;
    private SettingsBottomSheet settingsBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.sus_cert_dashboard);

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

        CardView profilingCv = findViewById(R.id.profilingCv);
        CardView inspectionCv = findViewById(R.id.inspectionCv);
        TextView cloudBackupTv = findViewById(R.id.cloudBackupTv);
        TextView localBackupTv = findViewById(R.id.localBackupTv);
        FloatingActionButton susBackupFb = findViewById(R.id.susBackupFb);
        FloatingActionButton cloudBackupFb = findViewById(R.id.cloudBackupFb);
        FloatingActionButton localBackupFb = findViewById(R.id.localBackupFb);

        cloudBackupFb.setVisibility(View.GONE);
        localBackupFb.setVisibility(View.GONE);
        cloudBackupTv.setVisibility(View.GONE);
        localBackupTv.setVisibility(View.GONE);

        isAllFabsVisible = false;

        profilingCv.setOnClickListener(view -> startActivity(new Intent(SusCertDashboard.this, GMRProfilingWebActivity.class)));
        inspectionCv.setOnClickListener(view -> startActivity(new Intent(SusCertDashboard.this, GMRProfiledFarmersListActivity.class)));

        susBackupFb.setOnClickListener(view -> {
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

        localBackupFb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SusCertLocalBottomSheet bottomSheet = new SusCertLocalBottomSheet();
                        bottomSheet.show(getSupportFragmentManager(), "ModalBottomSheet");
                    }
                });
        
        cloudBackupFb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SusCertCloudBottomSheet bottomSheet = new SusCertCloudBottomSheet();
                        bottomSheet.show(getSupportFragmentManager(), "ModalBottomSheet");
                    }
                });

    }

    private <T> T requireNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException("Required value was null.");
        }
        return obj;
    }

    private void injectDependencies() {
        // In a real-world scenario, replace this with your Dagger/Hilt setup
        dbHelper = new GMRDbHelper(this);
        preferenceHelper = new PreferenceHelper(this);
    }
}