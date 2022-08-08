package com.chainsys.salesmanagementsystems.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.businesslogic.BusinessLogic;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.model.Sales;
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
	
	public void insertSales(Sales sales) {
		salesRepository.save(sales);
	}
	public List<Sales> allSales(){
		return salesRepository.findAll();
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
		return salesRepository.findBySalesDateGreaterThanEqualAndSalesDateLessThanEqual(startDate, endDate); 
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
}
