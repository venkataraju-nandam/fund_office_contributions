package com.fundoffice.model;

public enum EmployeeType {
    DRIVER, FIREMAN,  DISABILITY ;
 
    public String getValue() {
        return this.toString();
    }
}
