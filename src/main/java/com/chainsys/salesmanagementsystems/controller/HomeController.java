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
		return "redirect:/employee/updateemployeeform";
	}
	@GetMapping("/deleteemplyee")
	public String redirectToDeleteEmployee(Model model) {
		return "redirect:/employee/deleteemployee";
	}
	@GetMapping("/getemployee")
	public String redirectToGetEmployee(Model model){
		return "redirect:/employee/getemployee";
	}
	@GetMapping("/addaccountfrom")
	public String redirectToAccount(Model model) {
		return "redirect:/account/addaccountform";
	}
	@GetMapping("/addsalesform")
	public String redirectToAddSales(Model model) {
		return "redirect:/sales/addsalesform";
	}
	
}
