package com.alperenyozcu.duzce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alperenyozcu.duzce.model.yetenekler;
@Repository
public interface yeteneklerRepository extends JpaRepository<yetenekler, Integer> {
	List<yetenekler> findAllByKullaniciid(int id);
}
