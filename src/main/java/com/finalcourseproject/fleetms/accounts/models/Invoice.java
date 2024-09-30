package com.finalcourseproject.fleetms.accounts.models;

import com.finalcourseproject.fleetms.parameters.models.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "invoice_status_id", insertable = false, updatable = false)
    private InvoiceStatus invoiceStatus;

    @Column(name = "invoice_status_id")
    private Integer invoiceStatusId;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

    @Column(name = "client_id")
    private Integer clientId;

    private String remarks;

}
