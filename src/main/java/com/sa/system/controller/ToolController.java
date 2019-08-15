package com.sa.system.controller;

import java.util.List;

import com.sa.system.entity.Tool;
import com.sa.system.entity.ToolType;
import com.sa.system.repository.ToolRepository;
import com.sa.system.repository.ToolTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tool")
public class ToolController {

    @Autowired private ToolRepository toolRepository;
    @Autowired private ToolTypeRepository toolTypeRepository;

    @GetMapping("/name")
    public List<Tool> getTool() {
        return toolRepository.findAll();
    }

    @GetMapping("/type")
    public List<ToolType> getToolType() {
        return toolTypeRepository.findAll();
    }
}