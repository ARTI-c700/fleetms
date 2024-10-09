package com.finalcourseproject.fleetms.accounts.controllers;

import com.finalcourseproject.fleetms.accounts.models.InvoiceStatus;
import com.finalcourseproject.fleetms.accounts.services.InvoiceStatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceStatusController {
    private final InvoiceStatusService invoiceStatusService;

    public InvoiceStatusController(InvoiceStatusService invoiceStatusService) {
        this.invoiceStatusService = invoiceStatusService;
    }

    @GetMapping("/accounts/invoiceStatuses")
    public String getAllInvoiceStatuses(Model model) {
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getAll();
        model.addAttribute("invoiceStatuses", invoiceStatusList);
        return "/accounts/invoiceStatuses";
    }

    @RequestMapping("/accounts/invoiceStatus/{id}")
    @ResponseBody
    public InvoiceStatus getInvoiceStatus(@PathVariable Integer id) {
        return invoiceStatusService.getById(id);
    }

    @PostMapping(value="/accounts/invoiceStatuses")
    public String addNew(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/accounts/invoiceStatuses";
    }

    @RequestMapping(value="accounts/invoiceStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        invoiceStatusService.delete(id);
        return "redirect:/accounts/invoiceStatuses";
    }
}
