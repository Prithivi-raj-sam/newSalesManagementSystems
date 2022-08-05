package com.chainsys.salesmanagementsystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.dto.AccountsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.LeadsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.SalesEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.TargetEmployeeDTO;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.repository.AccountRepository;
import com.chainsys.salesmanagementsystems.repository.EmployeeRepository;
import com.chainsys.salesmanagementsystems.repository.LeadRepository;
import com.chainsys.salesmanagementsystems.repository.SalesRepository;
import com.chainsys.salesmanagementsystems.repository.TargetRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private LeadRepository leadRepository;
	@Autowired
	private SalesRepository salesRepository;
	@Autowired
	private TargetRepository targetRepository;
	
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
		dto.setEmployee(getEmployeeById(id));
		dto.setAccountList(accountRepository.findByEmployeeEmployeeId(id));
		return dto;
	}
	public LeadsEmployeeDTO getLeadsAndEmployee(int id) {
		LeadsEmployeeDTO dto=new LeadsEmployeeDTO();
		dto.setEmployee(getEmployeeById(id));
		dto.setLeadlist(leadRepository.findByEmployeeEmployeeId(id));
		return dto;
	}
	public SalesEmployeeDTO getSalesEmployee(int id) {
		SalesEmployeeDTO dto=new SalesEmployeeDTO();
		dto.setEmployee(getEmployeeById(id));
		dto.setSalesList(salesRepository.findByEmployeeEmployeeId(id));
		return dto;
	}
	public TargetEmployeeDTO getTargetsAndEmployee(int id) {
		TargetEmployeeDTO dto=new TargetEmployeeDTO();
		dto.setEmployee(getEmployeeById(id));
		dto.setTargetList(targetRepository.findByEmployeeId(id));
		return dto;
	}
}
