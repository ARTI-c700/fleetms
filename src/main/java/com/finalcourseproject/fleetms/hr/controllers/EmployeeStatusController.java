package com.finalcourseproject.fleetms.hr.controllers;

import com.finalcourseproject.fleetms.hr.models.EmployeeStatus;
import com.finalcourseproject.fleetms.hr.services.EmployeeStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeStatusController {
    private final EmployeeStatusService employeeStatusService;

    @GetMapping("/hr/employeeStatuses")
    public String getAllEmployeeStatuses(Model model) {
        List<EmployeeStatus> statuses = employeeStatusService.findAllEmployeeStatuses();
        model.addAttribute("statuses", statuses);
        return "hr/employeeStatuses";
    }

    //Get Job Title by id
    @GetMapping("/hr/employeeStatus/{id}")
    @ResponseBody
    public EmployeeStatus getEmployeeStatus(@PathVariable Integer id){
        return employeeStatusService.findEmployeeStatus(id);
    }

    @PostMapping("/hr/employeeStatuses")
    public String saveEmployeeStatus(EmployeeStatus employeeStatus){
        employeeStatusService.saveEmployeeStatus(employeeStatus);
        return "redirect:/hr/employeeStatuses";
    }

    @DeleteMapping(value="/hr/employeeStatus/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeeStatusService.deleteEmployeeStatus(id);
        return "redirect:/hr/employeeStatuses";
    }
}
