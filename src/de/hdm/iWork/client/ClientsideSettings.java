package de.hdm.iWork.client;

import com.google.gwt.core.client.GWT;

import de.hdm.iWork.shared.CommonSettings;
import de.hdm.iWork.shared.IWorkAdministration;
import de.hdm.iWork.shared.IWorkAdministrationAsync;

public class ClientsideSettings extends CommonSettings {
	
	private static IWorkAdministrationAsync iWorkAdministration = null;
	
	public static IWorkAdministrationAsync getIWorkAdministration(){
				
		if (iWorkAdministration == null){
			
			iWorkAdministration = GWT.create(IWorkAdministration.class);
		}
		
		return iWorkAdministration;
	}

}
