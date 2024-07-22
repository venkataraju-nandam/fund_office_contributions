package com.fundoffice.demo;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.io.Resource;
import org.kie.api.runtime.Globals;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {
private static final String RULES_ORDER_DISCOUNT_XLS = "rules/employee-employer-rules.drl.xlsx";
 private static final KieServices kieServices = KieServices.Factory.get();
@Bean
 public KieContainer kieContainer() {
  Resource dt = ResourceFactory.newClassPathResource(RULES_ORDER_DISCOUNT_XLS, getClass());
  System.out.print( ".....RULES_ORDER_DISCOUNT_XLS..... \n" + dt  );
  
  KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(dt);

  KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
  System.out.print( ".....DroolsConfig: kieBuilder.getResults()..... \n" );
  if (kieBuilder.getResults() != null) {
	    System.out.println( kieBuilder.getResults() );
//	    System.out.println( kieBuilder.getResults().getMessages() );
  }
  kieBuilder.buildAll();
  if (kieBuilder.getResults() != null) {
	    System.out.println( kieBuilder.getResults() );
//	    System.out.println( kieBuilder.getResults().getMessages() );
  }
  
//  if (kieBuilder.hasErrors()) {
//	    System.out.print( kieBuilder.getErrors() );
//  }
  
//  Globals globals = kieSession.getGlobals();
//  System.out.println( globals.getGlobalKeys() );
  
  KieModule kieModule = kieBuilder.getKieModule();
  KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
//  System.out.println( kieModule.getReleaseId());
//  System.out.println( kieContainer.getKieBaseNames());
//  System.out.println( kieContainer.getKieSessionConfiguration().toString());
  return kieContainer;
 }
}
