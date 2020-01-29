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

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
//        generateElementAndElementTypes();
//        generateVehiclesMakesAndModels();
//        generateEmployees();
//        generateContactsAndAddresses();
    }

    private void generateContactsAndAddresses(){
        Element workEmail = elementService.getElementById(6);
        Element personalEmail = elementService.getElementById(7);
        Element homePhone = elementService.getElementById(9);
        Element workPhone = elementService.getElementById(10);
        Element cellPhone = elementService.getElementById(11);


        Person bipin = employeeService.getEmployeeById(1);
        List<Contact> bipinList = new ArrayList<>();
        bipinList.add(new Contact(bipin, personalEmail, "bipinsemail@bipin.com","null"));
        bipinList.add(new Contact(bipin, workEmail, "bipinsemail@astontech.com","null"));
        bipinList.add(new Contact(bipin, homePhone, "null", "1112223333"));
        bipinList.add(new Contact(bipin, workPhone, "null","1111111111"));
        bipinList.add(new Contact(bipin, cellPhone, "null","1212121212"));
        contactService.saveContactList(bipinList);

        Address bip1 = new Address(123, "Main St", "Minneapolis", "MN", "United States");
        Address bip2 = new Address(1111, "Street Street", "Saint Paul", "MN", "United States");
        bip1.setPerson(bipin);
        bip2.setPerson(bipin);
        addressService.saveAddress(bip1);
        addressService.saveAddress(bip2);


        Person tony = employeeService.getEmployeeById(2);
        List<Contact> tonyList = new ArrayList<>();
        tonyList.add(new Contact(tony, personalEmail, "tonysemail@tony.com","null"));
        tonyList.add(new Contact(tony, workEmail, "tonysemail@astontech.com","null"));
        tonyList.add(new Contact(tony, homePhone, "null","1223334444"));
        tonyList.add(new Contact(tony, workPhone, "null","1222222222"));
        tonyList.add(new Contact(tony, cellPhone, "null","1231232323"));
        contactService.saveContactList(tonyList);

        Address tony1 = new Address(123, "Main St", "St. Louis Park", "MN", "United States");
        Address tony2 = new Address(2222, "Tony Street", "Bloomington", "MN", "United States");
        tony1.setPerson(tony);
        tony2.setPerson(tony);
        addressService.saveAddress(tony1);
        addressService.saveAddress(tony2);


        Person eric = employeeService.getEmployeeById(3);
        List<Contact> ericList = new ArrayList<>();
        ericList.add(new Contact(eric, personalEmail, "ericsemail@eric.com","null"));
        ericList.add(new Contact(eric, workEmail, "ericsemail@astontech.com","null"));
        ericList.add(new Contact(eric, homePhone, "null","1334445555"));
        ericList.add(new Contact(eric, workPhone, "null","1333333333"));
        ericList.add(new Contact(eric, cellPhone, "null","1341343434"));
        contactService.saveContactList(ericList);

        Address eric1 = new Address(123, "Eric St", "Saint Paul", "MN", "United States");
        eric1.setPerson(eric);
        addressService.saveAddress(eric1);


        Person justin = employeeService.getEmployeeById(4);
        List<Contact> justinList = new ArrayList<>();
        justinList.add(new Contact(justin, personalEmail, "justinsemail@justin.com","null"));
        justinList.add(new Contact(justin, workEmail, "justinsemail@astontech.com","null"));
        justinList.add(new Contact(justin, homePhone, "null","1445556666"));
        justinList.add(new Contact(justin, workPhone, "null","1444444444"));
        justinList.add(new Contact(justin, cellPhone, "null","1451454545"));
        contactService.saveContactList(justinList);

        Address justin1 = new Address(123, "Justin St", "Saint Paul", "MN", "United States");
        justin1.setPerson(justin);
        addressService.saveAddress(justin1);


        Person dan = employeeService.getEmployeeById(5);
        List<Contact> danList = new ArrayList<>();
        danList.add(new Contact(dan, personalEmail, "dansemail@dan.com","null"));
        danList.add(new Contact(dan, workEmail, "dansemail@astontech.com","null"));
        danList.add(new Contact(dan, homePhone, "null","1556667777"));
        danList.add(new Contact(dan, workPhone, "null","1555555555"));
        danList.add(new Contact(dan, cellPhone, "null","1561565656"));
        contactService.saveContactList(danList);

        Address dan1 = new Address(123, "Dan St", "Minneapolis", "MN", "United States");
        dan1.setPerson(dan);
        addressService.saveAddress(dan1);


        Person sean = employeeService.getEmployeeById(6);
        List<Contact> seanList = new ArrayList<>();
        seanList.add(new Contact(sean, personalEmail, "seansemail@sean.com","null"));
        seanList.add(new Contact(sean, workEmail, "seansemail@astontech.com", "null"));
        seanList.add(new Contact(sean, homePhone, "null","1667778888"));
        seanList.add(new Contact(sean, workPhone, "null","1666666666"));
        seanList.add(new Contact(sean, cellPhone, "null","1671676767"));
        contactService.saveContactList(seanList);

        Address sean1 = new Address(123, "Sean St", "Minneapolis", "MN", "United States");
        sean1.setPerson(sean);
        addressService.saveAddress(sean1);
    }

    private void generateEmployees(){
        Employee emp1 = new Employee();
        emp1.setFirstName("Bipin");
        emp1.setLastName("Butala");
        emp1.setBackground("Java Developer");
        employeeService.saveEmployee(emp1);

        Employee emp2 = new Employee();
        emp2.setFirstName("Tony");
        emp2.setLastName("Morano");
        emp2.setBackground("Java Developer");
        employeeService.saveEmployee(emp2);

        Employee emp3 = new Employee();
        emp3.setFirstName("Dan");
        emp3.setLastName("Simmer");
        emp3.setBackground("DotNet Developer");
        employeeService.saveEmployee(emp3);

        Employee emp4 = new Employee();
        emp4.setFirstName("Sean");
        emp4.setLastName("Nilsen");
        emp4.setBackground("Contact Center Engineer");
        employeeService.saveEmployee(emp4);
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
