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

import com.chainsys.salesmanagementsystems.dto.AccountsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.LeadsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.SalesEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.TargetEmployeeDTO;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.GetId;
import com.chainsys.salesmanagementsystems.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/getemployeeId")
	public String getemployeeId(Model model) {
		model.addAttribute("redirect", "getemployee");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/updateId")
	public String updateId(Model model) {
		model.addAttribute("redirect", "updateemployeeform");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/deleteId")
	public String deleteId(Model model) {
		model.addAttribute("redirect", "deleteemployee");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	
	
	
	@GetMapping("/addemployeeform")
	public String addEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("addEmployee", employee);
		return "add-employee-form";
	}
	@PostMapping("/addemployee")
	public String addEmployee(@Valid@ModelAttribute("addEmployee")Employee employee, Model model,Errors error) {
		if(error.hasErrors()) {
			return "add-employee-form";
		}
		employeeservice.insertEmployee(employee);
		return "add-employee-form";
	}
	
	@PostMapping("/getemployee")
	public String getEmployeeById(@ModelAttribute("getId")GetId id,Model model) {
		Employee employee=employeeservice.getEmployeeById(id.getId());
		model.addAttribute("employee", employee);
		return "get-employee-id";
	}
	@GetMapping("/allemployee")
	public String getAllEmployee(Model model) {
		List<Employee>allEmployee =employeeservice.allEmployee();
		model.addAttribute("allEmployee", allEmployee);
		return "all-employees";
	}
	@PostMapping("/deleteemployee")
	public String deleteEmployeeById(@ModelAttribute("getId")GetId id,Model model) {
		employeeservice.deleteEmployee(id.getId());
		return "redirect:/employee/allemployee";
	}
	@PostMapping("/updateemployeeform")
	public String updateEmployeeForm(@ModelAttribute("getId")GetId id,Model model) {
		Employee employee=employeeservice.getEmployeeById(id.getId());
		model.addAttribute("updateEmployee", employee);
		return "update-employee-form";
	}
	@PostMapping("/updateemployee")
	public String updateEmployee(@Valid@ModelAttribute("updateEmployee")Employee employee, Model model,Errors error) {
		if(error.hasErrors()) {
			return "update-employee-form";
		}
		employeeservice.updateEmployee(employee);
		return "update-employee-form";
	}
	@GetMapping("/getaccountsemployee")
	public String getAccountsAndEmplyee(@RequestParam("id")int id,Model model) {
		AccountsEmployeeDTO dto=employeeservice.getAccountsandEmployee(id);
		model.addAttribute("getAccounts", dto.getAccountList());
		model.addAttribute("getEmployee", dto.getEmployee());
		return "list-accounts-employee";
	}
	@GetMapping("/getleadsandemployee")
	public String getLeadsandEmployee(@RequestParam("id")int id,Model model) {
		LeadsEmployeeDTO dto=employeeservice.getLeadsAndEmployee(id);
		model.addAttribute("getemployee", dto.getEmployee());
		model.addAttribute("getleads", dto.getLeadlist());
		return "list-employee-leads";
	}
	@GetMapping("/getsalesandemployee")
	public String getSalesAndEmployee(@RequestParam("id")int id,Model model) {
		SalesEmployeeDTO dto=employeeservice.getSalesEmployee(id);
		model.addAttribute("getEmployee", dto.getEmployee());
		model.addAttribute("getSales", dto.getSalesList());
		return "list-employee-sales";
	}
	@GetMapping("/getemployeeandtarget")
	public String getEmployeeAndTarget(@RequestParam("id")int id,Model model) {
		TargetEmployeeDTO dto=employeeservice.getTargetsAndEmployee(id);
		model.addAttribute("getEmployee", dto.getEmployee());
		model.addAttribute("getTargets", dto.getTargetList());
		return "list-employee-target";
	}
	
}
