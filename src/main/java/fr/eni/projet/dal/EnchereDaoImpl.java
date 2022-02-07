package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projet.bo.Enchere;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class EnchereDaoImpl implements EnchereDAO {

	private static final String DELETE_ENCHERE = "DELETE FROM ENCHERES where no_utilisateur = ?;"; 
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?);";

	@Override
	public void deleteEnchere(int numUtil) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;

		try {
			cnx = ConnexionProvider.getConnection();
			pstmt.setInt(1, numUtil);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("probleme de deleteEnchere ", e);
		}
	}

	@Override
	public void insertEnchere(Enchere enchere) throws DALException {

		Connection cnx;
		PreparedStatement stmt;
		
		try {
			cnx = ConnexionProvider.getConnection();
			stmt = cnx.prepareStatement(INSERT_ENCHERE);
			stmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			stmt.setInt(2, enchere.getArticle().getNoArticle());
			stmt.setDate(3, Date.valueOf(enchere.getDateEnchere()));
			stmt.setInt(4, enchere.getMontantEnchere());
			stmt.executeUpdate();
			
			stmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			throw new DALException("problème avec la méthode insertEnchere", e);
		}
	}

	
	
}
