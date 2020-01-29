package com.astontech.hr.rest;

import com.astontech.hr.domain.Element;
import com.astontech.hr.services.ElementService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/element")
public class ElementRest {
    private Logger log = Logger.getLogger(ElementRest.class);

    @Autowired
    private ElementService elementService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Element> getAll() { return elementService.listAllElements(); }
}
