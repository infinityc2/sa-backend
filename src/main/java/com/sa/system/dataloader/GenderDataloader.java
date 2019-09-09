package com.sa.system.dataloader;

import java.util.stream.Stream;

import com.sa.system.entity.Gender;
import com.sa.system.repository.GenderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class GenderDataloader implements ApplicationRunner {

    @Autowired private GenderRepository genderRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("ชาย", "หญิง").forEach(sexual -> {
            Gender gender = new Gender();
            gender.setGender(sexual);
            genderRepository.save(gender);
        });
        genderRepository.findAll().forEach(System.out::println);
    }

}