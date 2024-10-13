package com.finalcourseproject.fleetms.fleet.controllers;

import com.finalcourseproject.fleetms.fleet.models.VehicleMake;
import com.finalcourseproject.fleetms.fleet.services.VehicleMakeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class VehicleMakeController {

    private final VehicleMakeService vehicleMakeService;

    //Get All VehicleMakes
    @GetMapping("fleet/vehicleMakes")
    public String findAll(Model model){
        model.addAttribute("vehicleMakes", vehicleMakeService.findAll());
        return "/fleet/vehicleMakes";
    }

    @RequestMapping("/fleet/vehicleMakes/{id}")
    @ResponseBody
    public Optional<VehicleMake> findById(@PathVariable Integer id)
    {
        return vehicleMakeService.findById(id);
    }

    //Add VehicleMake
    @PostMapping(value="/fleet/vehicleMakes")
    public String addNew(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/fleet/vehicleMakes";
    }

    @RequestMapping(value="vehicleMake/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMakeService.delete(id);
        return "redirect:/fleet/vehicleMakes";
    }
}