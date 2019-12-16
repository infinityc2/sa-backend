package com.sa.system.repository;

import com.sa.system.entity.PaymentType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long>{

}