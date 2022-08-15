package com.chainsys.salesmanagementsystems.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.salesmanagementsystems.model.Territory;

public interface TerritoryRepository extends CrudRepository<Territory,Integer>{
	Territory save(Territory territory);
	void deleteById(int id);
	Territory findById(int id);
	List<Territory> findAll();
	Territory findByTerritoryName(String territoryName);
	List<Territory> findByTerritoryNameStartingWith(String name);
}
