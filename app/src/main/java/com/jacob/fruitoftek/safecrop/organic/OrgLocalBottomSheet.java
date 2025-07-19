package com.jacob.fruitoftek.safecrop.organic;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jacob.fruitoftek.safecrop.R;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class OrgLocalBottomSheet extends BottomSheetDialogFragment {

//    private ChildSurveyDBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_org_local_bottom_sheet, container, false);

        return view;
    }
}