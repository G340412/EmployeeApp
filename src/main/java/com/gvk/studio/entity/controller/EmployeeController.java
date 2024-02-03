package com.gvk.studio.entity.controller;

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

import com.gvk.studio.entity.Employee;
import com.gvk.studio.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		Long empId=employeeService.saveEmployee(employee);
		return new ResponseEntity<String>("Employee Data Saved :"+empId,HttpStatus.OK);
		
	}
	
	@GetMapping("/allEmployee")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> allEmployees = employeeService.getAllEmployees();
		System.out.println("All Employee Data :"+allEmployees);
		return new ResponseEntity<List<Employee>>(allEmployees,HttpStatus.OK);
		
	}
	
	@GetMapping("/getEmployee/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long empId){
		Employee employee = employeeService.getEmployeeDetails(empId);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteEmp/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long empId){
		String msg=employeeService.deleteEmployee(empId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee/{empId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long empId,@RequestBody Employee employee){
		
		String msg =employeeService.updateEmployee(empId,employee);
		 return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
}
