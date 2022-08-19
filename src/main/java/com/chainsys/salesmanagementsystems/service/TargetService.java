package com.chainsys.salesmanagementsystems.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.repository.TargetRepository;

@Service
public class TargetService {
	@Autowired
	private TargetRepository targetRepository;
	public void insertTarget(Target target) {
		targetRepository.save(target);
	}
	public List<Target> getTargetByEMployeeId(int id){
		return targetRepository.findByEmployeeId(id);
	}
	public List<Target> allTarget(){
		return targetRepository.findAll();
	}
	public void updateTarget(Target target) {
		targetRepository.save(target);
	}
	public List<Target> getTargetByDescendingOrder(int id){
		return targetRepository.findByEmployeeIdOrderByTargetDateDesc(id);
	}
	public List<Target>getTargetByDescindingOrderDate(){
		return targetRepository.findAllByOrderByTargetDateDesc();
	}
	public void deleteTarget(int id) {
		targetRepository.deleteById(id);
	}
	public Target getTargetById(int id) {
		return targetRepository.findById(id);
	}
	public List<Target> getSalesInCome(SalesInCome salesIncome) {
		return  targetRepository.findByTargetDateGreaterThanEqualAndTargetDateLessThanEqual(salesIncome.getFromDate(), salesIncome.getToDate());   
	}
	public List<Target> getTargetByTwoDate(Target target){
		return targetRepository.findByTargetDateGreaterThanEqualAndTargetDateLessThanEqual(target.getTargetDate(), target.getTargetSetDate());
	}
	public List<Target> getTargetByTwoDate(Date startdate,Date endDate){
		return targetRepository.findByTargetDateGreaterThanEqualAndTargetDateLessThanEqual(startdate,endDate);
	}
}
