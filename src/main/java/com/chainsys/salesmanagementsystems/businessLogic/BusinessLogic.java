package com.chainsys.salesmanagementsystems.businesslogic;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.model.Sales;
import com.chainsys.salesmanagementsystems.model.Target;

public class BusinessLogic {
	private BusinessLogic() {
		
	}
	public static int[] getTotalSalesAndLeadAttribute(List<Target> targetList) {
		Iterator<Target> targetItr=targetList.iterator();
		int plannedLeads=0;
		int commitedLeads=0;
		int plannedSales=0;
		int closedSales=0;
		while(targetItr.hasNext()) {
			Target target=targetItr.next();
			if(target.getTargetCategory().equals("lead")) {
				plannedLeads+=target.getPlannedTarget();
				commitedLeads+=target.getClosedTarget();
			}
			else if(target.getTargetCategory().equals("sales")) {
				plannedSales+=target.getPlannedTarget();
				closedSales+=target.getClosedTarget();
			}
		}
		int[] targetandAchivement=new int[4];
		targetandAchivement[0]=plannedLeads;
		targetandAchivement[1]=commitedLeads;
		targetandAchivement[2]=plannedSales;
		targetandAchivement[3]=closedSales;
		return targetandAchivement;
	}
	
	public static double getTotalSalesAmount(List<Sales> salesList) {
		Iterator<Sales> salesItr=salesList.iterator();
		double totalAmountSales=0;
		while(salesItr.hasNext()) {
			Sales sales=salesItr.next();
			totalAmountSales+=sales.getAmount();
		}
		return totalAmountSales;
	}
//	public static int[] getTotalLeads(List<Target> targetList, List<Lead> leadList) {
//		List<Integer> employeeIdList = leadList.stream().map(Lead::getEmployeeId).collect(Collectors.toList());
//		List<Integer> distinctEmployeeId = employeeIdList.stream().distinct().collect(Collectors.toList());
//		int commitedLeads = 0;
//		int plannedLeads = 0;
//		Iterator<Integer> employeeIdItr = distinctEmployeeId.iterator();
//		Iterator<Target> targetItr = targetList.iterator();
//		while (employeeIdItr.hasNext()) {
//			int employeeId = employeeIdItr.next();
//			while (targetItr.hasNext()) {
//				Target target = targetItr.next();
//				if (target.getEmployeeId() == employeeId) {
//					commitedLeads += target.getClosedTarget();
//					plannedLeads += target.getPlannedTarget();
//				}
//			}
//			targetItr = targetList.iterator();
//		}
//		int[] leadsTarget = new int[2];
//		leadsTarget[0] = plannedLeads;
//		leadsTarget[1] = commitedLeads;
//		return leadsTarget;
//	}
	
}
