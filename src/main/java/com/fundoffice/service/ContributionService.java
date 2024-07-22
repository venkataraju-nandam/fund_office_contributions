package com.fundoffice.service;

import org.drools.template.model.Global;
import org.kie.api.runtime.Globals;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundoffice.model.Contribution;
import com.fundoffice.model.EmpRequest;

@Service
public class ContributionService {
 
    @Autowired
    private KieContainer kieContainer;
 
    public Contribution getContribution(EmpRequest empRequest) {
    	System.out.println( ".....ContributionService -> getContribution.....\n" );
        Contribution  contribution = new Contribution();
        KieSession kieSession = kieContainer.newKieSession();
        System.out.println( ".....ContributionService -> kieSession.....\n" );
        
        
        Globals globals = kieSession.getGlobals();
        System.out.println( "....."+ globals.getGlobalKeys() +".....\n" );
        
//        kieSession.setGlobal("contribution", contribution);
        kieSession.getGlobals().set("contribution", contribution);
        
        System.out.println( ".....ContributionService -> empRequest.....\n"+ empRequest );
        kieSession.insert(empRequest);
        System.out.println( ".....ContributionService -> empRequest ->empId.....\n"+ empRequest.getEmpId() );
        System.out.println( ".....ContributionService -> empRequest ->age.....\n"+ empRequest.getAge() );
        System.out.println( ".....ContributionService -> empRequest ->salary.....\n"+ empRequest.getSalary() );
        System.out.println( ".....ContributionService -> empRequest ->empType.....\n"+ empRequest.getEmpType() );
        
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println( ".....ContributionService -> contribution ->getContribution.....\n"+ contribution.getContribution() );
        return contribution;
    }
}
