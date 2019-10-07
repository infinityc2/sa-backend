package com.sa.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sa.system.entity.CancelRepair;
import com.sa.system.entity.CancelationCause;
import com.sa.system.entity.ProductReceiveType;
import com.sa.system.entity.Request;
import com.sa.system.repository.CancelRepairRepository;
import com.sa.system.repository.CancelationCauseRepository;
import com.sa.system.repository.ProductReceiveTypeRepository;
import com.sa.system.repository.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class CancelRepairController {

    @Autowired private CancelRepairRepository cancelRepairRepository;
    @Autowired private RequestRepository requestRepository;
    @Autowired private CancelationCauseRepository cancelationCauseRepository;
    @Autowired private ProductReceiveTypeRepository productReceiveTypeRepository;

    @GetMapping("/cancel")
    public List<CancelRepair> findCancelRepairs() {
        return cancelRepairRepository.findAll();
    }

    @GetMapping("/cancel/{id}")
    public Optional<CancelRepair> findCancel(@PathVariable Long id) {
        return cancelRepairRepository.findById(id);
    }

    @PostMapping("/cancel/")
    public CancelRepair addCancelRepair(@PathVariable Long requestId, @PathVariable Long cancelationCauseId, @PathVariable Long productReceiveId) {
        CancelRepair newCancelRepair = new CancelRepair();
        Optional<Request> request = requestRepository.findById(requestId);
        Optional<CancelationCause> cancelationCause = cancelationCauseRepository.findById(cancelationCauseId);
        Optional<ProductReceiveType> productReceiveType = productReceiveTypeRepository.findById(productReceiveId);

        newCancelRepair.setRequest(request.get());
        newCancelRepair.setCancelationCause(cancelationCause.get());
        newCancelRepair.setProductReceiveType(productReceiveType.get());
        newCancelRepair.setCancelDate(new Date());

        return cancelRepairRepository.save(newCancelRepair);
    }

}