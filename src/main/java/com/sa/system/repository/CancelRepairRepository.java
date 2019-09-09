package com.sa.system.repository;

import com.sa.system.entity.CancelRepair;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CancelRepairRepository extends JpaRepository<CancelRepair, Long> {

}