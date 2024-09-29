package com.finalcourseproject.fleetms.fleet.services;

import com.finalcourseproject.fleetms.fleet.models.VehicleMovement;
import com.finalcourseproject.fleetms.fleet.repositories.VehicleMovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMovementService {
    private final VehicleMovementRepository vehicleMovementRepository;

    public VehicleMovementService(VehicleMovementRepository vehicleMovementRepository) {
        this.vehicleMovementRepository = vehicleMovementRepository;
    }

    public List<VehicleMovement> getAll() {
        return vehicleMovementRepository.findAll();
    }

    public void save(VehicleMovement vehicle) {
        vehicleMovementRepository.save(vehicle);
    }

    public void delete(Integer id) {
        vehicleMovementRepository.deleteById(id);
    }

    public VehicleMovement getById(Integer id) {
        return vehicleMovementRepository.findById(id).orElse(null);
    }

}
