package com.capg.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.service.IEmployeeService;
@Component
public class SBU {
	
	public int sbuId;
	public String sbuName;
	public String sbuHead;
	
	IEmployeeService iemployeeService;
	
	public IEmployeeService getIemployeeService() {
		return iemployeeService;
	}
	@Autowired
	public void setIemployeeService(IEmployeeService iemployeeService) {
		this.iemployeeService = iemployeeService;
	}

	public SBU() {
		
	}
	
	public SBU(int sbuId, String sbuName, String sbuHead) {
		this.sbuId = sbuId;
		this.sbuName = sbuName;
		this.sbuHead = sbuHead;
	}
	public int getSbuId() {
		return sbuId;
	}
	public void setSbuId(int sbuId) {
		this.sbuId = sbuId;
	}
	public String getSbuName() {
		return sbuName;
	}
	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}
	public String getSbuHead() {
		return sbuHead;
	}
	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}
	
	public void display(Employee emp,SBU sbu) {
		iemployeeService.insertEmployee(emp);
		iemployeeService.displayEmployeeDetails(emp.getEmployeeId());
		System.out.println("sbu details");
		System.out.println("sbu id : "+sbu.getSbuId()+"\n"+"sbu name : "+sbu.getSbuName()+"\n"+
		"sbu head : "+sbu.getSbuHead());
	}
	
	

}
