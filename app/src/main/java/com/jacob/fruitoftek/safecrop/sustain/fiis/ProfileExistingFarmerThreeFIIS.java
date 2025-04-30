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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.jacob.fruitoftek.safecrop.DashboardActivity;
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

public class ProfileExistingFarmerThreeFIIS extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;

    private List<String> selectedItems = new ArrayList<>();

    private ArrayAdapter<String> adapter;

    private ImageView currentImageView, profileIv, farmerImageIv, agentSignImageIv;
    private EditText iis_q86Et, iis_q86pjEt, iis_q87Et, iis_q88Et, iis_q89Et, iis_q90Et,
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
    AutoCompleteTextView q86spinner, q87spinner, q88spinner, q89spinner, q90spinner, q91spinner,
            q92spinner, q93spinner, q94spinner, q95spinner, q96spinner, q97spinner, q98spinner,
            q99spinner, q100spinner, q101spinner, q102spinner, q103spinner, q104spinner, q105spinner,
            q106spinner, q107spinner, q108spinner, q109spinner, q110spinner, q111spinner, q112spinner,
            q113spinner, q114spinner, q115spinner, q116spinner, q117spinner, q118spinner;
    private Button iisThreePreviousBtn, saveBtn;
    private TextView tvUserName, tvUserName2;
    private Uri profileIvUri, farmerImageIvUri, agentSignImageIvUri;
    private String profileImagePath, farmerImagePath, agentSignImagePath;
    private MyFIISDbHelper dbHelper;
    private PreferenceHelper preferenceHelper;
    private TextView q16s1Tv, q16s2Tv, q17s1Tv, q18s1Tv, q18s2Tv, q18s3Tv, q19s1Tv, q20s1Tv, q21s1Tv, q21s2Tv, q29s1Tv, q31s1Tv;
    private TextInputLayout q16s1Mt, q16s2Mt, q17s1Mt, q18s3Mt, q19s1Mt, q20s1Mt, q21s1Mt, q21s2Mt, q29s1Mt, q31s1Mt;

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
        setContentView(R.layout.profile_existing_farmer_three_fiis);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String questionfiis1 = intent.getStringExtra("QUESTIONFIIS1");
        String questionfiis2 = intent.getStringExtra("QUESTIONFIIS2");
        String questionfiis3 = intent.getStringExtra("QUESTIONFIIS3");
        String questionfiis4 = intent.getStringExtra("QUESTIONFIIS4");
        String questionfiis5 = intent.getStringExtra("QUESTIONFIIS5");
        String questionfiis6 = intent.getStringExtra("QUESTIONFIIS6");
        String questionfiis7 = intent.getStringExtra("QUESTIONFIIS7");
        String questionfiis8 = intent.getStringExtra("QUESTIONFIIS8");
        String questionfiis9 = intent.getStringExtra("QUESTIONFIIS9");
        String questionfiis10 = intent.getStringExtra("QUESTIONFIIS10");
        String questionfiis11 = intent.getStringExtra("QUESTIONFIIS11");
        String questionfiis12 = intent.getStringExtra("QUESTIONFIIS12");
        String questionfiis13 = intent.getStringExtra("QUESTIONFIIS13");
        String questionfiis14 = intent.getStringExtra("QUESTIONFIIS14");
        String questionfiis15 = intent.getStringExtra("QUESTIONFIIS15");
        String questionfiis16 = intent.getStringExtra("QUESTIONFIIS16");
        String questionfiis17 = intent.getStringExtra("QUESTIONFIIS17");
        String questionfiis18 = intent.getStringExtra("QUESTIONFIIS18");
        String questionfiis19 = intent.getStringExtra("QUESTIONFIIS19");
        String questionfiis20 = intent.getStringExtra("QUESTIONFIIS20");
        String questionfiis21 = intent.getStringExtra("QUESTIONFIIS21");
        String questionfiis22 = intent.getStringExtra("QUESTIONFIIS22");
        String questionfiis23 = intent.getStringExtra("QUESTIONFIIS23");
        String questionfiis24 = intent.getStringExtra("QUESTIONFIIS24");
        String questionfiis25 = intent.getStringExtra("QUESTIONFIIS25");
        String questionfiis26 = intent.getStringExtra("QUESTIONFIIS26");
        String questionfiis27 = intent.getStringExtra("QUESTIONFIIS27");
        String questionfiis28 = intent.getStringExtra("QUESTIONFIIS28");
        String questionfiis29 = intent.getStringExtra("QUESTIONFIIS29");
        String questionfiis30 = intent.getStringExtra("QUESTIONFIIS30");
        String questionfiis31 = intent.getStringExtra("QUESTIONFIIS31");
        String questionfiis32 = intent.getStringExtra("QUESTIONFIIS32");
        String questionfiis33 = intent.getStringExtra("QUESTIONFIIS33");
        String questionfiis34 = intent.getStringExtra("QUESTIONFIIS34");
        String questionfiis35 = intent.getStringExtra("QUESTIONFIIS35");
        String questionfiis36 = intent.getStringExtra("QUESTIONFIIS36");
        String questionfiis37 = intent.getStringExtra("QUESTIONFIIS37");
        String questionfiis38 = intent.getStringExtra("QUESTIONFIIS38");
        String questionfiis39 = intent.getStringExtra("QUESTIONFIIS39");
        String questionfiis40 = intent.getStringExtra("QUESTIONFIIS40");
        String questionfiis41 = intent.getStringExtra("QUESTIONFIIS41");
        String questionfiis42 = intent.getStringExtra("QUESTIONFIIS42");
        String questionfiis43 = intent.getStringExtra("QUESTIONFIIS43");
        String questionfiis44 = intent.getStringExtra("QUESTIONFIIS44");
        String questionfiis45 = intent.getStringExtra("QUESTIONFIIS45");
        String questionfiis46 = intent.getStringExtra("QUESTIONFIIS46");
        String questionfiis47 = intent.getStringExtra("QUESTIONFIIS47");
        String questionfiis48 = intent.getStringExtra("QUESTIONFIIS48");
        String questionfiis49 = intent.getStringExtra("QUESTIONFIIS49");
        String questionfiis50 = intent.getStringExtra("QUESTIONFIIS50");
        String questionfiis51 = intent.getStringExtra("QUESTIONFIIS51");
        String questionfiis52 = intent.getStringExtra("QUESTIONFIIS52");
        String questionfiis53 = intent.getStringExtra("QUESTIONFIIS53");
        String questionfiis54 = intent.getStringExtra("QUESTIONFIIS54");
        String questionfiis55 = intent.getStringExtra("QUESTIONFIIS55");
        String questionfiis56 = intent.getStringExtra("QUESTIONFIIS56");
        String questionfiis57 = intent.getStringExtra("QUESTIONFIIS57");
        String questionfiis58 = intent.getStringExtra("QUESTIONFIIS58");
        String questionfiis59 = intent.getStringExtra("QUESTIONFIIS59");
        String questionfiis60 = intent.getStringExtra("QUESTIONFIIS60");
        String questionfiis61 = intent.getStringExtra("QUESTIONFIIS61");
        String questionfiis62 = intent.getStringExtra("QUESTIONFIIS62");
        String questionfiis63 = intent.getStringExtra("QUESTIONFIIS63");
        String questionfiis64 = intent.getStringExtra("QUESTIONFIIS64");
        String questionfiis65 = intent.getStringExtra("QUESTIONFIIS65");
        String questionfiis66 = intent.getStringExtra("QUESTIONFIIS66");
        String questionfiis67 = intent.getStringExtra("QUESTIONFIIS67");
        String questionfiis68 = intent.getStringExtra("QUESTIONFIIS68");
        String questionfiis69 = intent.getStringExtra("QUESTIONFIIS69");
        String questionfiis70 = intent.getStringExtra("QUESTIONFIIS70");
        String questionfiis71 = intent.getStringExtra("QUESTIONFIIS71");
        String questionfiis72 = intent.getStringExtra("QUESTIONFIIS72");
        String questionfiis73 = intent.getStringExtra("QUESTIONFIIS73");
        String questionfiis74 = intent.getStringExtra("QUESTIONFIIS74");
        String questionfiis75 = intent.getStringExtra("QUESTIONFIIS75");
        String questionfiis76 = intent.getStringExtra("QUESTIONFIIS76");
        String questionfiis77 = intent.getStringExtra("QUESTIONFIIS77");
        String questionfiis78 = intent.getStringExtra("QUESTIONFIIS78");
        String questionfiis79 = intent.getStringExtra("QUESTIONFIIS79");
        String questionfiis80 = intent.getStringExtra("QUESTIONFIIS80");
        String questionfiis81 = intent.getStringExtra("QUESTIONFIIS81");
        String questionfiis82 = intent.getStringExtra("QUESTIONFIIS82");
        String questionfiis83 = intent.getStringExtra("QUESTIONFIIS83");
        String questionfiis84 = intent.getStringExtra("QUESTIONFIIS84");
        String questionfiis85 = intent.getStringExtra("QUESTIONFIIS85");
        String questionfiis86 = intent.getStringExtra("QUESTIONFIIS86");
        String questionfiis87 = intent.getStringExtra("QUESTIONFIIS87");
        String questionfiis88 = intent.getStringExtra("QUESTIONFIIS88");
        String questionfiis89 = intent.getStringExtra("QUESTIONFIIS89");
        String questionfiis90 = intent.getStringExtra("QUESTIONFIIS90");
        String questionfiis91 = intent.getStringExtra("QUESTIONFIIS91");
        String questionfiis92 = intent.getStringExtra("QUESTIONFIIS92");
        String questionfiis93 = intent.getStringExtra("QUESTIONFIIS93");
        String questionfiis94 = intent.getStringExtra("QUESTIONFIIS94");
        String questionfiis95 = intent.getStringExtra("QUESTIONFIIS95");
        String questionfiis96 = intent.getStringExtra("QUESTIONFIIS96");
        String questionfiis97 = intent.getStringExtra("QUESTIONFIIS97");
        String questionfiis98 = intent.getStringExtra("QUESTIONFIIS98");
        String questionfiis99 = intent.getStringExtra("QUESTIONFIIS99");
        String questionfiis100 = intent.getStringExtra("QUESTIONFIIS100");
        String questionfiis101 = intent.getStringExtra("QUESTIONFIIS101");
        String questionfiis102 = intent.getStringExtra("QUESTIONFIIS102");
        String questionfiis103 = intent.getStringExtra("QUESTIONFIIS103");
        String questionfiis104 = intent.getStringExtra("QUESTIONFIIS104");
        String questionfiis105 = intent.getStringExtra("QUESTIONFIIS105");
        String questionfiis106 = intent.getStringExtra("QUESTIONFIIS106");
        String questionfiis107 = intent.getStringExtra("QUESTIONFIIS107");
        String questionfiis108 = intent.getStringExtra("QUESTIONFIIS108");
        String questionfiis109 = intent.getStringExtra("QUESTIONFIIS109");
        String questionfiis110 = intent.getStringExtra("QUESTIONFIIS110");
        String questionfiis111 = intent.getStringExtra("QUESTIONFIIS111");
        String questionfiis112 = intent.getStringExtra("QUESTIONFIIS112");
        String questionfiis113 = intent.getStringExtra("QUESTIONFIIS113");
        String questionfiis114 = intent.getStringExtra("QUESTIONFIIS114");
        String questionfiis115 = intent.getStringExtra("QUESTIONFIIS115");
        String questionfiis116 = intent.getStringExtra("QUESTIONFIIS116");
        String questionfiis117 = intent.getStringExtra("QUESTIONFIIS117");
        String questionfiis118 = intent.getStringExtra("QUESTIONFIIS118");
        String questionfiis119 = intent.getStringExtra("QUESTIONFIIS119");
        String questionfiis120 = intent.getStringExtra("QUESTIONFIIS120");
        String questionfiis121 = intent.getStringExtra("QUESTIONFIIS121");
        String questionfiis122 = intent.getStringExtra("QUESTIONFIIS122");
        String questionfiis123 = intent.getStringExtra("QUESTIONFIIS123");
        String questionfiis124 = intent.getStringExtra("QUESTIONFIIS124");
        String questionfiis125 = intent.getStringExtra("QUESTIONFIIS125");
        String questionfiis126 = intent.getStringExtra("QUESTIONFIIS126");
        String questionfiis127 = intent.getStringExtra("QUESTIONFIIS127");
        String questionfiis128 = intent.getStringExtra("QUESTIONFIIS128");
        String questionfiis129 = intent.getStringExtra("QUESTIONFIIS129");

        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        preferenceHelper = new PreferenceHelper(this);
        dbHelper = new MyFIISDbHelper(this);

        setupActionBar();

        tvUserName = findViewById(R.id.fiisuserFNameTV);
        tvUserName2 = findViewById(R.id.fiisuserONameTV);
        tvUserName.setText(preferenceHelper.getFirstName());
        tvUserName2.setText(preferenceHelper.getLastName());


        iis_q86Et = findViewById(R.id.iis_q86Et);
        iis_q87Et = findViewById(R.id.iis_q87Et);
        iis_q88Et = findViewById(R.id.iis_q88Et);
        iis_q89Et = findViewById(R.id.iis_q89Et);
        iis_q90Et = findViewById(R.id.iis_q90Et);
        iis_q91Et = findViewById(R.id.iis_q91Et);
        iis_q92Et = findViewById(R.id.iis_q92Et);
        iis_q93Et = findViewById(R.id.iis_q93Et);
        iis_q94Et = findViewById(R.id.iis_q94Et);
        iis_q95Et = findViewById(R.id.iis_q95Et);
        iis_q96Et = findViewById(R.id.iis_q96Et);
        iis_q97Et = findViewById(R.id.iis_q97Et);
        iis_q98Et = findViewById(R.id.iis_q98Et);
        iis_q99Et = findViewById(R.id.iis_q99Et);
        iis_q100Et = findViewById(R.id.iis_q100Et);
        iis_q101Et = findViewById(R.id.iis_q101Et);
        iis_q102Et = findViewById(R.id.iis_q102Et);
        iis_q103Et = findViewById(R.id.iis_q103Et);
        iis_q104Et = findViewById(R.id.iis_q104Et);
        iis_q104pjEt = findViewById(R.id.iis_q104pjEt);
        iis_q105Et = findViewById(R.id.iis_q105Et);
        iis_q106Et = findViewById(R.id.iis_q106Et);
        iis_q107Et = findViewById(R.id.iis_q107Et);
        iis_q108Et = findViewById(R.id.iis_q108Et);
        iis_q109Et = findViewById(R.id.iis_q109Et);
        iis_q110Et = findViewById(R.id.iis_q110Et);
        iis_q111Et = findViewById(R.id.iis_q111Et);
        iis_q112Et = findViewById(R.id.iis_q112Et);
        iis_q113Et = findViewById(R.id.iis_q113Et);
        iis_q114Et = findViewById(R.id.iis_q114Et);
        iis_q115Et = findViewById(R.id.iis_q115Et);
        iis_q116Et = findViewById(R.id.iis_q116Et);
        iis_q117Et = findViewById(R.id.iis_q117Et);
        iis_q118Et = findViewById(R.id.iis_q118Et);
        iis_q119Et = findViewById(R.id.iis_q119Et);

        profileIv = findViewById(R.id.iis_photoIv);
        iisThreePreviousBtn = findViewById(R.id.fiisThreePreviousBtn);
        saveBtn = findViewById(R.id.fiisThreeSaveBtn);
        profileIv.setOnClickListener(v -> showImagePickDialog(profileIv));

        //Q86
        iis_q86pjEt = findViewById(R.id.iis_q86pjEt);

        iis_q86pjEt.setVisibility(View.GONE);
        String[] iis_q86 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q86adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q86
        );
        AutoCompleteTextView iis_q86AutoCompleteTextView = findViewById(R.id.iis_q86Et);
        iis_q86AutoCompleteTextView.setAdapter(iis_q86adapter);

        iis_q86AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q86pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q86pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q86pjEt.setVisibility(View.VISIBLE);
                }
            }
        });



        //Q87
        iis_q87pjEt = findViewById(R.id.iis_q87pjEt);

        iis_q87pjEt.setVisibility(View.GONE);
        String[] iis_q87 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q87adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q87
        );
        AutoCompleteTextView iis_q87AutoCompleteTextView = findViewById(R.id.iis_q87Et);
        iis_q87AutoCompleteTextView.setAdapter(iis_q87adapter);

        iis_q87AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q87pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q87pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q87pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q88
        iis_q88pjEt = findViewById(R.id.iis_q88pjEt);

        iis_q88pjEt.setVisibility(View.GONE);
        String[] iis_q88 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q88adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q88
        );
        AutoCompleteTextView iis_q88AutoCompleteTextView = findViewById(R.id.iis_q88Et);
        iis_q88AutoCompleteTextView.setAdapter(iis_q88adapter);

        iis_q88AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q88pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q88pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q88pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q89
        iis_q89pjEt = findViewById(R.id.iis_q89pjEt);

        iis_q89pjEt.setVisibility(View.GONE);
        String[] iis_q89 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q89adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q89
        );
        AutoCompleteTextView iis_q89AutoCompleteTextView = findViewById(R.id.iis_q89Et);
        iis_q89AutoCompleteTextView.setAdapter(iis_q89adapter);

        iis_q89AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q89pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q89pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q89pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q90
        iis_q90pjEt = findViewById(R.id.iis_q90pjEt);

        iis_q90pjEt.setVisibility(View.GONE);
        String[] iis_q90 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q90adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q90
        );
        AutoCompleteTextView iis_q90AutoCompleteTextView = findViewById(R.id.iis_q90Et);
        iis_q90AutoCompleteTextView.setAdapter(iis_q90adapter);

        iis_q90AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q90pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q90pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q90pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q91
        iis_q91pjEt = findViewById(R.id.iis_q91pjEt);

        iis_q91pjEt.setVisibility(View.GONE);
        String[] iis_q91 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q91adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q91
        );
        AutoCompleteTextView iis_q91AutoCompleteTextView = findViewById(R.id.iis_q91Et);
        iis_q91AutoCompleteTextView.setAdapter(iis_q91adapter);

        iis_q91AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q91pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q91pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q91pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q92
        iis_q92pjEt = findViewById(R.id.iis_q92pjEt);

        iis_q92pjEt.setVisibility(View.GONE);
        String[] iis_q92 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q92adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q92
        );
        AutoCompleteTextView iis_q92AutoCompleteTextView = findViewById(R.id.iis_q92Et);
        iis_q92AutoCompleteTextView.setAdapter(iis_q92adapter);

        iis_q92AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q92pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q92pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q92pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q93
        iis_q93pjEt = findViewById(R.id.iis_q93pjEt);

        iis_q93pjEt.setVisibility(View.GONE);
        String[] iis_q93 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q93adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q93
        );
        AutoCompleteTextView iis_q93AutoCompleteTextView = findViewById(R.id.iis_q93Et);
        iis_q93AutoCompleteTextView.setAdapter(iis_q93adapter);

        iis_q93AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q93pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q93pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q93pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q94
        iis_q94pjEt = findViewById(R.id.iis_q94pjEt);

        iis_q94pjEt.setVisibility(View.GONE);
        String[] iis_q94 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q94adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q94
        );
        AutoCompleteTextView iis_q94AutoCompleteTextView = findViewById(R.id.iis_q94Et);
        iis_q94AutoCompleteTextView.setAdapter(iis_q94adapter);

        iis_q94AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q94pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q94pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q94pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q95
        iis_q95pjEt = findViewById(R.id.iis_q95pjEt);

        iis_q95pjEt.setVisibility(View.GONE);
        String[] iis_q95 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q95adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q95
        );
        AutoCompleteTextView iis_q95AutoCompleteTextView = findViewById(R.id.iis_q95Et);
        iis_q95AutoCompleteTextView.setAdapter(iis_q95adapter);

        iis_q95AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q95pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q95pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q95pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q96
        iis_q96pjEt = findViewById(R.id.iis_q96pjEt);

        iis_q96pjEt.setVisibility(View.GONE);
        String[] iis_q96 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q96adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q96
        );
        AutoCompleteTextView iis_q96AutoCompleteTextView = findViewById(R.id.iis_q96Et);
        iis_q96AutoCompleteTextView.setAdapter(iis_q96adapter);

        iis_q96AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q96pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q96pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q96pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q97
        iis_q97pjEt = findViewById(R.id.iis_q97pjEt);

        iis_q97pjEt.setVisibility(View.GONE);
        String[] iis_q97 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q97adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q97
        );
        AutoCompleteTextView iis_q97AutoCompleteTextView = findViewById(R.id.iis_q97Et);
        iis_q97AutoCompleteTextView.setAdapter(iis_q97adapter);

        iis_q97AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q97pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q97pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q97pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q98
        iis_q98pjEt = findViewById(R.id.iis_q98pjEt);

        iis_q98pjEt.setVisibility(View.GONE);
        String[] iis_q98 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q98adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q98
        );
        AutoCompleteTextView iis_q98AutoCompleteTextView = findViewById(R.id.iis_q98Et);
        iis_q98AutoCompleteTextView.setAdapter(iis_q98adapter);

        iis_q98AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q98pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q98pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q98pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q99
        iis_q99pjEt = findViewById(R.id.iis_q99pjEt);

        iis_q99pjEt.setVisibility(View.GONE);
        String[] iis_q99 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q99adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q99
        );
        AutoCompleteTextView iis_q99AutoCompleteTextView = findViewById(R.id.iis_q99Et);
        iis_q99AutoCompleteTextView.setAdapter(iis_q99adapter);

        iis_q99AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q99pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q99pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q99pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q100
        iis_q100pjEt = findViewById(R.id.iis_q100pjEt);

        iis_q100pjEt.setVisibility(View.GONE);
        String[] iis_q100 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q100adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q100
        );
        AutoCompleteTextView iis_q100AutoCompleteTextView = findViewById(R.id.iis_q100Et);
        iis_q100AutoCompleteTextView.setAdapter(iis_q100adapter);

        iis_q100AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q100pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q100pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q100pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q101
        iis_q101pjEt = findViewById(R.id.iis_q101pjEt);

        iis_q101pjEt.setVisibility(View.GONE);
        String[] iis_q101 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q101adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q101
        );
        AutoCompleteTextView iis_q101AutoCompleteTextView = findViewById(R.id.iis_q101Et);
        iis_q101AutoCompleteTextView.setAdapter(iis_q101adapter);

        iis_q101AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q101pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q101pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q101pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q102
        iis_q102pjEt = findViewById(R.id.iis_q102pjEt);

        iis_q102pjEt.setVisibility(View.GONE);
        String[] iis_q102 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q102adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q102
        );
        AutoCompleteTextView iis_q102AutoCompleteTextView = findViewById(R.id.iis_q102Et);
        iis_q102AutoCompleteTextView.setAdapter(iis_q102adapter);

        iis_q102AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q102pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q102pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q102pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q103
        iis_q103pjEt = findViewById(R.id.iis_q103pjEt);

        iis_q103pjEt.setVisibility(View.GONE);
        String[] iis_q103 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q103adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q103
        );
        AutoCompleteTextView iis_q103AutoCompleteTextView = findViewById(R.id.iis_q103Et);
        iis_q103AutoCompleteTextView.setAdapter(iis_q103adapter);

        iis_q103AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q103pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q103pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q103pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q104
//        q104spinner = findViewById(R.id.iis_q104Et);
//        iis_q104pjEt = findViewById(R.id.iis_q104pjEt);
//
//        iis_q104pjEt.setVisibility(View.GONE);
//        String[] iis_q104 = new String[]{"Yes", "No", "NA"};
//        ArrayAdapter<String> iis_q104adapter = new ArrayAdapter<>(
//                this,
//                R.layout.dropdown,
//                iis_q104
//        );
//        AutoCompleteTextView iis_q104AutoCompleteTextView = findViewById(R.id.iis_q104Et);
//        iis_q104AutoCompleteTextView.setAdapter(iis_q104adapter);
//
//        iis_q104AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedItem = parent.getItemAtPosition(position).toString();
//                if (selectedItem.trim().equals("Yes")) {
//                    iis_q104pjEt.setVisibility(View.GONE);
//                }
//                if (selectedItem.trim().equals("No")) {
//                    iis_q104pjEt.setVisibility(View.VISIBLE);
//                }
//                if (selectedItem.trim().equals("NA")) {
//                    iis_q104pjEt.setVisibility(View.VISIBLE);
//                }
//            }
//        });


        //Q105
        iis_q105pjEt = findViewById(R.id.iis_q105pjEt);

        iis_q105pjEt.setVisibility(View.GONE);
        String[] iis_q105 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q105adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q105
        );
        AutoCompleteTextView iis_q105AutoCompleteTextView = findViewById(R.id.iis_q105Et);
        iis_q105AutoCompleteTextView.setAdapter(iis_q105adapter);

        iis_q105AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q105pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q105pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q105pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q106
        iis_q106pjEt = findViewById(R.id.iis_q106pjEt);

        iis_q106pjEt.setVisibility(View.GONE);
        String[] iis_q106 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q106adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q106
        );
        AutoCompleteTextView iis_q106AutoCompleteTextView = findViewById(R.id.iis_q106Et);
        iis_q106AutoCompleteTextView.setAdapter(iis_q106adapter);

        iis_q106AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q106pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q106pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q106pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q107
        iis_q107pjEt = findViewById(R.id.iis_q107pjEt);

        iis_q107pjEt.setVisibility(View.GONE);
        String[] iis_q107 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q107adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q107
        );
        AutoCompleteTextView iis_q107AutoCompleteTextView = findViewById(R.id.iis_q107Et);
        iis_q107AutoCompleteTextView.setAdapter(iis_q107adapter);

        iis_q107AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q107pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q107pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q107pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q108
        iis_q108pjEt = findViewById(R.id.iis_q108pjEt);

        iis_q108pjEt.setVisibility(View.GONE);
        String[] iis_q108 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q108adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q108
        );
        AutoCompleteTextView iis_q108AutoCompleteTextView = findViewById(R.id.iis_q108Et);
        iis_q108AutoCompleteTextView.setAdapter(iis_q108adapter);

        iis_q108AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q108pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q108pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q108pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q109
        iis_q109pjEt = findViewById(R.id.iis_q109pjEt);

        iis_q109pjEt.setVisibility(View.GONE);
        String[] iis_q109 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q109adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q109
        );
        AutoCompleteTextView iis_q109AutoCompleteTextView = findViewById(R.id.iis_q109Et);
        iis_q109AutoCompleteTextView.setAdapter(iis_q109adapter);

        iis_q109AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q109pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q109pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q109pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q110
        iis_q110pjEt = findViewById(R.id.iis_q110pjEt);

        iis_q110pjEt.setVisibility(View.GONE);
        String[] iis_q110 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q110adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q110
        );
        AutoCompleteTextView iis_q110AutoCompleteTextView = findViewById(R.id.iis_q110Et);
        iis_q110AutoCompleteTextView.setAdapter(iis_q110adapter);

        iis_q110AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q110pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q110pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q110pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q111
        iis_q111pjEt = findViewById(R.id.iis_q111pjEt);

        iis_q111pjEt.setVisibility(View.GONE);
        String[] iis_q111 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q111adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q111
        );
        AutoCompleteTextView iis_q111AutoCompleteTextView = findViewById(R.id.iis_q111Et);
        iis_q111AutoCompleteTextView.setAdapter(iis_q111adapter);

        iis_q111AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q111pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q111pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q111pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q112
        iis_q112pjEt = findViewById(R.id.iis_q112pjEt);

        iis_q112pjEt.setVisibility(View.GONE);
        String[] iis_q112 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q112adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q112
        );
        AutoCompleteTextView iis_q112AutoCompleteTextView = findViewById(R.id.iis_q112Et);
        iis_q112AutoCompleteTextView.setAdapter(iis_q112adapter);

        iis_q112AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q112pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q112pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q112pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q113
        iis_q113pjEt = findViewById(R.id.iis_q113pjEt);

        iis_q113pjEt.setVisibility(View.GONE);
        String[] iis_q113 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q113adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q113
        );
        AutoCompleteTextView iis_q113AutoCompleteTextView = findViewById(R.id.iis_q113Et);
        iis_q113AutoCompleteTextView.setAdapter(iis_q113adapter);

        iis_q113AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q113pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q113pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q113pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q114
        iis_q114pjEt = findViewById(R.id.iis_q114pjEt);

        iis_q114pjEt.setVisibility(View.GONE);
        String[] iis_q114 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q114adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q114
        );
        AutoCompleteTextView iis_q114AutoCompleteTextView = findViewById(R.id.iis_q114Et);
        iis_q114AutoCompleteTextView.setAdapter(iis_q114adapter);

        iis_q114AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q114pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q114pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q114pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q115
        iis_q115pjEt = findViewById(R.id.iis_q115pjEt);

        iis_q115pjEt.setVisibility(View.GONE);
        String[] iis_q115 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q115adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q115
        );
        AutoCompleteTextView iis_q115AutoCompleteTextView = findViewById(R.id.iis_q115Et);
        iis_q115AutoCompleteTextView.setAdapter(iis_q115adapter);

        iis_q115AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q115pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q115pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q115pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q116
        iis_q116pjEt = findViewById(R.id.iis_q116pjEt);

        iis_q116pjEt.setVisibility(View.GONE);
        String[] iis_q116 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q116adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q116
        );
        AutoCompleteTextView iis_q116AutoCompleteTextView = findViewById(R.id.iis_q116Et);
        iis_q116AutoCompleteTextView.setAdapter(iis_q116adapter);

        iis_q116AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q116pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q116pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q116pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q117
        iis_q117pjEt = findViewById(R.id.iis_q117pjEt);

        iis_q117pjEt.setVisibility(View.GONE);
        String[] iis_q117 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q117adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q117
        );
        AutoCompleteTextView iis_q117AutoCompleteTextView = findViewById(R.id.iis_q117Et);
        iis_q117AutoCompleteTextView.setAdapter(iis_q117adapter);

        iis_q117AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q117pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q117pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q117pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q118
        iis_q118pjEt = findViewById(R.id.iis_q118pjEt);

        iis_q118pjEt.setVisibility(View.GONE);
        String[] iis_q118 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q118adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q118
        );
        AutoCompleteTextView iis_q118AutoCompleteTextView = findViewById(R.id.iis_q118Et);
        iis_q118AutoCompleteTextView.setAdapter(iis_q118adapter);

        iis_q118AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q118pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q118pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q118pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        iisThreePreviousBtn.setOnClickListener(v -> {
            Toast.makeText(ProfileExistingFarmerThreeFIIS.this, "Use yout phone back key", Toast.LENGTH_SHORT).show();
//            Intent previousIntent = new Intent(ProfileExistingFarmerThreeFIIS.this, ProfileExistingFarmerTwoFIIS.class);
//            previousIntent.putExtra("QUESTIONFIIS1", questionfiis1);
//            previousIntent.putExtra("QUESTIONFIIS2", questionfiis2);
//            previousIntent.putExtra("QUESTIONFIIS3", questionfiis3);
//            previousIntent.putExtra("QUESTIONFIIS4", questionfiis4);
//            previousIntent.putExtra("QUESTIONFIIS5", questionfiis5);
//            previousIntent.putExtra("QUESTIONFIIS6", questionfiis6);
//            previousIntent.putExtra("QUESTIONFIIS7", questionfiis7);
//            previousIntent.putExtra("QUESTIONFIIS8", questionfiis8);
//            previousIntent.putExtra("QUESTIONFIIS9", questionfiis9);
//            previousIntent.putExtra("QUESTIONFIIS10", questionfiis10);
//            previousIntent.putExtra("QUESTIONFIIS11", questionfiis11);
//            previousIntent.putExtra("QUESTIONFIIS12", questionfiis12);
//            previousIntent.putExtra("QUESTIONFIIS13", questionfiis13);
//            previousIntent.putExtra("QUESTIONFIIS14", questionfiis14);
//            previousIntent.putExtra("QUESTIONFIIS15", questionfiis15);
//            previousIntent.putExtra("QUESTIONFIIS16", questionfiis16);
//            previousIntent.putExtra("QUESTIONFIIS17", questionfiis17);
//            previousIntent.putExtra("QUESTIONFIIS18", questionfiis18);
//            previousIntent.putExtra("QUESTIONFIIS19", questionfiis19);
//            previousIntent.putExtra("QUESTIONFIIS20", questionfiis20);
//            previousIntent.putExtra("QUESTIONFIIS21", questionfiis21);
//            previousIntent.putExtra("QUESTIONFIIS22", questionfiis22);
//            previousIntent.putExtra("QUESTIONFIIS23", questionfiis23);
//            previousIntent.putExtra("QUESTIONFIIS24", questionfiis24);
//            previousIntent.putExtra("QUESTIONFIIS25", questionfiis25);
//            previousIntent.putExtra("QUESTIONFIIS26", questionfiis26);
//            previousIntent.putExtra("QUESTIONFIIS27", questionfiis27);
//            previousIntent.putExtra("QUESTIONFIIS28", questionfiis28);
//            previousIntent.putExtra("QUESTIONFIIS29", questionfiis29);
//            previousIntent.putExtra("QUESTIONFIIS30", questionfiis30);
//            previousIntent.putExtra("QUESTIONFIIS31", questionfiis31);
//            previousIntent.putExtra("QUESTIONFIIS32", questionfiis32);
//            previousIntent.putExtra("QUESTIONFIIS33", questionfiis33);
//            previousIntent.putExtra("QUESTIONFIIS34", questionfiis34);
//            previousIntent.putExtra("QUESTIONFIIS35", questionfiis35);
//            previousIntent.putExtra("QUESTIONFIIS36", questionfiis36);
//            previousIntent.putExtra("QUESTIONFIIS37", questionfiis37);
//            previousIntent.putExtra("QUESTIONFIIS38", questionfiis38);
//            previousIntent.putExtra("QUESTIONFIIS39", questionfiis39);
//            previousIntent.putExtra("QUESTIONFIIS40", questionfiis40);
//            previousIntent.putExtra("QUESTIONFIIS41", questionfiis41);
//            previousIntent.putExtra("QUESTIONFIIS42", questionfiis42);
//            previousIntent.putExtra("QUESTIONFIIS43", questionfiis43);
//            previousIntent.putExtra("QUESTIONFIIS44", questionfiis44);
//            previousIntent.putExtra("QUESTIONFIIS45", questionfiis45);
//            previousIntent.putExtra("QUESTIONFIIS46", questionfiis46);
//            previousIntent.putExtra("QUESTIONFIIS47", questionfiis47);
//            previousIntent.putExtra("QUESTIONFIIS48", questionfiis48);
//            previousIntent.putExtra("QUESTIONFIIS49", questionfiis49);
//            previousIntent.putExtra("QUESTIONFIIS50", questionfiis50);
//            previousIntent.putExtra("QUESTIONFIIS51", questionfiis51);
//            previousIntent.putExtra("QUESTIONFIIS52", questionfiis52);
//            previousIntent.putExtra("QUESTIONFIIS53", questionfiis53);
//            previousIntent.putExtra("QUESTIONFIIS54", questionfiis54);
//            previousIntent.putExtra("QUESTIONFIIS55", questionfiis55);
//            previousIntent.putExtra("QUESTIONFIIS56", questionfiis56);
//            previousIntent.putExtra("QUESTIONFIIS57", questionfiis57);
//            previousIntent.putExtra("QUESTIONFIIS58", questionfiis58);
//            previousIntent.putExtra("QUESTIONFIIS59", questionfiis59);
//            previousIntent.putExtra("QUESTIONFIIS60", questionfiis60);
//            previousIntent.putExtra("QUESTIONFIIS61", questionfiis61);
//            previousIntent.putExtra("QUESTIONFIIS62", questionfiis62);
//            previousIntent.putExtra("QUESTIONFIIS63", questionfiis63);
//            previousIntent.putExtra("QUESTIONFIIS64", questionfiis64);
//            previousIntent.putExtra("QUESTIONFIIS65", questionfiis65);
//            previousIntent.putExtra("QUESTIONFIIS66", questionfiis66);
//            previousIntent.putExtra("QUESTIONFIIS67", questionfiis67);
//            previousIntent.putExtra("QUESTIONFIIS68", questionfiis68);
//            previousIntent.putExtra("QUESTIONFIIS69", questionfiis69);
//            previousIntent.putExtra("QUESTIONFIIS70", questionfiis70);
//            previousIntent.putExtra("QUESTIONFIIS71", questionfiis71);
//            previousIntent.putExtra("QUESTIONFIIS72", questionfiis72);
//            previousIntent.putExtra("QUESTIONFIIS73", questionfiis73);
//            previousIntent.putExtra("QUESTIONFIIS74", questionfiis74);
//            previousIntent.putExtra("QUESTIONFIIS75", questionfiis75);
//            previousIntent.putExtra("QUESTIONFIIS76", questionfiis76);
//            previousIntent.putExtra("QUESTIONFIIS77", questionfiis77);
//            previousIntent.putExtra("QUESTIONFIIS78", questionfiis78);
//            previousIntent.putExtra("QUESTIONFIIS79", questionfiis79);
//            previousIntent.putExtra("QUESTIONFIIS80", questionfiis80);
//            previousIntent.putExtra("QUESTIONFIIS81", questionfiis81);
//            previousIntent.putExtra("QUESTIONFIIS82", questionfiis82);
//            previousIntent.putExtra("QUESTIONFIIS83", questionfiis83);
//            previousIntent.putExtra("QUESTIONFIIS84", questionfiis84);
//            previousIntent.putExtra("QUESTIONFIIS85", questionfiis85);
//            previousIntent.putExtra("QUESTIONFIIS86", questionfiis86);
//            previousIntent.putExtra("QUESTIONFIIS87", questionfiis87);
//            previousIntent.putExtra("QUESTIONFIIS88", questionfiis88);
//            previousIntent.putExtra("QUESTIONFIIS89", questionfiis89);
//            previousIntent.putExtra("QUESTIONFIIS90", questionfiis90);
//            previousIntent.putExtra("QUESTIONFIIS91", questionfiis91);
//            previousIntent.putExtra("QUESTIONFIIS92", questionfiis92);
//            previousIntent.putExtra("QUESTIONFIIS93", questionfiis93);
//            previousIntent.putExtra("QUESTIONFIIS94", questionfiis94);
//            previousIntent.putExtra("QUESTIONFIIS95", questionfiis95);
//            previousIntent.putExtra("QUESTIONFIIS96", questionfiis96);
//            previousIntent.putExtra("QUESTIONFIIS97", questionfiis97);
//            previousIntent.putExtra("QUESTIONFIIS98", questionfiis98);
//            previousIntent.putExtra("QUESTIONFIIS99", questionfiis99);
//            previousIntent.putExtra("QUESTIONFIIS100", questionfiis100);
//            previousIntent.putExtra("QUESTIONFIIS101", questionfiis101);
//            previousIntent.putExtra("QUESTIONFIIS102", questionfiis102);
//            previousIntent.putExtra("QUESTIONFIIS103", questionfiis103);
//            previousIntent.putExtra("QUESTIONFIIS104", questionfiis104);
//            previousIntent.putExtra("QUESTIONFIIS105", questionfiis105);
//            previousIntent.putExtra("QUESTIONFIIS106", questionfiis106);
//            previousIntent.putExtra("QUESTIONFIIS107", questionfiis107);
//            previousIntent.putExtra("QUESTIONFIIS108", questionfiis108);
//            previousIntent.putExtra("QUESTIONFIIS109", questionfiis109);
//            previousIntent.putExtra("QUESTIONFIIS110", questionfiis110);
//            previousIntent.putExtra("QUESTIONFIIS111", questionfiis111);
//            previousIntent.putExtra("QUESTIONFIIS112", questionfiis112);
//            previousIntent.putExtra("QUESTIONFIIS113", questionfiis113);
//            previousIntent.putExtra("QUESTIONFIIS114", questionfiis114);
//            previousIntent.putExtra("QUESTIONFIIS115", questionfiis115);
//            previousIntent.putExtra("QUESTIONFIIS116", questionfiis116);
//            previousIntent.putExtra("QUESTIONFIIS117", questionfiis117);
//            previousIntent.putExtra("QUESTIONFIIS118", questionfiis118);
//            previousIntent.putExtra("QUESTIONFIIS119", questionfiis119);
//            previousIntent.putExtra("QUESTIONFIIS120", questionfiis120);
//            previousIntent.putExtra("QUESTIONFIIS121", questionfiis121);
//            previousIntent.putExtra("QUESTIONFIIS122", questionfiis122);
//            previousIntent.putExtra("QUESTIONFIIS123", questionfiis123);
//            previousIntent.putExtra("QUESTIONFIIS124", questionfiis124);
//            previousIntent.putExtra("QUESTIONFIIS125", questionfiis125);
//            previousIntent.putExtra("QUESTIONFIIS126", questionfiis126);
//            previousIntent.putExtra("QUESTIONFIIS127", questionfiis127);
//            previousIntent.putExtra("QUESTIONFIIS128", questionfiis128);
//            previousIntent.putExtra("QUESTIONFIIS129", questionfiis129);
//            startActivity(previousIntent);
        });

        //saveBtn.setOnClickListener(v -> saveRecord());


        saveBtn.setOnClickListener(v -> {
            String firstName = tvUserName.getText().toString().trim();
            String otherNames = tvUserName2.getText().toString().trim();
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

            if (questionfiis1.isEmpty()) {
                Toast.makeText(this, "Question1 and Question2 required", Toast.LENGTH_SHORT).show();
                return;
            }

            String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            dbHelper.insertRecord(firstName, otherNames, questionfiis1, questionfiis2, questionfiis3, questionfiis4, questionfiis5, questionfiis6, questionfiis7, questionfiis8, questionfiis9, questionfiis10, questionfiis11, questionfiis12, questionfiis13, questionfiis14, questionfiis15, questionfiis16, questionfiis17, questionfiis18, questionfiis19, questionfiis20, questionfiis21, questionfiis22, questionfiis23, questionfiis24, questionfiis25, questionfiis26, questionfiis27, questionfiis28, questionfiis29, questionfiis30, questionfiis31, questionfiis32, questionfiis33, questionfiis34, questionfiis35, questionfiis36, questionfiis37, questionfiis38, questionfiis39, questionfiis40, questionfiis41, questionfiis42, questionfiis43, questionfiis44, questionfiis45, questionfiis46, questionfiis47, questionfiis48, questionfiis49, questionfiis50, questionfiis51, questionfiis52, questionfiis53, questionfiis54, questionfiis55, questionfiis56, questionfiis57, questionfiis58, questionfiis59, questionfiis60, questionfiis61, questionfiis62, questionfiis63, questionfiis64, questionfiis65, questionfiis66, questionfiis67, questionfiis68, questionfiis69, questionfiis70, questionfiis71, questionfiis72, questionfiis73, questionfiis74, questionfiis75, questionfiis76, questionfiis77, questionfiis78, questionfiis79, questionfiis80, questionfiis81, questionfiis82, questionfiis83, questionfiis84, questionfiis85, questionfiis86, questionfiis87, questionfiis88, questionfiis89, questionfiis90, questionfiis91, questionfiis92, questionfiis93, questionfiis94, questionfiis95, questionfiis96, questionfiis97, questionfiis98, questionfiis99, questionfiis100, questionfiis101, questionfiis102, questionfiis103, questionfiis104, questionfiis105, questionfiis106, questionfiis107, questionfiis108, questionfiis109, questionfiis110, questionfiis111, questionfiis112, questionfiis113, questionfiis114, questionfiis115, questionfiis116, questionfiis117, questionfiis118, questionfiis119, questionfiis120, questionfiis121, questionfiis122, questionfiis123, questionfiis124, questionfiis125, questionfiis126, questionfiis127, questionfiis128, questionfiis129, questionfiis130, questionfiis131, questionfiis132, questionfiis133, questionfiis134, questionfiis135, questionfiis136, questionfiis137, questionfiis138, questionfiis139, questionfiis140, questionfiis141, questionfiis142, questionfiis143, questionfiis144, questionfiis145, questionfiis146, questionfiis147, questionfiis148, questionfiis149, questionfiis150, questionfiis151, questionfiis152, questionfiis153, questionfiis154, questionfiis155, questionfiis156, questionfiis157, questionfiis158, questionfiis159, questionfiis160, questionfiis161, questionfiis162, questionfiis163, questionfiis164, questionfiis165, questionfiis166, questionfiis167, questionfiis168, questionfiis169, questionfiis170, questionfiis171, questionfiis172, questionfiis173, questionfiis174, questionfiis175, questionfiis176, questionfiis177, questionfiis178, questionfiis179, questionfiis180, questionfiis181, questionfiis182, questionfiis183, questionfiis184, questionfiis185, questionfiis186, questionfiis187, questionfiis188, questionfiis189, questionfiis190, questionfiis191, questionfiis192, questionfiis193, questionfiis194, questionfiis195, questionfiis196, profileImagePath, currentDate, currentDate);

            Toast.makeText(this, "Profiled successfully", Toast.LENGTH_SHORT).show();
            showSuccessDialog();
        });

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.inspection_part3);
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
                            //pickFromGallery();
                        } else {
                            //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_IMAGES}, STORAGE_REQUEST_CODE);
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
        if (uri != null) { // Check if uri is not null before proceeding
            String question5 = iis_q86Et.getText().toString().trim(); // Get the value of question5
            String filePath = saveImageFile(uri, question5);
            if (filePath != null) {
                if (imageView == profileIv) {
                    profileIvUri = uri;
                    profileImagePath = filePath; // Save file path in the database
                } else if (imageView == farmerImageIv) {
                    farmerImageIvUri = uri;
                    farmerImagePath = filePath; // Save file path in the database
                } else if (imageView == agentSignImageIv) {
                    agentSignImageIvUri = uri;
                    agentSignImagePath = filePath; // Save file path in the database
                }
            } else {
                Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Image selection failed", Toast.LENGTH_SHORT).show();
        }
    }

    private String saveImageFile(Uri uri, String question5) {
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

//    private void saveRecord() {
//        String firstName = tvUserName.getText().toString().trim();
//        String otherNames = tvUserName2.getText().toString().trim();
////        String questionfiis1 = iis_q1Et.getText().toString().trim();
////        String questionfiis2 = iis_q2Et.getText().toString().trim();
////        String questionfiis3 = iis_q3Et.getText().toString().trim();
////        String questionfiis4 = iis_q4Et.getText().toString().trim();
////        String questionfiis5 = iis_q5Et.getText().toString().trim();
////        String questionfiis6 = iis_q6Et.getText().toString().trim();
////        String questionfiis7 = iis_q7Et.getText().toString().trim();
////        String questionfiis8 = iis_q8Et.getText().toString().trim();
////        String questionfiis9 = iis_q9Et.getText().toString().trim();
////        String questionfiis10 = iis_q10Et.getText().toString().trim();
////        String questionfiis11 = iis_q11Et.getText().toString().trim();
////        String questionfiis12 = iis_q12Et.getText().toString().trim();
////        String questionfiis13 = iis_q13Et.getText().toString().trim();
////        String questionfiis14 = iis_q14Et.getText().toString().trim();
////        String questionfiis15 = iis_q15Et.getText().toString().trim();
////        String questionfiis16 = iis_q16Et.getText().toString().trim();
////        String questionfiis17 = iis_q17Et.getText().toString().trim();
////        String questionfiis18 = iis_q18Et.getText().toString().trim();
////        String questionfiis19 = iis_q19Et.getText().toString().trim();
////        String questionfiis20 = iis_q20Et.getText().toString().trim();
////        String questionfiis21 = iis_q21Et.getText().toString().trim();
////        String questionfiis22 = iis_q22Et.getText().toString().trim();
////        String questionfiis23 = iis_q23Et.getText().toString().trim();
////        String questionfiis24 = iis_q24Et.getText().toString().trim();
////        String questionfiis25 = iis_q25Et.getText().toString().trim();
////        String questionfiis26 = iis_q26Et.getText().toString().trim();
////        String questionfiis27 = iis_q27Et.getText().toString().trim();
////        String questionfiis28 = iis_q28Et.getText().toString().trim();
////        String questionfiis29 = iis_q29Et.getText().toString().trim();
////        String questionfiis30 = iis_q30Et.getText().toString().trim();
////        String questionfiis31 = iis_q31Et.getText().toString().trim();
////        String questionfiis32 = iis_q32Et.getText().toString().trim();
////        String questionfiis33 = iis_q33Et.getText().toString().trim();
////        String questionfiis34 = iis_q34Et.getText().toString().trim();
////        String questionfiis35 = iis_q35Et.getText().toString().trim();
////        String questionfiis36 = iis_q36Et.getText().toString().trim();
////        String questionfiis37 = iis_q37Et.getText().toString().trim();
////        String questionfiis38 = iis_q38Et.getText().toString().trim();
////        String questionfiis39 = iis_q39Et.getText().toString().trim();
////        String questionfiis40 = iis_q40Et.getText().toString().trim();
////        String questionfiis41 = iis_q41Et.getText().toString().trim();
////        String questionfiis42 = iis_q42Et.getText().toString().trim();
////        String questionfiis43 = iis_q42pjEt.getText().toString().trim();
////        String questionfiis44 = iis_q43Et.getText().toString().trim();
////        String questionfiis45 = iis_q43pjEt.getText().toString().trim();
////        String questionfiis46 = iis_q44Et.getText().toString().trim();
////        String questionfiis47 = iis_q44pjEt.getText().toString().trim();
////        String questionfiis48 = iis_q45Et.getText().toString().trim();
////        String questionfiis49 = iis_q45pjEt.getText().toString().trim();
////        String questionfiis50 = iis_q46Et.getText().toString().trim();
////        String questionfiis51 = iis_q46pjEt.getText().toString().trim();
////        String questionfiis52 = iis_q47Et.getText().toString().trim();
////        String questionfiis53 = iis_q47pjEt.getText().toString().trim();
////        String questionfiis54 = iis_q48Et.getText().toString().trim();
////        String questionfiis55 = iis_q48pjEt.getText().toString().trim();
////        String questionfiis56 = iis_q49Et.getText().toString().trim();
////        String questionfiis57 = iis_q49pjEt.getText().toString().trim();
////        String questionfiis58 = iis_q50Et.getText().toString().trim();
////        String questionfiis59 = iis_q50pjEt.getText().toString().trim();
////        String questionfiis60 = iis_q51Et.getText().toString().trim();
////        String questionfiis61 = iis_q51pjEt.getText().toString().trim();
////        String questionfiis62 = iis_q52Et.getText().toString().trim();
////        String questionfiis63 = iis_q52pjEt.getText().toString().trim();
////        String questionfiis64 = iis_q53Et.getText().toString().trim();
////        String questionfiis65 = iis_q53pjEt.getText().toString().trim();
////        String questionfiis66 = iis_q54Et.getText().toString().trim();
////        String questionfiis67 = iis_q54pjEt.getText().toString().trim();
////        String questionfiis68 = iis_q55Et.getText().toString().trim();
////        String questionfiis69 = iis_q55pjEt.getText().toString().trim();
////        String questionfiis70 = iis_q56Et.getText().toString().trim();
////        String questionfiis71 = iis_q56pjEt.getText().toString().trim();
////        String questionfiis72 = iis_q57Et.getText().toString().trim();
////        String questionfiis73 = iis_q57pjEt.getText().toString().trim();
////        String questionfiis74 = iis_q58Et.getText().toString().trim();
////        String questionfiis75 = iis_q58pjEt.getText().toString().trim();
////        String questionfiis76 = iis_q59Et.getText().toString().trim();
////        String questionfiis77 = iis_q59pjEt.getText().toString().trim();
////        String questionfiis78 = iis_q60Et.getText().toString().trim();
////        String questionfiis79 = iis_q60pjEt.getText().toString().trim();
////        String questionfiis80 = iis_q61Et.getText().toString().trim();
////        String questionfiis81 = iis_q61pjEt.getText().toString().trim();
////        String questionfiis82 = iis_q62Et.getText().toString().trim();
////        String questionfiis83 = iis_q62pjEt.getText().toString().trim();
////        String questionfiis84 = iis_q63Et.getText().toString().trim();
////        String questionfiis85 = iis_q63pjEt.getText().toString().trim();
////        String questionfiis86 = iis_q64Et.getText().toString().trim();
////        String questionfiis87 = iis_q64pjEt.getText().toString().trim();
////        String questionfiis88 = iis_q65Et.getText().toString().trim();
////        String questionfiis89 = iis_q65pjEt.getText().toString().trim();
////        String questionfiis90 = iis_q66Et.getText().toString().trim();
////        String questionfiis91 = iis_q66pjEt.getText().toString().trim();
////        String questionfiis92 = iis_q67Et.getText().toString().trim();
////        String questionfiis93 = iis_q67pjEt.getText().toString().trim();
////        String questionfiis94 = iis_q68Et.getText().toString().trim();
////        String questionfiis95 = iis_q68pjEt.getText().toString().trim();
////        String questionfiis96 = iis_q69Et.getText().toString().trim();
////        String questionfiis97 = iis_q69pjEt.getText().toString().trim();
////        String questionfiis98 = iis_q70Et.getText().toString().trim();
////        String questionfiis99 = iis_q70pjEt.getText().toString().trim();
////        String questionfiis100 = iis_q71Et.getText().toString().trim();
////        String questionfiis101 = iis_q71pjEt.getText().toString().trim();
////        String questionfiis102 = iis_q72Et.getText().toString().trim();
////        String questionfiis103 = iis_q72pjEt.getText().toString().trim();
////        String questionfiis104 = iis_q73Et.getText().toString().trim();
////        String questionfiis105 = iis_q73pjEt.getText().toString().trim();
////        String questionfiis106 = iis_q74Et.getText().toString().trim();
////        String questionfiis107 = iis_q74pjEt.getText().toString().trim();
////        String questionfiis108 = iis_q75Et.getText().toString().trim();
////        String questionfiis109 = iis_q75pjEt.getText().toString().trim();
////        String questionfiis110 = iis_q76Et.getText().toString().trim();
////        String questionfiis111 = iis_q76pjEt.getText().toString().trim();
////        String questionfiis112 = iis_q77Et.getText().toString().trim();
////        String questionfiis113 = iis_q77pjEt.getText().toString().trim();
////        String questionfiis114 = iis_q78Et.getText().toString().trim();
////        String questionfiis115 = iis_q78pjEt.getText().toString().trim();
////        String questionfiis116 = iis_q79Et.getText().toString().trim();
////        String questionfiis117 = iis_q79pjEt.getText().toString().trim();
////        String questionfiis118 = iis_q80Et.getText().toString().trim();
////        String questionfiis119 = iis_q80pjEt.getText().toString().trim();
////        String questionfiis120 = iis_q81Et.getText().toString().trim();
////        String questionfiis121 = iis_q81pjEt.getText().toString().trim();
////        String questionfiis122 = iis_q82Et.getText().toString().trim();
////        String questionfiis123 = iis_q82pjEt.getText().toString().trim();
////        String questionfiis124 = iis_q83Et.getText().toString().trim();
////        String questionfiis125 = iis_q83pjEt.getText().toString().trim();
////        String questionfiis126 = iis_q84Et.getText().toString().trim();
////        String questionfiis127 = iis_q84pjEt.getText().toString().trim();
////        String questionfiis128 = iis_q85Et.getText().toString().trim();
////        String questionfiis129 = iis_q85pjEt.getText().toString().trim();
//        String questionfiis130 = iis_q86Et.getText().toString().trim();
//        String questionfiis131 = iis_q86pjEt.getText().toString().trim();
//        String questionfiis132 = iis_q87Et.getText().toString().trim();
//        String questionfiis133 = iis_q87pjEt.getText().toString().trim();
//        String questionfiis134 = iis_q88Et.getText().toString().trim();
//        String questionfiis135 = iis_q88pjEt.getText().toString().trim();
//        String questionfiis136 = iis_q89Et.getText().toString().trim();
//        String questionfiis137 = iis_q89pjEt.getText().toString().trim();
//        String questionfiis138 = iis_q90Et.getText().toString().trim();
//        String questionfiis139 = iis_q90pjEt.getText().toString().trim();
//        String questionfiis140 = iis_q91Et.getText().toString().trim();
//        String questionfiis141 = iis_q91pjEt.getText().toString().trim();
//        String questionfiis142 = iis_q92Et.getText().toString().trim();
//        String questionfiis143 = iis_q92pjEt.getText().toString().trim();
//        String questionfiis144 = iis_q93Et.getText().toString().trim();
//        String questionfiis145 = iis_q93pjEt.getText().toString().trim();
//        String questionfiis146 = iis_q94Et.getText().toString().trim();
//        String questionfiis147 = iis_q94pjEt.getText().toString().trim();
//        String questionfiis148 = iis_q95Et.getText().toString().trim();
//        String questionfiis149 = iis_q95pjEt.getText().toString().trim();
//        String questionfiis150 = iis_q96Et.getText().toString().trim();
//        String questionfiis151 = iis_q96pjEt.getText().toString().trim();
//        String questionfiis152 = iis_q97Et.getText().toString().trim();
//        String questionfiis153 = iis_q97pjEt.getText().toString().trim();
//        String questionfiis154 = iis_q98Et.getText().toString().trim();
//        String questionfiis155 = iis_q98pjEt.getText().toString().trim();
//        String questionfiis156 = iis_q99Et.getText().toString().trim();
//        String questionfiis157 = iis_q99pjEt.getText().toString().trim();
//        String questionfiis158 = iis_q100Et.getText().toString().trim();
//        String questionfiis159 = iis_q100pjEt.getText().toString().trim();
//        String questionfiis160 = iis_q101Et.getText().toString().trim();
//        String questionfiis161 = iis_q101pjEt.getText().toString().trim();
//        String questionfiis162 = iis_q102Et.getText().toString().trim();
//        String questionfiis163 = iis_q102pjEt.getText().toString().trim();
//        String questionfiis164 = iis_q103Et.getText().toString().trim();
//        String questionfiis165 = iis_q103pjEt.getText().toString().trim();
//        String questionfiis166 = iis_q104Et.getText().toString().trim();
//        String questionfiis167 = iis_q104pjEt.getText().toString().trim();
//        String questionfiis168 = iis_q105Et.getText().toString().trim();
//        String questionfiis169 = iis_q105pjEt.getText().toString().trim();
//        String questionfiis170 = iis_q106Et.getText().toString().trim();
//        String questionfiis171 = iis_q106pjEt.getText().toString().trim();
//        String questionfiis172 = iis_q107Et.getText().toString().trim();
//        String questionfiis173 = iis_q107pjEt.getText().toString().trim();
//        String questionfiis174 = iis_q108Et.getText().toString().trim();
//        String questionfiis175 = iis_q108pjEt.getText().toString().trim();
//        String questionfiis176 = iis_q109Et.getText().toString().trim();
//        String questionfiis177 = iis_q109pjEt.getText().toString().trim();
//        String questionfiis178 = iis_q110Et.getText().toString().trim();
//        String questionfiis179 = iis_q110pjEt.getText().toString().trim();
//        String questionfiis180 = iis_q111Et.getText().toString().trim();
//        String questionfiis181 = iis_q111pjEt.getText().toString().trim();
//        String questionfiis182 = iis_q112Et.getText().toString().trim();
//        String questionfiis183 = iis_q112pjEt.getText().toString().trim();
//        String questionfiis184 = iis_q113Et.getText().toString().trim();
//        String questionfiis185 = iis_q113pjEt.getText().toString().trim();
//        String questionfiis186 = iis_q114Et.getText().toString().trim();
//        String questionfiis187 = iis_q114pjEt.getText().toString().trim();
//        String questionfiis188 = iis_q115Et.getText().toString().trim();
//        String questionfiis189 = iis_q115pjEt.getText().toString().trim();
//        String questionfiis190 = iis_q116Et.getText().toString().trim();
//        String questionfiis191 = iis_q116pjEt.getText().toString().trim();
//        String questionfiis192 = iis_q117Et.getText().toString().trim();
//        String questionfiis193 = iis_q117pjEt.getText().toString().trim();
//        String questionfiis194 = iis_q118Et.getText().toString().trim();
//        String questionfiis195 = iis_q118pjEt.getText().toString().trim();
//        String questionfiis196 = iis_q119Et.getText().toString().trim();
//
//        if (questionfiis196.isEmpty() || questionfiis195.isEmpty() || questionfiis194.isEmpty()) {
//            Toast.makeText(this, "Question 1, 5, 6 are required", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
//        dbHelper.insertRecord(firstName, otherNames, questionfiis1, questionfiis2, questionfiis3, questionfiis4, questionfiis5, questionfiis6, questionfiis7, questionfiis8, questionfiis9, questionfiis10, questionfiis11, questionfiis12, questionfiis13, questionfiis14, questionfiis15, questionfiis16, questionfiis17, questionfiis18, questionfiis19, questionfiis20, questionfiis21, questionfiis22, questionfiis23, questionfiis24, questionfiis25, questionfiis26, questionfiis27, questionfiis28, questionfiis29, questionfiis30, questionfiis31, questionfiis32, questionfiis33, questionfiis34, questionfiis35, questionfiis36, questionfiis37, questionfiis38, questionfiis39, questionfiis40, questionfiis41, questionfiis42, questionfiis43, questionfiis44, questionfiis45, questionfiis46, questionfiis47, questionfiis48, questionfiis49, questionfiis50, questionfiis51, questionfiis52, questionfiis53, questionfiis54, questionfiis55, questionfiis56, questionfiis57, questionfiis58, questionfiis59, questionfiis60, questionfiis61, questionfiis62, questionfiis63, questionfiis64, questionfiis65, questionfiis66, questionfiis67, questionfiis68, questionfiis69, questionfiis70, questionfiis71, questionfiis72, questionfiis73, questionfiis74, questionfiis75, questionfiis76, questionfiis77, questionfiis78, questionfiis79, questionfiis80, questionfiis81, questionfiis82, questionfiis83, questionfiis84, questionfiis85, questionfiis86, questionfiis87, questionfiis88, questionfiis89, questionfiis90, questionfiis91, questionfiis92, questionfiis93, questionfiis94, questionfiis95, questionfiis96, questionfiis97, questionfiis98, questionfiis99, questionfiis100, questionfiis101, questionfiis102, questionfiis103, questionfiis104, questionfiis105, questionfiis106, questionfiis107, questionfiis108, questionfiis109, questionfiis110, questionfiis111, questionfiis112, questionfiis113, questionfiis114, questionfiis115, questionfiis116, questionfiis117, questionfiis118, questionfiis119, questionfiis120, questionfiis121, questionfiis122, questionfiis123, questionfiis124, questionfiis125, questionfiis126, questionfiis127, questionfiis128, questionfiis129, questionfiis130, questionfiis131, questionfiis132, questionfiis133, questionfiis134, questionfiis135, questionfiis136, questionfiis137, questionfiis138, questionfiis139, questionfiis140, questionfiis141, questionfiis142, questionfiis143, questionfiis144, questionfiis145, questionfiis146, questionfiis147, questionfiis148, questionfiis149, questionfiis150, questionfiis151, questionfiis152, questionfiis153, questionfiis154, questionfiis155, questionfiis156, questionfiis157, questionfiis158, questionfiis159, questionfiis160, questionfiis161, questionfiis162, questionfiis163, questionfiis164, questionfiis165, questionfiis166, questionfiis167, questionfiis168, questionfiis169, questionfiis170, questionfiis171, questionfiis172, questionfiis173, questionfiis174, questionfiis175, questionfiis176, questionfiis177, questionfiis178, questionfiis179, questionfiis180, questionfiis181, questionfiis182, questionfiis183, questionfiis184, questionfiis185, questionfiis186, questionfiis187, questionfiis188, questionfiis189, questionfiis190, questionfiis191, questionfiis192, questionfiis193, questionfiis194, questionfiis195, questionfiis196, profileImagePath, currentDate, currentDate);
//
//        Toast.makeText(this, "Profiled successfully", Toast.LENGTH_SHORT).show();
//        showSuccessDialog();
//    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Farmer profiled successfully. Do you want to add a new record?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    clearFields();
                    dialog.dismiss();
                    startActivity(new Intent(ProfileExistingFarmerThreeFIIS.this, ListFIISFarmersActivity.class));
                    finish();
                })
                .setNegativeButton("No", (dialog, which) -> {
                    dialog.dismiss();
                    startActivity(new Intent(ProfileExistingFarmerThreeFIIS.this, DashboardActivity.class));
                    finish();
                })
                .show();
    }

    private void clearFields() {
        iis_q87Et.setText("");
        iis_q86Et.setText("");
        profileIv.setImageResource(R.drawable.ic_person_black);
        farmerImageIv.setImageResource(R.drawable.ic_person_black);
        agentSignImageIv.setImageResource(R.drawable.ic_person_black);
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
                //pickFromGallery();
            } else {
                //Toast.makeText(this, "Storage permission is required", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void get_fiis_gpsLocation(View view){
        gpsTracker = new GpsTrackerFIIS(ProfileExistingFarmerThreeFIIS.this);
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