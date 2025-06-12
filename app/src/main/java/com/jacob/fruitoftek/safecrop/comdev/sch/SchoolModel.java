package com.jacob.fruitoftek.safecrop.comdev.sch;

import android.net.Uri;

import android.os.Parcel;
import android.os.Parcelable;

public class SchoolModel implements Parcelable {

    private int id; // Add id field
    private String sch_name;
    private String sch_district;
    private String sch_community;
    private String schquestion4;
    private String schquestion5;
    private String schquestion6;
    private String schquestion7;
    private String schquestion8;
    private String schquestion9;
    private String schquestion10;
    private String schquestion11;
    private String schquestion12;
    private String schquestion13;
    private String schquestion14;
    private String schquestion15;
    private String schquestion16;
    private String schquestion17;
    private String schquestion18;
    private String schquestion19;
    private String schquestion20;
    private String schquestion21;
    private String schquestion22;
    private String schquestion23;
    private String schquestion24;
    private String schquestion25;
    private String schquestion26;
    private String schquestion27;
    private String schquestion28;
    private String schquestion29;
    private String schquestion30;
    private String schquestion31;
    private String schquestion32;
    private String schquestion33;
    private String schquestion34;
    private String sch_location;
    private Uri farmer_photo;
    private String signature;
    private String userFname;
    private String userLname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public SchoolModel(int id, String sch_name, String sch_district, String sch_community,
                       String schquestion4, String schquestion5, String schquestion6, String schquestion7,
                       String schquestion8, String schquestion9, String schquestion10, String schquestion11,
                       String schquestion12, String schquestion13, String schquestion14, String schquestion15,
                       String schquestion16, String schquestion17, String schquestion18, String schquestion19,
                       String schquestion20, String schquestion21, String schquestion22, String schquestion23,
                       String schquestion24, String schquestion25, String schquestion26, String schquestion27,
                       String schquestion28, String schquestion29, String schquestion30, String schquestion31,
                       String schquestion32, String schquestion33, String schquestion34, String sch_location,
                       Uri farmer_photo, String signature, String userFname, String userLname, String userEmail,
                       String onCreate, String onUpdate) {
        this.id = id;
        this.sch_name = sch_name;
        this.sch_district = sch_district;
        this.sch_community = sch_community;
        this.schquestion4 = schquestion4;
        this.schquestion5 = schquestion5;
        this.schquestion6 = schquestion6;
        this.schquestion7 = schquestion7;
        this.schquestion8 = schquestion8;
        this.schquestion9 = schquestion9;
        this.schquestion10 = schquestion10;
        this.schquestion11 = schquestion11;
        this.schquestion12 = schquestion12;
        this.schquestion13 = schquestion13;
        this.schquestion14 = schquestion14;
        this.schquestion15 = schquestion15;
        this.schquestion16 = schquestion16;
        this.schquestion17 = schquestion17;
        this.schquestion18 = schquestion18;
        this.schquestion19 = schquestion19;
        this.schquestion20 = schquestion20;
        this.schquestion21 = schquestion21;
        this.schquestion22 = schquestion22;
        this.schquestion23 = schquestion23;
        this.schquestion24 = schquestion24;
        this.schquestion25 = schquestion25;
        this.schquestion26 = schquestion26;
        this.schquestion27 = schquestion27;
        this.schquestion28 = schquestion28;
        this.schquestion29 = schquestion29;
        this.schquestion30 = schquestion30;
        this.schquestion31 = schquestion31;
        this.schquestion32 = schquestion32;
        this.schquestion33 = schquestion33;
        this.schquestion34 = schquestion34;
        this.sch_location = sch_location;
        this.farmer_photo = farmer_photo;
        this.signature = signature;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
        this.onCreate = onCreate;
        this.onUpdate = onUpdate;
    }

    protected SchoolModel(Parcel in) {
        id = in.readInt();
        sch_name = in.readString();
        sch_district = in.readString();
        sch_community = in.readString();
        schquestion4 = in.readString();
        schquestion5 = in.readString();
        schquestion6 = in.readString();
        schquestion7 = in.readString();
        schquestion8 = in.readString();
        schquestion9 = in.readString();
        schquestion10 = in.readString();
        schquestion11 = in.readString();
        schquestion12 = in.readString();
        schquestion13 = in.readString();
        schquestion14 = in.readString();
        schquestion15 = in.readString();
        schquestion16 = in.readString();
        schquestion17 = in.readString();
        schquestion18 = in.readString();
        schquestion19 = in.readString();
        schquestion20 = in.readString();
        schquestion21 = in.readString();
        schquestion22 = in.readString();
        schquestion23 = in.readString();
        schquestion24 = in.readString();
        schquestion25 = in.readString();
        schquestion26 = in.readString();
        schquestion27 = in.readString();
        schquestion28 = in.readString();
        schquestion29 = in.readString();
        schquestion30 = in.readString();
        schquestion31 = in.readString();
        schquestion32 = in.readString();
        schquestion33 = in.readString();
        schquestion34 = in.readString();
        sch_location = in.readString();
        farmer_photo = in.readParcelable(Uri.class.getClassLoader());
        signature = in.readString();
        userFname = in.readString();
        userLname = in.readString();
        userEmail = in.readString();
        onCreate = in.readString();
        onUpdate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(sch_name);
        dest.writeString(sch_district);
        dest.writeString(sch_community);
        dest.writeString(schquestion4);
        dest.writeString(schquestion5);
        dest.writeString(schquestion6);
        dest.writeString(schquestion7);
        dest.writeString(schquestion8);
        dest.writeString(schquestion9);
        dest.writeString(schquestion10);
        dest.writeString(schquestion11);
        dest.writeString(schquestion12);
        dest.writeString(schquestion13);
        dest.writeString(schquestion14);
        dest.writeString(schquestion15);
        dest.writeString(schquestion16);
        dest.writeString(schquestion17);
        dest.writeString(schquestion18);
        dest.writeString(schquestion19);
        dest.writeString(schquestion20);
        dest.writeString(schquestion21);
        dest.writeString(schquestion22);
        dest.writeString(schquestion23);
        dest.writeString(schquestion24);
        dest.writeString(schquestion25);
        dest.writeString(schquestion26);
        dest.writeString(schquestion27);
        dest.writeString(schquestion28);
        dest.writeString(schquestion29);
        dest.writeString(schquestion30);
        dest.writeString(schquestion31);
        dest.writeString(schquestion32);
        dest.writeString(schquestion33);
        dest.writeString(schquestion34);
        dest.writeString(sch_location);
        dest.writeParcelable(farmer_photo, flags);
        dest.writeString(signature);
        dest.writeString(userFname);
        dest.writeString(userLname);
        dest.writeString(userEmail);
        dest.writeString(onCreate);
        dest.writeString(onUpdate);
    }

    @Override
    public int describeContents() {
        return 0; // No special contents in this Parcelable
    }

    public static final Creator<SchoolModel> CREATOR = new Creator<SchoolModel>() {
        @Override
        public SchoolModel createFromParcel(Parcel in) {
            return new SchoolModel(in);
        }

        @Override
        public SchoolModel[] newArray(int size) {
            return new SchoolModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and setters
    public String getSch_name() { return sch_name; }
    public String getSch_district() { return sch_district; }
    public String getSch_community() { return sch_community; }
    public String getSch_location() { return sch_location; }
    public String getSignature() { return signature; }
    public Uri getFarmer_photo() {return farmer_photo;}
    public String getUserFname() {return userFname;}
    public String getUserLname() {return userLname;}
    public String getUserEmail() {return userEmail;}
    public String getOnCreate() {return onCreate;}
    public String getOnUpdate() {return onUpdate;}

    public String getSchquestion4() {
        return schquestion4;
    }

    public String getSchquestion5() {
        return schquestion5;
    }

    public String getSchquestion6() {
        return schquestion6;
    }

    public String getSchquestion7() {
        return schquestion7;
    }

    public String getSchquestion8() {
        return schquestion8;
    }

    public String getSchquestion9() {
        return schquestion9;
    }

    public String getSchquestion10() {
        return schquestion10;
    }

    public String getSchquestion11() {
        return schquestion11;
    }

    public String getSchquestion12() {
        return schquestion12;
    }

    public String getSchquestion13() {
        return schquestion13;
    }

    public String getSchquestion14() {
        return schquestion14;
    }

    public String getSchquestion15() {
        return schquestion15;
    }

    public String getSchquestion16() {
        return schquestion16;
    }

    public String getSchquestion17() {
        return schquestion17;
    }

    public String getSchquestion18() {
        return schquestion18;
    }

    public String getSchquestion19() {
        return schquestion19;
    }

    public String getSchquestion20() {
        return schquestion20;
    }

    public String getSchquestion21() {
        return schquestion21;
    }

    public String getSchquestion22() {
        return schquestion22;
    }

    public String getSchquestion23() {
        return schquestion23;
    }

    public String getSchquestion24() {
        return schquestion24;
    }

    public String getSchquestion25() {
        return schquestion25;
    }

    public String getSchquestion26() {
        return schquestion26;
    }

    public String getSchquestion27() {
        return schquestion27;
    }

    public String getSchquestion28() {
        return schquestion28;
    }

    public String getSchquestion29() {
        return schquestion29;
    }

    public String getSchquestion30() {
        return schquestion30;
    }

    public String getSchquestion31() {
        return schquestion31;
    }

    public String getSchquestion32() {
        return schquestion32;
    }

    public String getSchquestion33() {
        return schquestion33;
    }

    public String getSchquestion34() {
        return schquestion34;
    }

    public void setSch_name(String sch_name) { this.sch_name = sch_name; }
    public void setSch_district(String sch_district) { this.sch_district = sch_district; }
    public void setSch_community(String sch_community) { this.sch_community = sch_community; }
    public void setSch_location(String sch_location) { this.sch_location = sch_location; }
    public void setSignature(String signature) { this.signature = signature; }
    public void setFarmer_photo(Uri farmer_photo) {this.farmer_photo = farmer_photo;}
    public void setUserFname(String userFname) {this.userFname = userFname;}
    public void setUserLname(String userLname) {this.userLname = userLname;}
    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}
    public void setOnCreate(String onCreate) {this.onCreate = onCreate;}
    public void setOnUpdate(String onUpdate) {this.onUpdate = onUpdate;}

    public void setSchquestion4(String schquestion4) {
        this.schquestion4 = schquestion4;
    }

    public void setSchquestion5(String schquestion5) {
        this.schquestion5 = schquestion5;
    }

    public void setSchquestion6(String schquestion6) {
        this.schquestion6 = schquestion6;
    }

    public void setSchquestion7(String schquestion7) {
        this.schquestion7 = schquestion7;
    }

    public void setSchquestion8(String schquestion8) {
        this.schquestion8 = schquestion8;
    }

    public void setSchquestion9(String schquestion9) {
        this.schquestion9 = schquestion9;
    }

    public void setSchquestion10(String schquestion10) {
        this.schquestion10 = schquestion10;
    }

    public void setSchquestion11(String schquestion11) {
        this.schquestion11 = schquestion11;
    }

    public void setSchquestion12(String schquestion12) {
        this.schquestion12 = schquestion12;
    }

    public void setSchquestion13(String schquestion13) {
        this.schquestion13 = schquestion13;
    }

    public void setSchquestion14(String schquestion14) {
        this.schquestion14 = schquestion14;
    }

    public void setSchquestion15(String schquestion15) {
        this.schquestion15 = schquestion15;
    }

    public void setSchquestion16(String schquestion16) {
        this.schquestion16 = schquestion16;
    }

    public void setSchquestion17(String schquestion17) {
        this.schquestion17 = schquestion17;
    }

    public void setSchquestion18(String schquestion18) {
        this.schquestion18 = schquestion18;
    }

    public void setSchquestion19(String schquestion19) {
        this.schquestion19 = schquestion19;
    }

    public void setSchquestion20(String schquestion20) {
        this.schquestion20 = schquestion20;
    }

    public void setSchquestion21(String schquestion21) {
        this.schquestion21 = schquestion21;
    }

    public void setSchquestion22(String schquestion22) {
        this.schquestion22 = schquestion22;
    }

    public void setSchquestion23(String schquestion23) {
        this.schquestion23 = schquestion23;
    }

    public void setSchquestion24(String schquestion24) {
        this.schquestion24 = schquestion24;
    }

    public void setSchquestion25(String schquestion25) {
        this.schquestion25 = schquestion25;
    }

    public void setSchquestion26(String schquestion26) {
        this.schquestion26 = schquestion26;
    }

    public void setSchquestion27(String schquestion27) {
        this.schquestion27 = schquestion27;
    }

    public void setSchquestion28(String schquestion28) {
        this.schquestion28 = schquestion28;
    }

    public void setSchquestion29(String schquestion29) {
        this.schquestion29 = schquestion29;
    }

    public void setSchquestion30(String schquestion30) {
        this.schquestion30 = schquestion30;
    }

    public void setSchquestion31(String schquestion31) {
        this.schquestion31 = schquestion31;
    }

    public void setSchquestion32(String schquestion32) {
        this.schquestion32 = schquestion32;
    }

    public void setSchquestion33(String schquestion33) {
        this.schquestion33 = schquestion33;
    }

    public void setSchquestion34(String schquestion34) {
        this.schquestion34 = schquestion34;
    }
}
