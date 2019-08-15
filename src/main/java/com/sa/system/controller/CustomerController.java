package com.sa.system.controller;

import java.util.Map;

import com.sa.system.entity.Customer;
import com.sa.system.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired private CustomerRepository customerRepository;

    @GetMapping("/login")
    public boolean loginCustomer(@RequestBody Map<String, String> body) {
        Customer customer = customerRepository.findByEmail(body.get("email").toString());
        return customer.getPassword().matches(body.get("password").toString());
    }

    @PostMapping("/register")
    public Customer register(@RequestBody Map<String, String> body) {
        Customer newCustomer = new Customer();
        newCustomer.setEmail(body.get("email").toString());
        newCustomer.setPassword(body.get("password").toString());
        newCustomer.setPhone(body.get("phone").toString());
        return customerRepository.save(newCustomer);
    }
    
}