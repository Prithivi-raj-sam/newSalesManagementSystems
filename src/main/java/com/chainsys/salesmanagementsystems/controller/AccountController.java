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

import com.chainsys.salesmanagementsystems.dto.LeadsAccountsDTO;
import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.GetId;
import com.chainsys.salesmanagementsystems.model.Territory;
import com.chainsys.salesmanagementsystems.service.AccountService;
import com.chainsys.salesmanagementsystems.service.TerritoryService;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountservice;
	@Autowired
	private TerritoryService territoryService;
	
	@GetMapping("/getId")
	public String getAccountId(Model model) {
		model.addAttribute("redirect", "getaccount");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/updateId")
	public String updateAccountId(Model model) {
		model.addAttribute("redirect", "updateaccountform");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/deleteId")
	public String deleteAccountById(Model model) {
		model.addAttribute("redirect", "deleteaccount");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	
	
	
	
	@GetMapping("/addaccountform")
	public String addAccountForm(Model model) {
		Account account =new Account();
		model.addAttribute("addAccount", account);
		model.addAttribute("allTerritory", territoryService.allTerritory());
		Territory territory=new Territory();
		model.addAttribute("territory", territory);
		return "add-account-form";
	}
	@PostMapping("/addaccount")
	public String addAccount(@ModelAttribute("addAccount")Account accout,@ModelAttribute("territory")Territory territory, Model model) {
		territory.setNoOfCustomer(1);
		territoryService.updateTerritory(null);
		accountservice.insertAccount(accout);
		model.addAttribute("result", "1 Record Added");
		return "add-account-form";
	}
	@PostMapping("/getaccount")
	public String getAccountById(@ModelAttribute("getId") GetId id,Model model) {
		Account account =accountservice.getAccountById(id.getId());
		model.addAttribute("account", account);
		return "get-account-id";
	}
	
	@GetMapping("/allaccount")
	public String getAllAccount(Model model) {
		List<Account>allAccount=accountservice.allAccount();
		model.addAttribute("allaccount", allAccount);
		return "all-account";
	}
	@PostMapping("/deleteaccount")
	public String deleteAccount(@ModelAttribute("getId")GetId id,Model model) {
		accountservice.deleteAccount(id.getId());
		return "redirect:/account/allaccount";
	}
	@PostMapping("/updateaccountform")
	public String updateAccountForm(@RequestParam("id")GetId id,Model model) {
		Account account =accountservice.getAccountById(id.getId());
		model.addAttribute("updateAccount", account);
		return "update-account-form";
	}
	@PostMapping("/updateaccount")
	public String updateAccount(@ModelAttribute("updateAccount")Account accout, Model model) {
		accountservice.insertAccount(accout);
		return "update-account-form";
	}
	@GetMapping("/getacountandleads")
	public String getAcountAndLeads(@RequestParam("id")int id, Model model) {
		LeadsAccountsDTO dto=accountservice.getAcountsAndLeads(id);
		model.addAttribute("getaccount", dto.getAccount());
		model.addAttribute("getlead", dto.getLeadsList());
		return "list-account-leads";
	}
}
