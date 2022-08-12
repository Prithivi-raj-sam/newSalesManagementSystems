package com.chainsys.salesmanagementsystems.model;

import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_id_seq")
    @SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_id_seq",  allocationSize = 1)
	@Column(name="emp_id")
	private int employeeId;
	
//	@Size(max = 40, min = 3, message = "Name length should be 3 to 40")
//	@NotNull(message = "Employee Name can't be Empty")

	@Column(name="emp_name")
//	@NotEmpty(message = "*Please enter employeeName")
//    @Pattern(regexp = "^[a-zA-Z]*$", message = "*Value should be in Alphabets ")
	private String employeeName;
	
	

	@Column(name="emp_phone")
//	@Digits(message = "*Invalid number.", integer = 10, fraction = 0)
	private long employeePhone;
	
	
	@Column(name="emp_email")
//	@Email(message = "*Invalid Email", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String email;
	
	
	@Column(name="emp_address")
//	@NotEmpty(message = "*Please enter employeeName")
//    @Pattern(regexp = "^[a-zA-Z]*$", message = "*Value should be in Alphabets ")
	private String address;
	
	
////	@Pattern(regexp = "^([0-9]+){1,10}$", message = "Enter valid Territory Id ")
	@Column(name="Territory_id")
//	@NotNull(message = "*Please enter Territory Id")
	private int territoryId;
	
	
	@Column(name="emp_password")
//	@Pattern(regexp="^.(?=.{8,})(?=..[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=]).$",message="please enter the correct format *Welcomee@13")
    private String password;
	
	@Column(name="emp_password_last_change_date")
//	@NotNull(message = "*Please enter Password Last Change date")
     private Date passwordLastChangeDate;// add 
	
	
	@Column(name="emp_role")
//	@NotNull(message = "*Please enter Employee Role")
//	@Pattern(regexp = "^[A-Za-z]\\w{3,30}$", message = "Enter valid role ")
	private String role;
	
	@Column(name="emp_profile")
	private File profile;
	
	@OneToMany(mappedBy="employee",fetch=FetchType.LAZY)
	private List<Account> accountList;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Territory_id", insertable=false,updatable=false,nullable=false)
	private Territory territory;
	
	@OneToMany(mappedBy="employee",fetch=FetchType.LAZY)
	private List<Lead> leadlist;
	
	@OneToMany(mappedBy="employee",fetch=FetchType.LAZY)
	private List<Sales>salesList;
	
	@OneToMany(mappedBy="employee",fetch=FetchType.LAZY)
	private List<Target>targetList;
	
	public List<Target> getTargetList() {
		return targetList;
	}
	public void setTargetList(List<Target> targetList) {
		this.targetList = targetList;
	}
	public List<Sales> getSalesList() {
		return salesList;
	}
	public void setSalesList(List<Sales> salesList) {
		this.salesList = salesList;
	}
	public List<Lead> getLeadlist() {
		return leadlist;
	}
	public void setLeadlist(List<Lead> leadlist) {
		this.leadlist = leadlist;
	}
	public Territory getTerritory() {
		return territory;
	}
	public void setTerritory(Territory territory) {
		this.territory = territory;
	}
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
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
