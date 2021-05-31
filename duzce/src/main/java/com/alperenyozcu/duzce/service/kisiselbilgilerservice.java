package com.alperenyozcu.duzce.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenyozcu.duzce.dao.kisiselbilgilerRepository;
import com.alperenyozcu.duzce.model.kisiselbilgiler;

@Service
public class kisiselbilgilerservice {

	@Autowired
	 kisiselbilgilerRepository kisiselbilgilerRepository;
	
	public Collection< kisiselbilgiler> findAllBykullaniciid(int id){
		return kisiselbilgilerRepository.findAllBykullaniciid(id);
	}
	
	public  kisiselbilgiler findById(int id) {
		return kisiselbilgilerRepository.findById(id).get();
	}
	
	public void save( kisiselbilgiler  kisiselbilgiler) {
		kisiselbilgilerRepository.save( kisiselbilgiler);
	}
	
	public void deleteById(int id) {
		kisiselbilgilerRepository.deleteById(id);
}
}
