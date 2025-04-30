package com.jacob.fruitoftek.safecrop.organic.orgpro;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class OrgProModel implements Parcelable {

    private int id;
    private String orgquestion1;
    private String orgquestion2;
    private String orgquestion3;
    private String orgquestion4;
    private String orgquestion5;
    private String orgquestion6;
    private String orgquestion7;
    private String orgquestion8;
    private String orgquestion9;
    private String orgquestion10;
    private String orgquestion11;
    private String orgquestion12;
    private String orgquestion13;
    private String orgquestion14;
    private String orgquestion15;
    private String orgquestion16;
    private String orgquestion17;
    private String orgquestion19;
    private String orgquestion18;
    private String orgquestion20;
    private String orgquestion21;
    private String orgquestion22;
    private String orgquestion23;
    private String orgquestion24;
    private String orgquestion25;
    private String orgquestion26;
    private String orgquestion27;
    private String orgquestion28;
    private String orgquestion29;
    private String orgquestion30;
    private String orgquestion31;
    private String org_location;
    private Uri farmer_photo;
    private String signature;
    private String userFname;
    private String userOname;
    private String onCreate;
    private String onUpdate;

    public OrgProModel(int id, String orgquestion1, String orgquestion2, String orgquestion3,
                       String orgquestion4, String orgquestion5, String orgquestion6, String orgquestion7,
                       String orgquestion8, String orgquestion9, String orgquestion10, String orgquestion11,
                       String orgquestion12, String orgquestion13, String orgquestion14, String orgquestion15,
                       String orgquestion16, String orgquestion17, String orgquestion19, String orgquestion18,
                       String orgquestion20, String orgquestion21, String orgquestion22, String orgquestion23,
                       String orgquestion24, String orgquestion25, String orgquestion26, String orgquestion27,
                       String orgquestion28, String orgquestion29, String orgquestion30, String orgquestion31,
                       String org_location, Uri farmer_photo, String signature, String userFname,
                       String userOname, String onCreate, String onUpdate) {
        this.id = id;
        this.orgquestion1 = orgquestion1;
        this.orgquestion2 = orgquestion2;
        this.orgquestion3 = orgquestion3;
        this.orgquestion4 = orgquestion4;
        this.orgquestion5 = orgquestion5;
        this.orgquestion6 = orgquestion6;
        this.orgquestion7 = orgquestion7;
        this.orgquestion8 = orgquestion8;
        this.orgquestion9 = orgquestion9;
        this.orgquestion10 = orgquestion10;
        this.orgquestion11 = orgquestion11;
        this.orgquestion12 = orgquestion12;
        this.orgquestion13 = orgquestion13;
        this.orgquestion14 = orgquestion14;
        this.orgquestion15 = orgquestion15;
        this.orgquestion16 = orgquestion16;
        this.orgquestion17 = orgquestion17;
        this.orgquestion19 = orgquestion19;
        this.orgquestion18 = orgquestion18;
        this.orgquestion20 = orgquestion20;
        this.orgquestion21 = orgquestion21;
        this.orgquestion22 = orgquestion22;
        this.orgquestion23 = orgquestion23;
        this.orgquestion24 = orgquestion24;
        this.orgquestion25 = orgquestion25;
        this.orgquestion26 = orgquestion26;
        this.orgquestion27 = orgquestion27;
        this.orgquestion28 = orgquestion28;
        this.orgquestion29 = orgquestion29;
        this.orgquestion30 = orgquestion30;
        this.orgquestion31 = orgquestion31;
        this.org_location = org_location;
        this.farmer_photo = farmer_photo;
        this.signature = signature;
        this.userFname = userFname;
        this.userOname = userOname;
        this.onCreate = onCreate;
        this.onUpdate = onUpdate;
    }

    protected OrgProModel(Parcel in) {
        id = in.readInt();
        orgquestion1 = in.readString();
        orgquestion2 = in.readString();
        orgquestion3 = in.readString();
        orgquestion4 = in.readString();
        orgquestion5 = in.readString();
        orgquestion6 = in.readString();
        orgquestion7 = in.readString();
        orgquestion8 = in.readString();
        orgquestion9 = in.readString();
        orgquestion10 = in.readString();
        orgquestion11 = in.readString();
        orgquestion12 = in.readString();
        orgquestion13 = in.readString();
        orgquestion14 = in.readString();
        orgquestion15 = in.readString();
        orgquestion16 = in.readString();
        orgquestion17 = in.readString();
        orgquestion19 = in.readString();
        orgquestion18 = in.readString();
        orgquestion20 = in.readString();
        orgquestion21 = in.readString();
        orgquestion22 = in.readString();
        orgquestion23 = in.readString();
        orgquestion24 = in.readString();
        orgquestion25 = in.readString();
        orgquestion26 = in.readString();
        orgquestion27 = in.readString();
        orgquestion28 = in.readString();
        orgquestion29 = in.readString();
        orgquestion30 = in.readString();
        orgquestion31 = in.readString();
        org_location = in.readString();
        farmer_photo = in.readParcelable(Uri.class.getClassLoader());
        signature = in.readString();
        userFname = in.readString();
        userOname = in.readString();
        onCreate = in.readString();
        onUpdate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(orgquestion1);
        dest.writeString(orgquestion2);
        dest.writeString(orgquestion3);
        dest.writeString(orgquestion4);
        dest.writeString(orgquestion5);
        dest.writeString(orgquestion6);
        dest.writeString(orgquestion7);
        dest.writeString(orgquestion8);
        dest.writeString(orgquestion9);
        dest.writeString(orgquestion10);
        dest.writeString(orgquestion11);
        dest.writeString(orgquestion12);
        dest.writeString(orgquestion13);
        dest.writeString(orgquestion14);
        dest.writeString(orgquestion15);
        dest.writeString(orgquestion16);
        dest.writeString(orgquestion17);
        dest.writeString(orgquestion19);
        dest.writeString(orgquestion18);
        dest.writeString(orgquestion20);
        dest.writeString(orgquestion21);
        dest.writeString(orgquestion22);
        dest.writeString(orgquestion23);
        dest.writeString(orgquestion24);
        dest.writeString(orgquestion25);
        dest.writeString(orgquestion26);
        dest.writeString(orgquestion27);
        dest.writeString(orgquestion28);
        dest.writeString(orgquestion29);
        dest.writeString(orgquestion30);
        dest.writeString(orgquestion31);
        dest.writeString(org_location);
        dest.writeParcelable(farmer_photo, flags);
        dest.writeString(signature);
        dest.writeString(userFname);
        dest.writeString(userOname);
        dest.writeString(onCreate);
        dest.writeString(onUpdate);
    }

    @Override
    public int describeContents() {
        return 0; // No special contents in this Parcelable
    }

    public static final Creator<OrgProModel> CREATOR = new Creator<OrgProModel>() {
        @Override
        public OrgProModel createFromParcel(Parcel in) {
            return new OrgProModel(in);
        }

        @Override
        public OrgProModel[] newArray(int size) {
            return new OrgProModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and setters

    public String getOrgquestion9() {
        return orgquestion9;
    }

    public String getOrgquestion1() {
        return orgquestion1;
    }

    public String getOrgquestion2() {
        return orgquestion2;
    }

    public String getOrgquestion3() {
        return orgquestion3;
    }

    public String getOrgquestion4() {
        return orgquestion4;
    }

    public String getOrgquestion5() {
        return orgquestion5;
    }

    public String getOrgquestion6() {
        return orgquestion6;
    }

    public String getOrgquestion7() {
        return orgquestion7;
    }

    public String getOrgquestion8() {
        return orgquestion8;
    }

    public String getOrgquestion10() {
        return orgquestion10;
    }

    public String getOrgquestion11() {
        return orgquestion11;
    }

    public String getOrgquestion12() {
        return orgquestion12;
    }

    public String getOrgquestion13() {
        return orgquestion13;
    }

    public String getOrgquestion14() {
        return orgquestion14;
    }

    public String getOrgquestion15() {
        return orgquestion15;
    }

    public String getOrgquestion16() {
        return orgquestion16;
    }

    public String getOrgquestion17() {
        return orgquestion17;
    }

    public String getOrgquestion19() {
        return orgquestion19;
    }

    public String getOrgquestion18() {
        return orgquestion18;
    }

    public String getOrgquestion20() {
        return orgquestion20;
    }

    public String getOrgquestion21() {
        return orgquestion21;
    }

    public String getOrgquestion22() {
        return orgquestion22;
    }

    public String getOrgquestion23() {
        return orgquestion23;
    }

    public String getOrgquestion24() {
        return orgquestion24;
    }

    public String getOrgquestion25() {
        return orgquestion25;
    }

    public String getOrgquestion26() {
        return orgquestion26;
    }

    public String getOrgquestion27() {
        return orgquestion27;
    }

    public String getOrgquestion28() {
        return orgquestion28;
    }

    public String getOrgquestion29() {
        return orgquestion29;
    }

    public String getOrgquestion30() {
        return orgquestion30;
    }

    public String getOrgquestion31() {
        return orgquestion31;
    }

    public String getOrg_location() {
        return org_location;
    }

    public String getSignature() { return signature; }
    public Uri getFarmer_photo() {return farmer_photo;}
    public String getUserFname() {return userFname;}
    public String getUserOname() {return userOname;}
    public String getOnCreate() {return onCreate;}
    public String getOnUpdate() {return onUpdate;}

    public void setSignature(String signature) { this.signature = signature; }
    public void setFarmer_photo(Uri farmer_photo) {this.farmer_photo = farmer_photo;}
    public void setUserFname(String userFname) {this.userFname = userFname;}
    public void setUserOname(String userOname) {this.userOname = userOname;}
    public void setOnCreate(String onCreate) {this.onCreate = onCreate;}
    public void setOnUpdate(String onUpdate) {this.onUpdate = onUpdate;}

    public void setOrgquestion1(String orgquestion1) {
        this.orgquestion1 = orgquestion1;
    }

    public void setOrgquestion2(String orgquestion2) {
        this.orgquestion2 = orgquestion2;
    }

    public void setOrgquestion3(String orgquestion3) {
        this.orgquestion3 = orgquestion3;
    }

    public void setOrgquestion4(String orgquestion4) {
        this.orgquestion4 = orgquestion4;
    }

    public void setOrgquestion5(String orgquestion5) {
        this.orgquestion5 = orgquestion5;
    }

    public void setOrgquestion6(String orgquestion6) {
        this.orgquestion6 = orgquestion6;
    }

    public void setOrgquestion7(String orgquestion7) {
        this.orgquestion7 = orgquestion7;
    }

    public void setOrgquestion8(String orgquestion8) {
        this.orgquestion8 = orgquestion8;
    }

    public void setOrgquestion9(String orgquestion9) {
        this.orgquestion9 = orgquestion9;
    }

    public void setOrgquestion10(String orgquestion10) {
        this.orgquestion10 = orgquestion10;
    }

    public void setOrgquestion11(String orgquestion11) {
        this.orgquestion11 = orgquestion11;
    }

    public void setOrgquestion12(String orgquestion12) {
        this.orgquestion12 = orgquestion12;
    }

    public void setOrgquestion13(String orgquestion13) {
        this.orgquestion13 = orgquestion13;
    }

    public void setOrgquestion14(String orgquestion14) {
        this.orgquestion14 = orgquestion14;
    }

    public void setOrgquestion15(String orgquestion15) {
        this.orgquestion15 = orgquestion15;
    }

    public void setOrgquestion16(String orgquestion16) {
        this.orgquestion16 = orgquestion16;
    }

    public void setOrgquestion17(String orgquestion17) {
        this.orgquestion17 = orgquestion17;
    }

    public void setOrgquestion19(String orgquestion19) {
        this.orgquestion19 = orgquestion19;
    }

    public void setOrgquestion18(String orgquestion18) {
        this.orgquestion18 = orgquestion18;
    }

    public void setOrgquestion20(String orgquestion20) {
        this.orgquestion20 = orgquestion20;
    }

    public void setOrgquestion21(String orgquestion21) {
        this.orgquestion21 = orgquestion21;
    }

    public void setOrgquestion22(String orgquestion22) {
        this.orgquestion22 = orgquestion22;
    }

    public void setOrgquestion23(String orgquestion23) {
        this.orgquestion23 = orgquestion23;
    }

    public void setOrgquestion24(String orgquestion24) {
        this.orgquestion24 = orgquestion24;
    }

    public void setOrgquestion25(String orgquestion25) {
        this.orgquestion25 = orgquestion25;
    }

    public void setOrgquestion26(String orgquestion26) {
        this.orgquestion26 = orgquestion26;
    }

    public void setOrgquestion27(String orgquestion27) {
        this.orgquestion27 = orgquestion27;
    }

    public void setOrgquestion28(String orgquestion28) {
        this.orgquestion28 = orgquestion28;
    }

    public void setOrgquestion29(String orgquestion29) {
        this.orgquestion29 = orgquestion29;
    }

    public void setOrgquestion30(String orgquestion30) {
        this.orgquestion30 = orgquestion30;
    }

    public void setOrgquestion31(String orgquestion31) {
        this.orgquestion31 = orgquestion31;
    }

    public void setOrg_location(String org_location) {
        this.org_location = org_location;
    }
}
