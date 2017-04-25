package de.hdm.iWork.server.db;

import java.sql.*;
import de.hdm.iWork.shared.bo.*;

public class EigenschaftMapper {
	
	/*
	 * statische Variable
	 */
	
	private static EigenschaftMapper eigenschaftMapper=null;
	
	/**
	 * Geschützter Konstruktor
	 */
	protected EigenschaftMapper(){
		
	}
	
	/**
	 * Statische Methode die Singeltone Eigenschaft sicherstellt
	 * @return
	 */
	
	public static EigenschaftMapper eigenschaftMapper(){
		if(eigenschaftMapper == null){
			eigenschaftMapper = new EigenschaftMapper();
			
		}
		
		return eigenschaftMapper;
	}
	
	public Eigenschaft anlegenEigenschaft(Eigenschaft eigenschaft){
		Connection con= DBConnection.connection();
		
		try{
			Statement stmt= con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
			          + "FROM eigenschaft ");
			
			if(rs.next()){
				
				/*
				 * EigenschaftId des Objekts wird gesetzt und dabei um 1 erhöht
				 */
				eigenschaft.setEigenschaftId(rs.getInt("maxid")+1);
				
				stmt = con.createStatement();
				
				/*
				 * Einfügeoperation
				 */
				stmt.executeUpdate("INSERT INTO eigenschaft (eigenschaftId,bezeichnung) " + "VALUES ("
						+ eigenschaft.getEigenschaftId() + "," + eigenschaft.getBezeichnung() + ")");
				
			}
		}
		
		catch (SQLException e2){
			e2.printStackTrace();
		}
		
		return eigenschaft;
	}
	
	public Eigenschaft updateEigenschaft(Eigenschaft eigenschaft){
		Connection con= DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("UPDATE eigenschaft " + "SET bezeichnung\"" + eigenschaft.getBezeichnung()
			+ "\" " + "WHERE eigenschaftId=" + eigenschaft.getEigenschaftId());
			
		}
		
		catch(SQLException e2){
			e2.printStackTrace();
		}
		
		return eigenschaft;
	}
	
	public void loeschenEigenschaft(Eigenschaft eigenschaft){
		Connection con = DBConnection.connection();
		
		try{
			
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("DELETE FROM eigenschaft " + "WHERE eigenschaftId=" + eigenschaft.getEigenschaftId());
				
		}
		
		catch(SQLException e2){
			e2.printStackTrace();
		}
	}
	
	public Eigenschaft getEigenschaftbyId(int eigenschaftId){
		java.sql.Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT eigenschaftId, bezeichnung FROM eigenschaft "
					+ "WHERE eigenschaftId=" + eigenschaftId);
			
			if(rs.next()){
				Eigenschaft eigenschaft = new Eigenschaft();
				eigenschaft.setEigenschaftId(rs.getInt("eigenschaftId"));
				eigenschaft.setBezeichnung(rs.getString("bezeichnung"));
				return eigenschaft;
				
			}
		}
		
		catch(SQLException e2){
			e2.printStackTrace();
			return null;
		}
		
		return null;
	}
}
