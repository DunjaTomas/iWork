package de.hdm.iWork.shared.bo;

import java.util.Date;

public class Stellenbeschreibung {

	private int stellenId;
	private String bezeichnung;
	private String beschreibungstext;
	private Date frist;

	public Stellenbeschreibung() {
	}

	public int getStellenId() {
		return this.stellenId;
	}

	public void setStellenId(int stellenId) {
		this.stellenId = stellenId;
	}

	public String getBezeichnung() {
		return this.bezeichnung;
	}

	public void setBezeichnug(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBeschreibungstext() {
		return this.beschreibungstext;
	}

	public void setBeschreibungstext(String beschreibungstext) {
		this.beschreibungstext = beschreibungstext;
	}

	public Date getFrist() {
		return this.frist;
	}

	public void setFrist(Date frist) {
		this.frist = frist;
	}

}
