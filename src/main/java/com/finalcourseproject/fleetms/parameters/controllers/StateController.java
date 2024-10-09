package com.finalcourseproject.fleetms.parameters.controllers;

import com.finalcourseproject.fleetms.parameters.models.Country;
import com.finalcourseproject.fleetms.parameters.models.State;
import com.finalcourseproject.fleetms.parameters.services.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StateController {
    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/parameters/states")
    public String getAllStates(Model model) {
        List<State> states = stateService.findAllStates();
        model.addAttribute("states", states);
        return "/parameters/states";
    }

    @GetMapping("/parameters/stateAdd")
    public String addState() {
        return "/parameters/stateAdd";
    }

//    @GetMapping("/parameters/stateEdit/{id}")
//    public String editState(@RequestParam("id") Integer id, Model model) {
//        return "/parameters/stateEdit";
//    }

    @GetMapping("/parameters/states/edit/{id}")
    public String editCountry(@PathVariable Integer id, Model model) {
        State state = stateService.findById(id);
        model.addAttribute("stateEdit", state);

        return "/parameters/stateEdit";
    }

    @PostMapping("/parameters/states")
    public String save(State state) {
        stateService.save(state);
        return "redirect:/parameters/states";
    }

    @RequestMapping(value = "/parameters/states/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteCountry(@PathVariable Integer id) {
        stateService.delete(id);
        return "redirect:/parameters/states/";
    }

    @RequestMapping(value = "/parameters/states/update/{id}", method = {RequestMethod.GET, RequestMethod.PATCH})
    public String updateCountry(State state, @PathVariable Integer id) {
        stateService.save(state);
        return "redirect:/parameters/states/";
    }
}
