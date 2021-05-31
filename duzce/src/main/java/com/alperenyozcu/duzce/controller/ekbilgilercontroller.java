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


import com.alperenyozcu.duzce.model.ekbilgiler;
import com.alperenyozcu.duzce.model.kullanici;

import com.alperenyozcu.duzce.service.ekbilgilerservice;
import com.alperenyozcu.duzce.service.kullaniciservice;

@Controller
public class ekbilgilercontroller {
	@Autowired
	kullaniciservice kullaniciservice;
	@Autowired
	ekbilgilerservice ekbilgilerservice;
	@GetMapping({"/kullanici/ekbilgi"})
	public ModelAndView home1(Model model, Authentication authentication) {
		
		kullanici user =  gecerlikullanicial(authentication);

	     
        Collection<ekbilgiler> ekbilgilerler = ekbilgilerservice.findAllBykullaniciid(user.getId());
        model.addAttribute("ekbilgiler", ekbilgilerler);
		System.out.println("get maping alperen");
		return new ModelAndView("ekbilgidoldur");//html adı olacak
		
	}

	@PostMapping("/kullanici/ekbilgiekle")
	public RedirectView addEkbilgi(Authentication authentication, @ModelAttribute ekbilgiler ekbilgi)
	{
		kullanici user = gecerlikullanicial(authentication);
		user.getEkbilgilerler().add(ekbilgi);
		kullaniciservice.createUser(user);
		return new RedirectView("/kullanici/ekbilgi");
		
	}
	public kullanici gecerlikullanicial(Authentication authentication) {
		return kullaniciservice.findByMail(authentication.getName());
	}
	@GetMapping("/kullanici/ekbilgisil")
	public RedirectView ekbilgisil (int id) {
		ekbilgilerservice.deleteById(id);
		return new RedirectView("/kullanici/ekbilgi");
	}
	@GetMapping("/kullanici/ekbilgiguncelle")
	public String ekbilgiguncelle(@RequestParam int id, Model model ) {
		
		ekbilgiler ekbilgi = ekbilgilerservice.findById(id);
		model.addAttribute("ekbilgi", ekbilgi);
		return "ekbilgiguncelle"; //egitimguncelle html cagrılır
	}
	
	
	@PostMapping("/kullanici/ekbilgiguncelle")
	public RedirectView egitimguncelle(@ModelAttribute ekbilgiler ekbilgi, Authentication authentication) {
		
		kullanici user = gecerlikullanicial(authentication);
		
		ekbilgi.setKullaniciid(user.getId());
		ekbilgilerservice.save(ekbilgi);
		return new RedirectView("/kullanici/ekbilgi");
	}
	
}
