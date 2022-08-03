package com.chainsys.salesmanagementsystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void insertEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	public List<Employee> allEmployee(){
		return employeeRepository.findAll();
	}
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
}
