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

			stmt.executeUpdate(
					"UPDATE stellenausschreibung " + "SET bezeichnung\"" + stellenausschreibung.getBezeichnung()
							+ "\", " + " beschreibung=\"" + stellenausschreibung.getBeschreibungstext() + "\", "
							+ " frist=\"" + stellenausschreibung.getFrist() + "\" " + "WHERE stellenid="
							+ stellenausschreibung.getStellenId());
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

	public Stellenausschreibung insertTest(Stellenausschreibung s, int stellenId) {

		// String sql;
		// Statement stm=null;
		// ResultSet rs;
		// ResultSetMetaData rsmd;
		// int felder;

		// System.out.println("Methode Insert betreten");
		Connection con = DBConnection.connection();

		// if (con == null) {
		// System.out.println("FEHLER");
		// }

		try {
			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery("SELECT MAX(stellenid) AS maxstellenid " + "FROM test");

			if (rs.next()) {

				s.setStellenId(rs.getInt("maxstellenid") + 1);

				stm = con.createStatement();
				stm.executeUpdate("INSERT INTO test (stellenid, bezeichnung, beschreibung) VALUES(" + s.getStellenId()
						+ ",'" + s.getBezeichnung() + "','" + s.getBeschreibungstext() + "')");
			}

			/*
			 * Einfuegeoperation
			 */
			// sql = "SELECT * FROM test";
			//
			// rs = stm.executeQuery(sql);
			// rsmd = rs.getMetaData();
			//
			// felder = rsmd.getColumnCount();
			//
			// while (rs.next()) {
			// for (int i = 1; i <= felder; i++) {
			// System.out.print(rs.getString(i) + ';');
			// }
			// System.out.println();
			// }
			//
			// stm.close();
			// con.close();

			// stmt.executeUpdate("INSERT INTO test (bezeichnung,beschreibung) "
			// + "VALUES('" + s.getBezeichnung() + "','"
			// + s.getBeschreibungstext() + "')");

		}

		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return s;
	}

	public Stellenausschreibung getStellenTest(int stellenid) {
		Connection con = DBConnection.connection();

		try {

			Statement stmt = con.createStatement();
			//
			ResultSet rs = stmt.executeQuery(
					"SELECT stellenid, bezeichnung, beschreibung FROM test WHERE stellenid= " + stellenid);

			// ResultSet rs = stmt.executeQuery("SELECT * FROM test " + "WHERE
			// stellenid= " + stellenid);
			//
			if (rs.next()) {
				Stellenausschreibung s = new Stellenausschreibung();
				s.setStellenId(rs.getInt("stellenid"));
				s.setBezeichnug("bezeichnung");
				s.setBeschreibungstext("beschreibung");

				return s;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		return null;
	}

}