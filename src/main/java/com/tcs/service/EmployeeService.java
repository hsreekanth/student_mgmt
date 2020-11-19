package com.tcs.service;

import java.util.List;

import com.tcs.exception.ResourceFoundException;
import com.tcs.exception.ResourceNotFoundException;
import com.tcs.model.Employee;

public interface EmployeeService {

	public Long createNewEmployee(Employee empInfo) throws ResourceFoundException;
	public Employee getEmployeeByEmpId(Long empId) throws ResourceNotFoundException;
	public List<Employee> getAllEmployees();
	public String updateEmployee(Employee empInfo);
}
