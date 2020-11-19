package com.tcs.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.exception.ResourceFoundException;
import com.tcs.model.Employee;
import com.tcs.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	@PostMapping("/create")
	public ResponseEntity<Long> createEmployee(@RequestBody Employee empInfo) throws ResourceFoundException {
		Long empId = service.createNewEmployee(empInfo);
		if(empId!=null) {
		return new ResponseEntity<Long>(empId,HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	@GetMapping("/getEmp/{empId}")
	public ResponseEntity<Employee> findEmployeeByEmpId(@PathVariable(value = "empId")Long empId) {
		Employee employee = service.getEmployeeByEmpId(empId);
		if(employee!=null) {
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		
	}
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
		
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(Employee empInfo) {
		String msg = service.updateEmployee(empInfo);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	};

}
