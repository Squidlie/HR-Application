package com.astontech.hr.bootstrap;


import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        generateElementAndElementTypes();
        generateVehiclesMakesAndModels();
    }

    private void generateElementAndElementTypes(){
        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);

        ElementType emailType = new ElementType("Email");

        List<Element> emailList = new ArrayList<>();
        emailList.add(new Element("Work"));
        emailList.add(new Element("Personal"));
        emailList.add(new Element("Delegated"));

        emailType.setElementList(emailList);

        elementTypeService.saveElementType(emailType);
    }

    private void generateVehiclesMakesAndModels(){

        VehicleMake ford = new VehicleMake("Ford");
        VehicleMake toyota = new VehicleMake("Toyota");

        VehicleModel f150 = new VehicleModel("F-150");
        VehicleModel mustang = new VehicleModel("Mustang");
        VehicleModel explorer = new VehicleModel("Explorer");
        VehicleModel taurus = new VehicleModel("Taurus");
        f150.setVehicleMake(ford);
        mustang.setVehicleMake(ford);
        explorer.setVehicleMake(ford);
        taurus.setVehicleMake(ford);

        Vehicle v1 = new Vehicle(2000, "AAA111", "111111111111", "Red", true, 20000, 0);
        Vehicle v2 = new Vehicle(2001, "BBB222", "222222222222", "Orange", false, 0, 1);
        v1.setVehicleModel(f150);
        v2.setVehicleModel(f150);
        Vehicle v3 = new Vehicle(2002, "CCC333", "333333333333", "Yellow", true, 21000, 2);
        Vehicle v4 = new Vehicle(2003, "DDD444", "444444444444", "Green", false, 0, 3);
        v3.setVehicleModel(mustang);
        v4.setVehicleModel(mustang);
        Vehicle v5 = new Vehicle(2004, "EEE555", "555555555555", "Blue", true, 22000, 4);
        Vehicle v6 = new Vehicle(2005, "FFF666", "666666666666", "Indigo", false, 0, 5);
        v5.setVehicleModel(explorer);
        v6.setVehicleModel(explorer);
        Vehicle v7 = new Vehicle(2006,"GGG777", "777777777777", "Violet", true, 23000, 6);
        Vehicle v8 = new Vehicle(2007,"HHH888", "888888888888", "Black", false, 0, 7);
        v7.setVehicleModel(taurus);
        v8.setVehicleModel(taurus);

        VehicleModel prius = new VehicleModel("Prius");
        VehicleModel camry = new VehicleModel("Camry");
        VehicleModel corolla = new VehicleModel("Corolla");
        VehicleModel rav4 = new VehicleModel("RAV4");
        prius.setVehicleMake(toyota);
        camry.setVehicleMake(toyota);
        corolla.setVehicleMake(toyota);
        rav4.setVehicleMake(toyota);

        Vehicle v9 = new Vehicle(2008, "AAA111", "010101010101", "Violet", true, 24000, 8);
        Vehicle v10 = new Vehicle(2009, "AAA222", "121212121212", "Indigo", false, 0, 9);
        v9.setVehicleModel(prius);
        v10.setVehicleModel(prius);
        Vehicle v11 = new Vehicle(2010, "AAA333", "232323232323", "Blue", true, 25000, 10);
        Vehicle v12 = new Vehicle(2011,"AAA444", "343434343434", "Green", false, 0, 11);
        v11.setVehicleModel(camry);
        v12.setVehicleModel(camry);
        Vehicle v13 = new Vehicle(2012, "AAA555", "454545454545", "Yellow", true, 26000, 12);
        Vehicle v14 = new Vehicle(2013, "AAA666", "565656565656", "Orange", false, 0,13);
        v13.setVehicleModel(corolla);
        v14.setVehicleModel(corolla);
        Vehicle v15 = new Vehicle(2014, "AAA777", "676767676767", "Red", true, 27000, 14);
        Vehicle v16 = new Vehicle(2015, "AAA888", "787878787878", "Gray", false, 0, 15);
        v15.setVehicleModel(rav4);
        v16.setVehicleModel(rav4);
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(v1);
        vehicleList.add(v2);
        vehicleList.add(v3);
        vehicleList.add(v4);
        vehicleList.add(v5);
        vehicleList.add(v6);
        vehicleList.add(v7);
        vehicleList.add(v8);
        vehicleList.add(v9);
        vehicleList.add(v10);
        vehicleList.add(v11);
        vehicleList.add(v12);
        vehicleList.add(v13);
        vehicleList.add(v14);
        vehicleList.add(v15);
        vehicleList.add(v16);
        List<VehicleModel> modelList = new ArrayList<>();
        modelList.add(f150);
        modelList.add(mustang);
        modelList.add(explorer);
        modelList.add(taurus);
        modelList.add(prius);
        modelList.add(camry);
        modelList.add(corolla);
        modelList.add(rav4);
        List<VehicleMake> makeList = new ArrayList<>();
        makeList.add(ford);
        makeList.add(toyota);

        vehicleMakeService.saveVehicleMakeList(makeList);
        vehicleModelService.saveVehicleModelList(modelList);
        vehicleService.saveVehicleList(vehicleList);

    }
}
