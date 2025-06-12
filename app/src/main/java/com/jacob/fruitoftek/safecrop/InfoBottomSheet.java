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
import com.jacob.fruitoftek.safecrop.comdev.cra.SurveyedCraActivity;
import com.jacob.fruitoftek.safecrop.comdev.cra.SyncCraInfoActivity;
import com.jacob.fruitoftek.safecrop.comdev.gra.SurveyedGraActivity;
import com.jacob.fruitoftek.safecrop.comdev.gra.SyncGraInfoActivity;
import com.jacob.fruitoftek.safecrop.sustain.pentry.PEActivity;
import com.jacob.fruitoftek.safecrop.sustain.pentry.PEDoneActivity;
import com.jacob.fruitoftek.safecrop.sustain.pentry.PEInfoActivity;
import com.jacob.fruitoftek.safecrop.sustain.pentry.PEnteryDetailsActivity;
import com.jacob.fruitoftek.safecrop.sustain.profiling.GMRProfiledFarmersListActivity;
import com.jacob.fruitoftek.safecrop.sustain.profiling.GMRSurveyInfoActivity;

public class InfoBottomSheet extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_bottom_sheet, container, false);

        ImageView btnClose = view.findViewById(R.id.closeInfoBtn);
        btnClose.setOnClickListener(v -> dismiss());

//        TextView profilingTv = view.findViewById(R.id.ibsFarmerProfilingTv);
//        profilingTv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), GMRProfiledFarmersListActivity.class));});
//        TextView viewInspectionTv = view.findViewById(R.id.ibsInspectionSurveyTv);
//        viewInspectionTv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), InspectedFarmersWebActivity.class));});

        TextView profilingTv = view.findViewById(R.id.ibsFarmerProfilingTv);
        ImageView ibsprofilingIV = view.findViewById(R.id.ibsFarmerProfilingIV);
        profilingTv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), GMRProfiledFarmersListActivity.class));});
        ibsprofilingIV.setOnClickListener(v -> { startActivity(new Intent(getActivity(), GMRSurveyInfoActivity.class));});

        TextView ibsPETv = view.findViewById(R.id.ibsPETv);
        ImageView ibsPEIV = view.findViewById(R.id.ibsPEIV);
        ibsPETv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), PEDoneActivity.class));});
        ibsPEIV.setOnClickListener(v -> { startActivity(new Intent(getActivity(), PEInfoActivity.class));});

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

//        TextView viewTSTTv = view.findViewById(R.id.ibsTSTTv);
//        ImageView ibsTSTIV = view.findViewById(R.id.ibsTSTIV);
//        viewTSTTv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SurveyedGraActivity.class));});
//        ibsTSTIV.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SyncGraInfoActivity.class));});

        TextView viewibsCRATv = view.findViewById(R.id.ibsCRATv);
        ImageView ibsCRAIV = view.findViewById(R.id.ibsCRAIV);
        viewibsCRATv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SurveyedCraActivity.class));});
        ibsCRAIV.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SyncCraInfoActivity.class));});

        TextView viewibsCFLRATv = view.findViewById(R.id.ibsCFLRATv);
        ImageView ibsCFLRAIV = view.findViewById(R.id.ibsCFLRAIV);
        viewibsCFLRATv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SurveyedGraActivity.class));});
        ibsCFLRAIV.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SyncGraInfoActivity.class));});

        TextView viewibsGRATv = view.findViewById(R.id.ibsGRATv);
        ImageView ibsGRAIV = view.findViewById(R.id.ibsGRAIV);
        viewibsGRATv.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SurveyedGraActivity.class));});
        ibsGRAIV.setOnClickListener(v -> { startActivity(new Intent(getActivity(), SyncGraInfoActivity.class));});

        return view;
    }
}