package com.gvk.studio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvk.studio.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
