package com.sa.system.repository;

import com.sa.system.entity.ReceiveProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReceiveProductRepository extends JpaRepository<ReceiveProduct, Long> {

}