package de.hdm.iWork.shared.bo;

public class Profil extends BusinessObject {
	
	private static final long serialVersionUID = 1L;
	
	  /**
	   * Fremdschluesselbeziehung zum Besitzer des Profils.
	   */
	  private int besitzerId = 0;
	  
	  /**
	   * No Argument Constructor
	   */
	  public Profil() {
	    super();
	  }

	  /**
	   * Auslesen des Fremdschluessels zum Besitzer des Profils.
	   */
	  public int getBesitzerId() {
	    return this.besitzerId;
	  }

	  /**
	   * Setzen des Fremdschluessels zum Besitzer des Profils.
	   */
	  public void setBesitzerId(int id) {
	    this.besitzerId = id;
	  }
	  
	 /**
	  * Erzeugen einer textuellen Darstellung der jeweiliger jeweiligen Instanz von Benutzer
	  * @see java.lang.Object#toString()
	  */ 
	  public String toString() {
		    return super.toString();
	  }
	  
	  /**
	   * Feststellen der Gleichheit zweier Profil-Objekte anhand der ID
	   */
	  public boolean equals(Object o) {
		    if (o != null && o instanceof Profil) {
		      Profil c = (Profil) o;
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
