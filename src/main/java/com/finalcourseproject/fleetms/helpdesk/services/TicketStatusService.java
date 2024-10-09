package com.finalcourseproject.fleetms.helpdesk.services;

import com.finalcourseproject.fleetms.helpdesk.models.TicketStatus;
import com.finalcourseproject.fleetms.helpdesk.repositories.TicketStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketStatusService {
    private final TicketStatusRepository ticketStatusRepository;

    //Get All TicketStatuses
    public List<TicketStatus> findAll(){
        return ticketStatusRepository.findAll();
    }

    //Get TicketStatus By Id
    public Optional<TicketStatus> findById(int id) {
        return ticketStatusRepository.findById(id);
    }

    //Delete TicketStatus
    public void delete(int id) {
        ticketStatusRepository.deleteById(id);
    }

    //Update TicketStatus
    public void save( TicketStatus ticketStatus) {
        ticketStatusRepository.save(ticketStatus);
    }
}
