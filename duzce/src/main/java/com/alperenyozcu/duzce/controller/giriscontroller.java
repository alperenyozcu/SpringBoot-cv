package com.alperenyozcu.duzce.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.alperenyozcu.duzce.model.kullanici;
import com.alperenyozcu.duzce.service.kullaniciservice;



@Controller
public class giriscontroller {
	@Autowired
	kullaniciservice kullaniciservice;
	
	@GetMapping("/")
	public RedirectView redirect(Principal principal, Model model)
	{
		if(principal==null)
			return new RedirectView("login");
		
		kullanici kullanici = kullaniciservice.findByMail(principal.getName());

		
		if(kullanici.getSistemrol().equals("USER"))
		{
			//return ("homepage");
			return new RedirectView("kullanici/homepage");
		}
		//return "homepage";
		return new RedirectView("/admin/homepage");

}
	}
