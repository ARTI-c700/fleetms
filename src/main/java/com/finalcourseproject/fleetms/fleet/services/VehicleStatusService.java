package com.finalcourseproject.fleetms.fleet.services;

import com.finalcourseproject.fleetms.fleet.models.VehicleStatus;
import com.finalcourseproject.fleetms.fleet.repositories.VehicleStatusRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class VehicleStatusService {
    private final VehicleStatusRepository vehicleStatusRepository;

    public VehicleStatusService(VehicleStatusRepository vehicleStatusRepository) {
        this.vehicleStatusRepository = vehicleStatusRepository;
    }

    //Get All VehicleStatus
    public List<VehicleStatus> findAll(){
        return vehicleStatusRepository.findAll();
    }

    //Get VehicleStatus By Id
    public Optional<VehicleStatus> findById(int id) {
        return vehicleStatusRepository.findById(id);
    }

    //Delete VehicleStatus
    public void delete(int id) {
        vehicleStatusRepository.deleteById(id);
    }

    //Update VehicleStatus
    public void save(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }
}
