package com.chainsys.salesmanagementsystems.dto;

import java.util.List;

import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.Employee;

public class AccountsEmployeeDTO {
	private List<Account> accountList;
	private Employee employee;
	
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
