package com.sa.system.dataloader;

import java.util.Optional;
import java.util.stream.Stream;

import com.sa.system.entity.Tool;
import com.sa.system.entity.ToolType;
import com.sa.system.repository.ToolRepository;
import com.sa.system.repository.ToolTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ToolDataloader implements ApplicationRunner {

    @Autowired private ToolRepository toolRepository;
    @Autowired private ToolTypeRepository toolTypeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("Software", "Hardware").forEach(type -> {
            ToolType toolType = new ToolType();
            toolType.setType(type);
            toolTypeRepository.save(toolType);
        });

        Optional<ToolType> software = toolTypeRepository.findById(1L);
        Optional<ToolType> hardware = toolTypeRepository.findById(2L);

        Tool software1 = new Tool();
        software1.setName("Windows 10");
        software1.setType(software.get());
        software1.setPrice(5000L);
        toolRepository.save(software1);

        Tool software2 = new Tool();
        software2.setName("Microsoft Office 2016");
        software2.setType(software.get());
        software2.setPrice(3000L);
        toolRepository.save(software2);

        Tool software3 = new Tool();
        software3.setName("Dropbox");
        software3.setType(software.get());
        software3.setPrice(0L);
        toolRepository.save(software3);

        Tool software4 = new Tool();
        software4.setName("Adobe Creative Cloud");
        software4.setType(software.get());
        software4.setPrice(5000L);
        toolRepository.save(software4);

        Tool software5 = new Tool();
        software5.setName("VLC Media Player");
        software5.setType(software.get());
        software5.setPrice(0L);
        toolRepository.save(software5);

        Tool software6 = new Tool();
        software6.setName("Sony Vegus");
        software6.setType(software.get());
        software6.setPrice(7000L);
        toolRepository.save(software6);

        Tool software7 = new Tool();
        software7.setName("Chrome");
        software7.setType(software.get());
        software7.setPrice(0L);
        toolRepository.save(software7);

        Tool hardware1 = new Tool();
        hardware1.setName("VGA Card");
        hardware1.setType(hardware.get());
        hardware1.setPrice(10000L);
        toolRepository.save(hardware1);

        Tool hardware2 = new Tool();
        hardware2.setName("Mainboard");
        hardware2.setType(hardware.get());
        hardware2.setPrice(3500L);
        toolRepository.save(hardware2);

        Tool hardware3 = new Tool();
        hardware3.setName("RAM");
        hardware3.setType(hardware.get());
        hardware3.setPrice(2000L);
        toolRepository.save(hardware3);

        Tool hardware4 = new Tool();
        hardware4.setName("Power Supply");
        hardware4.setType(hardware.get());
        hardware4.setPrice(2000L);
        toolRepository.save(hardware4);

        Tool hardware5 = new Tool();
        hardware5.setName("Heat Sink");
        hardware5.setType(hardware.get());
        hardware5.setPrice(1500L);
        toolRepository.save(hardware5);

        Tool hardware6 = new Tool();
        hardware6.setName("Harddisk");
        hardware6.setType(hardware.get());
        hardware6.setPrice(2400L);
        toolRepository.save(hardware6);

        Tool hardware7 = new Tool();
        hardware7.setName("Battery");
        hardware7.setType(hardware.get());
        hardware7.setPrice(1000L);
        toolRepository.save(hardware7);

        toolTypeRepository.findAll().forEach(System.out::println);
	}

    
}