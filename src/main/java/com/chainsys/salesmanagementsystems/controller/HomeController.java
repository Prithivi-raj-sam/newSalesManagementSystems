package com.chainsys.salesmanagementsystems.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.model.Login;
import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.model.Territory;
import com.chainsys.salesmanagementsystems.service.EmployeeService;
import com.chainsys.salesmanagementsystems.service.LeadService;
import com.chainsys.salesmanagementsystems.service.AccountService;
import com.chainsys.salesmanagementsystems.validation.InvalidInputDataException;
import com.chainsys.salesmanagementsystems.validation.Validator;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LeadService leadService;
	@Autowired
	private AccountService accountService;
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
				SalesInCome salesInCome=new SalesInCome();
				model.addAttribute("salesIncome", salesInCome);
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
	@GetMapping("/managerpage")
	public String getManagerPage(@RequestParam("empId")int empId,Model model) {
		model.addAttribute("empId", empId);
		SalesInCome salesInCome=new SalesInCome();
		model.addAttribute("salesIncome", salesInCome);
		return "manager-page";
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
	public String redirectToAddSales(@RequestParam("empId")int empId,Model model) {
		List<Lead> leadList=leadService.getLeadsByEmployeeId(empId);
		List<Lead> openLeadList=leadList.stream()
		  .filter(lead -> lead.getStatus().equals("open lead"))
		  .collect(Collectors.toList());
		model.addAttribute("leadList", openLeadList);
		model.addAttribute("empId", empId);
		return "add-sales";
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
	public String redirectToAddLeads(@RequestParam("empId")int empId,Model model) {
		List<Account>accountlist=accountService.allAccount();
		model.addAttribute("accountlist", accountlist);
		model.addAttribute("empId", empId);
		return "add-leads";
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
		List<Employee> employeeList=employeeService.allEmployee();
		model.addAttribute("allEmployee", employeeList);
		Employee employee=new Employee();
		model.addAttribute("employeeDetail", employee);
		return "set-target-employees";
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
		return "employee";
	}
	@GetMapping("/targets")
	public String redirectToTarget(Model model) {
		Target target=new Target();
		model.addAttribute("target", target);
		return"target";
	}
	@GetMapping("/lead")//need
	public String redirectToLeads(@RequestParam("empId")int empId,Model model) {
		model.addAttribute("empId", empId);
		return"leads";
	}
	@GetMapping("/territorys")
	public String redirectToTerritory(@RequestParam("empId")int empId,Model model) {
		Territory territory=new Territory();
		model.addAttribute("territory", territory);
		model.addAttribute("empId", empId);
		return"territory";
	}
	
	@GetMapping("/marketeraccount")
	public String redirectToMarketerAccount(@RequestParam("empId") int empId,Model model) {
		model.addAttribute("empId", empId);
		Account account=new Account();
		model.addAttribute("account", account);
		return "marketer-account";
	}
	@GetMapping("/marketerterritory")
	public String redirectTomarketerTerrotory(@RequestParam("empId")int empId,Model model) {
		Territory territory=new Territory();
		model.addAttribute("empId", empId);
		model.addAttribute("territory", territory);
		return "marketer-territory";
	}
	@GetMapping("/employeeTarget")
	public String redirectToMarketerTarget(@RequestParam("empId")int empId,Model model) {
		SalesInCome salesInCome=new SalesInCome();
		model.addAttribute("salesInCome", salesInCome);
		model.addAttribute("empId", empId);
		return "employee-target";
	}
	
	@GetMapping("/salesmanSales")//need
	public String redirectToSalesmanSales(@RequestParam("empId") int empId,Model model) {
		SalesInCome salesInCome=new SalesInCome();
		model.addAttribute("salesInCome", salesInCome);
		model.addAttribute("empId", empId);
		return "salesman-sales";
	}
	@GetMapping("/salesmanLeads")
	public String redirectToSalesmanLeads(@RequestParam("empId") int empId,Model model) {
		SalesInCome salesInCome=new SalesInCome();
		model.addAttribute("salesInCome", salesInCome);
		model.addAttribute("empId", empId);
		return "salesman-leads";
	}
	@GetMapping("/salesIncome")
	public String redirectToSalesIncome(Model model) {
		SalesInCome salesIncome=new SalesInCome();
		model.addAttribute("salesIncome", salesIncome);
		return "income-reports";
	}
	@GetMapping("/test")
	public String testSession(Model model) {
		return "test";
	}
	
}
