package com.jacob.fruitoftek.safecrop.comdev;

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
import com.jacob.fruitoftek.safecrop.comdev.ch.ChildWebListFarmersActivity;
import com.jacob.fruitoftek.safecrop.comdev.com.CommunityWebSurveyActivity;
import com.jacob.fruitoftek.safecrop.comdev.cra.CommunityRiskAssceActivity;
import com.jacob.fruitoftek.safecrop.comdev.gra.GraActivity;
import com.jacob.fruitoftek.safecrop.comdev.hh.HouseHoldWebListFarmersActivity;
import com.jacob.fruitoftek.safecrop.comdev.lra.ChildForceLaborRiskAssceActivity;
import com.jacob.fruitoftek.safecrop.comdev.obs.ObservationWebListFarmersActivity;
import com.jacob.fruitoftek.safecrop.comdev.sch.SchoolWebSurveyActivity;
import com.jacob.fruitoftek.safecrop.login.AccountBottomSheet;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;

import javax.inject.Inject;

public class ComDevDashboard extends AppCompatActivity {

    Boolean isAllFabsVisible;

    @Inject
    PreferenceHelper preferenceHelper;

    private AccountBottomSheet profileBottomSheet;
    private InfoBottomSheet infoBottomSheet;
    private SettingsBottomSheet settingsBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.com_dev_dashboard);

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

        CardView comSurveyCV = findViewById(R.id.comSurveyCV);
        CardView schSurveyCV = findViewById(R.id.schSurveyCV);
        CardView houseHoldCV = findViewById(R.id.householdCV);
        CardView obsHoldCV = findViewById(R.id.obsHoldCV);
        CardView childSurveyCV = findViewById(R.id.childSurveyCV);
        CardView comRiskAssesCV = findViewById(R.id.comRiskAssesCV);
        CardView chForceLaborRiskAssesCV = findViewById(R.id.chForceLaborRiskAssesCV);
        CardView genderRiskAssesCV = findViewById(R.id.genderRiskAssesCV);

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

        comSurveyCV.setOnClickListener(view -> startActivity(new Intent(ComDevDashboard.this, CommunityWebSurveyActivity.class)));
        schSurveyCV.setOnClickListener(view -> startActivity(new Intent(ComDevDashboard.this, SchoolWebSurveyActivity.class)));
        houseHoldCV.setOnClickListener(view -> startActivity(new Intent(ComDevDashboard.this, HouseHoldWebListFarmersActivity.class)));
        obsHoldCV.setOnClickListener(view -> startActivity(new Intent(ComDevDashboard.this, ObservationWebListFarmersActivity.class)));
        childSurveyCV.setOnClickListener(view -> startActivity(new Intent(ComDevDashboard.this, ChildWebListFarmersActivity.class)));
        comRiskAssesCV.setOnClickListener(view -> startActivity(new Intent(ComDevDashboard.this, CommunityRiskAssceActivity.class)));
        chForceLaborRiskAssesCV.setOnClickListener(view -> startActivity(new Intent(ComDevDashboard.this, ChildForceLaborRiskAssceActivity.class)));
        genderRiskAssesCV.setOnClickListener(view -> startActivity(new Intent(ComDevDashboard.this, GraActivity.class)));

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
                        ComDevCloudBottomSheet bottomSheet = new ComDevCloudBottomSheet();
                        bottomSheet.show(getSupportFragmentManager(), "ModalBottomSheet");
                    }
                });

        localBackupFb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ComDevLocalBottomSheet bottomSheet = new ComDevLocalBottomSheet();
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
        preferenceHelper = new PreferenceHelper(this);
    }
}