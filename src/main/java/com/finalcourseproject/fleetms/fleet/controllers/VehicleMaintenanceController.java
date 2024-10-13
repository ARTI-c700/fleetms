package com.finalcourseproject.fleetms.fleet.controllers;

import com.finalcourseproject.fleetms.fleet.models.VehicleMaintenance;
import com.finalcourseproject.fleetms.fleet.services.VehicleMaintenanceService;
import com.finalcourseproject.fleetms.fleet.services.VehicleService;
import com.finalcourseproject.fleetms.parameters.services.SupplierService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class VehicleMaintenanceController {
    private final VehicleMaintenanceService vehicleMaintenanceService;
    private final VehicleService vehicleService;
    private final SupplierService supplierService;

    public void addModelAttributes(Model model) {
        model.addAttribute("vehicles", vehicleService.getAll());
        model.addAttribute("suppliers", supplierService.findAllSuppliers());
    }

    //Get All VehicleMaintenances
    @GetMapping("/fleet/maintenances")
    public String findAll(Model model){
        model.addAttribute("maintenances", vehicleMaintenanceService.findAll());
        return "/fleet/maintenances";
    }

    @GetMapping("/fleet/maintenanceAdd")
    public String addMaintenance(Model model){
        addModelAttributes(model);
        return "/fleet/maintenanceAdd";
    }

    @GetMapping("/fleet/maintenance/{op}/{id}")
    public String editMaintenance(Model model, @PathVariable Integer id, @PathVariable String op){
        VehicleMaintenance maintenance = vehicleMaintenanceService.findById(id);
        model.addAttribute("maintenance", maintenance);
        addModelAttributes(model);
        return "/fleet/maintenance"+op;
    }

    //Add VehicleMaintenance
    @PostMapping("/fleet/maintenances")
    public String addNew(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/fleet/maintenances";
    }

    @RequestMapping(value="fleet/maintenance/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/fleet/maintenances";
    }

}