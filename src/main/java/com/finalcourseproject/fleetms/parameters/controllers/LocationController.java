package com.finalcourseproject.fleetms.parameters.controllers;

import com.finalcourseproject.fleetms.parameters.models.Location;
import com.finalcourseproject.fleetms.parameters.services.CountryService;
import com.finalcourseproject.fleetms.parameters.services.LocationService;
import com.finalcourseproject.fleetms.parameters.services.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;
    private final CountryService countryService;
    private final StateService stateService;

    public void addModelAttributes(Model model) {
        model.addAttribute("locations", locationService.findAllLocations());
        model.addAttribute("countries", countryService.findAllCountries());
        model.addAttribute("states", stateService.findAllStates());
    }

    //Get All Locations
    @GetMapping("/parameters/locations")
    public String getAllLocations(Model model) {
        addModelAttributes(model);
        return "/parameters/locations";
    }

    //Get The Location
    @GetMapping("/parameters/locations/{id}")
    public String getLocation(@PathVariable Integer id, Model model) {
        Location location = locationService.findLocation(id);
        model.addAttribute("location", location);
        return "/parameters/locations";
    }

    //Add A Location
    @PostMapping("/parameters/locations/addLocation")
    public String addLocation(Location location) {
        locationService.saveLocation(location);
        return "/parameters/addLocation";
    }

    //Delete The Location
    @DeleteMapping("/parameters/locations/delete/{id}")
    public String deleteLocation(@PathVariable Integer id) {
        locationService.deleteLocation(id);
        return "redirect:/parameters/locations";
    }
}
