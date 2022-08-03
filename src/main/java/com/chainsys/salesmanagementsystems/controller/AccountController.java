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

import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountservice;
	
	@GetMapping("/addaccountform")
	public String addAccountForm(Model model) {
		Account account =new Account();
		model.addAttribute("addAccount", account);
		return "add-account-form";
	}
	@PostMapping("/addaccount")
	public String addAccount(@ModelAttribute("addAccount")Account accout, Model model) {
		accountservice.insertAccount(accout);
		return "add-account-form";
	}
	@GetMapping("/getaccount")
	public String getAccountById(@RequestParam("id") int id,Model model) {
		Account account =accountservice.getAccountById(id);
		model.addAttribute("account", account);
		return "get-account-id";
	}
	@GetMapping("/deleteaccount")
	public String deleteAccountById(@RequestParam("id")int id,Model model) {
		accountservice.deleteAccount(id);
		return "redirect:/account/allaccount";
	}
	@GetMapping("/allaccount")
	public String getAllAccount(Model model) {
		List<Account>allAccount=accountservice.allAccount();
		model.addAttribute("allaccount", allAccount);
		return "all-account";
	}
	@GetMapping("/updateaccountform")
	public String updateAccountForm(@RequestParam("id")int id,Model model) {
		Account account =accountservice.getAccountById(id);
		model.addAttribute("updateAccount", account);
		return "update-account-form";
	}
	@PostMapping("/updateaccount")
	public String updateAccount(@ModelAttribute("updateAccount")Account accout, Model model) {
		accountservice.insertAccount(accout);
		return "update-account-form";
	}
}
