package com.sa.system.controller;

import java.util.List;
import java.util.Optional;

import com.sa.system.entity.ProductReceiveType;
import com.sa.system.repository.ProductReceiveTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class ProductReceiveTypeController {

    @Autowired private ProductReceiveTypeRepository productReceiveTypeRepository;

    @GetMapping("/product")
    public List<ProductReceiveType> getAllProductReceiveTypes() {
        return productReceiveTypeRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Optional<ProductReceiveType> getProductReceive(@PathVariable Long id) {
        return productReceiveTypeRepository.findById(id);
    }
}