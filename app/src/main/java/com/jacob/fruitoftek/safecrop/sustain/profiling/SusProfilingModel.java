package com.jacob.fruitoftek.safecrop.sustain.profiling;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.database.Cursor;

import com.google.gson.annotations.SerializedName;

public class SusProfilingModel implements Parcelable {

    private int id;
    private String farmer_id;
    private String district;
    private String community;
    private String suspro_question1;
    private String suspro_question2;
    private String suspro_question3;
    private String suspro_question4;
    private String suspro_question4b;
    private String suspro_question4c;
    private String suspro_question5;
    private String suspro_question6;
    private String suspro_question7;
    private String suspro_question7b;
    private String suspro_question8;
    private String suspro_question8b;
    private String suspro_question9;
    private String suspro_question10;
    private String suspro_question11;
    private String suspro_question11b;
    private String suspro_question11c;
    private String suspro_question12;
    private String suspro_question12b;
    private String suspro_question13;
    private String suspro_question14;
    private String suspro_question14b;
    private String suspro_question14c;
    private String suspro_question14d;
    private String suspro_question15;
    private String suspro_question15b;
    private String suspro_question16;
    private String suspro_question16b;
    private String suspro_question17;
    private String suspro_question17b;
    private String suspro_question17c;
    private String suspro_question18;
    private String suspro_question19;
    private String suspro_question20;
    private String suspro_question21;
    private String suspro_location;
    private Uri farmer_photo;
    private String signature;
    private String is_sync;
    private String is_draft;
    private String userFname;
    private String userLname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public SusProfilingModel(int id, String farmer_id, String district, String community, String suspro_question1,
                             String suspro_question2, String suspro_question3, String suspro_question4, String suspro_question4b,
                             String suspro_question4c, String suspro_question5, String suspro_question6, String suspro_question7,
                             String suspro_question7b, String suspro_question8, String suspro_question8b, String suspro_question9,
                             String suspro_question10, String suspro_question11, String suspro_question11b, String suspro_question11c,
                             String suspro_question12, String suspro_question12b, String suspro_question13, String suspro_question14,
                             String suspro_question14b, String suspro_question14c, String suspro_question14d, String suspro_question15,
                             String suspro_question15b, String suspro_question16, String suspro_question16b, String suspro_question17,
                             String suspro_question17b, String suspro_question17c, String suspro_question18, String suspro_question19,
                             String suspro_question20, String suspro_question21, String suspro_location, Uri farmer_photo,
                             String signature, String is_sync, String is_draft, String userFname, String userLname, String userEmail,
                             String onCreate, String onUpdate) {
        this.id = id;
        this.farmer_id = farmer_id;
        this.district = district;
        this.community = community;
        this.suspro_question1 = suspro_question1;
        this.suspro_question2 = suspro_question2;
        this.suspro_question3 = suspro_question3;
        this.suspro_question4 = suspro_question4;
        this.suspro_question4b = suspro_question4b;
        this.suspro_question4c = suspro_question4c;
        this.suspro_question5 = suspro_question5;
        this.suspro_question6 = suspro_question6;
        this.suspro_question7 = suspro_question7;
        this.suspro_question7b = suspro_question7b;
        this.suspro_question8 = suspro_question8;
        this.suspro_question8b = suspro_question8b;
        this.suspro_question9 = suspro_question9;
        this.suspro_question10 = suspro_question10;
        this.suspro_question11 = suspro_question11;
        this.suspro_question11b = suspro_question11b;
        this.suspro_question11c = suspro_question11c;
        this.suspro_question12 = suspro_question12;
        this.suspro_question12b = suspro_question12b;
        this.suspro_question13 = suspro_question13;
        this.suspro_question14 = suspro_question14;
        this.suspro_question14b = suspro_question14b;
        this.suspro_question14c = suspro_question14c;
        this.suspro_question14d = suspro_question14d;
        this.suspro_question15 = suspro_question15;
        this.suspro_question15b = suspro_question15b;
        this.suspro_question16 = suspro_question16;
        this.suspro_question16b = suspro_question16b;
        this.suspro_question17 = suspro_question17;
        this.suspro_question17b = suspro_question17b;
        this.suspro_question17c = suspro_question17c;
        this.suspro_question18 = suspro_question18;
        this.suspro_question19 = suspro_question19;
        this.suspro_question20 = suspro_question20;
        this.suspro_question21 = suspro_question21;
        this.suspro_location = suspro_location;
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

    protected SusProfilingModel(Parcel in) {
        id = in.readInt();
        farmer_id = in.readString();
        district = in.readString();
        community = in.readString();
        suspro_question1 = in.readString();
        suspro_question2 = in.readString();
        suspro_question3 = in.readString();
        suspro_question4 = in.readString();
        suspro_question4b = in.readString();
        suspro_question4c = in.readString();
        suspro_question5 = in.readString();
        suspro_question6 = in.readString();
        suspro_question7 = in.readString();
        suspro_question7b = in.readString();
        suspro_question8 = in.readString();
        suspro_question8b = in.readString();
        suspro_question9 = in.readString();
        suspro_question10 = in.readString();
        suspro_question11 = in.readString();
        suspro_question11b = in.readString();
        suspro_question11c = in.readString();
        suspro_question12 = in.readString();
        suspro_question12b = in.readString();
        suspro_question13 = in.readString();
        suspro_question14 = in.readString();
        suspro_question14b = in.readString();
        suspro_question14c = in.readString();
        suspro_question14d = in.readString();
        suspro_question15 = in.readString();
        suspro_question15b = in.readString();
        suspro_question16 = in.readString();
        suspro_question16b = in.readString();
        suspro_question17 = in.readString();
        suspro_question17b = in.readString();
        suspro_question17c = in.readString();
        suspro_question18 = in.readString();
        suspro_question19 = in.readString();
        suspro_question20 = in.readString();
        suspro_question21 = in.readString();
        suspro_location = in.readString();
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
        dest.writeString(district);
        dest.writeString(community);
        dest.writeString(suspro_question1);
        dest.writeString(suspro_question2);
        dest.writeString(suspro_question3);
        dest.writeString(suspro_question4);
        dest.writeString(suspro_question4b);
        dest.writeString(suspro_question4c);
        dest.writeString(suspro_question5);
        dest.writeString(suspro_question6);
        dest.writeString(suspro_question7);
        dest.writeString(suspro_question7b);
        dest.writeString(suspro_question8);
        dest.writeString(suspro_question8b);
        dest.writeString(suspro_question9);
        dest.writeString(suspro_question10);
        dest.writeString(suspro_question11);
        dest.writeString(suspro_question11b);
        dest.writeString(suspro_question11c);
        dest.writeString(suspro_question12);
        dest.writeString(suspro_question12b);
        dest.writeString(suspro_question13);
        dest.writeString(suspro_question14);
        dest.writeString(suspro_question14b);
        dest.writeString(suspro_question14c);
        dest.writeString(suspro_question14d);
        dest.writeString(suspro_question15);
        dest.writeString(suspro_question15b);
        dest.writeString(suspro_question16);
        dest.writeString(suspro_question16b);
        dest.writeString(suspro_question17);
        dest.writeString(suspro_question17b);
        dest.writeString(suspro_question17c);
        dest.writeString(suspro_question18);
        dest.writeString(suspro_question19);
        dest.writeString(suspro_question20);
        dest.writeString(suspro_question21);
        dest.writeString(suspro_location);
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

    public static SusProfilingModel fromCursor(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        String farmer_id = cursor.getString(cursor.getColumnIndexOrThrow("farmer_id"));
        String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
        String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
        String suspro_question1 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question1"));
        String suspro_question2 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question2"));
        String suspro_question3 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question3"));
        String suspro_question4 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question4"));
        String suspro_question4b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question4b"));
        String suspro_question4c = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question4c"));
        String suspro_question5 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question5"));
        String suspro_question6 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question6"));
        String suspro_question7 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question7"));
        String suspro_question7b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question7b"));
        String suspro_question8 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question8"));
        String suspro_question8b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question8b"));
        String suspro_question9 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question9"));
        String suspro_question10 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question10"));
        String suspro_question11 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question11"));
        String suspro_question11b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question11b"));
        String suspro_question11c = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question11c"));
        String suspro_question12 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question12"));
        String suspro_question12b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question12b"));
        String suspro_question13 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question13"));
        String suspro_question14 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question14"));
        String suspro_question14b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question14b"));
        String suspro_question14c = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question14c"));
        String suspro_question14d = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question14d"));
        String suspro_question15 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question15"));
        String suspro_question15b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question15b"));
        String suspro_question16 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question16"));
        String suspro_question16b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question16b"));
        String suspro_question17 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question17"));
        String suspro_question17b = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question17b"));
        String suspro_question17c = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question17c"));
        String suspro_question18 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question18"));
        String suspro_question19 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question19"));
        String suspro_question20 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question20"));
        String suspro_question21 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question21"));
        String suspro_location = cursor.getString(cursor.getColumnIndexOrThrow("suspro_location"));
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

        return new SusProfilingModel(
                id,
                farmer_id,
                district,
                community,
                suspro_question1,
                suspro_question2,
                suspro_question3,
                suspro_question4,
                suspro_question4b,
                suspro_question4c,
                suspro_question5,
                suspro_question6,
                suspro_question7,
                suspro_question7b,
                suspro_question8,
                suspro_question8b,
                suspro_question9,
                suspro_question10,
                suspro_question11,
                suspro_question11b,
                suspro_question11c,
                suspro_question12,
                suspro_question12b,
                suspro_question13,
                suspro_question14,
                suspro_question14b,
                suspro_question14c,
                suspro_question14d,
                suspro_question15,
                suspro_question15b,
                suspro_question16,
                suspro_question16b,
                suspro_question17,
                suspro_question17b,
                suspro_question17c,
                suspro_question18,
                suspro_question19,
                suspro_question20,
                suspro_question21,
                suspro_location,
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

    public static final Creator<SusProfilingModel> CREATOR = new Creator<SusProfilingModel>() {
        @Override
        public SusProfilingModel createFromParcel(Parcel in) {
            return new SusProfilingModel(in);
        }

        @Override
        public SusProfilingModel[] newArray(int size) {
            return new SusProfilingModel[size];
        }
    };

    @SerializedName("farmer_photo")
    public String getFarmerPhotoString() {
        return farmer_photo != null ? farmer_photo.toString() : "";
    }

    // Getters and setters
    public int getId() { return id; }

    public String getFarmer_id() {
        return farmer_id;
    }

    public String getDistrict() {
        return district;
    }

    public String getCommunity() {
        return community;
    }

    public String getSuspro_question1() {
        return suspro_question1;
    }

    public String getSuspro_question2() {
        return suspro_question2;
    }

    public String getSuspro_question3() {
        return suspro_question3;
    }

    public String getSuspro_question4() {
        return suspro_question4;
    }

    public String getSuspro_question4b() {
        return suspro_question4b;
    }

    public String getSuspro_question4c() {
        return suspro_question4c;
    }

    public String getSuspro_question5() {
        return suspro_question5;
    }

    public String getSuspro_question6() {
        return suspro_question6;
    }

    public String getSuspro_question7() {
        return suspro_question7;
    }

    public String getSuspro_question7b() {
        return suspro_question7b;
    }

    public String getSuspro_question8() {
        return suspro_question8;
    }

    public String getSuspro_question8b() {
        return suspro_question8b;
    }

    public String getSuspro_question9() {
        return suspro_question9;
    }

    public String getSuspro_question10() {
        return suspro_question10;
    }

    public String getSuspro_question11() {
        return suspro_question11;
    }

    public String getSuspro_question11b() {
        return suspro_question11b;
    }

    public String getSuspro_question11c() {
        return suspro_question11c;
    }

    public String getSuspro_question12() {
        return suspro_question12;
    }

    public String getSuspro_question12b() {
        return suspro_question12b;
    }

    public String getSuspro_question13() {
        return suspro_question13;
    }

    public String getSuspro_question14() {
        return suspro_question14;
    }

    public String getSuspro_question14b() {
        return suspro_question14b;
    }

    public String getSuspro_question14c() {
        return suspro_question14c;
    }

    public String getSuspro_question14d() {
        return suspro_question14d;
    }

    public String getSuspro_question15() {
        return suspro_question15;
    }

    public String getSuspro_question15b() {
        return suspro_question15b;
    }

    public String getSuspro_question16() {
        return suspro_question16;
    }

    public String getSuspro_question16b() {
        return suspro_question16b;
    }

    public String getSuspro_question17() {
        return suspro_question17;
    }

    public String getSuspro_question17b() {
        return suspro_question17b;
    }

    public String getSuspro_question17c() {
        return suspro_question17c;
    }

    public String getSuspro_question18() {
        return suspro_question18;
    }

    public String getSuspro_question19() {
        return suspro_question19;
    }

    public String getSuspro_question20() {
        return suspro_question20;
    }

    public String getSuspro_question21() {
        return suspro_question21;
    }

    public String getSuspro_location() {
        return suspro_location;
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

    public void setFarmer_id(String farmer_id) {
        this.farmer_id = farmer_id;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public void setSuspro_question1(String suspro_question1) {
        this.suspro_question1 = suspro_question1;
    }

    public void setSuspro_question2(String suspro_question2) {
        this.suspro_question2 = suspro_question2;
    }

    public void setSuspro_question3(String suspro_question3) {
        this.suspro_question3 = suspro_question3;
    }

    public void setSuspro_question4(String suspro_question4) {
        this.suspro_question4 = suspro_question4;
    }

    public void setSuspro_question4b(String suspro_question4b) {
        this.suspro_question4b = suspro_question4b;
    }

    public void setSuspro_question4c(String suspro_question4c) {
        this.suspro_question4c = suspro_question4c;
    }

    public void setSuspro_question5(String suspro_question5) {
        this.suspro_question5 = suspro_question5;
    }

    public void setSuspro_question6(String suspro_question6) {
        this.suspro_question6 = suspro_question6;
    }

    public void setSuspro_question7(String suspro_question7) {
        this.suspro_question7 = suspro_question7;
    }

    public void setSuspro_question7b(String suspro_question7b) {
        this.suspro_question7b = suspro_question7b;
    }

    public void setSuspro_question8(String suspro_question8) {
        this.suspro_question8 = suspro_question8;
    }

    public void setSuspro_question8b(String suspro_question8b) {
        this.suspro_question8b = suspro_question8b;
    }

    public void setSuspro_question9(String suspro_question9) {
        this.suspro_question9 = suspro_question9;
    }

    public void setSuspro_question10(String suspro_question10) {
        this.suspro_question10 = suspro_question10;
    }

    public void setSuspro_question11(String suspro_question11) {
        this.suspro_question11 = suspro_question11;
    }

    public void setSuspro_question11b(String suspro_question11b) {
        this.suspro_question11b = suspro_question11b;
    }

    public void setSuspro_question11c(String suspro_question11c) {
        this.suspro_question11c = suspro_question11c;
    }

    public void setSuspro_question12(String suspro_question12) {
        this.suspro_question12 = suspro_question12;
    }

    public void setSuspro_question12b(String suspro_question12b) {
        this.suspro_question12b = suspro_question12b;
    }

    public void setSuspro_question13(String suspro_question13) {
        this.suspro_question13 = suspro_question13;
    }

    public void setSuspro_question14(String suspro_question14) {
        this.suspro_question14 = suspro_question14;
    }

    public void setSuspro_question14b(String suspro_question14b) {
        this.suspro_question14b = suspro_question14b;
    }

    public void setSuspro_question14c(String suspro_question14c) {
        this.suspro_question14c = suspro_question14c;
    }

    public void setSuspro_question14d(String suspro_question14d) {
        this.suspro_question14d = suspro_question14d;
    }

    public void setSuspro_question15(String suspro_question15) {
        this.suspro_question15 = suspro_question15;
    }

    public void setSuspro_question15b(String suspro_question15b) {
        this.suspro_question15b = suspro_question15b;
    }

    public void setSuspro_question16(String suspro_question16) {
        this.suspro_question16 = suspro_question16;
    }

    public void setSuspro_question16b(String suspro_question16b) {
        this.suspro_question16b = suspro_question16b;
    }

    public void setSuspro_question17(String suspro_question17) {
        this.suspro_question17 = suspro_question17;
    }

    public void setSuspro_question17b(String suspro_question17b) {
        this.suspro_question17b = suspro_question17b;
    }

    public void setSuspro_question17c(String suspro_question17c) {
        this.suspro_question17c = suspro_question17c;
    }

    public void setSuspro_question18(String suspro_question18) {
        this.suspro_question18 = suspro_question18;
    }

    public void setSuspro_question19(String suspro_question19) {
        this.suspro_question19 = suspro_question19;
    }

    public void setSuspro_question20(String suspro_question20) {
        this.suspro_question20 = suspro_question20;
    }

    public void setSuspro_question21(String suspro_question21) {
        this.suspro_question21 = suspro_question21;
    }

    public void setSuspro_location(String suspro_location) {
        this.suspro_location = suspro_location;
    }

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
