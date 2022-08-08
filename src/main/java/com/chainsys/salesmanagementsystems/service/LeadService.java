package com.chainsys.salesmanagementsystems.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.dto.LeadsAccountsDTO;
import com.chainsys.salesmanagementsystems.dto.SalesLeadsDTO;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.repository.AccountRepository;
import com.chainsys.salesmanagementsystems.repository.LeadRepository;
import com.chainsys.salesmanagementsystems.repository.SalesRepository;

@Service
public class LeadService {

	@Autowired
	private LeadRepository leadRepository;
	@Autowired
	private SalesRepository salesRepository;
	
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
	public SalesLeadsDTO getSalesAndLeads(int id) {
		SalesLeadsDTO dto=new SalesLeadsDTO();
		dto.setLead(getLeadById(id));
		dto.setSales(salesRepository.findByLeadId(id));
		System.out.println(getLeadById(id).getLeadId());
		System.out.println(salesRepository.findByLeadId(id).getLeadId());
		return dto; 
	}
	public List<Lead> getLeadsForSalesInCome(Date startDate, Date endDate){
		return leadRepository.findByLeadDateGreaterThanEqualAndLeadDateLessThanEqual(startDate, endDate);   
	}
	
}
