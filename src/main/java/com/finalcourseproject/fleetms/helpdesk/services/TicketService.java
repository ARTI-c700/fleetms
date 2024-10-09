package com.finalcourseproject.fleetms.helpdesk.services;

import com.finalcourseproject.fleetms.helpdesk.models.Ticket;
import com.finalcourseproject.fleetms.helpdesk.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    //Get All Tickets
    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    //Get Ticket By Id
    public Optional<Ticket> findById(int id) {
        return ticketRepository.findById(id);
    }

    //Delete Ticket
    public void delete(int id) {
        ticketRepository.deleteById(id);
    }

    //Update Ticket
    public void save(Ticket invoice) {
        ticketRepository.save(invoice);
    }
}
