package de.hdm.iWork.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.iWork.shared.bo.*;



@RemoteServiceRelativePath("iworkadministration")
public interface IWorkAdministration extends RemoteService {

	public void init() throws IllegalArgumentException;
	
	/**
	 * Alle Eigenschaften auslesen
	 */
	
	public Vector<Eigenschaft> getAllEigenschaften() throws IllegalArgumentException;
	
	public Vector<Inhalt> getAllInhalteFor(int i) throws IllegalArgumentException;
	
	
}
