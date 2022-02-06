package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class EnchereDaoImpl implements EnchereDAO {

	private static final String DELETE_ENCHERE = "DELETE FROM ENCHERES where no_utilisateur = ?;";

	@Override
	public void deleteEnchere(int numUtil) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;

		try {
			cnx = ConnexionProvider.getConnection();
			pstmt.setInt(1, numUtil);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("problem de deleteEnchere ", e);
		}
	}

	
	
}
