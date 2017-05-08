package de.hdm.iWork.client;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.iWork.shared.IWorkAdministrationAsync;
import de.hdm.iWork.shared.bo.Inhalt;

public class ShowEigenschaften extends ShowSuper {

	@Override
	protected String getHeadlineText() {
		return "Eigenschaftsangaben";
	}

	@Override
	protected void run() {
		
		this.append("Aufrufen aller angegeben Eigenschaften");
		
		IWorkAdministrationAsync iworkVerwaltung = ClientsideSetting.getIWorkAdministration();

		iworkVerwaltung.getAllInhalteFor(1, new InhalteCallback(this));
		
		
	}

	
	class InhalteCallback implements AsyncCallback<Vector<Inhalt>> {
		
		private ShowSuper showsuper = null;
		
		
		public InhalteCallback (ShowSuper s){
			this.showsuper = s;
		}
		
			
		@Override
		public void onFailure(Throwable caught) {
			
			 this.showsuper.append("Fehler bei der Abfrage " + caught.getMessage());
			
		}

		@Override
		public void onSuccess(Vector<Inhalt> result) {
			this.showsuper.append("test");
			if (result != null) {
				for (Inhalt i : result) {
					if (i != null){
						this.showsuper.append("test");
							
					}
		            this.showsuper.append(i.getId() + " " + i.getAngabe());
		            

		          }
		        }
			
		}
		
	}

}
