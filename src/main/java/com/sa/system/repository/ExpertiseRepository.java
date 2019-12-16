package com.sa.system.repository;

import com.sa.system.entity.Expertise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ExpertiseRepository extends JpaRepository<Expertise, Long> {

}