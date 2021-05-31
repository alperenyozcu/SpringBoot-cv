package com.alperenyozcu.duzce.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alperenyozcu.duzce.model.ekbilgiler;
@Repository
public interface ekbilgilerRepository extends JpaRepository<ekbilgiler, Integer> {
	List<ekbilgiler> findAllByKullaniciid(int id);

}
