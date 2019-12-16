package com.sa.system.repository;

import com.sa.system.entity.Satisfaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SatisfactionRepository extends JpaRepository<Satisfaction, Long>{

    
}