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
import org.springframework.web.bind.annotation.RestController;

import com.tcs.model.StudentInfo;
import com.tcs.service.StudentService;

@RestController
public class StudentResource {
	@Autowired
	private StudentService service;

	@PostMapping("/create")
	public ResponseEntity<Long> saveStudent(@RequestBody StudentInfo info) {
		ResponseEntity<Long> responseEntity = null;

		Long studentId = service.createNewStudent(info);
		if (studentId != null) {
			return responseEntity = new ResponseEntity<Long>(studentId, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/student/{id}")
	public ResponseEntity<StudentInfo> getStudent(@PathVariable(value = "id") Long id) {
		ResponseEntity<StudentInfo> responseEntity = null;
		StudentInfo studentInfo = service.getStudentInfo(id);
		if (studentInfo.getId() != null) {
			return responseEntity = new ResponseEntity<StudentInfo>(studentInfo, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/students")
	public ResponseEntity<List<StudentInfo>> getAllStudent() {
		ResponseEntity<List<StudentInfo>> responseEntity = null;
		List<StudentInfo> studentInfo = service.getAllStudents();
		if (studentInfo!= null) {
			return responseEntity = new ResponseEntity<List<StudentInfo>>(studentInfo, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@PutMapping("/update")
	public ResponseEntity<Long> updateStudent(@RequestBody StudentInfo info) {
		ResponseEntity<Long> responseEntity = null;

		Long studentId = service.createNewStudent(info);
		if (studentId != null) {
			return responseEntity = new ResponseEntity<Long>(studentId, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	
}
