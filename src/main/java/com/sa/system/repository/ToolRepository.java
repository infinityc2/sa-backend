package com.sa.system.repository;

import java.util.Collection;

import com.sa.system.entity.Request;
import com.sa.system.entity.Tool;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ToolRepository extends JpaRepository<Tool, Long>{

    Collection<Tool> findByRequest(Request request);
}