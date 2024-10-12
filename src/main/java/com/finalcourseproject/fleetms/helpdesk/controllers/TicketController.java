package com.finalcourseproject.fleetms.helpdesk.controllers;

import com.finalcourseproject.fleetms.helpdesk.models.Ticket;
import com.finalcourseproject.fleetms.helpdesk.services.TicketService;
import com.finalcourseproject.fleetms.helpdesk.services.TicketStatusService;
import com.finalcourseproject.fleetms.parameters.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    private final ClientService clientService;
    private final TicketStatusService ticketStatusService;

    public void addModelAttributes(Model model) {
        model.addAttribute("tickets", ticketService.findAll());
        model.addAttribute("clients", clientService.findAllClients());
        model.addAttribute("ticketStatuses", ticketStatusService.findAll());
    }

    @GetMapping("/helpdesk/tickets")
    public String findAllTickets(Model model) {
        addModelAttributes(model);
        return "helpdesk/tickets";
    }

    //Add Ticket
    @PostMapping(value="/tickets/addNew")
    public String addNew(Ticket ticket) {
        ticketService.save(ticket);
        return "redirect:/ticketList";
    }

    @RequestMapping(value="/tickets/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Ticket ticket) {
        ticketService.save(ticket);
        return "redirect:/ticketList";
    }

    @RequestMapping(value="/tickets/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        ticketService.delete(id);
        return "redirect:/ticketList";
    }
}
