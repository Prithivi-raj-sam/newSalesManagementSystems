package com.chainsys.salesmanagementsystems.dto;

import java.util.List;

import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Territory;

public class EmployeeTerritoryDTO {
	private Territory territory;
	private List<Employee> employeeList;
	
	public Territory getTerritory() {
		return territory;
	}
	public void setTerritory(Territory territory) {
		this.territory = territory;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	

}
