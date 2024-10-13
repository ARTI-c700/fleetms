package com.finalcourseproject.fleetms.hr.services;

import com.finalcourseproject.fleetms.hr.models.EmployeeType;
import com.finalcourseproject.fleetms.hr.repositories.EmployeeTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeTypeService {
    private final EmployeeTypeRepository employeeTypeRepository;

    //Get All EmployeeTypes
    public List<EmployeeType> findAllEmployeeTypes(){
        return employeeTypeRepository.findAll();
    }

    //Get EmployeeType By Id
    public Optional<EmployeeType> findEmployeeType(int id) {
        return employeeTypeRepository.findById(id);
    }

    //Delete EmployeeType
    public void deleteEmployeeType(int id) {
        employeeTypeRepository.deleteById(id);
    }

    //Update EmployeeType
    public void saveEmployeeType(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }
}
