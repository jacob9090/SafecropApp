package com.jacob.fruitoftek.safecrop.farmerlist;

import java.io.Serializable;

public class FarmerListModal implements Serializable {

    private String district;
    private String community;
    private String farmer_id;
    private String farmer_name;
    private String ghana_card;
    private String farmer_yob;
    private String farmer_phone;
    private String farmer_gender;
    private String photo;

    public FarmerListModal(String district, String community, String farmer_id, String farmer_name, String ghana_card, String farmer_yob, String farmer_phone, String farmer_gender, String photo) {
        this.district = district;
        this.community = community;
        this.farmer_id = farmer_id;
        this.farmer_name = farmer_name;
        this.ghana_card = ghana_card;
        this.farmer_yob = farmer_yob;
        this.farmer_phone = farmer_phone;
        this.farmer_gender = farmer_gender;
        this.photo = photo;
    }

    public String getDistrict() {
        return district;
    }

    public String getCommunity() {
        return community;
    }

    public String getFarmer_id() {
        return farmer_id;
    }

    public String getFarmer_name() {
        return farmer_name;
    }

    public String getGhana_card() {
        return ghana_card;
    }

    public String getFarmer_yob() {
        return farmer_yob;
    }

    public String getFarmer_phone() {
        return farmer_phone;
    }

    public String getFarmer_gender() {
        return farmer_gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public void setFarmer_id(String farmer_id) {
        this.farmer_id = farmer_id;
    }

    public void setFarmer_name(String farmer_name) {
        this.farmer_name = farmer_name;
    }

    public void setGhana_card(String ghana_card) {
        this.ghana_card = ghana_card;
    }

    public void setFarmer_yob(String farmer_yob) {
        this.farmer_yob = farmer_yob;
    }

    public void setFarmer_phone(String farmer_phone) {
        this.farmer_phone = farmer_phone;
    }

    public void setFarmer_gender(String farmer_gender) {
        this.farmer_gender = farmer_gender;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
