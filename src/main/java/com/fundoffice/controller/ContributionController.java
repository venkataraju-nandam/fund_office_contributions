package com.fundoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fundoffice.model.Contribution;
import com.fundoffice.model.EmpRequest;
import com.fundoffice.service.ContributionService;

@RestController
public class ContributionController {
 
    @Autowired
    private ContributionService contributionService;

    @GetMapping("/hello-contributions")
    public void  helloContributions() {
    	System.out.println("Hello........... TEST");
    }
    

    
    @PostMapping("/get-contribution")
    public ResponseEntity<Contribution> getContribution(@RequestBody EmpRequest empRequest) {
    	System.out.println("Hello........... getContribution");
    	Contribution contribution = contributionService.getContribution(empRequest);
        return new ResponseEntity<>(contribution, HttpStatus.OK);
    }
}
