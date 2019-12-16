package com.sa.system.controller;

import java.util.List;

import com.sa.system.entity.Position;
import com.sa.system.repository.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/position")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class PositionController {

    @Autowired private PositionRepository positionRepository;

    @GetMapping
    public List<Position> getPosition() {
        return positionRepository.findAll();
    }
}