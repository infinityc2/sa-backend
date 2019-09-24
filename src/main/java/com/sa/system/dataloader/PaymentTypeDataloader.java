package com.sa.system.dataloader;

import java.util.stream.Stream;

import com.sa.system.entity.PaymentType;
import com.sa.system.repository.PaymentTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PaymentTypeDataloader implements ApplicationRunner {

    @Autowired private PaymentTypeRepository paymentTypeRepository;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("เงินสด", "บัตรเครดิต").forEach(pay -> {
            PaymentType paymentType = new PaymentType();
            paymentType.setType(pay);
            paymentTypeRepository.save(paymentType);
        });

    }  
}