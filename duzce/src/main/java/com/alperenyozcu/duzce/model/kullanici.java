package com.alperenyozcu.duzce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class kullanici {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	private String sifre;
	private String kullaniciadi;
	private String kullanicisoyadi;
	private String sistemrol;
	@OneToMany(targetEntity = egitim.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "kullaniciid", referencedColumnName =  "id")
  private List<egitim> egitimler;
	@OneToMany(targetEntity = ekbilgiler.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "kullaniciid", referencedColumnName =  "id")
  private List<ekbilgiler> ekbilgilerler;
	@OneToMany(targetEntity = kisiselbilgiler.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "kullaniciid", referencedColumnName =  "id")
  private List<kisiselbilgiler> kisiselbilgilerler;
	@OneToMany(targetEntity = linkler.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "kullaniciid", referencedColumnName =  "id")
  private List<linkler> linklerler;
	@OneToMany(targetEntity = yabancidil.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "kullaniciid", referencedColumnName =  "id")
  private List<yabancidil> yabancidiller;
	@OneToMany(targetEntity = yetenekler.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "kullaniciid", referencedColumnName =  "id")
  private List<yetenekler> yeteneklerler;
	public kullanici(int id, String email, String sifre, String kullaniciadi, String kullanicisoyadi, String sistemrol,
			List<egitim> egitimler, List<ekbilgiler> ekbilgilerler, List<kisiselbilgiler> kisiselbilgilerler,
			List<linkler> linklerler, List<yabancidil> yabancidiller, List<yetenekler> yeteneklerler) {
		super();
		this.id = id;
		this.email = email;
		this.sifre = sifre;
		this.kullaniciadi = kullaniciadi;
		this.kullanicisoyadi = kullanicisoyadi;
		this.sistemrol = sistemrol;
		this.egitimler = egitimler;
		this.ekbilgilerler = ekbilgilerler;
		this.kisiselbilgilerler = kisiselbilgilerler;
		this.linklerler = linklerler;
		this.yabancidiller = yabancidiller;
		this.yeteneklerler = yeteneklerler;
	}
	public kullanici() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public String getKullaniciadi() {
		return kullaniciadi;
	}
	public void setKullaniciadi(String kullaniciadi) {
		this.kullaniciadi = kullaniciadi;
	}
	public String getKullanicisoyadi() {
		return kullanicisoyadi;
	}
	public void setKullanicisoyadi(String kullanicisoyadi) {
		this.kullanicisoyadi = kullanicisoyadi;
	}
	public String getSistemrol() {
		return sistemrol;
	}
	public void setSistemrol(String sistemrol) {
		this.sistemrol = sistemrol;
	}
	public List<egitim> getEgitimler() {
		return egitimler;
	}
	public void setEgitimler(List<egitim> egitimler) {
		this.egitimler = egitimler;
	}
	public List<ekbilgiler> getEkbilgilerler() {
		return ekbilgilerler;
	}
	public void setEkbilgilerler(List<ekbilgiler> ekbilgilerler) {
		this.ekbilgilerler = ekbilgilerler;
	}
	public List<kisiselbilgiler> getKisiselbilgilerler() {
		return kisiselbilgilerler;
	}
	public void setKisiselbilgilerler(List<kisiselbilgiler> kisiselbilgilerler) {
		this.kisiselbilgilerler = kisiselbilgilerler;
	}
	public List<linkler> getLinklerler() {
		return linklerler;
	}
	public void setLinklerler(List<linkler> linklerler) {
		this.linklerler = linklerler;
	}
	public List<yabancidil> getYabancidiller() {
		return yabancidiller;
	}
	public void setYabancidiller(List<yabancidil> yabancidiller) {
		this.yabancidiller = yabancidiller;
	}
	public List<yetenekler> getYeteneklerler() {
		return yeteneklerler;
	}
	public void setYeteneklerler(List<yetenekler> yeteneklerler) {
		this.yeteneklerler = yeteneklerler;
	}

	

	
}
