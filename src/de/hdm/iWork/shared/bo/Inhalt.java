package de.hdm.iWork.shared.bo;

public class Inhalt extends BusinessObject {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Fremdschlüsselbeziehung zu Eigenschaft
	 */
	private int eigenschaftsId=0;
	
	/**
	 * Fremdschlüsselbeziehung zu Profil
	 */
	private int profilId=0;
	
	/**
	 * Angabe des Users
	 */
	
	private String angabe="";
	
	/**
	 * Auslesen des Fremschslüssels zu Eigenschaft
	 */
	
	public int getEigenschaftsId(){
		return this.eigenschaftsId;
		
	}
	
	/**
	 * Setzen des Fremdschlüssels zu Eigenschaft
	 */
	public void setEigenschaftsId(int eigenschaftsId){
		this.eigenschaftsId=eigenschaftsId;
	}
	
	/**
	 * Auslesen des Fremdschlüssels zu Profil
	 */
	
	public int getProfilId(){
		return this.profilId;
	}
	
	/**
	 * Setzen des Fremdschlüssels zu Profil
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