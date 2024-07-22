package com.fundoffice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpRequest {
 
     String empId;
     Integer age;
 	 EmployeeType empType;
     Integer salary;
     Employer employer;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public EmployeeType getEmpType() {
		return empType;
	}
	public void setEmpType(EmployeeType empType) {
		this.empType = empType;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
}
