package com.tcs.model;

import java.util.Date;

import lombok.Data;
@Data
public class StudentInfo {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Date dateOfBirth;
	private String gender;
	private String fatherName;
	private String motherName;
	private Long contactNumber;
}
