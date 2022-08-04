package com.chainsys.salesmanagementsystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.dto.AccountsEmployeeDTO;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.repository.AccountRepository;
import com.chainsys.salesmanagementsystems.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
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
	public AccountsEmployeeDTO getAccountsandEmployee(int id) {
		AccountsEmployeeDTO dto=new AccountsEmployeeDTO();
		System.out.println(getEmployeeById(id));
		dto.setEmployee(getEmployeeById(id));
		dto.setAccountList(accountRepository.findByEmployeeEmployeeId(id));
		return dto;
	}
}
