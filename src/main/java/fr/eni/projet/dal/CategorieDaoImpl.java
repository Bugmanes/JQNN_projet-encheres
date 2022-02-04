package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class CategorieDaoImpl implements CategorieDAO {

	//insertion methodes SQL
	private final static String SELECT_ALL = "SELECT * FROM CATEGORIES;";
	private final static String SELECT_BY_ID = "SELECT * FROM Articles_Vendus WHERE id = ?;";

	@Override
	public ArrayList<Categorie> selectAll() throws DALException {

		Categorie categorie;
		ArrayList<Categorie> categories = new ArrayList<>();

		try {
			Connection cnx = ConnexionProvider.getConnection();
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
				categories.add(categorie);
			}
			//fermeture de connection ...
			rs.close();
			stmt.close();
			cnx.close();
		} catch (SQLException e) {
			throw new DALException("problème avec la méthode selectAll de catégorie", e);
		}

		return categories;
	}

	@Override
	public Categorie selectById(int id) throws DALException {
		//declaration de mes variables
		Categorie categorie = null;
		Connection cnx;
		ResultSet rs;
		PreparedStatement pstmt;

		// récupération de la connexion
		try {
			//hydratation de mes variables
			cnx = ConnexionProvider.getConnection();
			pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
				categorie.setNoCategorie(id);
			}
			//fermeture de connction...
			rs.close();
			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			throw new DALException("problème avec la méthode selectById de catégorie", e);
		}

		return categorie;
	}

}
