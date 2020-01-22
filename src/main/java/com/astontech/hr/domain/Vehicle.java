package com.astontech.hr.domain;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleId")
    private Integer id;

    @Version
    private Integer version;

    private int pageId;
    private int Year;
    private String LicensePlate;
    private String VIN;
    private String Color;
    private boolean IsPurchase;
    private int PurchasePrice;

    @ManyToOne
    private VehicleModel vehicleModel;


    public Vehicle(){}
    public Vehicle(int year){
        this.setYear(year);
    }
    public Vehicle(String licensePlate){
        this.setLicensePlate(licensePlate);
    }
    public Vehicle(int year, String licensePlate, String vin, String color, int purchasePrice, int pageId){
        this.setYear(year);
        this.setLicensePlate(licensePlate);
        this.setVIN(vin);
        this.setColor(color);
        this.setPurchasePrice(purchasePrice);
        this.setPageId(pageId);
    }
    public Vehicle(int year, String licensePlate, String vin, String color, boolean isPurchase, int purchasePrice, int pageId){
        this.setYear(year);
        this.setLicensePlate(licensePlate);
        this.setVIN(vin);
        this.setColor(color);
        this.setPurchase(isPurchase);
        this.setPurchasePrice(purchasePrice);
        this.setPageId(pageId);
    }
    public Vehicle(int year, String licensePlate, String vin, String color, boolean isPurchase, int purchasePrice, VehicleModel vehicleModel){
        this.setYear(year);
        this.setLicensePlate(licensePlate);
        this.setVIN(vin);
        this.setColor(color);
        this.setPurchase(isPurchase);
        this.setPurchasePrice(purchasePrice);
        this.setVehicleModel(vehicleModel);
    }

    public Integer getIdByPageId(Integer pageId){
        if(pageId == this.getPageId()){
            return getId();
        } else
            return 0;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getYear() {
        return Year;
    }
    public void setYear(int year) {
        Year = year;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVIN() {
        return VIN;
    }
    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return Color;
    }
    public void setColor(String color) {
        Color = color;
    }

    public boolean isPurchase() {
        return IsPurchase;
    }
    public void setPurchase(boolean purchase) {
        IsPurchase = purchase;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }
    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }
    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getPageId() {
        return pageId;
    }
    public void setPageId(int pageId) {
        this.pageId = pageId;
    }
}
