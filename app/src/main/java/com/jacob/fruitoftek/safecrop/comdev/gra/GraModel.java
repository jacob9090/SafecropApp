package com.jacob.fruitoftek.safecrop.comdev.gra;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class GraModel implements Parcelable {

    private int id;
    private String graquestion1;
    private String graquestion2;
    private String graquestion3;
    private String graquestion4;
    private String graquestion5;
    private String graquestion6;
    private String graquestion7;
    private String graquestion8;
    private String gra_location;
    private Uri farmer_photo;
    private String signature;
    private String userFname;
    private String userLname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public GraModel(int id, String graquestion1, String graquestion2, String graquestion3,
                    String graquestion4, String graquestion5, String graquestion6, String graquestion7, 
                    String graquestion8, String gra_location, Uri farmer_photo, String signature, 
                    String userFname, String userLname, String userEmail, String onCreate, String onUpdate) {
        this.id = id;
        this.graquestion1 = graquestion1;
        this.graquestion2 = graquestion2;
        this.graquestion3 = graquestion3;
        this.graquestion4 = graquestion4;
        this.graquestion5 = graquestion5;
        this.graquestion6 = graquestion6;
        this.graquestion7 = graquestion7;
        this.graquestion8 = graquestion8;
        this.gra_location = gra_location;
        this.farmer_photo = farmer_photo;
        this.signature = signature;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
        this.onCreate = onCreate;
        this.onUpdate = onUpdate;
    }

    protected GraModel(Parcel in) {
        id = in.readInt();
        graquestion1 = in.readString();
        graquestion2 = in.readString();
        graquestion3 = in.readString();
        graquestion4 = in.readString();
        graquestion5 = in.readString();
        graquestion6 = in.readString();
        graquestion7 = in.readString();
        graquestion8 = in.readString();
        gra_location = in.readString();
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
        dest.writeString(graquestion1);
        dest.writeString(graquestion2);
        dest.writeString(graquestion3);
        dest.writeString(graquestion4);
        dest.writeString(graquestion5);
        dest.writeString(graquestion6);
        dest.writeString(graquestion7);
        dest.writeString(graquestion8);
        dest.writeString(gra_location);
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

    public static final Creator<GraModel> CREATOR = new Creator<GraModel>() {
        @Override
        public GraModel createFromParcel(Parcel in) {
            return new GraModel(in);
        }

        @Override
        public GraModel[] newArray(int size) {
            return new GraModel[size];
        }
    };

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    // Getters and setters
    public String getGraquestion1() {return graquestion1;}
    public String getGraquestion2() {return graquestion2;}
    public String getGraquestion3() {return graquestion3;}
    public String getGraquestion4() {return graquestion4;}
    public String getGraquestion5() {return graquestion5;}
    public String getGraquestion6() {return graquestion6;}
    public String getGraquestion7() {return graquestion7;}
    public String getGraquestion8() {return graquestion8;}
    public String getGra_location() {return gra_location;}
    public Uri getFarmer_photo() {return farmer_photo;}
    public String getSignature() {return signature;}
    public String getUserFname() {return userFname;}
    public String getUserLname() {return userLname;}
    public String getUserEmail() {return userEmail;}
    public String getOnCreate() {return onCreate;}
    public String getOnUpdate() {return onUpdate;}

    public void setGraquestion1(String graquestion1) {this.graquestion1 = graquestion1;}
    public void setGraquestion2(String graquestion2) {this.graquestion2 = graquestion2;}
    public void setGraquestion3(String graquestion3) {this.graquestion3 = graquestion3;}
    public void setGraquestion4(String graquestion4) {this.graquestion4 = graquestion4;}
    public void setGraquestion5(String graquestion5) {this.graquestion5 = graquestion5;}
    public void setGraquestion6(String graquestion6) {this.graquestion6 = graquestion6;}
    public void setGraquestion7(String graquestion7) {this.graquestion7 = graquestion7;}
    public void setGraquestion8(String graquestion8) {this.graquestion8 = graquestion8;}
    public void setGra_location(String gra_location) {this.gra_location = gra_location;}
    public void setFarmer_photo(Uri farmer_photo) {this.farmer_photo = farmer_photo;}
    public void setSignature(String signature) {this.signature = signature;}
    public void setUserFname(String userFname) {this.userFname = userFname;}
    public void setUserLname(String userLname) {this.userLname = userLname;}
    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}
    public void setOnCreate(String onCreate) {this.onCreate = onCreate;}
    public void setOnUpdate(String onUpdate) {this.onUpdate = onUpdate;}
}
