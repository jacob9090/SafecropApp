package com.jacob.fruitoftek.safecrop.sustain.training.old;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;
import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.media.Image;
import android.os.Build;

import androidx.annotation.NonNull;

import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;


import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.jacob.fruitoftek.safecrop.facerecognition.FaceDatabaseHelper;
import com.jacob.fruitoftek.safecrop.facerecognition.SimilarityClassifier;

import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import android.util.Size;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.tensorflow.lite.Interpreter;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TrainingAttendance extends AppCompatActivity {

    FaceDetector detector;
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    PreviewView previewView;
    ImageView face_preview, camera_switch;
    Interpreter tfLite;
    TextView reco_name, preview_info, preview_header;
    Button save_attendance, view_uploaded_farmers;
    CameraSelector cameraSelector;
    boolean developerMode = false;
    float distance = 1.0f;
    boolean start = true;
    boolean flipX = false;
    Context context = TrainingAttendance.this;
    int cam_face = CameraSelector.LENS_FACING_BACK;
    int[] intValues;
    int inputSize = 112;
    boolean isModelQuantized = false;
    float[][] embeedings;
    float IMAGE_MEAN = 128.0f;
    float IMAGE_STD = 128.0f;
    int OUTPUT_SIZE = 192;
    private static int SELECT_PICTURE = 1;
    ProcessCameraProvider cameraProvider;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    String modelFile = "mobile_face_net.tflite";
    private List<SimilarityClassifier.Recognition> registered = new ArrayList<>();
    private FaceDatabaseHelper dbHelper; // Add this

    @RequiresApi(api = Build.VERSION_CODES.M)

    Spinner spinnerContinent, spinnerCountry, spinnerCapital;
    ImageView imageViewLocation;

    // Data mappings
    Map<String, List<String>> continentCountryMap = new HashMap<>();
    Map<String, List<String>> countryCapitalMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_training_attendance);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        spinnerContinent = findViewById(R.id.spinnerContinent);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerCapital = findViewById(R.id.spinnerCapital);
        imageViewLocation = findViewById(R.id.facePreviewImageView);

        // Initialize sample data
        initSampleData();

        // Populate continents
        final List<String> continents = new ArrayList<>(continentCountryMap.keySet());
        ArrayAdapter<String> adapterContinent = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, continents);
        adapterContinent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerContinent.setAdapter(adapterContinent);

        spinnerContinent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedContinent = continents.get(position);
                loadCountries(selectedContinent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCountry = (String) spinnerCountry.getSelectedItem();
                loadCapitals(selectedCountry);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinnerCapital.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCapital = (String) spinnerCapital.getSelectedItem();
                // Example: set an image based on capital (here just placeholder)
                imageViewLocation.setImageResource(R.drawable.user);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        face_preview = findViewById(R.id.facePreviewImageView);
        reco_name = findViewById(R.id.previewInfoTxt);
        preview_info = findViewById(R.id.previewInfoTxt);
        camera_switch = findViewById(R.id.cameraSwitchBtn);
        save_attendance = findViewById(R.id.save_attendance);
//        view_uploaded_farmers = findViewById(R.id.view_uploaded_farmers);

//        view_uploaded_farmers.setOnClickListener(v -> startActivity(new Intent(this, AddedFaceListActivity.class)));

        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
        }

        camera_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cam_face == CameraSelector.LENS_FACING_BACK) {
                    cam_face = CameraSelector.LENS_FACING_FRONT;
                    flipX = true;
                } else {
                    cam_face = CameraSelector.LENS_FACING_BACK;
                    flipX = false;
                }
                cameraProvider.unbindAll();
                cameraBind();
            }
        });

        try {
            tfLite = new Interpreter(loadModelFile(TrainingAttendance.this, modelFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FaceDetectorOptions highAccuracyOpts =
                new FaceDetectorOptions.Builder()
                        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                        .build();
        detector = FaceDetection.getClient(highAccuracyOpts);
        cameraBind();

        preview_info.setText("1. Bring Face in view of Camera.");

        dbHelper = new FaceDatabaseHelper(this); // Initialize dbHelper
        registered = dbHelper.getAllFaces();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    private MappedByteBuffer loadModelFile(Activity activity, String MODEL_FILE) throws IOException {
        AssetFileDescriptor fileDescriptor = activity.getAssets().openFd(MODEL_FILE);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    private void cameraBind() {
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        previewView = findViewById(R.id.previewView);
        cameraProviderFuture.addListener(() -> {
            try {
                cameraProvider = cameraProviderFuture.get();
                bindPreview(cameraProvider);
            } catch (ExecutionException | InterruptedException e) {
            }
        }, ContextCompat.getMainExecutor(this));
    }

    void bindPreview(@NonNull ProcessCameraProvider cameraProvider) {
        Preview preview = new Preview.Builder()
                .build();
        cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(cam_face)
                .build();
        preview.setSurfaceProvider(previewView.getSurfaceProvider());
        ImageAnalysis imageAnalysis =
                new ImageAnalysis.Builder()
                        .setTargetResolution(new Size(640, 480))
                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                        .build();
        Executor executor = Executors.newSingleThreadExecutor();
        imageAnalysis.setAnalyzer(executor, new ImageAnalysis.Analyzer() {
            @Override
            public void analyze(@NonNull ImageProxy imageProxy) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                InputImage image = null;
                @SuppressLint("UnsafeExperimentalUsageError")
                Image mediaImage = imageProxy.getImage();
                if (mediaImage != null) {
                    image = InputImage.fromMediaImage(mediaImage, imageProxy.getImageInfo().getRotationDegrees());
                }
                Task<List<Face>> result =
                        detector.process(image)
                                .addOnSuccessListener(
                                        new OnSuccessListener<List<Face>>() {
                                            @Override
                                            public void onSuccess(List<Face> faces) {
                                                if (faces.size() != 0) {
                                                    Face face = faces.get(0);
                                                    Bitmap frame_bmp = toBitmap(mediaImage);
                                                    int rot = imageProxy.getImageInfo().getRotationDegrees();
                                                    Bitmap frame_bmp1 = rotateBitmap(frame_bmp, rot, false, false);
                                                    RectF boundingBox = new RectF(face.getBoundingBox());
                                                    Bitmap cropped_face = getCropBitmapByCPU(frame_bmp1, boundingBox);
                                                    if (flipX)
                                                        cropped_face = rotateBitmap(cropped_face, 0, flipX, false);
                                                    Bitmap scaled = getResizedBitmap(cropped_face, 112, 112);
                                                    if (start)
                                                        recognizeImage(scaled);
                                                } else {
                                                    reco_name.setText("No Face Detected!");
                                                }
                                            }
                                        })
                                .addOnFailureListener(
                                        new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                            }
                                        })
                                .addOnCompleteListener(new OnCompleteListener<List<Face>>() {
                                    @Override
                                    public void onComplete(@NonNull Task<List<Face>> task) {
                                        imageProxy.close();
                                    }
                                });
            }
        });
        cameraProvider.bindToLifecycle((LifecycleOwner) this, cameraSelector, imageAnalysis, preview);
    }

    public void recognizeImage(final Bitmap bitmap) {
        face_preview.setImageBitmap(bitmap);
        ByteBuffer imgData = ByteBuffer.allocateDirect(1 * inputSize * inputSize * 3 * 4);
        imgData.order(ByteOrder.nativeOrder());
        int[] intValues = new int[inputSize * inputSize];
        bitmap.getPixels(intValues, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int pixel = 0;
        for (int i = 0; i < inputSize; ++i) {
            for (int j = 0; j < inputSize; ++j) {
                final int val = intValues[pixel++];
                imgData.putFloat((((val >> 16) & 0xFF) - IMAGE_MEAN) / IMAGE_STD);
                imgData.putFloat((((val >> 8) & 0xFF) - IMAGE_MEAN) / IMAGE_STD);
                imgData.putFloat((((val) & 0xFF) - IMAGE_MEAN) / IMAGE_STD);
            }
        }
        Object[] inputArray = {imgData};
        Map<Integer, Object> outputMap = new HashMap<>();
        embeedings = new float[1][OUTPUT_SIZE];
        outputMap.put(0, embeedings);
        tfLite.runForMultipleInputsOutputs(inputArray, outputMap);
        SimilarityClassifier.Recognition result = null;
        float min_dist = Float.MAX_VALUE;

        for (SimilarityClassifier.Recognition entry : registered) { // Iterate through List
            float[] knownEmb = stringToFloatArray((String) entry.getExtra()); // Cast and convert
            float dist = 0;
            for (int i = 0; i < OUTPUT_SIZE; i++) {
                float diff = embeedings[0][i] - knownEmb[i];
                dist += diff * diff;
            }
            dist = (float) Math.sqrt(dist);
            if (dist < min_dist) {
                min_dist = dist;
                result = entry;
            }
        }
        if (result != null) {
            String name = result.getTitle();
            reco_name.setText("Face Recognized: " + name);
        } else {
            reco_name.setText("Unknown Person");
        }
    }

    public static Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }

    private static Bitmap rotateBitmap(Bitmap bitmap, int rotationDegrees, boolean flipX, boolean flipY) {
        Matrix matrix = new Matrix();
        matrix.postRotate(rotationDegrees);
        if (flipX) {
            matrix.postScale(-1.0f, 1.0f);
        }
        if (flipY) {
            matrix.postScale(1.0f, -1.0f);
        }
        Bitmap rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return rotatedBitmap;
    }

    private static Bitmap toBitmap(Image image) {
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer yBuffer = planes[0].getBuffer();
        ByteBuffer uBuffer = planes[1].getBuffer();
        ByteBuffer vBuffer = planes[2].getBuffer();
        int ySize = yBuffer.remaining();
        int uSize = uBuffer.remaining();
        int vSize = vBuffer.remaining();
        byte[] nv21 = new byte[ySize + uSize + vSize];
        yBuffer.get(nv21, 0, ySize);
        vBuffer.get(nv21, ySize, vSize);
        uBuffer.get(nv21, ySize + vSize, uSize);
        YuvImage yuvImage = new YuvImage(nv21, ImageFormat.NV21, image.getWidth(), image.getHeight(), null);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new android.graphics.Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 75, out);
        byte[] imageBytes = out.toByteArray();
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }

    public static Bitmap getCropBitmapByCPU(Bitmap source, RectF cropRectF) {
        Bitmap resultBitmap = Bitmap.createBitmap((int) cropRectF.width(),
                (int) cropRectF.height(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(resultBitmap);
        Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
        paint.setColor(Color.WHITE);
        c.drawRect(new RectF(0, 0, cropRectF.width(), cropRectF.height()), paint);
        Matrix matrix = new Matrix();
        matrix.postTranslate(-cropRectF.left, -cropRectF.top);
        c.drawBitmap(source, matrix, paint);
        if (source != null && !source.isRecycled()) {
            source.recycle();
        }
        return resultBitmap;
    }

    private float[] stringToFloatArray(String s) {
        String[] values = s.split(",");
        float[] result = new float[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = Float.parseFloat(values[i]);
        }
        return result;
    }

    private void initSampleData() {
        // Sample continents and countries
        List<String> asiaCountries = new ArrayList<>();
        asiaCountries.add("Derma");
        asiaCountries.add("Derma Nkwankyire");
        asiaCountries.add("Dwomo");
        asiaCountries.add("Techimantia");

        List<String> europeCountries = new ArrayList<>();
        europeCountries.add("Abechem");
        europeCountries.add("Ankaase");
        europeCountries.add("Apesika");
        europeCountries.add("Appiahkrom");
        europeCountries.add("Asenchem");
        europeCountries.add("Bomaa");
        europeCountries.add("Brosankro");
        europeCountries.add("Dumakwai");
        europeCountries.add("Jacobu");
        europeCountries.add("Katapei");
        europeCountries.add("Kisuogya");
        europeCountries.add("Kramokrom");
        europeCountries.add("Kruboa");
        europeCountries.add("Kusuogya");
        europeCountries.add("Kwaku Dua krom");
        europeCountries.add("Kyekyewere");
        europeCountries.add("Mampong");
        europeCountries.add("Old Town");
        europeCountries.add("Olumankrom");
        europeCountries.add("Pokuakura");
        europeCountries.add("Subompang");
        europeCountries.add("Tanokrom");
        europeCountries.add("Tepa");
        europeCountries.add("Tuagyankrom");

        continentCountryMap.put("Bechem", asiaCountries);
        continentCountryMap.put("Tepa", europeCountries);

        // Sample countries and capitals
        countryCapitalMap.put("Derma", List.of("After Two"));
        countryCapitalMap.put("Derma Nkwankyire", List.of("After Two"));
        countryCapitalMap.put("Dwomo", List.of("After Two"));
        countryCapitalMap.put("Techimantia", List.of("After Two"));
        countryCapitalMap.put("Abechem", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Ankaase", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Apesika", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Appiahkrom", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Asenchem", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Bomaa", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Brosankro", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Dumakwai", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Jacobu", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Katapei", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Kisuogya", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Kramokrom", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Kruboa", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Kusuogya", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Kwaku Dua krom", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Kyekyewere", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Mampong", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Old Town", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Olumankrom", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Pokuakura", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Subompang", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Tanokrom", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Tepa", List.of("Anidaso Cooperative"));
        countryCapitalMap.put("Tuagyankrom", List.of("Anidaso Cooperative"));
    }

    private void loadCountries(String continent) {
        List<String> countries = continentCountryMap.get(continent);
        if (countries == null) countries = new ArrayList<>();

        ArrayAdapter<String> adapterCountry = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapterCountry);

        if (!countries.isEmpty()) {
            loadCapitals(countries.get(0));
        } else {
            spinnerCapital.setAdapter(null);
        }
    }

    private void loadCapitals(String country) {
        List<String> capitals = countryCapitalMap.get(country);
        if (capitals == null) capitals = new ArrayList<>();

        ArrayAdapter<String> adapterCapital = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, capitals);
        adapterCapital.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCapital.setAdapter(adapterCapital);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.training_attendance);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}