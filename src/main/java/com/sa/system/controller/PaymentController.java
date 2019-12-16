package com.sa.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sa.system.entity.Payment;
import com.sa.system.entity.PaymentType;
import com.sa.system.entity.Repairman;
import com.sa.system.entity.Request;
import com.sa.system.repository.PaymentRepository;
import com.sa.system.repository.PaymentTypeRepository;
import com.sa.system.repository.RepairmanRepository;
import com.sa.system.repository.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class PaymentController {

    @Autowired private PaymentRepository paymentRepository;
    @Autowired private PaymentTypeRepository paymentTypeRepository;
    @Autowired private RepairmanRepository repairmanRepository;
    @Autowired private RequestRepository requestRepository;

    @GetMapping("/payment")
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @GetMapping("/payment/{id}")
    public Optional<Payment> getOnePayment(@PathVariable Long id) {
        return paymentRepository.findById(id);
    }

    @PostMapping("/payment/{paymentTypeId}/{requestId}/{repairmanId}")
    public Payment addPayment(@PathVariable Long paymentTypeId, @PathVariable Long requestId, @PathVariable Long repairmanId, @RequestBody Map<String, String> body) {
        Payment newPayment = new Payment();
        Optional<PaymentType> paymentType = paymentTypeRepository.findById(paymentTypeId);
        Optional<Request> request = requestRepository.findById(requestId);
        Optional<Repairman> repairman = repairmanRepository.findById(repairmanId);

        newPayment.setPaymentType(paymentType.get());
        newPayment.setRequest(request.get());
        newPayment.setRepairman(repairman.get());
        newPayment.setFee(Long.valueOf(body.get("fee").toString()));
        newPayment.setPayDate(new Date());
        return paymentRepository.save(newPayment);
    }
}