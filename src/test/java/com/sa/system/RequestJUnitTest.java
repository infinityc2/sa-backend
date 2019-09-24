package com.sa.system;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.sa.system.entity.Brand;
import com.sa.system.entity.ComputerType;
import com.sa.system.entity.Customer;
import com.sa.system.entity.CustomerType;
import com.sa.system.entity.Gender;
import com.sa.system.entity.Request;
import com.sa.system.entity.Tool;
import com.sa.system.repository.BrandRepository;
import com.sa.system.repository.ComputerTypeRepository;
import com.sa.system.repository.CustomerRepository;
import com.sa.system.repository.RequestRepository;
import com.sa.system.repository.ToolRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RequestJUnitTest {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private BrandRepository brandRepository;
    @Autowired private ToolRepository toolRepository;
    @Autowired private RequestRepository requestRepository;
    @Autowired private ComputerTypeRepository computerTypeRepository;

    @Autowired private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void addRequest() {
        Request request = new Request();
        Brand brand = new Brand();
        ComputerType computerType = new ComputerType();
        brand.setName("IBM");
        computerType.setType("Super Computer");
        entityManager.persist(brand);
        entityManager.persist(computerType);
        request.setSymptom("blue screen windows");
        request.setBrand(brand);
        request.setType(computerType);
        request.setEmail("customer1@gmail.com");
        request.setPhone("0977854163");
        request.setSentDate(new Date());
        request.setRequestDate(new Date());

        Customer customer = new Customer();
        Gender gender = new Gender();
        gender.setGender("เกย์");
        entityManager.persist(gender);

        CustomerType customerType = new CustomerType();
        customerType.setType("VIP");
        entityManager.persist(customerType);

        customer.setGender(gender);
        customer.setCustomerType(customerType);
        customer.setEmail("customer1@gmail.com");
        customer.setFirstname("John");
        customer.setLastname("Doe");
        customer.setPassword("123456789");
        customer.setPhone("0977854163");
        entityManager.persist(customer);
        request.setCustomer(customer);

        try {
            entityManager.persist(request);
            entityManager.flush();
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n Add Invoice be Problem\n" + violations);
        }

    }
}