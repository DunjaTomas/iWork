package de.hdm.iWork.server.db;

import java.sql.*;
import com.google.appengine.api.utils.SystemProperty;

public class DBConnection {

	private static Driver drv;
	private static Connection con = null;

//	private static String googleUrl = "";
	private static String localUrl = "jdbc:mysql://127.0.0.1:3306/iwork?user=root&password=";

	public static Connection connection() {

		if (con == null) {

			String url = null;

			try {
				
				drv = new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(drv);
				
				/*
				 * Check ob man sich in der Produktiveumgebung befindet oder
				 * noch in Entwicklungsumgebung. Je nach dem werden
				 * unterschiedliche Diver und URL geladen.
				 */
//				if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//					/**
//					 * Class ist eine Klasse die von Java stammt, diese
//					 * instanziiert
//					 */
//					Class.forName("com.mysql.jdbc.GoogleDriver");
//					url = googleUrl;
//
//				} else {

					Class.forName("com.mysql.jdbc.Driver");
					url = localUrl;

//				}

				con = DriverManager.getConnection(url);

			} catch (Exception e) {
				con = null;
				e.printStackTrace();
			}

		}
		return con;
	}

}
