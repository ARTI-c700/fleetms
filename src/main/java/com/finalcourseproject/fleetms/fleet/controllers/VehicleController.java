package com.finalcourseproject.fleetms.fleet.controllers;

import com.finalcourseproject.fleetms.fleet.models.Vehicle;
import com.finalcourseproject.fleetms.fleet.services.*;
import com.finalcourseproject.fleetms.hr.services.EmployeeService;
import com.finalcourseproject.fleetms.parameters.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;
    private final VehicleTypeService vehicleTypeService;
    private final VehicleMakeService vehicleMakeService;
    private final VehicleModelService vehicleModelService;
    private final LocationService locationService;
    private final EmployeeService employeeService;
    private final VehicleStatusService vehicleStatusService;

    public Model addModelAttributes(Model model) {
        model.addAttribute("vehicles", vehicleService.getAll());
        model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
        model.addAttribute("vehicleMakes", vehicleMakeService.findAll());
        model.addAttribute("vehicleModels", vehicleModelService.findAll());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("vehicleStatus", vehicleStatusService.findAll());

        return model;
    }

    // Get all vehicles
    @GetMapping("/fleet/vehicles")
    public String vehicles(Model model) {
        addModelAttributes(model);
        return "fleet/vehicles";
    }

    // Adding a new vehicle
    @PostMapping("/fleet/addVehicle")
    public String addVehicle(Model model) {
        addModelAttributes(model);
        return "fleet/addVehicle";
    }

    // Edit the current vehicle
    @PatchMapping("/fleet/editVehicle/{op}/{id}")
    public String editVehicle(Model model, @PathVariable String op, @PathVariable Integer id) {
        Vehicle vehicle = vehicleService.getById(id);
        model.addAttribute("vehicle", vehicle);
        addModelAttributes(model);
        return "fleet/vehicle" + op;
    }

    //Add Vehicle
    @PostMapping("/fleet/vehicles")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/fleet/vehicles";
    }

    // Delete current vehicle
    @RequestMapping(value="/fleet/vehicle/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        vehicleService.delete(id);
        return "redirect:/fleet/vehicles";
    }
}
