package com.alperenyozcu.duzce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alperenyozcu.duzce.model.kullanici;
@Repository
public interface kullaniciRepository extends JpaRepository<kullanici, Integer>{
	
	kullanici findByemail(String email);
}
