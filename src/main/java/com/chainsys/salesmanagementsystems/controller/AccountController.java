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

import com.chainsys.salesmanagementsystems.businesslogic.BusinessLogic;
import com.chainsys.salesmanagementsystems.dto.LeadsAccountsDTO;
import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.GetId;
import com.chainsys.salesmanagementsystems.model.Territory;
import com.chainsys.salesmanagementsystems.service.AccountService;
import com.chainsys.salesmanagementsystems.service.EmployeeService;
import com.chainsys.salesmanagementsystems.service.TerritoryService;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountservice;
	@Autowired
	private TerritoryService territoryService;
	@Autowired
	private EmployeeService employeeService;
	
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
		accountservice.insertAccount(account);
		model.addAttribute("result", "1 Record Added");
		return "add-account-form";
	}

	@GetMapping("/getaccount")//need
	public String getAccountById(@RequestParam("id") int id,@RequestParam("empId") int empId,Model model) {
		Account account =accountservice.getAccountById(id);
		Employee employee=employeeService.getEmployeeById(empId);
		model.addAttribute("account", account);
		model.addAttribute("empId", empId);
		if(employee.getRole().equals("marketer"))
			return "get-account-marketer";
		else return "get-account-id";
	}
	
	@GetMapping("/allaccount")//need
	public String getAllAccount(@RequestParam("empId")int empId,Model model) {
		List<Account>allAccount=accountservice.allAccount();
		model.addAttribute("allaccount", allAccount);
		model.addAttribute("empId", empId);
		return "all-accounts";
	}
	@GetMapping("/allaccountbyemployee")//need
	public String getAllAccountByEmployeeId(@RequestParam("empId")int empId,Model model) {
		List<Account>allAccount=accountservice.getAccountByEmployeeId(empId);
		model.addAttribute("allaccount", allAccount);
		model.addAttribute("empId", empId);
		return "all-accounts";
	}
	@PostMapping("/getaccountbycompanyname")
	public String getAccountByCompanyName(@ModelAttribute("account")Account account,Model model) {
		List<Account>allAccount=accountservice.getAccountByComapnyName(account.getCompanyName());
		model.addAttribute("allaccount", allAccount);
		model.addAttribute("empId", account.getEmployeeId());
		return "all-accounts";
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
		model.addAttribute("result", "1 record updated");
		return "update-account-form";
	}
	@GetMapping("/getacountandleads")//need
	public String getAcountAndLeads(@RequestParam("id")int id, Model model) {
		LeadsAccountsDTO dto=accountservice.getAcountsAndLeads(id);
		model.addAttribute("getaccount", dto.getAccount());
		model.addAttribute("getlead", dto.getLeadsList());
		return "list-account-leads";
	}
}
