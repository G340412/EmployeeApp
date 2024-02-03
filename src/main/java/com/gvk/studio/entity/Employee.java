package com.gvk.studio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EMP_ID")
	private Long empId;
	@Column(name="EMP_NAME")
	private String empName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="GENDER ")
	private String empGender;
	@Column(name="EMP_SAL")
	private double empSalary;
	@Column(name="EMP_AGE")
	private int empAge;
	@Column(name="EMP_DEPT")
	private String empDept;
	@Column(name="EMP_ADDR")
	private String empAddress;
	
}
