package com.astontech.hr.rest;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactRest {

    private Logger log = Logger.getLogger(ContactRest.class);

    @Autowired
    private AddressService addressService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Contact> getAll() { return contactService.listAllContacts(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Contact getById(@PathVariable int id) {
        return contactService.getContactById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Contact save(@RequestBody Contact contact) {
        Employee person = employeeService.getEmployeeById(contact.getPerson().getId());
        Element element = elementService.getElementById(contact.getElement().getId());
        contact.setPerson(person);
        contact.setElement(element);
        return contactService.saveContact(contact);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) {
        boolean result = false;
        try{
            contactService.deleteContact(id);
            result = true;
        } catch (Exception ex) {
            log.info(ex);
        }
        return result;
    }
}
