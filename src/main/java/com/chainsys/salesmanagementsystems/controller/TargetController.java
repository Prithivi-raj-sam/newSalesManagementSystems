package com.chainsys.salesmanagementsystems.controller;


import java.util.List;
import java.util.stream.Collectors;


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
import com.chainsys.salesmanagementsystems.service.TargetService;

@Controller
@RequestMapping("/target")
public class TargetController {
	private static final String ALLTARGET="all-targets";
	private static final String ALLTARGETMODEL="alltargets";
	
	@Autowired
	private TargetService targetService;
	
	
	@GetMapping("/alltargets")//need
	public String allTargets(Model model) {
		List<Target>allTarget = targetService.allTarget();
		model.addAttribute(ALLTARGETMODEL, allTarget);
		return ALLTARGET;
	}
	@GetMapping("/alltargetbyEmployeeid")//need
	public String getAlltargetsByEmployeeId(@RequestParam("empId") int empId,Model model) {
		List<Target> targetList=targetService.getTargetByEMployeeId(empId);
		model.addAttribute("targetList", targetList);
		return "employees-target";
	}
	@PostMapping("/alltargetfortwodates")//need
	public String getTargetBetweenTwoDates(@ModelAttribute("salesInCome")SalesInCome salesInCome,Model model) {
		List<Target>targetList =targetService.getSalesInCome(salesInCome);
		List<Target>employeetargetList= targetList.stream()
		  .filter(target-> target.getEmployeeId()==salesInCome.getCommitedLeads())
		  .collect(Collectors.toList());
		model.addAttribute("targetList", employeetargetList);
		model.addAttribute("empId", salesInCome.getCommitedLeads());
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
		targetService.insertTarget(target);
		return "add-target-form";
	}
	@GetMapping("/gettarget")//need
	public String getTargetById(@RequestParam("targetId")int targetId,Model model) {
		Target target=targetService.getTargetById(targetId);
		model.addAttribute("target", target);
		return "get-target-id";
	}
	@GetMapping("/deleteTarget")//need
	public String deleteTarget(@RequestParam("targetId")int targetId, Model model) {
		targetService.deleteTarget(targetId);
		return "redirect:/target/alltargets";
	}
	@GetMapping("/updatetargetform")//need
	public String updateTargetForm(@RequestParam("targetId")int targetId,Model model) {
		Target target=targetService.getTargetById(targetId);
		model.addAttribute("updatetarget", target);
		return "update-target-form";
	}
	@PostMapping("/updatetarget")//need
	public String updatetarget(@ModelAttribute("updatetarget")Target target, Model model) {
		targetService.updateTarget(target);
		return "update-target-form";
	}
	@PostMapping("/gettargetbydate")//need
	public String getTaretByTargetDateAndTargetSetdate(@ModelAttribute("target")Target target,Model model) {
		List<Target> targetList=targetService.getTargetByTwoDate(target);
		model.addAttribute(ALLTARGETMODEL, targetList);
		return ALLTARGET;
	}
	@GetMapping("/goingtarget")//need
	public String getCurrentTarget(@RequestParam("empId") int empId,Model model) {
		List<Target> targetList=targetService.getTargetByDescendingOrder(empId);
		Target target=targetList.get(0);
		model.addAttribute("target", target);
		return "current-target";
	}
	@GetMapping("/todaytarget")//need
	public String getTodayTarget(Model model) {
		List<Target> targetList=targetService.getTargetByDescindingOrderDate();
		targetList=BusinessLogic.getTodayTarget(targetList);
		model.addAttribute(ALLTARGETMODEL, targetList);
		return ALLTARGET;
	}
}
