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

import com.chainsys.salesmanagementsystems.businesslogic.BusinessLogic;
import com.chainsys.salesmanagementsystems.dto.LeadsAccountsDTO;
import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.service.AccountService;
import com.chainsys.salesmanagementsystems.service.EmployeeService;
import com.chainsys.salesmanagementsystems.service.LeadService;
import com.chainsys.salesmanagementsystems.service.TerritoryService;
import com.chainsys.salesmanagementsystems.validation.InvalidInputDataException;

@Controller
@RequestMapping("/account")
public class AccountController {
	private static final String ALLACCOUNT="all-accounts"; 
	private static final String EMPID="empId";
	private static final String ALLACCOUNTMODEL="allaccount";
	private static final String EMPLOYEENAME="employeeName";
	private static final String RESULT="result";
	private static final String ERROR="error";
	private static final String MESSAGE="Somthing Went Wrong Please Try Later";
	private static final String ERRORPAGE="error-page";
	
	@Autowired
	private AccountService accountservice;
	@Autowired
	private TerritoryService territoryService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LeadService leadService;
	
	@GetMapping("/addaccountform")//need
	public String addAccountForm(@RequestParam("empId")int empId,Model model) {
		Account account =new Account();
		account.setEmployeeId(empId);
		account.setCustomerJoinDate(BusinessLogic.getInstanceDate());
		model.addAttribute("addAccount", account);
		model.addAttribute("allTerritory", territoryService.allTerritory());
		return "add-account-form";
	}
	@PostMapping("/addaccount")//need
	public String addAccount(@ModelAttribute("addAccount")Account account, Model model) {
		try {
			accountservice.insertAccount(account);
			model.addAttribute(RESULT, "1 Record Added");
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT,"Data Type Mismatch in Your AccountForm");
		}
		return "add-account-form";
	}

	@GetMapping("/getaccount")//need
	public String getAccountById(@RequestParam("id") int id,@RequestParam("empId") int empId,Model model) {
		Account account=null;
		try {
		account =accountservice.getAccountById(id);
		if(account==null)
			throw new InvalidInputDataException("There is no Such Account");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		Employee employee=null;
		try {
		employee=employeeService.getEmployeeById(empId);
		if(employee==null)
			throw new InvalidInputDataException("You Are Have Not Permission to Process");
		
		model.addAttribute("account", account);
		model.addAttribute(EMPID, empId);
		if(employee.getRole().equals("marketer"))
			return "get-account-marketer";
		else return "get-account-id";
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
	}
	
	@GetMapping("/allaccount")//need
	public String getAllAccount(@RequestParam("empId")int empId,Model model) {
		List<Account>allAccount=null;
		try {
		allAccount=accountservice.allAccount();
		if(allAccount==null)
			throw new InvalidInputDataException("All Accounts Are Null");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>employeeName=null;
		try {
		employeeName=employeeService.getEmployeeNamesByEmployeeId(allAccount);
		if(employeeName==null)
			throw new InvalidInputDataException("There is No Such Employee");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute(EMPLOYEENAME, employeeName);
		model.addAttribute(ALLACCOUNTMODEL, allAccount);
		model.addAttribute(EMPID, empId);
		return ALLACCOUNT;
	}
	@GetMapping("/allaccountbyemployee")//need
	public String getAllAccountByEmployeeId(@RequestParam("empId")int empId,Model model) {
		List<Account>allAccount=null;
		try {
		allAccount=accountservice.getAccountByEmployeeId(empId);
		if(allAccount==null)
			throw new InvalidInputDataException("There is No Accounts For this Employee");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>employeeName=null;
		try {
			employeeName=employeeService.getEmployeeNamesByEmployeeId(allAccount);
			if(employeeName==null)
				throw new InvalidInputDataException("There is Some Issues in Fetching Employee Name");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute(EMPLOYEENAME, employeeName);
		model.addAttribute(ALLACCOUNTMODEL, allAccount);
		model.addAttribute(EMPID, empId);
		return ALLACCOUNT;
	}
	@PostMapping("/getaccountbycompanyname")//need
	public String getAccountByCompanyName(@ModelAttribute("account")Account account,Model model) {
		List<Account>allAccount=accountservice.getAccountByComapnyName(account.getCompanyName());
		List<String>employeeName=employeeService.getEmployeeNamesByEmployeeId(allAccount);
		model.addAttribute(EMPLOYEENAME, employeeName);
		model.addAttribute(ALLACCOUNTMODEL, allAccount);
		model.addAttribute(EMPID, account.getEmployeeId());
		return ALLACCOUNT;
	}
	@GetMapping("/deleteaccount")//need
	public String deleteAccount(@RequestParam("id")int id,@RequestParam("empId")int empId,Model model) {
		accountservice.deleteAccount(id);
		return "redirect:/account/allaccountbyemployee?empId="+empId;
	}
	@GetMapping("/updateaccountform")//need
	public String updateAccountForm(@RequestParam("id")int id,Model model) {
		Account account =accountservice.getAccountById(id);
		model.addAttribute("updateAccount", account);
		model.addAttribute("allTerritory", territoryService.allTerritory());
		return "update-account-form";
	}
	@PostMapping("/updateaccount")//need
	public String updateAccount(@ModelAttribute("updateAccount")Account account, Model model) {
		accountservice.updateAccount(account);
		model.addAttribute(RESULT, "1 record updated");
		return "update-account-form";
	}
	@GetMapping("/getacountandleads")//need
	public String getAcountAndLeads(@RequestParam("id")int id, Model model) {
		LeadsAccountsDTO dto=accountservice.getAcountsAndLeads(id);
		List<Lead>leadList=dto.getLeadsList();
		List<String>accountName=leadService.getAccountNameOfLeads(leadList);
		List<String> employeeName=leadService.getEmployeeNameOfleads(leadList);
		model.addAttribute(EMPLOYEENAME, employeeName);
		model.addAttribute("accountName", accountName);
		model.addAttribute("getaccount", dto.getAccount());
		model.addAttribute("getlead", dto.getLeadsList());
		return "list-account-leads";
	}
}
