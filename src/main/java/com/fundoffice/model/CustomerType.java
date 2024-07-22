package com.fundoffice.model;

public enum CustomerType {
    LOYAL, NEW, DISSATISFIED, DRIVER, FIREMAN ;
 
    public String getValue() {
        return this.toString();
    }
}
