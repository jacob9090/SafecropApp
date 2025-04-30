package com.jacob.fruitoftek.safecrop.farmertrain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jacob.fruitoftek.safecrop.R;

public class TrainCloudBottomSheet extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_train_cloud_bottom_sheet, container, false);

//        ImageView closeCloudBackupBtn = view.findViewById(R.id.comDevCloudCloseBackupBtn);
//        closeCloudBackupBtn.setOnClickListener(v -> dismiss());

        return view;
    }
}