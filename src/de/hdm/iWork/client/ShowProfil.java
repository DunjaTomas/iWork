package de.hdm.iWork.client;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

import de.hdm.iWork.shared.IWorkAdministrationAsync;
import de.hdm.iWork.shared.bo.Inhalt;


/**
 * Klasse, die das Anzeigen eines Profils auf dem Client realisiert.
 * @author Carolin
 *
 */
public class ShowProfil extends ShowSuper{
	
	@Override
	protected String getHeadlineText() {
		String headlineText = "Profil"; // Noch anpassen. (Evlt Profilname)
		return headlineText;
	}

	@Override
	protected void run() {
		
		ShowSuper showsuper = new ShowEigenschaften();
        RootPanel.get("Details").add(showsuper);
		
		
	}


}
