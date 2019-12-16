package com.sa.system.repository;

import com.sa.system.entity.Repairman;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepairmanRepository extends JpaRepository<Repairman, Long> {

}