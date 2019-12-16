package com.sa.system.controller;

import java.util.List;

import com.sa.system.entity.Expertise;
import com.sa.system.repository.ExpertiseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expertise")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class ExpertiseController {

    @Autowired private ExpertiseRepository expertiseRepository;

    @GetMapping("/expert")
    public List<Expertise> getExpertise() {
        return expertiseRepository.findAll();
    }
}