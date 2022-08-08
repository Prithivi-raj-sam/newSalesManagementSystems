package com.chainsys.salesmanagementsystems.model;

import java.sql.Date;

public class SalesInCome {
	private Date fromDate;
	private Date toDate;
	private int plannedLeads;
	private int commitedLeads;
	private int plannedSales;
	private int closedSales;
	private double totalSalesAmount;
	
	
	public int getPlannedLeads() {
		return plannedLeads;
	}
	public void setPlannedLeads(int plannedLeads) {
		this.plannedLeads = plannedLeads;
	}
	public int getCommitedLeads() {
		return commitedLeads;
	}
	public void setCommitedLeads(int commitedLeads) {
		this.commitedLeads = commitedLeads;
	}
	public int getPlannedSales() {
		return plannedSales;
	}
	public void setPlannedSales(int plannedSales) {
		this.plannedSales = plannedSales;
	}
	public int getClosedSales() {
		return closedSales;
	}
	public void setClosedSales(int closedSales) {
		this.closedSales = closedSales;
	}
	public double getTotalSalesAmount() {
		return totalSalesAmount;
	}
	public void setTotalSalesAmount(double totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
