package com.sa.system.controller;

import java.util.List;

import com.sa.system.entity.Province;
import com.sa.system.repository.ProvinceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class ProvinceController {

    @Autowired private ProvinceRepository provinceRepository;

    @GetMapping("/province")
    public List<Province> getProvince() {
        return provinceRepository.findAll();
    }
    
}