package com.chainsys.salesmanagementsystems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "territories")
public class Territory {
	@Id
	@Column(name = "territory_id")
	private int territoryId;
	@Column(name = "territory_name")
	private String territoryName;
	@Column(name = "no_of_customers")
	private int noOfCustomer;

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
