/**
 * Project : cmx-validation-framework
 * Type : SrpingDroolsConfig
 * Created By : shekharp
 * Date : Aug 21, 2016
 */
package com.cmx.intelix;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Validator;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author shekharp
 *
 */
@Configuration
public class SrpingDroolsConfig {

	@Bean
	public Validator validator() {
		final LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		return factory;
	}

	@Bean
	public Collaborators collaborators() {
		final Map<String, Object> collaborators = new HashMap<String, Object>();
		// collaborators.put("applicantRepository", new ApplicantRepository());
		return new Collaborators(collaborators);
	}

	@Bean
	public KnowledgeBase knowledgeBase() {
		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("PersonRules.drl"), ResourceType.DRL);
		if (kbuilder.hasErrors()) {
			throw new RuntimeException(kbuilder.getErrors().toString());
		}
		final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}

	@Bean
	public StatelessKnowledgeSession statelessKnowledgeSession() {
		return knowledgeBase().newStatelessKnowledgeSession();
	}

}
