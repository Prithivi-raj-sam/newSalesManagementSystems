package com.chainsys.salesmanagementsystems.controller;


import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.salesmanagementsystems.model.GetId;
import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.service.TargetService;

@Controller
@RequestMapping("/target")
public class TargetController {
	@Autowired
	private TargetService targetService;
	
	
	@GetMapping("/getId")
	public String getTargetId(Model model) {
		model.addAttribute("redirect", "gettarget");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/updateId")
	public String updateTargetId(Model model) {
		model.addAttribute("redirect", "updatetargetform");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	@GetMapping("/deleteId")
	public String deleteTargetById(Model model) {
		model.addAttribute("redirect", "deleteTarget");
		GetId getId=new GetId();
		model.addAttribute("getId", getId);
		return "get-id";
	}
	
	
	
	
	
	@GetMapping("/alltargets")//need
	public String allTargets(Model model) {
		List<Target>allTarget = targetService.allTarget();
		model.addAttribute("alltargets", allTarget);
		return "all-targets";
	}
	@GetMapping("/addtargetform")//need
	public String addTargetForm(Model model) {
		Target target=new Target();
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
	@GetMapping("/updatetargetform")
	public String updateTargetForm(@RequestParam("targetId")int targetId,Model model) {
		Target target=targetService.getTargetById(targetId);
		model.addAttribute("updatetarget", target);
		return "update-target-form";
	}
	@PostMapping("/updatetarget")
	public String updatetarget(@ModelAttribute("updatetarget")Target target, Model model) {
		targetService.updateTarget(target);
		return "update-target-form";
	}
	@PostMapping("/gettargetbydate")
	public String getTaretByTargetDateAndTargetSetdate(@ModelAttribute("target")Target target,Model model) {
		List<Target> targetList=targetService.getTargetByTwoDate(target);
		model.addAttribute("targetList", targetList);
		return "all-targets";
	}
}
