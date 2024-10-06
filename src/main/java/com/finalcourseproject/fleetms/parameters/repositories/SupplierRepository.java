package com.finalcourseproject.fleetms.parameters.repositories;

import com.finalcourseproject.fleetms.parameters.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
