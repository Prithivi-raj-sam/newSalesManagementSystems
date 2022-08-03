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

import com.chainsys.salesmanagementsystems.model.Territory;
import com.chainsys.salesmanagementsystems.service.TerritoryService;

@Controller
@RequestMapping("/territory")
public class TerritoryController {
	@Autowired
	private TerritoryService territoryService;
	
	@GetMapping("/addterritoryform")
	public String addTerritoryForm(Model model) {
		Territory territory=new Territory();
		model.addAttribute("addterritory", territory);
		return "add-territory-form";
	}
	@PostMapping("/addterritory")
	public String addTerritory(@ModelAttribute("addterritory")Territory ter,Model model) {
		territoryService.insertTerritory(ter);
		return "add-territory-form";
	}
	@GetMapping("/getterritory")
	public String getTerritory(@RequestParam("id")int id,Model model) {
		Territory territory=territoryService.getTerritoryById(id);
		model.addAttribute("territory", territory);
		return "get-territory-id";
	}
	@GetMapping("/deleteterritory")
	public String deleteTerritory(@RequestParam("id")int id,Model model) {
		territoryService.deleteTerritory(id);
		return "redirect:/territories/allterritory";
	}
	@GetMapping("/allterritory")
	public String allTerritory(Model model) {
		List<Territory>allterritory =territoryService.allTerritory();
		model.addAttribute("allteritory", allterritory);
		return "all-territory";
	}
	@GetMapping("/updateterritoryform")
	public String updateTerritoryForm(@RequestParam("id")int id,Model model) {
		Territory ter=territoryService.getTerritoryById(id);
		model.addAttribute("updateTerritory", ter);
		return "update-territory-form";
	}
	@PostMapping("/updateterritory")
	public String updateTerritory(@ModelAttribute("updateTerritory")Territory ter,Model model) {
		territoryService.updateTerritory(ter);
		return "update-territory-form";
	}
}
