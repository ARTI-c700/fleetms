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

    public List<VehicleMovement> findAllMovements() {
        return vehicleMovementRepository.findAll();
    }

    public void saveMovement(VehicleMovement vehicle) {
        vehicleMovementRepository.save(vehicle);
    }

    public void deleteMovement(Integer id) {
        vehicleMovementRepository.deleteById(id);
    }

    public VehicleMovement findMovement(Integer id) {
        return vehicleMovementRepository.findById(id).orElse(null);
    }

}
