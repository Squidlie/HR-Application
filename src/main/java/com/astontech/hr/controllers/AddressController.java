package com.astontech.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AddressController {
        @RequestMapping("/address")
        public String addressPage() {

            return "address";
        }
    }
