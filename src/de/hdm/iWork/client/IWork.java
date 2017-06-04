package de.hdm.iWork.client;

import com.google.gwt.core.client.*;
import com.google.gwt.user.client.ui.*;

import de.hdm.iWork.shared.IWorkAdministrationAsync;
import de.hdm.iWork.shared.bo.Stellenausschreibung;


/**
 * Entry-Point Klasse
 * @author Dunja
 *
 */

public class IWork implements EntryPoint {
	
	

	@Override
	public void onModuleLoad() {
			
			RootPanel.get("Navigator").add(new Navigator ());
		
		
	}

}
