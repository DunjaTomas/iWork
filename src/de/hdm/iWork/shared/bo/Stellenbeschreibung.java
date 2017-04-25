package de.hdm.iWork.shared.bo;

import java.util.Date;

/**
 * Diese Klasse repräsentiert eine Stellenbeschreibung und deren Methoden
 * @author Nina
 *
 */
public class Stellenbeschreibung extends BusinessObject {

	// Das Attribut serialVersionUID wird von der Oberklasse BusinessObject vererbt
	private static final long serialVersionUID = 1L;

	//Attribute einer Stellenbeschreibung
	private int stellenId;
	private String bezeichnung;
	private String beschreibungstext;
	private Date frist;

	//No-Argument Constructor
	public Stellenbeschreibung() {
		super();
	}

	//Getter & Setter-Methoden
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
