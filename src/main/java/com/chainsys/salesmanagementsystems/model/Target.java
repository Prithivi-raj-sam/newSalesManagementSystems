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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "targets")
public class Target {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "target_id_seq")
    @SequenceGenerator(name = "target_id_seq", sequenceName = "target_id_seq",  allocationSize = 1)
	@Column(name = "target_id")
	private int targetId;
	@Column(name = "target_date")
	private Date targetDate;
	@Column(name = "planned_target")
	private int plannedTarget;
	@Column(name = "closed_target")
	private int closedTarget;
	@Column(name = "employee_id")
	private int employeeId;
	@Column(name = "manager_comment")
	private String managerComment;
	@Column(name = "target_set_Date")
	private Date targetSetDate;
	
	public Date getTargetSetDate() {
		return targetSetDate;
	}
	public void setTargetSetDate(Date targetSetDate) {
		this.targetSetDate = targetSetDate;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id",insertable=false,updatable=false,nullable=false)
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getTargetId() {
		return targetId;
	}
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public int getPlannedTarget() {
		return plannedTarget;
	}
	public void setPlannedTarget(int plannedTarget) {
		this.plannedTarget = plannedTarget;
	}
	public int getClosedTarget() {
		return closedTarget;
	}
	public void setClosedTarget(int closedTarget) {
		this.closedTarget = closedTarget;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getManagerComment() {
		return managerComment;
	}
	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}
	
	

}
