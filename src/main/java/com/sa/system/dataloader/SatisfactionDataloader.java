package com.sa.system.dataloader;

import java.util.stream.Stream;

import com.sa.system.entity.Satisfaction;
import com.sa.system.repository.SatisfactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SatisfactionDataloader implements ApplicationRunner {

    @Autowired private SatisfactionRepository satisfactionRepository;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("พึงพอใจมากที่สุด", "พึงพอใจมาก", "พึงพอใจปานกลาง", "พึงพอใจน้อย", "ไม่พึงพอใจ").forEach(level -> {
            Satisfaction satisfaction = new Satisfaction();
            satisfaction.setSatisfactionLevel(level);
            satisfactionRepository.save(satisfaction);
        });
    }

    
}