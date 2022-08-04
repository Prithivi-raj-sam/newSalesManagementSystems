package com.chainsys.salesmanagementsystems.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.salesmanagementsystems.model.Sales;

public interface SalesRepository extends CrudRepository<Sales,Integer>{
	Sales save(Sales sales);
	List<Sales> findAll();
	Sales findById(int id);
	void deleteById(int id);
	List<Sales> findBySellerId(int id);
}
