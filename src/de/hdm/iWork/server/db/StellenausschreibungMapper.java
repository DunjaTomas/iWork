package de.hdm.iWork.server.db;

import java.sql.*;
import java.util.*;

import de.hdm.iWork.shared.bo.Stellenausschreibung;

/**
 * Diese Klasse stellt die Verbindung zwischen der Klasse Stellenausschreibung
 * und der Datenbank dar.
 * 
 * @author Nina
 *
 */
public class StellenausschreibungMapper {

	// statische Variable
	private static StellenausschreibungMapper stellenausschreibungMapper = null;

	// Geschützter Konstruktor
	protected StellenausschreibungMapper() {
	}

	// Statische Methode die Singeltone Eigenschaft sicherstellt
	public static StellenausschreibungMapper stellenausschreibungMapper() {
		if (stellenausschreibungMapper == null) {
			stellenausschreibungMapper = new StellenausschreibungMapper();
		}
		return stellenausschreibungMapper;
	}

	// Neue Stellenausschreibung erstellen
	public Stellenausschreibung anlegenStellenbeschreibung(Stellenausschreibung stellenausschreibung) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(stellenid) AS maxid " + "FROM stellenausschreibung ");

			if (rs.next()) {

				/*
				 * StellenbeschreibungId des Objekts wird gesetzt und dabei um 1
				 * erhoeht
				 */
				stellenausschreibung.setStellenId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				/*
				 * Einfuegeoperation
				 */
				stmt.executeUpdate("INSERT INTO stellenausschreibung (stellenid,bezeichnung,beschreibung,frist) "
						+ "VALUES (" + stellenausschreibung.getStellenId() + "," + stellenausschreibung.getBezeichnung()
						+ "," + stellenausschreibung.getBeschreibungstext() + "," + stellenausschreibung.getFrist()
						+ ")");
			}
		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return stellenausschreibung;
	}

	// Bestehende Stellenausschreibung verändern
	public Stellenausschreibung updateStellenbeschreibung(Stellenausschreibung stellenausschreibung) {

		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE stellenausschreibung " + "SET bezeichnung\""
					+ stellenausschreibung.getBezeichnung() + "\", " + " beschreibung=\""
					+ stellenausschreibung.getBeschreibungstext() + "\", " + " frist=\"" + stellenausschreibung.getFrist()
					+ "\" " + "WHERE stellenid=" + stellenausschreibung.getStellenId());
		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}

		return stellenausschreibung;
	}

	// Bestehende Stellenausschreibung löschen
	public void loeschenStellenbeschreibung(Stellenausschreibung stellenausschreibung) {
		Connection con = DBConnection.connection();

		try {

			Statement stmt = con.createStatement();

			stmt.executeUpdate(
					"DELETE FROM stellenausschreibung " + "WHERE stellenid=" + stellenausschreibung.getStellenId());
		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	// Ausgabe aller Stellenbeschreibungen zu einer bestimmten StellenId
	public Stellenausschreibung getStellenbeschreibungById(int stellenId) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT stellenid, bezeichnung, bezeichnung, frist FROM stellenausschreibung "
							+ "WHERE stellenid=" + stellenId);

			if (rs.next()) {
				Stellenausschreibung stellenausschreibung = new Stellenausschreibung();
				stellenausschreibung.setStellenId(rs.getInt("stellenid"));
				stellenausschreibung.setBezeichnug(rs.getString("bezeichnung"));
				stellenausschreibung.setBeschreibungstext(rs.getString("beschreibung"));
				stellenausschreibung.setFrist(rs.getDate("frist"));
				return stellenausschreibung;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return null;
	}

	// Ausgabe aller Stellenbeschreibungen
	public Vector<Stellenausschreibung> getAllStellenbeschreibungen() {

		Connection con = DBConnection.connection();

		Vector<Stellenausschreibung> result = new Vector<Stellenausschreibung>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM stellenausschreibung");

			while (rs.next()) {
				Stellenausschreibung stellenausschreibung = new Stellenausschreibung();

				stellenausschreibung.setStellenId(rs.getInt("stellenid"));
				stellenausschreibung.setBezeichnug(rs.getString("bezeichnung"));
				stellenausschreibung.setBeschreibungstext(rs.getString("beschreibung"));
				stellenausschreibung.setFrist(rs.getDate("frist"));

				result.add(stellenausschreibung);
			}

		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return result;
	}

	// Ausgabe aller Stellenbeschreibungen zu einer bestimmten ProfilId
	public Vector<Stellenausschreibung> getStellenbeschreibungByProfilId(int profilId) {

		Connection con = DBConnection.connection();

		Vector<Stellenausschreibung> result = new Vector<Stellenausschreibung>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT stellenid, bezeichnung, bezeichnung, frist FROM stellenausschreibung "
							+ "WHERE profilid=" + profilId);

			if (rs.next()) {
				Stellenausschreibung stellenausschreibung = new Stellenausschreibung();
				stellenausschreibung.setStellenId(rs.getInt("stellenid"));
				stellenausschreibung.setBezeichnug(rs.getString("bezeichnung"));
				stellenausschreibung.setBeschreibungstext(rs.getString("beschreibung"));
				stellenausschreibung.setFrist(rs.getDate("frist"));
				result.add(stellenausschreibung);
				return result;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return null;
	}

}