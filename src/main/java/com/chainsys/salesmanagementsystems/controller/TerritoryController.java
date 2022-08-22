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
import com.chainsys.salesmanagementsystems.validation.InvalidInputDataException;

@Controller
@RequestMapping("/territory")
public class TerritoryController {
	private static final String ERROR="error";
	private static final String ERRORPAGE="error-page";
	private static final String RESULT="result";
	private static final String MESSAGE="message";
	
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
		try {
			territoryService.insertTerritory(ter);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		return "add-territory-form";
	}
	@PostMapping("getTerritorybyname")//need
	public String getTerritoryByName(@ModelAttribute("territory")Territory territory,Model model) {
		List<Territory> territoryList=null;
		try {
			territoryList=territoryService.gettargetByStartingTerritoryName(territory.getTerritoryName());
			if(territoryList==null)
				throw new InvalidInputDataException("Cannot Fetch Territory Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute("allteritory", territoryList);
		return "all-territory";
	}
	@GetMapping("/getterritory")//need
	public String getTerritory(@RequestParam("id")int id,@RequestParam("empId")int empId,Model model) {
		Territory territory=null;
		try {
			territory=territoryService.getTerritoryById(id);
			if(territory==null)
				throw new InvalidInputDataException("Cannot Fetch territory Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute("territory", territory);
		Employee employee=employeeService.getEmployeeById(empId);
		if(employee.getRole().equals("salesman"))
			return "get-territory-sales";
		return "get-territory-id";
	}
	@GetMapping("/deleteterritory")//need
	public String deleteTerritory(@RequestParam("getId")int id,Model model) {
		try {
			territoryService.deleteTerritory(id);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		return "redirect:/territories/allterritory";
	}
	@GetMapping("/allterritory")//need
	public String allTerritory(Model model) {
		List<Territory>allterritory =null;
		try {
			allterritory =territoryService.allTerritory();
			if(allterritory==null)
				throw new InvalidInputDataException("Cannot Fetch All Territory Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute("allteritory", allterritory);
		return "all-territory";
	}
	@GetMapping("/updateterritoryform")//need
	public String updateTerritoryForm(@RequestParam("id")int id,Model model) {
		Territory ter=null;
		try {
			ter=territoryService.getTerritoryById(id);
			if(ter==null)
				throw new InvalidInputDataException("Cannot Fetch Territory Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}

		model.addAttribute("updateTerritory", ter);
		return "update-territory-form";
	}
	@PostMapping("/updateterritory")//need
	public String updateTerritory(@ModelAttribute("updateTerritory")Territory ter,Model model) {
		model.addAttribute(RESULT, "1 Record updated");
		try {
			territoryService.updateTerritory(ter);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		return "update-territory-form";
	}
	@GetMapping("/getaccountsandterritory")//need
	public String getAccountAndTerritory(@RequestParam("id")int id,Model model) {
		AccountsTerritoryDTO dto=null;
		try {
			dto=territoryService.getAccountandTerritory(id);
			if(dto==null)
				throw new InvalidInputDataException("Cannot Fetch Account And Territory details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute("getTerritory", dto.getTerritory());
		model.addAttribute("getAccounts", dto.getAccountList());
		return "list-accounts-territory";
}
	 @GetMapping("/getemployeeandterritory")//need
	 public String getEmployeesAndTerritory(@RequestParam("id")int id,Model model) {
		 EmployeeTerritoryDTO dto=null;
		 try {
			 dto=territoryService.getTErritoryAndEmployee(id);
			 if(dto==null)
				 throw new InvalidInputDataException("Cannot Fetch Employee And Territory");
		 }catch(InvalidInputDataException exp) {
				model.addAttribute(ERROR, exp.getMessage());
				model.addAttribute(RESULT, MESSAGE);
				return ERRORPAGE;
			}

		 model.addAttribute("getTerritory", dto.getTerritory());
		 model.addAttribute("getEmployee", dto.getEmployeeList());
		 return "list-employees-territory";
	 }
	
}