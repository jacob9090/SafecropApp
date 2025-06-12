package com.jacob.fruitoftek.safecrop.comdev.lra;

import android.os.Parcel;
import android.os.Parcelable;

public class LraModel implements Parcelable {

    private int id;
    private String lraquestion1;
    private String lraquestion2;
    private String lraquestion3;
    private String lraquestion4;
    private String lraquestion5;
    private String lraquestion6;
    private String lraquestion7;
    private String lraquestion8;
    private String lraquestion9;
    private String lraquestion10;
    private String lra_location;
    private String signature;
    private String userFname;
    private String userLname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public LraModel(int id, String lraquestion1,
                    String lraquestion2, String lraquestion3, String lraquestion4, String lraquestion5,
                    String lraquestion6, String lraquestion7, String lraquestion8, String lraquestion9,
                    String lraquestion10, String lra_location, String signature,
                    String userFname, String userLname, String userEmail, String onCreate, String onUpdate) {
        this.id = id;
        this.lraquestion1 = lraquestion1;
        this.lraquestion2 = lraquestion2;
        this.lraquestion3 = lraquestion3;
        this.lraquestion4 = lraquestion4;
        this.lraquestion5 = lraquestion5;
        this.lraquestion6 = lraquestion6;
        this.lraquestion7 = lraquestion7;
        this.lraquestion8 = lraquestion8;
        this.lraquestion9 = lraquestion9;
        this.lraquestion10 = lraquestion10;
        this.lra_location = lra_location;
        this.signature = signature;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
        this.onCreate = onCreate;
        this.onUpdate = onUpdate;
    }

    protected LraModel(Parcel in) {
        id = in.readInt();
        lraquestion1 = in.readString();
        lraquestion2 = in.readString();
        lraquestion3 = in.readString();
        lraquestion4 = in.readString();
        lraquestion5 = in.readString();
        lraquestion6 = in.readString();
        lraquestion7 = in.readString();
        lraquestion8 = in.readString();
        lraquestion9 = in.readString();
        lraquestion10 = in.readString();
        lra_location = in.readString();
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
        dest.writeString(lraquestion1);
        dest.writeString(lraquestion2);
        dest.writeString(lraquestion3);
        dest.writeString(lraquestion4);
        dest.writeString(lraquestion5);
        dest.writeString(lraquestion6);
        dest.writeString(lraquestion7);
        dest.writeString(lraquestion8);
        dest.writeString(lraquestion9);
        dest.writeString(lraquestion10);
        dest.writeString(lra_location);
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

    public static final Creator<LraModel> CREATOR = new Creator<LraModel>() {
        @Override
        public LraModel createFromParcel(Parcel in) {
            return new LraModel(in);
        }

        @Override
        public LraModel[] newArray(int size) {
            return new LraModel[size];
        }
    };

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    // Getters and setters

    public String getLraquestion1() {
        return lraquestion1;
    }

    public void setLraquestion1(String lraquestion1) {
        this.lraquestion1 = lraquestion1;
    }

    public String getLraquestion2() {
        return lraquestion2;
    }

    public void setLraquestion2(String lraquestion2) {
        this.lraquestion2 = lraquestion2;
    }

    public String getLraquestion3() {
        return lraquestion3;
    }

    public void setLraquestion3(String lraquestion3) {
        this.lraquestion3 = lraquestion3;
    }

    public String getLraquestion4() {
        return lraquestion4;
    }

    public void setLraquestion4(String lraquestion4) {
        this.lraquestion4 = lraquestion4;
    }

    public String getLraquestion5() {
        return lraquestion5;
    }

    public void setLraquestion5(String lraquestion5) {
        this.lraquestion5 = lraquestion5;
    }

    public String getLraquestion6() {
        return lraquestion6;
    }

    public void setLraquestion6(String lraquestion6) {
        this.lraquestion6 = lraquestion6;
    }

    public String getLraquestion7() {
        return lraquestion7;
    }

    public void setLraquestion7(String lraquestion7) {
        this.lraquestion7 = lraquestion7;
    }

    public String getLraquestion8() {
        return lraquestion8;
    }

    public void setLraquestion8(String lraquestion8) {
        this.lraquestion8 = lraquestion8;
    }

    public String getLraquestion9() {
        return lraquestion9;
    }

    public void setLraquestion9(String lraquestion9) {
        this.lraquestion9 = lraquestion9;
    }

    public String getLraquestion10() {
        return lraquestion10;
    }

    public void setLraquestion10(String lraquestion10) {
        this.lraquestion10 = lraquestion10;
    }

    public String getLra_location() {
        return lra_location;
    }

    public void setLra_location(String lra_location) {
        this.lra_location = lra_location;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getOnCreate() {
        return onCreate;
    }

    public void setOnCreate(String onCreate) {
        this.onCreate = onCreate;
    }

    public String getOnUpdate() {
        return onUpdate;
    }

    public void setOnUpdate(String onUpdate) {
        this.onUpdate = onUpdate;
    }
}
