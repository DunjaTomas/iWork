package de.hdm.iWork.server.db;

import java.sql.*;
import de.hdm.iWork.shared.bo.*;

public class ProfilMapper {

	/**
	 * Statische Variable
	 */
	private static ProfilMapper profilMapper = null;
	
	/**
	 * Geschuetzter Konstruktur
	 */
	protected ProfilMapper(){
	}
	
	/**
	 * Statische Methode zur Sicherstellung der Singleton-Eigenschaft von ProfilMapper
	 */
	public static ProfilMapper profilMapper() {
		if (profilMapper == null) {
			profilMapper = new ProfilMapper();
		    }

		    return profilMapper;
	}
}
