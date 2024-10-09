package com.finalcourseproject.fleetms.fleet.controllers;

import com.finalcourseproject.fleetms.fleet.models.VehicleHire;
import com.finalcourseproject.fleetms.fleet.services.*;
import com.finalcourseproject.fleetms.parameters.services.ClientService;
import com.finalcourseproject.fleetms.parameters.services.LocationService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class VehicleHireController {

    private final VehicleHireService vehicleHireService;
    private final ClientService clientService;
    private final LocationService locationService;
    private final VehicleService vehicleService;

    public Model addModelAttributes(Model model){
        model.addAttribute("clients", clientService.findAllClients());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("vehicles", vehicleService.getAll());
        return model;
    }

    //Get All VehicleHires
    @GetMapping("/fleet/hires")
    public String findAll(Model model){
        model.addAttribute("hires", vehicleHireService.findAll());
        return "/fleet/hires";
    }

    @GetMapping("/fleet/hireAdd")
    public String addHire(Model model){
        addModelAttributes(model);
        return "/fleet/hireAdd";
    }

    @GetMapping("/fleet/hire/{op}/{id}")
    public String editHire(Model model, @PathVariable Integer id, @PathVariable String op){
        VehicleHire hire = vehicleHireService.findById(id);
        model.addAttribute("hire", hire);
        addModelAttributes(model);
        return "/fleet/hire"+op;
    }

    //Add VehicleHire
    @PostMapping("/fleet/hires")
    public String addNew(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/fleet/hires";
    }

    @RequestMapping(value="fleet/hire/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/fleet/hires";
    }

}