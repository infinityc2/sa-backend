package com.sa.system.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.sa.system.entity.Invoice;
import com.sa.system.repository.CustomerRepository;
import com.sa.system.repository.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired private InvoiceRepository invoiceRepository;
    @Autowired private CustomerRepository customerRepository;

    @GetMapping("/{email}")
    public Collection<Invoice> findInvoiceByCustomer(@PathVariable String email) {
        return invoiceRepository.findByCustomer(customerRepository.findByEmail(email));
    }

    @GetMapping("/menu")
    public List<Invoice> findInvoiceAll() {
        return invoiceRepository.findAll();
    }

    @GetMapping("/menu/{id}")
    public Optional<Invoice> findInvoiceById(@PathVariable Long id) {
        return invoiceRepository.findById(id);
    }
    
}