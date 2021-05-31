package com.alperenyozcu.duzce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alperenyozcu.duzce.model.linkler;
@Repository
public interface linklerRepository extends JpaRepository<linkler, Integer> {
	List<linkler> findAllByKullaniciid(int id);
}
