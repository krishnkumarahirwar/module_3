package com.capg.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.capg.entity.Employee;
@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	
	HashMap<Integer,Employee> store=new HashMap<>();
	@Override
	public void insertEmployee(Employee emp1) {
		store.put(emp1.employeeId,emp1);
	}

	@Override
	public void displayEmployeeDetails(int employeeId) {
			Employee emp=store.get(employeeId);
			System.out.println("employee id : "+emp.getEmployeeId()+"\n"+"employee name : "+emp.employeeName+
					"\n"+"employee salary : "+emp.getSalary()+"\n"+"employee business unit : "+emp.getBusinessUnit()+"\n"
					+"emloyee age : "+emp.getAge());
		
	}
	
}
