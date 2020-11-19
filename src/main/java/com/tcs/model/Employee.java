package com.tcs.model;

import java.util.Date;

import lombok.Data;

@Data
public class Employee {

	private Long empId;
	private String firstName;
	private String lastName;
	private String email;
	private Date dateOfBirth;
	private String gender;
	private String desg; // values are principal/professor/non-teaching staff
	private Long contactNumber;
}
