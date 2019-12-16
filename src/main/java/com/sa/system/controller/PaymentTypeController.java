package com.sa.system.controller;

import java.util.List;

import com.sa.system.entity.PaymentType;
import com.sa.system.repository.PaymentTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class PaymentTypeController {

    @Autowired private PaymentTypeRepository paymentTypeRepository;

    @GetMapping("/payment/type")
    public List<PaymentType> getAllPaymentType() {
        return paymentTypeRepository.findAll();
    }
}