package com.alperenyozcu.duzce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class kisiselbilgiler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String aciklama;
	private String adres;
	@Temporal(TemporalType.DATE)
	private Date dogtarih;
	private String telefon;
	private String meslek;
	private int kullaniciid;
	public kisiselbilgiler(int id, String aciklama, String adres, Date dogtarih, String telefon,String meslek,int kullaniciid) {
		super();
		this.id = id;
		this.aciklama = aciklama;
		this.adres = adres;
		this.dogtarih = dogtarih;
		this.telefon = telefon;
		this.meslek=meslek;
		this.kullaniciid=kullaniciid;
	}
	public kisiselbilgiler() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public Date getDogtarih() {
		return dogtarih;
	}
	public void setDogtarih(Date dogtarih) {
		this.dogtarih = dogtarih;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getMeslek() {
		return meslek;
	}
	public void setMeslek(String meslek) {
		this.meslek = meslek;
	}
	public int getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(int kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	
}
