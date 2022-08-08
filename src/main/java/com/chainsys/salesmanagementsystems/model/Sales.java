package com.chainsys.salesmanagementsystems.model;

import java.util.Date;

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
@Table(name="sales")
public class Sales {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sales_id_seq")
    @SequenceGenerator(name = "sales_id_seq", sequenceName = "sales_id_seq",  allocationSize = 1)
	@Column(name="sale_id")
	private int salesId;
	
	@NotEmpty(message = "*Please enter Seller Id")
	@Pattern(regexp = "^([0-9]+){1,10}$", message = "Enter valid Seller Id ")
	@Column(name="seller_id")
	private int employeeId;
	
	@NotEmpty(message = "*Please enter Lead Id")
	@Pattern(regexp = "^([0-9]+){1,10}$", message = "Enter valid Lead Id ")
	@Column(name="lead_id")
	private int leadId;
	
	@NotEmpty(message = "*Please enter Lead Id")
	@Column(name="sales_date")
	private Date salesDate;
	
	@NotEmpty(message = "*Please enter Amount")
	@Pattern(regexp = "^[0-9]+(.[0-9]*)?$", message = "Enter valid Amount")
	@Column(name="amount")
	private float amount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="seller_id",insertable=false,updatable=false,nullable=false)
	private Employee employee;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lead_id",insertable=false,updatable=false,nullable=false)
	private Lead lead;
	
	public Lead getLead() {
		return lead;
	}
	public void setLead(Lead lead) {
		this.lead = lead;
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
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	
	public int getLeadId() {
		return leadId;
	}
	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	
	
	
	
	
}
