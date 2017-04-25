package de.hdm.iWork.server.db;

import java.util.Vector;

import de.hdm.iWork.shared.bo.Stellenbeschreibung;

public class StellenbeschreibungMapper {

	private static StellenbeschreibungMapper stellenbeschreibungMapper = null;

	protected StellenbeschreibungMapper() {
	}

	public static StellenbeschreibungMapper stellenbeschreibungMapper() {
	    if (stellenbeschreibungMapper == null) {
	      stellenbeschreibungMapper = new StellenbeschreibungMapper();
	    }
	    return stellenbeschreibungMapper;
	  }
	
	public void anlegenStellenbeschreibung(Stellenbeschreibung stellenbeschreibung){
		
	}
	
	public void updateStellenbeschreibung(Stellenbeschreibung stellenbeschreibung){
		
	}
	
	public void loeschenStellenbeschreibung(Stellenbeschreibung stellenbeschreibung){
		
	}
	
	public Stellenbeschreibung getStellenbeschreibungById(int stellenId){
		return null;
		
	}
	
	public Vector<Stellenbeschreibung> getAllStellenbeschreibungen(){
		return null;
		
	}
	
	public Vector<Stellenbeschreibung> getStellenbeschreibungByProfilId(int profilId){
		return null;
		
	}
	
}