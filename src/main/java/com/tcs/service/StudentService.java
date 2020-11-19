package com.tcs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.exception.ResourceNotFoundException;
import com.tcs.model.StudentInfo;
@Service
public interface StudentService {

	public Long createNewStudent(StudentInfo studentInfo);
	public StudentInfo getStudentInfo(Long studentId) throws ResourceNotFoundException;
	public List<StudentInfo> getAllStudents();
}
