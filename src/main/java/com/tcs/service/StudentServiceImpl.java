package com.tcs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entities.StudentEntity;
import com.tcs.model.StudentInfo;
import com.tcs.repositories.StudentInfoRepository;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentInfoRepository studRepo;
	

	@Override
	public Long createNewStudent(StudentInfo studentInfo) {
		StudentEntity entity=new StudentEntity();
		BeanUtils.copyProperties(studentInfo, entity);
		StudentEntity newStudent = studRepo.save(entity);
		return newStudent.getId();
	}

	@Override
	public StudentInfo getStudentInfo(Long studentId) {
		StudentEntity studInfo= studRepo.findById(studentId).get();
		StudentInfo info=new StudentInfo();
		BeanUtils.copyProperties(studInfo, info);
		return info;
	}

	@Override
	public List<StudentInfo> getAllStudents() {
		List<StudentEntity> listOfStudents = studRepo.findAll();
		return listOfStudents.stream().map(student->{
			StudentInfo students=new StudentInfo();
			BeanUtils.copyProperties(student, students);
			
			return students;
		}).collect(Collectors.toList());
	}
}
