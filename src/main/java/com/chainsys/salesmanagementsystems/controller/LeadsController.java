package com.chainsys.salesmanagementsystems.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.salesmanagementsystems.businesslogic.BusinessLogic;
import com.chainsys.salesmanagementsystems.dto.SalesLeadsDTO;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.service.EmployeeService;
import com.chainsys.salesmanagementsystems.service.LeadService;
import com.chainsys.salesmanagementsystems.service.SalesService;

@Controller
@RequestMapping("/leads")
public class LeadsController {
	private static final String ALLLEADS="all-leads";
	private static final String EMPID="empId";
	private static final String ACCOUNTNAME="accountName";
	private static final String EMPLOYEENAME="employeeName";
	private static final String ALLLEADSMODEL="allLeads";
	@Autowired
	private LeadService leadservice;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private SalesService salesService;
	
	@GetMapping("/getlead")//need
	public String getleadsById(@RequestParam("id")int id,@RequestParam("empId")int empId,Model model) {
		Lead leads=leadservice.getLeadById(id);
		Employee employee=employeeService.getEmployeeById(empId);
		model.addAttribute("leads", leads);
		model.addAttribute("employeeId", empId);
		if(employee.getRole().equals("salesman"))
			return "get-leads-employees";
		else return "get-leads-id";
	}
	@PostMapping("/getleadsbytwodates")//need
	public String getLeadsByDates(@ModelAttribute("salesInCome") SalesInCome salesInCome, Model model) {
		List<Lead> leasList=leadservice.getLeadsForSalesInCome(salesInCome.getFromDate(), salesInCome.getToDate());  
		List<String>employeename=leadservice.getEmployeeNameOfleads(leasList);
		List<String>accountName=leadservice.getAccountNameOfLeads(leasList);
		model.addAttribute(EMPLOYEENAME, employeename);
		model.addAttribute(ACCOUNTNAME, accountName);
		model.addAttribute(ALLLEADSMODEL, leasList);
		model.addAttribute(EMPID, salesInCome.getPlannedLeads());
		return ALLLEADS;
	}
	@GetMapping("/addleadfrom")//need
	public String addLeadForm(@RequestParam("id")int id,@RequestParam("empId")int empId,Model model) {
		Lead lead=new Lead();
		lead.setAccountId(id);
		lead.setEmployeeId(empId);
		lead.setLeadDate(BusinessLogic.getInstanceDate());
		lead.setStatus("open lead");
		model.addAttribute("addLead", lead);
		return "add-leads-form";
	}
	@PostMapping("/addlead")//need
	public String addLead(@ModelAttribute("addLead")Lead lead,Model model) {
		leadservice.insertLead(lead);
		return "add-leads-form";
	}
	@GetMapping("/deletelead")//need
	public String deleteLeadsById(@RequestParam("id")int id,@RequestParam("empId")int empId,Model model) {
		leadservice.deleteLead(id);
		return "redirect:/leads/allleads";
	}
	@GetMapping("/closeleads")//need
	public String closingleads(@RequestParam("id") int id,@RequestParam("empId")int empId,Model model) {
		Lead lead=leadservice.getLeadById(id);
		lead.setStatus("closed leads(lose)");
		leadservice.updateLead(lead);
		return "redirect:/home/addsales?empId="+empId;
	}
	@GetMapping("/allleads")//need
	public String getAllLeads(@RequestParam("empId") int empId,Model model) {
		List<Lead>allLeads=leadservice.allLead();
		List<String>employeename=leadservice.getEmployeeNameOfleads(allLeads);
		List<String>accountName=leadservice.getAccountNameOfLeads(allLeads);
		model.addAttribute(EMPLOYEENAME, employeename);
		model.addAttribute(ACCOUNTNAME, accountName);
		model.addAttribute(ALLLEADSMODEL, allLeads);
		model.addAttribute(EMPID, empId);
		return ALLLEADS;
	}
	@GetMapping("allleadsbyemployeeid")//need
	public String getAllleadsByEmployeeId(@RequestParam("empId") int empId,Model model) {
		List<Lead>allLeads=leadservice.getLeadsByEmployeeId(empId);
		List<String>employeename=leadservice.getEmployeeNameOfleads(allLeads);
		List<String>accountName=leadservice.getAccountNameOfLeads(allLeads);
		model.addAttribute(EMPLOYEENAME, employeename);
		model.addAttribute(ACCOUNTNAME, accountName);
		model.addAttribute(ALLLEADSMODEL, allLeads);
		model.addAttribute(EMPID, empId);
		return ALLLEADS;
	}
	@GetMapping("/updateleadfrom")//need
	public String updateLeadForm(@RequestParam("empId")int empId,Model model) {
		Lead lead=leadservice.getLeadById(empId);
		model.addAttribute("updateLead", lead);
		return "update-leads-form";
	}
	@PostMapping("/updatelead")//need
	public String updateLead(@ModelAttribute("updateLead")Lead lead,Model model) {
		leadservice.updateLead(lead);
		return "update-leads-form";
	}
	@GetMapping("/getleadsandsales")//need
	public String getLeadsAndSales(@RequestParam("id")int id,Model model) {
		SalesLeadsDTO dto=leadservice.getSalesAndLeads(id);
		List<String> salesDetail= salesService.getSalesForLead(dto.getSales());
		model.addAttribute(ACCOUNTNAME, salesDetail.get(0));
		model.addAttribute(EMPLOYEENAME, salesDetail.get(1));
		model.addAttribute("getLeads", dto.getLead());
		model.addAttribute("getSales",dto.getSales());
		return "list-leads-sales";
	}
}
