package com.finalcourseproject.fleetms.fleet.controllers;

import com.finalcourseproject.fleetms.fleet.services.VehicleTypeService;
import com.finalcourseproject.fleetms.fleet.models.VehicleType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class VehicleTypeController {
    private VehicleTypeService vehicleTypeService;

    //Get All VehicleTypes
    @GetMapping("/fleet/vehicleTypes")
    public String findAll(Model model){
        model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
        return "/fleet/vehicleTypes";
    }

    @RequestMapping("/fleet/vehicleType/{id}")
    @ResponseBody
    public Optional<VehicleType> findById(@PathVariable Integer id)
    {
        return vehicleTypeService.findById(id);
    }

    //Add VehicleType
    @PostMapping(value="/fleet/vehicleTypes")
    public String addNew(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/fleet/vehicleTypes";
    }

    @RequestMapping(value="fleet/vehicleType/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        vehicleTypeService.delete(id);
        return "redirect:/fleet/vehicleTypes";
    }
}
