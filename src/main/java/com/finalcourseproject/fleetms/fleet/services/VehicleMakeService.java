package com.finalcourseproject.fleetms.fleet.services;

import com.finalcourseproject.fleetms.fleet.models.VehicleMake;
import com.finalcourseproject.fleetms.fleet.repositories.VehicleMakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {
    private final VehicleMakeRepository vehicleMakeRepository;

    public VehicleMakeService(VehicleMakeRepository vehicleMakeRepository) {
        this.vehicleMakeRepository = vehicleMakeRepository;
    }

    //Get All VehicleMakes
    public List<VehicleMake> findAll(){
        return vehicleMakeRepository.findAll();
    }

    //Get VehicleMake By Id
    public Optional<VehicleMake> findById(int id) {
        return vehicleMakeRepository.findById(id);
    }

    //Delete VehicleMake
    public void delete(int id) {
        vehicleMakeRepository.deleteById(id);
    }

    //Update VehicleMake
    public void save(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }
}
