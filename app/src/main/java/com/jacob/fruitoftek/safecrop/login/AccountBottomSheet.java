package com.jacob.fruitoftek.safecrop.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jacob.fruitoftek.safecrop.R;
import com.jacob.fruitoftek.safecrop.login.utils.PreferenceHelper;

import java.util.HashMap;
import java.util.Map;

public class AccountBottomSheet extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_bottom_sheet, container, false);

        ImageView btnClose = view.findViewById(R.id.closeAccountBtn);
        btnClose.setOnClickListener(v -> dismiss());

        PreferenceHelper preferenceHelper = new PreferenceHelper(getActivity());

        // Use a map to store references to frequently accessed views
        Map<Integer, View> viewMap = new HashMap<>();
        viewMap.put(R.id.userNameTV, view.findViewById(R.id.userNameTV));
        viewMap.put(R.id.userLNameTV, view.findViewById(R.id.userLNameTV));
        viewMap.put(R.id.userDistrictTV, view.findViewById(R.id.userDistrictTV));
        viewMap.put(R.id.userPhoneTV, view.findViewById(R.id.userPhoneTV));
        viewMap.put(R.id.userEmailTV, view.findViewById(R.id.userEmailTV));

        // Retrieve user data from PreferenceHelper once
        String firstName = preferenceHelper.getFirstName();
        String lastName = preferenceHelper.getLastName();
        String phone = preferenceHelper.getPhone();
        String district = preferenceHelper.getDistrict();
        String email = preferenceHelper.getEmail();

        // Set the text for TextViews using the stored data
        TextView tvUserName = (TextView) viewMap.get(R.id.userNameTV);
        TextView tvUserName2 = (TextView) viewMap.get(R.id.userLNameTV);
        TextView tvUserPhone = (TextView) viewMap.get(R.id.userPhoneTV);
        TextView tvUserDistrict = (TextView) viewMap.get(R.id.userDistrictTV);
        TextView tvUserEmail = (TextView) viewMap.get(R.id.userEmailTV);

        if (tvUserName != null) {
            tvUserName.setText(firstName);
        } else {
            Log.e("AccountBottomSheet", "First name is null");
        }

        if (tvUserName2 != null) {
            tvUserName2.setText(lastName);
        } else {
            Log.e("AccountBottomSheet", "Last name is null");
        }

        if (tvUserPhone != null) {
            tvUserPhone.setText(phone);
        } else {
            Log.e("AccountBottomSheet", "Phone No. is null");
        }

        if (tvUserDistrict != null) {
            tvUserDistrict.setText(district);
        } else {
            Log.e("AccountBottomSheet", "District is null");
        }

        if (tvUserEmail != null) {
            tvUserEmail.setText(email);
        } else {
            Log.e("AccountBottomSheet", "Email is null");
        }

        // Find the button from the layout
        Button logOutBtn = view.findViewById(R.id.logOutBtn);

        // Set an OnClickListener to handle the button click
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the session or preferences to log the user out
                clearUserSession();

                // Navigate back to the LoginActivity
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);

                dismiss(); // Dismiss the bottom sheet
            }
        });

        return view;
    }

    private void clearUserSession() {
        PreferenceHelper preferenceHelper = new PreferenceHelper(getActivity());
        preferenceHelper.putIsLogin(false);  // Set login status to false
        preferenceHelper.clearUserInfo();    // Clear stored user information
    }
}