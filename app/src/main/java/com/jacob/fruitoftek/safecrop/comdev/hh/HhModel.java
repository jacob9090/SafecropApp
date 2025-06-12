package com.jacob.fruitoftek.safecrop.comdev.hh;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class HhModel implements Parcelable {

    private int id; // Add id field
    private String hh_name;
    private String hh_district;
    private String hh_community;
    private String hhquestion4;
    private String hhquestion5;
    private String hhquestion6;
    private String hhquestion7;
    private String hhquestion8;
    private String hhquestion9;
    private String hhquestion10;
    private String hhquestion11;
    private String hhquestion12;
    private String hhquestion13;
    private String hhquestion14;
    private String hhquestion15;
    private String hhquestion16;
    private String hhquestion17;
    private String hhquestion18;
    private String hhquestion19;
    private String hhquestion20;
    private String hhquestion21;
    private String hhquestion22;
    private String hhquestion23;
    private String hhquestion24;
    private String hhquestion25;
    private String hhquestion26;
    private String hhquestion27;
    private String hhquestion28;
    private String hhquestion29;
    private String hhquestion30;
    private String hhquestion31;
    private String hhquestion32;
    private String hhquestion36;
    private String hhquestion37;
    private String hh_location;
    private Uri farmer_photo;
    private String signature;
    private String userFname;
    private String userLname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public HhModel(int id, String hh_name, String hh_district, String hh_community,
                   String hhquestion4, String hhquestion5, String hhquestion6, String hhquestion7, String hhquestion8,
                   String hhquestion9, String hhquestion10, String hhquestion11, String hhquestion12, String hhquestion13,
                   String hhquestion14, String hhquestion15, String hhquestion16, String hhquestion17, String hhquestion18,
                   String hhquestion19, String hhquestion20, String hhquestion21, String hhquestion22, String hhquestion23,
                   String hhquestion24, String hhquestion25, String hhquestion26, String hhquestion27, String hhquestion28,
                   String hhquestion29, String hhquestion30, String hhquestion31, String hhquestion32, String hhquestion36,
                   String hhquestion37, String hh_location,
                   Uri farmer_photo, String signature, String userFname, String userLname, String userEmail,
                   String onCreate, String onUpdate) {
        this.id = id;
        this.hh_name = hh_name;
        this.hh_district = hh_district;
        this.hh_community = hh_community;
        this.hhquestion4 = hhquestion4;
        this.hhquestion5 = hhquestion5;
        this.hhquestion6 = hhquestion6;
        this.hhquestion7 = hhquestion7;
        this.hhquestion8 = hhquestion8;
        this.hhquestion9 = hhquestion9;
        this.hhquestion10 = hhquestion10;
        this.hhquestion11 = hhquestion11;
        this.hhquestion12 = hhquestion12;
        this.hhquestion13 = hhquestion13;
        this.hhquestion14 = hhquestion14;
        this.hhquestion15 = hhquestion15;
        this.hhquestion16 = hhquestion16;
        this.hhquestion17 = hhquestion17;
        this.hhquestion18 = hhquestion18;
        this.hhquestion19 = hhquestion19;
        this.hhquestion20 = hhquestion20;
        this.hhquestion21 = hhquestion21;
        this.hhquestion22 = hhquestion22;
        this.hhquestion23 = hhquestion23;
        this.hhquestion24 = hhquestion24;
        this.hhquestion25 = hhquestion25;
        this.hhquestion26 = hhquestion26;
        this.hhquestion27 = hhquestion27;
        this.hhquestion28 = hhquestion28;
        this.hhquestion29 = hhquestion29;
        this.hhquestion30 = hhquestion30;
        this.hhquestion31 = hhquestion31;
        this.hhquestion32 = hhquestion32;
        this.hhquestion36 = hhquestion36;
        this.hhquestion37 = hhquestion37;
        this.hh_location = hh_location;
        this.farmer_photo = farmer_photo;
        this.signature = signature;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
        this.onCreate = onCreate;
        this.onUpdate = onUpdate;
    }

    protected HhModel(Parcel in) {
        id = in.readInt();
        hh_name = in.readString();
        hh_district = in.readString();
        hh_community = in.readString();
        hhquestion4 = in.readString();
        hhquestion5 = in.readString();
        hhquestion6 = in.readString();
        hhquestion7 = in.readString();
        hhquestion8 = in.readString();
        hhquestion9 = in.readString();
        hhquestion10 = in.readString();
        hhquestion11 = in.readString();
        hhquestion12 = in.readString();
        hhquestion13 = in.readString();
        hhquestion14 = in.readString();
        hhquestion15 = in.readString();
        hhquestion16 = in.readString();
        hhquestion17 = in.readString();
        hhquestion18 = in.readString();
        hhquestion19 = in.readString();
        hhquestion20 = in.readString();
        hhquestion21 = in.readString();
        hhquestion22 = in.readString();
        hhquestion23 = in.readString();
        hhquestion24 = in.readString();
        hhquestion25 = in.readString();
        hhquestion26 = in.readString();
        hhquestion27 = in.readString();
        hhquestion28 = in.readString();
        hhquestion29 = in.readString();
        hhquestion30 = in.readString();
        hhquestion31 = in.readString();
        hhquestion32 = in.readString();
        hhquestion36 = in.readString();
        hhquestion37 = in.readString();
        hh_location = in.readString();
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
        dest.writeString(hh_name);
        dest.writeString(hh_district);
        dest.writeString(hh_community);
        dest.writeString(hhquestion4);
        dest.writeString(hhquestion5);
        dest.writeString(hhquestion6);
        dest.writeString(hhquestion7);
        dest.writeString(hhquestion8);
        dest.writeString(hhquestion9);
        dest.writeString(hhquestion10);
        dest.writeString(hhquestion11);
        dest.writeString(hhquestion12);
        dest.writeString(hhquestion13);
        dest.writeString(hhquestion14);
        dest.writeString(hhquestion15);
        dest.writeString(hhquestion16);
        dest.writeString(hhquestion17);
        dest.writeString(hhquestion18);
        dest.writeString(hhquestion19);
        dest.writeString(hhquestion20);
        dest.writeString(hhquestion21);
        dest.writeString(hhquestion22);
        dest.writeString(hhquestion23);
        dest.writeString(hhquestion24);
        dest.writeString(hhquestion25);
        dest.writeString(hhquestion26);
        dest.writeString(hhquestion27);
        dest.writeString(hhquestion28);
        dest.writeString(hhquestion29);
        dest.writeString(hhquestion30);
        dest.writeString(hhquestion31);
        dest.writeString(hhquestion32);
        dest.writeString(hhquestion36);
        dest.writeString(hhquestion37);
        dest.writeString(hh_location);
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

    public static final Creator<HhModel> CREATOR = new Creator<HhModel>() {
        @Override
        public HhModel createFromParcel(Parcel in) {
            return new HhModel(in);
        }

        @Override
        public HhModel[] newArray(int size) {
            return new HhModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and setters

    public String getHh_name() {
        return hh_name;
    }

    public String getHh_district() {
        return hh_district;
    }

    public String getHh_community() {
        return hh_community;
    }

    public String getHh_location() {
        return hh_location;
    }

    public String getSignature() { return signature; }
    public Uri getFarmer_photo() {return farmer_photo;}
    public String getUserFname() {return userFname;}
    public String getUserLname() {return userLname;}
    public String getUserEmail() {return userEmail;}
    public String getOnCreate() {return onCreate;}
    public String getOnUpdate() {return onUpdate;}

    public String getHhquestion4() {
        return hhquestion4;
    }

    public String getHhquestion5() {
        return hhquestion5;
    }

    public String getHhquestion6() {
        return hhquestion6;
    }

    public String getHhquestion7() {
        return hhquestion7;
    }

    public String getHhquestion8() {
        return hhquestion8;
    }

    public String getHhquestion9() {
        return hhquestion9;
    }

    public String getHhquestion10() {
        return hhquestion10;
    }

    public String getHhquestion11() {
        return hhquestion11;
    }

    public String getHhquestion12() {
        return hhquestion12;
    }

    public String getHhquestion13() {
        return hhquestion13;
    }

    public String getHhquestion14() {
        return hhquestion14;
    }

    public String getHhquestion15() {
        return hhquestion15;
    }

    public String getHhquestion16() {
        return hhquestion16;
    }

    public String getHhquestion17() {
        return hhquestion17;
    }

    public String getHhquestion18() {
        return hhquestion18;
    }

    public String getHhquestion19() {
        return hhquestion19;
    }

    public String getHhquestion20() {
        return hhquestion20;
    }

    public String getHhquestion21() {
        return hhquestion21;
    }

    public String getHhquestion22() {
        return hhquestion22;
    }

    public String getHhquestion23() {
        return hhquestion23;
    }

    public String getHhquestion24() {
        return hhquestion24;
    }

    public String getHhquestion25() {
        return hhquestion25;
    }

    public String getHhquestion26() {
        return hhquestion26;
    }

    public String getHhquestion27() {
        return hhquestion27;
    }

    public String getHhquestion28() {
        return hhquestion28;
    }

    public String getHhquestion29() {
        return hhquestion29;
    }

    public String getHhquestion30() {
        return hhquestion30;
    }

    public String getHhquestion31() {
        return hhquestion31;
    }

    public String getHhquestion32() {
        return hhquestion32;
    }

    public String getHhquestion36() {
        return hhquestion36;
    }

    public String getHhquestion37() {
        return hhquestion37;
    }

    public void setHh_name(String hh_name) {
        this.hh_name = hh_name;
    }

    public void setHh_district(String hh_district) {
        this.hh_district = hh_district;
    }

    public void setHh_community(String hh_community) {
        this.hh_community = hh_community;
    }

    public void setHh_location(String hh_location) {
        this.hh_location = hh_location;
    }

    public void setSignature(String signature) { this.signature = signature; }
    public void setFarmer_photo(Uri farmer_photo) {this.farmer_photo = farmer_photo;}
    public void setUserFname(String userFname) {this.userFname = userFname;}
    public void setUserLname(String userLname) {this.userLname = userLname;}
    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}
    public void setOnCreate(String onCreate) {this.onCreate = onCreate;}
    public void setOnUpdate(String onUpdate) {this.onUpdate = onUpdate;}

    public void setHhquestion5(String hhquestion5) {
        this.hhquestion5 = hhquestion5;
    }

    public void setHhquestion4(String hhquestion4) {
        this.hhquestion4 = hhquestion4;
    }

    public void setHhquestion6(String hhquestion6) {
        this.hhquestion6 = hhquestion6;
    }

    public void setHhquestion7(String hhquestion7) {
        this.hhquestion7 = hhquestion7;
    }

    public void setHhquestion8(String hhquestion8) {
        this.hhquestion8 = hhquestion8;
    }

    public void setHhquestion9(String hhquestion9) {
        this.hhquestion9 = hhquestion9;
    }

    public void setHhquestion10(String hhquestion10) {
        this.hhquestion10 = hhquestion10;
    }

    public void setHhquestion11(String hhquestion11) {
        this.hhquestion11 = hhquestion11;
    }

    public void setHhquestion12(String hhquestion12) {
        this.hhquestion12 = hhquestion12;
    }

    public void setHhquestion13(String hhquestion13) {
        this.hhquestion13 = hhquestion13;
    }

    public void setHhquestion14(String hhquestion14) {
        this.hhquestion14 = hhquestion14;
    }

    public void setHhquestion15(String hhquestion15) {
        this.hhquestion15 = hhquestion15;
    }

    public void setHhquestion16(String hhquestion16) {
        this.hhquestion16 = hhquestion16;
    }

    public void setHhquestion17(String hhquestion17) {
        this.hhquestion17 = hhquestion17;
    }

    public void setHhquestion18(String hhquestion18) {
        this.hhquestion18 = hhquestion18;
    }

    public void setHhquestion19(String hhquestion19) {
        this.hhquestion19 = hhquestion19;
    }

    public void setHhquestion20(String hhquestion20) {
        this.hhquestion20 = hhquestion20;
    }

    public void setHhquestion21(String hhquestion21) {
        this.hhquestion21 = hhquestion21;
    }

    public void setHhquestion22(String hhquestion22) {
        this.hhquestion22 = hhquestion22;
    }

    public void setHhquestion23(String hhquestion23) {
        this.hhquestion23 = hhquestion23;
    }

    public void setHhquestion24(String hhquestion24) {
        this.hhquestion24 = hhquestion24;
    }

    public void setHhquestion25(String hhquestion25) {
        this.hhquestion25 = hhquestion25;
    }

    public void setHhquestion26(String hhquestion26) {
        this.hhquestion26 = hhquestion26;
    }

    public void setHhquestion27(String hhquestion27) {
        this.hhquestion27 = hhquestion27;
    }

    public void setHhquestion28(String hhquestion28) {
        this.hhquestion28 = hhquestion28;
    }

    public void setHhquestion29(String hhquestion29) {
        this.hhquestion29 = hhquestion29;
    }

    public void setHhquestion30(String hhquestion30) {
        this.hhquestion30 = hhquestion30;
    }

    public void setHhquestion31(String hhquestion31) {
        this.hhquestion31 = hhquestion31;
    }

    public void setHhquestion32(String hhquestion32) {
        this.hhquestion32 = hhquestion32;
    }

    public void setHhquestion36(String hhquestion36) {
        this.hhquestion36 = hhquestion36;
    }

    public void setHhquestion37(String hhquestion37) {
        this.hhquestion37 = hhquestion37;
    }
}
