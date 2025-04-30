package com.jacob.fruitoftek.safecrop.login.utils;

import android.app.Activity;

import org.json.JSONException;
import org.json.JSONObject;

public class ParseContent {

    private final String KEY_SUCCESS = "status";
    private final String KEY_MSG = "message";
    private final String KEY_DATA = "data"; // Corrected from "Data" to match typical JSON response
    private final Activity activity;
    private final PreferenceHelper preferenceHelper;

    public ParseContent(Activity activity) {
        this.activity = activity;
        this.preferenceHelper = new PreferenceHelper(activity);
    }

    public boolean isSuccess(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            return jsonObject.optString(KEY_SUCCESS).equals("true");
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
        preferenceHelper.putIsLogin(true);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(KEY_SUCCESS).equals("true")) {
                JSONObject userData = jsonObject.getJSONObject(KEY_DATA);

                preferenceHelper.putFirstName(userData.getString(AndyConstants.Params.KEY_FIRST_NAME));
                preferenceHelper.putLastName(userData.getString(AndyConstants.Params.KEY_LAST_NAME));
                preferenceHelper.putRole(userData.getString(AndyConstants.Params.KEY_ROLE));
                preferenceHelper.putSurveyAccess(userData.getString(AndyConstants.Params.KEY_SURVEY_ACCESS));
                preferenceHelper.putPhone(userData.getString(AndyConstants.Params.KEY_PHONE));
                preferenceHelper.putDistrict(userData.getString(AndyConstants.Params.KEY_DISTRICT));
                preferenceHelper.putCommunity(userData.getString(AndyConstants.Params.KEY_COMMUNITY));
                preferenceHelper.putCooperative(userData.getString(AndyConstants.Params.KEY_COOPERATIVE));
                preferenceHelper.putEmail(userData.getString(AndyConstants.Params.KEY_EMAIL));
                preferenceHelper.putIsLogin(userData.getString(AndyConstants.Params.KEY_IS_LOGGED_IN));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
