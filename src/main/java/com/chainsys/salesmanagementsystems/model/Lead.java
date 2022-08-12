package com.chainsys.salesmanagementsystems.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="leads")
public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "lead_id_seq")
    @SequenceGenerator(name = "lead_id_seq", sequenceName = "lead_id_seq",  allocationSize = 1)
	@Column(name="lead_id")
	private int leadId;
	
//	@NotEmpty(message = "*Please enter Account Id")
//	@Pattern(regexp = "^([0-9]+){1,10}$", message = "Enter valid Account Id ")
	@Column(name="account_id")
	private int accountId;
	
//	@NotEmpty(message = "*Please enter Status")
//	@Pattern(regexp = "^[A-Za-z]\\w{3,30}$", message = "Enter valid Status")
	@Column(name="status")
	private String status;
	
//	@NotEmpty(message = "*Please enter Seller Id")
//	@Pattern(regexp = "^([0-9]+){1,10}$", message = "Enter valid Seller Id ")
	@Column(name="saller_id")
	private int employeeId;
	
//	@NotEmpty(message = "*Please enter Date")
	@Column(name="lead_date") 
	private Date leadDate;
	
//	@NotEmpty(message = "*Please enter Stages")
//	@Pattern(regexp = "^[A-Za-z]\\w{3,30}$", message = "Enter valid Stages")
	@Column(name="stages")
	private String stages;
	
//	@NotEmpty(message = "*Please enter Probabilty")
//	@Pattern(regexp = "^[0-9]+(.[0-9]*)?$", message = "Enter valid probability")
	@Column(name="propability")
	private float propability;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_id",insertable=false, updatable=false,nullable=false)
	private Account account;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="saller_id",insertable=false, updatable=false,nullable=false)
	private Employee employee;
	
	@OneToOne(mappedBy="lead",fetch=FetchType.LAZY)
	private Sales sales;
	
	public Sales getSales() {
		return sales;
	}
	public void setSales(Sales sales) {
		this.sales = sales;
	}
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
	
//	A sales lead is identified via marketing, referrals, social media, 
//	networking, product trials, or consultations. A lead does not become
//	a prospect until they've been qualified to determine their level of 
//	interest and fit as a potential customer.
//	From generating to converting, you're probably well aware that leads
//	are an important part of marketing and the overall customer life cycle.
	
//	Traditionally Lead Generation has been a responsibility of the Sales team.
//	In the digital era, however, that responsibility is now shared between the Sales
//	and Marketing team.
	
	
	
	
	
	
}
