package de.hdm.iWork.server.db;

import java.sql.*;
import de.hdm.iWork.shared.bo.*;


public class ProfilMapper {

	/**
	 * Statische Variable
	 */
	private static ProfilMapper profilMapper = null;
	
	/**
	 * Geschuetzter Konstruktur
	 */
	protected ProfilMapper(){
	}
	
	/**
	 * Statische Methode zur Sicherstellung der Singleton-Eigenschaft von ProfilMapper
	 */
	public static ProfilMapper profilMapper() {
		if (profilMapper == null) {
			profilMapper = new ProfilMapper();
		    }

		    return profilMapper;
	}
	
	/**
	 * Einfügen eines Profil-Objektes
	 */
	public Profil insert(Profil p){
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
			          + "FROM profil ");
			
			if (rs.next()) {
				
		        p.setId(rs.getInt("maxid") + 1);

		        stmt = con.createStatement();

		        stmt.executeUpdate("INSERT INTO profil (id) "
		            + "VALUES (" + p.getId() + "')");
		      }
			
			
		}
		catch(SQLException e){
			
		}
		
		return p;
	}
	

	 /**
	  * Loeschen der Daten eines Profil-Objektes aus der Datenbank
	  */
	  public void delete(Profil p) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM profil " + "WHERE id=" + p.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	


}
