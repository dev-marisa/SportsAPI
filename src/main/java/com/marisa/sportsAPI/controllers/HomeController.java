package com.marisa.sportsAPI.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.marisa.sportsAPI.models.Sport;
import com.marisa.sportsAPI.models.Team;
import com.marisa.sportsAPI.services.SportsAPIService;

@Controller
public class HomeController {

	private SportsAPIService sportServ;
	
	public HomeController(SportsAPIService sportServ) {
		this.sportServ = sportServ;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("aSport", new Sport());
		model.addAttribute("aTeam", new Team());
		model.addAttribute("allSports", sportServ.getAllSports());
		model.addAttribute("allTeams", sportServ.getAllTeams());
		return "index.jsp";
	}
	
	@PostMapping("/sport")
	public String addSport(@Valid @ModelAttribute("aSport") Sport aSport, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
		} else {
			sportServ.create(aSport);
		}
		return "redirect:/";
	}
	
	@PostMapping("/team")
	public String addTeam(@Valid @ModelAttribute("aTeam") Team aTeam, 
			BindingResult result, Model model) {
		System.out.println(aTeam.getSport());
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
		} else {
			sportServ.create(aTeam);
		}
		return "redirect:/";
	}
	
	
}
