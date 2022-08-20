package com.chainsys.salesmanagementsystems.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.businesslogic.BusinessLogic;
import com.chainsys.salesmanagementsystems.dto.SalesLeadsDTO;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.model.LeadDetail;
import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.repository.LeadRepository;
import com.chainsys.salesmanagementsystems.repository.SalesRepository;

@Service
public class LeadService {

	@Autowired
	private LeadRepository leadRepository;
	@Autowired
	private SalesRepository salesRepository;
	@Autowired
	private TargetService targetService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AccountService accountService;
	public void insertLead(Lead lead) {
		leadRepository.save(lead);
		List<Target>targetList=targetService.getTargetByDescendingOrder(lead.getEmployeeId());
		Target target= BusinessLogic.updateClosedTarget(targetList, "lead");
		targetService.updateTarget(target);
	}
	public List<LeadDetail> allLead(){
		List<Lead>leadList= leadRepository.findAll();
		return BusinessLogic.getLeadDetails(leadList, accountService, employeeService);
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
	public List<LeadDetail> getLeadsByEmployeeId(int id){
		List<Lead>leadList= leadRepository.findByEmployeeEmployeeId(id);
		return BusinessLogic.getLeadDetails(leadList, accountService, employeeService);
	}
	public SalesLeadsDTO getSalesAndLeads(int id) {
		SalesLeadsDTO dto=new SalesLeadsDTO();
		dto.setLead(getLeadById(id));
		dto.setSales(salesRepository.findByLeadId(id));
		return dto; 
	}
	public List<LeadDetail> getLeadsForSalesInCome(Date startDate, Date endDate){
		List<Lead>leadList= leadRepository.findByLeadDateGreaterThanEqualAndLeadDateLessThanEqual(startDate, endDate);  
		 return BusinessLogic.getLeadDetails(leadList, accountService, employeeService);
	}
	
}
