package com.alperenyozcu.duzce.controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alperenyozcu.duzce.model.kullanici;
import com.alperenyozcu.duzce.service.kullaniciservice;



@Controller
@RequestMapping("/kullanici")
public class kullanicicontroller {
	
	@Autowired
	kullaniciservice userservice;
	@GetMapping({"/homepage",""})
	public ModelAndView home(Principal principal,Model model) {
		kullanici kullanici = userservice.findByMail(principal.getName());
		model.addAttribute("kullanici", kullanici);
		return new ModelAndView("homepage");
	}
	@GetMapping({"/cvgoster"})
	public ModelAndView cvgoster(@RequestParam int id,  Model model) {
		kullanici kullanici = userservice.findById(id);
		model.addAttribute("kullanici", kullanici);
		return new ModelAndView("index");
	}

	
	

}
