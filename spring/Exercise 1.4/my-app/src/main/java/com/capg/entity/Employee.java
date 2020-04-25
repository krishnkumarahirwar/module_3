package com.capg.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Employee 
{
	@Value("${id}")
   public int employeeId;
	
	@Value("${name}")
   public String employeeName;
	
	@Value("${salary}")
   public double salary;
	
	@Value("${bu}")
   public String businessUnit;
	
	@Value("${age}")
   public int age;
   public Employee() {
	   
   }
   
   
public Employee(int employeeId, String employeeName, double salary, String businessUnit, int age) {
	this.employeeId = employeeId;
	this.employeeName = employeeName;
	this.salary = salary;
	this.businessUnit = businessUnit;
	this.age = age;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getBusinessUnit() {
	return businessUnit;
}
public void setBusinessUnit(String businessUnit) {
	this.businessUnit = businessUnit;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
   
}
