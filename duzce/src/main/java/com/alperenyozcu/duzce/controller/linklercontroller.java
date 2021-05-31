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
import com.alperenyozcu.duzce.model.linkler;
import com.alperenyozcu.duzce.service.kullaniciservice;
import com.alperenyozcu.duzce.service.linklerservice;

@Controller
public class linklercontroller {
	@Autowired
	kullaniciservice kullaniciservice;
	@Autowired 
	linklerservice linklerservice;
	@GetMapping({"/kullanici/linkler"})
	public ModelAndView home1(Model model, Authentication authentication) {
		
		kullanici user =  gecerlikullanicial(authentication);

	     
        Collection<linkler> linkler = linklerservice.findAllBykullaniciid(user.getId());
        model.addAttribute("linkler", linkler);
		System.out.println("get maping alperen");
		return new ModelAndView("linkler");//html adı olacak
		
	}

	@PostMapping("/kullanici/linkekle")
	public RedirectView addEkbilgi(Authentication authentication, @ModelAttribute linkler link)
	{
		kullanici user = gecerlikullanicial(authentication);
		user.getLinklerler().add(link);
		kullaniciservice.createUser(user);
		return new RedirectView("/kullanici/linkler");
		
	}
	public kullanici gecerlikullanicial(Authentication authentication) {
		return kullaniciservice.findByMail(authentication.getName());
	
}
	@GetMapping("/kullanici/linksil")
	public RedirectView linksil (int id) {
		linklerservice.deleteById(id);
		return new RedirectView("/kullanici/linkler");
	}
	@GetMapping("/kullanici/linkguncelle")
	public String linkguncelle(@RequestParam int id, Model model ) {
		
		linkler link = linklerservice.findById(id);
		model.addAttribute("link", link);//html de doların içine bu gelecek
		return "linkguncelle"; //kisiselbilgiguncelle html cagrılır
	}
	
	
	@PostMapping("/kullanici/linkguncelle")
	public RedirectView linkguncelle(@ModelAttribute linkler link, Authentication authentication) {
		
		kullanici user = gecerlikullanicial(authentication);
		
		link.setKullaniciid(user.getId());
		linklerservice.save(link);
		return new RedirectView("/kullanici/linkler");
	}
}
