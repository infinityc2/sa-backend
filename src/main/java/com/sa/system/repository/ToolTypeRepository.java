package com.sa.system.repository;

import com.sa.system.entity.ToolType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ToolTypeRepository extends JpaRepository<ToolType, Long>{

    
}