package com.tcs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE_TBL")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long empId;
	private String firstName;
	private String lastName;
	private String email;
	private Date dateOfBirth;
	private String gender;
	private String Desg; // values are principal/professor/non-teaching staff
	private Long contactNumber;
}
