package com.finalcourseproject.fleetms.hr.services;

import com.finalcourseproject.fleetms.hr.models.EmployeeStatus;
import com.finalcourseproject.fleetms.hr.repositories.EmployeeStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeStatusService {
    private final EmployeeStatusRepository employeeStatusRepository;

    //Find All Employee Statuses
    public List<EmployeeStatus> findAllEmployeeStatuses() {
        return employeeStatusRepository.findAll();
    }

    public EmployeeStatus findEmployeeStatus(Integer id) {
        return employeeStatusRepository.findById(id).orElse(null);
    }

    public void saveEmployeeStatus(EmployeeStatus employeeStatus) {
        employeeStatusRepository.save(employeeStatus);
    }

    public void deleteEmployeeStatus(Integer id) {
        employeeStatusRepository.deleteById(id);
    }
}
