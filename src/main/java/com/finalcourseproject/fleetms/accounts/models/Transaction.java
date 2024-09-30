package com.finalcourseproject.fleetms.accounts.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.finalcourseproject.fleetms.hr.models.Employee;
import com.finalcourseproject.fleetms.parameters.models.Client;
import com.finalcourseproject.fleetms.parameters.models.Contact;
import com.finalcourseproject.fleetms.parameters.models.Supplier;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double amount;
    private String purpose;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "transaction_status_id", insertable = false, updatable = false)
    private TransactionStatus transactionStatus;

    @Column(name = "transaction_status_id")
    private Integer transactionStatusId;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id", insertable = false, updatable = false)
    private TransactionType transactionType;

    @Column(name = "transaction_type_id")
    private Integer transactionTypeId;

    @ManyToOne
    @JoinColumn(name = "contact_id", insertable = false, updatable = false)
    private Contact contact;

    @Column(name = "contact_id")
    private Integer contactId;

    @ManyToOne
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private Supplier supplier;


    @Column(name = "supplier_id")
    private Integer supplierid;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

    @Column(name = "client_id")
    private Integer clientId;

    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee approvedBy;

    @Column(name = "employee_id")
    private Integer employeeId;

    private String remarks;
}
