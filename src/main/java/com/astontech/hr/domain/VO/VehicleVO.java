package com.astontech.hr.domain.VO;

public class VehicleVO {

    private String newVehicleMake;
    private String newVehicleModel;
    private String newVehicles;
    private String[] newVehicleModelArray;
    private String[] newVehicleArray;

    private String pageId;
    private String newYear;
    private String newLicensePlate;
    private String newVIN;
    private String newColor;
    private boolean newIsPurchase;
    private String newPurchasePrice;

    public VehicleVO() {
    }

    public void splitNewVehicleModelsIntoArray() {
        this.setNewVehicleModelArray(this.getNewVehicleModel().split("\\r?\\n"));
    }

    public void splitNewVehiclesIntoArray() {
        this.setNewVehicleArray(this.getNewYear().split(","));
    }

    public String getNewVehicleMake() {
        return newVehicleMake;
    }

    public void setNewVehicleMake(String newVehicleMake) {
        this.newVehicleMake = newVehicleMake;
    }

    public String getNewVehicleModel() {
        return newVehicleModel;
    }

    public void setNewVehicleModel(String newVehicleModel) {
        this.newVehicleModel = newVehicleModel;
    }

    public String getNewVehicles() {
        return newVehicles;
    }

    public void setNewVehicles(String newVehicles) {
        this.newVehicles = newVehicles;
    }

    public String[] getNewVehicleModelArray() {
        return newVehicleModelArray;
    }

    public void setNewVehicleModelArray(String[] newVehicleModelArray) {
        this.newVehicleModelArray = newVehicleModelArray;
    }

    public String[] getNewVehicleArray() {
        return newVehicleArray;
    }

    public void setNewVehicleArray(String[] newVehicleArray) {
        this.newVehicleArray = newVehicleArray;
    }

    public String getNewYear() {
        return newYear;
    }
    public void setNewYear(String newYear) {
        this.newYear = newYear;
    }

    public String getNewLicensePlate() {
        return newLicensePlate;
    }
    public void setNewLicensePlate(String newLicensePlate) {
        this.newLicensePlate = newLicensePlate;
    }

    public String getNewVIN() {
        return newVIN;
    }
    public void setNewVIN(String newVIN) {
        this.newVIN = newVIN;
    }

    public String getNewColor() {
        return newColor;
    }
    public void setNewColor(String newColor) {
        this.newColor = newColor;
    }

    public boolean isNewIsPurchase() {
        return newIsPurchase;
    }
    public void setNewIsPurchase(boolean newIsPurchase) {
        this.newIsPurchase = newIsPurchase;
    }

    public String getNewPurchasePrice() {
        return newPurchasePrice;
    }
    public void setNewPurchasePrice(String newPurchasePrice) {
        this.newPurchasePrice = newPurchasePrice;
    }

    public String getPageId() {
        return pageId;
    }
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
}