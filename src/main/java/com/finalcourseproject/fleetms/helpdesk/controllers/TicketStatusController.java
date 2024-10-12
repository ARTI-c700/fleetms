package com.finalcourseproject.fleetms.helpdesk.controllers;

import com.finalcourseproject.fleetms.helpdesk.models.TicketStatus;
import com.finalcourseproject.fleetms.helpdesk.services.TicketStatusService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TicketStatusController {
    private final TicketStatusService ticketStatusService;

    @GetMapping("/helpdesk/ticketStatuses")
    public String findAllTicketStatuses(Model model) {
        model.addAttribute("ticketStatuses", ticketStatusService.findAll());
        return "/helpdesk/ticketStatuses";
    }

    @GetMapping("/helpdesk/ticketStatus/{id}")
    @ResponseBody
    public Optional<TicketStatus> getTicketStatus(Integer id) {
        return ticketStatusService.findById(id);
    }

    //Add TicketStatus
    @PostMapping(value="/helpdesk/ticketStatuses")
    public String addNew(TicketStatus ticketStatus) {
        ticketStatusService.save(ticketStatus);
        return "redirect:/helpdesk/ticketStatuses";
    }

    @RequestMapping(value="helpdesk/ticketStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        ticketStatusService.delete(id);
        return "redirect:/helpdesk/ticketStatuses";
    }
}
