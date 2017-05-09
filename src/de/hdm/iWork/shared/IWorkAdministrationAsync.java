package de.hdm.iWork.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.*;

import de.hdm.iWork.shared.bo.*;

public interface IWorkAdministrationAsync {

	void init(AsyncCallback<Void> callback);

	void getAllEigenschaften(AsyncCallback<Vector<Eigenschaft>> callback);

	void getAllInhalteFor(int i, AsyncCallback<Vector<Inhalt>> callback);

	void getAllStellenausschreibungen(AsyncCallback<Vector<Stellenausschreibung>> callback);
}
