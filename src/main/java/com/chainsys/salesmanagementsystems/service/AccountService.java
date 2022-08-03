package com.chainsys.salesmanagementsystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
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
}
