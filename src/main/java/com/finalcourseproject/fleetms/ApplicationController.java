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

    @GetMapping("/_layout")
    public String layout() {
        return "_layout";
    }

    @GetMapping("/index2")
    public String index2() {
        return "index2";
    }
}
