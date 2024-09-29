package com.finalcourseproject.fleetms.accounts.services;

import com.finalcourseproject.fleetms.accounts.models.TransactionStatus;
import com.finalcourseproject.fleetms.accounts.repositories.TransactionRepository;
import com.finalcourseproject.fleetms.accounts.repositories.TransactionStatusRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionStatusService {
    private final TransactionStatusRepository transactionStatusRepository;

    public TransactionStatusService(TransactionStatusRepository transactionStatusRepository) {
        this.transactionStatusRepository = transactionStatusRepository;
    }

    public List<TransactionStatus> getAll() {
        return transactionStatusRepository.findAll();
    }

    public void save(TransactionStatus transactionStatus) {
        transactionStatusRepository.save(transactionStatus);
    }

    public void delete(Integer id) {
        transactionStatusRepository.deleteById(id);
    }

    public TransactionStatus getById(Integer id) {
        return transactionStatusRepository.findById(id).orElse(null);
    }
}
