package com.chainsys.salesmanagementsystems.dto;

import java.util.List;

import com.chainsys.salesmanagementsystems.model.Sales;

public class SalesDTO {
	private List<Sales> salesList;
	public List<Sales> getSalesList() {
		return salesList;
	}
	public void setSalesList(List<Sales> salesList) {
		this.salesList = salesList;
	}
	public List<String> getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(List<String> employeeName) {
		this.employeeName = employeeName;
	}
	public List<String> getAccountName() {
		return accountName;
	}
	public void setAccountName(List<String> accountName) {
		this.accountName = accountName;
	}
	private List<String>employeeName;
	private List<String> accountName;
}
