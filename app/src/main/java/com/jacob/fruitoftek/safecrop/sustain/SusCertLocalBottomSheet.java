package com.jacob.fruitoftek.safecrop.sustain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.sustain.gmrs.GMRDbHelper;

public class SusCertLocalBottomSheet extends BottomSheetDialogFragment {

    private GMRDbHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_sus_cert_local, container, false);

        dbHelper = new GMRDbHelper(getActivity());

        ImageView closeLocalBackupBtn = view.findViewById(R.id.closeLocalBackupBtn);
        closeLocalBackupBtn.setOnClickListener(v -> dismiss());

        TextView scbsLocalBackupProfilingTv = view.findViewById(R.id.scbsLocalBackupProfilingTv);
        TextView scbsLocalBackupInspectionTv = view.findViewById(R.id.scbsLocalBackupInspectionTv);
        TextView scbsLocalBackupTrainingTv = view.findViewById(R.id.scbsLocalBackupTrainingTv);

        scbsLocalBackupProfilingTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkPermissionsAndExport();
            }
        });

        return view;
    }
}
