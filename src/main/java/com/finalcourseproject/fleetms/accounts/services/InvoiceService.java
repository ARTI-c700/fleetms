package com.finalcourseproject.fleetms.accounts.services;

import com.finalcourseproject.fleetms.accounts.models.Invoice;
import com.finalcourseproject.fleetms.accounts.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    // Get all invoices
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // Get an invoice by its Id
    public Invoice getInvoice(Integer id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    // Delete an invoice
    public void deleteInvoice(Integer id) {
        invoiceRepository.deleteById(id);
    }

    // Update an invoice
    public void saveInvoice (Invoice invoice) {
        invoiceRepository.save(invoice);
    }
}
