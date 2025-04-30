package com.jacob.fruitoftek.safecrop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jacob.fruitoftek.safecrop.comdev.ch.ChildWebSurveyedListActivity;
import com.jacob.fruitoftek.safecrop.comdev.ch.SyncChildInfoActivity;
import com.jacob.fruitoftek.safecrop.comdev.com.SurveyedCommunitiesActivity;
import com.jacob.fruitoftek.safecrop.comdev.com.SyncComInfoActivity;
import com.jacob.fruitoftek.safecrop.comdev.hh.SurveyedHouseHoldActivity;
import com.jacob.fruitoftek.safecrop.comdev.hh.SyncHhInfoActivity;
import com.jacob.fruitoftek.safecrop.comdev.obs.SurveyedObservationActivity;
import com.jacob.fruitoftek.safecrop.comdev.obs.SyncObsInfoActivity;
import com.jacob.fruitoftek.safecrop.comdev.sch.SurveyedSchoolsActivity;
import com.jacob.fruitoftek.safecrop.comdev.sch.SyncSchoolInfoActivity;

public class InfoBottomSheet extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_bottom_sheet, container, false);

        ImageView btnClose = view.findViewById(R.id.closeInfoBtn);
        btnClose.setOnClickListener(v -> dismiss());

//        TextView profilingTv = view.findViewById(R.id.ibsFarmerProfilingTv);
//        TextView viewInspectionTv = view.findViewById(R.id.ibsInspectionSurveyTv);
//        profilingTv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), GMRProfiledFarmersListActivity.class));});
//        viewInspectionTv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), InspectedFarmersWebActivity.class));});

        TextView viewComSuvTv = view.findViewById(R.id.ibsComSurveyTv);
        ImageView ibsComSurveyIV = view.findViewById(R.id.ibsComSurveyIV);
        viewComSuvTv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SurveyedCommunitiesActivity.class));});
        ibsComSurveyIV.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SyncComInfoActivity.class));});

        TextView viewSchTv = view.findViewById(R.id.ibsSchSurveyTv);
        ImageView ibsSchSurveyIV = view.findViewById(R.id.ibsSchSurveyIV);
        viewSchTv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SurveyedSchoolsActivity.class));});
        ibsSchSurveyIV.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SyncSchoolInfoActivity.class));});

        TextView viewHhTv = view.findViewById(R.id.ibsHouseholdSurveyTv);
        ImageView ibsHouseholdSurveyIV = view.findViewById(R.id.ibsHouseholdSurveyIV);
        viewHhTv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SurveyedHouseHoldActivity.class));});
        ibsHouseholdSurveyIV.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SyncHhInfoActivity.class));});

        TextView viewObsTv = view.findViewById(R.id.ibsObservationSurveyTv);
        ImageView ibsObservationSurveyIV = view.findViewById(R.id.ibsObservationSurveyIV);
        viewObsTv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SurveyedObservationActivity.class));});
        ibsObservationSurveyIV.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SyncObsInfoActivity.class));});

        TextView viewChTv = view.findViewById(R.id.ibsChildSurveyTv);
        ImageView ibsChildSurveyIV = view.findViewById(R.id.ibsChildSurveyIV);
        viewChTv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), ChildWebSurveyedListActivity.class));});
        ibsChildSurveyIV.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SyncChildInfoActivity.class));});

        return view;
    }
}