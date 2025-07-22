package com.jacob.fruitoftek.safecrop.sustain.training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.sustain.SusCertDashboard;

public class TrainingCompletedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN

        );

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_training_completed);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Button newSuvBtn = findViewById(R.id.newSurvey);
        Button homeSuvBtn = findViewById(R.id.goHome);

        newSuvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nsintent = new Intent(TrainingCompletedActivity.this, TrainingActivity.class);
                startActivity(nsintent);
                finish();

            }
        });

        homeSuvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent dintent = new Intent(TrainingCompletedActivity.this, SusCertDashboard.class);
                startActivity(dintent);
                finish();

            }
        });
    }
}