package com.finalcourseproject.fleetms.accounts.services;

import com.finalcourseproject.fleetms.accounts.models.Transaction;
import com.finalcourseproject.fleetms.accounts.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }

    public Transaction getById(Integer id) {
        return transactionRepository.findById(id).orElse(null);
    }
}
