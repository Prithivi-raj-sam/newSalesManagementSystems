package com.chainsys.salesmanagementsystems.businesslogic;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Lead;
import com.chainsys.salesmanagementsystems.model.Sales;
import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.model.Target;

public class BusinessLogic {
	private BusinessLogic() {
		
	}
	public static int[] getTotalSalesAndLeadAttribute(List<Target> targetList) {
		int plannedLeads=0;
		int commitedLeads=0;
		int plannedSales=0;
		int closedSales=0;
		for(int i=0;i<targetList.size();i++) {
			Target target=targetList.get(i);
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
	public static Date getInstanceDate() {
        Calendar vcalendar=Calendar.getInstance();
        String dates =  vcalendar.get(Calendar.DATE) + "/" + (vcalendar.get(Calendar.MONTH)+1) + "/" + vcalendar.get(Calendar.YEAR);
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date date=null;
        try {
            date=new java.sql.Date(dateFormat.parse(dates).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
	public static Target updateClosedTarget(List<Target>targetList,String category) {
		Target updatedTarget=null;
		for(int i=0;i<targetList.size();i++) {
			updatedTarget=targetList.get(i);
			if(updatedTarget.getTargetCategory().equals(category)) {
				updatedTarget.setClosedTarget(updatedTarget.getClosedTarget()+1);
				break;
			}
		}
		return updatedTarget;
	}
	public static Date fromDateCalculation(Date payslipDate) {
        String stringDate=payslipDate+"";
        String[] dateArray=stringDate.split("-");
        int month=Integer.parseInt(dateArray[1]);
        int year=Integer.parseInt(dateArray[0]);
      
        String startDateString="01"+"/"+month+"/"+year;
        
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date startdate=null;
        try {
            java.util.Date date1=simpleDateFormat.parse(startDateString);
            startdate=new java.sql.Date(date1.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return startdate;
    }
	public static Date toDateCalculation(Date payslipDate) {
        String stringDate=payslipDate+"";
        String[] dateArray=stringDate.split("-");
        int month=Integer.parseInt(dateArray[1]);
        int year=Integer.parseInt(dateArray[0]);
        
        String endDate=null;
        if(month==1||month==3|| month==5|| month==7||month==8|| month==10|| month==12) {
            endDate="31"+"/"+month+"/"+year;
        }
        else if(month==4||month==6|| month==9|| month==11) {
            endDate="30"+"/"+month+"/"+year;
        }
        else {
            if(year%4==0) {
                endDate="29"+"/"+month+"/"+year;
            }
            else
                endDate="28"+"/"+month+"/"+year;
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date enddate=null;
        try {
            java.util.Date date2=simpleDateFormat.parse(endDate);
            enddate=new java.sql.Date(date2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return enddate;
    }
	public List<SalesInCome> getMonthlySaleIncome(List<Sales> salesList,SalesInCome salesIncome){
		List<SalesInCome>salesInComeList=new ArrayList<>();
		SalesInCome salesInCome=new SalesInCome();
		double totalAmountSales=0;
		for(int i=0;i<salesList.size();i++) {
			boolean nextmonth=findSameMonth(salesList.get(i).getSalesDate(),salesList.get(i+1).getSalesDate());
			if(nextmonth) {
				salesInCome.setTotalSalesAmount(totalAmountSales);
				salesInComeList.add(salesInCome);
				totalAmountSales=0;
			}
			totalAmountSales+=salesList.get(i).getAmount();
		}
		return salesInComeList;
	}
	public static int monthsCount(){
		long monthsBetween = ChronoUnit.MONTHS.between(
		        LocalDate.parse("2016-08-31").withDayOfMonth(1),
		        LocalDate.parse("2016-11-30").withDayOfMonth(1));
		return (int)monthsBetween;
	}
	public static Date nextmonth(Date date) {
		LocalDate localdate=date.toLocalDate();
		return Date.valueOf(LocalDate.of(localdate.getYear(),localdate.getMonthValue()+1, 10));
	}
	public boolean findSameMonth(Date date1,Date date2) {
		boolean result=false;
		
		String stringDate1=date1+"";
        String[] dateArray=stringDate1.split("-");
        int month1=Integer.parseInt(dateArray[1]);
        
        String stringDate2=date2+"";
        String[] dateArray2=stringDate2.split("-");
        int month2=Integer.parseInt(dateArray2[1]);
        if(month1!=month2) {
        	result=true;
        }
		return result;
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
	public static Date[] getFirstAndLastdayOfMonth(Date date) {
		LocalDate convertedDate =date.toLocalDate();
		convertedDate = convertedDate.withDayOfMonth(
		 convertedDate.getMonth().length(convertedDate.isLeapYear()));
//		LocalDate convertedDate2=LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy"));
		LocalDate convertedDate2=convertedDate.withDayOfMonth(1);
		System.out.println(convertedDate2);
		
	}
	public static void main(String[] args) {
		
	}
	
}
