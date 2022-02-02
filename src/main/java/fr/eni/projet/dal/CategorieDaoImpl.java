package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.projet.bo.Categorie;
import fr.eni.projet.util.ConnexionProvider;

public class CategorieDaoImpl implements CategorieDAO {
	
	private final static String SELECT_ALL = "SELECT * FROM CATEGORIES;";

	@Override
	public ArrayList<Categorie> selectAll() {
		
		Categorie categorie;
		ArrayList<Categorie> categories = new ArrayList<>();
		
		try {
			Connection cnx = ConnexionProvider.getConnection();
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				categorie = new Categorie(rs.getString("libelle"));
				categories.add(categorie);
			}
			rs.close();
			stmt.close();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categories;
	}

}
