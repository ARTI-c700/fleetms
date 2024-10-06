package com.finalcourseproject.fleetms.accounts.controllers;

import com.finalcourseproject.fleetms.accounts.models.Transaction;
import com.finalcourseproject.fleetms.accounts.services.TransactionService;
import com.finalcourseproject.fleetms.accounts.services.TransactionStatusService;
import com.finalcourseproject.fleetms.accounts.services.TransactionTypeService;
import com.finalcourseproject.fleetms.hr.services.*;
import com.finalcourseproject.fleetms.parameters.services.ClientService;
import com.finalcourseproject.fleetms.parameters.services.ContactService;
import com.finalcourseproject.fleetms.parameters.services.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionStatusService transactionStatusService;
    private final TransactionTypeService transactionTypeService;
    private final ContactService contactService;
    private final SupplierService supplierService;
    private final ClientService clientService;
    private final EmployeeService employeeService;

    public TransactionController(TransactionService transactionService, TransactionStatusService transactionStatusService, TransactionTypeService transactionTypeService, ContactService contactService, SupplierService supplierService, ClientService clientService, EmployeeService employeeService) {
        this.transactionService = transactionService;
        this.transactionStatusService = transactionStatusService;
        this.transactionTypeService = transactionTypeService;
        this.contactService = contactService;
        this.supplierService = supplierService;
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    public Model addModelAttributes(Model model){
        model.addAttribute("transactionStatuses", transactionStatusService.findAll());
        model.addAttribute("transactionTypes", transactionTypeService.findAll());
        model.addAttribute("contacts", contactService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        return model;
    }

    @GetMapping("/accounts/transactions")
    public String  getAll(Model model){
        List<Transaction> transactions =   transactionService.findAll();
        model.addAttribute("transactions", transactions);
        addModelAttributes(model);
        return "/accounts/transactions";
    }

    @GetMapping("/accounts/transactionAdd")
    public String addTransaction(Model model){
        addModelAttributes(model);
        return "accounts/transactionAdd";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/accounts/transaction/{op}/{id}")
    public String editTransaction(@PathVariable Integer id, @PathVariable String op, Model model){
        Transaction transaction = transactionService.findById(id);
        model.addAttribute("transaction", transaction);
        addModelAttributes(model);
        return "/accounts/transaction"+ op;
    }

    @PostMapping("/accounts/transactions")
    public String save(Transaction transaction){
        transactionService.save(transaction);
        return "redirect:/accounts/transactions";
    }

    @RequestMapping(value = "/accounts/transactions/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public  String delete(@PathVariable Integer id){
        transactionService.delete(id);
        return "redirect:/accounts/transactions";
    }
}
