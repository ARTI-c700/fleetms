package com.finalcourseproject.fleetms.parameters.services;

import com.finalcourseproject.fleetms.parameters.models.Supplier;
import com.finalcourseproject.fleetms.parameters.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    //Get All Suppliers
    public List<Supplier> findAllSuppliers(){
        return supplierRepository.findAll();
    }

    //Get Supplier By Id
    public Supplier findSupplier(int id) {
        return supplierRepository.findById(id).orElse(null);
    }

    //Delete Supplier
    public void deleteSupplier(int id) {
        supplierRepository.deleteById(id);
    }

    //Update Supplier
    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }
}