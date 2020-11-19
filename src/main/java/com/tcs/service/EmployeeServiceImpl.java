package com.tcs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entities.EmployeeEntity;
import com.tcs.exception.ResourceFoundException;
import com.tcs.exception.ResourceNotFoundException;
import com.tcs.model.Employee;
import com.tcs.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Long createNewEmployee(Employee empInfo) throws ResourceFoundException {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(empInfo, entity);
		/*
		 * EmployeeEntity employee = repo.findById(entity.getEmpId()).get();
		 * if(employee.getEmpId()!=null) { throw new
		 * ResourceFoundException("Record already exist if you want please update "); }
		 */ 
		EmployeeEntity newEmployee = repo.save(entity);
		return newEmployee.getEmpId();
	}

	@Override
	public Employee getEmployeeByEmpId(Long empId) throws ResourceNotFoundException {
		EmployeeEntity employeeInfo = repo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is not found with given id::" + empId));
		Employee emp = new Employee();
		BeanUtils.copyProperties(employeeInfo, emp);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> allEmployeeDetails = repo.findAll();
		return allEmployeeDetails.stream().map(employee -> {
			Employee emp = new Employee();
			BeanUtils.copyProperties(employee, emp);
			return emp;
		}).collect(Collectors.toList());
	}

	@Override
	public String updateEmployee(Employee empInfo) {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(empInfo, entity);
		repo.save(entity);
		return "DetailsUpdatedSucessfully";
	}

}
