package com.chainsys.salesmanagementsystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.dto.LeadsAccountsDTO;
import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.model.Territory;
import com.chainsys.salesmanagementsystems.repository.AccountRepository;
import com.chainsys.salesmanagementsystems.repository.LeadRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private LeadRepository leadRepository;
	@Autowired
	private TerritoryService territoryService;
	@Autowired
	private TargetService targetService;
	
	public void insertAccount(Account account) {
		 Territory ter=null;
		 ter=territoryService.getTerritoryById(account.getTerritoryId());
		 ter.setNoOfCustomer(ter.getNoOfCustomer()+1);
		 territoryService.updateTerritory(ter);
		 accountRepository.save(account);
		 List<Target>targetList=targetService.getTargetByDescendingOrder(account.getEmployeeId());
		 targetList.get(0).setClosedTarget((targetList.get(0).getClosedTarget())+1);
		 targetService.updateTarget(targetList.get(0));
	}
	public List<Account> allAccount(){
		return accountRepository.findAll();
	}
	public void updateAccount(Account account) {
		accountRepository.save(account);
	}
	public List<Account> getAccountByComapnyName(String companyName){
		return accountRepository.findByCompanyName(companyName);
	}
	public void deleteAccount(int id) {
		accountRepository.deleteById(id);
		 Territory ter=null;
		 ter=territoryService.getTerritoryById(getAccountById(id).getTerritoryId());
		 ter.setNoOfCustomer(ter.getNoOfCustomer()-1);
	}
	public Account getAccountById(int id) {
		return accountRepository.findById(id);
	}
	public List<Account> getAccountByEmployeeId(int id){
		return accountRepository.findByEmployeeEmployeeId(id);
	}
	public LeadsAccountsDTO getAcountsAndLeads(int id) {
		LeadsAccountsDTO dto=new LeadsAccountsDTO();
		dto.setAccount(accountRepository.findById(id));
		dto.setLeadsList(leadRepository.findByAccountAccountId(id));
		return dto;
	}
}
