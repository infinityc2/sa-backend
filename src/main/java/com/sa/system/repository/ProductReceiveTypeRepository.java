package com.sa.system.repository;

import com.sa.system.entity.ProductReceiveType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductReceiveTypeRepository extends JpaRepository<ProductReceiveType, Long> {

}