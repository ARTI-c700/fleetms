package com.finalcourseproject.fleetms.parameters.controllers;

import com.finalcourseproject.fleetms.hr.services.EmployeeService;
import com.finalcourseproject.fleetms.parameters.models.Department;
import com.finalcourseproject.fleetms.parameters.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @GetMapping("/parameters/departments")
    public String getAllDepartments(Model model) {
        model.addAttribute("departments", departmentService.findAllDepartments());
        model.addAttribute("employees", employeeService.findAllEmployees());

        return "/parameters/departments";
    }

    @GetMapping("/parameters/departments/{id}")
    public String getDepartment(@PathVariable Integer id, Model model) {
        Department department = departmentService.findDepartment(id);
        model.addAttribute("department", department);
        return "/parameters/department";
    }

    @PostMapping("/parameters/departments/addNew")
    public String addDepartment(Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/parameters/departments";
    }

    @RequestMapping(value = "/parameters/departments/updateDepartment/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String editDepartment(@PathVariable Integer id, String property) {
        Department department = departmentService.findDepartment(id);
        departmentService.editDepartment(department, property);
        return "redirect:/parameters/departments";
    }

    @DeleteMapping("/parameters/departments/delete/{id}")
    public String deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
        return "redirect:/parameters/departments";
    }
}
