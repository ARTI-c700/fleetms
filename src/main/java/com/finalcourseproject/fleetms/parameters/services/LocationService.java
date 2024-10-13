package com.finalcourseproject.fleetms.parameters.services;

import com.finalcourseproject.fleetms.parameters.models.Location;
import com.finalcourseproject.fleetms.parameters.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findAllLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    public Location findLocation(Integer id) {
        return locationRepository.findById(id).orElse(null);
    }

    public void saveLocation(Location location) {
        locationRepository.save(location);
    }

    public void deleteLocation(Integer id) {
        locationRepository.deleteById(id);
    }

    public List<Location> findByDescriptionContaining(String description) {
        return null;
    }
}
