package com.sa.system.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sa.system.entity.Expertise;
import com.sa.system.entity.Gender;
import com.sa.system.entity.Position;
import com.sa.system.entity.Repairman;
import com.sa.system.repository.ExpertiseRepository;
import com.sa.system.repository.GenderRepository;
import com.sa.system.repository.PositionRepository;
import com.sa.system.repository.RepairmanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repairman")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class RepairmanController {

    @Autowired private RepairmanRepository repairmanRepository;
    @Autowired private GenderRepository genderRepository;
    @Autowired private ExpertiseRepository expertiseRepository;
    @Autowired private PositionRepository positionRepository;

    @GetMapping("/group")
    public List<Repairman> getRepairman() {
        return repairmanRepository.findAll();
    }

    @PostMapping("/register")
    public Repairman addRepairman(@RequestBody Map<String, String> body) {
        Repairman newRepairman = new Repairman();
        Optional<Gender> gender = genderRepository.findById(Long.valueOf(body.get("gender").toString()));
        Optional<Position> position = positionRepository.findById(Long.valueOf(body.get("position").toString()));
        Optional<Expertise> expertise = expertiseRepository.findById(Long.valueOf(body.get("expertise").toString()));

        newRepairman.setGender(gender.get());
        newRepairman.setPosition(position.get());
        newRepairman.setExpertise(expertise.get());
        newRepairman.setFirstName(body.get("firstName"));
        newRepairman.setLastName(body.get("lastName"));
        newRepairman.setPhone(body.get("phone"));

        return repairmanRepository.save(newRepairman);
    }
}