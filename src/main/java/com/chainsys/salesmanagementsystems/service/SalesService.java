package com.chainsys.salesmanagementsystems.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.businesslogic.BusinessLogic;
import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.model.Sales;
import com.chainsys.salesmanagementsystems.model.SalesDetail;
import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.repository.SalesRepository;

@Service
public class SalesService {
	@Autowired
	private SalesRepository salesRepository;
	@Autowired
	private TargetService targetService;
	@Autowired
	private LeadService leadService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AccountService accountService;
	public void insertSales(Sales sales) {
		salesRepository.save(sales);
		Lead lead=leadService.getLeadById(sales.getLeadId());
		lead.setStatus("closed leads(won)");
		leadService.updateLead(lead);
		List<Target>targetList=targetService.getTargetByDescendingOrder(sales.getEmployeeId());
		Target target= BusinessLogic.updateClosedTarget(targetList, "sales");
		targetService.updateTarget(target);
	}
	public List<SalesDetail> allSales(){
		List<Sales> salesList=salesRepository.findAll();
		List<SalesDetail>salesDetailsList=BusinessLogic.getSalesdetails(salesList, accountService, employeeService, leadService);
		 return salesDetailsList;
	}
	public void updateSales(Sales sales) {
		salesRepository.save(sales);
	}
	public void deleteSales(int id) {
		salesRepository.deleteById(id);
	}
	public Sales getSalesById(int id) {
		return salesRepository.findById(id);
	}
	public List<Sales> getSalesBetweenTwoDates(Date startDate,Date endDate){
		return salesRepository.findBySalesDateGreaterThanEqualAndSalesDateLessThanEqualOrderBySalesDateDesc(startDate, endDate); 
	}
	public List<Sales> getSalesByEmployeeId(int id){
		return salesRepository.findByEmployeeEmployeeId(id);
	}
	public List<SalesDetail> getSalesDetailsOfNames(List<Sales>salesList){
		return BusinessLogic.getSalesdetails(salesList, accountService, employeeService, leadService);
	}
	public SalesInCome getTotalSalesBetweenTwoDates(SalesInCome salesIncome){
		List<Target> targetList=targetService.getSalesInCome(salesIncome);
		List<Sales> salesList= getSalesBetweenTwoDates(salesIncome.getFromDate(),salesIncome.getToDate());
		int[] inComeAttributes=BusinessLogic.getTotalSalesAndLeadAttribute(targetList);
		salesIncome.setPlannedLeads(inComeAttributes[0]);
		salesIncome.setCommitedLeads(inComeAttributes[1]);
		salesIncome.setPlannedSales(inComeAttributes[2]);
		salesIncome.setClosedSales(inComeAttributes[3]);
		salesIncome.setTotalSalesAmount(BusinessLogic.getTotalSalesAmount(salesList));
		return salesIncome;
	}
	public SalesDetail getSalesForLead(Sales sales) {
		return BusinessLogic.getSalesDetailsByLeads(sales, accountService, employeeService, leadService);
		
	}
	public List<SalesInCome> getMonthlySales(SalesInCome salesIncome) {
		Date[] fromAndToDate=BusinessLogic.getFirstAndLastdayOfMonth(salesIncome.getFromDate(),salesIncome.getToDate());
		List<Sales> salesList= getSalesBetweenTwoDates(fromAndToDate[0],fromAndToDate[1]);
		List<SalesInCome> salesIncomeList=BusinessLogic.getMonthlySaleIncome(salesList,salesIncome);
		salesIncomeList=BusinessLogic.getMonthlyTarget(targetService, salesIncomeList);
		return salesIncomeList;
	}
	
}
