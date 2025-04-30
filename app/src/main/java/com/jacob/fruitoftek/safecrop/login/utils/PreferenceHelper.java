package com.jacob.fruitoftek.safecrop.login.utils;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

public class PreferenceHelper {
    private SharedPreferences sharedPrefs;

    // Preference keys
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_ROLE = "role";
    private static final String KEY_SURVEY_ACCESS = "survey_access";
    private static final String KEY_PHONE = "user_phone";
    private static final String KEY_DISTRICT = "user_district";
    private static final String KEY_COMMUNITY = "user_community";
    private static final String KEY_COOPERATIVE = "user_cooperative";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_IS_LOGGED_IN = "is_logged_in";

    public PreferenceHelper(Context context) {
        sharedPrefs = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE);
    }

    public void saveUserData(JSONObject user) throws JSONException {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(KEY_FIRST_NAME, user.getString("first_name"));
        editor.putString(KEY_LAST_NAME, user.getString("last_name"));
        editor.putString(KEY_ROLE, user.getString("role"));
        editor.putString(KEY_SURVEY_ACCESS, user.getString("survey_access"));
        editor.putString(KEY_PHONE, user.getString("user_phone"));
        editor.putString(KEY_DISTRICT, user.getString("user_district"));
        editor.putString(KEY_COMMUNITY, user.getString("user_community"));
        editor.putString(KEY_COOPERATIVE, user.getString("user_cooperative"));
        editor.putString(KEY_EMAIL, user.getString("email"));
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.apply();
    }

    public void clearUserData() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.clear();
        editor.apply();
    }

    public void logout() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean(KEY_IS_LOGGED_IN, false);
        editor.apply();
    }

    // Set login status
    public void putIsLogin(boolean loginorout) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putBoolean(KEY_IS_LOGGED_IN, loginorout);
        edit.apply();
    }

    // Get login status
    public boolean getIsLogin() {
        return sharedPrefs.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    // Clear all stored user information
    public void clearUserInfo() {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.remove(KEY_FIRST_NAME);
        edit.remove(KEY_LAST_NAME);
        edit.remove(KEY_ROLE);
        edit.remove(KEY_SURVEY_ACCESS);
        edit.remove(KEY_PHONE);
        edit.remove(KEY_DISTRICT);
        edit.remove(KEY_COMMUNITY);
        edit.remove(KEY_COOPERATIVE);
        edit.remove(KEY_EMAIL);
        edit.apply(); // Use apply instead of commit for asynchronous saving
    }

    // Optional: Clear entire session including login status
    public void clearSession() {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.clear();  // Clears all data in shared preferences
        edit.apply();
    }

    public void putFirstName(String fname) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(KEY_FIRST_NAME, fname);
        edit.apply();
    }

    public void putLastName(String fname) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(KEY_FIRST_NAME, fname);
        edit.apply();
    }

    public void putRole(String role) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(KEY_ROLE, role);
        edit.apply();
    }

    public void putSurveyAccess(String survey_access) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(KEY_SURVEY_ACCESS, survey_access);
        edit.apply();
    }

    public void putPhone(String user_phone) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(KEY_PHONE, user_phone);
        edit.apply();
    }

    public void putDistrict(String user_district) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(KEY_DISTRICT, user_district);
        edit.apply();
    }

    public void putCommunity(String user_community) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(KEY_COMMUNITY, user_community);
        edit.apply();
    }

    public void putCooperative(String user_cooperative) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(KEY_COOPERATIVE, user_cooperative);
        edit.apply();
    }

    public void putEmail(String email) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(KEY_EMAIL, email);
        edit.apply();
    }

    public void putIsLogin(String is_logged_in) {
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(KEY_IS_LOGGED_IN, is_logged_in);
        edit.apply();
    }

    // Getters
    public String getFirstName() { return sharedPrefs.getString(KEY_FIRST_NAME, ""); }
    public String getLastName() { return sharedPrefs.getString(KEY_LAST_NAME, ""); }
    public String getRole() { return sharedPrefs.getString(KEY_ROLE, ""); }
    public String getSurveyAccess() { return sharedPrefs.getString(KEY_SURVEY_ACCESS, ""); }
    public String getPhone() { return sharedPrefs.getString(KEY_PHONE, ""); }
    public String getDistrict() { return sharedPrefs.getString(KEY_DISTRICT, ""); }
    public String getCommunity() { return sharedPrefs.getString(KEY_COMMUNITY, ""); }
    public String getCooperative() { return sharedPrefs.getString(KEY_COOPERATIVE, ""); }
    public String getEmail() { return sharedPrefs.getString(KEY_EMAIL, ""); }
    public boolean isLoggedIn() { return sharedPrefs.getBoolean(KEY_IS_LOGGED_IN, false); }
}
