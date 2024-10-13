package com.finalcourseproject.fleetms.hr.controllers;

import com.finalcourseproject.fleetms.hr.models.EmployeeType;
import com.finalcourseproject.fleetms.hr.services.EmployeeTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeTypeController {
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/hr/employeeTypes")
    public String parameters(Model model){
        List<EmployeeType> employeeTypes = employeeTypeService.findAllEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypes);
        return "hr/employeeTypes";
    }

    @GetMapping("/hr/employeeType/{id}")
    @ResponseBody
    public EmployeeType getById(@PathVariable Integer id){
        return employeeTypeService.findEmployeeType(id).orElse(null);
    }

    @PostMapping("/hr/employeeTypes")
    public String save(EmployeeType employeeType){
        employeeTypeService.saveEmployeeType(employeeType);
        return "redirect:/hr/employeeTypes";
    }

    @RequestMapping(value="/hr/employeeType/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        employeeTypeService.deleteEmployeeType(id);
        return "redirect:/hr/employeeTypes";
    }

}
