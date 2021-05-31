package com.alperenyozcu.duzce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alperenyozcu.duzce.model.kisiselbilgiler;
@Repository
public interface kisiselbilgilerRepository extends JpaRepository<kisiselbilgiler, Integer> {

	List<kisiselbilgiler> findAllBykullaniciid(int id);
}
