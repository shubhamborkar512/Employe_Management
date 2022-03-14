package com.smart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.exceptions.UserNotFoundException;
import com.smart.model.Employee;
import com.smart.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class HomeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmp(){
		List<Employee>employees= employeeService.getAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee>  getEmp(@PathVariable("id") Long Id) throws UserNotFoundException{
		Employee employee=employeeService.findEmpById(Id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee emp){
		Employee employee=employeeService.addEmployee(emp);
		return new ResponseEntity<>(employee,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp){
		Employee employee=employeeService.addEmployee(emp);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable("id") Long Id) throws UserNotFoundException{
		employeeService.deleteEmployee(Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
