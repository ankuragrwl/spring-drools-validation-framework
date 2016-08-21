package com.cmx.intelix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CmxValidationFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmxValidationFrameworkApplication.class, args);
	}

	// @Bean
	// public StatelessKnowledgeSession statelessKnowledgeSession() {
	// // final KnowledgeBuilder kbuilder =
	// // KnowledgeBuilderFactory.newKnowledgeBuilder();
	// // kbuilder.add(ResourceFactory.newFileSystemResource("PersonRules.drl"),
	// // ResourceType.DRL);
	// // //assertFalse(kbuilder.hasErrors());
	// // if (kbuilder.hasErrors()) {
	// // System.out.println(kbuilder.getErrors());
	// // }
	// // final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
	// // kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	// //
	// // final StatelessKnowledgeSession ksession =
	// // kbase.newStatelessKnowledgeSession();
	// //
	// // return ksession;
	//
	// final KieServices ks = KieServices.Factory.get();
	// final KieContainer kContainer = ks.getKieClasspathContainer();
	// // final KieSession kSession = kContainer.newKieSession();
	//
	// return (StatelessKnowledgeSession) kContainer.newStatelessKieSession();
	// }
}
