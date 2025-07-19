package com.jacob.fruitoftek.safecrop.comdev.com;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.jacob.fruitoftek.safecrop.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GetComPhotoActivity extends AppCompatActivity {

    private static final int STORAGE_PERMISSION_CODE = 101;
    private static final int CAMERA_PERMISSION_CODE = 102;

    private ImageView imageView;
    private Uri imageUri;
    private File imageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_com_photo);

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

        imageView = findViewById(R.id.comImageView);
        Button btnCaptureOrSelect = findViewById(R.id.combtnCaptureOrSelect);
        Button btnOk = findViewById(R.id.combtnOk);

        // Set listener to capture or select photo
        btnCaptureOrSelect.setOnClickListener(v -> {
            if (checkStoragePermission() && checkCameraPermission()) {
                showImageOptions();
            } else {
                if (!checkStoragePermission()) {
                    requestStoragePermission();
                } else if (!checkCameraPermission()) {
                    requestCameraPermission();
                }
            }
        });

        // Set listener for saving photo and returning result
        btnOk.setOnClickListener(v -> {
            if (imageUri != null) {
                // Create "ComPhoto" folder in app directory
                File storageDir = new File(getApplicationContext().getFilesDir(), "ComPhoto");
                if (!storageDir.exists()) {
                    storageDir.mkdirs();
                }

                // Generate unique filename with extension based on imageUri
                String filename = String.format("comphoto_%s.%s", System.currentTimeMillis(), getExtensionFromUri(imageUri));

                // Create new File object for the image in the "ComPhoto" folder
                File newImageFile = new File(storageDir, filename);

                // Copy image from original Uri to the new File
                try {
                    copyFile(imageUri, newImageFile);
                    // Using FileProvider to get URI
                    Uri contentUri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".fileprovider", newImageFile);
                    Log.d("GetComPhotoActivity", "Content URI: " + contentUri.toString()); // Log the content URI

                    // Pass the contentUri to GetComPhotoActivity
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("FarmerPhotoPath", contentUri.toString());
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } catch (IOException e) {
                    Log.e("GetComPhotoActivity", "Error copying image file", e);
                    Toast.makeText(this, "Failed to save photo.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "No photo selected.", Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    // Show options to capture or select photo
    private void showImageOptions() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        Intent chooser = Intent.createChooser(galleryIntent, "Select or Capture Image");
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{cameraIntent});
        selectOrCaptureLauncher.launch(chooser);
    }

    // Launch the camera app to capture a photo
    private void launchCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        selectOrCaptureLauncher.launch(cameraIntent);
    }

    // ActivityResultLauncher for handling camera/gallery results
    private final ActivityResultLauncher<Intent> selectOrCaptureLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null && data.getData() != null) {
                        // Image selected from the gallery
                        imageUri = data.getData();
                        loadImageIntoView(imageUri);
                    } else if (data != null && data.getExtras() != null) {
                        // Image captured with the camera
                        Bitmap capturedImage = (Bitmap) data.getExtras().get("data");
                        if (capturedImage != null) {
                            imageFile = saveBitmapToFile(capturedImage);
                            if (imageFile != null) {
                                imageUri = Uri.fromFile(imageFile);
                                loadImageIntoView(imageUri);
                            }
                        }
                    }
                } else {
                    Toast.makeText(this, "No image selected or captured.", Toast.LENGTH_SHORT).show();
                }
            }
    );

    // Save captured Bitmap to file
    private File saveBitmapToFile(@NonNull Bitmap bitmap) {
        try {
            // Get the directory for the app's external pictures directory
            File picturesDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "ComPhoto");

            // Create the directory if it does not exist
            if (!picturesDir.exists()) {
                if (!picturesDir.mkdirs()) {
                    Log.e("GetComPhotoActivity", "Failed to create directory: " + picturesDir.getPath());
                    Toast.makeText(this, "Failed to create directory.", Toast.LENGTH_SHORT).show();
                    return null;
                }
            }

            // Generate a unique file name with timestamp
            File imageFile = new File(picturesDir, "comphoto_" + System.currentTimeMillis() + ".jpg");

            // Write the bitmap to the file
            try (FileOutputStream fos = new FileOutputStream(imageFile)) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            }

            return imageFile;
        } catch (IOException e) {
            Log.e("GetComPhotoActivity", "Error saving bitmap to file", e);
            Toast.makeText(this, "Failed to save image.", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    // Load image into ImageView using Glide
    private void loadImageIntoView(Uri uri) {
        Glide.with(this)
                .load(uri)
                .placeholder(android.R.color.darker_gray)
                .error(android.R.drawable.stat_notify_error)
                .into(imageView);
    }

    // Check for storage permission
    private boolean checkStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_GRANTED;
        } else {
            return ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        }
    }

    // Check for camera permission
    private boolean checkCameraPermission() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    // Request storage permission
    private void requestStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_IMAGES}, STORAGE_PERMISSION_CODE);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    // Request camera permission
    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (checkCameraPermission()) {
                    showImageOptions();
                } else {
                    requestCameraPermission();
                }
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU ?
                                Manifest.permission.READ_MEDIA_IMAGES : Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    // Permission denied, but user can still request it again
                    Toast.makeText(this, "Storage permission is required to select photos.", Toast.LENGTH_LONG).show();
                } else {
                    // User explicitly denied and checked "Don't ask again"
                    Toast.makeText(this, "Storage permission is denied. You can enable it in app settings.", Toast.LENGTH_LONG).show();
                    // Guide the user to the app settings
                    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    startActivity(intent);
                }
            }
        } else if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showImageOptions();
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                    // Permission denied, but user can still request it again
                    Toast.makeText(this, "Camera permission is required to capture photos.", Toast.LENGTH_LONG).show();
                } else {
                    // User explicitly denied and checked "Don't ask again"
                    Toast.makeText(this, "Camera permission is denied. You can enable it in app settings.", Toast.LENGTH_LONG).show();
                    // Guide the user to the app settings
                    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    startActivity(intent);
                }
            }
        }
    }

    // Helper method to get file extension from Uri
    private String getExtensionFromUri(Uri uri) {
        if (uri == null || uri.getScheme() == null) {
            return null;
        }
        if (ContentResolver.SCHEME_FILE.equals(uri.getScheme())) {
            return MimeTypeMap.getFileExtensionFromUrl(uri.getPath());
        }

        String mimeType = getContentResolver().getType(uri);
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeType != null && mimeType.startsWith("image/")
                ? mimeTypeMap.getExtensionFromMimeType(mimeType)
                : null;
    }

    // Helper method to copy file from Uri to File
    private void copyFile(Uri sourceUri, File destFile) throws IOException {
        InputStream inputStream = getContentResolver().openInputStream(sourceUri);
        OutputStream outputStream = new FileOutputStream(destFile);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.get_photo);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    
    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}