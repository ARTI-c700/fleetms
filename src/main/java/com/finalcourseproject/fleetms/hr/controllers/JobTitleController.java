package com.finalcourseproject.fleetms.hr.controllers;

import com.finalcourseproject.fleetms.hr.models.JobTitle;
import com.finalcourseproject.fleetms.hr.services.JobTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class JobTitleController {
    private final JobTitleService jobTitleService;

    @GetMapping("/hr/jobTitles")
    public String parameters(Model model){
        List<JobTitle> jobTitles = jobTitleService.findAllJobTitles();
        model.addAttribute("jobTitles", jobTitles);
        return "hr/jobTitles";
    }

    //Get Job Title by id
    @GetMapping("/hr/jobTitle/{id}")
    @ResponseBody
    public JobTitle getById(@PathVariable Integer id){
        return jobTitleService.findJobTitle(id).orElse(null);
    }

    @PostMapping("/hr/jobTitles")
    public String save(JobTitle jobTitle){
        jobTitleService.saveJobTitle(jobTitle);
        return "redirect:/hr/jobTitles";
    }

    @DeleteMapping(value="/hr/jobTitle/delete/{id}")
    public String delete(@PathVariable Integer id) {
        jobTitleService.deleteJobTitle(id);
        return "redirect:/hr/jobTitles";
    }
}
