package com.finalcourseproject.fleetms.helpdesk.models;

import com.finalcourseproject.fleetms.hr.models.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    private Integer id;

    private String subject;
    private String details;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date openDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date closeDateTime;

    @ManyToOne
    @JoinColumn(name = "ticket_status_id", insertable = false, updatable = false)
    private TicketStatus ticketStatus;

    @Column(name = "ticket_status_id")
    private Integer ticketStatusId;

    @ManyToOne
    @JoinColumn(name = "raised_by_id", insertable = false, updatable = false)
    private Employee raisedBy;

    @Column(name = "raised_by_id")
    private Integer raisedById;

    @ManyToOne
    @JoinColumn(name = "assigned_to", insertable = false, updatable = false)
    private Employee assignedTo;

    @Column(name = "assigned_to_id")
    private Integer assignedToId;

    private String remarks;
}
