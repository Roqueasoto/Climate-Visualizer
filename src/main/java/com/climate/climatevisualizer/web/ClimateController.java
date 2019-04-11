package com.climate.climatevisualizer.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ClimateController {

    @GetMapping("/")
    public String homePageGet (ModelMap model) {
        // TODO Fetch Addresses
        String address = "";

        model.put("address", address);

        return "index";
    }

    @GetMapping("/climate")
    public String climatePageGet (ModelMap model) {
        String address = "";

        // TODO Add resulting figure
        model.put("figure", "");

        return "climate";
    }

    @PostMapping("/")
    public String AddressPost (String address) {

        // TODO Post form data from form

        return "redirect:/climate";
    }
}
