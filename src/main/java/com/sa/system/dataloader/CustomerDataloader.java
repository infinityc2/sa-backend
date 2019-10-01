package com.sa.system.dataloader;

import java.util.Optional;

import com.sa.system.entity.Customer;
import com.sa.system.entity.CustomerType;
import com.sa.system.entity.Gender;
import com.sa.system.entity.Province;
import com.sa.system.repository.CustomerRepository;
import com.sa.system.repository.CustomerTypeRepository;
import com.sa.system.repository.GenderRepository;
import com.sa.system.repository.ProvinceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataloader implements ApplicationRunner {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private GenderRepository genderRepository;
    @Autowired private CustomerTypeRepository customerTypeRepository;
    @Autowired private ProvinceRepository provinceRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer = new Customer();
        
        CustomerType customerType = new CustomerType();
        customerType.setType("VIP");
        customerTypeRepository.save(customerType);

        Gender gender = new Gender();
        gender.setGender("LGBT");
        genderRepository.save(gender);
        
        Province province = new Province();
        province.setProvince("ไซตามะ");
        provinceRepository.save(province);

        customer.setProvince(province);
        customer.setGender(gender);
        customer.setCustomerType(customerType);
        customer.setEmail("gg@gmail.com");
        customer.setFirstname("John");
        customer.setLastname("Cena");
        customer.setPassword("15963215");
        customer.setPhone("0987654321");
        customer.setAddress("145/78 ggg ggg");

        customerRepository.save(customer);
    }

    
}