package com.jacob.fruitoftek.safecrop.sustain.fiis;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputLayout;
import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class UpdateFIIS extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;
    
    private ImageView currentImageView, profileIv, farmerImageIv, agentSignImageIv;

    private TextView firstNameEt, otherNamesEt;
    private EditText iis_q1Et, iis_q2Et, iis_q3Et, iis_q4Et, iis_q5Et, iis_q6Et, iis_q7Et, iis_q8Et, iis_q9Et, iis_q10Et,
            iis_q11Et, iis_q12Et, iis_q13Et, iis_q14Et, iis_q15Et, iis_q16Et, iis_q17Et, iis_q18Et, iis_q19Et, iis_q20Et,
            iis_q21Et, iis_q22Et, iis_q23Et, iis_q24Et, iis_q25Et, iis_q26Et, iis_q27Et, iis_q28Et, iis_q29Et, iis_q30Et,
            iis_q31Et, iis_q32Et, iis_q33Et, iis_q34Et, iis_q35Et, iis_q36Et, iis_q37Et, iis_q38Et, iis_q39Et, iis_q40Et,
            iis_q41Et, iis_q42Et, iis_q42pjEt, iis_q43Et, iis_q43pjEt, iis_q44Et, iis_q44pjEt, iis_q45Et, iis_q45pjEt,
            iis_q46Et, iis_q46pjEt, iis_q47Et, iis_q47pjEt, iis_q48Et, iis_q48pjEt, iis_q49Et, iis_q49pjEt,  iis_q50Et, iis_q50pjEt,
            iis_q51Et, iis_q51pjEt, iis_q52Et, iis_q52pjEt, iis_q53Et, iis_q53pjEt, iis_q54Et, iis_q54pjEt, iis_q55Et, iis_q55pjEt, iis_q56Et, iis_q56pjEt,
            iis_q57Et, iis_q57pjEt, iis_q58Et, iis_q58pjEt, iis_q59Et, iis_q59pjEt, iis_q60Et, iis_q60pjEt, iis_q61Et, iis_q61pjEt,
            iis_q62Et, iis_q62pjEt, iis_q63Et, iis_q63pjEt, iis_q64Et, iis_q64pjEt, iis_q65Et, iis_q65pjEt, iis_q66Et, iis_q66pjEt,
            iis_q67Et, iis_q67pjEt, iis_q68Et,  iis_q68pjEt, iis_q69Et,  iis_q69pjEt, iis_q70Et, iis_q70pjEt, iis_q71Et, iis_q71pjEt,
            iis_q72Et, iis_q72pjEt, iis_q73Et, iis_q73pjEt, iis_q74Et, iis_q74pjEt, iis_q75Et, iis_q75pjEt, iis_q76Et, iis_q76pjEt,
            iis_q77Et, iis_q77pjEt, iis_q78Et, iis_q78pjEt, iis_q79Et, iis_q79pjEt, iis_q80Et, iis_q80pjEt, iis_q81Et, iis_q81pjEt,
            iis_q82Et, iis_q82pjEt, iis_q83Et, iis_q83pjEt, iis_q84Et, iis_q84pjEt, iis_q85Et, iis_q85pjEt, iis_q86Et, iis_q86pjEt, iis_q87Et, iis_q88Et, iis_q89Et, iis_q90Et,
            iis_q91Et, iis_q92Et, iis_q93Et, iis_q94Et, iis_q95Et, iis_q96Et, iis_q97Et,
            iis_q98Et, iis_q99Et, iis_q100Et, iis_q101Et, iis_q102Et, iis_q103Et, iis_q104Et,
            iis_q105Et, iis_q106Et, iis_q107Et, iis_q108Et, iis_q109Et, iis_q110Et, iis_q111Et,
            iis_q112Et, iis_q113Et, iis_q114Et, iis_q115Et, iis_q116Et, iis_q117Et, iis_q118Et,
            iis_q119Et, iis_q87pjEt, iis_q88pjEt, iis_q89pjEt, iis_q90pjEt, iis_q91pjEt, iis_q92pjEt,
            iis_q93pjEt, iis_q94pjEt, iis_q95pjEt, iis_q96pjEt, iis_q97pjEt, iis_q98pjEt, iis_q99pjEt,
            iis_q100pjEt, iis_q101pjEt, iis_q102pjEt, iis_q103pjEt, iis_q104pjEt, iis_q105pjEt,
            iis_q106pjEt, iis_q107pjEt, iis_q108pjEt, iis_q109pjEt, iis_q110pjEt, iis_q111pjEt,
            iis_q112pjEt, iis_q113pjEt, iis_q114pjEt, iis_q115pjEt, iis_q116pjEt, iis_q117pjEt,
            iis_q118pjEt;
    private AutoCompleteTextView iisgen, iisdistrict, iiscommunity, iisfarm_unit, iisfarm_visited, numberofpermworkers,
            iisgenp1, iisgenp2, iisgenp3, iisgenp4, iisgenp5, q42spinner, q43spinner, q44spinner, q45spinner, q46spinner,
            q47spinner, q48spinner, q49spinner, q50spinner, q51spinner, q52spinner, iisq53spinner, iisq54spinner,
            q55spinner, q56spinner, q57spinner, q58spinner, q59spinner, q60spinner, q61spinner, q62spinner, q63spinner,
            q64spinner, q65spinner, q66spinner, q67spinner, q68spinner, q69spinner, q70spinner, q71spinner, q72spinner,
            q73spinner, q74spinner, q75spinner, q76spinner, q77spinner, q78spinner, q79spinner, q80spinner, q81spinner,
            q82spinner, q83spinner, q84spinner, q85spinner, q86spinner, q87spinner, q88spinner, q89spinner, q90spinner, q91spinner,
            q92spinner, q93spinner, q94spinner, q95spinner, q96spinner, q97spinner, q98spinner,
            q99spinner, q100spinner, q101spinner, q102spinner, q103spinner, q104spinner, q105spinner,
            q106spinner, q107spinner, q108spinner, q109spinner, q110spinner, q111spinner, q112spinner,
            q113spinner, q114spinner, q115spinner, q116spinner, q117spinner, q118spinner;
    private Button updateBtn, dobBtn;
    private Uri profileIvUri, farmerImageIvUri, agentSignImageIvUri;
    private String profileImagePath, farmerImagePath, agentSignImagePath, recordId;
    private MyFIISDbHelper dbHelper;
    private PreferenceHelper preferenceHelper;

    boolean[] selectedLanguage;
    ArrayList<Integer> langList = new ArrayList<>();
    String[] langArray = {"Manure", "Compost", "Disease-free farm debris", "Other"};


    boolean[] selectedLostFarmTo;
    ArrayList<Integer> lostFarmToList = new ArrayList<>();
    String[] lostFarmToArray = {"Leased", "Sold", "Fire", "Fulani", "Galamsey", "Other"};

    boolean[] selectedCropGrown;
    ArrayList<Integer> cropGrownList = new ArrayList<>();
    String[] cropGrownArray = {"Fallow", "palm trees", "para rubber", "vegetables", "other"};


    boolean[] selectedWaterSource;
    ArrayList<Integer> waterSourceList = new ArrayList<>();
    String[] waterSourceArray = {"River", "Stream", "Hand dug well", "Pond"};


    boolean[] selectedIPMMethod;
    ArrayList<Integer> IPMMethodList = new ArrayList<>();
    String[] IPMMethodArray = {"Physical", "Biological", "Chemical", "Prevention, Monitoring & Intervention"};


    boolean[] avoidSprayDriftContamination;
    ArrayList<Integer> avoidSprayDriftContaminationList = new ArrayList<>();
    String[] avoidSprayDriftContaminationArray = {"Non Application Zone (Buffer Zone)", "Non Crop Vegetative Barriers", "Warning Signs"};

    private List<String> selectedItems = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private TextView q16s1Tv, q16s2Tv, q17s1Tv, q18s1Tv, q18s2Tv, q18s3Tv, q19s1Tv, q20s1Tv, q21s1Tv, q21s2Tv, q29s1Tv, q31s1Tv;
    private TextInputLayout q16s1Mt, q16s2Mt, q17s1Mt, q18s3Mt, q19s1Mt, q20s1Mt, q21s1Mt, q21s2Mt, q29s1Mt, q31s1Mt;
    LinearLayout hhp1Ll, hhp2Ll, hhp3Ll, hhp4Ll, hhp5Ll, hhp6Ll, hhp7Ll, hhp8Ll, hhp9Ll, hhp10Ll;

    private static final int IMAGE_PICK_CAMERA_CODE = 102;
    private static final int IMAGE_PICK_GALLERY_CODE = 103;
    private String[] cameraPermissions;
    private String[] storagePermissions;

    private GpsTrackerFIIS gpsTracker;

    // Declare a member variable to hold the date picker instance
    private MaterialDatePicker<Long> datePicker;

    private final ActivityResultLauncher<Intent> captureImageLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Bundle extras = result.getData().getExtras();
                    if (extras != null) {
                        Bitmap imageBitmap = (Bitmap) extras.get("data");
                        Uri imageUri = getImageUri(imageBitmap);
                        if (imageUri != null) {
                            setImageUri(imageUri, currentImageView);
                        }
                    }
                }
            });

    private final ActivityResultLauncher<Intent> selectImageLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Uri imageUri = result.getData().getData();
                    if (imageUri != null) {
                        setImageUri(imageUri, currentImageView);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_fiis);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new MyFIISDbHelper(this);

        setupActionBar();

        Intent intent = getIntent();
        recordId = intent.getStringExtra("ID");

        iis_q1Et = findViewById(R.id.iis_q1Et);
        iis_q2Et = findViewById(R.id.iis_q2Et);
        iis_q3Et = findViewById(R.id.iis_q3Et);
        iis_q4Et = findViewById(R.id.iis_q4Et);
        iis_q5Et = findViewById(R.id.iis_q5Et);
        iis_q6Et = findViewById(R.id.iis_q6Et);
        iis_q7Et = findViewById(R.id.iis_q7Et);
        iis_q8Et = findViewById(R.id.iis_q8Et);
        iis_q9Et = findViewById(R.id.iis_q9Et);
        iis_q10Et = findViewById(R.id.iis_q10Et);
        iis_q11Et = findViewById(R.id.iis_q11Et);
        iis_q12Et = findViewById(R.id.iis_q12Et);
        iis_q13Et = findViewById(R.id.iis_q13Et);
        iis_q14Et = findViewById(R.id.iis_q14Et);
        iis_q15Et = findViewById(R.id.iis_q15Et);
        iis_q16Et = findViewById(R.id.iis_q16Et);
        iis_q17Et = findViewById(R.id.iis_q17Et);
        iis_q18Et = findViewById(R.id.iis_q18Et);
        iis_q19Et = findViewById(R.id.iis_q19Et);
        iis_q20Et = findViewById(R.id.iis_q20Et);
        iis_q21Et = findViewById(R.id.iis_q21Et);
        iis_q22Et = findViewById(R.id.iis_q22Et);
        iis_q23Et = findViewById(R.id.iis_q23Et);
        iis_q24Et = findViewById(R.id.iis_q24Et);
        iis_q25Et = findViewById(R.id.iis_q25Et);
        iis_q26Et = findViewById(R.id.iis_q26Et);
        iis_q27Et = findViewById(R.id.iis_q27Et);
        iis_q28Et = findViewById(R.id.iis_q28Et);
        iis_q29Et = findViewById(R.id.iis_q29Et);
        iis_q30Et = findViewById(R.id.iis_q30Et);
        iis_q31Et = findViewById(R.id.iis_q31Et);
        iis_q32Et = findViewById(R.id.iis_q32Et);
        iis_q33Et = findViewById(R.id.iis_q33Et);
        iis_q34Et = findViewById(R.id.iis_q34Et);
        iis_q35Et = findViewById(R.id.iis_q35Et);
        iis_q36Et = findViewById(R.id.iis_q36Et);
        iis_q37Et = findViewById(R.id.iis_q37Et);
        iis_q38Et = findViewById(R.id.iis_q38Et);
        iis_q39Et = findViewById(R.id.iis_q39Et);
        iis_q40Et = findViewById(R.id.iis_q40Et);
        iis_q41Et = findViewById(R.id.iis_q41Et);
        iis_q42Et = findViewById(R.id.iis_q42Et);
        iis_q42pjEt = findViewById(R.id.iis_q42pjEt);
        iis_q43Et = findViewById(R.id.iis_q43Et);
        iis_q43pjEt = findViewById(R.id.iis_q43pjEt);
        iis_q44Et = findViewById(R.id.iis_q44Et);
        iis_q44pjEt = findViewById(R.id.iis_q44pjEt);
        iis_q45Et = findViewById(R.id.iis_q45Et);
        iis_q45pjEt = findViewById(R.id.iis_q45pjEt);
        iis_q46Et = findViewById(R.id.iis_q46Et);
        iis_q46pjEt = findViewById(R.id.iis_q46pjEt);
        iis_q47Et = findViewById(R.id.iis_q47Et);
        iis_q47pjEt = findViewById(R.id.iis_q47pjEt);
        iis_q48Et = findViewById(R.id.iis_q48Et);
        iis_q48pjEt = findViewById(R.id.iis_q48pjEt);
        iis_q49Et = findViewById(R.id.iis_q49Et);
        iis_q49pjEt = findViewById(R.id.iis_q49pjEt);
        iis_q50Et = findViewById(R.id.iis_q50Et);
        iis_q50pjEt = findViewById(R.id.iis_q50pjEt);
        iis_q51Et = findViewById(R.id.iis_q51Et);
        iis_q51pjEt = findViewById(R.id.iis_q51pjEt);
        iis_q52Et = findViewById(R.id.iis_q52Et);
        iis_q52pjEt = findViewById(R.id.iis_q52pjEt);
        iis_q53Et = findViewById(R.id.iis_q53Et);
        iis_q53pjEt = findViewById(R.id.iis_q53pjEt);
        iis_q54Et = findViewById(R.id.iis_q54Et);
        iis_q54pjEt = findViewById(R.id.iis_q54pjEt);
        iis_q55Et = findViewById(R.id.iis_q55Et);
        iis_q55pjEt = findViewById(R.id.iis_q55pjEt);
        iis_q56Et = findViewById(R.id.iis_q56Et);
        iis_q56pjEt = findViewById(R.id.iis_q56pjEt);
        iis_q57Et = findViewById(R.id.iis_q57Et);
        iis_q57pjEt = findViewById(R.id.iis_q57pjEt);
        iis_q58Et = findViewById(R.id.iis_q58Et);
        iis_q58pjEt = findViewById(R.id.iis_q58pjEt);
        iis_q59Et = findViewById(R.id.iis_q59Et);
        iis_q59pjEt = findViewById(R.id.iis_q59pjEt);
        iis_q60Et = findViewById(R.id.iis_q60Et);
        iis_q60pjEt = findViewById(R.id.iis_q60pjEt);
        iis_q61Et = findViewById(R.id.iis_q61Et);
        iis_q61pjEt = findViewById(R.id.iis_q61pjEt);
        iis_q62Et = findViewById(R.id.iis_q62Et);
        iis_q62pjEt = findViewById(R.id.iis_q62pjEt);
        iis_q63Et = findViewById(R.id.iis_q63Et);
        iis_q63pjEt = findViewById(R.id.iis_q63pjEt);
        iis_q64Et = findViewById(R.id.iis_q64Et);
        iis_q64pjEt = findViewById(R.id.iis_q64pjEt);
        iis_q65Et = findViewById(R.id.iis_q65Et);
        iis_q65pjEt = findViewById(R.id.iis_q65pjEt);
        iis_q66Et = findViewById(R.id.iis_q66Et);
        iis_q66pjEt = findViewById(R.id.iis_q66pjEt);
        iis_q67Et = findViewById(R.id.iis_q67Et);
        iis_q67pjEt = findViewById(R.id.iis_q67pjEt);
        iis_q68Et = findViewById(R.id.iis_q68Et);
        iis_q68pjEt = findViewById(R.id.iis_q68pjEt);
        iis_q69Et = findViewById(R.id.iis_q69Et);
        iis_q69pjEt = findViewById(R.id.iis_q69pjEt);
        iis_q70Et = findViewById(R.id.iis_q70Et);
        iis_q70pjEt = findViewById(R.id.iis_q70pjEt);
        iis_q71Et = findViewById(R.id.iis_q71Et);
        iis_q71pjEt = findViewById(R.id.iis_q71pjEt);
        iis_q72Et = findViewById(R.id.iis_q72Et);
        iis_q72pjEt = findViewById(R.id.iis_q72pjEt);
        iis_q73Et = findViewById(R.id.iis_q73Et);
        iis_q73pjEt = findViewById(R.id.iis_q73pjEt);
        iis_q74Et = findViewById(R.id.iis_q74Et);
        iis_q74pjEt = findViewById(R.id.iis_q74pjEt);
        iis_q75Et = findViewById(R.id.iis_q75Et);
        iis_q75pjEt = findViewById(R.id.iis_q75pjEt);
        iis_q76Et = findViewById(R.id.iis_q76Et);
        iis_q76pjEt = findViewById(R.id.iis_q76pjEt);
        iis_q77Et = findViewById(R.id.iis_q77Et);
        iis_q77pjEt = findViewById(R.id.iis_q77pjEt);
        iis_q78Et = findViewById(R.id.iis_q78Et);
        iis_q78pjEt = findViewById(R.id.iis_q78pjEt);
        iis_q79Et = findViewById(R.id.iis_q79Et);
        iis_q79pjEt = findViewById(R.id.iis_q79pjEt);
        iis_q80Et = findViewById(R.id.iis_q80Et);
        iis_q80pjEt = findViewById(R.id.iis_q80pjEt);
        iis_q81Et = findViewById(R.id.iis_q81Et);
        iis_q81pjEt = findViewById(R.id.iis_q81pjEt);
        iis_q82Et = findViewById(R.id.iis_q82Et);
        iis_q82pjEt = findViewById(R.id.iis_q82pjEt);
        iis_q83Et = findViewById(R.id.iis_q83Et);
        iis_q83pjEt = findViewById(R.id.iis_q83pjEt);
        iis_q84Et = findViewById(R.id.iis_q84Et);
        iis_q84pjEt = findViewById(R.id.iis_q84pjEt);
        iis_q85Et = findViewById(R.id.iis_q85Et);
        iis_q85pjEt = findViewById(R.id.iis_q85pjEt);
        iis_q86Et = findViewById(R.id.iis_q86Et);
        iis_q86pjEt = findViewById(R.id.iis_q86pjEt);
        iis_q87Et = findViewById(R.id.iis_q87Et);
        iis_q87pjEt = findViewById(R.id.iis_q87pjEt);
        iis_q88Et = findViewById(R.id.iis_q88Et);
        iis_q88pjEt = findViewById(R.id.iis_q88pjEt);
        iis_q89Et = findViewById(R.id.iis_q89Et);
        iis_q89pjEt = findViewById(R.id.iis_q89pjEt);
        iis_q90Et = findViewById(R.id.iis_q90Et);
        iis_q90pjEt = findViewById(R.id.iis_q90pjEt);
        iis_q91Et = findViewById(R.id.iis_q91Et);
        iis_q91pjEt = findViewById(R.id.iis_q91pjEt);
        iis_q92Et = findViewById(R.id.iis_q92Et);
        iis_q92pjEt = findViewById(R.id.iis_q92pjEt);
        iis_q93Et = findViewById(R.id.iis_q93Et);
        iis_q93pjEt = findViewById(R.id.iis_q93pjEt);
        iis_q94Et = findViewById(R.id.iis_q94Et);
        iis_q94pjEt = findViewById(R.id.iis_q94pjEt);
        iis_q95Et = findViewById(R.id.iis_q95Et);
        iis_q95pjEt = findViewById(R.id.iis_q95pjEt);
        iis_q96Et = findViewById(R.id.iis_q96Et);
        iis_q96pjEt = findViewById(R.id.iis_q96pjEt);
        iis_q97Et = findViewById(R.id.iis_q97Et);
        iis_q97pjEt = findViewById(R.id.iis_q97pjEt);
        iis_q98Et = findViewById(R.id.iis_q98Et);
        iis_q98pjEt = findViewById(R.id.iis_q98pjEt);
        iis_q99Et = findViewById(R.id.iis_q99Et);
        iis_q99pjEt = findViewById(R.id.iis_q99pjEt);
        iis_q100Et = findViewById(R.id.iis_q100Et);
        iis_q100pjEt = findViewById(R.id.iis_q100pjEt);
        iis_q101Et = findViewById(R.id.iis_q101Et);
        iis_q101pjEt = findViewById(R.id.iis_q101pjEt);
        iis_q102Et = findViewById(R.id.iis_q102Et);
        iis_q102pjEt = findViewById(R.id.iis_q102pjEt);
        iis_q103Et = findViewById(R.id.iis_q103Et);
        iis_q103pjEt = findViewById(R.id.iis_q103pjEt);
        iis_q104Et = findViewById(R.id.iis_q104Et);
        iis_q104pjEt = findViewById(R.id.iis_q104pjEt);
        iis_q105Et = findViewById(R.id.iis_q105Et);
        iis_q105pjEt = findViewById(R.id.iis_q105pjEt);
        iis_q106Et = findViewById(R.id.iis_q106Et);
        iis_q106pjEt = findViewById(R.id.iis_q106pjEt);
        iis_q107Et = findViewById(R.id.iis_q107Et);
        iis_q107pjEt = findViewById(R.id.iis_q107pjEt);
        iis_q108Et = findViewById(R.id.iis_q108Et);
        iis_q108pjEt = findViewById(R.id.iis_q108pjEt);
        iis_q109Et = findViewById(R.id.iis_q109Et);
        iis_q109pjEt = findViewById(R.id.iis_q109pjEt);
        iis_q110Et = findViewById(R.id.iis_q110Et);
        iis_q110pjEt = findViewById(R.id.iis_q110pjEt);
        iis_q111Et = findViewById(R.id.iis_q111Et);
        iis_q111pjEt = findViewById(R.id.iis_q111pjEt);
        iis_q112Et = findViewById(R.id.iis_q112Et);
        iis_q112pjEt = findViewById(R.id.iis_q112pjEt);
        iis_q113Et = findViewById(R.id.iis_q113Et);
        iis_q113pjEt = findViewById(R.id.iis_q113pjEt);
        iis_q114Et = findViewById(R.id.iis_q114Et);
        iis_q114pjEt = findViewById(R.id.iis_q114pjEt);
        iis_q115Et = findViewById(R.id.iis_q115Et);
        iis_q115pjEt = findViewById(R.id.iis_q115pjEt);
        iis_q116Et = findViewById(R.id.iis_q116Et);
        iis_q116pjEt = findViewById(R.id.iis_q116pjEt);
        iis_q117Et = findViewById(R.id.iis_q117Et);
        iis_q117pjEt = findViewById(R.id.iis_q117pjEt);
        iis_q118Et = findViewById(R.id.iis_q118Et);
        iis_q118pjEt = findViewById(R.id.iis_q118pjEt);
        iis_q119Et = findViewById(R.id.iis_q119Et);
        profileIv = findViewById(R.id.iiuprofileIv);

        updateBtn = findViewById(R.id.fiisUpdateSaveBtn);

        iis_q1Et.setText(intent.getStringExtra("QUESTIONFIIS1"));
        iis_q2Et.setText(intent.getStringExtra("QUESTIONFIIS2"));
        iis_q3Et.setText(intent.getStringExtra("QUESTIONFIIS3"));
        iis_q4Et.setText(intent.getStringExtra("QUESTIONFIIS4"));
        iis_q5Et.setText(intent.getStringExtra("QUESTIONFIIS5"));
        iis_q6Et.setText(intent.getStringExtra("QUESTIONFIIS6"));
        iis_q7Et.setText(intent.getStringExtra("QUESTIONFIIS7"));
        iis_q8Et.setText(intent.getStringExtra("QUESTIONFIIS8"));
        iis_q9Et.setText(intent.getStringExtra("QUESTIONFIIS9"));
        iis_q10Et.setText(intent.getStringExtra("QUESTIONFIIS10"));
        iis_q11Et.setText(intent.getStringExtra("QUESTIONFIIS11"));
        iis_q12Et.setText(intent.getStringExtra("QUESTIONFIIS12"));
        iis_q13Et.setText(intent.getStringExtra("QUESTIONFIIS13"));
        iis_q14Et.setText(intent.getStringExtra("QUESTIONFIIS14"));
        iis_q15Et.setText(intent.getStringExtra("QUESTIONFIIS15"));
        iis_q16Et.setText(intent.getStringExtra("QUESTIONFIIS16"));
        iis_q17Et.setText(intent.getStringExtra("QUESTIONFIIS17"));
        iis_q18Et.setText(intent.getStringExtra("QUESTIONFIIS18"));
        iis_q19Et.setText(intent.getStringExtra("QUESTIONFIIS19"));
        iis_q20Et.setText(intent.getStringExtra("QUESTIONFIIS20"));
        iis_q21Et.setText(intent.getStringExtra("QUESTIONFIIS21"));
        iis_q22Et.setText(intent.getStringExtra("QUESTIONFIIS22"));
        iis_q23Et.setText(intent.getStringExtra("QUESTIONFIIS23"));
        iis_q24Et.setText(intent.getStringExtra("QUESTIONFIIS24"));
        iis_q25Et.setText(intent.getStringExtra("QUESTIONFIIS25"));
        iis_q26Et.setText(intent.getStringExtra("QUESTIONFIIS26"));
        iis_q27Et.setText(intent.getStringExtra("QUESTIONFIIS27"));
        iis_q28Et.setText(intent.getStringExtra("QUESTIONFIIS28"));
        iis_q29Et.setText(intent.getStringExtra("QUESTIONFIIS29"));
        iis_q30Et.setText(intent.getStringExtra("QUESTIONFIIS30"));
        iis_q31Et.setText(intent.getStringExtra("QUESTIONFIIS31"));
        iis_q32Et.setText(intent.getStringExtra("QUESTIONFIIS32"));
        iis_q33Et.setText(intent.getStringExtra("QUESTIONFIIS33"));
        iis_q34Et.setText(intent.getStringExtra("QUESTIONFIIS34"));
        iis_q35Et.setText(intent.getStringExtra("QUESTIONFIIS35"));
        iis_q36Et.setText(intent.getStringExtra("QUESTIONFIIS36"));
        iis_q37Et.setText(intent.getStringExtra("QUESTIONFIIS37"));
        iis_q38Et.setText(intent.getStringExtra("QUESTIONFIIS38"));
        iis_q39Et.setText(intent.getStringExtra("QUESTIONFIIS39"));
        iis_q40Et.setText(intent.getStringExtra("QUESTIONFIIS40"));
        iis_q41Et.setText(intent.getStringExtra("QUESTIONFIIS41"));
        iis_q42Et.setText(intent.getStringExtra("QUESTIONFIIS42"));
        iis_q42pjEt.setText(intent.getStringExtra("QUESTIONFIIS43"));
        iis_q43Et.setText(intent.getStringExtra("QUESTIONFIIS44"));
        iis_q43pjEt.setText(intent.getStringExtra("QUESTIONFIIS45"));
        iis_q44Et.setText(intent.getStringExtra("QUESTIONFIIS46"));
        iis_q44pjEt.setText(intent.getStringExtra("QUESTIONFIIS47"));
        iis_q45Et.setText(intent.getStringExtra("QUESTIONFIIS48"));
        iis_q45pjEt.setText(intent.getStringExtra("QUESTIONFIIS49"));
        iis_q46Et.setText(intent.getStringExtra("QUESTIONFIIS50"));
        iis_q46pjEt.setText(intent.getStringExtra("QUESTIONFIIS51"));
        iis_q47Et.setText(intent.getStringExtra("QUESTIONFIIS52"));
        iis_q47pjEt.setText(intent.getStringExtra("QUESTIONFIIS53"));
        iis_q48Et.setText(intent.getStringExtra("QUESTIONFIIS54"));
        iis_q48pjEt.setText(intent.getStringExtra("QUESTIONFIIS55"));
        iis_q49Et.setText(intent.getStringExtra("QUESTIONFIIS56"));
        iis_q49pjEt.setText(intent.getStringExtra("QUESTIONFIIS57"));
        iis_q50Et.setText(intent.getStringExtra("QUESTIONFIIS58"));
        iis_q50pjEt.setText(intent.getStringExtra("QUESTIONFIIS59"));
        iis_q51Et.setText(intent.getStringExtra("QUESTIONFIIS60"));
        iis_q51pjEt.setText(intent.getStringExtra("QUESTIONFIIS61"));
        iis_q52Et.setText(intent.getStringExtra("QUESTIONFIIS62"));
        iis_q52pjEt.setText(intent.getStringExtra("QUESTIONFIIS63"));
        iis_q53Et.setText(intent.getStringExtra("QUESTIONFIIS64"));
        //iis_q53pjEt.setText(intent.getStringExtra("QUESTIONFIIS65"));
        iis_q54Et.setText(intent.getStringExtra("QUESTIONFIIS66"));
        //iis_q54pjEt.setText(intent.getStringExtra("QUESTIONFIIS67"));
        iis_q55Et.setText(intent.getStringExtra("QUESTIONFIIS68"));
        iis_q55pjEt.setText(intent.getStringExtra("QUESTIONFIIS69"));
        iis_q56Et.setText(intent.getStringExtra("QUESTIONFIIS70"));
        iis_q56pjEt.setText(intent.getStringExtra("QUESTIONFIIS71"));
        iis_q57Et.setText(intent.getStringExtra("QUESTIONFIIS72"));
        iis_q57pjEt.setText(intent.getStringExtra("QUESTIONFIIS73"));
        iis_q58Et.setText(intent.getStringExtra("QUESTIONFIIS74"));
        iis_q58pjEt.setText(intent.getStringExtra("QUESTIONFIIS75"));
        iis_q59Et.setText(intent.getStringExtra("QUESTIONFIIS76"));
        iis_q59pjEt.setText(intent.getStringExtra("QUESTIONFIIS77"));
        iis_q60Et.setText(intent.getStringExtra("QUESTIONFIIS78"));
        iis_q60pjEt.setText(intent.getStringExtra("QUESTIONFIIS79"));
        iis_q61Et.setText(intent.getStringExtra("QUESTIONFIIS80"));
        iis_q61pjEt.setText(intent.getStringExtra("QUESTIONFIIS81"));
        iis_q62Et.setText(intent.getStringExtra("QUESTIONFIIS82"));
        iis_q62pjEt.setText(intent.getStringExtra("QUESTIONFIIS83"));
        iis_q63Et.setText(intent.getStringExtra("QUESTIONFIIS84"));
        iis_q63pjEt.setText(intent.getStringExtra("QUESTIONFIIS85"));
        iis_q64Et.setText(intent.getStringExtra("QUESTIONFIIS86"));
        iis_q64pjEt.setText(intent.getStringExtra("QUESTIONFIIS87"));
        iis_q65Et.setText(intent.getStringExtra("QUESTIONFIIS88"));
        iis_q65pjEt.setText(intent.getStringExtra("QUESTIONFIIS89"));
        iis_q66Et.setText(intent.getStringExtra("QUESTIONFIIS90"));
        iis_q66pjEt.setText(intent.getStringExtra("QUESTIONFIIS91"));
        iis_q67Et.setText(intent.getStringExtra("QUESTIONFIIS92"));
        iis_q67pjEt.setText(intent.getStringExtra("QUESTIONFIIS93"));
        iis_q68Et.setText(intent.getStringExtra("QUESTIONFIIS94"));
        iis_q68pjEt.setText(intent.getStringExtra("QUESTIONFIIS95"));
        iis_q69Et.setText(intent.getStringExtra("QUESTIONFIIS96"));
        iis_q69pjEt.setText(intent.getStringExtra("QUESTIONFIIS97"));
        iis_q70Et.setText(intent.getStringExtra("QUESTIONFIIS98"));
        iis_q70pjEt.setText(intent.getStringExtra("QUESTIONFIIS99"));
        iis_q71Et.setText(intent.getStringExtra("QUESTIONFIIS100"));
        iis_q71pjEt.setText(intent.getStringExtra("QUESTIONFIIS101"));
        iis_q72Et.setText(intent.getStringExtra("QUESTIONFIIS102"));
        iis_q72pjEt.setText(intent.getStringExtra("QUESTIONFIIS103"));
        iis_q73Et.setText(intent.getStringExtra("QUESTIONFIIS104"));
        iis_q73pjEt.setText(intent.getStringExtra("QUESTIONFIIS105"));
        iis_q74Et.setText(intent.getStringExtra("QUESTIONFIIS106"));
        iis_q74pjEt.setText(intent.getStringExtra("QUESTIONFIIS107"));
        iis_q75Et.setText(intent.getStringExtra("QUESTIONFIIS108"));
        iis_q75pjEt.setText(intent.getStringExtra("QUESTIONFIIS109"));
        iis_q76Et.setText(intent.getStringExtra("QUESTIONFIIS110"));
        iis_q76pjEt.setText(intent.getStringExtra("QUESTIONFIIS111"));
        iis_q77Et.setText(intent.getStringExtra("QUESTIONFIIS112"));
        iis_q77pjEt.setText(intent.getStringExtra("QUESTIONFIIS113"));
        iis_q78Et.setText(intent.getStringExtra("QUESTIONFIIS114"));
        iis_q78pjEt.setText(intent.getStringExtra("QUESTIONFIIS115"));
        iis_q79Et.setText(intent.getStringExtra("QUESTIONFIIS116"));
        iis_q79pjEt.setText(intent.getStringExtra("QUESTIONFIIS117"));
        iis_q80Et.setText(intent.getStringExtra("QUESTIONFIIS118"));
        iis_q80pjEt.setText(intent.getStringExtra("QUESTIONFIIS119"));
        iis_q81Et.setText(intent.getStringExtra("QUESTIONFIIS120"));
        iis_q81pjEt.setText(intent.getStringExtra("QUESTIONFIIS121"));
        iis_q82Et.setText(intent.getStringExtra("QUESTIONFIIS122"));
        iis_q82pjEt.setText(intent.getStringExtra("QUESTIONFIIS123"));
        iis_q83Et.setText(intent.getStringExtra("QUESTIONFIIS124"));
        iis_q83pjEt.setText(intent.getStringExtra("QUESTIONFIIS125"));
        iis_q84Et.setText(intent.getStringExtra("QUESTIONFIIS126"));
        iis_q84pjEt.setText(intent.getStringExtra("QUESTIONFIIS127"));
        iis_q85Et.setText(intent.getStringExtra("QUESTIONFIIS128"));
        iis_q85pjEt.setText(intent.getStringExtra("QUESTIONFIIS129"));
        iis_q86Et.setText(intent.getStringExtra("QUESTIONFIIS130"));
        iis_q86pjEt.setText(intent.getStringExtra("QUESTIONFIIS131"));
        iis_q87Et.setText(intent.getStringExtra("QUESTIONFIIS132"));
        iis_q87pjEt.setText(intent.getStringExtra("QUESTIONFIIS133"));
        iis_q88Et.setText(intent.getStringExtra("QUESTIONFIIS134"));
        iis_q88pjEt.setText(intent.getStringExtra("QUESTIONFIIS135"));
        iis_q89Et.setText(intent.getStringExtra("QUESTIONFIIS136"));
        iis_q89pjEt.setText(intent.getStringExtra("QUESTIONFIIS137"));
        iis_q90Et.setText(intent.getStringExtra("QUESTIONFIIS138"));
        iis_q90pjEt.setText(intent.getStringExtra("QUESTIONFIIS139"));
        iis_q91Et.setText(intent.getStringExtra("QUESTIONFIIS140"));
        iis_q91pjEt.setText(intent.getStringExtra("QUESTIONFIIS141"));
        iis_q92Et.setText(intent.getStringExtra("QUESTIONFIIS142"));
        iis_q92pjEt.setText(intent.getStringExtra("QUESTIONFIIS143"));
        iis_q93Et.setText(intent.getStringExtra("QUESTIONFIIS144"));
        iis_q93pjEt.setText(intent.getStringExtra("QUESTIONFIIS145"));
        iis_q94Et.setText(intent.getStringExtra("QUESTIONFIIS146"));
        iis_q94pjEt.setText(intent.getStringExtra("QUESTIONFIIS147"));
        iis_q95Et.setText(intent.getStringExtra("QUESTIONFIIS148"));
        iis_q95pjEt.setText(intent.getStringExtra("QUESTIONFIIS149"));
        iis_q96Et.setText(intent.getStringExtra("QUESTIONFIIS150"));
        iis_q96pjEt.setText(intent.getStringExtra("QUESTIONFIIS151"));
        iis_q97Et.setText(intent.getStringExtra("QUESTIONFIIS152"));
        iis_q97pjEt.setText(intent.getStringExtra("QUESTIONFIIS153"));
        iis_q98Et.setText(intent.getStringExtra("QUESTIONFIIS154"));
        iis_q98pjEt.setText(intent.getStringExtra("QUESTIONFIIS155"));
        iis_q99Et.setText(intent.getStringExtra("QUESTIONFIIS156"));
        iis_q99pjEt.setText(intent.getStringExtra("QUESTIONFIIS157"));
        iis_q100Et.setText(intent.getStringExtra("QUESTIONFIIS158"));
        iis_q100pjEt.setText(intent.getStringExtra("QUESTIONFIIS159"));
        iis_q101Et.setText(intent.getStringExtra("QUESTIONFIIS160"));
        iis_q101pjEt.setText(intent.getStringExtra("QUESTIONFIIS161"));
        iis_q102Et.setText(intent.getStringExtra("QUESTIONFIIS162"));
        iis_q102pjEt.setText(intent.getStringExtra("QUESTIONFIIS163"));
        iis_q103Et.setText(intent.getStringExtra("QUESTIONFIIS164"));
        iis_q103pjEt.setText(intent.getStringExtra("QUESTIONFIIS165"));
        iis_q104Et.setText(intent.getStringExtra("QUESTIONFIIS166"));
        iis_q104pjEt.setText(intent.getStringExtra("QUESTIONFIIS167"));
        iis_q105Et.setText(intent.getStringExtra("QUESTIONFIIS168"));
        iis_q105pjEt.setText(intent.getStringExtra("QUESTIONFIIS169"));
        iis_q106Et.setText(intent.getStringExtra("QUESTIONFIIS170"));
        iis_q106pjEt.setText(intent.getStringExtra("QUESTIONFIIS171"));
        iis_q107Et.setText(intent.getStringExtra("QUESTIONFIIS172"));
        iis_q107pjEt.setText(intent.getStringExtra("QUESTIONFIIS173"));
        iis_q108Et.setText(intent.getStringExtra("QUESTIONFIIS174"));
        iis_q108pjEt.setText(intent.getStringExtra("QUESTIONFIIS175"));
        iis_q109Et.setText(intent.getStringExtra("QUESTIONFIIS176"));
        iis_q109pjEt.setText(intent.getStringExtra("QUESTIONFIIS177"));
        iis_q110Et.setText(intent.getStringExtra("QUESTIONFIIS178"));
        iis_q110pjEt.setText(intent.getStringExtra("QUESTIONFIIS179"));
        iis_q111Et.setText(intent.getStringExtra("QUESTIONFIIS180"));
        iis_q111pjEt.setText(intent.getStringExtra("QUESTIONFIIS181"));
        iis_q112Et.setText(intent.getStringExtra("QUESTIONFIIS182"));
        iis_q112pjEt.setText(intent.getStringExtra("QUESTIONFIIS183"));
        iis_q113Et.setText(intent.getStringExtra("QUESTIONFIIS184"));
        iis_q113pjEt.setText(intent.getStringExtra("QUESTIONFIIS185"));
        iis_q114Et.setText(intent.getStringExtra("QUESTIONFIIS186"));
        iis_q114pjEt.setText(intent.getStringExtra("QUESTIONFIIS187"));
        iis_q115Et.setText(intent.getStringExtra("QUESTIONFIIS188"));
        iis_q115pjEt.setText(intent.getStringExtra("QUESTIONFIIS189"));
        iis_q116Et.setText(intent.getStringExtra("QUESTIONFIIS190"));
        iis_q116pjEt.setText(intent.getStringExtra("QUESTIONFIIS191"));
        iis_q117Et.setText(intent.getStringExtra("QUESTIONFIIS192"));
        iis_q117pjEt.setText(intent.getStringExtra("QUESTIONFIIS193"));
        iis_q118Et.setText(intent.getStringExtra("QUESTIONFIIS194"));
        iis_q118pjEt.setText(intent.getStringExtra("QUESTIONFIIS195"));
        iis_q119Et.setText(intent.getStringExtra("QUESTIONFIIS196"));


//        String selectedGender = intent.getStringExtra("QUESTION2");
//
//        // Initialize gender options
//        String[] genderOptions = new String[]{"Male", "Female"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, genderOptions);
//        q2Et.setAdapter(adapter);
//        q2Et.setText(selectedGender, false); // Set the selected gender without triggering the dropdown

        profileImagePath = intent.getStringExtra("PROFILE_IMAGE");

        loadImage(profileImagePath, profileIv);

        profileIv.setOnClickListener(v -> showImagePickDialog(profileIv));

        updateBtn.setOnClickListener(v -> updateRecord());

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Update Inspection Record");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void showImagePickDialog(ImageView imageView) {
        currentImageView = imageView;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick Image From")
                .setItems(new CharSequence[]{"Camera", "Gallery"}, (dialog, which) -> {
                    if (which == 0) {
                        if (checkPermissions(Manifest.permission.CAMERA)) {
                            pickFromCamera();
                        } else {
                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
                        }
                    } else {
                        if (checkPermissions(Manifest.permission.READ_MEDIA_IMAGES)) {
                            pickFromGallery();
                        } else {
                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_IMAGES}, STORAGE_REQUEST_CODE);
                        }
                    }
                })
                .show();
    }

    private boolean checkPermissions(String permission) {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
    }

    private void pickFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        selectImageLauncher.launch(intent);
    }

    private void pickFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        captureImageLauncher.launch(intent);
    }

    private void setImageUri(Uri uri, ImageView imageView) {
        if (uri != null && imageView != null) {
            Picasso.get().load(uri).into(imageView);
            saveImageUri(imageView, uri);
        }
    }

    private void saveImageUri(ImageView imageView, Uri uri) {
        String filePath = saveImageFile(uri);
        if (filePath != null) {
            if (imageView == profileIv) {
                profileIvUri = uri;
                profileImagePath = filePath;
            } else if (imageView == farmerImageIv) {
                farmerImageIvUri = uri;
                farmerImagePath = filePath;
            } else if (imageView == agentSignImageIv) {
                agentSignImageIvUri = uri;
                agentSignImagePath = filePath;
            }
        } else {
            Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
        }
    }

    private String saveImageFile(Uri uri) {
        try {
            File directory = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "farmer_photos");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            String imageName = "IMG_" + System.currentTimeMillis() + ".jpg";
            File file = new File(directory, imageName);
            try (InputStream inputStream = getContentResolver().openInputStream(uri);
                 FileOutputStream outputStream = new FileOutputStream(file)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            }
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Uri getImageUri(Bitmap bitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "TempImage", null);
        return Uri.parse(path);
    }

    private void loadImage(String imagePath, ImageView imageView) {
        if (imagePath != null && !imagePath.equals("null")) {
            Picasso.get().load(new File(imagePath)).into(imageView);
        } else {
            imageView.setImageResource(R.drawable.ic_person_black);
        }
    }

    private void updateRecord() {
        //String question1 = q1Et.getText().toString().trim();
        String questionfiis1 = iis_q1Et.getText().toString().trim();
        String questionfiis2 = iis_q2Et.getText().toString().trim();
        String questionfiis3 = iis_q3Et.getText().toString().trim();
        String questionfiis4 = iis_q4Et.getText().toString().trim();
        String questionfiis5 = iis_q5Et.getText().toString().trim();
        String questionfiis6 = iis_q6Et.getText().toString().trim();
        String questionfiis7 = iis_q7Et.getText().toString().trim();
        String questionfiis8 = iis_q8Et.getText().toString().trim();
        String questionfiis9 = iis_q9Et.getText().toString().trim();
        String questionfiis10 = iis_q10Et.getText().toString().trim();
        String questionfiis11 = iis_q11Et.getText().toString().trim();
        String questionfiis12 = iis_q12Et.getText().toString().trim();
        String questionfiis13 = iis_q13Et.getText().toString().trim();
        String questionfiis14 = iis_q14Et.getText().toString().trim();
        String questionfiis15 = iis_q15Et.getText().toString().trim();
        String questionfiis16 = iis_q16Et.getText().toString().trim();
        String questionfiis17 = iis_q17Et.getText().toString().trim();
        String questionfiis18 = iis_q18Et.getText().toString().trim();
        String questionfiis19 = iis_q19Et.getText().toString().trim();
        String questionfiis20 = iis_q20Et.getText().toString().trim();
        String questionfiis21 = iis_q21Et.getText().toString().trim();
        String questionfiis22 = iis_q22Et.getText().toString().trim();
        String questionfiis23 = iis_q23Et.getText().toString().trim();
        String questionfiis24 = iis_q24Et.getText().toString().trim();
        String questionfiis25 = iis_q25Et.getText().toString().trim();
        String questionfiis26 = iis_q26Et.getText().toString().trim();
        String questionfiis27 = iis_q27Et.getText().toString().trim();
        String questionfiis28 = iis_q28Et.getText().toString().trim();
        String questionfiis29 = iis_q29Et.getText().toString().trim();
        String questionfiis30 = iis_q30Et.getText().toString().trim();
        String questionfiis31 = iis_q31Et.getText().toString().trim();
        String questionfiis32 = iis_q32Et.getText().toString().trim();
        String questionfiis33 = iis_q33Et.getText().toString().trim();
        String questionfiis34 = iis_q34Et.getText().toString().trim();
        String questionfiis35 = iis_q35Et.getText().toString().trim();
        String questionfiis36 = iis_q36Et.getText().toString().trim();
        String questionfiis37 = iis_q37Et.getText().toString().trim();
        String questionfiis38 = iis_q38Et.getText().toString().trim();
        String questionfiis39 = iis_q39Et.getText().toString().trim();
        String questionfiis40 = iis_q40Et.getText().toString().trim();
        String questionfiis41 = iis_q41Et.getText().toString().trim();
        String questionfiis42 = iis_q42Et.getText().toString().trim();
        String questionfiis43 = iis_q42pjEt.getText().toString().trim();
        String questionfiis44 = iis_q43Et.getText().toString().trim();
        String questionfiis45 = iis_q43pjEt.getText().toString().trim();
        String questionfiis46 = iis_q44Et.getText().toString().trim();
        String questionfiis47 = iis_q44pjEt.getText().toString().trim();
        String questionfiis48 = iis_q45Et.getText().toString().trim();
        String questionfiis49 = iis_q45pjEt.getText().toString().trim();
        String questionfiis50 = iis_q46Et.getText().toString().trim();
        String questionfiis51 = iis_q46pjEt.getText().toString().trim();
        String questionfiis52 = iis_q47Et.getText().toString().trim();
        String questionfiis53 = iis_q47pjEt.getText().toString().trim();
        String questionfiis54 = iis_q48Et.getText().toString().trim();
        String questionfiis55 = iis_q48pjEt.getText().toString().trim();
        String questionfiis56 = iis_q49Et.getText().toString().trim();
        String questionfiis57 = iis_q49pjEt.getText().toString().trim();
        String questionfiis58 = iis_q50Et.getText().toString().trim();
        String questionfiis59 = iis_q50pjEt.getText().toString().trim();
        String questionfiis60 = iis_q51Et.getText().toString().trim();
        String questionfiis61 = iis_q51pjEt.getText().toString().trim();
        String questionfiis62 = iis_q52Et.getText().toString().trim();
        String questionfiis63 = iis_q52pjEt.getText().toString().trim();
        String questionfiis64 = iis_q53Et.getText().toString().trim();
        String questionfiis65 = iis_q53pjEt.getText().toString().trim();
        String questionfiis66 = iis_q54Et.getText().toString().trim();
        String questionfiis67 = iis_q54pjEt.getText().toString().trim();
        String questionfiis68 = iis_q55Et.getText().toString().trim();
        String questionfiis69 = iis_q55pjEt.getText().toString().trim();
        String questionfiis70 = iis_q56Et.getText().toString().trim();
        String questionfiis71 = iis_q56pjEt.getText().toString().trim();
        String questionfiis72 = iis_q57Et.getText().toString().trim();
        String questionfiis73 = iis_q57pjEt.getText().toString().trim();
        String questionfiis74 = iis_q58Et.getText().toString().trim();
        String questionfiis75 = iis_q58pjEt.getText().toString().trim();
        String questionfiis76 = iis_q59Et.getText().toString().trim();
        String questionfiis77 = iis_q59pjEt.getText().toString().trim();
        String questionfiis78 = iis_q60Et.getText().toString().trim();
        String questionfiis79 = iis_q60pjEt.getText().toString().trim();
        String questionfiis80 = iis_q61Et.getText().toString().trim();
        String questionfiis81 = iis_q61pjEt.getText().toString().trim();
        String questionfiis82 = iis_q62Et.getText().toString().trim();
        String questionfiis83 = iis_q62pjEt.getText().toString().trim();
        String questionfiis84 = iis_q63Et.getText().toString().trim();
        String questionfiis85 = iis_q63pjEt.getText().toString().trim();
        String questionfiis86 = iis_q64Et.getText().toString().trim();
        String questionfiis87 = iis_q64pjEt.getText().toString().trim();
        String questionfiis88 = iis_q65Et.getText().toString().trim();
        String questionfiis89 = iis_q65pjEt.getText().toString().trim();
        String questionfiis90 = iis_q66Et.getText().toString().trim();
        String questionfiis91 = iis_q66pjEt.getText().toString().trim();
        String questionfiis92 = iis_q67Et.getText().toString().trim();
        String questionfiis93 = iis_q67pjEt.getText().toString().trim();
        String questionfiis94 = iis_q68Et.getText().toString().trim();
        String questionfiis95 = iis_q68pjEt.getText().toString().trim();
        String questionfiis96 = iis_q69Et.getText().toString().trim();
        String questionfiis97 = iis_q69pjEt.getText().toString().trim();
        String questionfiis98 = iis_q70Et.getText().toString().trim();
        String questionfiis99 = iis_q70pjEt.getText().toString().trim();
        String questionfiis100 = iis_q71Et.getText().toString().trim();
        String questionfiis101 = iis_q71pjEt.getText().toString().trim();
        String questionfiis102 = iis_q72Et.getText().toString().trim();
        String questionfiis103 = iis_q72pjEt.getText().toString().trim();
        String questionfiis104 = iis_q73Et.getText().toString().trim();
        String questionfiis105 = iis_q73pjEt.getText().toString().trim();
        String questionfiis106 = iis_q74Et.getText().toString().trim();
        String questionfiis107 = iis_q74pjEt.getText().toString().trim();
        String questionfiis108 = iis_q75Et.getText().toString().trim();
        String questionfiis109 = iis_q75pjEt.getText().toString().trim();
        String questionfiis110 = iis_q76Et.getText().toString().trim();
        String questionfiis111 = iis_q76pjEt.getText().toString().trim();
        String questionfiis112 = iis_q77Et.getText().toString().trim();
        String questionfiis113 = iis_q77pjEt.getText().toString().trim();
        String questionfiis114 = iis_q78Et.getText().toString().trim();
        String questionfiis115 = iis_q78pjEt.getText().toString().trim();
        String questionfiis116 = iis_q79Et.getText().toString().trim();
        String questionfiis117 = iis_q79pjEt.getText().toString().trim();
        String questionfiis118 = iis_q80Et.getText().toString().trim();
        String questionfiis119 = iis_q80pjEt.getText().toString().trim();
        String questionfiis120 = iis_q81Et.getText().toString().trim();
        String questionfiis121 = iis_q81pjEt.getText().toString().trim();
        String questionfiis122 = iis_q82Et.getText().toString().trim();
        String questionfiis123 = iis_q82pjEt.getText().toString().trim();
        String questionfiis124 = iis_q83Et.getText().toString().trim();
        String questionfiis125 = iis_q83pjEt.getText().toString().trim();
        String questionfiis126 = iis_q84Et.getText().toString().trim();
        String questionfiis127 = iis_q84pjEt.getText().toString().trim();
        String questionfiis128 = iis_q85Et.getText().toString().trim();
        String questionfiis129 = iis_q85pjEt.getText().toString().trim();
        String questionfiis130 = iis_q86Et.getText().toString().trim();
        String questionfiis131 = iis_q86pjEt.getText().toString().trim();
        String questionfiis132 = iis_q87Et.getText().toString().trim();
        String questionfiis133 = iis_q87pjEt.getText().toString().trim();
        String questionfiis134 = iis_q88Et.getText().toString().trim();
        String questionfiis135 = iis_q88pjEt.getText().toString().trim();
        String questionfiis136 = iis_q89Et.getText().toString().trim();
        String questionfiis137 = iis_q89pjEt.getText().toString().trim();
        String questionfiis138 = iis_q90Et.getText().toString().trim();
        String questionfiis139 = iis_q90pjEt.getText().toString().trim();
        String questionfiis140 = iis_q91Et.getText().toString().trim();
        String questionfiis141 = iis_q91pjEt.getText().toString().trim();
        String questionfiis142 = iis_q92Et.getText().toString().trim();
        String questionfiis143 = iis_q92pjEt.getText().toString().trim();
        String questionfiis144 = iis_q93Et.getText().toString().trim();
        String questionfiis145 = iis_q93pjEt.getText().toString().trim();
        String questionfiis146 = iis_q94Et.getText().toString().trim();
        String questionfiis147 = iis_q94pjEt.getText().toString().trim();
        String questionfiis148 = iis_q95Et.getText().toString().trim();
        String questionfiis149 = iis_q95pjEt.getText().toString().trim();
        String questionfiis150 = iis_q96Et.getText().toString().trim();
        String questionfiis151 = iis_q96pjEt.getText().toString().trim();
        String questionfiis152 = iis_q97Et.getText().toString().trim();
        String questionfiis153 = iis_q97pjEt.getText().toString().trim();
        String questionfiis154 = iis_q98Et.getText().toString().trim();
        String questionfiis155 = iis_q98pjEt.getText().toString().trim();
        String questionfiis156 = iis_q99Et.getText().toString().trim();
        String questionfiis157 = iis_q99pjEt.getText().toString().trim();
        String questionfiis158 = iis_q100Et.getText().toString().trim();
        String questionfiis159 = iis_q100pjEt.getText().toString().trim();
        String questionfiis160 = iis_q101Et.getText().toString().trim();
        String questionfiis161 = iis_q101pjEt.getText().toString().trim();
        String questionfiis162 = iis_q102Et.getText().toString().trim();
        String questionfiis163 = iis_q102pjEt.getText().toString().trim();
        String questionfiis164 = iis_q103Et.getText().toString().trim();
        String questionfiis165 = iis_q103pjEt.getText().toString().trim();
        String questionfiis166 = iis_q104Et.getText().toString().trim();
        String questionfiis167 = iis_q104pjEt.getText().toString().trim();
        String questionfiis168 = iis_q105Et.getText().toString().trim();
        String questionfiis169 = iis_q105pjEt.getText().toString().trim();
        String questionfiis170 = iis_q106Et.getText().toString().trim();
        String questionfiis171 = iis_q106pjEt.getText().toString().trim();
        String questionfiis172 = iis_q107Et.getText().toString().trim();
        String questionfiis173 = iis_q107pjEt.getText().toString().trim();
        String questionfiis174 = iis_q108Et.getText().toString().trim();
        String questionfiis175 = iis_q108pjEt.getText().toString().trim();
        String questionfiis176 = iis_q109Et.getText().toString().trim();
        String questionfiis177 = iis_q109pjEt.getText().toString().trim();
        String questionfiis178 = iis_q110Et.getText().toString().trim();
        String questionfiis179 = iis_q110pjEt.getText().toString().trim();
        String questionfiis180 = iis_q111Et.getText().toString().trim();
        String questionfiis181 = iis_q111pjEt.getText().toString().trim();
        String questionfiis182 = iis_q112Et.getText().toString().trim();
        String questionfiis183 = iis_q112pjEt.getText().toString().trim();
        String questionfiis184 = iis_q113Et.getText().toString().trim();
        String questionfiis185 = iis_q113pjEt.getText().toString().trim();
        String questionfiis186 = iis_q114Et.getText().toString().trim();
        String questionfiis187 = iis_q114pjEt.getText().toString().trim();
        String questionfiis188 = iis_q115Et.getText().toString().trim();
        String questionfiis189 = iis_q115pjEt.getText().toString().trim();
        String questionfiis190 = iis_q116Et.getText().toString().trim();
        String questionfiis191 = iis_q116pjEt.getText().toString().trim();
        String questionfiis192 = iis_q117Et.getText().toString().trim();
        String questionfiis193 = iis_q117pjEt.getText().toString().trim();
        String questionfiis194 = iis_q118Et.getText().toString().trim();
        String questionfiis195 = iis_q118pjEt.getText().toString().trim();
        String questionfiis196 = iis_q119Et.getText().toString().trim();

        if (questionfiis1.isEmpty() || questionfiis6.isEmpty()) {
            Toast.makeText(this, "Question1 and Question2 required", Toast.LENGTH_SHORT).show();
            return;
        }

        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        dbHelper.updateRecord(recordId, questionfiis1, questionfiis2, questionfiis3, questionfiis4, questionfiis5, questionfiis6, questionfiis7, questionfiis8, questionfiis9, questionfiis10, questionfiis11, questionfiis12, questionfiis13, questionfiis14, questionfiis15, questionfiis16, questionfiis17, questionfiis18, questionfiis19, questionfiis20, questionfiis21, questionfiis22, questionfiis23, questionfiis24, questionfiis25, questionfiis26, questionfiis27, questionfiis28, questionfiis29, questionfiis30, questionfiis31, questionfiis32, questionfiis33, questionfiis34, questionfiis35, questionfiis36, questionfiis37, questionfiis38, questionfiis39, questionfiis40, questionfiis41, questionfiis42, questionfiis43, questionfiis44, questionfiis45, questionfiis46, questionfiis47, questionfiis48, questionfiis49, questionfiis50, questionfiis51, questionfiis52, questionfiis53, questionfiis54, questionfiis55, questionfiis56, questionfiis57, questionfiis58, questionfiis59, questionfiis60, questionfiis61, questionfiis62, questionfiis63, questionfiis64, questionfiis65, questionfiis66, questionfiis67, questionfiis68, questionfiis69, questionfiis70, questionfiis71, questionfiis72, questionfiis73, questionfiis74, questionfiis75, questionfiis76, questionfiis77, questionfiis78, questionfiis79, questionfiis80, questionfiis81, questionfiis82, questionfiis83, questionfiis84, questionfiis85, questionfiis86, questionfiis87, questionfiis88, questionfiis89, questionfiis90, questionfiis91, questionfiis92, questionfiis93, questionfiis94, questionfiis95, questionfiis96, questionfiis97, questionfiis98, questionfiis99, questionfiis100, questionfiis101, questionfiis102, questionfiis103, questionfiis104, questionfiis105, questionfiis106, questionfiis107, questionfiis108, questionfiis109, questionfiis110, questionfiis111, questionfiis112, questionfiis113, questionfiis114, questionfiis115, questionfiis116, questionfiis117, questionfiis118, questionfiis119, questionfiis120, questionfiis121, questionfiis122, questionfiis123, questionfiis124, questionfiis125, questionfiis126, questionfiis127, questionfiis128, questionfiis129, questionfiis130, questionfiis131, questionfiis132, questionfiis133, questionfiis134, questionfiis135, questionfiis136, questionfiis137, questionfiis138, questionfiis139, questionfiis140, questionfiis141, questionfiis142, questionfiis143, questionfiis144, questionfiis145, questionfiis146, questionfiis147, questionfiis148, questionfiis149, questionfiis150, questionfiis151, questionfiis152, questionfiis153, questionfiis154, questionfiis155, questionfiis156, questionfiis157, questionfiis158, questionfiis159, questionfiis160, questionfiis161, questionfiis162, questionfiis163, questionfiis164, questionfiis165, questionfiis166, questionfiis167, questionfiis168, questionfiis169, questionfiis170, questionfiis171, questionfiis172, questionfiis173, questionfiis174, questionfiis175, questionfiis176, questionfiis177, questionfiis178, questionfiis179, questionfiis180, questionfiis181, questionfiis182, questionfiis183, questionfiis184, questionfiis185, questionfiis186, questionfiis187, questionfiis188, questionfiis189, questionfiis190, questionfiis191, questionfiis192, questionfiis193, questionfiis194, questionfiis195, questionfiis196, profileImagePath, currentDate, currentDate);

        Toast.makeText(this, "Record updated successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                pickFromCamera();
            } else {
                Toast.makeText(this, "Camera permission is required", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == STORAGE_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                pickFromGallery();
            } else {
                Toast.makeText(this, "Storage permission is required", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void get_fiis_gpsLocation(View view){
        gpsTracker = new GpsTrackerFIIS(UpdateFIIS.this);
        if(gpsTracker.canGetLocation()){
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();
            String latlong = latitude + " " + longitude;
            iis_q119Et.setText(latlong);

        }else{
            gpsTracker.showSettingsAlert();
        }
    }
}