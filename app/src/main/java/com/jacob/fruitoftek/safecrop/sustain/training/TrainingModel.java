package com.jacob.fruitoftek.safecrop.sustain.training;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TrainingModel implements Parcelable {

    private int id;
    private String training_code;
    private String district;
    private String community;
    private String training_question1;
    private String training_question2;
    private String training_question3;
    private String training_question4;
    private String training_question5;
    private String training_question6;
    private String training_question7;
    private String training_question8;
    private String training_question9;
    private String training_question10;
    private String training_question11;
    private String training_question12;
    private String training_question13;
    private String training_question14;
    private String training_question15;
    private String training_location;
    private Uri farmer_photo;
    private String signature;
    private String is_sync;
    private String is_draft;
    private String userFname;
    private String userLname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public TrainingModel(int id, String training_code, String district, String community, String training_question1, String training_question2,
                         String training_question3, String training_question4, String training_question5, String training_question6,
                         String training_question7, String training_question8, String training_question9, String training_question10,
                         String training_question11, String training_question12, String training_question13, String training_question14,
                         String training_question15, String training_location, Uri farmer_photo, String signature, String is_sync,
                         String is_draft, String userFname, String userLname, String userEmail, String onCreate, String onUpdate) {
        this.id = id;
        this.training_code = training_code;
        this.district = district;
        this.community = community;
        this.training_question1 = training_question1;
        this.training_question2 = training_question2;
        this.training_question3 = training_question3;
        this.training_question4 = training_question4;
        this.training_question5 = training_question5;
        this.training_question6 = training_question6;
        this.training_question7 = training_question7;
        this.training_question8 = training_question8;
        this.training_question9 = training_question9;
        this.training_question10 = training_question10;
        this.training_question11 = training_question11;
        this.training_question12 = training_question12;
        this.training_question13 = training_question13;
        this.training_question14 = training_question14;
        this.training_question15 = training_question15;
        this.training_location = training_location;
        this.farmer_photo = farmer_photo;
        this.signature = signature;
        this.is_sync = is_sync;
        this.is_draft = is_draft;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
        this.onCreate = onCreate;
        this.onUpdate = onUpdate;
    }

    protected TrainingModel(Parcel in) {
        id = in.readInt();
        training_code = in.readString();
        district = in.readString();
        community = in.readString();
        training_question1 = in.readString();
        training_question2 = in.readString();
        training_question3 = in.readString();
        training_question4 = in.readString();
        training_question5 = in.readString();
        training_question6 = in.readString();
        training_question7 = in.readString();
        training_question8 = in.readString();
        training_question9 = in.readString();
        training_question10 = in.readString();
        training_question11 = in.readString();
        training_question12 = in.readString();
        training_question13 = in.readString();
        training_question14 = in.readString();
        training_question15 = in.readString();
        training_location = in.readString();
        farmer_photo = in.readParcelable(Uri.class.getClassLoader());
        signature = in.readString();
        is_sync = in.readString();
        is_draft = in.readString();
        userFname = in.readString();
        userLname = in.readString();
        userEmail = in.readString();
        onCreate = in.readString();
        onUpdate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(training_code);
        dest.writeString(district);
        dest.writeString(community);
        dest.writeString(training_question1);
        dest.writeString(training_question2);
        dest.writeString(training_question3);
        dest.writeString(training_question4);
        dest.writeString(training_question5);
        dest.writeString(training_question6);
        dest.writeString(training_question7);
        dest.writeString(training_question8);
        dest.writeString(training_question9);
        dest.writeString(training_question10);
        dest.writeString(training_question11);
        dest.writeString(training_question12);
        dest.writeString(training_question13);
        dest.writeString(training_question14);
        dest.writeString(training_question15);
        dest.writeString(training_location);
        dest.writeParcelable(farmer_photo, flags);
        dest.writeString(signature);
        dest.writeString(is_sync);
        dest.writeString(is_draft);
        dest.writeString(userFname);
        dest.writeString(userLname);
        dest.writeString(userEmail);
        dest.writeString(onCreate);
        dest.writeString(onUpdate);
    }

    public static TrainingModel fromCursor(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        String training_code = cursor.getString(cursor.getColumnIndexOrThrow("training_code"));
        String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
        String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
        String training_question1 = cursor.getString(cursor.getColumnIndexOrThrow("training_question1"));
        String training_question2 = cursor.getString(cursor.getColumnIndexOrThrow("training_question2"));
        String training_question3 = cursor.getString(cursor.getColumnIndexOrThrow("training_question3"));
        String training_question4 = cursor.getString(cursor.getColumnIndexOrThrow("training_question4"));
        String training_question5 = cursor.getString(cursor.getColumnIndexOrThrow("training_question5"));
        String training_question6 = cursor.getString(cursor.getColumnIndexOrThrow("training_question6"));
        String training_question7 = cursor.getString(cursor.getColumnIndexOrThrow("training_question7"));
        String training_location = cursor.getString(cursor.getColumnIndexOrThrow("training_location"));
        String training_question8 = cursor.getString(cursor.getColumnIndexOrThrow("training_question8"));
        String training_question9 = cursor.getString(cursor.getColumnIndexOrThrow("training_question9"));
        String training_question10 = cursor.getString(cursor.getColumnIndexOrThrow("training_question10"));
        String training_question11 = cursor.getString(cursor.getColumnIndexOrThrow("training_question11"));
        String training_question12 = cursor.getString(cursor.getColumnIndexOrThrow("training_question12"));
        String training_question13 = cursor.getString(cursor.getColumnIndexOrThrow("training_question13"));
        String training_question14 = cursor.getString(cursor.getColumnIndexOrThrow("training_question14"));
        String training_question15 = cursor.getString(cursor.getColumnIndexOrThrow("training_question15"));
        String farmer_photo_str = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
        Uri farmer_photo = (farmer_photo_str != null && !farmer_photo_str.isEmpty()) ? Uri.parse(farmer_photo_str) : null;
        String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
        String is_sync = cursor.getString(cursor.getColumnIndexOrThrow("is_sync"));
        String is_draft = cursor.getString(cursor.getColumnIndexOrThrow("is_draft"));
        String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
        String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
        String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
        String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
        String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

        return new TrainingModel(
                id,
                training_code,
                district,
                community,
                training_question1,
                training_question2,
                training_question3,
                training_question4,
                training_question5,
                training_question6,
                training_question7,
                training_question8,
                training_question9,
                training_question10,
                training_question11,
                training_question12,
                training_question13,
                training_question14,
                training_question15,
                training_location,
                farmer_photo,
                signature,
                is_sync,
                is_draft,
                userFname,
                userLname,
                userEmail,
                onCreate,
                onUpdate
        );
    }

    @Override
    public int describeContents() {
        return 0; // No special contents in this Parcelable
    }

    public static final Creator<TrainingModel> CREATOR = new Creator<TrainingModel>() {
        @Override
        public TrainingModel createFromParcel(Parcel in) {
            return new TrainingModel(in);
        }

        @Override
        public TrainingModel[] newArray(int size) {
            return new TrainingModel[size];
        }
    };

    @SerializedName("farmer_photo")
    public String getFarmerPhotoString() {
        return farmer_photo != null ? farmer_photo.toString() : "";
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getTraining_code() {
        return training_code;
    }

    public String getDistrict() {
        return district;
    }

    public String getCommunity() {
        return community;
    }

    public String getTraining_question1() {
        return training_question1;
    }

    public String getTraining_question2() {
        return training_question2;
    }

    public String getTraining_question3() {
        return training_question3;
    }

    public String getTraining_question4() {
        return training_question4;
    }

    public String getTraining_question5() {
        return training_question5;
    }

    public String getTraining_question6() {
        return training_question6;
    }

    public String getTraining_question7() {
        return training_question7;
    }

    public String getTraining_question8() {
        return training_question8;
    }

    public String getTraining_question9() {
        return training_question9;
    }

    public String getTraining_question10() {
        return training_question10;
    }

    public String getTraining_question11() {
        return training_question11;
    }

    public String getTraining_question12() {
        return training_question12;
    }

    public String getTraining_question13() {
        return training_question13;
    }

    public String getTraining_question14() {
        return training_question14;
    }

    public String getTraining_question15() {
        return training_question15;
    }

    public String getTraining_location() {
        return training_location;
    }

    public Uri getFarmer_photo() { return farmer_photo; }

    public String getFarmer_photoString() { return farmer_photo != null ? farmer_photo.toString() : ""; }

    public String getSignature() { return signature; }

    public String getIs_sync() { return is_sync; }

    public String getIs_draft() { return is_draft; }

    public String getUserFname() { return userFname; }

    public String getUserLname() { return userLname; }

    public String getUserEmail() { return userEmail; }

    public String getOnCreate() { return onCreate; }

    public String getOnUpdate() { return onUpdate; }

    public void setId(int id) { this.id = id; }

    public void setTraining_code(String training_code) {
        this.training_code = training_code;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public void setTraining_question1(String training_question1) {
        this.training_question1 = training_question1;
    }

    public void setTraining_question2(String training_question2) {
        this.training_question2 = training_question2;
    }

    public void setTraining_question3(String training_question3) {
        this.training_question3 = training_question3;
    }

    public void setTraining_question4(String training_question4) {
        this.training_question4 = training_question4;
    }

    public void setTraining_question5(String training_question5) {
        this.training_question5 = training_question5;
    }

    public void setTraining_question6(String training_question6) {
        this.training_question6 = training_question6;
    }

    public void setTraining_question7(String training_question7) {
        this.training_question7 = training_question7;
    }

    public void setTraining_question8(String training_question8) {
        this.training_question8 = training_question8;
    }

    public void setTraining_question9(String training_question9) {
        this.training_question9 = training_question9;
    }

    public void setTraining_question10(String training_question10) {
        this.training_question10 = training_question10;
    }

    public void setTraining_question11(String training_question11) {
        this.training_question11 = training_question11;
    }

    public void setTraining_question12(String training_question12) {
        this.training_question12 = training_question12;
    }

    public void setTraining_question13(String training_question13) {
        this.training_question13 = training_question13;
    }

    public void setTraining_question14(String training_question14) {
        this.training_question14 = training_question14;
    }

    public void setTraining_question15(String training_question15) {
        this.training_question15 = training_question15;
    }

    public void setTraining_location(String training_location) {
        this.training_location = training_location;
    }

    public void setFarmer_photo(Uri farmer_photo) {
        this.farmer_photo = farmer_photo;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setIs_sync(String is_sync) {
        this.is_sync = is_sync;
    }

    public void setIs_draft(String is_draft) {
        this.is_draft = is_draft;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setOnCreate(String onCreate) {
        this.onCreate = onCreate;
    }

    public void setOnUpdate(String onUpdate) {
        this.onUpdate = onUpdate;
    }
}
