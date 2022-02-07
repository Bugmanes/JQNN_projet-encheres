package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.bo.Article;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class EnchereDaoImpl implements EnchereDAO {

	private static final String DELETE_ENCHERE = "DELETE FROM ENCHERES where no_utilisateur = ?;";
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?);";
	private final static String SELECT_BY_NO_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article=?";

	@Override
	// supprimer une enchere
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
	// creer une enchere
	public void insertEnchere(Enchere enchere) throws DALException {

		Connection cnx;
		PreparedStatement stmt;

		try {
			// preparer les parametres
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

	@Override
	public List<Enchere> selectByNoArticle(Article art) throws DALException {

		Enchere enchere;
		List<Enchere> encheres = new ArrayList<Enchere>();
		Connection cnx;
		PreparedStatement stmt;
		ResultSet rs;
		UtilisateurDAO udao = DAOFactory.getUtilisateurDAO();
		Utilisateur user;

		try {
			cnx = ConnexionProvider.getConnection();
			stmt = cnx.prepareStatement(SELECT_BY_NO_ARTICLE);
			stmt.setInt(1, art.getNoArticle());
			rs = stmt.executeQuery();

			while (rs.next()) {
				// recuperation des informations de l'utilisateur grace a son numero("no_utilisateur")
				user = udao.selectById(rs.getInt("no_utilisateur"));
				enchere = new Enchere(rs.getDate("date_enchere").toLocalDate(), rs.getInt("montant_enchere"), user,
						art);
				// ajout de l'enchere
				encheres.add(enchere);
			}
			
		} catch (SQLException e) {
			throw new DALException("problème avec la méthode selectByNoArticle de EnchereDAO", e);
		}

		return encheres;
	}

}
