package com.jacob.fruitoftek.safecrop.sustain.inspection;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class InspectionModel implements Parcelable {

    private int id;
    private String farmer_id;
    private String farmer_name;
    private String district;
    private String community;
    private String inspection_question1;
    private String inspection_question2;
    private String inspection_question3;
    private String inspection_question4;
    private String inspection_question5;
    private String inspection_location;
    private Uri farmer_photo;
    private String signature;
    private String is_sync;
    private String is_draft;
    private String userFname;
    private String userLname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public InspectionModel(int id, String farmer_id, String farmer_name, String district, String community, 
                           String inspection_question1, String inspection_question2, String inspection_question3, 
                           String inspection_question4, String inspection_question5, String inspection_location,
                           Uri farmer_photo, String signature, String is_sync, String is_draft, String userFname,
                           String userLname, String userEmail, String onCreate, String onUpdate) {
        this.id = id;
        this.farmer_id = farmer_id;
        this.farmer_name = farmer_name;
        this.district = district;
        this.community = community;
        this.inspection_question1 = inspection_question1;
        this.inspection_question2 = inspection_question2;
        this.inspection_question3 = inspection_question3;
        this.inspection_question4 = inspection_question4;
        this.inspection_question5 = inspection_question5;
        this.inspection_location = inspection_location;
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

    protected InspectionModel(Parcel in) {
        id = in.readInt();
        farmer_id = in.readString();
        farmer_name = in.readString();
        district = in.readString();
        community = in.readString();
        inspection_question1 = in.readString();
        inspection_question2 = in.readString();
        inspection_question3 = in.readString();
        inspection_question4 = in.readString();
        inspection_question5 = in.readString();
        inspection_location = in.readString();
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
        dest.writeString(farmer_id);
        dest.writeString(farmer_name);
        dest.writeString(district);
        dest.writeString(community);
        dest.writeString(inspection_question1);
        dest.writeString(inspection_question2);
        dest.writeString(inspection_question3);
        dest.writeString(inspection_question4);
        dest.writeString(inspection_question5);
        dest.writeString(inspection_location);
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

    public static InspectionModel fromCursor(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        String farmer_id = cursor.getString(cursor.getColumnIndexOrThrow("farmer_id"));
        String farmer_name = cursor.getString(cursor.getColumnIndexOrThrow("farmer_name"));
        String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
        String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
        String inspection_question1 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question1"));
        String inspection_question2 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question2"));
        String inspection_question3 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question3"));
        String inspection_question4 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question4"));
        String inspection_question5 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question5"));
        String inspection_location = cursor.getString(cursor.getColumnIndexOrThrow("inspection_location"));

        // Farmer photo as Uri
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

        return new InspectionModel(
                id,
                farmer_id,
                farmer_name,
                district,
                community,
                inspection_question1,
                inspection_question2,
                inspection_question3,
                inspection_question4,
                inspection_question5,
                inspection_location,
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

    public static final Creator<InspectionModel> CREATOR = new Creator<InspectionModel>() {
        @Override
        public InspectionModel createFromParcel(Parcel in) {
            return new InspectionModel(in);
        }

        @Override
        public InspectionModel[] newArray(int size) {
            return new InspectionModel[size];
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

    public String getFarmer_id() { return farmer_id; }

    public String getFarmer_name() { return farmer_name; }

    public String getDistrict() { return district; }

    public String getCommunity() { return community; }

    public String getInspection_question1() { return inspection_question1; }

    public String getInspection_question2() { return inspection_question2; }

    public String getInspection_question3() { return inspection_question3;}

    public String getInspection_question4() { return inspection_question4; }

    public String getInspection_question5() { return inspection_question5; }

    public String getInspection_location() { return inspection_location; }

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

    public void setInspection_question5(String inspection_question5) { this.inspection_question5 = inspection_question5; }

    public void setId(int id) { this.id = id; }

    public void setFarmer_id(String farmer_id) { this.farmer_id = farmer_id; }

    public void setFarmer_name(String farmer_name) { this.farmer_name = farmer_name; }

    public void setDistrict(String district) { this.district = district; }

    public void setCommunity(String community) { this.community = community; }

    public void setInspection_question1(String inspection_question1) { this.inspection_question1 = inspection_question1; }

    public void setInspection_question2(String inspection_question2) { this.inspection_question2 = inspection_question2; }

    public void setInspection_question3(String inspection_question3) { this.inspection_question3 = inspection_question3; }

    public void setInspection_question4(String inspection_question4) { this.inspection_question4 = inspection_question4; }

    public void setInspection_location(String inspection_location) { this.inspection_location = inspection_location; }

    public void setFarmer_photo(String farmer_photo) {
        this.farmer_photo = (farmer_photo != null && !farmer_photo.isEmpty()) ? Uri.parse(farmer_photo) : null;
    }
    public void setFarmer_photo(Uri farmer_photo) { this.farmer_photo = farmer_photo; }

    public void setSignature(String signature) { this.signature = signature; }

    public void setIs_sync(String is_sync) { this.is_sync = is_sync; }

    public void setIs_draft(String is_draft) { this.is_draft = is_draft; }

    public void setUserFname(String userFname) { this.userFname = userFname; }

    public void setUserLname(String userLname) { this.userLname = userLname; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public void setOnCreate(String onCreate) { this.onCreate = onCreate; }

    public void setOnUpdate(String onUpdate) { this.onUpdate = onUpdate; }
}