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
import com.alperenyozcu.duzce.model.kullanici;
import com.alperenyozcu.duzce.model.yabancidil;
import com.alperenyozcu.duzce.service.kullaniciservice;
import com.alperenyozcu.duzce.service.yabancidilservice;

@Controller

public class yabancidilcontroller {

	@Autowired
	kullaniciservice kullaniciservice;
	@Autowired
	yabancidilservice yabancidilservice;
	@GetMapping({"/kullanici/yabancidil"})
	public ModelAndView home1(Model model, Authentication authentication) {

		kullanici user =  gecerlikullanicial(authentication);

	     
        Collection<yabancidil> yabancidil = yabancidilservice.findAllBykullaniciid(user.getId());
        model.addAttribute("yabancidil", yabancidil);
		System.out.println("get maping alperen");
		return new ModelAndView("yabancidil");//html adı olacak
		
	}

	@PostMapping("/kullanici/yabancidilekle")
	public RedirectView addEkbilgi(Authentication authentication, @ModelAttribute yabancidil dil)
	{
		kullanici user = gecerlikullanicial(authentication);
		user.getYabancidiller().add(dil);
		kullaniciservice.createUser(user);
		return new RedirectView("/kullanici/yabancidil");
		
	}
	public kullanici gecerlikullanicial(Authentication authentication) {
		return kullaniciservice.findByMail(authentication.getName());
	
}
	@GetMapping("/kullanici/yabancidilsil")
	public RedirectView yabancidilsil (int id) {
		yabancidilservice.deleteById(id);
		return new RedirectView("/kullanici/yabancidil");
	}
	@GetMapping("/kullanici/yabancidilguncelle")
	public String yabancidilguncelle(@RequestParam int id, Model model ) {
		
		yabancidil yabancidil = yabancidilservice.findById(id);
		model.addAttribute("yabancidil", yabancidil);//html de doların içine bu gelecek
		return "yabancidilguncelle"; //kisiselbilgiguncelle html cagrılır
	}
	
	
	@PostMapping("/kullanici/yabancidilguncelle")
	public RedirectView yabancidilguncelle(@ModelAttribute yabancidil yabancidil, Authentication authentication) {
		
		kullanici user = gecerlikullanicial(authentication);
		
		yabancidil.setKullaniciid(user.getId());
		yabancidilservice.save(yabancidil);
		return new RedirectView("/kullanici/yabancidil");
	}
}
