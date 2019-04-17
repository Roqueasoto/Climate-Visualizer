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

    @GetMapping("/index")
    public String homePageGet (ModelMap model) {
        // TODO Fetch Addresses

        model.addAttribute("input", new Address());

        return "index";
    }

    @PostMapping("/index")
    public String AddressPost (@ModelAttribute Address input,
                               ModelMap model) {
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

            // If response is available, then strip optional and add to model
            ClimateResults results = new ClimateResults(latLon.get().getFirst(),
                    latLon.get().getSecond());
            model.addAttribute("results", results);

        } catch (IOException e) {
            // if the query raises an error, then send to the failed query page
            return "failedQuery";
        }

        // TODO Add resulting figure

        // Take user to the final page.
        return "climate";
    }
}
