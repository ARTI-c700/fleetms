package com.finalcourseproject.fleetms.security.repositories;

import com.finalcourseproject.fleetms.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByUsernameAndLastname(String username, String lastName);
    User findByEmail(String email);
}
