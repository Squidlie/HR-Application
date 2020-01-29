package com.astontech.hr.rest;

import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.AddressService;
import com.astontech.hr.services.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressRest {

    private Logger log = Logger.getLogger(AddressRest.class);

    @Autowired
    private AddressService addressService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Address> getAll() {
        return addressService.listAllAddresses();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Address getById(@PathVariable int id) {
        return addressService.getAddressById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Address save(@RequestBody Address address) {
        Employee person = employeeService.getEmployeeById(address.getPerson().getId());
        address.setPerson(person);
        return addressService.saveAddress(address);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) {
        boolean result = false;
        try{
            addressService.deleteAddress(id);
            result = true;
        } catch (Exception ex) {
            log.info(ex);
        }
        return result;
    }
}
