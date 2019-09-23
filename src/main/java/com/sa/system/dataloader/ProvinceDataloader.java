package com.sa.system.dataloader;

import java.util.stream.Stream;

import com.sa.system.entity.Province;
import com.sa.system.repository.ProvinceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProvinceDataloader implements ApplicationRunner {

    @Autowired private ProvinceRepository provinceRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("กรุงเทพมหานคร", "ตาก", "อุดรธานี").forEach(place -> {
            Province province = new Province();
            province.setProvince(place);
            provinceRepository.save(province);
        });
    }

    
}