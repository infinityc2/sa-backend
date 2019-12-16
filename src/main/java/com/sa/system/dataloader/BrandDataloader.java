package com.sa.system.dataloader;

import java.util.stream.Stream;

import com.sa.system.entity.Brand;
import com.sa.system.repository.BrandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class BrandDataloader implements ApplicationRunner {
    
    @Autowired private BrandRepository brandRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("Lenovo", "HP", "Dell", "Apple", "Asus", "Acer", "Sony", "Alienware", "Samsung", "Toshiba", "Microsoft", "Compaq", "MSI").forEach(item -> {
            Brand brand = new Brand();
            brand.setName(item);
            brandRepository.save(brand);
        });
        brandRepository.findAll().forEach(System.out::println);
	}

    
}