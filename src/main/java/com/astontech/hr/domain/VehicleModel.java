package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleModelId")
    private Integer id;

    @Version
    private Integer version;

    private String VehicleModelName;

    @ManyToOne
    private VehicleMake vehicleMake;

    public VehicleModel(){}
    public VehicleModel(String vehicleModelName){
        this.setVehicleModelName(vehicleModelName);
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

    public String getVehicleModelName() {
        return VehicleModelName;
    }
    public void setVehicleModelName(String vehicleModelName) {
        VehicleModelName = vehicleModelName;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }
    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
}
