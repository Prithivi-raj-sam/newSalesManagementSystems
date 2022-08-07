package com.chainsys.salesmanagementsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Login;
import com.chainsys.salesmanagementsystems.service.EmployeeService;
import com.chainsys.salesmanagementsystems.validation.InvalidInputDataException;
import com.chainsys.salesmanagementsystems.validation.Validator;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/login")
	public String loginPage(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login-page";
	}

	@PostMapping("employeepage")
	public String redirectToEmployeesPage(@ModelAttribute("login") Login login, Model model) {
		Employee employee = employeeService.getEmployeeById(login.getEmployeeId());
		try {
			Validator.nullValueErrorCheck(employee);
		} catch (InvalidInputDataException exp) {
			model.addAttribute("error", "Error Name:" + exp.getMessage());
			model.addAttribute("message", "There is no Such Employee Id");
			return "login-page";
		}
		if (employee.getPassword().equals(login.getPassword())) {
			if (employee.getRole().equalsIgnoreCase("manager")) {
				return "manager-page";
			} else if (employee.getRole().equalsIgnoreCase("marketer")) {
				return "marketer-page";
			} else if (employee.getRole().equalsIgnoreCase("salesman")) {
				return "salesman-page";
			} else {
				model.addAttribute("message", "Somthing Wrong Please Ask Manager");
				return "login-page";
			}
		}
		else {
			model.addAttribute("message", "password miss match");
			return "login-page";
		}
	}

	@GetMapping("/addemployeeform")
	public String redirectToAddEMployee(Model model) {
		return "redirect:/employee/addemployeeform";
	}
	@GetMapping("/updateemployee")
	public String redirectToUpdateEmployee(Model model) {
		return "redirect:/employee/updateId";
	}
	@GetMapping("/deleteemplyee")
	public String redirectToDeleteEmployee(Model model) {
		return "redirect:/employee/deleteId";
	}
	@GetMapping("/getemployee")
	public String redirectToGetEmployee(Model model){
		return "redirect:/employee/getemployeeId";
	}
	@GetMapping("/getallemplyee")
	public String redirectToGetAllEmployees(Model model) {
		return "redirect:/employee/allemployee";
	}
	@GetMapping("/addaccountfrom")
	public String redirectToAddAccount(Model model) {
		return "redirect:/account/addaccountform";
	}
	@GetMapping("/getallaccount")
	public String redirectToAllAccount(Model model) {
		return "redirect:/account/allaccount";
	}
	@GetMapping("/deleteaccount")
	public String redirectToDeleteAccount(Model model) {
		return "redirect:/account/deleteId";
	}
	@GetMapping("/updateaccount")
	public String redirectToUpdateAccount(Model model) {
		return "redirect:/account/updateId";
	}
	@GetMapping("/getaccount")
	public String redirectToGetAccount(Model model) {
		return "redirect:/account/getId";
	}
	@GetMapping("/addsales")
	public String redirectToAddSales(Model model) {
		return "redirect:/sales/addsalesform";
	}
	@GetMapping("/updatesales")
	public String redirectToUpdateSales(Model model) {
		return "redirect:/sales/updateId";
	}
	@GetMapping("/getSales")
	public String redirectToGetSalesById(Model model) {
		return "redirect:/sales/getId";
	}
	@GetMapping("/getallSales")
	public String redirectToGetAllSales(Model model) {
		return "redirect:/sales/allsales";
	}
	@GetMapping("/deleteSales")
	public String redirectToDeleteSales(Model model) {
		return "redirect:/sales/deleteId";
	}
	@GetMapping("/addleads")
	public String redirectToAddLeads(Model model) {
		return "redirect:/leads/addleadfrom";
	}
	@GetMapping("/updateleads")
	public String redirectToUpdate(Model model) {
		return "redirect:/leads/updateleadfrom";
	}
	@GetMapping("/getleads")
	public String redirectToGetLeadsById(Model model) {
		return "redirect:/leads/getlead";
	}
	@GetMapping("/deleteleads")
	public String redirectToDelete(Model model) {
		return "redirect:/leads/deletelead";
	}
	@GetMapping("/getallleads")
	public String redirectToGetAllLeads(Model model) {
		return "redirect:/leads/allleads";
	}
	@GetMapping("/addterritory")
	public String redirectToAddTerritory(Model model) {
		return "redirect:/territory/addterritoryform";
	}
	@GetMapping("/updateterritory")
	public String redirectToUpdateTerritory(Model model) {
		return "redirect:/territory/updateId";
	}
	@GetMapping("/deleteterritory")
	public String redirectToDeleteTerritory(Model model) {
		return "redirect:/territory/deleteId";
	}
	@GetMapping("/getterritory")
	public String  redirectGetTerritoryById(Model model) {
		return "redirect:/territory/getId";
	}
	@GetMapping("/getallterritory")
	public String redirectToGetAllTerritory(Model model) {
		return "redirect:/territory/allterritory";
	}
	@GetMapping("/addTarget")
	public String redirectToAddTarget(Model model) {
		return "redirect:/target/addtargetform";
	}
	@GetMapping("/updatetarget")
	public String redirectToUpdateTarget(Model model) {
		return "redirect:/target/updateId";
	}
	@GetMapping("/getalltarget")
	public String redirectToGetAllTarget(Model model) {
		return "redirect:/target/alltargets";
	}
	@GetMapping("/gettarget")
	public String redirectToGetTargetById(Model model) {
		return "redirect:/target/getId";
	}
	@GetMapping("/deletetarget")
	public String redirectToDeletetarget(Model model) {
		return "redirect:/target/deleteId";
	}
	
}
