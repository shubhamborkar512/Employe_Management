package com.smart.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.exceptions.UserNotFoundException;
import com.smart.model.Employee;
import com.smart.repository.EmpRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmpRepository empRepository;

	public Employee addEmployee(Employee emp) {
		emp.setEmployeeCode(UUID.randomUUID().toString());
		return empRepository.save(emp);
	}
	
	public List<Employee>  getAllEmployees(){
		return empRepository.findAll();
	}
	
	public Employee updateEmployee(Employee emp) {
		return empRepository.save(emp);
	}
	
	public void deleteEmployee(Long id) {
		empRepository.deleteById(id);
	}
	
	public Employee findEmpById(Long id) throws UserNotFoundException {
		return empRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user by id"+id+" not found"));
	}
}
