package com.finalcourseproject.fleetms.hr.services;

import com.finalcourseproject.fleetms.hr.models.JobTitle;
import com.finalcourseproject.fleetms.hr.repositories.JobTitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobTitleService {
    private final JobTitleRepository jobTitleRepository;

    //Get All JobTitles
    public List<JobTitle> findAllJobTitles(){
        return jobTitleRepository.findAll();
    }

    //Get JobTitle By Id
    public Optional<JobTitle> findJobTitle(int id) {
        return jobTitleRepository.findById(id);
    }

    //Delete JobTitle
    public void deleteJobTitle(int id) {
        jobTitleRepository.deleteById(id);
    }

    //Update JobTitle
    public void saveJobTitle(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }
}
