package com.sa.system.repository;

import com.sa.system.entity.CancelationCause;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CancelationCauseRepository extends JpaRepository<CancelationCause, Long> {

}