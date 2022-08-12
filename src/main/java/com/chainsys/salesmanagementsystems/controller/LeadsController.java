package com.chainsys.salesmanagementsystems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.salesmanagementsystems.dto.SalesLeadsDTO;
import com.chainsys.salesmanagementsystems.model.GetId;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.service.LeadService;

@Controller
@RequestMapping("/leads")
public class LeadsController {
	@Autowired
	private LeadService leadservice;
	
	@GetMapping("/getId")
	public String getLeadId(Model model) {
		model.addAttribute("redirect", "getlead");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/updateId")
	public String deleteLeadId(Model model) {
		model.addAttribute("redirect", "updateleadfrom");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/deleteId")
	public String deleteLeadById(Model model) {
		model.addAttribute("redirect", "deletelead");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	
	
	
	
	
	@GetMapping("/getlead")
	public String getleadsById(@RequestParam("id")int id,@RequestParam("empId")int empId,Model model) {
		Lead leads=leadservice.getLeadById(id);
		model.addAttribute("leads", leads);
		return "get-leads-id";
	}
	@GetMapping("/addleadfrom")
	public String addLeadForm(Model model) {
		Lead lead=new Lead();
		model.addAttribute("addLead", lead);
		return "add-leads-form";
	}
	@PostMapping("/addlead")
	public String addLead(@ModelAttribute("addLead")Lead lead,Model model) {
		
		leadservice.insertLead(lead);
		return "add-leads-form";
	}
	@PostMapping("/deletelead")
	public String deleteLeadsById(@ModelAttribute("getId")GetId id,Model model) {
		leadservice.deleteLead(id.getId());
		return "redirect:/leads/allleads";
	}
	@GetMapping("/allleads")//need
	public String getAllLeads(@RequestParam("empId") int empId,Model model) {
		List<Lead>allLeads=leadservice.allLead();
		model.addAttribute("allLeads", allLeads);
		model.addAttribute("empId", empId);
		return "all-leads";
	}
	@PostMapping("/updateleadfrom")
	public String updateLeadForm(@ModelAttribute("getId")GetId id,Model model) {
		Lead lead=leadservice.getLeadById(id.getId());
		model.addAttribute("updateLead", lead);
		return "update-leads-form";
	}
	@PostMapping("/updatelead")
	public String updateLead(@ModelAttribute("updateLead")Lead lead,Model model) {
		
		leadservice.updateLead(lead);
		return "update-leads-form";
	}
	@GetMapping("/getleadsandsales")
	public String getLeadsAndSales(@RequestParam("id")int id,Model model) {
		SalesLeadsDTO dto=leadservice.getSalesAndLeads(id);
		model.addAttribute("getLeads", dto.getLead());
		model.addAttribute("getSales", dto.getSales());
		return "list-leads-sales";
	}
}
