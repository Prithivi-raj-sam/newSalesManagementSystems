package com.chainsys.salesmanagementsystems.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chainsys.salesmanagementsystems.dto.AccountsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.LeadsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.SalesDTO;
import com.chainsys.salesmanagementsystems.dto.SalesEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.TargetEmployeeDTO;
import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.model.Sales;
import com.chainsys.salesmanagementsystems.service.EmployeeService;
import com.chainsys.salesmanagementsystems.service.LeadService;
import com.chainsys.salesmanagementsystems.service.TerritoryService;
import com.chainsys.salesmanagementsystems.validation.InvalidInputDataException;
import com.chainsys.salesmanagementsystems.service.SalesService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private static final String REDIRECTTOALLEMPLOYEE="redirect:/employee/allemployee";
	private static final String RESULT="result";
	private static final String GETEMPLOYEE="getEmployee";
	private static final String EMPLOYEENAME="employeeName";
	private static final String ERROR="error";
	private static final String MESSAGE="Somthing Went Wrong Please try Again";
	private static final String ERRORPAGE="error-page";
	private static final String UPDATEEMPLOYEE="update-employee-form";
	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private TerritoryService territoryService;
	@Autowired
	private SalesService salesService;
	@Autowired
	private LeadService leadService;
	
	
	@GetMapping("/getemployee")//need
	public String getEmployeeById(@RequestParam("getId")int id,Model model) {
		Employee employee=null;
		try {
		employee=employeeservice.getEmployeeById(id);
		if(employee==null)
			throw new InvalidInputDataException("Cannot Find This Employee Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute("employee", employee);
		return "get-employee-id";
	}
	@PostMapping("/getemployeebyname")//need
	public String getEmployeeByname(@ModelAttribute("employee")Employee employeeName,Model model){
		List<Employee> employee=null;
		try {
		employee=employeeservice.getEmployeeByName(employeeName.getEmployeeName());
		if(employee==null)
			throw new InvalidInputDataException("Cannot Find This Employee Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute("allEmployee", employee);
		return "all-employees";
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
			employee.setProfile(photo.getBytes());
		}catch(IOException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		try {
		employeeservice.insertEmployee(employee);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute(RESULT, "1 row inserted");
		return "add-employee-form";
	}
	@ResponseBody
	@GetMapping("/getImage")//need
	public ResponseEntity<byte[]> getImage(@RequestParam("id")int empId,Model model){
		byte[] empPhoto=null;
		try {
		empPhoto=employeeservice.getEmployeeImageByteArray(empId);
		if(empPhoto==null)
			throw new InvalidInputDataException("Cannot Find Image");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(empPhoto);
	}
	@GetMapping("/allemployee")//need
	public String getAllEmployee(Model model) {
		List<Employee>allEmployee =null;
		try{
		allEmployee =employeeservice.allEmployee();
		if(allEmployee==null)
			throw new InvalidInputDataException("There Is No Employee Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute("allEmployee", allEmployee);
		return "all-employees";
	}
	@PostMapping("/deleteemployee")//need
	public String deleteEmployeeById(@RequestParam("id")int id,Model model) {
		try {
		employeeservice.deleteEmployee(id);
		}catch(Exception exp){
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		return REDIRECTTOALLEMPLOYEE;
	}
	@GetMapping("/updateemployeeform")//need
	public String updateEmployeeForm(@RequestParam("id")int id,Model model) {
		Employee employee=null;
		try {
		employee=employeeservice.getEmployeeById(id);
		if(employee==null)
			throw new InvalidInputDataException("Cannot Find Employee Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute("updateEmployee", employee);
		model.addAttribute("allTerritory", territoryService.allTerritory());
		return UPDATEEMPLOYEE;
	}
	@PostMapping("/updateemployee")//need
	public String updateEmployee(@ModelAttribute("updateEmployee")Employee employee, Model model) {
		try {
		employeeservice.updateEmployee(employee);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return UPDATEEMPLOYEE;
		}
		model.addAttribute(RESULT, "1 record updated");
		return UPDATEEMPLOYEE;
	}
	@GetMapping("/employeeachievment")//need
	public String redirectToAchievment(@RequestParam("id")int id,Model model) {
		Employee employee=null;
		try {
		employee=employeeservice.getEmployeeById(id);
		if(employee==null)
			throw new InvalidInputDataException("Cannot Fetch Employee Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		if(employee.getRole().equals("manager")) {
			return REDIRECTTOALLEMPLOYEE;
		}
		else if(employee.getRole().equals("salesman")) {
			SalesEmployeeDTO dto=null;
			try {
			dto=employeeservice.getSalesEmployee(id);
			if(dto==null)
				throw new InvalidInputDataException("Sale Data Cannot be Found");
			}catch(InvalidInputDataException exp) {
				model.addAttribute(ERROR, exp.getMessage());
				model.addAttribute(RESULT, MESSAGE);
				return ERRORPAGE;
			}
			model.addAttribute(GETEMPLOYEE, dto.getEmployee());
			model.addAttribute("getSales", dto.getSalesList());
			return "list-employee-sales";
		}
		else if(employee.getRole().equals("marketer")) {
			AccountsEmployeeDTO dto=null;
			try {
			dto=employeeservice.getAccountsandEmployee(id);
			if(dto==null)
				throw new InvalidInputDataException("Sale Data Cannot be Found");
			}catch(InvalidInputDataException exp) {
				model.addAttribute(ERROR, exp.getMessage());
				model.addAttribute(RESULT, MESSAGE);
				return ERRORPAGE;
			}
			model.addAttribute("getAccounts", dto.getAccountList());
			model.addAttribute(GETEMPLOYEE, dto.getEmployee());
			return "list-accounts-employee";
		}
		else {
			return REDIRECTTOALLEMPLOYEE;
		}
	}
	@GetMapping("/getaccountsemployee")//need
	public String getAccountsAndEmplyee(@RequestParam("id")int id,Model model) {
		AccountsEmployeeDTO dto=null;
		try {
		dto=employeeservice.getAccountsandEmployee(id);
		if(dto==null)
			throw new InvalidInputDataException("Accounts and Employee Details Missing");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute("getAccounts", dto.getAccountList());
		model.addAttribute(GETEMPLOYEE, dto.getEmployee());
		return "list-accounts-employee";
	}
	@GetMapping("/getleadsandemployee")//need
	public String getLeadsandEmployee(@RequestParam("id")int id,Model model) {
		LeadsEmployeeDTO dto=null;
		try {
			dto=employeeservice.getLeadsAndEmployee(id);
			if(dto==null)
				throw new InvalidInputDataException("Leads and Employee Details Missing");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<Lead>leadList=null;
		try {
			leadList=dto.getLeadlist();
			if(leadList==null)
				throw new InvalidInputDataException("Cannot find Lead Data");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>employeeName=null;
		try {
			employeeName=leadService.getAccountNameOfLeads(leadList);
			if(employeeName==null)
				throw new InvalidInputDataException("Cannot Find Employee Name");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>accountName=null;
		try {
			accountName=leadService.getAccountNameOfLeads(leadList);
			if(accountName==null)
				throw new InvalidInputDataException("Cannot Find Account Name");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute(EMPLOYEENAME, employeeName);
		model.addAttribute("accountName", accountName);
		model.addAttribute("getemployee", dto.getEmployee());
		model.addAttribute("getleads", dto.getLeadlist());
		return "list-employee-leads";
	}
	@GetMapping("/getsalesandemployee")//need
	public String getSalesAndEmployee(@RequestParam("id")int id,Model model) {
		SalesEmployeeDTO dto=null;
		try {
			dto=employeeservice.getSalesEmployee(id);
			if(dto==null)
				throw new InvalidInputDataException("Sales And Employee Details has Been Missing");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		SalesDTO salesDTO=null;
		try {
			salesDTO=salesService.getSalesDetailsOfNames(dto.getSalesList());
			if(salesDTO==null)
				throw new InvalidInputDataException("SalesName And EmployeeName Details has Been Missing");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute(GETEMPLOYEE, dto.getEmployee());
		model.addAttribute("getSales", dto.getSalesList());
		model.addAttribute("accountName", salesDTO.getAccountName());
		model.addAttribute(EMPLOYEENAME, salesDTO.getEmployeeName());
		return "list-employee-sales";
	}
	@GetMapping("/getemployeeandtarget")//need
	public String getEmployeeAndTarget(@RequestParam("id")int id,Model model) {
		TargetEmployeeDTO dto=null;
		try {
		dto=employeeservice.getTargetsAndEmployee(id);
		if(dto==null)
			throw new InvalidInputDataException("Target And Employee Details has been Missing");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute(GETEMPLOYEE, dto.getEmployee());
		model.addAttribute("getTargets", dto.getTargetList());
		return "list-employee-target";
	}
	@GetMapping("/getemployeebyhighsales")//need
	public String getEmployeeOrderByHighSales(Model model) {
		List<Sales>monthlyEmployeeSales=null;
		try {
		monthlyEmployeeSales=salesService.getallSales();
		if(monthlyEmployeeSales==null)
			throw new InvalidInputDataException("Target And Employee Details has been Missing");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<Integer>employeeId=null;
		try {
			employeeId=monthlyEmployeeSales.stream().map(Sales::getEmployeeId).toList();
			if(employeeId==null)
				throw new InvalidInputDataException("Cannot Extract Employee Id from Sales Table");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>employeeName=null;
		try {
		employeeName=employeeservice.getEmployeeName(employeeId);
		if(employeeName==null)
			throw new InvalidInputDataException("Cannot Find Employee Name");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute("monthlyEmployeeSales", monthlyEmployeeSales);
		model.addAttribute(EMPLOYEENAME, employeeName);
		return "monthly-employee-sales";
	}
	@GetMapping("/getemployeebyaccountcount")
	public String getEmployeeByAccountCount(Model model) {
		List<Account>accountList=null;
		try {
		accountList=employeeservice.getAccountCountByEmployees();
		if(accountList==null)
			throw new InvalidInputDataException("Cannot Find Account Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<Integer>employeeId=null;
		try {
		employeeId=accountList.stream().map(Account::getEmployeeId).toList();
		if(employeeId==null)
			throw new InvalidInputDataException("Cannot Extract Employee Id From accountList");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>employeeName=null;
		try {
			employeeName=employeeservice.getEmployeeName(employeeId);
			if(employeeName==null)
				throw new InvalidInputDataException("Cannot find Employee Name");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute(EMPLOYEENAME, employeeName);
		model.addAttribute("empId", 1);
		model.addAttribute("accountList", accountList);
		return "monthly-account-employee";
		
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
		model.addAttribute(RESULT, "password has been changed");
		return "password";
	}
}
