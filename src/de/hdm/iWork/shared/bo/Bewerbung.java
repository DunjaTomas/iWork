package de.hdm.iWork.shared.bo;
 //Klasse Bewerbung - Kommentare kommen noch
public class Bewerbung {

		private int stellenId;
		private int profilId;
		
		public Bewerbung(){
		}
		
		public int getStellenId(){
			return this.stellenId;
		}
		
		public void setStellenId(int stellenId){
			this.stellenId = stellenId;
		}
		
		public int getProfilId(){
			return this.profilId;
		}
		
		public void setProfilId(int profilId){
			this.profilId = profilId;
		}
	
}
