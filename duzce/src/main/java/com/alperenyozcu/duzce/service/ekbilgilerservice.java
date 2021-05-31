package com.alperenyozcu.duzce.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alperenyozcu.duzce.dao.ekbilgilerRepository;
import com.alperenyozcu.duzce.model.ekbilgiler;
@Service
public class ekbilgilerservice {


		@Autowired
		ekbilgilerRepository ekbilgilerRepository;
		
		public Collection<ekbilgiler> findAllBykullaniciid(int id){
			return ekbilgilerRepository.findAllByKullaniciid(id);
		}
		
		public ekbilgiler findById(int id) {
			return ekbilgilerRepository.findById(id).get();
		}
		
		public void save(ekbilgiler ekbilgiler) {
			ekbilgilerRepository.save(ekbilgiler);
		}
		
		public void deleteById(int id) {
			ekbilgilerRepository.deleteById(id);
	
}
		}
