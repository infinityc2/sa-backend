package com.sa.system.dataloader;

import java.util.stream.Stream;

import com.sa.system.entity.Position;
import com.sa.system.repository.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PositionDataloader implements ApplicationRunner {

    @Autowired private PositionRepository positionRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("Network", "Hardware", "Program", "Print").forEach(skill -> {
            Position position = new Position();
            position.setPosition(skill);
            positionRepository.save(position);
        });

    }

    
}