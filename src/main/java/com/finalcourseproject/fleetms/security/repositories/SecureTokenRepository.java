package com.finalcourseproject.fleetms.security.repositories;

import com.finalcourseproject.fleetms.security.models.SecureToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureTokenRepository extends JpaRepository<SecureToken, Integer> {
    SecureToken findByToken(String token);
    Integer removeByToken(final String token);
}
