package com.finalcourseproject.fleetms.fleet.controllers;

import com.finalcourseproject.fleetms.fleet.models.VehicleStatus;
import com.finalcourseproject.fleetms.fleet.services.VehicleStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class VehicleStatusController {
    private final VehicleStatusService vehicleStatusService;

    @GetMapping("/fleet/vehicleStatuses")
    public String findAllVehicleStatuses(Model model) {
        List<VehicleStatus> vehicleStatuses = vehicleStatusService.findAll();
        model.addAttribute("vehicleStatuses", vehicleStatuses);
        return "fleet/vehicleStatuses";
    }

    @GetMapping("/fleet/vehicleStatuses/{id}")
    @ResponseBody
    public Optional<VehicleStatus> getVehicleStatus(@PathVariable Integer id) {
        return vehicleStatusService.findById(id);
    }

    @PostMapping("/fleet/vehicleStatuses")
    public String saveVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/fleet/vehicleStatuses";
    }

    @RequestMapping(value = "/fleet/vehicleStatuses/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleStatus(@PathVariable Integer id) {
        vehicleStatusService.delete(id);
        return "redirect:/fleet/vehicleStatuses";
    }
}
