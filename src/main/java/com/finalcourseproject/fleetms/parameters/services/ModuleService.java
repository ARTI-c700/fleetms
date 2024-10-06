package com.finalcourseproject.fleetms.parameters.services;

import com.finalcourseproject.fleetms.parameters.models.Module;
import com.finalcourseproject.fleetms.parameters.repositories.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {
    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    public Module findById(Integer id) {
        return moduleRepository.findById(id).orElse(null);
    }

    public void save(Module location) {
        moduleRepository.save(location);
    }

    public void deleteById(Integer id) {
        moduleRepository.deleteById(id);
    }
}
