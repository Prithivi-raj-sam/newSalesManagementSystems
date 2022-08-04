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

import com.chainsys.salesmanagementsystems.model.Sales;
import com.chainsys.salesmanagementsystems.service.SalesService;

@Controller
@RequestMapping("/sales")
public class SalesController {
	@Autowired
	private SalesService salesService;
	
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
	@GetMapping("/getSales")
	public String getSalesByID(@RequestParam("id")int id, Model model) {
		Sales sales=salesService.getSalesById(id);
		model.addAttribute("sales", sales);
		return "get-sales-id";
	}
	@GetMapping("/deletesales")
	public String deleteSales(@RequestParam("id")int id, Model model) {
		salesService.deleteSales(id);
		return "all-sales";
	}
	@GetMapping("/updatesalesform")
	public String updateSalesServiceForm(@RequestParam("id")int id,Model model) {
		Sales sales =salesService.getSalesById(id);
		model.addAttribute("updatesales", sales);
		return "update-sales-form";
	}
	@PostMapping("/updatesales")
	public String updateSales(@ModelAttribute("updatesales")Sales sales,Model model) {
		salesService.updateSales(sales);
		return "update-sales-form";
	}
	
}
