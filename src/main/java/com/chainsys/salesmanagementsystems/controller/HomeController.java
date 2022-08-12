package com.chainsys.salesmanagementsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Login;
import com.chainsys.salesmanagementsystems.model.Target;
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
		Employee employee = employeeService.getEmployeeByEmployeeIdAndPassrd(login.getEmployeeId(),login.getPassword());
		try {
			Validator.nullValueErrorCheck(employee);
		} catch (InvalidInputDataException exp) {
			model.addAttribute("error", "Error Name:" + exp.getMessage());
			model.addAttribute("message", "Employee Id or password Mismatch");
			return "login-page";
		}
			model.addAttribute("empId", employee.getEmployeeId());
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
	public String redirectToGetAllSales(@RequestParam("empId")int empId,Model model) {
		Employee employee =employeeService.getEmployeeById(empId);
		if(employee.getRole().equals("salesman"))
			return "redirect:/sales/allsales";
		else return "redirect:/sales/";
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
	@GetMapping("/employees")
	public String redirectToEmployee(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return"employee";
	}
	@GetMapping("/targets")
	public String redirectToTarget(Model model) {
		Target target=new Target();
		model.addAttribute("target", target);
		return"target";
	}
	@GetMapping("/lead")
	public String redirectToLeads(@RequestParam("empId")int empId,Model model) {
		model.addAttribute("empId", empId);
		return"leads";
	}
	@GetMapping("/territorys")
	public String redirectToTerritory(Model model) {
		return"territory";
	}
	@GetMapping("/marketeraccount")
	public String redirectToMarketerAccount(Model model) {
		return "marketer-account";
	}
	@GetMapping("/marketerterritory")
	public String redirectTomarketerTerrotory(Model model) {
		return "marketer-territory";
	}
	@GetMapping("/marketerTarget")
	public String redirectToMarketerTarget(Model model) {
		return "marketer-target";
	}
	@GetMapping("/salesmanTarget")
	public String redirectToSalesTarget(Model model) {
		return "salesman-target";
	}
	@GetMapping("/salesmanSales")
	public String redirectToSalesmanSales(@RequestParam("empId") int empId,Model model) {
		model.addAttribute("empId", empId);
		return "salesman-sales";
	}
	@GetMapping("/salesmanLeads")
	public String redirectToSalesmanLeads(Model model) {
		return "salesman-leads";
	}
	@GetMapping("/test")
	public String testSession(Model model) {
		return "test";
	}
}
