package com.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.EmployeeInfo;

public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Integer> {

	
	public EmployeeInfo findByuserId(String userId);
	public EmployeeInfo findByuserPassword(String oldpwd);

	public Optional<EmployeeInfo> findByUserEmail(String userEmail);
	
}
