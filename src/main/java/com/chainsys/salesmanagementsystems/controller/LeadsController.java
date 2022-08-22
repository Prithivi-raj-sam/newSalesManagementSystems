package com.chainsys.salesmanagementsystems.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.chainsys.salesmanagementsystems.validation.InvalidInputDataException;

@Controller
@RequestMapping("/leads")
public class LeadsController {
	private static final String ALLLEADS="all-leads";
	private static final String EMPID="empId";
	private static final String ACCOUNTNAME="accountName";
	private static final String EMPLOYEENAME="employeeName";
	private static final String ALLLEADSMODEL="allLeads";
	private static final String ERROR="error";
	private static final String ERRORPAGE="ERRORPAGE"; 
	private static final String RESULT="result";
	private static final String MESSAGE="Somthing Went Wrong Please Try later";
	private static final String ADDLEADFORM="add-leads-form";
	private static final String UPDATELEADFORM="update-leads-form";
	
	@Autowired
	private LeadService leadservice;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private SalesService salesService;
	
	@GetMapping("/getlead")//need
	public String getleadsById(@RequestParam("id")int id,Model model,HttpServletRequest request) {
		HttpSession session= request.getSession();
		int employeeId=(int)session.getAttribute("employeeId");
		Lead leads=null;
		try {
		leads=leadservice.getLeadById(id);
		if(leads==null)
			throw new InvalidInputDataException("Cannot find This Lead Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		Employee employee=null;
		try {
			employee=employeeService.getEmployeeById(employeeId);
			if(employee==null)
				throw new InvalidInputDataException("Your Not Valid Employee");
			model.addAttribute("leads", leads);
			model.addAttribute("employeeId", employeeId);
			if(employee.getRole().equals("salesman"))
				return "get-leads-employees";
			else return "get-leads-id";
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
	}
	@PostMapping("/getleadsbytwodates")//need
	public String getLeadsByDates(@ModelAttribute("salesInCome") SalesInCome salesInCome, Model model) {
		List<Lead> leasList=null;
		try {
		leasList=leadservice.getLeadsForSalesInCome(salesInCome.getFromDate(), salesInCome.getToDate());  
		if(leasList==null)
			throw new InvalidInputDataException("Cannot Find Leads Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>employeename=null;
		try {
			employeename=leadservice.getEmployeeNameOfleads(leasList);
			if(employeename==null)
				throw new InvalidInputDataException("Cannot Find Employee Name");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>accountName=null;
		try {
			accountName=leadservice.getAccountNameOfLeads(leasList);
			if(accountName==null)
				throw new InvalidInputDataException("Cannot Fetch Account Name");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute(EMPLOYEENAME, employeename);
		model.addAttribute(ACCOUNTNAME, accountName);
		model.addAttribute(ALLLEADSMODEL, leasList);
		return ALLLEADS;
	}
	@GetMapping("/addleadfrom")//need
	public String addLeadForm(@RequestParam("id")int id,Model model,HttpServletRequest request) {
		Lead lead=new Lead();
		lead.setAccountId(id);
		HttpSession session= request.getSession();
		int employeeId=(int)session.getAttribute("employeeId");
		lead.setEmployeeId(employeeId);
		lead.setLeadDate(BusinessLogic.getInstanceDate());
		lead.setStatus("open lead");
		model.addAttribute("addLead", lead);
		return ADDLEADFORM;
	}
	@PostMapping("/addlead")//need
	public String addLead(@ModelAttribute("addLead")Lead lead,Model model) {
		try {
			leadservice.insertLead(lead);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute(RESULT, "1 Record Added");
		return ADDLEADFORM;
	}
	@GetMapping("/deletelead")//need
	public String deleteLeadsById(@RequestParam("id")int id,Model model) {
		try {
			leadservice.deleteLead(id);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		return "redirect:/leads/allleads";
	}
	@GetMapping("/closeleads")//need
	public String closingleads(@RequestParam("id") int id,Model model,HttpServletRequest request) {
		HttpSession session= request.getSession();
		int employeeId=(int)session.getAttribute("employeeId");
		Lead lead=null;
		try {
			lead=leadservice.getLeadById(id);
			if(lead==null)
				throw new InvalidInputDataException("Cannot Find Lead Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		lead.setStatus("closed leads(lose)");
		try {
		leadservice.updateLead(lead);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		return "redirect:/home/addsales?empId="+employeeId;
	}
	@GetMapping("/allleads")//need
	public String getAllLeads(Model model) {
		List<Lead>allLeads=null;
		try {
			allLeads=leadservice.allLead();
			if(allLeads==null)
				throw new InvalidInputDataException("Cannot Find Leads Lists");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>employeeName=null;
		try {
			employeeName=leadservice.getEmployeeNameOfleads(allLeads);
			if(employeeName==null)
				throw new InvalidInputDataException("Cannot Find Employee Name");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>accountName=null;
		try {
			accountName=leadservice.getAccountNameOfLeads(allLeads);
			if(accountName==null)
				throw new InvalidInputDataException("Cannot Find Account Name");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute(EMPLOYEENAME, employeeName);
		model.addAttribute(ACCOUNTNAME, accountName);
		model.addAttribute(ALLLEADSMODEL, allLeads);
		return ALLLEADS;
	}
	@GetMapping("allleadsbyemployeeid")//need
	public String getAllleadsByEmployeeId(@RequestParam("empId") int empId,Model model) {
		List<Lead>allLeads=null;
		try {
			allLeads=leadservice.getLeadsByEmployeeId(empId);
			if(allLeads==null)
				throw new InvalidInputDataException("Cannot Find lead Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>employeeName=null;
		try {
			employeeName=leadservice.getEmployeeNameOfleads(allLeads);
			if(employeeName==null)
				throw new InvalidInputDataException("Cannot Find EMployee Name");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>accountName=null;
		try {
			accountName=leadservice.getAccountNameOfLeads(allLeads);
			if(accountName==null)
				throw new InvalidInputDataException("Cannot Find Account Name");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute(EMPLOYEENAME, employeeName);
		model.addAttribute(ACCOUNTNAME, accountName);
		model.addAttribute(ALLLEADSMODEL, allLeads);
		model.addAttribute(EMPID, empId);
		return ALLLEADS;
	}
	@GetMapping("/updateleadfrom")//need
	public String updateLeadForm(@RequestParam("id")int id,Model model) {
		Lead lead=null;
		try {
			lead=leadservice.getLeadById(id);
			if(lead==null)
				throw new InvalidInputDataException("Cannot Find Lead Details");
			model.addAttribute("updateLead", lead);
			return UPDATELEADFORM;
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
	
	}
	@PostMapping("/updatelead")//need
	public String updateLead(@ModelAttribute("updateLead")Lead lead,Model model) {
		try {
		leadservice.updateLead(lead);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		return UPDATELEADFORM;
	}
	@GetMapping("/getleadsandsales")//need
	public String getLeadsAndSales(@RequestParam("id")int id,Model model) {
		SalesLeadsDTO dto=null;
		try {
		dto=leadservice.getSalesAndLeads(id);
		if(dto==null)
			throw new InvalidInputDataException("Cannot Find Leads And Sales");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String> salesDetail=null;
		try {
			salesDetail= salesService.getSalesForLead(dto.getSales());
			if(salesDetail==null)
				throw new InvalidInputDataException("Cannot Find Sales Deatils");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute(ACCOUNTNAME, salesDetail.get(0));
		model.addAttribute(EMPLOYEENAME, salesDetail.get(1));
		model.addAttribute("getLeads", dto.getLead());
		model.addAttribute("getSales",dto.getSales());
		return "list-leads-sales";
	}
}
