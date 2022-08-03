package com.chainsys.salesmanagementsystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.model.Territory;
import com.chainsys.salesmanagementsystems.repository.TerritoryRepository;

@Service
public class TerritoryService {
	@Autowired
	private TerritoryRepository territoryRepository;
	
	public void insertTerritory(Territory territory) {
		territoryRepository.save(territory);
	}
	public List<Territory> allTerritory(){
		return territoryRepository.findAll();
	}
	public void updateTerritory(Territory territory) {
		territoryRepository.save(territory);
	}
	public void deleteTerritory(int id) {
		territoryRepository.deleteById(id);
	}
	public Territory getTerritoryById(int id) {
		return territoryRepository.findById(id);
	}

}
