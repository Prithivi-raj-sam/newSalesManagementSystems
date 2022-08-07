package com.chainsys.salesmanagementsystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.businessLogic.BusinessLogic;
import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.repository.TargetRepository;

@Service
public class TargetService {
	@Autowired
	private TargetRepository targetRepository;
	@Autowired
	private EmployeeService employeeService;
	public void insertTarget(Target target) {
		targetRepository.save(target);
	}
	public List<Target> allTarget(){
		return targetRepository.findAll();
	}
	public void updateTarget(Target target) {
		targetRepository.save(target);
	}
	public void deleteTarget(int id) {
		targetRepository.deleteById(id);
	}
	public Target getTargetById(int id) {
		return targetRepository.findById(id);
	}
	public SalesInCome getSalesInCome(SalesInCome salesIncome) {
		List<Target>targetList=targetRepository.findByTargetDateGreaterThanEqualAndTargetDateLessThanEqual(salesIncome.getFromDate(), salesIncome.getToDate());   
		return BusinessLogic.getTotalPlansAndAchived(targetList,salesIncome,employeeService);
	}
}
