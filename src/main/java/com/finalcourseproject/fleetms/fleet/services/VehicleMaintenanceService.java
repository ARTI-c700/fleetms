package com.finalcourseproject.fleetms.fleet.services;

import com.finalcourseproject.fleetms.fleet.models.VehicleMaintenance;
import com.finalcourseproject.fleetms.fleet.repositories.VehicleMaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMaintenanceService {
    private final VehicleMaintenanceRepository vehicleMaintenanceRepository;

    public VehicleMaintenanceService(VehicleMaintenanceRepository vehicleMaintenanceRepository) {
        this.vehicleMaintenanceRepository = vehicleMaintenanceRepository;
    }

    //Get All VehicleMaintenances
    public List<VehicleMaintenance> findAll(){
        return vehicleMaintenanceRepository.findAll();
    }

    //Get VehicleMaintenance By Id
    public VehicleMaintenance findById(int id) {
        return vehicleMaintenanceRepository.findById(id).orElse(null);
    }

    //Delete VehicleMaintenance
    public void delete(int id) {
        vehicleMaintenanceRepository.deleteById(id);
    }

    //Update VehicleMaintenance
    public void save(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }
}
