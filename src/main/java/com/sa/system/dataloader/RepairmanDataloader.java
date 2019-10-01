package com.sa.system.dataloader;

import com.sa.system.entity.Expertise;
import com.sa.system.entity.Gender;
import com.sa.system.entity.Position;
import com.sa.system.entity.Repairman;
import com.sa.system.repository.ExpertiseRepository;
import com.sa.system.repository.GenderRepository;
import com.sa.system.repository.PositionRepository;
import com.sa.system.repository.RepairmanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RepairmanDataloader implements ApplicationRunner {

    @Autowired private RepairmanRepository repairmanRepository;
    @Autowired private PositionRepository positionRepository;
    @Autowired private GenderRepository genderRepository;
    @Autowired private ExpertiseRepository expertiseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Repairman repairman = new Repairman();

        Position position = new Position();
        position.setPosition("Legendary");
        positionRepository.save(position);

        Gender gender = new Gender();
        gender.setGender("LGBTQ");
        genderRepository.save(gender);

        Expertise expertise = new Expertise();
        expertise.setExpertise("Data Sciencist");
        expertiseRepository.save(expertise);

        repairman.setGender(gender);
        repairman.setPosition(position);
        repairman.setExpertise(expertise);
        repairman.setFirstName("Timber");
        repairman.setLastName("Saw");
        repairman.setPhone("0963258741");
        repairmanRepository.save(repairman);
    }

    
}