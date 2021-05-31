package com.alperenyozcu.duzce.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenyozcu.duzce.dao.linklerRepository;
import com.alperenyozcu.duzce.model.linkler;


@Service
public class linklerservice {

	@Autowired
	linklerRepository linklerRepository;
	
	public Collection<linkler> findAllBykullaniciid(int id){
		return linklerRepository.findAllByKullaniciid(id);
	}
	
	public linkler findById(int id) {
		return linklerRepository.findById(id).get();
	}
	
	public void save(linkler linkler) {
		linklerRepository.save(linkler);
	}
	
	public void deleteById(int id) {
		linklerRepository.deleteById(id);
}
	}
