package com.finalcourseproject.fleetms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index.html")
    public String home() {
        return "index";
    }

    @GetMapping("/404.html")
    public String notFound() {
        return "404";
    }

    @GetMapping("/_layout.html")
    public String layout() {
        return "_layout";
    }

    @GetMapping("/index2.html")
    public String index2() {
        return "index2";
    }

    @GetMapping("/accounts.html")
    public String accounts() {
        return "/accounts/index.html";
    }

    @GetMapping("/fleet.html")
    public String fleet() {
        return "/fleet/index.html";
    }

    @GetMapping("/helpdesk.html")
    public String helpdesk() {
        return "/helpdesk/index.html";
    }

    @GetMapping("/hr.html")
    public String hr() {
        return "/hr/index.html";
    }

    @GetMapping("/parameters.html")
    public String parameters() {
        return "/parameters/index.html";
    }

    @GetMapping("/payroll.html")
    public String payroll() {
        return "/payroll/index.html";
    }

}
