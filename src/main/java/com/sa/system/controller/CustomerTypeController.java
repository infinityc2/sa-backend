package com.sa.system.controller;

import java.util.List;

import com.sa.system.entity.CustomerType;
import com.sa.system.repository.CustomerTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class CustomerTypeController {

    @Autowired private CustomerTypeRepository customerTypeRepository;

    @GetMapping("/customertype")
    public List<CustomerType> getCustomerType() {
        return customerTypeRepository.findAll();
    }
}