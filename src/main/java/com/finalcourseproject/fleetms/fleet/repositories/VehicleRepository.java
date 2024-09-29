package com.finalcourseproject.fleetms.fleet.repositories;

import com.finalcourseproject.fleetms.fleet.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
