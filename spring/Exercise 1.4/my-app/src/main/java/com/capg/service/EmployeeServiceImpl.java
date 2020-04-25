package com.capg.service;

import org.springframework.stereotype.Service;

import com.capg.dao.EmployeeDaoImpl;
import com.capg.dao.IEmployeeDao;
import com.capg.entity.Employee;
@Service
public class EmployeeServiceImpl implements  IEmployeeService{
	
	IEmployeeDao service=new EmployeeDaoImpl();
	
	@Override
	public void insertEmployee(Employee emp) {
		service.insertEmployee(emp);
		
	}

	@Override
	public void displayEmployeeDetails(int employeeId) {
			service.displayEmployeeDetails(employeeId);
		
	}

	

	

}
