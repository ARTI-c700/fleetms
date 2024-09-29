package com.finalcourseproject.fleetms.hr.repositories;

import com.finalcourseproject.fleetms.hr.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
}