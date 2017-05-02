package de.hdm.iWork.shared.bo;

import java.io.Serializable;

/**
  * Muss noch befüllt werden
  * @author Nina
  *
  */
public abstract class BusinessObject implements Serializable {

		private static final long SerialVersionUID = 1L;
		
		/**
		 * Die eindeutige Identifikationsnummer einer Instanz dieser Klasse
		 */
		
		private int id = 0;
		
		/**
		 * Auslesen der id
		 */
		
		public int getId(){
			return this.id;
		}
		
		
		/**
		 * Setzen der id
		 */
		
		public void setId(int id){
			this.id = id;
		}
		
		public String toString(){
			
			
			return this.getClass().getName() + " #" + this.id;
		}
		
		 public boolean equals(Object o) {
			    /*
			     * Abfragen, ob ein Objekt ungleich NULL ist und ob ein Objekt gecastet
			     * werden kann, sind immer wichtig!
			     */
			    if (o != null && o instanceof BusinessObject) {
			      BusinessObject bo = (BusinessObject) o;
			      try {
			        if (bo.getId() == this.id)
			          return true;
			      }
			      catch (IllegalArgumentException e) {
			        /*
			         * Wenn irgendetwas schief geht, dann geben wir sicherheitshalber false
			         * zurück.
			         */
			        return false;
			      }
			    }
			    /*
			     * Wenn bislang keine Gleichheit bestimmt werden konnte, dann müssen
			     * schließlich false zurückgeben.
			     */
			    return false;
			  }
}
