package com.jacob.fruitoftek.safecrop.login.utils;

import android.app.Activity;

import org.json.JSONException;
import org.json.JSONObject;

public class ParseContent {
    private final String KEY_SUCCESS = "status";
    private final String KEY_MSG = "message";
    private final String KEY_DATA = "user";
    private final Activity activity;
    private final PreferenceHelper preferenceHelper;

    public ParseContent(Activity activity) {
        this.activity = activity;
        this.preferenceHelper = new PreferenceHelper(activity);
    }

    public boolean isSuccess(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            return jsonObject.optString(KEY_SUCCESS).equalsIgnoreCase("success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getErrorMessage(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            return jsonObject.getString(KEY_MSG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "No data";
    }

    public void saveInfo(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(KEY_SUCCESS).equalsIgnoreCase("success")) {
                JSONObject userData = jsonObject.getJSONObject(KEY_DATA);
                preferenceHelper.saveUserData(userData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

