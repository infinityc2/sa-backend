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
import com.sa.system.entity.Invoice;
import com.sa.system.entity.Tool;
import com.sa.system.repository.BrandRepository;
import com.sa.system.repository.ComputerTypeRepository;
import com.sa.system.repository.CustomerRepository;
import com.sa.system.repository.InvoiceRepository;
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
@RequestMapping("/invoice")
@CrossOrigin(origins = "http://localhost:8080")
public class InvoiceController {

    @Autowired private InvoiceRepository invoiceRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private BrandRepository brandRepository;
    @Autowired private ToolRepository toolRepository;
    @Autowired private ComputerTypeRepository computerTypeRepository;

    @GetMapping("/{email}")
    public Collection<Invoice> findInvoiceByCustomer(@PathVariable String email) {
        return invoiceRepository.findByCustomer(customerRepository.findByEmail(email));
    }

    @GetMapping("/menu")
    public List<Invoice> findInvoiceAll() {
        return invoiceRepository.findAll();
    }

    @GetMapping("/menu/{id}")
    public Optional<Invoice> findInvoiceById(@PathVariable Long id) {
        return invoiceRepository.findById(id);
    }
    
    @PostMapping("/repair/{items}")
    public Invoice postInvoice(@PathVariable List<Long> items, @RequestBody Map<String, String> body) {
        Invoice newInvoice = new Invoice();
        Optional<Brand> brand = brandRepository.findById(Long.valueOf(body.get("brand").toString()));
        Optional<ComputerType> computerType = computerTypeRepository.findById(Long.valueOf(body.get("type").toString()));

        newInvoice.setEmail(body.get("email").toString());
        newInvoice.setBrand(brand.get());
        newInvoice.setType(computerType.get());
        newInvoice.setPhone(body.get("phone").toString());
        newInvoice.setInvoiceDate(new Date());
        newInvoice.setSymptom(body.get("symptom").toString());

        try {
            Set<Tool> tools = new HashSet<Tool>();
            items.forEach(item -> {
                Tool tool = toolRepository.findById(item).get();
                tools.add(tool);
            });
            newInvoice.setTool(tools);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Customer email = customerRepository.findByEmail(body.get("customer").toString());
            Optional<Customer> customer = customerRepository.findById(email.getId());
            newInvoice.setCustomer(customer.get());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parseDate = dateFormat.parse(body.get("sentDate").toString());
            Timestamp date = new java.sql.Timestamp(parseDate.getTime());
            newInvoice.setSentDate(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return invoiceRepository.save(newInvoice);
    }

    @PostMapping("/repair/")
    public Invoice postInvoice(@RequestBody Map<String, String> body) {
        Invoice newInvoice = new Invoice();
        Optional<Brand> brand = brandRepository.findById(Long.valueOf(body.get("brand").toString()));
        Optional<ComputerType> computerType = computerTypeRepository.findById(Long.valueOf(body.get("type").toString()));

        newInvoice.setEmail(body.get("email").toString());
        newInvoice.setBrand(brand.get());
        newInvoice.setType(computerType.get());
        newInvoice.setPhone(body.get("phone").toString());
        newInvoice.setInvoiceDate(new Date());
        newInvoice.setSymptom(body.get("symptom").toString());

        try {
            Customer email = customerRepository.findByEmail(body.get("customer").toString());
            Optional<Customer> customer = customerRepository.findById(email.getId());
            newInvoice.setCustomer(customer.get());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parseDate = dateFormat.parse(body.get("sentDate").toString());
            Timestamp date = new java.sql.Timestamp(parseDate.getTime());
            newInvoice.setSentDate(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return invoiceRepository.save(newInvoice);
    }
}