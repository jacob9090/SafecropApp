package com.jacob.fruitoftek.safecrop.farmerlist;

import java.io.Serializable;

public class FarmerListModal implements Serializable {

    private String district;
    private String village;
    private String fid;
    private String name;
    private String ghanaCard;
    private String yob;
    private String phone;
    private String gender;
    private String photo;

    public FarmerListModal(String district, String village, String fid, String name, String ghanaCard, String yob, String phone, String gender, String photo) {
        this.district = district;
        this.village = village;
        this.fid = fid;
        this.name = name;
        this.ghanaCard = ghanaCard;
        this.yob = yob;
        this.phone = phone;
        this.gender = gender;
        this.photo = photo;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public String getGhanaCard() {
        return ghanaCard;
    }

    public String getYob() {
        return yob;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGhanaCard(String ghanaCard) {
        this.ghanaCard = ghanaCard;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
