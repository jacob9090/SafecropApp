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

//        dbHelper = new ChildSurveyDBHelper(getActivity());
//
//        ImageView closeLocalBackupBtn = view.findViewById(R.id.comDevLocalCloseBackupBtn);
//        closeLocalBackupBtn.setOnClickListener(v -> dismiss());
//
//        TextView cdbsCloudBackupChTv = view.findViewById(R.id.cdbsCloudBackupChTv);
//
//        cdbsCloudBackupChTv.setOnClickListener(v -> exportToCSV());

        return view;
    }

//    private void exportToCSV() {
//        new Thread(() -> {
//            List<ChildModel> childList = dbHelper.getAllSurveys();
//            File csvBackupDir = getActivity().getExternalFilesDir("CSVBackup");
//
//            if (csvBackupDir != null && !csvBackupDir.exists()) {
//                csvBackupDir.mkdirs();
//            }
//
//            File csvFile = new File(csvBackupDir, "ChildSurveyBackup.csv");
//
//            try (FileWriter writer = new FileWriter(csvFile)) {
//                // Write the header
//                writer.append("Farmer ID,Farmer District,Farmer Village,Child Location,User First Name,User Other Name,Created On,Updated On,Signature Path\n");
//
//                for (ChildModel child : childList) {
//                    writer.append(escapeCSV(child.getFarmerId())).append(',')
//                            .append(escapeCSV(child.getFarmerDistrict())).append(',')
//                            .append(escapeCSV(child.getFarmerVillage())).append(',')
//                            .append(escapeCSV(child.getChildLocation())).append(',')
//                            .append(escapeCSV(child.getUserFname())).append(',')
//                            .append(escapeCSV(child.getUserLname())).append(',')
//                            .append(escapeCSV(child.getOnCreate())).append(',')
//                            .append(escapeCSV(child.getOnUpdate())).append(',')
//                            .append(escapeCSV(child.getSignature())).append('\n');
//                }
//
//                getActivity().runOnUiThread(() -> {
//                    Toast.makeText(getActivity(), "CSV Exported Successfully to " + csvFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
//                });
//
//            } catch (IOException e) {
//                getActivity().runOnUiThread(() -> {
//                    Toast.makeText(getActivity(), "Failed to export CSV: " + e.getMessage(), Toast.LENGTH_LONG).show();
//                });
//            }
//        }).start();
//    }
//
//    private String escapeCSV(String value) {
//        if (value == null) {
//            return "";
//        }
//        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
//            value = value.replace("\"", "\"\"");
//            return "\"" + value + "\"";
//        }
//        return value;
//    }
}