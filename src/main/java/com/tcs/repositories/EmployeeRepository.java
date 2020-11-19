package com.tcs.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Serializable> {


}
