package com.finalcourseproject.fleetms.fleet.controllers;

import com.finalcourseproject.fleetms.fleet.models.VehicleMovement;
import com.finalcourseproject.fleetms.fleet.services.VehicleMovementService;
import com.finalcourseproject.fleetms.fleet.services.VehicleService;
import com.finalcourseproject.fleetms.parameters.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class VehicleMovementController {
    private final VehicleMovementService vehicleMovementService;
    private final LocationService locationService;
    private final VehicleService vehicleService;

    public void addModelAttributes(Model model) {
        model.addAttribute("vehicles", vehicleService.getAll());
        model.addAttribute("locations", locationService.findAllLocations());
        model.addAttribute("vehicleMovements", vehicleMovementService.findAllMovements());
    }

    @GetMapping("fleet/movements")
    public String findAll(Model model){
        model.addAttribute("movements", vehicleMovementService.findAllMovements());
        return "fleet/movements";
    }

    @GetMapping("/fleet/movementAdd")
    public String addMovement(Model model){
        addModelAttributes(model);
        return "/fleet/movementAdd";
    }

    @GetMapping("/fleet/movement/{op}/{id}")
    public String editMovement(Model model, @PathVariable Integer id, @PathVariable String op){
        VehicleMovement movement = vehicleMovementService.findMovement(id);
        model.addAttribute("movement", movement);
        addModelAttributes(model);
        return "/fleet/movement"+op;
    }

    //Add VehicleMovement
    @PostMapping("/fleet/movements")
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.saveMovement(vehicleMovement);
        return "redirect:/fleet/movements";
    }

    @DeleteMapping(value="/fleet/movements/delete")
    public String delete(@PathVariable Integer id) {
        vehicleMovementService.deleteMovement(id);
        return "redirect:/fleet/movements";
    }

}
