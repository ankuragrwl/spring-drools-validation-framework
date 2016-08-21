package com.cmx.intelix;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.internal.runtime.StatelessKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmxValidationFrameworkApplicationTests {

	@Autowired
	private StatelessKnowledgeSession session;

	@Autowired
	private Validator validator;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPersonAge() {
		final Person p = new Person(1, "Ankur", "Agrawal", 17);
		final Set<ConstraintViolation<Person>> violations = validator.validate(p);
		System.out.println(violations);
		Assert.assertNotNull(violations);
		Assert.assertEquals(Integer.valueOf(0), Integer.valueOf(violations.size()));
	}

}
