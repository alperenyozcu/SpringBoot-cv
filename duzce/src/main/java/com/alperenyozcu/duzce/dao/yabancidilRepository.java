package com.alperenyozcu.duzce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alperenyozcu.duzce.model.yabancidil;
@Repository
public interface yabancidilRepository extends JpaRepository<yabancidil, Integer> {
	List<yabancidil> findAllByKullaniciid(int id);
}
