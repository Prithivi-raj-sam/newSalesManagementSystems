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

import com.chainsys.salesmanagementsystems.dto.SalesLeadsDTO;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.service.LeadService;

@Controller
@RequestMapping("/leads")
public class LeadsController {
	@Autowired
	private LeadService leadservice;
	
	@GetMapping("/getlead")
	public String getleadsById(@RequestParam("id")int id,Model model) {
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
	@GetMapping("/deletelead")
	public String deleteLeadsById(@RequestParam("id")int id,Model model) {
		leadservice.deleteLead(id);
		return "redirect:/leads/allleads";
	}
	@GetMapping("/allleads")
	public String getAllLeads(Model model) {
		List<Lead>allLeads=leadservice.allLead();
		model.addAttribute("allLeads", allLeads);
		return "all-leads";
	}
	@GetMapping("/updateleadfrom")
	public String updateLeadForm(@RequestParam("id")int id,Model model) {
		Lead lead=leadservice.getLeadById(id);
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
