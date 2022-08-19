package com.chainsys.salesmanagementsystems.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chainsys.salesmanagementsystems.dto.AccountsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.LeadsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.SalesEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.TargetEmployeeDTO;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.GetId;
import com.chainsys.salesmanagementsystems.service.EmployeeService;
import com.chainsys.salesmanagementsystems.service.TerritoryService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private TerritoryService territoryService;
	
	@GetMapping("/getemployeeId")
	public String getemployeeId(Model model) {
		model.addAttribute("redirect", "getemployee");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	
	@GetMapping("/getemployee")//
	public String getEmployeeById(@RequestParam("getId")int id,Model model) {
		Employee employee=employeeservice.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "get-employee-id";
	}
	@PostMapping("/getemployeebyname")//need
	public String getEmployeeByname(@ModelAttribute("employee")Employee employeeName,Model model){
		List<Employee> employee=employeeservice.getEmployeeByName(employeeName.getEmployeeName());
		model.addAttribute("allEmployee", employee);
		return "all-employees";
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
	
	
	
	@GetMapping("/addemployeeform")//need
	public String addEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("addEmployee", employee);
		model.addAttribute("allTerritory", territoryService.allTerritory());
		return "add-employee-form";
	}
	@PostMapping("/addemployee")//need
	public String addEmployee(@ModelAttribute("addEmployee")Employee employee,@RequestParam("photo")MultipartFile photo, Model model) {
		try {
			System.out.println(photo.getBytes().length);
		}catch(IOException exp) {
			exp.printStackTrace();
		}
		try {
			employee.setProfile(photo.getBytes());
		}catch(IOException exp) {
			exp.printStackTrace();
		}
		employeeservice.insertEmployee(employee);
		model.addAttribute("result", "1 row inserted");
		return "add-employee-form";
	}
	@ResponseBody
	@GetMapping("/getImage")
	public ResponseEntity<byte[]> getImage(@RequestParam("id")int empId){
		byte[] empPhoto=employeeservice.getEmployeeImageByteArray(empId);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(empPhoto);
	}
	@GetMapping("/allemployee")
	public String getAllEmployee(Model model) {
		List<Employee>allEmployee =employeeservice.allEmployee();
		model.addAttribute("allEmployee", allEmployee);
		return "all-employees";
	}
	@PostMapping("/deleteemployee")//need
	public String deleteEmployeeById(@RequestParam("id")int id,Model model) {
		employeeservice.deleteEmployee(id);
		return "redirect:/employee/allemployee";
	}
	@GetMapping("/updateemployeeform")//need
	public String updateEmployeeForm(@RequestParam("id")int id,Model model) {
		Employee employee=employeeservice.getEmployeeById(id);
		model.addAttribute("updateEmployee", employee);
		model.addAttribute("allTerritory", territoryService.allTerritory());
		return "update-employee-form";
	}
	@PostMapping("/updateemployee")//need
	public String updateEmployee(@ModelAttribute("updateEmployee")Employee employee, Model model) {
		employeeservice.updateEmployee(employee);
		model.addAttribute("result", "1 record updated");
		return "update-employee-form";
	}
	@GetMapping("/employeeachievment")//need
	public String redirectToAchievment(@RequestParam("id")int id,Model model) {
		Employee employee=employeeservice.getEmployeeById(id);
		if(employee.getRole().equals("manager")) {
			return "redirect:/employee/allemployee";
		}
		else if(employee.getRole().equals("salesman")) {
			SalesEmployeeDTO dto=employeeservice.getSalesEmployee(id);
			model.addAttribute("getEmployee", dto.getEmployee());
			model.addAttribute("getSales", dto.getSalesList());
			return "list-employee-sales";
		}
		else if(employee.getRole().equals("marketer")) {
			AccountsEmployeeDTO dto=employeeservice.getAccountsandEmployee(id);
			model.addAttribute("getAccounts", dto.getAccountList());
			model.addAttribute("getEmployee", dto.getEmployee());
			return "list-accounts-employee";
		}
		else {
			return "redirect:/employee/allemployee";
		}
	}
	@GetMapping("/getaccountsemployee")//need
	public String getAccountsAndEmplyee(@RequestParam("id")int id,Model model) {
		AccountsEmployeeDTO dto=employeeservice.getAccountsandEmployee(id);
		model.addAttribute("getAccounts", dto.getAccountList());
		model.addAttribute("getEmployee", dto.getEmployee());
		return "list-accounts-employee";
	}
	@GetMapping("/getleadsandemployee")//need
	public String getLeadsandEmployee(@RequestParam("id")int id,Model model) {
		LeadsEmployeeDTO dto=employeeservice.getLeadsAndEmployee(id);
		model.addAttribute("getemployee", dto.getEmployee());
		model.addAttribute("getleads", dto.getLeadlist());
		return "list-employee-leads";
	}
	@GetMapping("/getsalesandemployee")//need
	public String getSalesAndEmployee(@RequestParam("id")int id,Model model) {
		SalesEmployeeDTO dto=employeeservice.getSalesEmployee(id);
		model.addAttribute("getEmployee", dto.getEmployee());
		model.addAttribute("getSales", dto.getSalesList());
		return "list-employee-sales";
	}
	@GetMapping("/getemployeeandtarget")//need
	public String getEmployeeAndTarget(@RequestParam("id")int id,Model model) {
		TargetEmployeeDTO dto=employeeservice.getTargetsAndEmployee(id);
		model.addAttribute("getEmployee", dto.getEmployee());
		model.addAttribute("getTargets", dto.getTargetList());
		return "list-employee-target";
	}
	@GetMapping("/passwordform")
	public String updatePasswordForm(@RequestParam("empId")int id,Model model) {
		Employee newEmployee=new Employee();
		model.addAttribute("emp", newEmployee);
		model.addAttribute("empId", id);
		return "password";
	}
	@PostMapping("/updatepassword")
	public String updatePassword(@ModelAttribute("emp")Employee employeePassword,Model model) {
		Employee employee=employeeservice.getEmployeeById(employeePassword.getEmployeeId());
		employee.setPassword(employeePassword.getPassword());
		employeeservice.updateEmployee(employee);
		model.addAttribute("result", "password has been changed");
		return "password";
	}
}
