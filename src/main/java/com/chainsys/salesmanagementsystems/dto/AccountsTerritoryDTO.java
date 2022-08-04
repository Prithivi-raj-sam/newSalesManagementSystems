package com.chainsys.salesmanagementsystems.dto;

import java.util.List;

import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.Territory;

public class AccountsTerritoryDTO {
	private Territory territory;
	private List<Account>accountList;
	
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
	
}
