package com.alperenyozcu.duzce.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alperenyozcu.duzce.model.egitim;
import com.alperenyozcu.duzce.model.kullanici;
import com.alperenyozcu.duzce.service.egitimservice;
import com.alperenyozcu.duzce.service.kullaniciservice;



@Controller
public class egitimcontroller {
	@Autowired
	kullaniciservice kullaniciservice;
	@Autowired
	egitimservice egitimservice;
	@GetMapping({"/kullanici/egitim",""})
	public ModelAndView home1(Model model, Authentication authentication) {
		kullanici user =  gecerlikullanicial(authentication);

     
        Collection<egitim> educations = egitimservice.findAllBykullaniciid(user.getId());
        model.addAttribute("egitimler", educations);
		
		return new ModelAndView("egitimdoldur");
		
	}
	
	@PostMapping("/kullanici/egitimekle")
	public RedirectView addEdu(Authentication authentication, @ModelAttribute egitim education)
	{
		kullanici user = gecerlikullanicial(authentication);
		user.getEgitimler().add(education);
		kullaniciservice.createUser(user);
		return new RedirectView("/kullanici/egitim");
		
	}
	public kullanici gecerlikullanicial(Authentication authentication) {
		return kullaniciservice.findByMail(authentication.getName());
	}
	@GetMapping("/kullanici/egitimsil")
	public RedirectView egitimsil (int id) {
		egitimservice.deleteById(id);
		return new RedirectView("/kullanici/egitim");
	}
	@GetMapping("/kullanici/egitimguncelle")
	public String eduDetail(@RequestParam int id, Model model ) {
		
		egitim education = egitimservice.findById(id);
		model.addAttribute("egitim", education);
		return "egitimguncelle"; //egitimguncelle html cagrılır
	}
	
	
	@PostMapping("/kullanici/egitimguncelle")
	public RedirectView updateEdu(@ModelAttribute egitim education, Authentication authentication) {
		
		kullanici user = gecerlikullanicial(authentication);
		
		education.setKullaniciid(user.getId());
		egitimservice.save(education);
		return new RedirectView("/kullanici/egitim");
	}
	
}
