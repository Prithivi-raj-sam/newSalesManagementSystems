package com.chainsys.salesmanagementsystems.dto;

import java.util.List;

import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Lead;

public class LeadsEmployeeDTO {
	private List<Lead> leadlist;
	private Employee employee;
	
	public List<Lead> getLeadlist() {
		return leadlist;
	}
	public void setLeadlist(List<Lead> leadlist) {
		this.leadlist = leadlist;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
