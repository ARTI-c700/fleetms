package com.finalcourseproject.fleetms.fleet.services;

import com.finalcourseproject.fleetms.fleet.models.VehicleType;
import com.finalcourseproject.fleetms.fleet.repositories.VehicleTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {
    private final VehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    //Get All VehicleTypes
    public List<VehicleType> findAll(){
        return vehicleTypeRepository.findAll();
    }

    //Get VehicleType By Id
    public Optional<VehicleType> findById(int id) {
        return vehicleTypeRepository.findById(id);
    }

    //Delete VehicleType
    public void delete(int id) {
        vehicleTypeRepository.deleteById(id);
    }

    //Update VehicleType
    public void save(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }
}
