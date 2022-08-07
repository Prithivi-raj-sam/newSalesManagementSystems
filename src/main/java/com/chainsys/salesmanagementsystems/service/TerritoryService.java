package com.chainsys.salesmanagementsystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.dto.AccountsTerritoryDTO;
import com.chainsys.salesmanagementsystems.dto.EmployeeTerritoryDTO;
import com.chainsys.salesmanagementsystems.repository.AccountRepository;
import com.chainsys.salesmanagementsystems.repository.EmployeeRepository;
import com.chainsys.salesmanagementsystems.model.Territory;
import com.chainsys.salesmanagementsystems.repository.TerritoryRepository;

@Service
public class TerritoryService {
	@Autowired
	private TerritoryRepository territoryRepository;
	@Autowired
	private AccountRepository accountsRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
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
	public Territory getTerritoryByName(String territoryName) {
		return territoryRepository.findByTerritoryName(territoryName);
	}
	public AccountsTerritoryDTO getAccountandTerritory(int id) {
		AccountsTerritoryDTO dto=new AccountsTerritoryDTO();
		dto.setTerritory(getTerritoryById(id));
		dto.setAccountList(accountsRepository.findByEmployeeEmployeeId(id));
		return dto;
	}
	public EmployeeTerritoryDTO getTErritoryAndEmployee(int id) {
		EmployeeTerritoryDTO dto=new EmployeeTerritoryDTO();
		dto.setTerritory(getTerritoryById(id));
		dto.setEmployeeList(employeeRepository.findByTerritoryTerritoryId(id));
		return dto; 
	}
}
