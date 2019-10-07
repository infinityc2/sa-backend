package com.sa.system.dataloader;

import java.util.stream.Stream;

import com.sa.system.entity.ProductReceiveType;
import com.sa.system.repository.ProductReceiveTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductReceiveTypeDataloader implements ApplicationRunner {

    @Autowired private ProductReceiveTypeRepository productReceiveTypeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("By yourself", "By kerry express").forEach(product -> {
            ProductReceiveType productReceiveType = new ProductReceiveType();
            productReceiveType.setType(product);
            productReceiveTypeRepository.save(productReceiveType);
        });

    }

    
}