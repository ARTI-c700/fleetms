package com.finalcourseproject.fleetms.parameters.controllers;

import com.finalcourseproject.fleetms.parameters.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService moduleService;

    @GetMapping("/parameters/modules")
    public String getModules(){
        return "modules";
    }
}
