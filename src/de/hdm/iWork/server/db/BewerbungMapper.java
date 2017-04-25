package de.hdm.iWork.server.db;

import java.util.Vector;

import de.hdm.iWork.shared.bo.Bewerbung;

public class BewerbungMapper {

	private static BewerbungMapper bewerbungMapper;
	
	protected BewerbungMapper(){
	}
	
	public static BewerbungMapper bewerbungMapper(){
		if (bewerbungMapper == null){
			bewerbungMapper = new BewerbungMapper();
		}
		return bewerbungMapper;
	}
	
	public void anlegenBewerbung(Bewerbung bewerbung){
		
	}
	
	public void updateBewerbung(Bewerbung bewerbung){
		
	}
	
	public void loeschenBewerbung(Bewerbung bewerbung){
		
	}
	
	public Vector<Bewerbung> getBewerbungByStellenId(int stellenId){
		return null;
		
	}
	
	public Vector<Bewerbung> getBewerbungByProfilId(int profilId){
		return null;
		
	}
}
