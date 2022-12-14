package com.chainsys.salesmanagementsystems.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.salesmanagementsystems.model.Account;

public interface AccountRepository extends CrudRepository<Account,Integer>{
	Account save(Account account);
	List<Account> findAll();
	void deleteById(int id);
	Account findById(int id);
	List<Account> findByEmployeeEmployeeId(int id);
	List<Account> findByTerritoryTerritoryId(int id);
	List<Account> findByCompanyName(String companyName);
	List<Account> findByCustomerJoinDateGreaterThanEqualAndCustomerJoinDateLessThanEqual(Date startDate,Date enddate);
}
