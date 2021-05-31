package com.alperenyozcu.duzce.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenyozcu.duzce.dao.yabancidilRepository;
import com.alperenyozcu.duzce.model.yabancidil;
@Service
public class yabancidilservice {
	@Autowired
	yabancidilRepository yabancidilRepository;
	
	public Collection< yabancidil> findAllBykullaniciid(int id){
		return yabancidilRepository.findAllByKullaniciid(id);
	}
	
	public yabancidil findById(int id) {
		return yabancidilRepository.findById(id).get();
	}
	
	public void save( yabancidil  yabancidil) {
		yabancidilRepository.save( yabancidil);
	}
	
	public void deleteById(int id) {
		yabancidilRepository.deleteById(id);
}
}
