package com.alperenyozcu.duzce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class yetenekler {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String yetenekisim;
	private int yil;
	private int kullaniciid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYetenekisim() {
		return yetenekisim;
	}
	public void setYetenekisim(String yetenekisim) {
		this.yetenekisim = yetenekisim;
	}
	public int getYil() {
		return yil;
	}
	public void setYil(int yil) {
		this.yil = yil;
	}
	public int getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(int kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	public yetenekler() {
		super();
	}
	public yetenekler(int id, String yetenekisim, int yil, int kullaniciid) {
		super();
		this.id = id;
		this.yetenekisim = yetenekisim;
		this.yil = yil;
		this.kullaniciid = kullaniciid;
	}

	
}
