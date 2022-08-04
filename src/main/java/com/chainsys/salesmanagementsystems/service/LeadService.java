package com.chainsys.salesmanagementsystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.dto.LeadsAccountsDTO;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.repository.AccountRepository;
import com.chainsys.salesmanagementsystems.repository.LeadRepository;

@Service
public class LeadService {

	@Autowired
	private LeadRepository leadRepository;
	
	
	public void insertLead(Lead lead) {
		leadRepository.save(lead);
	}
	public List<Lead> allLead(){
		return leadRepository.findAll();
	}
	public void updateLead(Lead lead) {
		leadRepository.save(lead);
	}
	public void deleteLead(int id) {
		leadRepository.deleteById(id);
	}
	public Lead getLeadById(int id) {
		return leadRepository.findById(id);
	}
	
}
