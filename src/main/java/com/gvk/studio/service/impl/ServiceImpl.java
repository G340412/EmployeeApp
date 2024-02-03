package com.gvk.studio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvk.studio.entity.Employee;
import com.gvk.studio.entity.exceptions.ResourceNotFoundException;
import com.gvk.studio.repository.EmployeeRepository;
import com.gvk.studio.service.IEmployeeService;

@Service
public class ServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Long saveEmployee(Employee saveEmp) {
		saveEmp=employeeRepository.save(saveEmp);
		return saveEmp.getEmpId();
	}

	@Override
	public String updateEmployee(Long empId,Employee updateEmp) {
		System.out.println("Employee Id :"+empId);
		
		Employee updateEmployeeDetails=updateEmployeeDetails(empId,updateEmp);
			employeeRepository.save(updateEmployeeDetails);
			return "Employee Details Updated sucess :"+updateEmp.getEmpName();
		}
		
	private Employee updateEmployeeDetails(Long empId,Employee updateEmp) {
		System.out.println("Employee Id :"+empId);
		Employee employee=employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + empId));
		System.out.println("Fetching Employee Details :"+updateEmp.getEmpName());
		System.out.println("Fetching Employee Details :"+employee.getEmpName());
		employee.setEmpName(updateEmp.getEmpName());
		employee.setEmail(updateEmp.getEmail());
		employee.setEmpAge(updateEmp.getEmpAge());
		employee.setEmpGender(updateEmp.getEmpGender());
		employee.setEmpSalary(updateEmp.getEmpSalary());
		employee.setEmpAddress(updateEmp.getEmpAddress());
		employee.setEmpDept(updateEmp.getEmpDept());
		return employee;
	}


	@Override
	public String deleteEmployee(Long empId) {
		Optional<Employee> exitsEmp=employeeRepository.findById(empId);
		if(exitsEmp.isPresent()) {
			employeeRepository.deleteById(empId);
			return "Employee Details deleted sucess :"+empId;
		}else {
			return "Employee details not found with this Emp ID :"+empId +" So unable to delete data";
		}
		
	}

	@Override
	public Employee getEmployeeDetails(Long empId) {
		Optional<Employee> employee=employeeRepository.findById(empId);
		if(employee.isPresent()) {
			return employee.get();
			 
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
				return employeeRepository.findAll();
	}

}
