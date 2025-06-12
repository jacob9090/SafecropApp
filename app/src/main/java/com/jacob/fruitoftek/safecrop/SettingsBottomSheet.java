package com.jacob.fruitoftek.safecrop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jacob.fruitoftek.safecrop.farmerlist.FarmerListActivity;
import com.jacob.fruitoftek.safecrop.sustain.traintopic.TrainingListActivity;

public class SettingsBottomSheet extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_bottom_sheet, container, false);

        Button updateFarmerListBtn = view.findViewById(R.id.updateFarmerListBtn);
        Button updateTrainingListBtn = view.findViewById(R.id.updateTrainingListBtn);
        TextView sbsReportBugTv = view.findViewById(R.id.sbsReportBugTv);

        updateFarmerListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateFarmerListIntent = new Intent(getActivity(), FarmerListActivity.class);
                startActivity(updateFarmerListIntent);
            }
        });

        updateTrainingListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateTrainingListIntent = new Intent(getActivity(), TrainingListActivity.class);
                startActivity(updateTrainingListIntent);
            }
        });

        sbsReportBugTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reportBugIntent = new Intent(getActivity(), ReportBugActivity.class);
                startActivity(reportBugIntent);
            }
        });

//        LabeledSwitch labeledSwitch = findViewById(R.id.switch);
//        labeledSwitch.setOnToggledListener(new OnToggledListener() {
//            @Override
//            public void onSwitched(LabeledSwitch labeledSwitch, boolean isOn) {
//                // Implement your switching logic here
//            }
//        });

        ImageView btnClose = view.findViewById(R.id.closeSettingsBtn);
        btnClose.setOnClickListener(v -> dismiss());

        return view;
    }

}