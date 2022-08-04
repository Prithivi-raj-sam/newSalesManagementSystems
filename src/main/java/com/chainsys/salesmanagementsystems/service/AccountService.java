package com.chainsys.salesmanagementsystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.dto.LeadsAccountsDTO;
import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.repository.AccountRepository;
import com.chainsys.salesmanagementsystems.repository.LeadRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private LeadRepository leadRepository;
	
	public void insertAccount(Account account) {
		 accountRepository.save(account);
	}
	public List<Account> allAccount(){
		return accountRepository.findAll();
	}
	public void updateAccount(Account account) {
		accountRepository.save(account);
	}
	public void deleteAccount(int id) {
		accountRepository.deleteById(id);
	}
	public Account getAccountById(int id) {
		return accountRepository.findById(id);
	}
	public LeadsAccountsDTO getAcountsAndLeads(int id) {
		LeadsAccountsDTO dto=new LeadsAccountsDTO();
		dto.setAccount(accountRepository.findById(id));
		dto.setLeadsList(leadRepository.findByAccountAccountId(id));
		return dto;
	}
}
