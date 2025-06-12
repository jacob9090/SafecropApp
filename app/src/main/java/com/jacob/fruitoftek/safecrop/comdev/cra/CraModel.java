package com.jacob.fruitoftek.safecrop.comdev.cra;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class CraModel implements Parcelable {

    private int id;
    private String craquestion1;
    private String craquestion2;
    private String craquestion3;
    private String craquestion4;
    private String craquestion5;
    private String craquestion6;
    private String craquestion7;
    private String craquestion8;
    private String craquestion9;
    private String craquestion10;
    private String craquestion11;
    private String craquestion12;
    private String craquestion13;
    private String cra_location;
    private Uri farmer_photo;
    private String signature;
    private String userFname;
    private String userLname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public CraModel(int id, String craquestion1, String craquestion2, String craquestion3, String craquestion4,
                    String craquestion5, String craquestion6, String craquestion7, String craquestion8,
                    String craquestion9, String craquestion10, String craquestion11, String craquestion12,
                    String craquestion13, String cra_location, String signature, String userFname,
                    String userLname, String userEmail, String onCreate, String onUpdate) {
        this.id = id;
        this.craquestion1 = craquestion1;
        this.craquestion2 = craquestion2;
        this.craquestion3 = craquestion3;
        this.craquestion4 = craquestion4;
        this.craquestion5 = craquestion5;
        this.craquestion6 = craquestion6;
        this.craquestion7 = craquestion7;
        this.craquestion8 = craquestion8;
        this.craquestion9 = craquestion9;
        this.craquestion10 = craquestion10;
        this.craquestion11 = craquestion11;
        this.craquestion12 = craquestion12;
        this.craquestion13 = craquestion13;
        this.cra_location = cra_location;
        this.farmer_photo = farmer_photo;
        this.signature = signature;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
        this.onCreate = onCreate;
        this.onUpdate = onUpdate;
    }

    protected CraModel(Parcel in) {
        id = in.readInt();
        craquestion1 = in.readString();
        craquestion2 = in.readString();
        craquestion3 = in.readString();
        craquestion4 = in.readString();
        craquestion5 = in.readString();
        craquestion6 = in.readString();
        craquestion7 = in.readString();
        craquestion8 = in.readString();
        craquestion9 = in.readString();
        craquestion10 = in.readString();
        craquestion11 = in.readString();
        craquestion12 = in.readString();
        craquestion13 = in.readString();
        cra_location = in.readString();
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
        dest.writeString(craquestion1);
        dest.writeString(craquestion2);
        dest.writeString(craquestion3);
        dest.writeString(craquestion4);
        dest.writeString(craquestion5);
        dest.writeString(craquestion6);
        dest.writeString(craquestion7);
        dest.writeString(craquestion8);
        dest.writeString(craquestion9);
        dest.writeString(craquestion10);
        dest.writeString(craquestion11);
        dest.writeString(craquestion12);
        dest.writeString(craquestion13);
        dest.writeString(cra_location);
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
        return 0;
    }

    public static final Creator<CraModel> CREATOR = new Creator<CraModel>() {
        @Override
        public CraModel createFromParcel(Parcel in) {
            return new CraModel(in);
        }

        @Override
        public CraModel[] newArray(int size) {
            return new CraModel[size];
        }
    };

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    // Getters and setters
    public String getCraquestion1() {return craquestion1;}
    public String getCraquestion2() {return craquestion2;}
    public String getCraquestion3() {return craquestion3;}
    public String getCraquestion4() {return craquestion4;}
    public String getCraquestion5() {return craquestion5;}
    public String getCraquestion6() {return craquestion6;}
    public String getCraquestion7() {return craquestion7;}
    public String getCraquestion8() {return craquestion8;}
    public String getCraquestion9() {return craquestion9;}
    public String getCraquestion10() {return craquestion10;}
    public String getCraquestion11() {return craquestion11;}
    public String getCraquestion12() {return craquestion12;}
    public String getCraquestion13() {return craquestion13;}
    public String getCra_location() {return cra_location;}
    public String getSignature() {return signature;}
    public String getUserFname() {return userFname;}
    public String getUserLname() {return userLname;}
    public String getUserEmail() {return userEmail;}
    public String getOnCreate() {return onCreate;}
    public String getOnUpdate() {return onUpdate;}

    public void setCraquestion1(String craquestion1) {this.craquestion1 = craquestion1;}
    public void setCraquestion2(String craquestion2) {this.craquestion2 = craquestion2;}
    public void setCraquestion3(String craquestion3) {this.craquestion3 = craquestion3;}
    public void setCraquestion4(String craquestion4) {this.craquestion4 = craquestion4;}
    public void setCraquestion5(String craquestion5) {this.craquestion5 = craquestion5;}
    public void setCraquestion6(String craquestion6) {this.craquestion6 = craquestion6;}
    public void setCraquestion7(String craquestion7) {this.craquestion7 = craquestion7;}
    public void setCraquestion8(String craquestion8) {this.craquestion8 = craquestion8;}
    public void setCraquestion9(String craquestion9) {this.craquestion9 = craquestion9;}
    public void setCraquestion10(String craquestion10) {this.craquestion10 = craquestion10;}
    public void setCraquestion11(String craquestion11) {this.craquestion11 = craquestion11;}
    public void setCraquestion12(String craquestion12) {this.craquestion12 = craquestion12;}
    public void setCraquestion13(String craquestion13) {this.craquestion13 = craquestion13;}
    public void setCra_location(String cra_location) {this.cra_location = cra_location;}
    public void setFarmer_photo(Uri farmer_photo) {this.farmer_photo = farmer_photo;}
    public void setSignature(String signature) {this.signature = signature;}
    public void setUserFname(String userFname) {this.userFname = userFname;}
    public void setUserLname(String userLname) {this.userLname = userLname;}
    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}
    public void setOnCreate(String onCreate) {this.onCreate = onCreate;}
    public void setOnUpdate(String onUpdate) {this.onUpdate = onUpdate;}
}
