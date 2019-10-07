package com.sa.system.controller;

import java.util.List;
import java.util.Optional;

import com.sa.system.entity.CancelationCause;
import com.sa.system.repository.CancelationCauseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class CancelationCauseController {

    @Autowired private CancelationCauseRepository cancelationCauseRepository;

    @GetMapping("/cause")
    public List<CancelationCause> getCancelationCauses() {
        return cancelationCauseRepository.findAll();
    }

    @GetMapping("/cause/{id}")
    public Optional<CancelationCause> getCancelationCause(@PathVariable Long id) {
        return cancelationCauseRepository.findById(id);
    }
}