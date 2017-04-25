package de.hdm.iWork.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.iWork.shared.bo.Bewerbung;

/**
 * Diese Klasse stellt die Verbindung zwischen der Klasse Bewerbung und der Datenbank dar.
 * @author Nina
 *
 */
public class BewerbungMapper {

	//statische Variable
	private static BewerbungMapper bewerbungMapper=null;
	
	//Geschützter Konstruktor
	protected BewerbungMapper(){
	}
	
	//Statische Methode die Singeltone Eigenschaft sicherstellt
	public static BewerbungMapper bewerbungMapper(){
		if (bewerbungMapper == null){
			bewerbungMapper = new BewerbungMapper();
		}
		return bewerbungMapper;
	}
	
	//Neue Bewerbung erstellen
	public void anlegenBewerbung(Bewerbung bewerbung){
	
	}
	
	//Bestehende Bewerbung verändern
	public void updateBewerbung(Bewerbung bewerbung){
		
	}
	
	//Bestehende Bewerbung löschen
	public void loeschenBewerbung(Bewerbung bewerbung){
		
	}
	
	//Ausgabe aller Bewerbungen zu einer bestimmten StellenId
	public Vector<Bewerbung> getBewerbungByStellenId(int stellenId){
		return null;
		
	}
	
	//Ausgabe aller Bewerbungen zu einer bestimmten ProfilId
	public Vector<Bewerbung> getBewerbungByProfilId(int profilId){
		return null;
		
	}
}
