package de.hdm.iWork.server;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.iWork.server.db.EigenschaftMapper;
import de.hdm.iWork.server.db.InhaltMapper;
import de.hdm.iWork.server.db.StellenausschreibungMapper;
import de.hdm.iWork.shared.IWorkAdministration;
import de.hdm.iWork.shared.bo.*;

@SuppressWarnings("serial")
public class IWorkAdministrationImpl extends RemoteServiceServlet implements IWorkAdministration {

	private EigenschaftMapper eigenschaftMapper = null;
	private InhaltMapper inhaltMapper = null;
	private StellenausschreibungMapper stellenMapper = null;

	public IWorkAdministrationImpl() throws IllegalArgumentException {

	}

	public void init() throws IllegalArgumentException {

		this.eigenschaftMapper = EigenschaftMapper.eigenschaftMapper();
		this.stellenMapper = StellenausschreibungMapper.stellenausschreibungMapper();

	}

	public Vector<Eigenschaft> getAllEigenschaften() throws IllegalArgumentException {

		return this.eigenschaftMapper.getAllEigenschaften();
	}

	public Vector<Inhalt> getAllInhalteFor(int i) throws IllegalArgumentException {
		return this.inhaltMapper.getAllInhalteFor(i);
	}

	public Stellenausschreibung createStellenausschreibung(int stellenId, String bezeichnung, String beschreibung) throws IllegalArgumentException {

		Stellenausschreibung s = new Stellenausschreibung();
		s.setBezeichnug(bezeichnung);
		s.setBeschreibungstext(beschreibung);

		return this.stellenMapper.insertTest(s, stellenId);
	}

	public Stellenausschreibung getStellenanzeige(int stellenid)
			throws IllegalArgumentException {

		return this.stellenMapper.getStellenTest(stellenid);
	}

}
