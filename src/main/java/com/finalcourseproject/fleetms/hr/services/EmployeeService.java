package com.finalcourseproject.fleetms.hr.services;

import com.finalcourseproject.fleetms.hr.models.Employee;
import com.finalcourseproject.fleetms.hr.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //Get All Employees
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    //Get Employee By Id
    public Employee findEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    //Delete Employee
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    //Update Employee
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    //Get Employee by username
    public Employee findEmployee(String un) {
        return employeeRepository.findByUsername(un);
    }

    //Get employee by Keyword
    public List<Employee> findEmployeeByKeyword(String keyword) {
        return employeeRepository.findByKeyword(keyword);
    }
}
