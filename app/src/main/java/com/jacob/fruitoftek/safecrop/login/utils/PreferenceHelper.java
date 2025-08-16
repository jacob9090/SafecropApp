package com.jacob.fruitoftek.safecrop.login.utils;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

public class PreferenceHelper {

    private final SharedPreferences sharedPrefs;

    private static final String PREF_NAME = "AppPrefs";

    // Keys
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    public static final String KEY_GENDER = "gender";
    private static final String KEY_ROLE = "role";
    private static final String KEY_SURVEY_ACCESS = "survey_access";
    private static final String KEY_PHONE = "user_phone";
    private static final String KEY_DISTRICT = "user_district";
    private static final String KEY_COMMUNITY = "user_community";
    private static final String KEY_COOPERATIVE = "user_cooperative";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_IS_LOGGED_IN = "is_logged_in";

    public PreferenceHelper(Context context) {
        sharedPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveUserData(JSONObject user) throws JSONException {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(KEY_FIRST_NAME, user.optString(KEY_FIRST_NAME, ""));
        editor.putString(KEY_LAST_NAME, user.optString(KEY_LAST_NAME, ""));
        editor.putString(KEY_GENDER, user.optString(KEY_GENDER, ""));
        editor.putString(KEY_ROLE, user.optString(KEY_ROLE, ""));
        editor.putString(KEY_SURVEY_ACCESS, user.optString(KEY_SURVEY_ACCESS, ""));
        editor.putString(KEY_PHONE, user.optString(KEY_PHONE, ""));
        editor.putString(KEY_DISTRICT, user.optString(KEY_DISTRICT, ""));
        editor.putString(KEY_COMMUNITY, user.optString(KEY_COMMUNITY, ""));
        editor.putString(KEY_COOPERATIVE, user.optString(KEY_COOPERATIVE, ""));
        editor.putString(KEY_EMAIL, user.optString(KEY_EMAIL, ""));
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.apply();
    }

    // Individual Setters
    public void putFirstName(String fname) {
        sharedPrefs.edit().putString(KEY_FIRST_NAME, fname).apply();
    }

    public void putLastName(String lname) {
        sharedPrefs.edit().putString(KEY_LAST_NAME, lname).apply();
    }

    public void putGender(String gender) {
        sharedPrefs.edit().putString(KEY_GENDER, gender).apply();
    }

    public void putRole(String role) {
        sharedPrefs.edit().putString(KEY_ROLE, role).apply();
    }

    public void putSurveyAccess(String surveyAccess) {
        sharedPrefs.edit().putString(KEY_SURVEY_ACCESS, surveyAccess).apply();
    }

    public void putPhone(String phone) {
        sharedPrefs.edit().putString(KEY_PHONE, phone).apply();
    }

    public void putDistrict(String district) {
        sharedPrefs.edit().putString(KEY_DISTRICT, district).apply();
    }

    public void putCommunity(String community) {
        sharedPrefs.edit().putString(KEY_COMMUNITY, community).apply();
    }

    public void putCooperative(String cooperative) {
        sharedPrefs.edit().putString(KEY_COOPERATIVE, cooperative).apply();
    }

    public void putEmail(String email) {
        sharedPrefs.edit().putString(KEY_EMAIL, email).apply();
    }

    public void putIsLogin(boolean loggedIn) {
        sharedPrefs.edit().putBoolean(KEY_IS_LOGGED_IN, loggedIn).apply();
    }

    // Individual Getters
    public String getFirstName() {
        return sharedPrefs.getString(KEY_FIRST_NAME, "");
    }

    public String getLastName() { return sharedPrefs.getString(KEY_LAST_NAME, ""); }

    public String getGender() { return sharedPrefs.getString(KEY_GENDER, ""); }

    public String getRole() {
        return sharedPrefs.getString(KEY_ROLE, "");
    }

    public String getSurveyAccess() {
        return sharedPrefs.getString(KEY_SURVEY_ACCESS, "");
    }

    public String getPhone() {
        return sharedPrefs.getString(KEY_PHONE, "");
    }

    public String getDistrict() {
        return sharedPrefs.getString(KEY_DISTRICT, "");
    }

    public String getCommunity() {
        return sharedPrefs.getString(KEY_COMMUNITY, "");
    }

    public String getCooperative() {
        return sharedPrefs.getString(KEY_COOPERATIVE, "");
    }

    public String getEmail() {
        return sharedPrefs.getString(KEY_EMAIL, "");
    }

    public boolean isLoggedIn() {
        return sharedPrefs.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    // Clear user info but keep session flag if needed
    public void clearUserInfo() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.remove(KEY_FIRST_NAME);
        editor.remove(KEY_LAST_NAME);
        editor.remove(KEY_GENDER);
        editor.remove(KEY_ROLE);
        editor.remove(KEY_SURVEY_ACCESS);
        editor.remove(KEY_PHONE);
        editor.remove(KEY_DISTRICT);
        editor.remove(KEY_COMMUNITY);
        editor.remove(KEY_COOPERATIVE);
        editor.remove(KEY_EMAIL);
        editor.apply();
    }

    // Full logout, clears everything
    public void clearSession() {
        sharedPrefs.edit().clear().apply();
    }
}

