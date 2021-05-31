package com.alperenyozcu.duzce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.alperenyozcu.duzce.model.kullanici;
import com.alperenyozcu.duzce.service.kullaniciservice;
@Controller
public class kayıtcontroller {

	@Autowired
	kullaniciservice kullaniciservice;

	@GetMapping({"/kaydol"})
	public String kaydolmet(Model model) {
		model.addAttribute("kullanici", new kullanici());
		return "kaydol";
}
	
	@PostMapping({"/kaydol"})
	public String kaydolmet(@ModelAttribute kullanici kullanici) {
		kullanici.setSistemrol("USER");
		kullanici.setSifre(new BCryptPasswordEncoder().encode(kullanici.getSifre()));
		kullaniciservice.createUser(kullanici);
		return "login";
}
	}
