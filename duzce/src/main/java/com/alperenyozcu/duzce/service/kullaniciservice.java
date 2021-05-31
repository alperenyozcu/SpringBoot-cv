package com.alperenyozcu.duzce.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenyozcu.duzce.dao.kullaniciRepository;
import com.alperenyozcu.duzce.model.kullanici;


@Service

public class kullaniciservice {

	@Autowired
	kullaniciRepository kullaniciRepository;
	
	public void createUser(kullanici user) {
		kullaniciRepository.save(user);
	}
	
	public Collection<kullanici> findAll()
	{
		List<kullanici> users = new ArrayList<kullanici>();
		for(kullanici user : kullaniciRepository.findAll())
		{
			users.add(user);
		}
		return users;
	}
	
	public kullanici findByMail(String mail) {
		return kullaniciRepository.findByemail(mail);
	}
	
	public kullanici findById(int id) {
		return kullaniciRepository.findById(id).get();
	}
}
