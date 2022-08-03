package com.chainsys.salesmanagementsystems.model;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="emp_id")
	private int employeeId;
	@Column(name="emp_name")
	private String employeeName;
	@Column(name="emp_phone")
	private long employeePhone;
	@Column(name="emp_email")
	private String email;
	@Column(name="emp_address")
	private String address;
	@Column(name="Territory_id")
	private int territoryId;
	@Column(name="emp_password")
	private String password;
	@Column(name="emp_password_last_change_date")
	private Date passwordLastChangeDate;
	@Column(name="emp_role")
	private String role;
	@Column(name="emp_profile")
	private File profile;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public long getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(long employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTerritoryId() {
		return territoryId;
	}
	public void setTerritoryId(int territoryId) {
		this.territoryId = territoryId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getPasswordLastChangeDate() {
		return passwordLastChangeDate;
	}
	public void setPasswordLastChangeDate(Date passwordLastChangeDate) {
		this.passwordLastChangeDate = passwordLastChangeDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public File getProfile() {
		return profile;
	}
	public void setProfile(File profile) {
		this.profile = profile;
	}
	
	
	
}