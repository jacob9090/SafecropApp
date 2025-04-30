package com.jacob.fruitoftek.safecrop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ExitBottomSheet extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exit_bottom_sheet, container, false);

        Button btnExit = view.findViewById(R.id.btnExit);
        btnExit.setOnClickListener(v -> {
            requireActivity().finish();
        });

        Button btnCancel = view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(v -> dismiss());

        ImageView btnClose = view.findViewById(R.id.closeBtn);
        btnClose.setOnClickListener(v -> dismiss());

        return view;
    }
}
