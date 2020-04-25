package com.capg.ui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capg.config.JavaConfig;
import com.capg.entity.Employee;
import com.capg.entity.SBU;
import com.capg.service.EmployeeServiceImpl;
import com.capg.service.IEmployeeService;

public class projectMain {
	
	public static void main(String args[]) {
		
		 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		 
		 Class configurationClass=JavaConfig.class;
	        context.register(configurationClass);
	        context.refresh();
	        Employee emp=new Employee(1,"krishna",7678,"mgnt",24);
	        SBU sbu=new SBU( 101,"ghj","gjhgh");
	        SBU sb=context.getBean(SBU.class);
	        sb.display(emp, sbu);
	        
	}

}
