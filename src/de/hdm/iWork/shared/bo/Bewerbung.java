package de.hdm.iWork.shared.bo;


/**
 * Diese Klasse repräsentiert eine Bewerbung und deren Methoden
 * @author Nina
 *
 */
public class Bewerbung extends BusinessObject {

	// Das Attribut serialVersionUID wird von der Oberklasse BusinessObject vererbt
	private static final long serialVersionUID = 1L;

	//Attribute einer Stellenbeschreibung
	private int stellenId;
	private int profilId;

	//No-Argument Constructor
	public Bewerbung() {
		super();
	}

	//Getter & Setter-Methoden
	public int getStellenId() {
		return this.stellenId;
	}

	public void setStellenId(int stellenId) {
		this.stellenId = stellenId;
	}

	public int getProfilId() {
		return this.profilId;
	}

	public void setProfilId(int profilId) {
		this.profilId = profilId;
	}

}
