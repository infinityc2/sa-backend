package com.sa.system.controller;

import java.util.List;

import com.sa.system.entity.Gender;
import com.sa.system.repository.GenderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gender")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class GenderController {

    @Autowired private GenderRepository genderRepository;

    @GetMapping
    public List<Gender> getGender() {
        return genderRepository.findAll();
    }
}