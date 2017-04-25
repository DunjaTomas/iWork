package de.hdm.iWork.server.db;

import java.util.Vector;

import de.hdm.iWork.shared.bo.Stellenbeschreibung;

/**
 * Diese Klasse stellt die Verbindung zwischen der Klasse Stellenbeschreibung und der Datenbank dar.
 * @author Nina
 *
 */
public class StellenbeschreibungMapper {

	//statische Variable
	private static StellenbeschreibungMapper stellenbeschreibungMapper = null;

	//Geschützter Konstruktor
	protected StellenbeschreibungMapper() {
	}

	//Statische Methode die Singeltone Eigenschaft sicherstellt
	public static StellenbeschreibungMapper stellenbeschreibungMapper() {
	    if (stellenbeschreibungMapper == null) {
	      stellenbeschreibungMapper = new StellenbeschreibungMapper();
	    }
	    return stellenbeschreibungMapper;
	  }
	
	//Neue Stellenbeschreibung erstellen
	public void anlegenStellenbeschreibung(Stellenbeschreibung stellenbeschreibung){
		
	}
	
	//Bestehende Stellenbeschreibung verändern
	public void updateStellenbeschreibung(Stellenbeschreibung stellenbeschreibung){
		
	}
	
	//Bestehende Stellenbeschreibung löschen
	public void loeschenStellenbeschreibung(Stellenbeschreibung stellenbeschreibung){
		
	}
	
	//Ausgabe aller Stellenbeschreibungen zu einer bestimmten StellenId
	public Stellenbeschreibung getStellenbeschreibungById(int stellenId){
		return null;
		
	}
	
	//Ausgabe aller Stellenbeschreibungen
	public Vector<Stellenbeschreibung> getAllStellenbeschreibungen(){
		return null;
		
	}
	
	//Ausgabe aller Stellenbeschreibungen zu einer bestimmten ProfilId
	public Vector<Stellenbeschreibung> getStellenbeschreibungByProfilId(int profilId){
		return null;
		
	}
	
}