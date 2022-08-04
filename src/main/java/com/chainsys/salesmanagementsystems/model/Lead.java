package com.chainsys.salesmanagementsystems.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="leads")
public class Lead {
	@Id
	@Column(name="lead_id")
	private int leadId;
	@Column(name="account_id")
	private int accountId;
	@Column(name="status")
	private String status;
	@Column(name="saller_id")
	private int employeeId;
	
	@Column(name="lead_date")
	private Date leadDate;
	@Column(name="stages")
	private String stages;
	@Column(name="propability")
	private float propability;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_id",insertable=false, updatable=false,nullable=false)
	private Account account;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="saller_id",insertable=false, updatable=false,nullable=false)
	private Employee employee;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	public float getPropability() {
		return propability;
	}
	public void setPropability(float propability) {
		this.propability = propability;
	}
	
	
	
	 
	
	
	
	
	
	
}
