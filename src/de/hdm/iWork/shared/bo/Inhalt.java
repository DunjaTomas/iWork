package de.hdm.iWork.shared.bo;

public class Inhalt extends BusinessObject {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Fremdschl�sselbeziehung zu Eigenschaft
	 */
	private int eigenschaftsId=0;
	
	/**
	 * Fremdschl�sselbeziehung zu Profil
	 */
	private int profilId=0;
	
	/**
	 * Angabe des Users
	 */
	
	private String angabe="";
	
	/**
	 * Auslesen des Fremschsl�ssels zu Eigenschaft
	 */
	
	public int getEigenschaftsId(){
		return this.eigenschaftsId;
		
	}
	
	/**
	 * Setzen des Fremdschl�ssels zu Eigenschaft
	 */
	public void setEigenschaftsId(int eigenschaftsId){
		this.eigenschaftsId=eigenschaftsId;
	}
	
	/**
	 * Auslesen des Fremdschl�ssels zu Profil
	 */
	
	public int getProfilId(){
		return this.profilId;
	}
	
	/**
	 * Setzen des Fremdschl�ssels zu Profil
	 */
	public void setProfilId(int profilId){
		this.profilId=profilId;
	}
	
	/**
	 * Auslesen der Angabe
	 */
	
	public String getAngabe(){
		return angabe;
		
	}
	
	/**
	 * Setzen der Angabe
	 */
	public void setAngabe(String angabe){
		this.angabe = angabe;
	}
}