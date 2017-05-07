package de.hdm.iWork.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.iWork.shared.bo.*;


public interface IWorkAdministration extends RemoteService {

	public void init() throws IllegalArgumentException;
	
	/**
	 * Alle Eigenschaften auslesen
	 */
	
	public Vector<Eigenschaft> getAllEigenschaften() throws IllegalArgumentException;
	
	
}
