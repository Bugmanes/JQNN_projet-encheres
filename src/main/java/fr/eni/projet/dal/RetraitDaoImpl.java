package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projet.bo.Retrait;
import fr.eni.projet.util.ConnexionProvider;

public class RetraitDaoImpl implements RetraitDAO {

	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS (no_article, rue, code_posta, ville) VALUES (?, ?, ?, ?);";
	
	public void insertRetrait(Retrait retrait) throws DALException {
		
		Connection cnx;
		PreparedStatement stmt;
		
		try {
			cnx = ConnexionProvider.getConnection();
			stmt = cnx.prepareStatement(INSERT_RETRAIT);
			stmt.setInt(1, retrait.getArticle().getNoArticle());
			stmt.setString(2, retrait.getRue());
			stmt.setString(3, retrait.getCodePostal());
			stmt.setString(4, retrait.getVille());
			stmt.executeUpdate();		
		} catch (SQLException e) {
			throw new DALException("probleme avec la methode insertRetrait", e);
		}
	}
}
