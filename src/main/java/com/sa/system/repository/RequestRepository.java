package com.sa.system.repository;

import java.util.Collection;

import com.sa.system.entity.Customer;
import com.sa.system.entity.Request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RequestRepository extends JpaRepository<Request, Long> {

	Collection<Request> findByCustomer(Customer customer);
}