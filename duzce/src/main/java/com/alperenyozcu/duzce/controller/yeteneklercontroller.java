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

import com.alperenyozcu.duzce.model.yetenekler;
import com.alperenyozcu.duzce.service.kullaniciservice;
import com.alperenyozcu.duzce.service.yeteneklerservice;

@Controller
public class yeteneklercontroller {
	@Autowired
	kullaniciservice kullaniciservice;
	@Autowired 
	yeteneklerservice yeteneklerservice;
	@GetMapping({"/kullanici/yetenekler"})
	public ModelAndView home1(Model model, Authentication authentication) {

		kullanici user =  gecerlikullanicial(authentication);

	     
        Collection<yetenekler> yetenekler = yeteneklerservice.findAllBykullaniciid(user.getId());
        model.addAttribute("yetenekler", yetenekler);
		System.out.println("get maping alperen");
		return new ModelAndView("yetenekler");//html adı olacak
		
	}

	@PostMapping("/kullanici/yetenekekle")
	public RedirectView addEkbilgi(Authentication authentication, @ModelAttribute yetenekler yetenek)
	{
		kullanici user = gecerlikullanicial(authentication);
		user.getYeteneklerler().add(yetenek);
		kullaniciservice.createUser(user);
		return new RedirectView("/kullanici/yetenekler");
		
	}
	public kullanici gecerlikullanicial(Authentication authentication) {
		return kullaniciservice.findByMail(authentication.getName());
}
	@GetMapping("/kullanici/yeteneksil")
	public RedirectView yeteneksil (int id) {
		yeteneklerservice.deleteById(id);
		return new RedirectView("/kullanici/yetenekler");
	}
	@GetMapping("/kullanici/yetenekguncelle")
	public String yetenekguncelle(@RequestParam int id, Model model ) {
		
		yetenekler yetenek = yeteneklerservice.findById(id);
		model.addAttribute("yetenek", yetenek);//html de doların içine bu gelecek
		return "yetenekguncelle"; //kisiselbilgiguncelle html cagrılır
	}
	
	
	@PostMapping("/kullanici/yetenekguncelle")
	public RedirectView yetenekguncelle(@ModelAttribute yetenekler yetenek, Authentication authentication) {
		
		kullanici user = gecerlikullanicial(authentication);
		
		yetenek.setKullaniciid(user.getId());
		yeteneklerservice.save(yetenek);
		return new RedirectView("/kullanici/yetenekler");
	}
	}

