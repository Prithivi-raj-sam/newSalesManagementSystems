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

import com.chainsys.salesmanagementsystems.dto.AccountsTerritoryDTO;
import com.chainsys.salesmanagementsystems.dto.EmployeeTerritoryDTO;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Territory;
import com.chainsys.salesmanagementsystems.service.EmployeeService;
import com.chainsys.salesmanagementsystems.service.TerritoryService;

@Controller
@RequestMapping("/territory")
public class TerritoryController {
	@Autowired
	private TerritoryService territoryService;
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/addterritoryform")//need
	public String addTerritoryForm(Model model) {
		Territory territory=new Territory();
		model.addAttribute("addterritory", territory);
		return "add-territory-form";
	}
	@PostMapping("/addterritory")//need
	public String addTerritory(@ModelAttribute("addterritory")Territory ter,Model model) {
		territoryService.insertTerritory(ter);
		return "add-territory-form";
	}
	@PostMapping("getTerritorybyname")//need
	public String getTerritoryByName(@ModelAttribute("territory")Territory territory,Model model) {
		List<Territory> territoryList=territoryService.gettargetByStartingTerritoryName(territory.getTerritoryName());
		model.addAttribute("allteritory", territoryList);
		model.addAttribute("empId", territory.getTerritoryId());
		return "all-territory";
	}
	@GetMapping("/getterritory")//need
	public String getTerritory(@RequestParam("id")int id,@RequestParam("empId")int empId,Model model) {
		Territory territory=territoryService.getTerritoryById(id);
		model.addAttribute("territory", territory);
		Employee employee=employeeService.getEmployeeById(empId);
		if(employee.getRole().equals("salesman"))
			return "get-territory-sales";
		return "get-territory-id";
	}
	@GetMapping("/deleteterritory")//need
	public String deleteTerritory(@RequestParam("getId")int id,Model model) {
		territoryService.deleteTerritory(id);
		return "redirect:/territories/allterritory";
	}
	@GetMapping("/allterritory")//need
	public String allTerritory(@RequestParam("empId")int empId,Model model) {
		List<Territory>allterritory =territoryService.allTerritory();
		model.addAttribute("allteritory", allterritory);
		model.addAttribute("empId", empId);
		return "all-territory";
	}
	@GetMapping("/updateterritoryform")//need
	public String updateTerritoryForm(@RequestParam("id")int id,Model model) {
		Territory ter=territoryService.getTerritoryById(id);
		model.addAttribute("updateTerritory", ter);
		return "update-territory-form";
	}
	@PostMapping("/updateterritory")//need
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
	 @GetMapping("/getemployeeandterritory")//need
	 public String getEmployeesAndTerritory(@RequestParam("id")int id,@RequestParam("empId")int empId,Model model) {
		 EmployeeTerritoryDTO dto=territoryService.getTErritoryAndEmployee(id);
		 model.addAttribute("getTerritory", dto.getTerritory());
		 model.addAttribute("getEmployee", dto.getEmployeeList());
		 return "list-employees-territory";
	 }
	
}