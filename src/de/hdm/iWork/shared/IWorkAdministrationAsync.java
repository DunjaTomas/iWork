package de.hdm.iWork.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.*;

import de.hdm.iWork.shared.bo.*;

public interface IWorkAdministrationAsync {

	void init(AsyncCallback<Void> callback);

	void getAllEigenschaften(AsyncCallback<Vector<Eigenschaft>> callback);

	void getAllInhalteFor(int i, AsyncCallback<Vector<Inhalt>> callback);

	void createStellenausschreibung(int stellenId, String bezeichnung, String beschreibung, AsyncCallback<Stellenausschreibung> callback);

	void getStellenanzeige(int stellenid, AsyncCallback<Stellenausschreibung> callback);

}
