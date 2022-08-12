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

import com.chainsys.salesmanagementsystems.dto.AccountsTerritoryDTO;
import com.chainsys.salesmanagementsystems.dto.EmployeeTerritoryDTO;
import com.chainsys.salesmanagementsystems.model.GetId;
import com.chainsys.salesmanagementsystems.model.Territory;
import com.chainsys.salesmanagementsystems.repository.EmployeeRepository;
import com.chainsys.salesmanagementsystems.service.AccountService;
import com.chainsys.salesmanagementsystems.service.TerritoryService;

@Controller
@RequestMapping("/territory")
public class TerritoryController {
	@Autowired
	private TerritoryService territoryService;
	
	
	@GetMapping("/getId")
	public String getTerritoryId(Model model) {
		model.addAttribute("redirect", "getterritory");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/updateId")
	public String updateTerritoryId(Model model) {
		model.addAttribute("redirect", "updateterritoryform");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/deleteId")
	public String deleteTerritoryById(Model model) {
		model.addAttribute("redirect", "deleteterritory");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	
	
	
	
	@GetMapping("/addterritoryform")
	public String addTerritoryForm(Model model) {
		Territory territory=new Territory();
		model.addAttribute("addterritory", territory);
		return "add-territory-form";
	}
	@PostMapping("/addterritory")
	public String addTerritory(@ModelAttribute("addterritory")Territory ter,Model model) {
		territoryService.insertTerritory(ter);
		return "add-territory-form";
	}
	@PostMapping("/getterritory")
	public String getTerritory(@ModelAttribute("getId")GetId id,Model model) {
		Territory territory=territoryService.getTerritoryById(id.getId());
		model.addAttribute("territory", territory);
		return "get-territory-id";
	}
	@PostMapping("/deleteterritory")
	public String deleteTerritory(@ModelAttribute("getId")GetId id,Model model) {
		territoryService.deleteTerritory(id.getId());
		return "redirect:/territories/allterritory";
	}
	@GetMapping("/allterritory")//need
	public String allTerritory(@RequestParam("empId")int empId,Model model) {
		List<Territory>allterritory =territoryService.allTerritory();
		model.addAttribute("allteritory", allterritory);
		model.addAttribute("empId", empId);
		return "all-territory";
	}
	@PostMapping("/updateterritoryform")
	public String updateTerritoryForm(@ModelAttribute("getId")GetId id,Model model) {
		Territory ter=territoryService.getTerritoryById(id.getId());
		model.addAttribute("updateTerritory", ter);
		return "update-territory-form";
	}
	@PostMapping("/updateterritory")
	public String updateTerritory(@ModelAttribute("updateTerritory")Territory ter,Model model) {
		
		model.addAttribute("result", "1 Record updated");
		territoryService.updateTerritory(ter);
		return "update-territory-form";
	}
	@GetMapping("/getaccountsandterritory")//need
	public String getAccountAndTerritory(@RequestParam("id")int id,@RequestParam("empId")int empId,Model model) {
		AccountsTerritoryDTO dto=territoryService.getAccountandTerritory(id);
		model.addAttribute("getTerritory", dto.getTerritory());
		model.addAttribute("getAccounts", dto.getAccountList());
		return "list-accounts-territory";
}
	 @GetMapping("/getemployeeandterritory")
	 public String getEmployeesAndTerritory(@RequestParam("id")int id,@RequestParam("empId")int empId,Model model) {
		 EmployeeTerritoryDTO dto=territoryService.getTErritoryAndEmployee(id);
		 model.addAttribute("getTerritory", dto.getTerritory());
		 model.addAttribute("getEmployee", dto.getEmployeeList());
		 return "list-employees-territory";
	 }
	
}