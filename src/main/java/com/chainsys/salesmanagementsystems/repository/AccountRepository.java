package com.chainsys.salesmanagementsystems.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.salesmanagementsystems.model.Account;

public interface AccountRepository extends CrudRepository<Account,Integer>{
	Account save(Account account);
	List<Account> findAll();
	void deleteById(int id);
	Account findById(int id);
}
