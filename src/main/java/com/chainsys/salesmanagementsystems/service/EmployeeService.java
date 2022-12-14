package com.chainsys.salesmanagementsystems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.salesmanagementsystems.businesslogic.BusinessLogic;
import com.chainsys.salesmanagementsystems.dto.AccountsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.LeadsEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.SalesEmployeeDTO;
import com.chainsys.salesmanagementsystems.dto.TargetEmployeeDTO;
import com.chainsys.salesmanagementsystems.model.Account;
import com.chainsys.salesmanagementsystems.model.Employee;
import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.repository.AccountRepository;
import com.chainsys.salesmanagementsystems.repository.EmployeeRepository;
import com.chainsys.salesmanagementsystems.repository.LeadRepository;
import com.chainsys.salesmanagementsystems.repository.SalesRepository;
import com.chainsys.salesmanagementsystems.repository.TargetRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private LeadRepository leadRepository;
	@Autowired
	private SalesRepository salesRepository;
	@Autowired
	private TargetRepository targetRepository;
	
	public void insertEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	public List<Employee> allEmployee(){
		return employeeRepository.findAll();
	}
	public List<Employee> getEmployeeByName(String name){
		return employeeRepository.findByEmployeeName(name);
	}
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
	public Employee getEmployeeByEmployeeIdAndPassrd(int id,String password) {
		return employeeRepository.findByEmployeeIdAndPassword(id, password);
	}
	public AccountsEmployeeDTO getAccountsandEmployee(int id) {
		AccountsEmployeeDTO dto=new AccountsEmployeeDTO();
		dto.setEmployee(getEmployeeById(id));
		dto.setAccountList(accountRepository.findByEmployeeEmployeeId(id));
		return dto;
	}
	public LeadsEmployeeDTO getLeadsAndEmployee(int id) {
		LeadsEmployeeDTO dto=new LeadsEmployeeDTO();
		dto.setEmployee(getEmployeeById(id));
		dto.setLeadlist(leadRepository.findByEmployeeEmployeeId(id));
		return dto;
	}
	public SalesEmployeeDTO getSalesEmployee(int id) {
		SalesEmployeeDTO dto=new SalesEmployeeDTO();
		dto.setEmployee(getEmployeeById(id));
		dto.setSalesList(salesRepository.findByEmployeeEmployeeId(id));
		return dto;
	}
	public TargetEmployeeDTO getTargetsAndEmployee(int id) {
		TargetEmployeeDTO dto=new TargetEmployeeDTO();
		dto.setEmployee(getEmployeeById(id));
		dto.setTargetList(targetRepository.findByEmployeeId(id));
		return dto;
	}
	public byte[] getEmployeeImageByteArray(int id) {
        Employee empPhoto = employeeRepository.findById(id);
        byte[] imageBytes = null;
            
            if(empPhoto != null)
            {
                imageBytes = empPhoto.getProfile();
            }   
        return imageBytes;
    }
	public List<String> getEmployeeNamesByEmployeeId(List<Account>accountList){
		List<String>employeeNameList=new ArrayList<>();
		List<Employee> employeeList=employeeRepository.findAll();
		for(int i=0;i<accountList.size();i++) {
			Account account =accountList.get(i);
			Optional<Employee> employeeNameObject=employeeList.stream().filter(employee->employee.getEmployeeId()==account.getEmployeeId()).findAny();
			if (employeeNameObject.isPresent()) {
			employeeNameList.add(employeeNameObject.get().getEmployeeName());
			}
		}
		return employeeNameList;
	}
	 public List<String>getEmployeeName(List<Integer>employeeIdList){
		   return BusinessLogic.getEmployeeName(employeeRepository.findByEmployeeIdIn(employeeIdList));
	   }
	 public List<Account>getAccountCountByEmployees(){
		 List<Employee> employeeList=allEmployee();
		 List<Account> accountList=
				 accountRepository.findByCustomerJoinDateGreaterThanEqualAndCustomerJoinDateLessThanEqual(BusinessLogic.getDateBeforeAMonth(BusinessLogic.getInstanceDate()), BusinessLogic.getInstanceDate());
		 return BusinessLogic.getTotalAccountOfEmployees(accountList, employeeList);
	 }
	 public List<String>getempNameByTarget(List<Target>targetList){
		 List<Integer>empId=targetList.stream().map(Target::getEmployeeId).collect(Collectors.toList());
		 List<String>employeeName=new ArrayList<>();
		 List<Employee> employeeList=allEmployee();
		 for(int i=0;i<empId.size();i++) {
			 for(int j=0;j<employeeList.size();j++) {
				 if(empId.get(i)==employeeList.get(j).getEmployeeId())
					 employeeName.add(employeeList.get(j).getEmployeeName());
			 }
		 }
		return 	employeeName;
			
	 }
	 
}
