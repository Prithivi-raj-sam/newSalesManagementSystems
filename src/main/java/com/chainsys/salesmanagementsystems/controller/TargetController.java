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

import com.chainsys.salesmanagementsystems.model.Target;
import com.chainsys.salesmanagementsystems.service.TargetService;

@Controller
@RequestMapping("/target")
public class TargetController {
	@Autowired
	private TargetService targetService;
	
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
	@GetMapping("/gettarget")
	public String getTargetById(@RequestParam("id")int id,Model model) {
		Target target=targetService.getTargetById(id);
		model.addAttribute("target", target);
		return "get-target-id";
	}
	@GetMapping("/deleteTarget")
	public String deleteTarget(@RequestParam("id")int id, Model model) {
		targetService.deleteTarget(id);
		return "redirect:/target/alltargets";
	}
	@GetMapping("/updatetargetform")
	public String updateTargetForm(@RequestParam("id")int id,Model model) {
		Target target=targetService.getTargetById(id);
		model.addAttribute("updatetarget", target);
		return "update-target-form";
	}
	@PostMapping("/updatetarget")
	public String updatetarget(@ModelAttribute("updatetarget")Target target,Model model) {
		targetService.updateTarget(target);
		return "update-target-form";
	}
}
