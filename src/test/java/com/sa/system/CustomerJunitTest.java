// package com.sa.system;

// import static org.junit.Assert.assertEquals;

// import java.util.Set;

// import javax.validation.ConstraintViolation;
// import javax.validation.ConstraintViolationException;
// import javax.validation.Validation;
// import javax.validation.Validator;
// import javax.validation.ValidatorFactory;

// import com.sa.system.entity.Customer;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
// import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)
// @DataJpaTest
// public class CustomerJunitTest {

//     @Autowired private TestEntityManager entityManager;
//     private Validator validator;

//     @Before
//     public void setup() {
//         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//         validator = factory.getValidator();
//     }

//     @Test
//     public void customerNotNull() {
//         Customer customer = new Customer();
//         customer.setEmail("customer1@gmail.com");
//         customer.setPassword("password1");
//         customer.setPhone("0984458956");

//         try {
//             entityManager.persist(customer);
//             entityManager.flush();
//         } catch(ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("\n\n\n customerNotNull\n" + violations);
//         }
//     }
// }