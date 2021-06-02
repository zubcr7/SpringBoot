package com.example.services;

import java.util.List;

import com.example.beans.Employee;
import com.example.exception.EmployeeException;


public interface IEmployeeService {
	public List<Employee> displayEmployee();

	 

    public Employee addEmployee(Employee employee);

 

    public Employee searchEmployeeById(int id) throws EmployeeException;

 

    public Employee updateEmployee(Employee employee);

 

    public void deleteEmployeeById(int id) throws EmployeeException;

 

}

