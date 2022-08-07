package com.chainsys.salesmanagementsystems.businessLogic;

import java.util.Iterator;
import java.util.List;

import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.model.Sales;
import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.service.EmployeeService;

public class BusinessLogic {
	public static SalesInCome getTotalPlansAndAchived(List<Target>targetList,SalesInCome salesIncome,EmployeeService employeeService) {
		Iterator<Target> targetItr=targetList.iterator();
		int totalLeads=0;
		int totalSales=0;
		int plannedSales=0;
		int plannedLeads=0;
		while(targetItr.hasNext()) {
			Target target=targetItr.next();
			String role=employeeService.getEmployeeById(target.getEmployeeId()).getRole();
			if(role.equalsIgnoreCase("marketer")) {
				totalLeads+=target.getClosedTarget();
				plannedLeads+=target.getPlannedTarget();
			}
			else if(role.equalsIgnoreCase("salesman")) {
				totalSales+=target.getClosedTarget();
				plannedSales+=target.getPlannedTarget();
			}
		}
		salesIncome.setClosedSales(totalSales);
		salesIncome.setCommitedLeads(totalLeads);
		salesIncome.setPlannedLeads(plannedLeads);
		salesIncome.setPlannedSales(plannedSales);
		return salesIncome;
	}
	public static SalesInCome getTotalSalesAmount(List<Sales> salesList,SalesInCome salesIncome) {
		Iterator<Sales> salesItr=salesList.iterator();
		int totalAmountSales=0;
		while(salesItr.hasNext()) {
			Sales sales=salesItr.next();
			totalAmountSales+=sales.getAmount();
		}
		salesIncome.setTotalSalesAmount(totalAmountSales);
		return salesIncome;
	}
}
