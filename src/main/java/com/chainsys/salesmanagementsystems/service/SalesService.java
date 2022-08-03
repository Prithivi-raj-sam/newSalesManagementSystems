package com.chainsys.salesmanagementsystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.model.Sales;
import com.chainsys.salesmanagementsystems.repository.SalesRepository;

@Service
public class SalesService {
	@Autowired
	private SalesRepository salesRepository;
	
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
}
