package com.finalcourseproject.fleetms.fleet.services;

import com.finalcourseproject.fleetms.fleet.models.VehicleModel;
import com.finalcourseproject.fleetms.fleet.repositories.VehicleModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    private final VehicleModelRepository vehicleModelRepository;
    public VehicleModelService(VehicleModelRepository vehicleModelRepository) {
        this.vehicleModelRepository = vehicleModelRepository;
    }

    //Get All VehicleModels
    public List<VehicleModel> findAll(){
        return vehicleModelRepository.findAll();
    }

    //Get VehicleModel By Id
    public Optional<VehicleModel> findById(int id) {
        return vehicleModelRepository.findById(id);
    }

    //Delete VehicleModel
    public void delete(int id) {
        vehicleModelRepository.deleteById(id);
    }

    //Update VehicleModel
    public void save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }
}
