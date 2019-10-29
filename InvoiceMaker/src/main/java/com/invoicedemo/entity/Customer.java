package com.invoicedemo.entity;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	private int ID;
	private String Imie;
	private String Nazwisko;
	private String NIP;
	private String Firma;
	
	public Customer() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getImie() {
		return Imie;
	}

	public void setImie(String imie) {
		Imie = imie;
	}

	public String getNazwisko() {
		return Nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		Nazwisko = nazwisko;
	}

	public String getNIP() {
		return NIP;
	}

	public void setNIP(String nIP) {
		NIP = nIP;
	}

	public String getFirma() {
		return Firma;
	}

	public void setFirma(String firma) {
		Firma = firma;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", Imie=" + Imie + ", Nazwisko=" + Nazwisko + ", NIP=" + NIP + ", Firma=" + Firma
				+ "]";
	}
	
	


}
