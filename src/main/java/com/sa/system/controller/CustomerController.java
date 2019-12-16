package com.sa.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sa.system.entity.Customer;
import com.sa.system.entity.CustomerType;
import com.sa.system.entity.Gender;
import com.sa.system.entity.Province;
import com.sa.system.repository.CustomerRepository;
import com.sa.system.repository.CustomerTypeRepository;
import com.sa.system.repository.GenderRepository;
import com.sa.system.repository.ProvinceRepository;

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
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class CustomerController {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private CustomerTypeRepository customerTypeRepository;
    @Autowired private GenderRepository genderRepository;
    @Autowired private ProvinceRepository provinceRepository;

    @GetMapping("/member")
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @PostMapping("/login")
    public Map<String, String> loginCustomer(@RequestBody Map<String, String> body) {
        Customer customer = customerRepository.findByEmail(body.get("email").toString());
        HashMap<String, String> map = new HashMap<>();
        try {
            boolean isMatch = customer.getPassword().matches(body.get("password").toString());
            map.put("message", isMatch ? "ยินดีต้อนรับ" : "รหัสผ่านไม่ถูกต้อง");
            map.put("id", isMatch ? customer.getId().toString() : null);
        } catch (Exception e) {
            map.put("id", null);
            map.put("message", "email ไม่ถูกต้อง");
        }
        return map;
    }

    @PostMapping("/register")
    public Customer register(@RequestBody Map<String, String> body) {
        Customer newCustomer = new Customer();
        Optional<CustomerType> customerType = customerTypeRepository.findById(Long.valueOf(body.get("customerType").toString()));
        Optional<Gender> gender = genderRepository.findById(Long.valueOf(body.get("gender").toString()));
        Optional<Province> province = provinceRepository.findById(Long.valueOf(body.get("province").toString()));

        newCustomer.setProvince(province.get());
        newCustomer.setGender(gender.get());
        newCustomer.setCustomerType(customerType.get());
        newCustomer.setEmail(body.get("email").toString());
        newCustomer.setFirstname(body.get("firstname").toString());
        newCustomer.setLastname(body.get("lastname").toString());
        newCustomer.setPassword(body.get("password").toString());
        newCustomer.setPhone(body.get("phone").toString());
        newCustomer.setAddress(body.get("address").toString());
        return customerRepository.save(newCustomer);
    }
    
}