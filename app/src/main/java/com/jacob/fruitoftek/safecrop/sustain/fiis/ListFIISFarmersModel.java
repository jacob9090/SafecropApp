package com.jacob.fruitoftek.safecrop.sustain.fiis;

public class ListFIISFarmersModel {

    String farmerid, farmerName, farmerDistrict, farmerCommunity, farmerGhCad, farmerDoB, farmerCocoaFarms, farmerFarmSize, farmerPreviousHarvest, farmerPhone;
    int image ;

    public ListFIISFarmersModel(String farmerid, String farmerName, String farmerDistrict, String farmerCommunity, String farmerGhCad, String farmerDoB, String farmerCocoaFarms, String farmerFarmSize, String farmerPreviousHarvest, String farmerPhone, int image) {
        this.farmerid = farmerid;
        this.farmerName = farmerName;
        this.farmerDistrict = farmerDistrict;
        this.farmerCommunity = farmerCommunity;
        this.farmerGhCad = farmerGhCad;
        this.farmerDoB = farmerDoB;
        this.farmerCocoaFarms = farmerCocoaFarms;
        this.farmerFarmSize = farmerFarmSize;
        this.farmerPreviousHarvest = farmerPreviousHarvest;
        this.farmerPhone = farmerPhone;
        this.image = image;
    }

    public String getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(String farmerid) {
        this.farmerid = farmerid;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerDistrict() {
        return farmerDistrict;
    }

    public void setFarmerDistrict(String farmerDistrict) {
        this.farmerDistrict = farmerDistrict;
    }

    public String getFarmerCommunity() {
        return farmerCommunity;
    }

    public void setFarmerCommunity(String farmerCommunity) {
        this.farmerCommunity = farmerCommunity;
    }

    public String getFarmerGhCad() {
        return farmerGhCad;
    }

    public void setFarmerGhCad(String farmerGhCad) {
        this.farmerGhCad = farmerGhCad;
    }

    public String getFarmerDoB() {
        return farmerDoB;
    }

    public void setFarmerDoB(String farmerDoB) {
        this.farmerDoB = farmerDoB;
    }

    public String getFarmerCocoaFarms() {
        return farmerCocoaFarms;
    }

    public void setFarmerCocoaFarms(String farmerCocoaFarms) {
        this.farmerCocoaFarms = farmerCocoaFarms;
    }

    public String getFarmerFarmSize() {
        return farmerFarmSize;
    }

    public void setFarmerFarmSize(String farmerFarmSize) {
        this.farmerFarmSize = farmerFarmSize;
    }

    public String getFarmerPreviousHarvest() {
        return farmerPreviousHarvest;
    }

    public void setFarmerPreviousHarvest(String farmerPreviousHarvest) {
        this.farmerPreviousHarvest = farmerPreviousHarvest;
    }

    public String getFarmerPhone() {
        return farmerPhone;
    }

    public void setFarmerPhone(String farmerPhone) {
        this.farmerPhone = farmerPhone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
