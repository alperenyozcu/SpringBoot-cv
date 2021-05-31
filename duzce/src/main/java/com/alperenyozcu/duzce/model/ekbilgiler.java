package com.alperenyozcu.duzce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ekbilgiler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ekbilgi;
	private int kullaniciid;
	public ekbilgiler() {
		super();
	}
	public ekbilgiler(int id, String ekbilgi, int kullaniciid) {
		super();
		this.id = id;
		this.ekbilgi = ekbilgi;
		this.kullaniciid = kullaniciid;
	}
	@Override
	public String toString() {
		return "ekbilgiler []";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEkbilgi() {
		return ekbilgi;
	}
	public void setEkbilgi(String ekbilgi) {
		this.ekbilgi = ekbilgi;
	}
	public int getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(int kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	
	
	
	
}
