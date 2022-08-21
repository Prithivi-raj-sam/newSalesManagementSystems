package com.chainsys.salesmanagementsystems.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.salesmanagementsystems.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
	Employee save(Employee employee);
	List<Employee> findAll();
	Employee findById(int id);
	void deleteById(int id);
	List<Employee> findByTerritoryTerritoryId(int id);
	Employee findByEmployeeIdAndPassword(int employeeId,String passward);
	List<Employee> findByEmployeeName(String name);
	List<Employee> findByEmployeeIdIn(List<Integer>employeeIdList);
}
