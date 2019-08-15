package com.sa.system.repository;

import java.util.Collection;

import com.sa.system.entity.Customer;
import com.sa.system.entity.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

	Collection<Invoice> findByCustomer(Customer findByEmail);

    
}