package com.finalcourseproject.fleetms.accounts.models;

import com.finalcourseproject.fleetms.hr.models.Employee;
import com.finalcourseproject.fleetms.parameters.models.Client;
import com.finalcourseproject.fleetms.parameters.models.Contact;
import com.finalcourseproject.fleetms.parameters.models.Supplier;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    private Integer transactionStatusId;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id", insertable = false, updatable = false)
    private TransactionType transactionType;
    private Integer transactionTypeId;

    @ManyToOne
    @JoinColumn(name = "contact_id", insertable = false, updatable = false)
    private Contact contact;
    private Integer contactId;

    @ManyToOne
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private Supplier supplier;
    private Integer supplierId;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;
    private Integer clientId;

    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee approvedBy;
    private Integer employeeId;

    private String remarks;
}
