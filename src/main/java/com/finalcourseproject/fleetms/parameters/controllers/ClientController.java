package com.finalcourseproject.fleetms.parameters.controllers;

import com.finalcourseproject.fleetms.parameters.models.Client;
import com.finalcourseproject.fleetms.parameters.services.ClientService;
import com.finalcourseproject.fleetms.parameters.services.CountryService;
import com.finalcourseproject.fleetms.parameters.services.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    private final ClientService clientService;
    private final CountryService countryService;
    private final StateService stateService;

    public ClientController(ClientService clientService, CountryService countryService, StateService stateService) {
        this.clientService = clientService;
        this.countryService = countryService;
        this.stateService = stateService;
    }

    public void addModelAttributes(Model model) {
        model.addAttribute("clients", clientService.findAllClients());
        model.addAttribute("countries", countryService.findAllCountries());
        model.addAttribute("states", stateService.findAllStates());
    }

    public String findAll(Model model) {
        addModelAttributes(model);
        return "/parameters/clients";
    }

    @GetMapping("/parameters/clientAdd")
    public String addClient(Model model) {
//        model.addAttribute("client", new Client());
        model.addAttribute("countries", countryService.findAllCountries());
        return "/parameters/clientAdd";
    }

    @GetMapping("/parameters/client/{op}/{id}")
    public String editClient(@PathVariable Integer id, @PathVariable String op, Model model) {
        Client client = clientService.findClientById(id);
        model.addAttribute("client", client);
        addModelAttributes(model);

        // This returns client
        return "/parameters/client"+ op;
    }

    @PostMapping("/parameters/clients")
    public String saveClient(Client client) {
        clientService.saveClient(client);
        return "redirect:/parameters/clients";
    }

    @RequestMapping(value = "/parameters/clients/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@PathVariable Integer id) {
        clientService.deleteClientById(id);
        return "redirect:/parameters/clients";
    }
}
