package com.alperenyozcu.duzce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.alperenyozcu.duzce.dao.kullaniciRepository;
@Controller
public class logincontroller  {
	
	@Autowired
	kullaniciRepository kullaniciRepository;

	@GetMapping({"/login"})
	public String login() {
		return "login";
	}
}