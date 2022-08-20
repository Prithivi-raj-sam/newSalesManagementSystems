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
import com.chainsys.salesmanagementsystems.dto.SalesDTO;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Sales;
import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.service.SalesService;
import com.chainsys.salesmanagementsystems.service.EmployeeService;

@Controller
@RequestMapping("/sales")
public class SalesController {
	private static final String ALLSALES="all-sales";
	private static final String SALESINCOME="salesIncome";
	private static final String ALLSALESMODEL="allSales";
	private static final String ACCOUNTNAME="accountName";
	private static final String EMPLOYEENAME="employeeName";
	private static final String EMPLOYEEID="empId";
	@Autowired
	private SalesService salesService;
	@Autowired
	private EmployeeService employeeservice;
	
	
	
	@GetMapping("/addsalesform")//need
	public String addSalesServiceForm(@RequestParam("id")int id,@RequestParam("empId")int empId,Model model) {
		Sales sales =new Sales();
		sales.setLeadId(id);
		sales.setEmployeeId(empId);
		sales.setSalesDate(BusinessLogic.getInstanceDate());
		model.addAttribute("addsales", sales);
		return "add-sales-form";
	}
	@PostMapping("/addsales")//need
	public String addSales(@ModelAttribute("addsales")Sales sales,Model model) {
		salesService.insertSales(sales);
		model.addAttribute("result", "1 sale added");
		return "add-sales-form";
	}
	@GetMapping("/allsales")//need
	public String allSales(@RequestParam("empId") int empId, Model model) {
		SalesDTO salesDTO=salesService.allSales();
		model.addAttribute(ALLSALESMODEL, salesDTO.getSalesList());
		model.addAttribute(ACCOUNTNAME, salesDTO.getAccountName());
		model.addAttribute(EMPLOYEENAME, salesDTO.getEmployeeName());
		model.addAttribute(EMPLOYEEID, empId);
		return ALLSALES;
	}
	@PostMapping("/getsalesfortwodates")//need
	public String getSalesBetweenTwoDates(@ModelAttribute("salesInCome")SalesInCome salesInCome,Model model) {
		List<Sales>allSales=salesService.getSalesBetweenTwoDates(salesInCome.getFromDate(),salesInCome.getToDate());
		SalesDTO saleDTO=salesService.getSalesDetailsOfNames(allSales);
		model.addAttribute(EMPLOYEEID, salesInCome.getPlannedSales());
		model.addAttribute(ACCOUNTNAME, saleDTO.getAccountName());
		model.addAttribute(EMPLOYEENAME, saleDTO.getEmployeeName());
		model.addAttribute(ALLSALESMODEL, allSales);
		return ALLSALES;
	}
	@GetMapping("/getSales")//need
	public String getSalesByID(@RequestParam("id")int id,@RequestParam("empId")int empId, Model model) {
		Sales sales=salesService.getSalesById(id);
		Employee employee=employeeservice.getEmployeeById(empId);
		model.addAttribute("sales", sales);
		if(employee.getRole().equals("salesman"))
			return "get-sales-id";
		
		else return "get-sales-manager";
	}
	@GetMapping("/getsalesbyemployeeid")//need
	public String getSalesByEmployeeId(@RequestParam("empId")int empId,Model model) {
		List<Sales> salesList=salesService.getSalesByEmployeeId(empId);
		SalesDTO salesDTO=salesService.getSalesDetailsOfNames(salesList);
		model.addAttribute(ALLSALESMODEL, salesList);
		model.addAttribute(ACCOUNTNAME, salesDTO.getAccountName());
		model.addAttribute(EMPLOYEENAME, salesDTO.getEmployeeName());
		model.addAttribute(EMPLOYEEID, empId);
		return ALLSALES;
	}
	@GetMapping("/deletesales")//need
	public String deleteSales(@RequestParam("id")int id,@RequestParam("empId")int empId, Model model) {
		salesService.deleteSales(id);
		return "redirect:/sales/allsales?empId="+empId;
	}
	@GetMapping("/updatesalesform")//need
	public String updateSalesServiceForm(@RequestParam("id")int id,Model model) {
		Sales sales =salesService.getSalesById(id);
		model.addAttribute("updatesales", sales);
		return "update-sales-form";
	}
	@PostMapping("/updatesales")//need
	public String updateSales(@ModelAttribute("updatesales")Sales sales,Model model) {
		salesService.updateSales(sales);
		return "update-sales-form";
	}
	@GetMapping("/salesincome")//need
	public String salesIncome(Model model) {
		SalesInCome salesIncome=new SalesInCome();
		model.addAttribute(SALESINCOME, salesIncome);
		return "sales-income";
	}
	@PostMapping("/salesTotalAmount")//need
	public String salesTotalAmount(@ModelAttribute("salesIncome")SalesInCome salesIncome, Model model) {
		salesIncome=salesService.getTotalSalesBetweenTwoDates(salesIncome);
		List<SalesInCome> salesIncomeList=salesService.getMonthlySales(salesIncome);
		model.addAttribute(SALESINCOME, salesIncome);
		model.addAttribute("salesIncomeList", salesIncomeList);
		return "sales-income-result";
	}

	
}
