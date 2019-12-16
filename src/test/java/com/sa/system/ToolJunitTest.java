package com.sa.system;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.sa.system.entity.Tool;
import com.sa.system.entity.ToolType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ToolJunitTest {

    @Autowired private TestEntityManager entityManager;
    private Validator  validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void ToolNotNull() {
        ToolType toolType = new ToolType();
        toolType.setType("Network");
        entityManager.persist(toolType);
        entityManager.flush();

        Tool tool = new Tool();
        tool.setName("P2P");
        tool.setType(toolType);
        tool.setPrice(500L);

        try {
            entityManager.persist(tool);
            entityManager.flush();
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations, false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n toolNotNull\n" + violations);
        }
    }
}