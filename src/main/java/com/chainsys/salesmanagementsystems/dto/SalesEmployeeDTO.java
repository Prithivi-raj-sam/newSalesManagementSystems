package com.chainsys.salesmanagementsystems.dto;

import java.util.List;

import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Sales;

public class SalesEmployeeDTO {
	private Employee employee;
	private List<Sales>salesList;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Sales> getSalesList() {
		return salesList;
	}
	public void setSalesList(List<Sales> salesList) {
		this.salesList = salesList;
	}
	
}
