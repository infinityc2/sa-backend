package com.sa.system.controller;

import java.util.List;
import java.util.Optional;

import com.sa.system.entity.Satisfaction;
import com.sa.system.repository.SatisfactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:4200" })
public class SatisfactionController {

    @Autowired
    private SatisfactionRepository satisfactionRepository;

    @GetMapping("/satisfaction")
    public List<Satisfaction> getSatisfaction() {
        return satisfactionRepository.findAll();
    }

    @GetMapping("/satisfaction/{id}")
    public Optional<Satisfaction> getSatisfaction(@PathVariable Long id) {
        return satisfactionRepository.findById(id);
    }
}