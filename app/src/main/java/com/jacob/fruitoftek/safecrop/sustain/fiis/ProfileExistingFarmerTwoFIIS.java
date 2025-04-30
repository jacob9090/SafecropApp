package com.jacob.fruitoftek.safecrop.sustain.fiis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileExistingFarmerTwoFIIS extends AppCompatActivity {

    private List<String> selectedItems = new ArrayList<>();

    private ArrayAdapter<String> adapter;

    ImageView progileIv;

    private EditText iis_q42Et, iis_q42pjEt, iis_q43Et, iis_q43pjEt, iis_q44Et, iis_q44pjEt, iis_q45Et, iis_q45pjEt,
            iis_q46Et, iis_q46pjEt, iis_q47Et, iis_q47pjEt, iis_q48Et, iis_q48pjEt, iis_q49Et, iis_q49pjEt,  iis_q50Et, iis_q50pjEt,
            iis_q51Et, iis_q51pjEt, iis_q52Et, iis_q52pjEt, iis_q53Et, iis_q54Et, iis_q55Et, iis_q55pjEt, iis_q56Et, iis_q56pjEt,
            iis_q57Et, iis_q57pjEt, iis_q58Et, iis_q58pjEt, iis_q59Et, iis_q59pjEt, iis_q60Et, iis_q60pjEt, iis_q61Et, iis_q61pjEt,
            iis_q62Et, iis_q62pjEt, iis_q63Et, iis_q63pjEt, iis_q64Et, iis_q64pjEt, iis_q65Et, iis_q65pjEt, iis_q66Et, iis_q66pjEt,
            iis_q67Et, iis_q67pjEt, iis_q68Et,  iis_q68pjEt, iis_q69Et,  iis_q69pjEt, iis_q70Et, iis_q70pjEt, iis_q71Et, iis_q71pjEt,
            iis_q72Et, iis_q72pjEt, iis_q73Et, iis_q73pjEt, iis_q74Et, iis_q74pjEt, iis_q75Et, iis_q75pjEt, iis_q76Et, iis_q76pjEt,
            iis_q77Et, iis_q77pjEt, iis_q78Et, iis_q78pjEt, iis_q79Et, iis_q79pjEt, iis_q80Et, iis_q80pjEt, iis_q81Et, iis_q81pjEt,
            iis_q82Et, iis_q82pjEt, iis_q83Et, iis_q83pjEt, iis_q84Et, iis_q84pjEt, iis_q85Et, iis_q85pjEt;
    AutoCompleteTextView q42spinner, q43spinner, q44spinner, q45spinner, q46spinner, q47spinner, q48spinner,
            q49spinner, q50spinner, q51spinner, q52spinner, iisq53spinner,
            iisq54spinner, q55spinner, q56spinner, q57spinner, q58spinner, q59spinner, q60spinner, q61spinner,
            q62spinner, q63spinner, q64spinner, q65spinner, q66spinner, q67spinner, q68spinner, q69spinner, q70spinner,
            q71spinner, q72spinner, q73spinner, q74spinner, q75spinner, q76spinner, q77spinner, q78spinner, q79spinner,
            q80spinner, q81spinner, q82spinner, q83spinner, q84spinner, q85spinner;

    ActionBar actionBar;

    Button iisTwoPreviousBtn, iisTwoNextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile_existing_farmer_two_fiis);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        iis_q42Et = findViewById(R.id.iis_q42Et);
        iis_q43Et = findViewById(R.id.iis_q43Et);
        iis_q44Et = findViewById(R.id.iis_q44Et);
        iis_q45Et = findViewById(R.id.iis_q45Et);
        iis_q46Et = findViewById(R.id.iis_q46Et);
        iis_q47Et = findViewById(R.id.iis_q47Et);
        iis_q48Et = findViewById(R.id.iis_q48Et);
        iis_q49Et = findViewById(R.id.iis_q49Et);
        iis_q50Et = findViewById(R.id.iis_q50Et);
        iis_q51Et = findViewById(R.id.iis_q51Et);
        iis_q52Et = findViewById(R.id.iis_q52Et);
        iis_q53Et = findViewById(R.id.iis_q53Et);
        iis_q54Et = findViewById(R.id.iis_q54Et);
        iis_q55Et = findViewById(R.id.iis_q55Et);
        iis_q56Et = findViewById(R.id.iis_q56Et);
        iis_q57Et = findViewById(R.id.iis_q57Et);
        iis_q58Et = findViewById(R.id.iis_q58Et);
        iis_q59Et = findViewById(R.id.iis_q59Et);
        iis_q60Et = findViewById(R.id.iis_q60Et);
        iis_q61Et = findViewById(R.id.iis_q61Et);
        iis_q62Et = findViewById(R.id.iis_q62Et);
        iis_q63Et = findViewById(R.id.iis_q63Et);
        iis_q64Et = findViewById(R.id.iis_q64Et);
        iis_q65Et = findViewById(R.id.iis_q65Et);
        iis_q66Et = findViewById(R.id.iis_q66Et);
        iis_q67Et = findViewById(R.id.iis_q67Et);
        iis_q68Et = findViewById(R.id.iis_q68Et);
        iis_q69Et = findViewById(R.id.iis_q69Et);
        iis_q70Et = findViewById(R.id.iis_q70Et);
        iis_q71Et = findViewById(R.id.iis_q71Et);
        iis_q72Et = findViewById(R.id.iis_q72Et);
        iis_q73Et = findViewById(R.id.iis_q73Et);
        iis_q74Et = findViewById(R.id.iis_q74Et);
        iis_q75Et = findViewById(R.id.iis_q75Et);
        iis_q76Et = findViewById(R.id.iis_q76Et);
        iis_q77Et = findViewById(R.id.iis_q77Et);
        iis_q78Et = findViewById(R.id.iis_q78Et);
        iis_q79Et = findViewById(R.id.iis_q79Et);
        iis_q80Et = findViewById(R.id.iis_q80Et);
        iis_q81Et = findViewById(R.id.iis_q81Et);
        iis_q82Et = findViewById(R.id.iis_q82Et);
        iis_q83Et = findViewById(R.id.iis_q83Et);
        iis_q84Et = findViewById(R.id.iis_q84Et);
        iis_q85Et = findViewById(R.id.iis_q85Et);
        iisTwoPreviousBtn = findViewById(R.id.iisTwoPreviousBtn);
        iisTwoNextBtn = findViewById(R.id.iisTwoNextBtn);

        //Q42
        q42spinner = findViewById(R.id.iis_q42Et);
        iis_q42pjEt = findViewById(R.id.iis_q42pjEt);

        iis_q42pjEt.setVisibility(View.GONE);
        String[] iis_q42 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q42adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q42
        );
        AutoCompleteTextView iis_q42AutoCompleteTextView = findViewById(R.id.iis_q42Et);
        iis_q42AutoCompleteTextView.setAdapter(iis_q42adapter);

        iis_q42AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q42pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q42pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q42pjEt.setVisibility(View.VISIBLE);
                }
            }
        });



        //Q43
        q43spinner = findViewById(R.id.iis_q43Et);
        iis_q43pjEt = findViewById(R.id.iis_q43pjEt);

        iis_q43pjEt.setVisibility(View.GONE);
        String[] iis_q43 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q43adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q43
        );
        AutoCompleteTextView iis_q43AutoCompleteTextView = findViewById(R.id.iis_q43Et);
        iis_q43AutoCompleteTextView.setAdapter(iis_q43adapter);

        iis_q43AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q43pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q43pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q43pjEt.setVisibility(View.VISIBLE);
                }
            }
        });



        //Q44
        q44spinner = findViewById(R.id.iis_q44Et);
        iis_q44pjEt = findViewById(R.id.iis_q44pjEt);

        iis_q44pjEt.setVisibility(View.GONE);
        String[] iis_q44 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q44adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q44
        );
        AutoCompleteTextView iis_q44AutoCompleteTextView = findViewById(R.id.iis_q44Et);
        iis_q44AutoCompleteTextView.setAdapter(iis_q44adapter);

        iis_q44AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q44pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q44pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q44pjEt.setVisibility(View.VISIBLE);
                }
            }
        });



        //Q45
        q45spinner = findViewById(R.id.iis_q45Et);
        iis_q45pjEt = findViewById(R.id.iis_q45pjEt);

        iis_q45pjEt.setVisibility(View.GONE);
        String[] iis_q45 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q45adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q45
        );
        AutoCompleteTextView iis_q45AutoCompleteTextView = findViewById(R.id.iis_q45Et);
        iis_q45AutoCompleteTextView.setAdapter(iis_q45adapter);

        iis_q45AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q45pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q45pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q45pjEt.setVisibility(View.VISIBLE);
                }
            }
        });



        //Q46
        q46spinner = findViewById(R.id.iis_q46Et);
        iis_q46pjEt = findViewById(R.id.iis_q46pjEt);

        iis_q46pjEt.setVisibility(View.GONE);
        String[] iis_q46 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q46adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q46
        );
        AutoCompleteTextView iis_q46AutoCompleteTextView = findViewById(R.id.iis_q46Et);
        iis_q46AutoCompleteTextView.setAdapter(iis_q46adapter);

        iis_q46AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q46pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q46pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q46pjEt.setVisibility(View.VISIBLE);
                }
            }
        });



        //Q47
        q47spinner = findViewById(R.id.iis_q47Et);
        iis_q47pjEt = findViewById(R.id.iis_q47pjEt);

        iis_q47pjEt.setVisibility(View.GONE);
        String[] iis_q47 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q47adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q47
        );
        AutoCompleteTextView iis_q47AutoCompleteTextView = findViewById(R.id.iis_q47Et);
        iis_q47AutoCompleteTextView.setAdapter(iis_q47adapter);

        iis_q47AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q47pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q47pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q47pjEt.setVisibility(View.VISIBLE);
                }
            }
        });



        //Q48
        q48spinner = findViewById(R.id.iis_q48Et);
        iis_q48pjEt = findViewById(R.id.iis_q48pjEt);

        iis_q48pjEt.setVisibility(View.GONE);
        String[] iis_q48 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q48adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q48
        );
        AutoCompleteTextView iis_q48AutoCompleteTextView = findViewById(R.id.iis_q48Et);
        iis_q48AutoCompleteTextView.setAdapter(iis_q48adapter);

        iis_q48AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q48pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q48pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q48pjEt.setVisibility(View.VISIBLE);
                }
            }
        });



        //Q49
        q49spinner = findViewById(R.id.iis_q49Et);
        iis_q49pjEt = findViewById(R.id.iis_q49pjEt);

        iis_q49pjEt.setVisibility(View.GONE);
        String[] iis_q49 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q49adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q49
        );
        AutoCompleteTextView iis_q49AutoCompleteTextView = findViewById(R.id.iis_q49Et);
        iis_q49AutoCompleteTextView.setAdapter(iis_q49adapter);

        iis_q49AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q49pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q49pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q49pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q50
        q50spinner = findViewById(R.id.iis_q50Et);
        iis_q50pjEt = findViewById(R.id.iis_q50pjEt);

        iis_q50pjEt.setVisibility(View.GONE);
        String[] iis_q50 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q50adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q50
        );
        AutoCompleteTextView iis_q50AutoCompleteTextView = findViewById(R.id.iis_q50Et);
        iis_q50AutoCompleteTextView.setAdapter(iis_q50adapter);

        iis_q50AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q50pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q50pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q50pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q51
        q51spinner = findViewById(R.id.iis_q51Et);
        iis_q51pjEt = findViewById(R.id.iis_q51pjEt);

        iis_q51pjEt.setVisibility(View.GONE);
        String[] iis_q51 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q51adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q51
        );
        AutoCompleteTextView iis_q51AutoCompleteTextView = findViewById(R.id.iis_q51Et);
        iis_q51AutoCompleteTextView.setAdapter(iis_q51adapter);

        iis_q51AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q51pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q51pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q51pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q52
        q52spinner = findViewById(R.id.iis_q52Et);
        iis_q52pjEt = findViewById(R.id.iis_q52pjEt);

        iis_q52pjEt.setVisibility(View.GONE);
        String[] iis_q52 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q52adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q52
        );
        AutoCompleteTextView iis_q52AutoCompleteTextView = findViewById(R.id.iis_q52Et);
        iis_q52AutoCompleteTextView.setAdapter(iis_q52adapter);

        iis_q52AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q52pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q52pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q52pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q53
        iisq53spinner = findViewById(R.id.iis_q53Et);
        String[] iis_q53 = new String[]{"Poor (35 %)", "Fair (35 – 74%)", "Good (75%)"};
        ArrayAdapter<String> iis_q53adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q53
        );
        AutoCompleteTextView iis_q53AutoCompleteTextView = findViewById(R.id.iis_q53Et);
        iis_q53AutoCompleteTextView.setAdapter(iis_q53adapter);


        //Q54
        iisq54spinner = findViewById(R.id.iis_q54Et);
        String[] iis_q54 = new String[]{"YES", "NO"};
        ArrayAdapter<String> iis_q54adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q54
        );
        AutoCompleteTextView iis_q54AutoCompleteTextView = findViewById(R.id.iis_q54Et);
        iis_q54AutoCompleteTextView.setAdapter(iis_q54adapter);


        //Q55
        q55spinner = findViewById(R.id.iis_q55Et);
        iis_q55pjEt = findViewById(R.id.iis_q55pjEt);

        iis_q55pjEt.setVisibility(View.GONE);
        String[] iis_q55 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q55adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q55
        );
        AutoCompleteTextView iis_q55AutoCompleteTextView = findViewById(R.id.iis_q55Et);
        iis_q55AutoCompleteTextView.setAdapter(iis_q55adapter);

        iis_q55AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q55pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q55pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q55pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q56
        q56spinner = findViewById(R.id.iis_q56Et);
        iis_q56pjEt = findViewById(R.id.iis_q56pjEt);

        iis_q56pjEt.setVisibility(View.GONE);
        String[] iis_q56 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q56adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q56
        );
        AutoCompleteTextView iis_q56AutoCompleteTextView = findViewById(R.id.iis_q56Et);
        iis_q56AutoCompleteTextView.setAdapter(iis_q56adapter);

        iis_q56AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q56pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q56pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q56pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q57
        q57spinner = findViewById(R.id.iis_q57Et);
        iis_q57pjEt = findViewById(R.id.iis_q57pjEt);

        iis_q57pjEt.setVisibility(View.GONE);
        String[] iis_q57 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q57adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q57
        );
        AutoCompleteTextView iis_q57AutoCompleteTextView = findViewById(R.id.iis_q57Et);
        iis_q57AutoCompleteTextView.setAdapter(iis_q57adapter);

        iis_q57AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q57pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q57pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q57pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q58
        q58spinner = findViewById(R.id.iis_q58Et);
        iis_q58pjEt = findViewById(R.id.iis_q58pjEt);

        iis_q58pjEt.setVisibility(View.GONE);
        String[] iis_q58 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q58adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q58
        );
        AutoCompleteTextView iis_q58AutoCompleteTextView = findViewById(R.id.iis_q58Et);
        iis_q58AutoCompleteTextView.setAdapter(iis_q58adapter);

        iis_q58AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q58pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q58pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q58pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q59
        q59spinner = findViewById(R.id.iis_q59Et);
        iis_q59pjEt = findViewById(R.id.iis_q59pjEt);

        iis_q59pjEt.setVisibility(View.GONE);
        String[] iis_q59 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q59adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q59
        );
        AutoCompleteTextView iis_q59AutoCompleteTextView = findViewById(R.id.iis_q59Et);
        iis_q59AutoCompleteTextView.setAdapter(iis_q59adapter);

        iis_q59AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q59pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q59pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q59pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q60
        q60spinner = findViewById(R.id.iis_q60Et);
        iis_q60pjEt = findViewById(R.id.iis_q60pjEt);

        iis_q60pjEt.setVisibility(View.GONE);
        String[] iis_q60 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q60adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q60
        );
        AutoCompleteTextView iis_q60AutoCompleteTextView = findViewById(R.id.iis_q60Et);
        iis_q60AutoCompleteTextView.setAdapter(iis_q60adapter);

        iis_q60AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q60pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q60pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q60pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q61
        q61spinner = findViewById(R.id.iis_q61Et);
        iis_q61pjEt = findViewById(R.id.iis_q61pjEt);

        iis_q61pjEt.setVisibility(View.GONE);
        String[] iis_q61 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q61adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q61
        );
        AutoCompleteTextView iis_q61AutoCompleteTextView = findViewById(R.id.iis_q61Et);
        iis_q61AutoCompleteTextView.setAdapter(iis_q61adapter);

        iis_q61AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q61pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q61pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q61pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q62
        q62spinner = findViewById(R.id.iis_q62Et);
        iis_q62pjEt = findViewById(R.id.iis_q62pjEt);

        iis_q62pjEt.setVisibility(View.GONE);
        String[] iis_q62 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q62adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q62
        );
        AutoCompleteTextView iis_q62AutoCompleteTextView = findViewById(R.id.iis_q62Et);
        iis_q62AutoCompleteTextView.setAdapter(iis_q62adapter);

        iis_q62AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q62pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q62pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q62pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q63
        q63spinner = findViewById(R.id.iis_q63Et);
        iis_q63pjEt = findViewById(R.id.iis_q63pjEt);

        iis_q63pjEt.setVisibility(View.GONE);
        String[] iis_q63 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q63adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q63
        );
        AutoCompleteTextView iis_q63AutoCompleteTextView = findViewById(R.id.iis_q63Et);
        iis_q63AutoCompleteTextView.setAdapter(iis_q63adapter);

        iis_q63AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q63pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q63pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q63pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q64
        q64spinner = findViewById(R.id.iis_q64Et);
        iis_q64pjEt = findViewById(R.id.iis_q64pjEt);

        iis_q64pjEt.setVisibility(View.GONE);
        String[] iis_q64 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q64adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q64
        );
        AutoCompleteTextView iis_q64AutoCompleteTextView = findViewById(R.id.iis_q64Et);
        iis_q64AutoCompleteTextView.setAdapter(iis_q64adapter);

        iis_q64AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q64pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q64pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q64pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q65
        q65spinner = findViewById(R.id.iis_q65Et);
        iis_q65pjEt = findViewById(R.id.iis_q65pjEt);

        iis_q65pjEt.setVisibility(View.GONE);
        String[] iis_q65 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q65adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q65
        );
        AutoCompleteTextView iis_q65AutoCompleteTextView = findViewById(R.id.iis_q65Et);
        iis_q65AutoCompleteTextView.setAdapter(iis_q65adapter);

        iis_q65AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q65pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q65pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q65pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q66
        q66spinner = findViewById(R.id.iis_q66Et);
        iis_q66pjEt = findViewById(R.id.iis_q66pjEt);

        iis_q66pjEt.setVisibility(View.GONE);
        String[] iis_q66 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q66adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q66
        );
        AutoCompleteTextView iis_q66AutoCompleteTextView = findViewById(R.id.iis_q66Et);
        iis_q66AutoCompleteTextView.setAdapter(iis_q66adapter);

        iis_q66AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q66pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q66pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q66pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q67
        q67spinner = findViewById(R.id.iis_q67Et);
        iis_q67pjEt = findViewById(R.id.iis_q67pjEt);

        iis_q67pjEt.setVisibility(View.GONE);
        String[] iis_q67 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q67adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q67
        );
        AutoCompleteTextView iis_q67AutoCompleteTextView = findViewById(R.id.iis_q67Et);
        iis_q67AutoCompleteTextView.setAdapter(iis_q67adapter);

        iis_q67AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q67pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q67pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q67pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q68
        q68spinner = findViewById(R.id.iis_q68Et);
        iis_q68pjEt = findViewById(R.id.iis_q68pjEt);

        iis_q68pjEt.setVisibility(View.GONE);
        String[] iis_q68 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q68adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q68
        );
        AutoCompleteTextView iis_q68AutoCompleteTextView = findViewById(R.id.iis_q68Et);
        iis_q68AutoCompleteTextView.setAdapter(iis_q68adapter);

        iis_q68AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q68pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q68pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q68pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q69
        q69spinner = findViewById(R.id.iis_q69Et);
        iis_q69pjEt = findViewById(R.id.iis_q69pjEt);

        iis_q69pjEt.setVisibility(View.GONE);
        String[] iis_q69 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q69adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q69
        );
        AutoCompleteTextView iis_q69AutoCompleteTextView = findViewById(R.id.iis_q69Et);
        iis_q69AutoCompleteTextView.setAdapter(iis_q69adapter);

        iis_q69AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q69pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q69pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q69pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q70
        q70spinner = findViewById(R.id.iis_q70Et);
        iis_q70pjEt = findViewById(R.id.iis_q70pjEt);

        iis_q70pjEt.setVisibility(View.GONE);
        String[] iis_q70 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q70adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q70
        );
        AutoCompleteTextView iis_q70AutoCompleteTextView = findViewById(R.id.iis_q70Et);
        iis_q70AutoCompleteTextView.setAdapter(iis_q70adapter);

        iis_q70AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q70pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q70pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q70pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q71
        q71spinner = findViewById(R.id.iis_q71Et);
        iis_q71pjEt = findViewById(R.id.iis_q71pjEt);

        iis_q71pjEt.setVisibility(View.GONE);
        String[] iis_q71 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q71adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q71
        );
        AutoCompleteTextView iis_q71AutoCompleteTextView = findViewById(R.id.iis_q71Et);
        iis_q71AutoCompleteTextView.setAdapter(iis_q71adapter);

        iis_q71AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q71pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q71pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q71pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q72
        q72spinner = findViewById(R.id.iis_q72Et);
        iis_q72pjEt = findViewById(R.id.iis_q72pjEt);

        iis_q72pjEt.setVisibility(View.GONE);
        String[] iis_q72 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q72adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q72
        );
        AutoCompleteTextView iis_q72AutoCompleteTextView = findViewById(R.id.iis_q72Et);
        iis_q72AutoCompleteTextView.setAdapter(iis_q72adapter);

        iis_q72AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q72pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q72pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q72pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q73
        q73spinner = findViewById(R.id.iis_q73Et);
        iis_q73pjEt = findViewById(R.id.iis_q73pjEt);

        iis_q73pjEt.setVisibility(View.GONE);
        String[] iis_q73 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q73adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q73
        );
        AutoCompleteTextView iis_q73AutoCompleteTextView = findViewById(R.id.iis_q73Et);
        iis_q73AutoCompleteTextView.setAdapter(iis_q73adapter);

        iis_q73AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q73pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q73pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q73pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q74
        q74spinner = findViewById(R.id.iis_q74Et);
        iis_q74pjEt = findViewById(R.id.iis_q74pjEt);

        iis_q74pjEt.setVisibility(View.GONE);
        String[] iis_q74 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q74adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q74
        );
        AutoCompleteTextView iis_q74AutoCompleteTextView = findViewById(R.id.iis_q74Et);
        iis_q74AutoCompleteTextView.setAdapter(iis_q74adapter);

        iis_q74AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q74pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q74pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q74pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q75
        q75spinner = findViewById(R.id.iis_q75Et);
        iis_q75pjEt = findViewById(R.id.iis_q75pjEt);

        iis_q75pjEt.setVisibility(View.GONE);
        String[] iis_q75 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q75adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q75
        );
        AutoCompleteTextView iis_q75AutoCompleteTextView = findViewById(R.id.iis_q75Et);
        iis_q75AutoCompleteTextView.setAdapter(iis_q75adapter);

        iis_q75AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q75pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q75pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q75pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q76
        q76spinner = findViewById(R.id.iis_q76Et);
        iis_q76pjEt = findViewById(R.id.iis_q76pjEt);

        iis_q76pjEt.setVisibility(View.GONE);
        String[] iis_q76 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q76adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q76
        );
        AutoCompleteTextView iis_q76AutoCompleteTextView = findViewById(R.id.iis_q76Et);
        iis_q76AutoCompleteTextView.setAdapter(iis_q76adapter);

        iis_q76AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q76pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q76pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q76pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q77
        q77spinner = findViewById(R.id.iis_q77Et);
        iis_q77pjEt = findViewById(R.id.iis_q77pjEt);

        iis_q77pjEt.setVisibility(View.GONE);
        String[] iis_q77 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q77adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q77
        );
        AutoCompleteTextView iis_q77AutoCompleteTextView = findViewById(R.id.iis_q77Et);
        iis_q77AutoCompleteTextView.setAdapter(iis_q77adapter);

        iis_q77AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q77pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q77pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q77pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q78
        q78spinner = findViewById(R.id.iis_q78Et);
        iis_q78pjEt = findViewById(R.id.iis_q78pjEt);

        iis_q78pjEt.setVisibility(View.GONE);
        String[] iis_q78 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q78adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q78
        );
        AutoCompleteTextView iis_q78AutoCompleteTextView = findViewById(R.id.iis_q78Et);
        iis_q78AutoCompleteTextView.setAdapter(iis_q78adapter);

        iis_q78AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q78pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q78pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q78pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q79
        q79spinner = findViewById(R.id.iis_q79Et);
        iis_q79pjEt = findViewById(R.id.iis_q79pjEt);

        iis_q79pjEt.setVisibility(View.GONE);
        String[] iis_q79 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q79adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q79
        );
        AutoCompleteTextView iis_q79AutoCompleteTextView = findViewById(R.id.iis_q79Et);
        iis_q79AutoCompleteTextView.setAdapter(iis_q79adapter);

        iis_q79AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q79pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q79pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q79pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q80
        q80spinner = findViewById(R.id.iis_q80Et);
        iis_q80pjEt = findViewById(R.id.iis_q80pjEt);

        iis_q80pjEt.setVisibility(View.GONE);
        String[] iis_q80 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q80adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q80
        );
        AutoCompleteTextView iis_q80AutoCompleteTextView = findViewById(R.id.iis_q80Et);
        iis_q80AutoCompleteTextView.setAdapter(iis_q80adapter);

        iis_q80AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q80pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q80pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q80pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q81
        q81spinner = findViewById(R.id.iis_q81Et);
        iis_q81pjEt = findViewById(R.id.iis_q81pjEt);

        iis_q81pjEt.setVisibility(View.GONE);
        String[] iis_q81 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q81adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q81
        );
        AutoCompleteTextView iis_q81AutoCompleteTextView = findViewById(R.id.iis_q81Et);
        iis_q81AutoCompleteTextView.setAdapter(iis_q81adapter);

        iis_q81AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q81pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q81pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q81pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q82
        q82spinner = findViewById(R.id.iis_q82Et);
        iis_q82pjEt = findViewById(R.id.iis_q82pjEt);

        iis_q82pjEt.setVisibility(View.GONE);
        String[] iis_q82 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q82adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q82
        );
        AutoCompleteTextView iis_q82AutoCompleteTextView = findViewById(R.id.iis_q82Et);
        iis_q82AutoCompleteTextView.setAdapter(iis_q82adapter);

        iis_q82AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q82pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q82pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q82pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q83
        q83spinner = findViewById(R.id.iis_q83Et);
        iis_q83pjEt = findViewById(R.id.iis_q83pjEt);

        iis_q83pjEt.setVisibility(View.GONE);
        String[] iis_q83 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q83adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q83
        );
        AutoCompleteTextView iis_q83AutoCompleteTextView = findViewById(R.id.iis_q83Et);
        iis_q83AutoCompleteTextView.setAdapter(iis_q83adapter);

        iis_q83AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q83pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q83pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q83pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q84
        q84spinner = findViewById(R.id.iis_q84Et);
        iis_q84pjEt = findViewById(R.id.iis_q84pjEt);

        iis_q84pjEt.setVisibility(View.GONE);
        String[] iis_q84 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q84adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q84
        );
        AutoCompleteTextView iis_q84AutoCompleteTextView = findViewById(R.id.iis_q84Et);
        iis_q84AutoCompleteTextView.setAdapter(iis_q84adapter);

        iis_q84AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q84pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q84pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q84pjEt.setVisibility(View.VISIBLE);
                }
            }
        });


        //Q85
        q85spinner = findViewById(R.id.iis_q85Et);
        iis_q85pjEt = findViewById(R.id.iis_q85pjEt);

        iis_q85pjEt.setVisibility(View.GONE);
        String[] iis_q85 = new String[]{"Yes", "No", "NA"};
        ArrayAdapter<String> iis_q85adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdown,
                iis_q85
        );
        AutoCompleteTextView iis_q85AutoCompleteTextView = findViewById(R.id.iis_q85Et);
        iis_q85AutoCompleteTextView.setAdapter(iis_q85adapter);

        iis_q85AutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.trim().equals("Yes")) {
                    iis_q85pjEt.setVisibility(View.GONE);
                }
                if (selectedItem.trim().equals("No")) {
                    iis_q85pjEt.setVisibility(View.VISIBLE);
                }
                if (selectedItem.trim().equals("NA")) {
                    iis_q85pjEt.setVisibility(View.VISIBLE);
                }
            }
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

        iisTwoPreviousBtn.setOnClickListener(v -> {
            Toast.makeText(ProfileExistingFarmerTwoFIIS.this, "Use your phone back key", Toast.LENGTH_SHORT).show();
//            Intent previousIntent = new Intent(ProfileExistingFarmerTwoFIIS.this, ProfileExistingFarmerOneFIIS.class);
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
//            startActivity(previousIntent);
        });

        iisTwoNextBtn.setOnClickListener(v -> {
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
            //String questionfiis65 = iis_q53pjEt.getText().toString().trim();
            String questionfiis66 = iis_q54Et.getText().toString().trim();
            //String questionfiis67 = iis_q54pjEt.getText().toString().trim();
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

            Intent nextIntent = new Intent(ProfileExistingFarmerTwoFIIS.this, ProfileExistingFarmerThreeFIIS.class);
            nextIntent.putExtra("QUESTIONFIIS1", questionfiis1);
            nextIntent.putExtra("QUESTIONFIIS2", questionfiis2);
            nextIntent.putExtra("QUESTIONFIIS3", questionfiis3);
            nextIntent.putExtra("QUESTIONFIIS4", questionfiis4);
            nextIntent.putExtra("QUESTIONFIIS5", questionfiis5);
            nextIntent.putExtra("QUESTIONFIIS6", questionfiis6);
            nextIntent.putExtra("QUESTIONFIIS7", questionfiis7);
            nextIntent.putExtra("QUESTIONFIIS8", questionfiis8);
            nextIntent.putExtra("QUESTIONFIIS9", questionfiis9);
            nextIntent.putExtra("QUESTIONFIIS10", questionfiis10);
            nextIntent.putExtra("QUESTIONFIIS11", questionfiis11);
            nextIntent.putExtra("QUESTIONFIIS12", questionfiis12);
            nextIntent.putExtra("QUESTIONFIIS13", questionfiis13);
            nextIntent.putExtra("QUESTIONFIIS14", questionfiis14);
            nextIntent.putExtra("QUESTIONFIIS15", questionfiis15);
            nextIntent.putExtra("QUESTIONFIIS16", questionfiis16);
            nextIntent.putExtra("QUESTIONFIIS17", questionfiis17);
            nextIntent.putExtra("QUESTIONFIIS18", questionfiis18);
            nextIntent.putExtra("QUESTIONFIIS19", questionfiis19);
            nextIntent.putExtra("QUESTIONFIIS20", questionfiis20);
            nextIntent.putExtra("QUESTIONFIIS21", questionfiis21);
            nextIntent.putExtra("QUESTIONFIIS22", questionfiis22);
            nextIntent.putExtra("QUESTIONFIIS23", questionfiis23);
            nextIntent.putExtra("QUESTIONFIIS24", questionfiis24);
            nextIntent.putExtra("QUESTIONFIIS25", questionfiis25);
            nextIntent.putExtra("QUESTIONFIIS26", questionfiis26);
            nextIntent.putExtra("QUESTIONFIIS27", questionfiis27);
            nextIntent.putExtra("QUESTIONFIIS28", questionfiis28);
            nextIntent.putExtra("QUESTIONFIIS29", questionfiis29);
            nextIntent.putExtra("QUESTIONFIIS30", questionfiis30);
            nextIntent.putExtra("QUESTIONFIIS31", questionfiis31);
            nextIntent.putExtra("QUESTIONFIIS32", questionfiis32);
            nextIntent.putExtra("QUESTIONFIIS33", questionfiis33);
            nextIntent.putExtra("QUESTIONFIIS34", questionfiis34);
            nextIntent.putExtra("QUESTIONFIIS35", questionfiis35);
            nextIntent.putExtra("QUESTIONFIIS36", questionfiis36);
            nextIntent.putExtra("QUESTIONFIIS37", questionfiis37);
            nextIntent.putExtra("QUESTIONFIIS38", questionfiis38);
            nextIntent.putExtra("QUESTIONFIIS39", questionfiis39);
            nextIntent.putExtra("QUESTIONFIIS40", questionfiis40);
            nextIntent.putExtra("QUESTIONFIIS41", questionfiis41);
            nextIntent.putExtra("QUESTIONFIIS42", questionfiis42);
            nextIntent.putExtra("QUESTIONFIIS43", questionfiis43);
            nextIntent.putExtra("QUESTIONFIIS44", questionfiis44);
            nextIntent.putExtra("QUESTIONFIIS45", questionfiis45);
            nextIntent.putExtra("QUESTIONFIIS46", questionfiis46);
            nextIntent.putExtra("QUESTIONFIIS47", questionfiis47);
            nextIntent.putExtra("QUESTIONFIIS48", questionfiis48);
            nextIntent.putExtra("QUESTIONFIIS49", questionfiis49);
            nextIntent.putExtra("QUESTIONFIIS50", questionfiis50);
            nextIntent.putExtra("QUESTIONFIIS51", questionfiis51);
            nextIntent.putExtra("QUESTIONFIIS52", questionfiis52);
            nextIntent.putExtra("QUESTIONFIIS53", questionfiis53);
            nextIntent.putExtra("QUESTIONFIIS54", questionfiis54);
            nextIntent.putExtra("QUESTIONFIIS55", questionfiis55);
            nextIntent.putExtra("QUESTIONFIIS56", questionfiis56);
            nextIntent.putExtra("QUESTIONFIIS57", questionfiis57);
            nextIntent.putExtra("QUESTIONFIIS58", questionfiis58);
            nextIntent.putExtra("QUESTIONFIIS59", questionfiis59);
            nextIntent.putExtra("QUESTIONFIIS60", questionfiis60);
            nextIntent.putExtra("QUESTIONFIIS61", questionfiis61);
            nextIntent.putExtra("QUESTIONFIIS62", questionfiis62);
            nextIntent.putExtra("QUESTIONFIIS63", questionfiis63);
            nextIntent.putExtra("QUESTIONFIIS64", questionfiis64);
            //nextIntent.putExtra("QUESTIONFIIS65", questionfiis65);
            nextIntent.putExtra("QUESTIONFIIS66", questionfiis66);
            //nextIntent.putExtra("QUESTIONFIIS67", questionfiis67);
            nextIntent.putExtra("QUESTIONFIIS68", questionfiis68);
            nextIntent.putExtra("QUESTIONFIIS69", questionfiis69);
            nextIntent.putExtra("QUESTIONFIIS70", questionfiis70);
            nextIntent.putExtra("QUESTIONFIIS71", questionfiis71);
            nextIntent.putExtra("QUESTIONFIIS72", questionfiis72);
            nextIntent.putExtra("QUESTIONFIIS73", questionfiis73);
            nextIntent.putExtra("QUESTIONFIIS74", questionfiis74);
            nextIntent.putExtra("QUESTIONFIIS75", questionfiis75);
            nextIntent.putExtra("QUESTIONFIIS76", questionfiis76);
            nextIntent.putExtra("QUESTIONFIIS77", questionfiis77);
            nextIntent.putExtra("QUESTIONFIIS78", questionfiis78);
            nextIntent.putExtra("QUESTIONFIIS79", questionfiis79);
            nextIntent.putExtra("QUESTIONFIIS80", questionfiis80);
            nextIntent.putExtra("QUESTIONFIIS81", questionfiis81);
            nextIntent.putExtra("QUESTIONFIIS82", questionfiis82);
            nextIntent.putExtra("QUESTIONFIIS83", questionfiis83);
            nextIntent.putExtra("QUESTIONFIIS84", questionfiis84);
            nextIntent.putExtra("QUESTIONFIIS85", questionfiis85);
            nextIntent.putExtra("QUESTIONFIIS86", questionfiis86);
            nextIntent.putExtra("QUESTIONFIIS87", questionfiis87);
            nextIntent.putExtra("QUESTIONFIIS88", questionfiis88);
            nextIntent.putExtra("QUESTIONFIIS89", questionfiis89);
            nextIntent.putExtra("QUESTIONFIIS90", questionfiis90);
            nextIntent.putExtra("QUESTIONFIIS91", questionfiis91);
            nextIntent.putExtra("QUESTIONFIIS92", questionfiis92);
            nextIntent.putExtra("QUESTIONFIIS93", questionfiis93);
            nextIntent.putExtra("QUESTIONFIIS94", questionfiis94);
            nextIntent.putExtra("QUESTIONFIIS95", questionfiis95);
            nextIntent.putExtra("QUESTIONFIIS96", questionfiis96);
            nextIntent.putExtra("QUESTIONFIIS97", questionfiis97);
            nextIntent.putExtra("QUESTIONFIIS98", questionfiis98);
            nextIntent.putExtra("QUESTIONFIIS99", questionfiis99);
            nextIntent.putExtra("QUESTIONFIIS100", questionfiis100);
            nextIntent.putExtra("QUESTIONFIIS101", questionfiis101);
            nextIntent.putExtra("QUESTIONFIIS102", questionfiis102);
            nextIntent.putExtra("QUESTIONFIIS103", questionfiis103);
            nextIntent.putExtra("QUESTIONFIIS104", questionfiis104);
            nextIntent.putExtra("QUESTIONFIIS105", questionfiis105);
            nextIntent.putExtra("QUESTIONFIIS106", questionfiis106);
            nextIntent.putExtra("QUESTIONFIIS107", questionfiis107);
            nextIntent.putExtra("QUESTIONFIIS108", questionfiis108);
            nextIntent.putExtra("QUESTIONFIIS109", questionfiis109);
            nextIntent.putExtra("QUESTIONFIIS110", questionfiis110);
            nextIntent.putExtra("QUESTIONFIIS111", questionfiis111);
            nextIntent.putExtra("QUESTIONFIIS112", questionfiis112);
            nextIntent.putExtra("QUESTIONFIIS113", questionfiis113);
            nextIntent.putExtra("QUESTIONFIIS114", questionfiis114);
            nextIntent.putExtra("QUESTIONFIIS115", questionfiis115);
            nextIntent.putExtra("QUESTIONFIIS116", questionfiis116);
            nextIntent.putExtra("QUESTIONFIIS117", questionfiis117);
            nextIntent.putExtra("QUESTIONFIIS118", questionfiis118);
            nextIntent.putExtra("QUESTIONFIIS119", questionfiis119);
            nextIntent.putExtra("QUESTIONFIIS120", questionfiis120);
            nextIntent.putExtra("QUESTIONFIIS121", questionfiis121);
            nextIntent.putExtra("QUESTIONFIIS122", questionfiis122);
            nextIntent.putExtra("QUESTIONFIIS123", questionfiis123);
            nextIntent.putExtra("QUESTIONFIIS124", questionfiis124);
            nextIntent.putExtra("QUESTIONFIIS125", questionfiis125);
            nextIntent.putExtra("QUESTIONFIIS126", questionfiis126);
            nextIntent.putExtra("QUESTIONFIIS127", questionfiis127);
            nextIntent.putExtra("QUESTIONFIIS128", questionfiis128);
            nextIntent.putExtra("QUESTIONFIIS129", questionfiis129);

            startActivity(nextIntent);
        });
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.farmer_profiling);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}