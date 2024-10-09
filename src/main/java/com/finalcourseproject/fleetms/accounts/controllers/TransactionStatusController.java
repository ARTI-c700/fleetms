package com.finalcourseproject.fleetms.accounts.controllers;

import com.finalcourseproject.fleetms.accounts.models.TransactionStatus;
import com.finalcourseproject.fleetms.accounts.services.TransactionStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class TransactionStatusController {
    private final TransactionStatusService transactionStatusService;

    @GetMapping("/accounts/transactionStatuses")
    public String transactionStatusParameters(Model model) {
        List<TransactionStatus> transactionStatuses = transactionStatusService.getAll();
        model.addAttribute("transactionStatuses", transactionStatuses);
        return "/accounts/transactionStatuses";
    }

    @GetMapping("/account/transactionStatuses/{id}")
    public TransactionStatus getTransactionStatusById(@PathVariable Integer id) {
        return transactionStatusService.getById(id);
    }

    @PostMapping("/accounts/transactionStatuses")
    public String saveTransactionStatus(TransactionStatus transactionStatus) {
        transactionStatusService.save(transactionStatus);
        return "redirect:/accounts/transactionStatuses";
    }

    @RequestMapping(value = "/accounts/transactionStatuses/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteTransactionStatus(@PathVariable Integer id) {
        transactionStatusService.delete(id);
        return "redirect:/accounts/transactionStatuses";
    }
}

