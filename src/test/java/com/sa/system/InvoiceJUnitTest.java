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
import com.sa.system.entity.Invoice;
import com.sa.system.entity.Tool;
import com.sa.system.repository.BrandRepository;
import com.sa.system.repository.ComputerTypeRepository;
import com.sa.system.repository.CustomerRepository;
import com.sa.system.repository.InvoiceRepository;
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
public class InvoiceJUnitTest {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private BrandRepository brandRepository;
    @Autowired private ToolRepository toolRepository;
    @Autowired private InvoiceRepository invoiceRepository;
    @Autowired private ComputerTypeRepository computerTypeRepository;

    @Autowired private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void addInvoice() {
        Invoice invoice = new Invoice();
        Brand brand = new Brand();
        ComputerType computerType = new ComputerType();
        brand.setName("IBM");
        computerType.setType("Super Computer");
        entityManager.persist(brand);
        entityManager.persist(computerType);
        invoice.setSymptom("blue screen windows");
        invoice.setBrand(brand);
        invoice.setType(computerType);
        invoice.setEmail("customer1@gmail.com");
        invoice.setPhone("0977854163");
        invoice.setSentDate(new Date());
        invoice.setInvoiceDate(new Date());

        Customer customer = new Customer();
        customer.setEmail("customer1@gmail.com");
        customer.setPassword("123456789");
        customer.setPhone("0977854163");
        entityManager.persist(customer);
        invoice.setCustomer(customer);


        try {
            entityManager.persist(invoice);
            entityManager.flush();
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n Add Invoice be Problem\n" + violations);
        }

    }
}