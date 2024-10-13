package com.finalcourseproject.fleetms.accounts.controllers;

import com.finalcourseproject.fleetms.accounts.models.Invoice;
import com.finalcourseproject.fleetms.accounts.services.InvoiceService;
import com.finalcourseproject.fleetms.accounts.services.InvoiceStatusService;
import com.finalcourseproject.fleetms.parameters.services.ClientService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceStatusService invoiceStatusService;
    private final ClientService clientService;

    @GetMapping("/accounts/invoices")
    public String getAllInvoices(Model model) {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        model.addAttribute("invoices", invoices);
        return "/accounts/invoices";
    }

    @GetMapping("/accounts/addInvoice")
    public String addInvoice() {
        return "/accounts/invoiceAdd";
    }

    @GetMapping("/accounts/invoice/{op}/{id}")
    public String editInvoice(@PathVariable Integer id, Model model, @PathVariable String op) {
        Invoice invoice = invoiceService.getInvoice(id);
        model.addAttribute("invoice", invoice);
        return "/accounts/invoice/" + op;
    }

    @PostMapping("/accounts/invoices")
    public String addInvoice(Invoice invoice) {
        invoiceService.saveInvoice(invoice);
        return "redirect:/accounts/invoices";
    }

    @RequestMapping(value = "/accounts/invoices/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public  String delete(@PathVariable Integer id){
        invoiceService.deleteInvoice(id);
        return "redirect:/accounts/invoices";
    }
}
