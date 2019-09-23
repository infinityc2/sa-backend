package com.sa.system.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import com.sa.system.entity.Brand;
import com.sa.system.entity.ComputerType;
import com.sa.system.entity.Customer;
import com.sa.system.entity.Request;
import com.sa.system.entity.Tool;
import com.sa.system.repository.BrandRepository;
import com.sa.system.repository.ComputerTypeRepository;
import com.sa.system.repository.CustomerRepository;
import com.sa.system.repository.RequestRepository;
import com.sa.system.repository.ToolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class RequestController {

    @Autowired private RequestRepository requestRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private BrandRepository brandRepository;
    @Autowired private ToolRepository toolRepository;
    @Autowired private ComputerTypeRepository computerTypeRepository;

    @GetMapping("/{email}")
    public Collection<Request> findRequestByCustomer(@PathVariable String email) {
        return requestRepository.findByCustomer(customerRepository.findByEmail(email));
    }

    @GetMapping("/menu")
    public List<Request> findRequestAll() {
        return requestRepository.findAll();
    }

    @GetMapping("/menu/{id}")
    public Optional<Request> findRequestById(@PathVariable Long id) {
        return requestRepository.findById(id);
    }
    
    @PostMapping("/repair/{items}")
    public Request addRequest(@PathVariable List<Long> items, @RequestBody Map<String, String> body) {
        Request newRequest = new Request();
        Optional<Brand> brand = brandRepository.findById(Long.valueOf(body.get("brand").toString()));
        Optional<ComputerType> computerType = computerTypeRepository.findById(Long.valueOf(body.get("type").toString()));

        newRequest.setEmail(body.get("email").toString());
        newRequest.setBrand(brand.get());
        newRequest.setType(computerType.get());
        newRequest.setPhone(body.get("phone").toString());
        newRequest.setRequestDate(new Date());
        newRequest.setSymptom(body.get("symptom").toString());

        try {
            Set<Tool> tools = new HashSet<Tool>();
            items.forEach(item -> {
                Tool tool = toolRepository.findById(item).get();
                tools.add(tool);
            });
            newRequest.setTool(tools);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Optional<Customer> customer = customerRepository.findById(Long.valueOf(body.get("customer").toString()));
            newRequest.setCustomer(customer.get());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parseDate = dateFormat.parse(body.get("sentDate").toString());
            Timestamp date = new java.sql.Timestamp(parseDate.getTime());
            newRequest.setSentDate(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return requestRepository.save(newRequest);
    }

    @PostMapping("/repair/")
    public Request addRequest(@RequestBody Map<String, String> body) {
        Request newRequest = new Request();
        Optional<Brand> brand = brandRepository.findById(Long.valueOf(body.get("brand").toString()));
        Optional<ComputerType> computerType = computerTypeRepository.findById(Long.valueOf(body.get("type").toString()));

        newRequest.setEmail(body.get("email").toString());
        newRequest.setBrand(brand.get());
        newRequest.setType(computerType.get());
        newRequest.setPhone(body.get("phone").toString());
        newRequest.setRequestDate(new Date());
        newRequest.setSymptom(body.get("symptom").toString());

        try {
            Optional<Customer> customer = customerRepository.findById(Long.valueOf(body.get("customer").toString()));
            newRequest.setCustomer(customer.get());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parseDate = dateFormat.parse(body.get("sentDate").toString());
            Timestamp date = new java.sql.Timestamp(parseDate.getTime());
            newRequest.setSentDate(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return requestRepository.save(newRequest);
    }
}