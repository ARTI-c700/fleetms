package com.finalcourseproject.fleetms.parameters.controllers;

import com.finalcourseproject.fleetms.parameters.models.Country;
import com.finalcourseproject.fleetms.parameters.services.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public String getAllCountries(Model model) {
        List<Country> countries = countryService.getAll();
        model.addAttribute("countries", countries);
        return "/parameters/countryList";
    }

    @GetMapping("/countryAdd")
    public String addCountry() {
        return "/parameters/countryAdd";
    }

    @GetMapping("/countryEdit")
    public String editCountry() {
        return "/parameters/countryEdit";
    }

    @GetMapping("/countries/edit/{id}")
    public String editCountry(@PathVariable Integer id, Model model) {
        Country country = countryService.getById(id);
        model.addAttribute("country", country);

        return "/parameters/countryEdit";
    }

    @PostMapping("/countries")
    public String save(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteCountry(@PathVariable Integer id) {
        countryService.delete(id);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateCountry(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }
}
