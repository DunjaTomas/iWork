package de.hdm.iWork.server.db;

import java.sql.*;
import java.util.Vector;

import de.hdm.iWork.shared.bo.Bewerbung;
import de.hdm.iWork.shared.bo.Stellenbeschreibung;

/**
 * Diese Klasse stellt die Verbindung zwischen der Klasse Bewerbung und der
 * Datenbank dar.
 * 
 * @author Nina
 *
 */
public class BewerbungMapper {

	// statische Variable
	private static BewerbungMapper bewerbungMapper = null;

	// Geschützter Konstruktor
	protected BewerbungMapper() {
	}

	// Statische Methode die Singeltone Eigenschaft sicherstellt
	public static BewerbungMapper bewerbungMapper() {
		if (bewerbungMapper == null) {
			bewerbungMapper = new BewerbungMapper();
		}
		return bewerbungMapper;
	}

	// Neue Bewerbung erstellen
	public Bewerbung anlegenBewerbung(Bewerbung bewerbung) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("INSERT INTO bewerbung (stellenid,benutzerid) " + "VALUES (" + bewerbung.getStellenId()
					+ "," + bewerbung.getBenutzerId() + ")");
		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return bewerbung;
	}

	// Bestehende Bewerbung verändern
	public Bewerbung updateBewerbung(Bewerbung bewerbung) {
		Connection con = DBConnection.connection();

		try {

			Statement stmt = con.createStatement();

			stmt.executeUpdate(
					"UPDATE bewerbung " + "SET stellenid=\"" + bewerbung.getStellenId() + "\" " + "WHERE stellenid="
							+ bewerbung.getStellenId() + "AND WHERE benutzerid=" + bewerbung.getBenutzerId());
		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return bewerbung;
	}

	// Bestehende Bewerbung löschen
	public void loeschenBewerbung(Bewerbung bewerbung) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM bewerbung " + "WHERE stellenid" + bewerbung.getStellenId()
					+ "AND WHERE benutzerid=" + bewerbung.getBenutzerId());
		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	// Ausgabe aller Bewerbungen zu einer bestimmten StellenId
	public Vector<Bewerbung> getBewerbungByStellenId(Stellenbeschreibung stellenId) {
		Connection con = DBConnection.connection();

		Vector<Bewerbung> result = new Vector<Bewerbung>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT stellenid, benutzerid FROM bewerbung " + "WHERE stellenid=" + stellenId);

			if (rs.next()) {
				Bewerbung bewerbung = new Bewerbung();
				bewerbung.setStellenId(rs.getInt("stellenid"));
				bewerbung.setBenutzerId(rs.getInt("benutzerid"));

				result.add(bewerbung);
				return result;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return null;

	}

	// Ausgabe aller Bewerbungen zu einer bestimmten ProfilId
	public Vector<Bewerbung> getBewerbungByBenutzerId(Bewerbung benutzerId) {
		Connection con = DBConnection.connection();

		Vector<Bewerbung> result = new Vector<Bewerbung>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT stellenid, benutzerlid FROM bewerbung " + "WHERE benutzerid=" + benutzerId);

			if (rs.next()) {
				Bewerbung bewerbung = new Bewerbung();
				bewerbung.setStellenId(rs.getInt("stellenid"));
				bewerbung.setBenutzerId(rs.getInt("benutzerid"));

				result.add(bewerbung);
				return result;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return null;

	}
}
