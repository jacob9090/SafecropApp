package com.jacob.fruitoftek.safecrop.farmerlist;

import java.io.Serializable;

public class FarmerListModal implements Serializable {

    private String fid;
    private String name;
    private String surname;
    private String phone;
    private String district;
    private String village;
    private String photo;

    public FarmerListModal(String fid, String name, String surname, String phone, String district, String village, String photo) {
        this.fid = fid;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.district = district;
        this.village = village;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
