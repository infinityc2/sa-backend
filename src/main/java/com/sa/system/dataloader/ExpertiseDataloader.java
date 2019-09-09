package com.sa.system.dataloader;

import java.util.stream.Stream;

import com.sa.system.entity.Expertise;
import com.sa.system.repository.ExpertiseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ExpertiseDataloader implements ApplicationRunner {

    @Autowired private ExpertiseRepository expertiseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("Network", "Hardware", "Program", "Print").forEach(skill -> {
            Expertise expertise = new Expertise();
            expertise.setExpert(skill);
            expertiseRepository.save(expertise);
        });

    }

    
}