package de.hdm.iWork.server.db;

import java.sql.*;
import java.util.*;

import de.hdm.iWork.shared.bo.Eigenschaft;
import de.hdm.iWork.shared.bo.Inhalt;
import de.hdm.iWork.shared.bo.Stellenbeschreibung;

/**
 * Diese Klasse stellt die Verbindung zwischen der Klasse Stellenbeschreibung
 * und der Datenbank dar.
 * 
 * @author Nina
 *
 */
public class StellenbeschreibungMapper {

	// statische Variable
	private static StellenbeschreibungMapper stellenbeschreibungMapper = null;

	// Geschützter Konstruktor
	protected StellenbeschreibungMapper() {
	}

	// Statische Methode die Singeltone Eigenschaft sicherstellt
	public static StellenbeschreibungMapper stellenbeschreibungMapper() {
		if (stellenbeschreibungMapper == null) {
			stellenbeschreibungMapper = new StellenbeschreibungMapper();
		}
		return stellenbeschreibungMapper;
	}

	// Neue Stellenbeschreibung erstellen
	public Stellenbeschreibung anlegenStellenbeschreibung(Stellenbeschreibung stellenbeschreibung) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(stellenId) AS maxid " + "FROM stellenbeschreibung ");

			if (rs.next()) {

				/*
				 * StellenbeschreibungId des Objekts wird gesetzt und dabei um 1
				 * erhoeht
				 */
				stellenbeschreibung.setStellenId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				/*
				 * Einfuegeoperation
				 */
				stmt.executeUpdate("INSERT INTO stellenbeschreibung (stellenId,bezeichnung,beschreibungstext,frist) "
						+ "VALUES (" + stellenbeschreibung.getStellenId() + "," + stellenbeschreibung.getBezeichnung()
						+ "," + stellenbeschreibung.getBeschreibungstext() + "," + stellenbeschreibung.getFrist()
						+ ")");
			}
		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return stellenbeschreibung;
	}

	// Bestehende Stellenbeschreibung verändern
	public Stellenbeschreibung updateStellenbeschreibung(Stellenbeschreibung stellenbeschreibung) {

		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE stellenbeschreibung " + "SET bezeichnung\""
					+ stellenbeschreibung.getBezeichnung() + "\", " + " beschreibungstext=\""
					+ stellenbeschreibung.getBeschreibungstext() + "\", " + " frist=\"" + stellenbeschreibung.getFrist()
					+ "\" " + "WHERE stellenId=" + stellenbeschreibung.getStellenId());
		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}

		return stellenbeschreibung;
	}

	// Bestehende Stellenbeschreibung löschen
	public void loeschenStellenbeschreibung(Stellenbeschreibung stellenbeschreibung) {
		Connection con = DBConnection.connection();

		try {

			Statement stmt = con.createStatement();

			stmt.executeUpdate(
					"DELETE FROM stellenbeschreibung " + "WHERE stellenId=" + stellenbeschreibung.getStellenId());
		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	// Ausgabe aller Stellenbeschreibungen zu einer bestimmten StellenId
	public Stellenbeschreibung getStellenbeschreibungById(int stellenId) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT stellenId, bezeichnung, bezeichnungstext, frist FROM stellenbeschreibung "
							+ "WHERE stellenId=" + stellenId);

			if (rs.next()) {
				Stellenbeschreibung stellenbeschreibung = new Stellenbeschreibung();
				stellenbeschreibung.setStellenId(rs.getInt("stellenId"));
				stellenbeschreibung.setBezeichnug(rs.getString("bezeichnung"));
				stellenbeschreibung.setBeschreibungstext(rs.getString("beschreibungstext"));
				stellenbeschreibung.setFrist(rs.getDate("frist"));
				return stellenbeschreibung;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return null;
	}

	// Ausgabe aller Stellenbeschreibungen
	public Vector<Stellenbeschreibung> getAllStellenbeschreibungen() {

		Connection con = DBConnection.connection();

		Vector<Stellenbeschreibung> result = new Vector<Stellenbeschreibung>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM stellenbeschreibung");

			while (rs.next()) {
				Stellenbeschreibung stellenbeschreibung = new Stellenbeschreibung();

				stellenbeschreibung.setStellenId(rs.getInt("stellenId"));
				stellenbeschreibung.setBezeichnug(rs.getString("bezeichnung"));
				stellenbeschreibung.setBeschreibungstext(rs.getString("beschreibungstext"));
				stellenbeschreibung.setFrist(rs.getDate("frist"));

				result.add(stellenbeschreibung);
			}

		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return result;
	}

	// Ausgabe aller Stellenbeschreibungen zu einer bestimmten ProfilId
	public Vector<Stellenbeschreibung> getStellenbeschreibungByProfilId(int profilId) {

		Connection con = DBConnection.connection();

		Vector<Stellenbeschreibung> result = new Vector<Stellenbeschreibung>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT stellenId, bezeichnung, bezeichnungstext, frist FROM stellenbeschreibung "
							+ "WHERE profilId=" + profilId);

			if (rs.next()) {
				Stellenbeschreibung stellenbeschreibung = new Stellenbeschreibung();
				stellenbeschreibung.setStellenId(rs.getInt("stellenId"));
				stellenbeschreibung.setBezeichnug(rs.getString("bezeichnung"));
				stellenbeschreibung.setBeschreibungstext(rs.getString("beschreibungstext"));
				stellenbeschreibung.setFrist(rs.getDate("frist"));
				result.add(stellenbeschreibung);
				return result;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return null;
	}

}