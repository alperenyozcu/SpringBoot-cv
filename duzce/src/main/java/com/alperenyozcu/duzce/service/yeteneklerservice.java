package com.alperenyozcu.duzce.service;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenyozcu.duzce.dao.yeteneklerRepository;
import com.alperenyozcu.duzce.model.yetenekler;
@Service
public class yeteneklerservice {
	@Autowired
	yeteneklerRepository yeteneklerRepository;
	
	public Collection< yetenekler> findAllBykullaniciid(int id){
		return yeteneklerRepository.findAllByKullaniciid(id);
	}
	
	public yetenekler findById(int id) {
		return yeteneklerRepository.findById(id).get();
	}
	
	public void save( yetenekler  yetenekler) {
		yeteneklerRepository.save( yetenekler);
	}
	
	public void deleteById(int id) {
		yeteneklerRepository.deleteById(id);
}
}
