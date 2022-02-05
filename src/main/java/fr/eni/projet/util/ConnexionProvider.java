package fr.eni.projet.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnexionProvider {

	private static DataSource datasource;

	static {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/EncheresCNXPool");
		} catch (NamingException e) {
			System.err.println(e.getMessage());
		}
	}

	public static Connection getConnection() throws SQLException {

		return datasource.getConnection();
	}
}
