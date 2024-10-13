package com.finalcourseproject.fleetms.reports;

import com.finalcourseproject.fleetms.accounts.repositories.TransactionRepository;
import com.finalcourseproject.fleetms.hr.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ReportsController {
    private final TransactionRepository transactionRepository;

    private final EmployeeRepository employeeRepository;

    @GetMapping("/reports/vehicles")
    public String vehicles() {
        return "/reports/vehicles";
    }

    @GetMapping("/reports/accounts")
    public String accounts(Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        model.addAttribute("employeeCount", employeeRepository.getCountByCountry());
        return "/reports/accounts";
    }

    @GetMapping("/reports/hires")
    public String hires(){
        return "/reports/hires";
    }

    @GetMapping("/reports/helpdesk")
    public String helpdesk(){
        return "/reports/helpdesk";
    }

    @GetMapping("/reports/maintenance")
    public String maintenance(){
        return "/reports/maintenance";
    }
}