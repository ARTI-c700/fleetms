package com.finalcourseproject.fleetms.parameters.controllers;

import com.finalcourseproject.fleetms.parameters.models.Supplier;
import com.finalcourseproject.fleetms.parameters.services.CountryService;
import com.finalcourseproject.fleetms.parameters.services.StateService;
import com.finalcourseproject.fleetms.parameters.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;
    private final CountryService countryService;
    private final StateService stateService;

    public Model addModelAttributes(Model model){
        model.addAttribute("suppliers", supplierService.findAllSuppliers());
        model.addAttribute("countries", countryService.findAllCountries());
        model.addAttribute("states", stateService.findAllStates());
        return model;
    }

    @GetMapping("/parameters/suppliers")
    public String findAll(Model model){
        addModelAttributes(model);
        return "/parameters/suppliers";
    }

    @GetMapping("/parameters/addSupplier")
    public String addSupplier(Model model){
        model.addAttribute("countries", countryService.findAllCountries());
        return "parameters/addSupplier";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/parameters/supplier/{op}/{id}")
    public String editSupplier(@PathVariable Integer id, @PathVariable String op, Model model){
        Supplier supplier = supplierService.findSupplier(id);
        model.addAttribute("supplier", supplier);
        addModelAttributes(model);
        return "/parameters/supplier"+ op; //returns supplierEdit or supplierDetails
    }

    @PostMapping("/parameters/suppliers")
    public String save(Supplier supplier) {
        supplierService.saveSupplier(supplier);
        return "redirect:/parameters/suppliers";
    }

    @DeleteMapping(value="/parameters/suppliers/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        supplierService.deleteSupplier(id);
        return "redirect:/parameters/suppliers";
    }
}
