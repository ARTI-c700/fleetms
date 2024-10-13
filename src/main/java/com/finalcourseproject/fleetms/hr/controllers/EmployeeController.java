package com.finalcourseproject.fleetms.hr.controllers;

import com.finalcourseproject.fleetms.hr.models.Employee;
import com.finalcourseproject.fleetms.hr.services.EmployeeService;
import com.finalcourseproject.fleetms.hr.services.EmployeeTypeService;
import com.finalcourseproject.fleetms.hr.services.JobTitleService;
import com.finalcourseproject.fleetms.parameters.services.CountryService;
import com.finalcourseproject.fleetms.parameters.services.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final StateService stateService;
    private final JobTitleService jobTitleService;
    private final EmployeeTypeService employeeTypeService;
    private final CountryService countryService;

    public void addModelAttributes(Model model) {
        model.addAttribute("employees", employeeService.findAllEmployees());
        model.addAttribute("states", stateService.findAllStates());
        model.addAttribute("jobTitles", jobTitleService.findAllJobTitles());
        model.addAttribute("employeeTypes", employeeTypeService.findAllEmployeeTypes());
        model.addAttribute("countries", countryService.findAllCountries());
    }

    //Get All Employees
    @GetMapping("/hr/employees")
    public String getAllEmployees(Model model){
        addModelAttributes(model);
        return "/hr/employees/";
    }

    @GetMapping("/hr/addEmployee")
    public String addEmployee(Model model){
        addModelAttributes(model);
        return "/hr/addEmployee";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/hr/employee/{op}/{id}")
    public String editEmployee(@PathVariable Integer id, @PathVariable String op, Model model){
        Employee employee = employeeService.findEmployee(id);
        model.addAttribute("employee", employee);
        addModelAttributes(model);
        return "/hr/employee"+ op; //returns employeeEdit or employeeDetails
    }

    //Add Employee
    @PostMapping("/hr/employees")
    public String addNew(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/hr/employees";
    }

    @DeleteMapping(value="/hr/employee/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/hr/employees";
    }

    @PostMapping(value="/employees/uploadPhoto", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File newFile = new File("D:\\SOLUTIONS\\fleetms\\uploads" + file.getOriginalFilename());
        boolean result = newFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(newFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    }

    @PostMapping("/employees/uploadPhoto2")
    public String uploadFile2(@RequestParam("file") MultipartFile file, Principal principal)
            throws IllegalStateException, IOException {
        String baseDirectory = "D:\\SOLUTIONS\\fleetms\\src\\main\\resources\\static\\img\\photos\\" ;
        file.transferTo(new File(baseDirectory + principal.getName() + ".jpg"));
        return "redirect:/employees";
    }

    @RequestMapping(value="/employee/profile")
    public String profile(Model model, Principal principal) {
        String un = principal.getName();
        addModelAttributes(model);
        model.addAttribute("employee", employeeService.findEmployee(un));
        return "profile";
    }
}
