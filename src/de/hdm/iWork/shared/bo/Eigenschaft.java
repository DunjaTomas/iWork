package de.hdm.iWork.shared.bo;


public class Eigenschaft extends BusinessObject {
	
	private static final long serialVersionUID = 1L;
	
	
	private int eigenschaftId=0;
	
	/**
	 * Bezeichnung der Eigenschaft	
	 */
	private String bezeichnung="";
	

	/**
	 * No Argument Constructor
	 */
	public Eigenschaft(){
		
		super();
	}
	
	/**
	 * Auslesen der ID
	 */
	public int getEigenschaftId(){
		return eigenschaftId;
	}
	
	/**
	 * Setzen der ID
	 */
	public void setEigenschaftId(int eigenschaftId){
		this.eigenschaftId = eigenschaftId;
	}
	
	/**
	 * Auslesen der Bezeichnung
	 */
	
	public String getBezeichnung(){
		return bezeichnung;
	}
	
	/**
	 * Setzen der Bezeichnung
	 */

	public void setBezeichnung(String bezeichnung){
		this.bezeichnung= bezeichnung;
	}
	
	
	
	
	

}