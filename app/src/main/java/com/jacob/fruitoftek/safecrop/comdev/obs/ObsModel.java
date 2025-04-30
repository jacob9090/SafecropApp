package com.jacob.fruitoftek.safecrop.comdev.obs;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class ObsModel implements Parcelable {

    private int id; // Add id field
    private String obs_name;
    private String obs_district;
    private String obs_community;
    private String obsquestion6;
    private String obsquestion7;
    private String obsquestion8;
    private String obsquestion9;
    private String obsquestion10;
    private String obsquestion11;
    private String obsquestion12;
    private String obsquestion13;
    private String obsquestion14;
    private String obsquestion15;
    private String obsquestion16;
    private String obsquestion17;
    private String obsquestion18;
    private String obsquestion19;
    private String obsquestion20;
    private String obsquestion21;
    private String obs_location;
    private Uri farmer_photo;
    private String signature;
    private String userFname;
    private String userOname;
    private String userEmail;
    private String onCreate;
    private String onUpdate;

    public ObsModel(int id, String obs_name, String obs_district, String obs_community,
                    String obsquestion6, String obsquestion7, String obsquestion8, String obsquestion9, String obsquestion10,
                    String obsquestion11, String obsquestion12, String obsquestion13, String obsquestion14, String obsquestion15,
                    String obsquestion16, String obsquestion17, String obsquestion18, String obsquestion19, String obsquestion20,
                    String obsquestion21, String obs_location, Uri farmer_photo, String signature, String userFname, String userOname,
                    String userEmail, String onCreate, String onUpdate) {
        this.id = id;
        this.obs_name = obs_name;
        this.obs_district = obs_district;
        this.obs_community = obs_community;
        this.obsquestion6 = obsquestion6;
        this.obsquestion7 = obsquestion7;
        this.obsquestion8 = obsquestion8;
        this.obsquestion9 = obsquestion9;
        this.obsquestion10 = obsquestion10;
        this.obsquestion11 = obsquestion11;
        this.obsquestion12 = obsquestion12;
        this.obsquestion13 = obsquestion13;
        this.obsquestion14 = obsquestion14;
        this.obsquestion15 = obsquestion15;
        this.obsquestion16 = obsquestion16;
        this.obsquestion17 = obsquestion17;
        this.obsquestion18 = obsquestion18;
        this.obsquestion19 = obsquestion19;
        this.obsquestion20 = obsquestion20;
        this.obsquestion21 = obsquestion21;
        this.obs_location = obs_location;
        this.farmer_photo = farmer_photo;
        this.signature = signature;
        this.userFname = userFname;
        this.userOname = userOname;
        this.userEmail = userEmail;
        this.onCreate = onCreate;
        this.onUpdate = onUpdate;
    }

    protected ObsModel(Parcel in) {
        id = in.readInt();
        obs_name = in.readString();
        obs_district = in.readString();
        obs_community = in.readString();
        obsquestion6 = in.readString();
        obsquestion7 = in.readString();
        obsquestion8 = in.readString();
        obsquestion9 = in.readString();
        obsquestion10 = in.readString();
        obsquestion11 = in.readString();
        obsquestion12 = in.readString();
        obsquestion13 = in.readString();
        obsquestion14 = in.readString();
        obsquestion15 = in.readString();
        obsquestion16 = in.readString();
        obsquestion17 = in.readString();
        obsquestion18 = in.readString();
        obsquestion19 = in.readString();
        obsquestion20 = in.readString();
        obsquestion21 = in.readString();
        obs_location = in.readString();
        farmer_photo = in.readParcelable(Uri.class.getClassLoader());
        signature = in.readString();
        userFname = in.readString();
        userOname = in.readString();
        userEmail = in.readString();
        onCreate = in.readString();
        onUpdate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(obs_name);
        dest.writeString(obs_district);
        dest.writeString(obs_community);
        dest.writeString(obsquestion6);
        dest.writeString(obsquestion7);
        dest.writeString(obsquestion8);
        dest.writeString(obsquestion9);
        dest.writeString(obsquestion10);
        dest.writeString(obsquestion11);
        dest.writeString(obsquestion12);
        dest.writeString(obsquestion13);
        dest.writeString(obsquestion14);
        dest.writeString(obsquestion15);
        dest.writeString(obsquestion16);
        dest.writeString(obsquestion17);
        dest.writeString(obsquestion18);
        dest.writeString(obsquestion19);
        dest.writeString(obsquestion20);
        dest.writeString(obsquestion21);
        dest.writeString(obs_location);
        dest.writeParcelable(farmer_photo, flags);
        dest.writeString(signature);
        dest.writeString(userFname);
        dest.writeString(userOname);
        dest.writeString(userEmail);
        dest.writeString(onCreate);
        dest.writeString(onUpdate);
    }

    @Override
    public int describeContents() {
        return 0; // No special contents in this Parcelable
    }

    public static final Creator<ObsModel> CREATOR = new Creator<ObsModel>() {
        @Override
        public ObsModel createFromParcel(Parcel in) {
            return new ObsModel(in);
        }

        @Override
        public ObsModel[] newArray(int size) {
            return new ObsModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and setters
    public String getObs_name() { return obs_name; }
    public String getObs_district() { return obs_district; }
    public String getObs_community() { return obs_community; }
    public String getObs_location() { return obs_location; }
    public String getSignature() { return signature; }
    public Uri getFarmer_photo() {return farmer_photo;}
    public String getUserFname() {return userFname;}
    public String getUserOname() {return userOname;}
    public String getUserEmail() {return userEmail;}
    public String getOnCreate() {return onCreate;}
    public String getOnUpdate() {return onUpdate;}

    public String getObsquestion6() {
        return obsquestion6;
    }

    public String getObsquestion7() {
        return obsquestion7;
    }

    public String getObsquestion8() {
        return obsquestion8;
    }

    public String getObsquestion9() {
        return obsquestion9;
    }

    public String getObsquestion10() {
        return obsquestion10;
    }

    public String getObsquestion11() {
        return obsquestion11;
    }

    public String getObsquestion12() {
        return obsquestion12;
    }

    public String getObsquestion13() {
        return obsquestion13;
    }

    public String getObsquestion14() {
        return obsquestion14;
    }

    public String getObsquestion15() {
        return obsquestion15;
    }

    public String getObsquestion16() {
        return obsquestion16;
    }

    public String getObsquestion17() {
        return obsquestion17;
    }

    public String getObsquestion18() {
        return obsquestion18;
    }

    public String getObsquestion19() {
        return obsquestion19;
    }

    public String getObsquestion20() {
        return obsquestion20;
    }

    public String getObsquestion21() {
        return obsquestion21;
    }

    public void setObs_name(String obs_name) { this.obs_name = obs_name; }
    public void setObs_district(String obs_district) { this.obs_district = obs_district; }
    public void setObs_community(String obs_community) { this.obs_community = obs_community; }
    public void setObs_location(String obs_location) { this.obs_location = obs_location; }
    public void setSignature(String signature) { this.signature = signature; }
    public void setFarmer_photo(Uri farmer_photo) {this.farmer_photo = farmer_photo;}
    public void setUserFname(String userFname) {this.userFname = userFname;}
    public void setUserOname(String userOname) {this.userOname = userOname;}
    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}
    public void setOnCreate(String onCreate) {this.onCreate = onCreate;}
    public void setOnUpdate(String onUpdate) {this.onUpdate = onUpdate;}

    public void setObsquestion6(String obsquestion6) {
        this.obsquestion6 = obsquestion6;
    }

    public void setObsquestion7(String obsquestion7) {
        this.obsquestion7 = obsquestion7;
    }

    public void setObsquestion8(String obsquestion8) {
        this.obsquestion8 = obsquestion8;
    }

    public void setObsquestion9(String obsquestion9) {
        this.obsquestion9 = obsquestion9;
    }

    public void setObsquestion10(String obsquestion10) {
        this.obsquestion10 = obsquestion10;
    }

    public void setObsquestion11(String obsquestion11) {
        this.obsquestion11 = obsquestion11;
    }

    public void setObsquestion12(String obsquestion12) {
        this.obsquestion12 = obsquestion12;
    }

    public void setObsquestion13(String obsquestion13) {
        this.obsquestion13 = obsquestion13;
    }

    public void setObsquestion14(String obsquestion14) {
        this.obsquestion14 = obsquestion14;
    }

    public void setObsquestion15(String obsquestion15) {
        this.obsquestion15 = obsquestion15;
    }

    public void setObsquestion16(String obsquestion16) {
        this.obsquestion16 = obsquestion16;
    }

    public void setObsquestion17(String obsquestion17) {
        this.obsquestion17 = obsquestion17;
    }

    public void setObsquestion18(String obsquestion18) {
        this.obsquestion18 = obsquestion18;
    }

    public void setObsquestion19(String obsquestion19) {
        this.obsquestion19 = obsquestion19;
    }

    public void setObsquestion20(String obsquestion20) {
        this.obsquestion20 = obsquestion20;
    }

    public void setObsquestion21(String obsquestion21) {
        this.obsquestion21 = obsquestion21;
    }
}
