package com.chainsys.salesmanagementsystems.model;

import java.util.Date;

public class LeadDetail {
	private int leadId;
	private int accountId;
	private int employeeId;
	private String accountName;
	private String employeeName;
	private String status;
	private Date leadDate;
	private String stages;
	private float probablity;
	public float getProbablity() {
		return probablity;
	}
	public void setProbablity(float probablity) {
		this.probablity = probablity;
	}
	public int getLeadId() {
		return leadId;
	}
	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getLeadDate() {
		return leadDate;
	}
	public void setLeadDate(Date leadDate) {
		this.leadDate = leadDate;
	}
	public String getStages() {
		return stages;
	}
	public void setStages(String stages) {
		this.stages = stages;
	}
	
}
