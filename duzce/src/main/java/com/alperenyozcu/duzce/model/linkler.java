package com.alperenyozcu.duzce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class linkler {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String link;
	private String linkadi;
	private int kullaniciid;
	public linkler(int id, String link, String linkadi, int kullaniciid) {
		super();
		this.id = id;
		this.link = link;
		this.linkadi = linkadi;
		this.kullaniciid = kullaniciid;
	}
	public linkler() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLinkadi() {
		return linkadi;
	}
	public void setLinkadi(String linkadi) {
		this.linkadi = linkadi;
	}
	public int getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(int kullaniciid) {
		this.kullaniciid = kullaniciid;
	} 
	

}
