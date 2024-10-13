package com.finalcourseproject.fleetms.parameters.services;

import com.finalcourseproject.fleetms.parameters.models.Department;
import com.finalcourseproject.fleetms.parameters.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    //Get All Departments
    public List<Department> findAllDepartments(){
        return departmentRepository.findAll();
    }

    //Get Department By Id
    public Department findDepartment(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    //Delete Department
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }

    //Update Department
    public void saveDepartment( Department department) {
        departmentRepository.save(department);
    }

    //Modify The Property of A Department
    public void editDepartment(Department department, String property) {
        Department departmentFromDb = findDepartment(department.getId());
        Arrays.stream(departmentFromDb.getClass().getDeclaredFields()).forEach(field -> {
                try {
                    if(Objects.equals(field.getName(), property)) {
                        field.setAccessible(true);
                        field.set(departmentFromDb, field.get(department));
                        saveDepartment(departmentFromDb);
                        field.setAccessible(false);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        );
    }

}
