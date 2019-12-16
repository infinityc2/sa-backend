package com.sa.system.repository;

import com.sa.system.entity.ComputerType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ComputerTypeRepository extends JpaRepository<ComputerType, Long>{

    
}