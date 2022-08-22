package com.chainsys.salesmanagementsystems.controller;


import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.salesmanagementsystems.businesslogic.BusinessLogic;
import com.chainsys.salesmanagementsystems.model.SalesInCome;
import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.service.EmployeeService;
import com.chainsys.salesmanagementsystems.service.TargetService;
import com.chainsys.salesmanagementsystems.validation.InvalidInputDataException;

@Controller
@RequestMapping("/target")
public class TargetController {
	private static final String ALLTARGET="all-targets";
	private static final String ALLTARGETMODEL="alltargets";
	private static final String ERROR="error";
	private static final String ERRORPAGE="error-page";
	private static final String RESULT="result";
	private static final String MESSAGE="message";
	private static final String EMPLOYEENAME="employeeName";
	private static final String EmployeeId="employeeId";
	
	@Autowired
	private TargetService targetService;
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/alltargets")//need
	public String allTargets(Model model) {
		List<Target>allTarget =null;
		try {
			allTarget = targetService.allTarget();
			if(allTarget==null)
				throw new InvalidInputDataException("Cannot Find Target Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>employeeName=employeeService.getempNameByTarget(allTarget);
		model.addAttribute(EMPLOYEENAME, employeeName);
		model.addAttribute(ALLTARGETMODEL, allTarget);
		return ALLTARGET;
	}
	@GetMapping("/alltargetbyEmployeeid")//need
	public String getAlltargetsByEmployeeId(HttpServletRequest request,Model model) {
		HttpSession session= request.getSession();
		int employeeId=(int)session.getAttribute(EmployeeId);
		List<Target> targetList=null;
		try {
			targetList=targetService.getTargetByEMployeeId(employeeId);
			if(targetList==null)
				throw new InvalidInputDataException("Cannot Find All Target list");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		model.addAttribute("targetList", targetList);
		return "employees-target";
	}
	@PostMapping("/alltargetfortwodates")//need
	public String getTargetBetweenTwoDates(@ModelAttribute("salesInCome")SalesInCome salesInCome,Model model,HttpServletRequest request) {
		List<Target>targetList =null;
		try {
			targetList =targetService.getSalesInCome(salesInCome);
			if(targetList==null)
				throw new InvalidInputDataException("Cannot Find All Target list");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<Target>employeetargetList= null;
		HttpSession session= request.getSession();
		int employeeId=(int)session.getAttribute(EmployeeId);
		try {
			employeetargetList= targetList.stream()
					  .filter(target-> target.getEmployeeId()==employeeId)
					  .collect(Collectors.toList());
			if(employeetargetList==null)
				throw new InvalidInputDataException("Cannot Extract EmployeeTarget List");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute("targetList", employeetargetList);
		return "employees-target";
	}
	@GetMapping("/addtargetform")//need
	public String addTargetForm(@RequestParam("id")int id,Model model) {
		Target target=new Target();
		target.setTargetSetDate(BusinessLogic.getInstanceDate());
		target.setEmployeeId(id);
		model.addAttribute("addtarget", target);
		return "add-target-form";
	}
	@PostMapping("/addtarget")//need
	public String addTarget(@ModelAttribute("addtarget")Target target,Model model) {
		try {
			targetService.insertTarget(target);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		return "add-target-form";
	}
	@GetMapping("/gettarget")//need
	public String getTargetById(@RequestParam("targetId")int targetId,Model model) {
		Target target=null;
		try {
			target=targetService.getTargetById(targetId);
			if(target==null)
				throw new InvalidInputDataException("Cannot Fetch Target Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute("target", target);
		return "get-target-id";
	}
	@GetMapping("/deleteTarget")//need
	public String deleteTarget(@RequestParam("targetId")int targetId, Model model) {
		try {
			targetService.deleteTarget(targetId);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		return "redirect:/target/alltargets";
	}
	@GetMapping("/updatetargetform")//need
	public String updateTargetForm(@RequestParam("targetId")int targetId,Model model) {
		Target target=null;
		try {
			target=targetService.getTargetById(targetId);
			if(target==null)
				throw new InvalidInputDataException("Cannot Fetch Target Data");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
	
		model.addAttribute("updatetarget", target);
		return "update-target-form";
	}
	@PostMapping("/updatetarget")//need
	public String updatetarget(@ModelAttribute("updatetarget")Target target, Model model) {
		try {
			targetService.updateTarget(target);
		}catch(Exception exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		return "update-target-form";
	}
	@PostMapping("/gettargetbydate")//need
	public String getTaretByTargetDateAndTargetSetdate(@ModelAttribute("target")Target target,Model model) {
		List<Target> targetList=null;
		try {
			targetList=targetService.getTargetByTwoDate(target);
			if(targetList==null)
				throw new InvalidInputDataException("Cannot Find Target List Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		model.addAttribute(ALLTARGETMODEL, targetList);
		List<String>employeeName=employeeService.getempNameByTarget(targetList);
		model.addAttribute(EMPLOYEENAME, employeeName);
		return ALLTARGET;
	}
	@GetMapping("/goingtarget")//need
	public String getCurrentTarget(HttpServletRequest request,Model model) {
		HttpSession session= request.getSession();
		int employeeId=(int)session.getAttribute(EmployeeId);
		List<Target> targetList=null;
		try {
			targetList=targetService.getTargetByDescendingOrder(employeeId);
			if(targetList==null)
				throw new InvalidInputDataException("Cannot Fetch Target Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		
		Target target=targetList.get(0);
		model.addAttribute("target", target);
		return "current-target";
	}
	@GetMapping("/todaytarget")//need
	public String getTodayTarget(Model model) {
		List<Target> targetList=null;
		try {
			targetList=targetService.getTargetByDescindingOrderDate();
			if(targetList==null)
				throw new InvalidInputDataException("Cannot Fetch target Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		try {
			targetList=BusinessLogic.getTodayTarget(targetList);
			if(targetList==null)
				throw new InvalidInputDataException("Cannot Fetch Today target Details");
		}catch(InvalidInputDataException exp) {
			model.addAttribute(ERROR, exp.getMessage());
			model.addAttribute(RESULT, MESSAGE);
			return ERRORPAGE;
		}
		List<String>employeeName=employeeService.getempNameByTarget(targetList);
		model.addAttribute(EMPLOYEENAME, employeeName);
		model.addAttribute(ALLTARGETMODEL, targetList);
		return ALLTARGET;
	}
}
