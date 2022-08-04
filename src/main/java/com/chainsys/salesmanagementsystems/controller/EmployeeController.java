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

import com.chainsys.salesmanagementsystems.dto.AccountsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.LeadsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.SalesEmployeeDTO;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/addemployeeform")
	public String addEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("addEmployee", employee);
		return "add-employee-form";
	}
	@PostMapping("/addemployee")
	public String addEmployee(@ModelAttribute("addEmployee")Employee employee, Model model) {
		employeeservice.insertEmployee(employee);
		return "add-employee-form";
	}
	@GetMapping("/getEmployee")
	public String getEmployeeById(@RequestParam("id")int id,Model model) {
		Employee employee=employeeservice.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "get-employee-id";
	}
	@GetMapping("/allemployee")
	public String getAllEmployee(Model model) {
		List<Employee>allEmployee =employeeservice.allEmployee();
		model.addAttribute("allEmployee", allEmployee);
		return "all-employees";
	}
	@GetMapping("/deleteemployee")
	public String deleteEmployeeById(@RequestParam("id")int id,Model model) {
		employeeservice.deleteEmployee(id);
		return "redirect:/employee/allemployee";
	}
	@GetMapping("/updateemployeeform")
	public String updateEmployeeForm(@RequestParam("id")int id,Model model) {
		Employee employee=employeeservice.getEmployeeById(id);
		model.addAttribute("updateEmployee", employee);
		return "update-employee-form";
	}
	@PostMapping("/updateemployee")
	public String updateEmployee(@ModelAttribute("updateEmployee")Employee employee, Model model) {
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
		return "list-sales-employee";
	}
	
}
