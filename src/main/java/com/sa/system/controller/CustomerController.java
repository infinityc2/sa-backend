package com.sa.system.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.sa.system.entity.Address;
import com.sa.system.entity.Customer;
import com.sa.system.entity.CustomerType;
import com.sa.system.entity.Gender;
import com.sa.system.repository.AddressRepository;
import com.sa.system.repository.CustomerRepository;
import com.sa.system.repository.CustomerTypeRepository;
import com.sa.system.repository.GenderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = {"http://localhost:8080"})
public class CustomerController {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private CustomerTypeRepository customerTypeRepository;
    @Autowired private GenderRepository genderRepository;
    @Autowired private AddressRepository addressRepository;

    @PostMapping("/login")
    public Map<String, String> loginCustomer(@RequestBody Map<String, String> body) {
        Customer customer = customerRepository.findByEmail(body.get("email").toString());
        HashMap<String, String> map = new HashMap<>();
        try {
            boolean isMatch = customer.getPassword().matches(body.get("password").toString());
            map.put("message", isMatch ? "ยินดีต้อนรับ" : "รหัสผ่านไม่ถูกต้อง");
            map.put("id", isMatch ? customer.getId().toString() : null);
        } catch (Exception e) {
            map.put("message", "email ไม่ถูกต้อง");
        }
        return map;
    }

    @PostMapping("/register")
    public Customer register(@RequestBody Map<String, String> body) {
        Customer newCustomer = new Customer();
        Optional<CustomerType> customerType = customerTypeRepository.findById(Long.valueOf(body.get("customerType").toString()));
        Optional<Gender> gender = genderRepository.findById(Long.valueOf(body.get("gender").toString()));

        newCustomer.setGender(gender.get());
        newCustomer.setCustomerType(customerType.get());
        newCustomer.setEmail(body.get("email").toString());
        newCustomer.setFirstName(body.get("firstName").toString());
        newCustomer.setLastName(body.get("lastName").toString());
        newCustomer.setPassword(body.get("password").toString());
        newCustomer.setPhone(body.get("phone").toString());
        return customerRepository.save(newCustomer);
    }
    
}