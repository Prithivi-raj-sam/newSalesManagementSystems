package com.chainsys.salesmanagementsystems.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	
	
	
	@GetMapping("/alltargets")
	public String allTargets(Model model) {
		List<Target>allTarget = targetService.allTarget();
		model.addAttribute("alltarget", allTarget);
		return "all-targets";
	}
	@GetMapping("/addtargetform")
	public String addTargetForm(Model model) {
		Target target=new Target();
		model.addAttribute("addtarget", target);
		return "add-target-form";
	}
	@PostMapping("/addtarget")
	public String addTarget(@ModelAttribute("addtarget")Target target,Model model) {
		targetService.insertTarget(target);
		return "add-target-form";
	}
	@PostMapping("/gettarget")
	public String getTargetById(@ModelAttribute("getId")GetId id,Model model) {
		Target target=targetService.getTargetById(id.getId());
		model.addAttribute("target", target);
		return "get-target-id";
	}
	@PostMapping("/deleteTarget")
	public String deleteTarget(@ModelAttribute("getId")GetId id, Model model) {
		targetService.deleteTarget(id.getId());
		return "redirect:/target/alltargets";
	}
	@PostMapping("/updatetargetform")
	public String updateTargetForm(@ModelAttribute("getId")GetId id,Model model) {
		Target target=targetService.getTargetById(id.getId());
		model.addAttribute("updatetarget", target);
		return "update-target-form";
	}
	@PostMapping("/updatetarget")
	public String updatetarget(@ModelAttribute("updatetarget")Target target,Model model) {
		targetService.updateTarget(target);
		return "update-target-form";
	}
}
