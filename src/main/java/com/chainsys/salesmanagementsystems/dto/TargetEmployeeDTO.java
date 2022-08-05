package com.chainsys.salesmanagementsystems.dto;

import java.util.List;

import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Target;

public class TargetEmployeeDTO {
	private Employee employee;
	private List<Target>targetList;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Target> getTargetList() {
		return targetList;
	}
	public void setTargetList(List<Target> targetList) {
		this.targetList = targetList;
	}

}
