package com.alperenyozcu.duzce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alperenyozcu.duzce.model.egitim;
@Repository
public interface egitimRepository extends JpaRepository<egitim, Integer> {
	List<egitim> findAllByKullaniciid(int id);
}
