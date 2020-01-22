package com.astontech.hr.controllers;

import com.astontech.hr.domain.*;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleService vehicleService;

    private Logger log = Logger.getLogger(AdminController.class);

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminHome(){
        return "admin/adminHome";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model){
        model.addAttribute("elementVO", new ElementVO());
        model.addAttribute("warningAlert", "visible");
        return "admin/element/element_add";
    }
    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO, Model model){
        elementVO.splitNewElementsIntoArray();
        logElementVO(elementVO);

        saveElementTypeAndElementsFromVO(elementVO);
        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("elementVO", new ElementVO());

        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model){
        model.addAttribute("elementTypeList", elementTypeService.listAllElementTypes());
        return "admin/element/element_list";
    }

    @RequestMapping(value= "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String elementTypeEdit(@PathVariable int id, Model model) {
        ElementType elementType = elementTypeService.getElementTypeById(id);

        model.addAttribute("elementType", elementType);
        return "admin/element/element_edit";
    }

    @RequestMapping(value ="/admin/element/delete/{id}", method = RequestMethod.GET)
    public String elementTypeDelete(@PathVariable int id) {
        elementTypeService.deleteElementType(id);
        return "redirect:/admin/element/list";
    }

    @RequestMapping(value = "/admin/element/update", method = RequestMethod.POST)
    public String elementTypeUpdate(ElementType elementType,
                                    Model model,
                                    @RequestParam("inputNewElement") String newElement) {
        if(!newElement.equals("")) {
            if(elementType.getElementList() == null){
                List<Element> elementList = new ArrayList<>();
                elementList.add(new Element(newElement));
                elementType.setElementList(elementList);
            } else {
            elementType.getElementList().add(new Element(newElement));
            }
        }

        for(int i =0; i < elementType.getElementList().size(); i++) {
            if(elementType.getElementList().get(i).getElementName().equals("")) {
                elementType.getElementList().remove(i);
            }
        }

        elementTypeService.saveElementType(elementType);
        return "redirect:/admin/element/edit/" + elementType.getId();
    }

    @RequestMapping(value = "/admin/vehicle/add/make", method = RequestMethod.GET)
    public String adminVehicleMakeGet(Model model){
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("warningAlert", "visible");
        return "admin/vehicle/vehicle_make_add";
    }
    @RequestMapping(value = "/admin/vehicle/add/make", method = RequestMethod.POST)
    public String adminVehicleMakePost(VehicleVO vehicleVO, Model model){
        vehicleVO.splitNewVehicleModelsIntoArray();
        logVehicleMakeVO(vehicleVO);

        saveVehicleMakeAndModelFromVO(vehicleVO);
        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        return "admin/vehicle/vehicle_make_add";
    }

    @RequestMapping(value = "/admin/vehicle/add/model", method = RequestMethod.GET)
    public String adminVehicleModelGet(Model model){
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("warningAlert", "visible");
        model.addAttribute("makeList", vehicleMakeService.listAllVehicleMakes());
        return "admin/vehicle/vehicle_model_add";
    }

    @RequestMapping(value = "/admin/vehicle/add/model", method = RequestMethod.POST)
    public String adminVehicleModelPost(VehicleVO vehicleVO, Model model){
        model.addAttribute("makeList", vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("modelList", vehicleModelService.listAllVehicleModels());
        logVehicleModelVO(vehicleVO);
        saveVehicleModelFromVO(vehicleVO);
        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        return "admin/vehicle/vehicle_model_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleGet(Model model){
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("warningAlert", "visible");
        model.addAttribute("makeList", vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("modelList", vehicleModelService.listAllVehicleModels());
        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String adminVehiclePost(VehicleVO vehicleVO, Model model){
        model.addAttribute("makeList", vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("modelList", vehicleModelService.listAllVehicleModels());
        Iterable<Vehicle> vehicleList = vehicleService.listAllVehicles();
        int counter = 0;
        for(Vehicle vehicle : vehicleList){
            counter++;
        }
        String pageIdString = Integer.toString(counter);
        vehicleVO.setPageId(pageIdString);
        logVehicleVO(vehicleVO);
        saveVehicleFromVO(vehicleVO);
        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");


        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String adminVehicleList(Model model){
        model.addAttribute("vehicleList", vehicleService.listAllVehicles());
        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value = "/admin/vehicle/edit", method = RequestMethod.GET)
    public String adminVehicleEditGet(Model model){
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleList", vehicleService.listAllVehicles());
        model.addAttribute("makeList", vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("modelList", vehicleModelService.listAllVehicleModels());
        return "admin/vehicle/vehicle_edit";
    }

    @RequestMapping(value ="/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String vehicleDelete(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        Iterable<Vehicle> vehicleList = vehicleService.listAllVehicles();
        int count = 0;
        for(Vehicle vehicle : vehicleList){
            for(int i=0; i <= count; i++){
                vehicle.setPageId(i);
            }
            count++;
        }
        vehicleService.saveVehicleList(vehicleList);
        return "redirect:/admin/vehicle/edit";
    }

    @RequestMapping(value = "/admin/vehicle/edit", method = RequestMethod.POST)
    public String adminVehicleEditPost(VehicleVO vehicleVO, Model model){
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleList", vehicleService.listAllVehicles());
        model.addAttribute("makeList", vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("modelList", vehicleModelService.listAllVehicleModels());
        String[] modelArray = vehicleVO.getNewVehicleModel().split(",");
        String[] licenseArray = vehicleVO.getNewLicensePlate().split(",");
        String[] vinArray = vehicleVO.getNewVIN().split(",");
        String[] yearArray = vehicleVO.getNewYear().split(",");
        String[] colorArray = vehicleVO.getNewColor().split(",");
        String[] priceArray = vehicleVO.getNewPurchasePrice().split(",");
        Iterable<Vehicle> vehicleList = vehicleService.listAllVehicles();
        for(Vehicle vehicle : vehicleList){
            for (int i=0; i < modelArray.length; i++) {
                if(vehicle.getPageId() == i) {
                    vehicle.setVehicleModel(vehicleModelService.getVehicleModelById(Integer.parseInt(modelArray[i])));
                }
            }
            for (int i=0; i < licenseArray.length; i++) {
                if(vehicle.getPageId() == i) {
                    vehicle.setLicensePlate(licenseArray[i]);
                }
            }
            for (int i=0; i < vinArray.length; i++) {
                if(vehicle.getPageId() == i) {
                    vehicle.setVIN(vinArray[i]);
                }
            }
            for (int i=0; i < yearArray.length; i++) {
                if(vehicle.getPageId() == i) {
                    vehicle.setYear(Integer.parseInt(yearArray[i]));
                }
            }
            for (int i=0; i < colorArray.length; i++) {
                if(vehicle.getPageId() == i) {
                    vehicle.setColor(colorArray[i]);
                }
            }
            for (int i=0; i < priceArray.length; i++) {
                if(vehicle.getPageId() == i) {
                    vehicle.setPurchasePrice(Integer.parseInt(priceArray[i]));
                }
            }
        }
        vehicleService.saveVehicleList(vehicleList);
        return "admin/vehicle/vehicle_edit";
    }


    private void saveElementTypeAndElementsFromVO(ElementVO elementVO){
        List<Element> newElementList = new ArrayList<>();
        for(String str : elementVO.getNewElementArray()) {
            newElementList.add(new Element(str));
        }
        ElementType newElementType = new ElementType(elementVO.getNewElementType());
        newElementType.setElementList(newElementList);

        elementTypeService.saveElementType(newElementType);
    }

    private void logElementVO(ElementVO elementVO) {
        log.info("New Element Type: " + elementVO.getNewElementType());
        for(String str : elementVO.getNewElementArray()){
            log.info("New Elements: " + str);
        }
    }

    private void saveVehicleMakeAndModelFromVO(VehicleVO vehicleVO){
        List<VehicleModel> newModelList = new ArrayList<>();
        for(String str : vehicleVO.getNewVehicleModelArray()) {
            newModelList.add(new VehicleModel(str));
        }
        VehicleMake newVehicleMake = new VehicleMake(vehicleVO.getNewVehicleMake());
        for(VehicleModel model : newModelList){
            model.setVehicleMake(newVehicleMake);
        }

        vehicleMakeService.saveVehicleMake(newVehicleMake);
        vehicleModelService.saveVehicleModelList(newModelList);
    }

    private void saveVehicleModelFromVO(VehicleVO vehicleVO){
        Iterable<VehicleMake> makeList= vehicleMakeService.listAllVehicleMakes();

        VehicleModel newModel = new VehicleModel(vehicleVO.getNewVehicleModel());
        for(VehicleMake make : makeList){
            if(make.getVehicleMakeName().equals(vehicleVO.getNewVehicleMake())){
                newModel.setVehicleMake(make);
            } else {
                log.info(newModel.getVehicleMake());
            }
        }
        vehicleModelService.saveVehicleModel(newModel);
    }

    private void saveVehicleFromVO(VehicleVO vehicleVO){
        Iterable<VehicleModel> modelList = vehicleModelService.listAllVehicleModels();

        Vehicle newVehicle = new Vehicle(Integer.parseInt(vehicleVO.getNewYear()),
                                         vehicleVO.getNewLicensePlate(),
                                         vehicleVO.getNewVIN(),
                                         vehicleVO.getNewColor(),
                                         Integer.parseInt(vehicleVO.getNewPurchasePrice()),
                                         Integer.parseInt(vehicleVO.getPageId()));
        for(VehicleModel model : modelList){
            if(model.getVehicleModelName().equals(vehicleVO.getNewVehicleModel())){
                newVehicle.setVehicleModel(model);
            } else {
                log.info(newVehicle.getVehicleModel());
            }
        }
        vehicleService.saveVehicle(newVehicle);
    }

    private void logVehicleMakeVO(VehicleVO vehicleVO) {
        log.info("New Make: " + vehicleVO.getNewVehicleMake());
        for(String str : vehicleVO.getNewVehicleModelArray()){
            log.info("New Models: " + str);
        }
    }

    private void logVehicleModelVO(VehicleVO vehicleVO) {
        log.info("Make Selected: " + vehicleVO.getNewVehicleMake());
        log.info("New Model: " + vehicleVO.getNewVehicleModel());
    }

    private void logVehicleVO(VehicleVO vehicleVO) {
        log.info("Make Selected: " + vehicleVO.getNewVehicleMake());
        log.info("Model Selected: " + vehicleVO.getNewVehicleModel());
        log.info("License Plate: " + vehicleVO.getNewLicensePlate());
        log.info("Year: " + vehicleVO.getNewYear());
        log.info("VIN: " + vehicleVO.getNewVIN());
        log.info("Color: " + vehicleVO.getNewColor());
        log.info("Purchase Price: " + vehicleVO.getNewPurchasePrice());
    }
}
