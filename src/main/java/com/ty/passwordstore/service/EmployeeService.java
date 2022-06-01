package com.ty.passwordstore.service;

import com.ty.passwordstore.dao.EmployeeDao;
import com.ty.passwordstore.dto.Employee;

public class EmployeeService {

	EmployeeDao  employeeDao  = new EmployeeDao ();
	
	public Employee saveEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}
	public Employee validateEmployee(String name,String phone)
	{
		return employeeDao.validateEmployee(name, phone);
	}
}
