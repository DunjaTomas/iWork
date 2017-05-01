package de.hdm.iWork.server.db;

import java.sql.*;
import de.hdm.iWork.shared.bo.*;

public class BenutzerMapper {
	
	/**
	 * Statische Variable
	 */
	private static BenutzerMapper benutzerMapper = null;
	
	/**
	 * Geschuetzter Konstruktur
	 */
	protected BenutzerMapper(){
	}

	/**
	 * Statische Methode zur Sicherstellung der Singleton-Eigenschaft von BenutzerMapper
	 */
	public static BenutzerMapper benutzerMapper() {
		if (benutzerMapper == null) {
			benutzerMapper = new BenutzerMapper();
		    }

		    return benutzerMapper;
	}
	
	/**
	 * Einfügen eines Benutzer-Objektes
	 */
	public Benutzer insert(Benutzer b){
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
			          + "FROM benutzer ");
			
			if (rs.next()) {
				
		        b.setId(rs.getInt("maxid") + 1);

		        stmt = con.createStatement();

		        stmt.executeUpdate("INSERT INTO benutzer (id, email) "
		            + "VALUES (" + b.getId() + ",'" + b.getEmail() + "')");
		      }
			
			
		}
		catch(SQLException e){
			
		}
		
		return b;
	}
	
	 /**
	   * Veraendern eines Benutzerobjektes
	   */
	  public Benutzer update(Benutzer b) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE benutzer " + "SET email=\""
	          + b.getEmail() + "\" " + "WHERE id=" + b.getId());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return b;
	  }

	  /**
	   * Loeschen der Daten eines Benutzer-Objektes aus der Datenbank
	   */
	  public void delete(Benutzer b) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM benutzer " + "WHERE id=" + b.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
}
