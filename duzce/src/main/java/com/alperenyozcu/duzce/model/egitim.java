package com.alperenyozcu.duzce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class egitim {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	private String bolum;
	private String okul;
	private String sinif;
	private int kullaniciid;
	public egitim(int id,  int kullaniciid,String okul,String bolum,String sinif) {
		super();
		this.id = id;
		this.kullaniciid = kullaniciid;
		this.bolum=bolum;
		this.sinif=sinif;
	}
	public egitim() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(int kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	public String getBolum() {
		return bolum;
	}
	public void setBolum(String bolum) {
		this.bolum = bolum;
	}
	public String getOkul() {
		return okul;
	}
	public void setOkul(String okul) {
		this.okul = okul;
	}
	public String getSinif() {
		return sinif;
	}
	public void setSinif(String sinif) {
		this.sinif = sinif;
	}
	
	
}
