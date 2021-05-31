package com.alperenyozcu.duzce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alperenyozcu.duzce.model.kullanici;

@Service
public class kullanicidetailcustomservice implements UserDetailsService {
	@Autowired
	private kullaniciservice kullaniciservice;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		kullanici user = kullaniciservice.findByMail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Kullanıcı Bulunamadı");
		}
		
		return new kullanicidetailcustom(user);
}
}