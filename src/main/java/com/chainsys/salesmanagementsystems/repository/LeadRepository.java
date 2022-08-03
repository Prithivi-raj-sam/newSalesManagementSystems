package com.chainsys.salesmanagementsystems.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.salesmanagementsystems.model.Lead;

public interface LeadRepository extends CrudRepository<Lead,Integer>{
	Lead save(Lead lead);
	List<Lead> findAll();
	Lead findById(int id);
	void deleteById(int id);
}