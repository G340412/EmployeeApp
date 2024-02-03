package com.gvk.studio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gvk.studio.entity.Employee;


public interface IEmployeeService {

	public Long saveEmployee(Employee saveEmp);
	public String updateEmployee(Long empId,Employee updateEmp);
	public String deleteEmployee(Long empId);
	public Employee getEmployeeDetails(Long empId);
	public List<Employee> getAllEmployees(); 
}
