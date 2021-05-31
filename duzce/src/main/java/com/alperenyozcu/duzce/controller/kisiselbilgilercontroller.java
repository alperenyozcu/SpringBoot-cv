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
import com.alperenyozcu.duzce.model.kisiselbilgiler;
import com.alperenyozcu.duzce.model.kullanici;
import com.alperenyozcu.duzce.service.kisiselbilgilerservice;
import com.alperenyozcu.duzce.service.kullaniciservice;



@Controller
public class kisiselbilgilercontroller {
	@Autowired
	kullaniciservice kullaniciservice;
	@Autowired
	kisiselbilgilerservice 	kisiselbilgilerservice;
	@GetMapping({"/kullanici/kisiselbilgi"})
	public ModelAndView home1(Model model, Authentication authentication) {

		kullanici user =  gecerlikullanicial(authentication);

	     
        Collection<kisiselbilgiler> kisiselbilgiler = kisiselbilgilerservice.findAllBykullaniciid(user.getId());
        model.addAttribute("kisiselbilgiler", kisiselbilgiler);
		System.out.println("get maping alperen");
		return new ModelAndView("kisiselbilgidoldur");//html adı olacak
		
	}

	@PostMapping("/kullanici/kisiselbilgiekle")
	public RedirectView addkisiselbilgi(Authentication authentication, @ModelAttribute kisiselbilgiler kisiselbilgi)
	{
		kullanici user = gecerlikullanicial(authentication);
		user.getKisiselbilgilerler().add(kisiselbilgi);
		kullaniciservice.createUser(user);
		return new RedirectView("/kullanici/kisiselbilgi");
		
	}
	public kullanici gecerlikullanicial(Authentication authentication) {
		return kullaniciservice.findByMail(authentication.getName());
	
}
	@GetMapping("/kullanici/kisiselbilgisil")
	public RedirectView kisiselbilgisil (int id) {
		kisiselbilgilerservice.deleteById(id);
		return new RedirectView("/kullanici/kisiselbilgi");
	}
	@GetMapping("/kullanici/kisiselbilgiguncelle")
	public String kisiselbilgiguncelle(@RequestParam int id, Model model ) {
		
		kisiselbilgiler kisiselbilgi = kisiselbilgilerservice.findById(id);
		model.addAttribute("kisiselbilgi", kisiselbilgi);//html de doların içine bu gelecek
		return "kisiselbilgiguncelle"; //kisiselbilgiguncelle html cagrılır
	}
	
	
	@PostMapping("/kullanici/kisiselbilgiguncelle")
	public RedirectView egitimguncelle(@ModelAttribute kisiselbilgiler kisiselbilgi, Authentication authentication) {
		
		kullanici user = gecerlikullanicial(authentication);
		
		kisiselbilgi.setKullaniciid(user.getId());
		kisiselbilgilerservice.save(kisiselbilgi);
		return new RedirectView("/kullanici/kisiselbilgi");
	}
}