package com.jacob.fruitoftek.safecrop.sustain.profiling;

import android.os.Parcel;
import android.os.Parcelable;
import android.database.Cursor;

public class SusProfilingModel implements Parcelable {

    private int id;
    private String farmer_id;
    private String farmer_name;
    private String farmer_gender;
    private String district;
    private String community;
    private String farmer_dob;
    private String ghana_card;
    private String suspro_question1;
    private String suspro_question2;
    private String suspro_question3;
    private String suspro_question4;
    private String suspro_question5;
    private String suspro_question6;
    private String suspro_question7;
    private String suspro_question8;
    private String suspro_question9;
    private String suspro_question10;
    private String suspro_question11;
    private String suspro_question12;
    private String suspro_question13;
    private String suspro_question14;
    private String suspro_question15;
    private String suspro_question16;
    private String suspro_question17;
    private String suspro_question18;
    private String suspro_question19;
    private String suspro_question20;
    private String suspro_question21;
    private String suspro_question22;
    private String suspro_question23;
    private String suspro_question24;
    private String suspro_question25;
    private String signature;
    private String is_sync;
    private String is_draft;
    private String userFname;
    private String userLname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public SusProfilingModel(int id, String farmer_id, String farmer_name, String farmer_gender, String district,
                             String community, String farmer_dob, String ghana_card, String suspro_question1,
                             String suspro_question2, String suspro_question3, String suspro_question4,
                             String suspro_question5, String suspro_question6, String suspro_question7,
                             String suspro_question8, String suspro_question9, String suspro_question10,
                             String suspro_question11, String suspro_question12, String suspro_question13,
                             String suspro_question14, String suspro_question15, String suspro_question16,
                             String suspro_question17, String suspro_question18, String suspro_question19,
                             String suspro_question20, String suspro_question21, String suspro_question22,
                             String suspro_question23, String suspro_question24, String suspro_question25,
                             String signature, String is_sync, String is_draft, String userFname, String userLname,
                             String userEmail, String onCreate, String onUpdate) {
        this.id = id;
        this.farmer_id = farmer_id;
        this.farmer_name = farmer_name;
        this.farmer_gender = farmer_gender;
        this.district = district;
        this.community = community;
        this.farmer_dob = farmer_dob;
        this.ghana_card = ghana_card;
        this.suspro_question1 = suspro_question1;
        this.suspro_question2 = suspro_question2;
        this.suspro_question3 = suspro_question3;
        this.suspro_question4 = suspro_question4;
        this.suspro_question5 = suspro_question5;
        this.suspro_question6 = suspro_question6;
        this.suspro_question7 = suspro_question7;
        this.suspro_question8 = suspro_question8;
        this.suspro_question9 = suspro_question9;
        this.suspro_question10 = suspro_question10;
        this.suspro_question11 = suspro_question11;
        this.suspro_question12 = suspro_question12;
        this.suspro_question13 = suspro_question13;
        this.suspro_question14 = suspro_question14;
        this.suspro_question15 = suspro_question15;
        this.suspro_question16 = suspro_question16;
        this.suspro_question17 = suspro_question17;
        this.suspro_question18 = suspro_question18;
        this.suspro_question19 = suspro_question19;
        this.suspro_question20 = suspro_question20;
        this.suspro_question21 = suspro_question21;
        this.suspro_question22 = suspro_question22;
        this.suspro_question23 = suspro_question23;
        this.suspro_question24 = suspro_question24;
        this.suspro_question25 = suspro_question25;
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
        farmer_name = in.readString();
        farmer_gender = in.readString();
        district = in.readString();
        community = in.readString();
        farmer_dob = in.readString();
        ghana_card = in.readString();
        suspro_question1 = in.readString();
        suspro_question2 = in.readString();
        suspro_question3 = in.readString();
        suspro_question4 = in.readString();
        suspro_question5 = in.readString();
        suspro_question6 = in.readString();
        suspro_question7 = in.readString();
        suspro_question8 = in.readString();
        suspro_question9 = in.readString();
        suspro_question10 = in.readString();
        suspro_question11 = in.readString();
        suspro_question12 = in.readString();
        suspro_question13 = in.readString();
        suspro_question14 = in.readString();
        suspro_question15 = in.readString();
        suspro_question16 = in.readString();
        suspro_question17 = in.readString();
        suspro_question18 = in.readString();
        suspro_question19 = in.readString();
        suspro_question20 = in.readString();
        suspro_question21 = in.readString();
        suspro_question22 = in.readString();
        suspro_question23 = in.readString();
        suspro_question24 = in.readString();
        suspro_question25 = in.readString();
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
        dest.writeString(farmer_gender);
        dest.writeString(district);
        dest.writeString(community);
        dest.writeString(farmer_dob);
        dest.writeString(ghana_card);
        dest.writeString(suspro_question1);
        dest.writeString(suspro_question2);
        dest.writeString(suspro_question3);
        dest.writeString(suspro_question4);
        dest.writeString(suspro_question5);
        dest.writeString(suspro_question6);
        dest.writeString(suspro_question7);
        dest.writeString(suspro_question8);
        dest.writeString(suspro_question9);
        dest.writeString(suspro_question10);
        dest.writeString(suspro_question11);
        dest.writeString(suspro_question12);
        dest.writeString(suspro_question13);
        dest.writeString(suspro_question14);
        dest.writeString(suspro_question15);
        dest.writeString(suspro_question16);
        dest.writeString(suspro_question17);
        dest.writeString(suspro_question18);
        dest.writeString(suspro_question19);
        dest.writeString(suspro_question20);
        dest.writeString(suspro_question21);
        dest.writeString(suspro_question22);
        dest.writeString(suspro_question23);
        dest.writeString(suspro_question24);
        dest.writeString(suspro_question25);
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
        String farmer_name = cursor.getString(cursor.getColumnIndexOrThrow("farmer_name"));
        String farmer_gender = cursor.getString(cursor.getColumnIndexOrThrow("farmer_gender"));
        String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
        String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
        String farmer_dob = cursor.getString(cursor.getColumnIndexOrThrow("farmer_dob"));
        String ghana_card = cursor.getString(cursor.getColumnIndexOrThrow("ghana_card"));
        String suspro_question1 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question1"));
        String suspro_question2 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question2"));
        String suspro_question3 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question3"));
        String suspro_question4 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question4"));
        String suspro_question5 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question5"));
        String suspro_question6 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question6"));
        String suspro_question7 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question7"));
        String suspro_question8 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question8"));
        String suspro_question9 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question9"));
        String suspro_question10 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question10"));
        String suspro_question11 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question11"));
        String suspro_question12 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question12"));
        String suspro_question13 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question13"));
        String suspro_question14 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question14"));
        String suspro_question15 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question15"));
        String suspro_question16 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question16"));
        String suspro_question17 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question17"));
        String suspro_question18 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question18"));
        String suspro_question19 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question19"));
        String suspro_question20 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question20"));
        String suspro_question21 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question21"));
        String suspro_question22 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question22"));
        String suspro_question23 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question23"));
        String suspro_question24 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question24"));
        String suspro_question25 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question25"));
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
                farmer_name,
                farmer_gender,
                district,
                community,
                farmer_dob,
                ghana_card,
                suspro_question1,
                suspro_question2,
                suspro_question3,
                suspro_question4,
                suspro_question5,
                suspro_question6,
                suspro_question7,
                suspro_question8,
                suspro_question9,
                suspro_question10,
                suspro_question11,
                suspro_question12,
                suspro_question13,
                suspro_question14,
                suspro_question15,
                suspro_question16,
                suspro_question17,
                suspro_question18,
                suspro_question19,
                suspro_question20,
                suspro_question21,
                suspro_question22,
                suspro_question23,
                suspro_question24,
                suspro_question25,
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

    // Getters and setters
    public int getId() { return id; }
    public String getFarmer_id() { return farmer_id; }
    public String getFarmer_name() { return farmer_name; }
    public String getFarmer_gender() { return farmer_gender; }
    public String getDistrict() { return district; }
    public String getCommunity() { return community; }
    public String getFarmer_dob() { return farmer_dob; }
    public String getGhana_card() { return ghana_card; }
    public String getSuspro_question1() { return suspro_question1; }
    public String getSuspro_question2() { return suspro_question2; }
    public String getSuspro_question3() { return suspro_question3; }
    public String getSuspro_question4() { return suspro_question4; }
    public String getSuspro_question5() { return suspro_question5; }
    public String getSuspro_question6() { return suspro_question6; }
    public String getSuspro_question7() { return suspro_question7; }
    public String getSuspro_question8() { return suspro_question8; }
    public String getSuspro_question9() { return suspro_question9; }
    public String getSuspro_question10() { return suspro_question10; }
    public String getSuspro_question11() { return suspro_question11; }
    public String getSuspro_question12() { return suspro_question12; }
    public String getSuspro_question13() { return suspro_question13; }
    public String getSuspro_question14() { return suspro_question14; }
    public String getSuspro_question15() { return suspro_question15; }
    public String getSuspro_question16() { return suspro_question16; }
    public String getSuspro_question17() { return suspro_question17; }
    public String getSuspro_question18() { return suspro_question18; }
    public String getSuspro_question19() { return suspro_question19; }
    public String getSuspro_question20() { return suspro_question20; }
    public String getSuspro_question21() { return suspro_question21; }
    public String getSuspro_question22() { return suspro_question22; }
    public String getSuspro_question23() { return suspro_question23; }
    public String getSuspro_question24() { return suspro_question24; }
    public String getSuspro_question25() { return suspro_question25; }
    public String getSignature() { return signature; }
    public String getIs_sync() { return is_sync; }
    public String getIs_draft() { return is_draft; }
    public String getUserFname() { return userFname; }
    public String getUserLname() { return userLname; }
    public String getUserEmail() { return userEmail; }
    public String getOnCreate() { return onCreate; }
    public String getOnUpdate() { return onUpdate; }

    public void setId(int id) { this.id = id; }
    public void setFarmer_id(String farmer_id) { this.farmer_id = farmer_id; }
    public void setFarmer_name(String farmer_name) { this.farmer_name = farmer_name; }
    public void setFarmer_gender(String farmer_gender) { this.farmer_gender = farmer_gender; }
    public void setDistrict(String district) { this.district = district; }
    public void setCommunity(String community) { this.community = community; }
    public void setFarmer_dob(String farmer_dob) { this.farmer_dob = farmer_dob; }
    public void setGhana_card(String ghana_card) { this.ghana_card = ghana_card; }
    public void setSuspro_question1(String suspro_question1) { this.suspro_question1 = suspro_question1; }
    public void setSuspro_question2(String suspro_question2) { this.suspro_question2 = suspro_question2; }
    public void setSuspro_question3(String suspro_question3) { this.suspro_question3 = suspro_question3; }
    public void setSuspro_question4(String suspro_question4) { this.suspro_question4 = suspro_question4; }
    public void setSuspro_question5(String suspro_question5) { this.suspro_question5 = suspro_question5; }
    public void setSuspro_question6(String suspro_question6) { this.suspro_question6 = suspro_question6; }
    public void setSuspro_question7(String suspro_question7) { this.suspro_question7 = suspro_question7; }
    public void setSuspro_question8(String suspro_question8) { this.suspro_question8 = suspro_question8; }
    public void setSuspro_question9(String suspro_question9) { this.suspro_question9 = suspro_question9; }
    public void setSuspro_question10(String suspro_question10) { this.suspro_question10 = suspro_question10; }
    public void setSuspro_question11(String suspro_question11) { this.suspro_question11 = suspro_question11; }
    public void setSuspro_question12(String suspro_question12) { this.suspro_question12 = suspro_question12; }
    public void setSuspro_question13(String suspro_question13) { this.suspro_question13 = suspro_question13; }
    public void setSuspro_question14(String suspro_question14) { this.suspro_question14 = suspro_question14; }
    public void setSuspro_question15(String suspro_question15) { this.suspro_question15 = suspro_question15; }
    public void setSuspro_question16(String suspro_question16) { this.suspro_question16 = suspro_question16; }
    public void setSuspro_question17(String suspro_question17) { this.suspro_question17 = suspro_question17; }
    public void setSuspro_question18(String suspro_question18) { this.suspro_question18 = suspro_question18; }
    public void setSuspro_question19(String suspro_question19) { this.suspro_question19 = suspro_question19; }
    public void setSuspro_question20(String suspro_question20) { this.suspro_question20 = suspro_question20; }
    public void setSuspro_question21(String suspro_question21) { this.suspro_question21 = suspro_question21; }
    public void setSuspro_question22(String suspro_question22) { this.suspro_question22 = suspro_question22; }
    public void setSuspro_question23(String suspro_question23) { this.suspro_question23 = suspro_question23; }
    public void setSuspro_question24(String suspro_question24) { this.suspro_question24 = suspro_question24; }
    public void setSuspro_question25(String suspro_question25) { this.suspro_question25 = suspro_question25; }
    public void setSignature(String signature) { this.signature = signature; }
    public void setIs_sync(String is_sync) { this.is_sync = is_sync; }
    public void setIs_draft(String is_draft) { this.is_draft = is_draft; }
    public void setUserFname(String userFname) { this.userFname = userFname; }
    public void setUserLname(String userLname) { this.userLname = userLname; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void setOnCreate(String onCreate) { this.onCreate = onCreate; }
    public void setOnUpdate(String onUpdate) { this.onUpdate = onUpdate; }
}
