package com.sa.system.controller;

import java.util.List;

import com.sa.system.entity.Brand;
import com.sa.system.entity.ComputerType;
import com.sa.system.repository.BrandRepository;
import com.sa.system.repository.ComputerTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/computer")
@CrossOrigin(origins = {"http://localhost:8080"})
public class BrandController {

    @Autowired private BrandRepository brandRepository;
    @Autowired private ComputerTypeRepository computerTypeRepository;

    @GetMapping("/brand")
    public List<Brand> getBrand() {
        return brandRepository.findAll();
    }

    @GetMapping("/type")
    public List<ComputerType> getComputerType() {
        return computerTypeRepository.findAll();
    }

}