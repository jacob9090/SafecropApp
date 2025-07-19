package com.jacob.fruitoftek.safecrop.organic.orgpro;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;
import android.Manifest;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GetOrgProLocationActivity extends AppCompatActivity {

    private TextView locationTextView;
    private TextView accuracyTextView;
    private LocationManager locationManager;
    private LocationListener locationListener;

    private static final long LOCATION_TIMEOUT = 10000; // 10 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_org_pro_location);

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

        setupActionBar();

        locationTextView = findViewById(R.id.orgProlocationTextView);
        accuracyTextView = findViewById(R.id.orgProaccuracyTextView);
        Button captureButton = findViewById(R.id.orgProcaptureSchLocationButton);
        Button okButton = findViewById(R.id.orgProokButton);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
//                locationTextView.setText(String.format("Latitude: %.6f, Longitude: %.6f", location.getLatitude(), location.getLongitude()));
                locationTextView.setText(location.getLatitude() + ", " + location.getLongitude());
                accuracyTextView.setText(String.format("Accuracy: %.2f meters", location.getAccuracy()));
                locationManager.removeUpdates(this);
            }

            @Override
            public void onProviderEnabled(@NonNull String provider) {}

            @Override
            public void onProviderDisabled(@NonNull String provider) {}

            @Override
            public void onStatusChanged(@NonNull String provider, int status, @Nullable Bundle extras) {}
        };

        captureButton.setOnClickListener(v -> {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            } else {
                List<String> providers = locationManager.getAllProviders();
                for (String provider : providers) {
                    locationManager.requestLocationUpdates(provider, 0, 0, locationListener);
                }

                new Handler().postDelayed(() -> {
                    locationManager.removeUpdates(locationListener);
                    locationTextView.setText("Location unavailable");
                    accuracyTextView.setText("Accuracy: N/A");
                }, LOCATION_TIMEOUT);
            }
        });

        okButton.setOnClickListener(v -> {
            String location = locationTextView.getText().toString();
            if (location.isEmpty()) {
                Toast.makeText(GetOrgProLocationActivity.this, "Location unavailable", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("location", location);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.get_location);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}