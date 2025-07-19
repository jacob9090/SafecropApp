package com.jacob.fruitoftek.safecrop.comdev.obs;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;

import androidx.appcompat.app.AlertDialog;

import android.view.View;
import android.widget.ProgressBar;

import android.content.Context;
import android.util.Log;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

public class GetObservationLocationActivity extends AppCompatActivity {

    private MapView mapView;
    private TextView locationTextView;
    private Button captureButton, okButton;
    private ProgressBar loadingIndicator;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;
    private double capturedLatitude, capturedLongitude;
    private boolean waitingForLocation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_observation_location);

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

        locationTextView = findViewById(R.id.obsLocationTextView);
        captureButton = findViewById(R.id.obsCaptureSchLocationButton);
        okButton = findViewById(R.id.obsOkButton);
        loadingIndicator = findViewById(R.id.obsLoadingIndicator);

        // Check internet connection
        boolean hasInternet = isInternetAvailable();

        if (hasInternet) {
            // Load OpenStreetMap only if internet is available
            initializeMap();
        } else {
            Log.d("DEBUG", "No internet, running in offline mode.");
            Toast.makeText(this, "Offline Mode: Map disabled", Toast.LENGTH_SHORT).show();
        }

        // Initialize Fused Location Provider
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        // Capture button to fetch location
        captureButton.setOnClickListener(v -> {
            loadingIndicator.setVisibility(View.VISIBLE);  // Show loading indicator
            checkPermissionsAndGetLocation();
        });

        // OK button to send coordinates
        okButton.setOnClickListener(v -> sendLocationToMainActivity());
    }

    /**
     * Check internet connection.
     */
    private boolean isInternetAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkCapabilities capabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
            return capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR));
        }
        return false;
    }

    /**
     * Initialize OpenStreetMap only when the app is online.
     */
    private void initializeMap() {
        mapView = findViewById(R.id.obsMapView);
        if (mapView == null) {
            Log.e("DEBUG", "MapView is null! Initialization failed.");
            return;
        }

        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, ctx.getSharedPreferences("osmdroid", MODE_PRIVATE));
        Configuration.getInstance().setUserAgentValue(getPackageName());

        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        // Set default location
        GeoPoint defaultLocation = new GeoPoint(6.6720, -1.6052);
        mapView.getController().setZoom(10.0);
        mapView.getController().setCenter(defaultLocation);

        Log.d("DEBUG", "MapView initialized successfully.");
    }

    /**
     * Check location permissions and request if necessary.
     */
    private void checkPermissionsAndGetLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissionsLauncher.launch(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            });
        } else {
            // Check if GPS is enabled
            if (!isLocationEnabled()) {
                waitingForLocation = true;  // Set flag to wait for location
                promptUserToEnableLocation();
            } else {
                requestLocationUpdates();
            }
        }
    }

    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    private void promptUserToEnableLocation() {
        new AlertDialog.Builder(this)
                .setTitle("Enable Location")
                .setMessage("Location services are required to get your current location. Please turn on GPS.")
                .setPositiveButton("Enable", (dialog, which) -> {
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                })
                .setNegativeButton("Cancel", (dialog, which) -> showToast("Location is required to continue."))
                .show();
    }

    /**
     * Request location updates.
     */
    private void requestLocationUpdates() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            showToast("Location permission is required.");
            loadingIndicator.setVisibility(View.GONE); // Hide loading if permissions are missing
            return;
        }

        LocationRequest locationRequest = new LocationRequest.Builder(LocationRequest.PRIORITY_HIGH_ACCURACY, 5000)
                .setMinUpdateDistanceMeters(10)
                .setWaitForAccurateLocation(true)
                .build();

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                Location location = locationResult.getLastLocation();
                if (location != null) {
                    updateLocation(location);
                    fusedLocationProviderClient.removeLocationUpdates(locationCallback);
                } else {
                    showToast("Failed to retrieve location.");
                }
                loadingIndicator.setVisibility(View.GONE); // Hide loading when done
            }
        };

        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, getMainLooper());
    }

    /**
     * Update location in UI and on map (if online).
     */
    private void updateLocation(Location location) {
        capturedLatitude = location.getLatitude();
        capturedLongitude = location.getLongitude();
        String coordinates = capturedLatitude + ", " + capturedLongitude;
        locationTextView.setText(coordinates);

        // Only update the map if internet is available
        if (isInternetAvailable() && mapView != null) {
            updateMapLocation(capturedLatitude, capturedLongitude);
        } else {
            Log.d("DEBUG", "Offline mode: Skipping map update.");
        }
    }

    /**
     * Update OpenStreetMap with new location.
     */
    private void updateMapLocation(double latitude, double longitude) {
        if (mapView == null) {
            Log.e("DEBUG", "updateMapLocation: MapView is null, cannot update location.");
            return;
        }

        GeoPoint point = new GeoPoint(latitude, longitude);
        mapView.getController().setZoom(18.0);
        mapView.getController().setCenter(point);

        // Add marker
        Marker marker = new Marker(mapView);
        marker.setPosition(point);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker.setTitle("Captured Location");

        mapView.getOverlays().add(marker);
        mapView.invalidate();
    }

    /**
     * Send captured location back to main activity.
     */
    private void sendLocationToMainActivity() {
        Intent intent = new Intent();
        intent.putExtra("location", capturedLatitude + ", " + capturedLongitude);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    /**
     * Handle permission request results.
     */
    private final ActivityResultLauncher<String[]> requestPermissionsLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {
                if (Boolean.TRUE.equals(result.get(Manifest.permission.ACCESS_FINE_LOCATION))) {
                    requestLocationUpdates();
                } else {
                    showPermissionDeniedDialog();
                    loadingIndicator.setVisibility(View.GONE); // Hide loading if permissions are denied
                }
            });

    /**
     * Show an alert dialog if the user denies permissions.
     */
    private void showPermissionDeniedDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Permission Required")
                .setMessage("This app requires location permission to work properly. Please enable it in settings.")
                .setPositiveButton("Go to Settings", (dialog, which) -> {
                    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(android.net.Uri.parse("package:" + getPackageName()));
                    startActivity(intent);
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    /**
     * Show a toast message for errors or status updates.
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (isInternetAvailable() && mapView != null) {
            mapView.onResume();
        }

        // If GPS was off and the user enabled it, fetch location
        if (waitingForLocation && isLocationEnabled()) {
            waitingForLocation = false;  // Reset flag
            requestLocationUpdates();
        }
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