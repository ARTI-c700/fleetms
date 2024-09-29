package com.finalcourseproject.fleetms.accounts.repositories;

import com.finalcourseproject.fleetms.accounts.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
