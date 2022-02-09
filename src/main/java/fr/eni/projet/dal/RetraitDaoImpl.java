package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projet.bo.Article;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.util.ConnexionProvider;

public class RetraitDaoImpl implements RetraitDAO {

	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS (no_article, rue, code_posta, ville) VALUES (?, ?, ?, ?);";
	private final static String SELECT_BY_NO_ARTICLE = "SELECT * FROM RETRAITS WHERE no_article=?;";
	
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
			
			stmt.close();
			cnx.close();
		} catch (SQLException e) {
			throw new DALException("probleme avec la methode insertRetrait", e);
		}
	}

	@Override
	public Retrait selectByNoArticle(Article art) throws DALException {

		Connection cnx;
		PreparedStatement stmt;
		ResultSet rs;
		Retrait retrait = null;
		
		try {
			cnx = ConnexionProvider.getConnection();
			stmt = cnx.prepareStatement(SELECT_BY_NO_ARTICLE);
			stmt.setInt(1, art.getNoArticle());
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				retrait = new Retrait(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), art);
			}
			rs.close();
			stmt.close();
			cnx.close();
		} catch (SQLException e) {
			throw new DALException("probleme avec la methode selectByNoArticle de retrait", e);
		}
		
		return retrait;
	}
}
