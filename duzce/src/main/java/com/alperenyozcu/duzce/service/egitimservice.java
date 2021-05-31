package com.alperenyozcu.duzce.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenyozcu.duzce.dao.egitimRepository;
import com.alperenyozcu.duzce.model.egitim;



@Service
public class egitimservice {
	@Autowired
	egitimRepository egitimRepository;
	
	public Collection<egitim> findAllBykullaniciid(int id){
		return egitimRepository.findAllByKullaniciid(id);
	}
	
	public egitim findById(int id) {
		return egitimRepository.findById(id).get();
	}
	
	public void save(egitim education) {
		egitimRepository.save(education);
	}
	
	public void deleteById(int id) {
		egitimRepository.deleteById(id);
}
}
