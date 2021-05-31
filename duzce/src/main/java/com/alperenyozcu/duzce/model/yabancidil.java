package com.alperenyozcu.duzce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class yabancidil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	private String diladi;
	private String seviye;
	private int kullaniciid;
	public yabancidil(int id, String diladi, String seviye, int kullaniciid) {
		super();
		this.id = id;
		this.diladi = diladi;
		this.seviye = seviye;
		this.kullaniciid = kullaniciid;
	}
	public yabancidil() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiladi() {
		return diladi;
	}
	public void setDiladi(String diladi) {
		this.diladi = diladi;
	}
	public String getSeviye() {
		return seviye;
	}
	public void setSeviye(String seviye) {
		this.seviye = seviye;
	}
	public int getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(int kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	
}
