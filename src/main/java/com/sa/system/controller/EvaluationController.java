package com.sa.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sa.system.entity.Evaluation;
import com.sa.system.entity.Repairman;
import com.sa.system.entity.Request;
import com.sa.system.entity.Satisfaction;
import com.sa.system.repository.EvaluationRepository;
import com.sa.system.repository.RepairmanRepository;
import com.sa.system.repository.RequestRepository;
import com.sa.system.repository.SatisfactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class EvaluationController {

    @Autowired private EvaluationRepository evaluationRepository;
    @Autowired private RequestRepository requestRepository;
    @Autowired private RepairmanRepository  repairmanRepository;
    @Autowired private SatisfactionRepository satisfactionRepository;

    @GetMapping("/evaluation")
    public List<Evaluation> getEvaluation() {
        return evaluationRepository.findAll();
    }

    @PostMapping("/evaluation/{request_id}/{repairman_id}/{satisfaction_id}")
    public Evaluation newEvaluation(@PathVariable Long request_id, @PathVariable Long repairman_id, @PathVariable Long satisfaction_id, @RequestBody Map<String, String> body) {
        Evaluation newEvaluation = new Evaluation();
        Optional<Request> request = requestRepository.findById(request_id);
        Optional<Repairman> repairman = repairmanRepository.findById(repairman_id);
        Optional<Satisfaction> satisfaction = satisfactionRepository.findById(satisfaction_id);

        newEvaluation.setSuggestion(body.get("suggestion").toString());
        newEvaluation.setRequest(request.get());
        newEvaluation.setRepairman(repairman.get());
        newEvaluation.setSatisfaction(satisfaction.get());
        newEvaluation.setEvaluationDate(new Date());

        return evaluationRepository.save(newEvaluation);
    }
}