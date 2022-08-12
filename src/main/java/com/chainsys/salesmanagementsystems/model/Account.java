package com.chainsys.salesmanagementsystems.model;

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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "account_id")
    @SequenceGenerator(name = "account_id", sequenceName = "account_id",  allocationSize = 1)
	@Column(name="account_id")
	private int accountId;  
	
//	@Size(max = 40, min = 3, message = "Name length should be 3 to 40")
//	@NotBlank(message = "Company Name can't be Empty")
//	@Pattern(regexp = "^[A-Za-z]\\w{3,40}$", message = "Enter valid Company name ")
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="contact_person")
//	@NotBlank(message = "Contact Person Name can't be Empty")
//	@Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+)?{3,30}$", message = "Enter valid Contact Person ")
	private String contactPerson;
	
//	@NotBlank(message = "Contact Role can't be Empty")
//	@Pattern(regexp = "^[A-Za-z]\\w{3,30}$", message = "Enter valid Contact Person Role ")
	@Column(name="contact_person_role")
	private String contactPersonRole;
	
	@Column(name="email")
//	@Email(message = "Email is not valid")
//	@NotEmpty(message = "Please enter email")
	private String email;
	
//	@NotEmpty(message = "Please enter Phone Numder")
//	@Digits(message = "Invalid number", integer = 10, fraction = 0)
	@Column(name="contact_person_phone")
	private long contactPersonPhone;
	
	@Column(name="address")
//	@NotEmpty(message = "*Please enter Address")
	private String address;
	
//	@NotEmpty(message = "*Please enter Account type")
//	@Pattern(regexp = "^[A-Za-z]\\w{3,30}$", message = "Enter valid Company name ")
	@Column(name="account_type")
	private String accountType;
	
//	@NotEmpty(message = "*Please enter Marketer Id")
//	@Pattern(regexp = "^([0-9]+){1,10}$", message = "Enter valid Employee Id ")
	@Column(name="marketer_id")
	private int employeeId;
	
//	@NotEmpty(message = "*Please enter Lead Through Channel")
//	@Pattern(regexp = "^[A-Za-z]\\w{3,30}$", message = "Enter valid Channel Name ")
	@Column(name="lead_through_channel")
	private String leadThroughChannel;
	
//	@NotEmpty(message = "*Please enter Cutomer Join date")
	@Column(name="customer_join_date")
	private Date customerJoinDate;
	
//	@NotEmpty(message = "*Please enter Territory Id")
//	@Pattern(regexp = "^([0-9]+){1,10}$", message = "Enter valid Territory Id ")
	@Column(name="territory_id")
	private int territoryId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="marketer_id", insertable=false,updatable=false,nullable=false)
	private Employee employee;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="territory_id",insertable=false,updatable=false,nullable=false)
	private Territory territory;
	
	@OneToMany(mappedBy="account",fetch=FetchType.LAZY)
	private List<Lead> leadsList;
	
	public Territory getTerritory() {
		return territory;
	}
	public void setTerritory(Territory territory) {
		this.territory = territory;
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
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactPersonRole() {
		return contactPersonRole;
	}
	public void setContactPersonRole(String contactPersonRole) {
		this.contactPersonRole = contactPersonRole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactPersonPhone() {
		return contactPersonPhone;
	}
	public void setContactPersonPhone(long contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getLeadThroughChannel() {
		return leadThroughChannel;
	}
	public void setLeadThroughChannel(String leadThroughChannel) {
		this.leadThroughChannel = leadThroughChannel;
	}
	public Date getCustomerJoinDate() {
		return customerJoinDate;
	}
	public void setCustomerJoinDate(Date customerJoinDate) {
		this.customerJoinDate = customerJoinDate;
	}
	public int getTerritoryId() {
		return territoryId;
	}
	public void setTerritoryId(int territoryId) {
		this.territoryId = territoryId;
	}
	
	
	
	
	 
	
	
	 
	
	
	
	
	
}
