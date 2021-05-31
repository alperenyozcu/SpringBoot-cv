package com.alperenyozcu.duzce.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.alperenyozcu.duzce.model.kullanici;
import com.alperenyozcu.duzce.service.kullaniciservice;


@Controller
@RequestMapping("/admin")
public class admincontroller {
	@Autowired
	kullaniciservice kullaniciservice;
	
	@GetMapping({"/homepage"})
	public ModelAndView home1(Model model, Authentication authentication) {
	

     
        Collection<kullanici> kullanicilar = kullaniciservice.findAll();
        model.addAttribute("kullanicilar", kullanicilar);
		
		return new ModelAndView("admintablo");
}
	@GetMapping({"/cvgoster"})
	public ModelAndView cvgoster(@RequestParam int id,  Model model) {
		kullanici kullanici = kullaniciservice.findById(id);
		model.addAttribute("kullanici", kullanici);
		return new ModelAndView("index");
	}
}
