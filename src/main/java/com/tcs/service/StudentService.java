package com.tcs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.model.StudentInfo;
@Service
public interface StudentService {

	public Long createNewStudent(StudentInfo studentInfo);
	public StudentInfo getStudentInfo(Long studentId);
	public List<StudentInfo> getAllStudents();
}
