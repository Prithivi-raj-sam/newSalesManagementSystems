package com.chainsys.salesmanagementsystems.dto;

import java.util.List;
import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.Lead;

public class LeadsAccountsDTO {
	private Account account;
	private List<Lead> leadsList;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Lead> getLeadsList() {
		return leadsList;
	}
	public void setLeadsList(List<Lead> leadsList) {
		this.leadsList = leadsList;
	}

}
