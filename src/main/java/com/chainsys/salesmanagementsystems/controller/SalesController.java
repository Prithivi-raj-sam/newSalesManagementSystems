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

import com.chainsys.salesmanagementsystems.model.GetId;
import com.chainsys.salesmanagementsystems.model.Sales;
import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.service.SalesService;

@Controller
@RequestMapping("/sales")
public class SalesController {
	@Autowired
	private SalesService salesService;
	
	
	@GetMapping("/getId")
	public String getSalesId(Model model) {
		model.addAttribute("redirect", "getSales");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/updateId")
	public String updateSalesId(Model model) {
		model.addAttribute("redirect", "updatesalesform");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/deleteId")
	public String deleteSalesById(Model model) {
		model.addAttribute("redirect", "deletesales");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	
	
	
	
	@GetMapping("/addsalesform")
	public String addSalesServiceForm(Model model) {
		Sales sales =new Sales();
		model.addAttribute("addsales", sales);
		return "add-sales-form";
	}
	@PostMapping("/addsales")
	public String addSales(@ModelAttribute("addsales")Sales sales,Model model) {
		salesService.insertSales(sales);
		return "add-sales-form";
	}
	@GetMapping("/allsales")
	public String allSales(Model model) {
		List<Sales>allSales=salesService.allSales();
		model.addAttribute("allSales", allSales);
		return "all-sales";
	}
	@PostMapping("/getSales")
	public String getSalesByID(@ModelAttribute("getIdd")GetId id, Model model) {
		Sales sales=salesService.getSalesById(id.getId());
		model.addAttribute("sales", sales);
		return "get-sales-id";
	}
	@PostMapping("/deletesales")
	public String deleteSales(@ModelAttribute("getIdd")GetId id, Model model) {
		salesService.deleteSales(id.getId());
		return "all-sales";
	}
	@PostMapping("/updatesalesform")
	public String updateSalesServiceForm(@ModelAttribute("getIdd")GetId id,Model model) {
		Sales sales =salesService.getSalesById(id.getId());
		model.addAttribute("updatesales", sales);
		return "update-sales-form";
	}
	@PostMapping("/updatesales")
	public String updateSales(@ModelAttribute("updatesales")Sales sales,Model model) {
		salesService.updateSales(sales);
		return "update-sales-form";
	}
	@GetMapping("/salesincome")
	public String salesIncome(Model model) {
		SalesInCome salesIncome=new SalesInCome();
		model.addAttribute("salesIncome", salesIncome);
		return "sales-income";
	}
	@PostMapping("/salesTotalAmount")
	public String salesTotalAmount(@ModelAttribute("salesIncome")SalesInCome salesIncome, Model model) {
		salesService.getSalesBetweenTwoDates(salesIncome);
		return "sales-income-result";
	}
}
