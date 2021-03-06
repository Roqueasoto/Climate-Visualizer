package com.climate.climatevisualizer.web;

import com.climate.geolocator.GeoLocator;
import com.climate.geolocator.Tuple;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.util.Optional;

@Controller
public class ClimateController {

    /**
     * Method for controller to listen to GET requests from the root domain
     * of the site and create a model and new address template to fill with
     * user data from template engine.
     * @param model
     * @return
     */
    @GetMapping("/")
    public String homePageGet (ModelMap model) {

        // Add an empty Address object to be filled later
        model.addAttribute("input", new Address());

        return "index";
    }

    /**
     * Method for controller to listen to POST requests from the site and
     * take user information from the model for plotting.
     * @param input
     * @param model
     * @return
     */
    @PostMapping("/")
    public String AddressPost (@ModelAttribute Address input,
                               ModelMap model) {

        //-----------------------------GEOLOCATION----------------------------//

        // Initialize GeoLocator
        GeoLocator geoCode = new GeoLocator();

        // Find Lat & Lon and add them to the model.
        try {
            // First get the Optional Tuple response from getLatlon
            Optional<Tuple<Double, Double>> latLon = geoCode.getLatLon(
                    input.getAddress());

            // Then test to see if the response was empty
            if (!latLon.isPresent()) {
                // If response is empty, then send to failed query page
                return "failedQuery";
            }

            /* If response is available, then strip optional and add to model
               as a ClimateResults object. This is temporary and for testing
               purposes. It will be replaced when the data analysis section
               is finished. */
            ClimateResults results = new ClimateResults(latLon.get().getFirst(),
                    latLon.get().getSecond());
            model.addAttribute("results", results);

        } catch (IOException e) {
            // if the query raises an error, then send to the failed query page
            return "failedQuery";
        }

        //----------------------------DATABASE SEARCH------------------------//


        //-----------------------------DATA ANALYSIS-------------------------//



        // TODO Add resulting data to MODEL and use Javascript for Figures.

        // Take user to the final page.
        return "climate";
    }
}
