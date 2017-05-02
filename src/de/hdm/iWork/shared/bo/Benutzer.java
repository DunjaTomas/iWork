package de.hdm.iWork.shared.bo;

/**
 * Diese Klasse repraesentiert eine Bewerbung und deren Methoden
 * @author Carolin Marian
 *
 */

public class Benutzer extends BusinessObject {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Emailadresse des Benutzers
	 */
	private String email = "";
	
	/**
	 * No Argument Constructor
	 */
	public Benutzer() {
		super();
	}
	
	/**
	 * Auslesen der Emailadresse .
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Setzen der Emaiadresse.
	 */
	 public void setEmail(String email) {
	    this.email = email;
	 }
	  
	 /**
	  * Erzeugen einer textuellen Darstellung der jeweiliger jeweiligen Instanz von Benutzer
	  * @see java.lang.Object#toString()
	  */ 
	  public String toString() {
		    return super.toString() + " " + this.email;
	  }
	  
	  /**
	   * Feststellen der Gleichheit zweier Benutzer-Objekte anhand der ID
	   */
	  public boolean equals(Object o) {
		    if (o != null && o instanceof Benutzer) {
		      Benutzer c = (Benutzer) o;
		      try {
		        return super.equals(c);
		      }
		      catch (IllegalArgumentException e) {
		        return false;
		      }
		    }
		    return false;
		  }
}
