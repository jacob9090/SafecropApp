package com.jacob.fruitoftek.safecrop.sustain.fiis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;

import java.util.ArrayList;
import java.util.List;

public class ProfileExistingFarmerOneFIIS extends AppCompatActivity {

    private List<String> selectedItems = new ArrayList<>();

    private ArrayAdapter<String> adapter;

    private EditText iis_q1Et, iis_q2Et, iis_q3Et, iis_q4Et, iis_q5Et, iis_q6Et, iis_q7Et, iis_q8Et, iis_q9Et, iis_q10Et,
            iis_q11Et, iis_q12Et, iis_q13Et, iis_q14Et, iis_q15Et, iis_q16Et, iis_q17Et, iis_q18Et, iis_q19Et, iis_q20Et,
            iis_q21Et, iis_q22Et, iis_q23Et, iis_q24Et, iis_q25Et, iis_q26Et, iis_q27Et, iis_q28Et, iis_q29Et, iis_q30Et,
            iis_q31Et, iis_q32Et, iis_q33Et, iis_q34Et, iis_q35Et, iis_q36Et, iis_q37Et, iis_q38Et, iis_q39Et, iis_q40Et,
            iis_q41Et;
    AutoCompleteTextView iisgen, iisdistrict, iiscommunity, iisfarm_unit, iisfarm_visited, numberofpermworkers,
            iisgenp1, iisgenp2, iisgenp3, iisgenp4, iisgenp5;

    CardView pw1Cv, pw2Cv, pw3Cv, pw4Cv, pw5Cv;

    private Button openIISDateBtn, iisOneNextBtn;

    private PreferenceHelper preferenceHelper;

    //private TextView tvUserFName, tvUserOName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile_existing_farmer_one_fiis);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        preferenceHelper = new PreferenceHelper(this);

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
        iisOneNextBtn = findViewById(R.id.iisOneNextBtn);


        //Q4 Gender
        iisgen = findViewById(R.id.iis_q3Et);
        String[] iisgen = new String[]{"Male", "Female"};
        ArrayAdapter<String> iisgenadapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iisgen
        );
        AutoCompleteTextView iisgenAutoCompleteTextView = findViewById(R.id.iis_q3Et);
        iisgenAutoCompleteTextView.setAdapter(iisgenadapter);


        //Q6 district
        iisdistrict = findViewById(R.id.iis_q8Et);
        String[] iisdistrict = new String[]{"Akim Oda", "Ofoase", "Kade"};
        ArrayAdapter<String> iisdistrictadapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iisdistrict
        );
        AutoCompleteTextView iisdistrictAutoCompleteTextView = findViewById(R.id.iis_q8Et);
        iisdistrictAutoCompleteTextView.setAdapter(iisdistrictadapter);


        //Q6 community
        iiscommunity = findViewById(R.id.iis_q9Et);
        String[] iiscommunity = new String[]{"Abaam A", "Abaam B", "Abaam C", "Abaam D", "Abenase", "Abenaso A", "Abenaso B", "Aboabo/Batabi", "Achiase A", "Achiase B", "Adanso Boi", "Adeikrom", "Adjorbue", "Aduasa", "Adubiase", "Adugyan", "Aggreykrom", "Akim Oda", "Akim Ofoase A", "Akim Ofoase A ", "Akim Ofoase B", "Akim Swedru", "Akokoaso B", "Akokoaso Beposo", "Akokoaso C", "Akotekrom", "Akropong", "Akroso A", "Akroso B", "Akroso C", "Akyekrom", "Akyekrom B", "Amonum", "Angona", "Anwona Nsese", "Anyinam A", "Anyinam B", "Anyinam C", "Anyinase", "Apenamang ", "Aperade", "Apinto", "ARKWANU", "Asabidie", "Asene A", "Asene B", "Asuboa", "Asubone", "Asuom A", "Asuom B", "Atenurom", "Banka", "Bantama", "Beposo Mp Road", "Bieni", "Boadua A", "Bommoden", "Bomso A", "Bomso B", "Bomso C", "Bomso D", "Bontoduase A", "Bontoduase B", "Bontoduase C", "Boso", "Breku", "Chia", "Darman", "Edwenase", "Eshiem A", "Eshiem B", "Essam A", "Essam B", "Gyadam", "Gyaha", "Kokoben", "Kotokuom A", "Kotokuom B", "Kwaboadi", "Kwasi Awuah A", "Kwasi Awuah B", "Kyeremansi", "Larbi Krom ", "Mallam A", "Mukyia", "Mukyiamu", "Nyamebekyere", "Oda Nkwanta", "Odumase", "Ofoase  Menskrom", "Ofoase Kuma", "Ofoase Marketsquare", "Okumaning A", "Okyinso", "Onomabo", "Osenase", "Otopah", "Otwereso A", "Otwereso A ", "Otwereso B", "Pampaso", "Santamaria", "Sanya", "Sika Ne Asem A", "Subinso", "Takroase", "Takyiman A", "Takyiman B", "Takyiman C", "Takyiman D", "Takyiman E", "Teacher Atta", "Topremang A", "Tweapease A", "Tweapease B", "Tweapease C", "Wenchi 1", "Wenchi 2", "Yeboah", "Yesu Nkwanta", "Zevor A", "Zevor C"};
        ArrayAdapter<String> iiscommunityadapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iiscommunity
        );
        AutoCompleteTextView iiscommunityAutoCompleteTextView = findViewById(R.id.iis_q9Et);
        iiscommunityAutoCompleteTextView.setAdapter(iiscommunityadapter);


        //Q6 farm unit
        iisfarm_unit = findViewById(R.id.iis_q10Et);
        String[] iisfarmunit = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        ArrayAdapter<String> iisfarmunitadapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iisfarmunit
        );
        AutoCompleteTextView iisfarmunitAutoCompleteTextView = findViewById(R.id.iis_q10Et);
        iisfarmunitAutoCompleteTextView.setAdapter(iisfarmunitadapter);


        //Q6 farm visited
        iisfarm_visited = findViewById(R.id.iis_q11Et);
        String[] iisiisfarmvisited = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        ArrayAdapter<String> iisfarmvisitedadapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iisiisfarmvisited
        );
        AutoCompleteTextView iisfarmvisitedAutoCompleteTextView = findViewById(R.id.iis_q11Et);
        iisfarmvisitedAutoCompleteTextView.setAdapter(iisfarmvisitedadapter);


        //Q17 DoB
        openIISDateBtn = findViewById(R.id.iisinspection_dateBtn);
        CalendarConstraints.Builder calendarConstraintBuilder = new CalendarConstraints.Builder();
        final MaterialDatePicker.Builder materialDatePickerBuilder = MaterialDatePicker.Builder.datePicker();
        materialDatePickerBuilder.setTitleText("SELECT DATE");

        materialDatePickerBuilder.setCalendarConstraints(calendarConstraintBuilder.build());

        final MaterialDatePicker materialDatePicker = materialDatePickerBuilder.build();

        openIISDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        // now update the selected date preview
                        iis_q16Et.setText(materialDatePicker.getHeaderText());
                    }
                });


        //Q18 number of perm. workers
        numberofpermworkers = findViewById(R.id.iis_q17Et);
        pw1Cv = findViewById(R.id.pw1Cv);
        pw2Cv = findViewById(R.id.pw2Cv);
        pw3Cv = findViewById(R.id.pw3Cv);
        pw4Cv = findViewById(R.id.pw4Cv);
        pw5Cv = findViewById(R.id.pw5Cv);

        pw1Cv.setVisibility(View.GONE);
        pw2Cv.setVisibility(View.GONE);
        pw3Cv.setVisibility(View.GONE);
        pw4Cv.setVisibility(View.GONE);
        pw5Cv.setVisibility(View.GONE);
        String[] noch = new String[]{"0", "1", "2", "3", "4", "5"};
        ArrayAdapter<String> nochadapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                noch
        );
        AutoCompleteTextView nochAutoCompleteTextView = findViewById(R.id.iis_q17Et);
        nochAutoCompleteTextView.setAdapter(nochadapter);

        nochAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("0")) {
                    pw1Cv.setVisibility(View.GONE);
                    pw2Cv.setVisibility(View.GONE);
                    pw3Cv.setVisibility(View.GONE);
                    pw4Cv.setVisibility(View.GONE);
                    pw5Cv.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("1")) {
                    pw1Cv.setVisibility(View.VISIBLE);
                    pw2Cv.setVisibility(View.GONE);
                    pw3Cv.setVisibility(View.GONE);
                    pw4Cv.setVisibility(View.GONE);
                    pw5Cv.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("2")) {
                    pw1Cv.setVisibility(View.VISIBLE);
                    pw2Cv.setVisibility(View.VISIBLE);
                    pw3Cv.setVisibility(View.GONE);
                    pw4Cv.setVisibility(View.GONE);
                    pw5Cv.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("3")) {
                    pw1Cv.setVisibility(View.VISIBLE);
                    pw2Cv.setVisibility(View.VISIBLE);
                    pw3Cv.setVisibility(View.VISIBLE);
                    pw4Cv.setVisibility(View.GONE);
                    pw5Cv.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("4")) {
                    pw1Cv.setVisibility(View.VISIBLE);
                    pw2Cv.setVisibility(View.VISIBLE);
                    pw3Cv.setVisibility(View.VISIBLE);
                    pw4Cv.setVisibility(View.VISIBLE);
                    pw5Cv.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("5")) {
                    pw1Cv.setVisibility(View.VISIBLE);
                    pw2Cv.setVisibility(View.VISIBLE);
                    pw3Cv.setVisibility(View.VISIBLE);
                    pw4Cv.setVisibility(View.VISIBLE);
                    pw5Cv.setVisibility(View.VISIBLE);
                }

            }
        });


        //Q19 gender_pw1
        iisgenp1 = findViewById(R.id.iis_q19Et);
        String[] iisgenp1 = new String[]{"Male", "Female"};
        ArrayAdapter<String> iisgenp1adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iisgenp1
        );
        AutoCompleteTextView iisgenp1AutoCompleteTextView = findViewById(R.id.iis_q19Et);
        iisgenp1AutoCompleteTextView.setAdapter(iisgenp1adapter);


        //Q23 gender_pw2
        iisgenp2 = findViewById(R.id.iis_q23Et);
        String[] iisgenp2 = new String[]{"Male", "Female"};
        ArrayAdapter<String> iisgenp2adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iisgenp2
        );
        AutoCompleteTextView iisgenp2AutoCompleteTextView = findViewById(R.id.iis_q23Et);
        iisgenp2AutoCompleteTextView.setAdapter(iisgenp2adapter);


        //Q27 gender_pw3
        iisgenp3 = findViewById(R.id.iis_q27Et);
        String[] iisgenp3 = new String[]{"Male", "Female"};
        ArrayAdapter<String> iisgenp3adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iisgenp3
        );
        AutoCompleteTextView iisgenp3AutoCompleteTextView = findViewById(R.id.iis_q27Et);
        iisgenp3AutoCompleteTextView.setAdapter(iisgenp3adapter);



        //Q31 gender_pw4
        iisgenp4 = findViewById(R.id.iis_q31Et);
        String[] iisgenp4 = new String[]{"Male", "Female"};
        ArrayAdapter<String> iisgenp4adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iisgenp4
        );
        AutoCompleteTextView iisgenp4AutoCompleteTextView = findViewById(R.id.iis_q31Et);
        iisgenp4AutoCompleteTextView.setAdapter(iisgenp4adapter);


        //Q35 gender_pw5
        iisgenp5 = findViewById(R.id.iis_q35Et);
        String[] iisgenp5 = new String[]{"Male", "Female"};
        ArrayAdapter<String> iisgenp5adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iisgenp5
        );
        AutoCompleteTextView iisgenp5AutoCompleteTextView = findViewById(R.id.iis_q35Et);
        iisgenp5AutoCompleteTextView.setAdapter(iisgenp5adapter);


//        iisOneNextBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent startIISTwo = new Intent(ProfileExistingFarmerOneFIIS.this, AddIISActivityTwo.class);
//                startActivity(startIISTwo);
//            }
//        });

        //Intent intent = getIntent();

        String farmerid = getIntent().getExtras().getString("farmerid");
        String farmername = getIntent().getExtras().getString("farmername");
        String farmerdistrict = getIntent().getExtras().getString("farmerdistrict");
        String farmercommunity = getIntent().getExtras().getString("farmercommunity");
        iis_q2Et.setText(farmername);
        iis_q6Et.setText(farmerid);
        iis_q8Et.setText(farmerdistrict);
        iis_q9Et.setText(farmercommunity);


        iisOneNextBtn.setOnClickListener(v -> {
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

            Intent intent = new Intent(ProfileExistingFarmerOneFIIS.this, ProfileExistingFarmerTwoFIIS.class);
            intent.putExtra("QUESTIONFIIS1", questionfiis1);
            intent.putExtra("QUESTIONFIIS2", questionfiis2);
            intent.putExtra("QUESTIONFIIS3", questionfiis3);
            intent.putExtra("QUESTIONFIIS4", questionfiis4);
            intent.putExtra("QUESTIONFIIS5", questionfiis5);
            intent.putExtra("QUESTIONFIIS6", questionfiis6);
            intent.putExtra("QUESTIONFIIS7", questionfiis7);
            intent.putExtra("QUESTIONFIIS8", questionfiis8);
            intent.putExtra("QUESTIONFIIS9", questionfiis9);
            intent.putExtra("QUESTIONFIIS10", questionfiis10);
            intent.putExtra("QUESTIONFIIS11", questionfiis11);
            intent.putExtra("QUESTIONFIIS12", questionfiis12);
            intent.putExtra("QUESTIONFIIS13", questionfiis13);
            intent.putExtra("QUESTIONFIIS14", questionfiis14);
            intent.putExtra("QUESTIONFIIS15", questionfiis15);
            intent.putExtra("QUESTIONFIIS16", questionfiis16);
            intent.putExtra("QUESTIONFIIS17", questionfiis17);
            intent.putExtra("QUESTIONFIIS18", questionfiis18);
            intent.putExtra("QUESTIONFIIS19", questionfiis19);
            intent.putExtra("QUESTIONFIIS20", questionfiis20);
            intent.putExtra("QUESTIONFIIS21", questionfiis21);
            intent.putExtra("QUESTIONFIIS22", questionfiis22);
            intent.putExtra("QUESTIONFIIS23", questionfiis23);
            intent.putExtra("QUESTIONFIIS24", questionfiis24);
            intent.putExtra("QUESTIONFIIS25", questionfiis25);
            intent.putExtra("QUESTIONFIIS26", questionfiis26);
            intent.putExtra("QUESTIONFIIS27", questionfiis27);
            intent.putExtra("QUESTIONFIIS28", questionfiis28);
            intent.putExtra("QUESTIONFIIS29", questionfiis29);
            intent.putExtra("QUESTIONFIIS30", questionfiis30);
            intent.putExtra("QUESTIONFIIS31", questionfiis31);
            intent.putExtra("QUESTIONFIIS32", questionfiis32);
            intent.putExtra("QUESTIONFIIS33", questionfiis33);
            intent.putExtra("QUESTIONFIIS34", questionfiis34);
            intent.putExtra("QUESTIONFIIS35", questionfiis35);
            intent.putExtra("QUESTIONFIIS36", questionfiis36);
            intent.putExtra("QUESTIONFIIS37", questionfiis37);
            intent.putExtra("QUESTIONFIIS38", questionfiis38);
            intent.putExtra("QUESTIONFIIS39", questionfiis39);
            intent.putExtra("QUESTIONFIIS40", questionfiis40);
            intent.putExtra("QUESTIONFIIS41", questionfiis41);
            startActivity(intent);
        });

    }

    private <T> T requireNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException("Required value was null.");
        }
        return obj;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.inspection_survey);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}