package com.finalcourseproject.fleetms.accounts.services;

import com.finalcourseproject.fleetms.accounts.models.InvoiceStatus;
import com.finalcourseproject.fleetms.accounts.repositories.InvoiceStatusRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceStatusService {
    private final InvoiceStatusRepository invoiceStatusRepository;

    public InvoiceStatusService(InvoiceStatusRepository invoiceStatusRepository) {
        this.invoiceStatusRepository = invoiceStatusRepository;
    }

    public List<InvoiceStatus> getAll() {
        return invoiceStatusRepository.findAll();
    }

    public void save(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public void delete(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }

    public InvoiceStatus getById(Integer id) {
        return invoiceStatusRepository.findById(id).orElse(null);
    }
}
