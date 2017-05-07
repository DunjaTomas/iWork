package de.hdm.iWork.shared.bo;


/**
 * Diese Klasse repräsentiert eine Bewerbung und deren Methoden
 * @author Nina
 *
 */
public class Bewerbung extends BusinessObject {

	// Das Attribut serialVersionUID wird von der Oberklasse BusinessObject vererbt
	private static final long serialVersionUID = 1L;

	//Attribute einer Stellenausschreibung
	private int stellenId = 0;
	private int benutzerId = 0;

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

	public int getBenutzerId() {
		return this.benutzerId;
	}

	public void setBenutzerId(int profilId) {
		this.benutzerId = profilId;
	}

}
