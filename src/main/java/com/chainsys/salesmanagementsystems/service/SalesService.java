package com.chainsys.salesmanagementsystems.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.businessLogic.BusinessLogic;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.model.Sales;
import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.repository.LeadRepository;
import com.chainsys.salesmanagementsystems.repository.SalesRepository;
import com.chainsys.salesmanagementsystems.repository.TargetRepository;

@Service
public class SalesService {
	@Autowired
	private SalesRepository salesRepository;
	@Autowired
	private TargetService targetService;
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
	public SalesInCome getSalesBetweenTwoDates(SalesInCome salesIncome){
		salesIncome =targetService.getSalesInCome(salesIncome);
		List<Sales> salesList= salesRepository.findBySalesDateGreaterThanEqualAndSalesDateLessThanEqual(salesIncome.getFromDate(), salesIncome.getToDate());      
		salesIncome=BusinessLogic.getTotalSalesAmount(salesList, salesIncome);
		return salesIncome;
	}
}
