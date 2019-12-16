package com.sa.system.dataloader;

import java.util.stream.Stream;

import com.sa.system.entity.CustomerType;
import com.sa.system.repository.CustomerTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerTypeDataloader implements ApplicationRunner {

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("Personal", "Organization").forEach(type -> {
            CustomerType customerType = new CustomerType();
            customerType.setType(type);
            customerTypeRepository.save(customerType);
        });
    }

}