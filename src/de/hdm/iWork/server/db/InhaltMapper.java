package de.hdm.iWork.server.db;

import java.sql.*;
import java.util.Vector;

import de.hdm.iWork.shared.bo.*;

public class InhaltMapper {

	private static InhaltMapper inhaltMapper = null;
	/*
	 * Geschützter Konstruktor
	 */
	protected InhaltMapper(){
		
	}
	
	public static InhaltMapper inhaltMapper(){
		if(inhaltMapper == null){
			inhaltMapper = new InhaltMapper();
			
		}
		
		return inhaltMapper;
		
	}
	
	/*
	 * Ihalts-Objekt anlegen
	 */
	
	public Inhalt anlegenInhalt(Inhalt inhalt){
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			/*
			 * Erst wird nach der höchsten Id gesucht
			 */
			
			stmt.executeUpdate("INSERT INTO inhalt (profilId, eigenschaftId, Angabe) " 
					+ "VALUES (" + inhalt.getProfilId() + "," + inhalt.getEigenschaftsId() + "," + inhalt.getAngabe() + ")");
	}
	
	catch(SQLException e2){
		e2.printStackTrace();
	}
	
		return inhalt;
	}
	
	/*
	 * Inhalt-Objekt aktualisieren
	 */
	
	public Inhalt updateInhalt(Inhalt inhalt){
		Connection con = DBConnection.connection();
		
		try{
			
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("UPDATE inhalt " + "SET angabe=\"" + inhalt.getAngabe()
			+ "\" " + "WHERE eigenschafId=" + inhalt.getEigenschaftsId() + "AND WHERE profilId=" + inhalt.getProfilId());
			
			
		}
		
		catch(SQLException e2){
			e2.printStackTrace();
		}
		
		return inhalt;
		
	}
	
	/*
	 * Inhalt-Objekt loeschen
	 */
	public void loeschenInhalt(Inhalt inhalt){
		Connection con = DBConnection.connection();
		
		try{
			
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("DELETE FROM inhalt " + "WHERE eigenschaftId" + inhalt.getEigenschaftsId() + "AND WHERE profilId=" + inhalt.getProfilId());
			
		}
		
		catch(SQLException e2){
			e2.printStackTrace();
		}
	}
	
	/*
	 * Auslesen eines Inhalt-Objekt nach Id
	 */
	
	public Inhalt getALLAngabenById(Eigenschaft eigenschaftId, Profil profilId){
		Connection con = DBConnection.connection();
		
		/*
		 * Ergebnis Vector
		 */
		Vector<Inhalt> result = new Vector<Inhalt>();
		
		try{
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT angabe FROM inhalt "
					+ "WHERE eigenschaftId=" + eigenschaftId + "AND WHERE profilId=" + profilId);
			
		if(rs.next()){
			Inhalt inhalt = new Inhalt();
			inhalt.setAngabe(rs.getString("angabe"));
			result.add(inhalt);
						
		  }
		}
		
		catch(SQLException e2){
			e2.printStackTrace();
			return null;
		}
		
		return null;
	}

	/**
	 * NOCH ZU ERLEDIGEN. SOLL ALLE INHALTE für ein Profil zurückgeben
	 * @return
	 */
	public Vector<Inhalt> getAllInhalteFor(int i) {
		Connection con = DBConnection.connection();
		
		/*
		 * Ergebnis Vector
		 */
		Vector<Inhalt> result = new Vector<Inhalt>();
		
		try{
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM inhalt "
					+ " WHERE profilId=" + 1);
			
		if(rs.next()){
			Inhalt inhalt = new Inhalt();
			inhalt.setAngabe(rs.getString("angabe"));
			result.add(inhalt);
						
		  }
		}
		
		catch(SQLException e2){
			e2.printStackTrace();
			return null;
		}
		
		return null;

	}
}