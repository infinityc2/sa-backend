package com.sa.system.dataloader;

import java.util.stream.Stream;

import com.sa.system.entity.CancelationCause;
import com.sa.system.repository.CancelationCauseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CancelationCauseDataloader implements ApplicationRunner {

    @Autowired private CancelationCauseRepository cancelationCauseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("Expensive", "Too long", "Bad fixed", "Mean").forEach(cancel -> {
            CancelationCause cancelationCause = new CancelationCause();
            cancelationCause.setCause(cancel);
            cancelationCauseRepository.save(cancelationCause);
        });

    }

    
}