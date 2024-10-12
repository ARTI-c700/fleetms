package com.finalcourseproject.fleetms.fleet.controllers;

import com.finalcourseproject.fleetms.fleet.models.VehicleModel;
import com.finalcourseproject.fleetms.fleet.services.VehicleModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class VehicleModelController {
    private final VehicleModelService vehicleModelService;

    // Get all vehicle models
    @GetMapping("/fleet/vehicleModels")
    public String findAll() {
        return "/fleet/vehicleModels";
    }

    // Get a vehicle model by its id
    @GetMapping("/fleet/vehicleModels/{id}")
    @ResponseBody
    public Optional<VehicleModel> getById(@PathVariable Integer id) {
        return vehicleModelService.findById(id);
    }

    // Add a new vehicle model
    @PostMapping("/fleet/addVehicleModel")
    public String save(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect: /fleet/vehicleModels";
    }

    @RequestMapping(value = "/fleet/vehicleModels/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@PathVariable Integer id) {
        vehicleModelService.delete(id);
        return "redirect:/fleet/vehicleModels";
    }
}
