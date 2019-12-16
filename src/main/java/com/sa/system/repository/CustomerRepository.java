package com.sa.system.repository;

import com.sa.system.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer findByEmail(String email);

    
}