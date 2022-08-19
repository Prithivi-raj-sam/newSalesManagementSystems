package com.chainsys.salesmanagementsystems.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "territories")
public class Territory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "territory_id_seq")
    @SequenceGenerator(name = "territory_id_seq", sequenceName = "territory_id_seq",  allocationSize = 1)
	@Column(name = "territory_id")
	private int territoryId;
	
	@Column(name = "territory_name")
	private String territoryName;
	
	@Column(name = "no_of_customers")
	private int noOfCustomer;

	@OneToMany(mappedBy="territory", fetch=FetchType.LAZY)
	private List<Account>accountList;
	
	@OneToMany(mappedBy="territory" ,fetch=FetchType.LAZY)
	private List<Employee> employeeList;
	
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public int getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(int territoryId) {
		this.territoryId = territoryId;
	}

	public String getTerritoryName() {
		return territoryName;
	}

	public void setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
	}

	public int getNoOfCustomer() {
		return noOfCustomer;
	}

	public void setNoOfCustomer(int noOfCustomer) {
		this.noOfCustomer = noOfCustomer;
	}

}
