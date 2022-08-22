package com.chainsys.salesmanagementsystems.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.chainsys.salesmanagementsystems.validation.InvalidInputDataException;
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
	private static final String ERROR="error";
	private static final String ERRORPAGE="error-page";
	private static final String RESULT="result";
	private static final String MESSAGE="message";
	
	@Autowired
	private SalesService salesService;
	@Autowired
	private EmployeeService employeeservice;
	
	
	
	@GetMapping("/addsalesform")//need
	public String addSalesServiceForm(@RequestParam("id")int id,Model model,HttpServletRequest request) {
		Sales sales =new Sales();
		sales.setLeadId(id);
		HttpSession session= request.getSession();
		int employeeId=(int)session.getAttribute("employeeId");
		sales.setEmployeeId(employeeId);
		sales.setSalesDate(BusinessLogic.getInstanceDate());
		model.addAttribute("addsales", sales);
		return "add-sales-form";
	}
	@PostMapping("/addsales")//need
	public String addSales(@ModelAttribute("addsales")Sales sales,Model model) {
		try {
			salesService.insertSales(sales);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute(RESULT, "1 sale added");
		return "add-sales-form";
	}
	@GetMapping("/allsales")//need
	public String allSales(Model model) {
		SalesDTO salesDTO=null;
		try {
		salesDTO=salesService.allSales();
		if(salesDTO==null)
			throw new InvalidInputDataException("Cannot Find Sales Detils");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute(ALLSALESMODEL, salesDTO.getSalesList());
		model.addAttribute(ACCOUNTNAME, salesDTO.getAccountName());
		model.addAttribute(EMPLOYEENAME, salesDTO.getEmployeeName());
		return ALLSALES;
	}
	@PostMapping("/getsalesfortwodates")//need
	public String getSalesBetweenTwoDates(@ModelAttribute("salesInCome")SalesInCome salesInCome,Model model,HttpServletRequest request) {
		HttpSession session= request.getSession();
		int employeeId=(int)session.getAttribute("employeeId");
		List<Sales>allSales=null;
		try {
		allSales=salesService.getSalesBetweenTwoDates(salesInCome.getFromDate(),salesInCome.getToDate());
		if(allSales==null)
			throw new InvalidInputDataException("Cannot Find AllSales details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		SalesDTO saleDTO=null;
		try {
			saleDTO=salesService.getSalesDetailsOfNames(allSales);
			if(saleDTO==null)
				throw new InvalidInputDataException("Cannot Find Sales Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}

		model.addAttribute(EMPLOYEEID, employeeId);
		model.addAttribute(ACCOUNTNAME, saleDTO.getAccountName());
		model.addAttribute(EMPLOYEENAME, saleDTO.getEmployeeName());
		model.addAttribute(ALLSALESMODEL, allSales);
		return ALLSALES;
	}
	@GetMapping("/getSales")//need
	public String getSalesByID(@RequestParam("id")int id, Model model,HttpServletRequest request) {
		Sales sales=null;
		try {
			sales=salesService.getSalesById(id);
			if(sales==null)
				throw new InvalidInputDataException("cannot Find Sales Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		Employee employee=null;
		try {
			HttpSession session= request.getSession();
			int employeeId=(int)session.getAttribute("employeeId");
			employee=employeeservice.getEmployeeById(employeeId);
			if(employee==null)
				throw new InvalidInputDataException("You Are Not Valid Employee");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute("sales", sales);
		if(employee.getRole().equals("salesman"))
			return "get-sales-id";
		
		else return "get-sales-manager";
	}
	@GetMapping("/getsalesbyemployeeid")//need
	public String getSalesByEmployeeId(HttpServletRequest request,Model model) {
		HttpSession session= request.getSession();
		int employeeId=(int)session.getAttribute("employeeId");
		List<Sales> salesList=null;
		try {
			salesList=salesService.getSalesByEmployeeId(employeeId);
			if(salesList==null) 
				throw new InvalidInputDataException("Cannot Find SalesList Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		SalesDTO salesDTO=null;
		try {
			salesDTO=salesService.getSalesDetailsOfNames(salesList);
			if(salesDTO==null)
				throw new InvalidInputDataException("Cannot Find EmployeeName or AccountName");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute(ALLSALESMODEL, salesList);
		model.addAttribute(ACCOUNTNAME, salesDTO.getAccountName());
		model.addAttribute(EMPLOYEENAME, salesDTO.getEmployeeName());
		return ALLSALES;
	}
	@GetMapping("/deletesales")//need
	public String deleteSales(@RequestParam("id")int id,Model model) {
		try {
			salesService.deleteSales(id);
			return "redirect:/sales/allsales";
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
	}
	@GetMapping("/updatesalesform")//need
	public String updateSalesServiceForm(@RequestParam("id")int id,Model model) {
		Sales sales =null;
		try {
			sales =salesService.getSalesById(id);
			model.addAttribute("updatesales", sales);
			return "update-sales-form";
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		
	}
	@PostMapping("/updatesales")//need
	public String updateSales(@ModelAttribute("updatesales")Sales sales,Model model) {
		try {
			salesService.updateSales(sales);
			return "update-sales-form";
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
	}
	@GetMapping("/salesincome")//need
	public String salesIncome(Model model) {
		SalesInCome salesIncome=new SalesInCome();
		model.addAttribute(SALESINCOME, salesIncome);
		return "sales-income";
	}
	@PostMapping("/salesTotalAmount")//need
	public String salesTotalAmount(@ModelAttribute("salesIncome")SalesInCome salesIncome, Model model) {
		try {
			salesIncome=salesService.getTotalSalesBetweenTwoDates(salesIncome);
			if(salesIncome==null)
				throw new InvalidInputDataException("Cannot Fetch Income Data");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<SalesInCome> salesIncomeList=null;
		try {
			salesIncomeList=salesService.getMonthlySales(salesIncome);
			if(salesIncomeList==null)
				throw new InvalidInputDataException("Cannot Fetch Monthly Income ");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute(SALESINCOME, salesIncome);
		model.addAttribute("salesIncomeList", salesIncomeList);
		return "sales-income-result";
	}

	
}
