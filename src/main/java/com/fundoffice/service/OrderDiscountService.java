package com.fundoffice.service;

import org.drools.template.model.Global;
import org.kie.api.runtime.Globals;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundoffice.model.OrderDiscount;
import com.fundoffice.model.OrderRequest;

@Service
public class OrderDiscountService {
 
    @Autowired
    private KieContainer kieContainer;
 
    public OrderDiscount getDiscount(OrderRequest orderRequest) {
    	System.out.println( ".....OrderDiscountService -> getDiscount.....\n" );
        OrderDiscount  orderDiscount = new OrderDiscount();
        KieSession kieSession = kieContainer.newKieSession();
        System.out.println( ".....OrderDiscountService -> kieSession.....\n" );
        
        
        Globals globals = kieSession.getGlobals();
        System.out.println( "....."+ globals.getGlobalKeys() +".....\n" );
        
//        kieSession.setGlobal("orderDiscount", orderDiscount);
        kieSession.getGlobals().set("orderDiscount", orderDiscount);
        
        System.out.println( ".....OrderDiscountService -> orderRequest.....\n"+ orderRequest );
        kieSession.insert(orderRequest);
        System.out.println( ".....OrderDiscountService -> orderRequest ->getCustomerNumber.....\n"+ orderRequest.getCustomerNumber() );
        System.out.println( ".....OrderDiscountService -> orderRequest ->getAge.....\n"+ orderRequest.getAge() );
        System.out.println( ".....OrderDiscountService -> orderRequest ->getAmount.....\n"+ orderRequest.getAmount() );
        System.out.println( ".....OrderDiscountService -> orderRequest ->getCustomerType.....\n"+ orderRequest.getCustomerType() );
        
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println( ".....OrderDiscountService -> orderDiscount ->getDiscount.....\n"+ orderDiscount.getDiscount() );
        return orderDiscount;
    }
}
