package com.jacob.fruitoftek.safecrop.sustain.pentry;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class PeModel implements Parcelable {

    private int id;
    private String pequestion1;
    private String pequestion2;
    private String pequestion3;
    private String pequestion4;
    private String pequestion5;
    private String pequestion6;
    private String pequestion7;
    private String pequestion8;
    private String pequestion9;
    private String pequestion10;
    private String pequestion11;
    private String pequestion12;
    private String pequestion13;
    private String pequestion14;
    private Uri farmer_photo;
    private String userFname;
    private String userLname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public PeModel(int id, String pequestion1, String pequestion2, String pequestion3,
                   String pequestion4, String pequestion5, String pequestion6, String pequestion7,
                   String pequestion8, String pequestion9, String pequestion10, String pequestion11,
                   String pequestion12, String pequestion13, String pequestion14, Uri farmer_photo,
                   String userFname, String userLname, String userEmail, String onCreate, String onUpdate) {
        this.id = id;
        this.pequestion1 = pequestion1;
        this.pequestion2 = pequestion2;
        this.pequestion3 = pequestion3;
        this.pequestion4 = pequestion4;
        this.pequestion5 = pequestion5;
        this.pequestion6 = pequestion6;
        this.pequestion7 = pequestion7;
        this.pequestion8 = pequestion8;
        this.pequestion9 = pequestion9;
        this.pequestion10 = pequestion10;
        this.pequestion11 = pequestion11;
        this.pequestion12 = pequestion12;
        this.pequestion13 = pequestion13;
        this.pequestion14 = pequestion14;
        this.farmer_photo = farmer_photo;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
        this.onCreate = onCreate;
        this.onUpdate = onUpdate;
    }

    protected PeModel(Parcel in) {
        id = in.readInt();
        pequestion1 = in.readString();
        pequestion2 = in.readString();
        pequestion3 = in.readString();
        pequestion4 = in.readString();
        pequestion5 = in.readString();
        pequestion6 = in.readString();
        pequestion7 = in.readString();
        pequestion8 = in.readString();
        pequestion9 = in.readString();
        pequestion10 = in.readString();
        pequestion11 = in.readString();
        pequestion12 = in.readString();
        pequestion13 = in.readString();
        pequestion14 = in.readString();
        farmer_photo = in.readParcelable(Uri.class.getClassLoader());
        userFname = in.readString();
        userLname = in.readString();
        userEmail = in.readString();
        onCreate = in.readString();
        onUpdate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(pequestion1);
        dest.writeString(pequestion2);
        dest.writeString(pequestion3);
        dest.writeString(pequestion4);
        dest.writeString(pequestion5);
        dest.writeString(pequestion6);
        dest.writeString(pequestion7);
        dest.writeString(pequestion8);
        dest.writeString(pequestion9);
        dest.writeString(pequestion10);
        dest.writeString(pequestion11);
        dest.writeString(pequestion12);
        dest.writeString(pequestion13);
        dest.writeString(pequestion14);
        dest.writeParcelable(farmer_photo, flags);
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

    public static final Creator<PeModel> CREATOR = new Creator<PeModel>() {
        @Override
        public PeModel createFromParcel(Parcel in) {
            return new PeModel(in);
        }

        @Override
        public PeModel[] newArray(int size) {
            return new PeModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and setters
    public String getPequestion1() {
        return pequestion1;
    }

    public void setPequestion1(String pequestion1) {
        this.pequestion1 = pequestion1;
    }

    public String getPequestion2() {
        return pequestion2;
    }

    public void setPequestion2(String pequestion2) {
        this.pequestion2 = pequestion2;
    }

    public String getPequestion3() {
        return pequestion3;
    }

    public void setPequestion3(String pequestion3) {
        this.pequestion3 = pequestion3;
    }

    public String getPequestion4() {
        return pequestion4;
    }

    public void setPequestion4(String pequestion4) {
        this.pequestion4 = pequestion4;
    }

    public String getPequestion5() {
        return pequestion5;
    }

    public void setPequestion5(String pequestion5) {
        this.pequestion5 = pequestion5;
    }

    public String getPequestion6() {
        return pequestion6;
    }

    public void setPequestion6(String pequestion6) {
        this.pequestion6 = pequestion6;
    }

    public String getPequestion7() {
        return pequestion7;
    }

    public void setPequestion7(String pequestion7) {
        this.pequestion7 = pequestion7;
    }

    public String getPequestion8() {
        return pequestion8;
    }

    public void setPequestion8(String pequestion8) {
        this.pequestion8 = pequestion8;
    }

    public String getPequestion9() {
        return pequestion9;
    }

    public void setPequestion9(String pequestion9) {
        this.pequestion9 = pequestion9;
    }

    public String getPequestion10() {
        return pequestion10;
    }

    public void setPequestion10(String pequestion10) {
        this.pequestion10 = pequestion10;
    }

    public String getPequestion11() {
        return pequestion11;
    }

    public void setPequestion11(String pequestion11) {
        this.pequestion11 = pequestion11;
    }

    public String getPequestion12() {
        return pequestion12;
    }

    public void setPequestion12(String pequestion12) {
        this.pequestion12 = pequestion12;
    }

    public String getPequestion13() {
        return pequestion13;
    }

    public void setPequestion13(String pequestion13) {
        this.pequestion13 = pequestion13;
    }

    public String getPequestion14() {
        return pequestion14;
    }

    public void setPequestion14(String pequestion14) {
        this.pequestion14 = pequestion14;
    }

    public Uri getFarmer_photo() {
        return farmer_photo;
    }

    public void setFarmer_photo(Uri farmer_photo) {
        this.farmer_photo = farmer_photo;
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
