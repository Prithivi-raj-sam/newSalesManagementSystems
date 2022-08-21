package com.chainsys.salesmanagementsystems.businesslogic;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.model.Sales;
import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.service.AccountService;
import com.chainsys.salesmanagementsystems.service.EmployeeService;
import com.chainsys.salesmanagementsystems.service.LeadService;
import com.chainsys.salesmanagementsystems.service.TargetService;

public class BusinessLogic {
	private BusinessLogic() {

	}

	public static List<String> getEmployeeNameByLead(List<Lead> leadList, EmployeeService employeeService) {
		List<String> employeeNameList = new ArrayList<>();
		List<Employee> employeeList = employeeService.allEmployee();
		for (int i = 0; i < leadList.size(); i++) {
			Lead lead = leadList.get(i);
			Optional<Employee> employeeOptional = employeeList.stream()
					.filter(employee -> employee.getEmployeeId() == lead.getEmployeeId()).findAny();
			if (employeeOptional.isPresent()) {
				employeeNameList.add(employeeOptional.get().getEmployeeName());
			}
		}
		return employeeNameList;
	}

	public static List<String> getAccountNameByLead(List<Lead> leadList, AccountService accountService) {
		List<String> accountName = new ArrayList<>();
		List<Account> accountList = accountService.allAccount();
		for (int i = 0; i < leadList.size(); i++) {
			Lead lead = leadList.get(i);
			Optional<Account> accountOptional = accountList.stream()
					.filter(account -> account.getAccountId() == lead.getAccountId()).findAny();
			if (accountOptional.isPresent()) {
				accountName.add(accountOptional.get().getCompanyName());
			}
		}
		return accountName;
	}

	public static List<String> getAccountNameBySales(List<Sales> salesList, AccountService accountService,
			LeadService leadService) {
		List<String> accountName = new ArrayList<>();
		List<Account> accountList = accountService.allAccount();
		for (int i = 0; i < salesList.size(); i++) {
			Sales sales = salesList.get(i);
			Lead lead = leadService.getLeadById(sales.getLeadId());
			Optional<Account> accountOptional = accountList.stream()
					.filter(account -> account.getAccountId() == lead.getAccountId()).findAny();
			if (accountOptional.isPresent()) {
				accountName.add(accountOptional.get().getCompanyName());
			}
		}
		return accountName;
	}

	public static List<String> getEmployeeNameBySales(List<Sales> salesList, EmployeeService employeeService) {
		List<String> employeeName = new ArrayList<>();
		List<Employee> employeeList = employeeService.allEmployee();
		for (int i = 0; i < salesList.size(); i++) {
			Sales sales = salesList.get(i);
			Optional<Employee> employeeOptional = employeeList.stream()
					.filter(employee -> employee.getEmployeeId() == sales.getEmployeeId()).findAny();
			if (employeeOptional.isPresent()) {
				employeeName.add(employeeOptional.get().getEmployeeName());
			}
		}
		return employeeName;
	}

	public static List<String> getEmployeeName(List<Employee> allEmpoyee) {
		return allEmpoyee.stream().map(Employee::getEmployeeName).collect(Collectors.toList());

	}

	public static Date getDateBeforeAMonth(Date date) {
		LocalDate monthBefore = date.toLocalDate().minusDays(30);
		return Date.valueOf(monthBefore);
	}

	public static List<String> getSalesDetailsByLeads(Sales sales, AccountService accountService,
			EmployeeService employeeService, LeadService leadService) {
		List<String> salesDetail = new ArrayList<>();
		Lead lead = leadService.getLeadById(sales.getLeadId());
		Account account = accountService.getAccountById(lead.getAccountId());
		Employee employee = employeeService.getEmployeeById(sales.getEmployeeId());
		salesDetail.add(account.getCompanyName());
		salesDetail.add(employee.getEmployeeName());
		return salesDetail;
	}

	public static int[] getTotalSalesAndLeadAttribute(List<Target> targetList) {
		int plannedLeads = 0;
		int commitedLeads = 0;
		int plannedSales = 0;
		int closedSales = 0;
		for (int i = 0; i < targetList.size(); i++) {
			Target target = targetList.get(i);
			if (target.getTargetCategory().equals("lead")) {
				plannedLeads += target.getPlannedTarget();
				commitedLeads += target.getClosedTarget();
			} else if (target.getTargetCategory().equals("sales")) {
				plannedSales += target.getPlannedTarget();
				closedSales += target.getClosedTarget();
			}
		}
		int[] targetandAchivement = new int[4];
		targetandAchivement[0] = plannedLeads;
		targetandAchivement[1] = commitedLeads;
		targetandAchivement[2] = plannedSales;
		targetandAchivement[3] = closedSales;
		return targetandAchivement;
	}

	public static double getTotalSalesAmount(List<Sales> salesList) {
		double totalAmountSales = 0;
		for (int i = 0; i < salesList.size(); i++) {
			Sales sales = salesList.get(i);
			totalAmountSales += sales.getAmount();
		}
		return totalAmountSales;
	}

	public static Date getInstanceDate() {
		LocalDate localDate = java.time.LocalDate.now();
		return Date.valueOf(localDate);
	}

	public static Target updateClosedTarget(List<Target> targetList, String category) {
		Target updatedTarget = null;
		for (int i = 0; i < targetList.size(); i++) {
			updatedTarget = targetList.get(i);
			if (updatedTarget.getTargetCategory().equals(category)) {
				updatedTarget.setClosedTarget(updatedTarget.getClosedTarget() + 1);
				break;
			}
		}
		return updatedTarget;
	}

	public static int monthsCount(Date startDate, Date enddate) {
		long monthsBetween = ChronoUnit.MONTHS.between(startDate.toLocalDate().withDayOfMonth(1),
				enddate.toLocalDate().withDayOfMonth(1));
		return (int) monthsBetween + 1;
	}

	public static List<SalesInCome> getMonthlySaleIncome(List<Sales> salesList, SalesInCome salesIncome) {
		int monthCount = monthsCount(salesIncome.getFromDate(), salesIncome.getToDate());
		List<SalesInCome> salesInComeList = new ArrayList<>();
		SalesInCome salesInCome = null;
		Date calDate = null;
		Date[] dateArray = null;
		for (int i = 0; i < monthCount; i++) {
			salesInCome = new SalesInCome();
			calDate = nextmonth(salesIncome.getFromDate(), i);
			dateArray = getFirstAndLastdayOfMonth(calDate, calDate);
			double totalAmount = 0;
			for (int j = 0; j < salesList.size(); j++) {
				Sales sales = salesList.get(j);
				if (sales.getSalesDate().compareTo(dateArray[0]) > 0
						&& sales.getSalesDate().compareTo(dateArray[1]) < 0) {
					totalAmount += sales.getAmount();
				}
			}
			salesInCome.setFromDate(dateArray[0]);
			salesInCome.setToDate(dateArray[1]);
			salesInCome.setTotalSalesAmount(totalAmount);
			salesInComeList.add(salesInCome);
		}
		return salesInComeList;
	}

	public static List<Sales> getHighSalesGroupByEmployeeId(List<Sales> salesList, List<Employee> employeeList) {
		List<Sales> highsalesList = new ArrayList<>();
		Sales sales = null;
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getRole().equals("salesman")) {
				sales = new Sales();
				sales.setAmount(0);
				sales.setEmployeeId(employeeList.get(i).getEmployeeId());
				for (int j = 0; j < salesList.size(); j++) {
					if (salesList.get(j).getEmployeeId() == sales.getEmployeeId()) {
						sales.setAmount(sales.getAmount() + salesList.get(j).getAmount());
					}
				}
				highsalesList.add(sales);
			}
		}
		return highsalesList;

	}
	public static List<Account> getTotalAccountOfEmployees(List<Account>accountList,List<Employee>employeeList){
		List<Account>accountCountList=new ArrayList<>();
		Account accounCount=null;
		for(int i=0;i<employeeList.size();i++) {
			Employee employee=employeeList.get(i);
			if(employee.getRole().equalsIgnoreCase("marketer")) {
				accounCount=new Account();
				long count=accountList.stream().filter(account->account.getEmployeeId()==employee.getEmployeeId()).count();
				accounCount.setEmployeeId(employee.getEmployeeId());
				accounCount.setAccountId((int)count);
				accountCountList.add(accounCount);
			}
		}
		return accountCountList;
	}
	public static Date nextmonth(Date date, int increament) {
		LocalDate localdate = date.toLocalDate();
		return Date.valueOf(LocalDate.of(localdate.getYear(), localdate.getMonthValue() + increament, 10));
	}

	public static List<SalesInCome> getMonthlyTarget(TargetService targetService, List<SalesInCome> salesInComeList) {

		SalesInCome salesInCome = null;
		for (int i = 0; i < salesInComeList.size(); i++) {
			salesInCome = salesInComeList.get(i);
			List<Target> targetList = targetService.getTargetByTwoDate(salesInCome.getFromDate(),
					salesInCome.getToDate());
			int plannedLeads = 0;
			int commitedLeads = 0;
			int plannedSales = 0;
			int closedSales = 0;
			for (int j = 0; j < targetList.size(); j++) {
				Target target = targetList.get(j);
				if (target.getTargetDate().compareTo(salesInCome.getFromDate()) > 0
						&& target.getTargetDate().compareTo(salesInCome.getToDate()) < 0) {
					if (target.getTargetCategory().equals("lead")) {
						plannedLeads += target.getPlannedTarget();
						commitedLeads += target.getClosedTarget();
					} else if (target.getTargetCategory().equals("sales")) {
						plannedSales += target.getPlannedTarget();
						closedSales += target.getClosedTarget();
					}
				}

			}
			salesInCome.setClosedSales(closedSales);
			salesInCome.setPlannedSales(plannedSales);
			salesInCome.setCommitedLeads(commitedLeads);
			salesInCome.setPlannedLeads(plannedLeads);
		}
		return salesInComeList;
	}

	public static Date[] getFirstAndLastdayOfMonth(Date startdate, Date endingDate) {
		LocalDate endDate = endingDate.toLocalDate();
		endDate = endDate.withDayOfMonth(endDate.getMonth().length(endDate.isLeapYear()));
		LocalDate firstDate = startdate.toLocalDate();
		firstDate = firstDate.withDayOfMonth(1);
		Date[] dateArray = new Date[2];
		dateArray[0] = Date.valueOf(firstDate);
		dateArray[1] = Date.valueOf(endDate);
		return dateArray;
	}

	public static List<Target> getTodayTarget(List<Target> targetList) {
		return targetList.stream().filter(target -> target.getTargetDate().compareTo(getInstanceDate()) > 0)
				.collect(Collectors.toList());
	}

}
