package com.sa.system.dataloader;

import java.util.stream.Stream;

import com.sa.system.entity.ITTechnician;
import com.sa.system.repository.ITTechnicianRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ITTechnicianDataloader implements ApplicationRunner {

    @Autowired private ITTechnicianRepository iTTechnicianRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("Junior", "Senior", "Professional", "Specialist").forEach(level -> {
            ITTechnician technician = new ITTechnician();
            technician.setTechnician(level);
            iTTechnicianRepository.save(technician);
        });

    }

    
}