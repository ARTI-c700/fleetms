package com.finalcourseproject.fleetms.accounts.services;

import com.finalcourseproject.fleetms.accounts.models.TransactionType;
import com.finalcourseproject.fleetms.accounts.repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionTypeService {

    private final TransactionTypeRepository transactionTypeRepository;

    public TransactionTypeService(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    //Get All TransactionTypes
    public List<TransactionType> findAll(){
        return transactionTypeRepository.findAll();
    }

    //Get TransactionType By Id
    public Optional<TransactionType> findById(int id) {
        return transactionTypeRepository.findById(id);
    }

    //Delete TransactionType
    public void delete(int id) {
        transactionTypeRepository.deleteById(id);
    }

    //Update TransactionType
    public void save( TransactionType transactionType) {
        transactionTypeRepository.save(transactionType);
    }

}