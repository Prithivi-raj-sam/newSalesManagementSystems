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
@Table(name="sales")
public class Sales {
	@Id
	@Column(name="sale_id")
	private int salesId;
	@Column(name="seller_id")
	private int sellerId;
	
	@Column(name="lead_id")
	private int leadId; 
	@Column(name="sales_date")
	private Date salesDate;
	@Column(name="amount")
	private float amount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="seller_id",insertable=false,updatable=false,nullable=false)
	private Employee employee;
	
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
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
