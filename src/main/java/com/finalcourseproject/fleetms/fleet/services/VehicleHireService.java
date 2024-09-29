package com.finalcourseproject.fleetms.fleet.services;

import com.finalcourseproject.fleetms.fleet.models.VehicleHire;
import com.finalcourseproject.fleetms.fleet.repositories.VehicleHireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleHireService {
    private final VehicleHireRepository vehicleHireRepository;

    public VehicleHireService(VehicleHireRepository vehicleHireRepository) {
        this.vehicleHireRepository = vehicleHireRepository;
    }

    //Get All VehicleHires
    public List<VehicleHire> findAll(){
        return vehicleHireRepository.findAll();
    }

    //Get VehicleHire By Id
    public VehicleHire findById(int id) {
        return vehicleHireRepository.findById(id).orElse(null);
    }

    //Delete VehicleHire
    public void delete(int id) {
        vehicleHireRepository.deleteById(id);
    }

    //Update VehicleHire
    public void save(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }
}
