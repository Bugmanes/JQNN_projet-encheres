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
	private final static String UPDATE_ENCHERE = "UPDATE ENCHERES SET montant_enchere=?, date_enchere=? WHERE no_article=? and no_utilisateur=?;";
	private final static String SELECT_BY_ARTICLE_USER = "SELECT * FROM ENCHERES WHERE no_article=? and no_utilisateur=?;";

	@Override
	// supprimer une enchere
	public void deleteEnchere(int numUtil) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;

		try {
			cnx = ConnexionProvider.getConnection();
			pstmt.setInt(1, numUtil);
			pstmt.executeUpdate();
			
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			throw new DALException("probleme de deleteEnchere ", e);
		}
	}

	@Override
	// creer une enchere
	public void insertEnchere(Enchere enchere) throws DALException {

		Connection cnx;
		PreparedStatement pstmt;
		ResultSet rs;

		try {
			// preparer les parametres
			cnx = ConnexionProvider.getConnection();
			pstmt = cnx.prepareStatement(SELECT_BY_ARTICLE_USER);
			pstmt.setInt(1, enchere.getArticle().getNoArticle());
			pstmt.setInt(2, enchere.getUtilisateur().getNoUtilisateur());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				pstmt = cnx.prepareStatement(UPDATE_ENCHERE);
				pstmt.setInt(1, enchere.getMontantEnchere());
				pstmt.setDate(2, Date.valueOf(enchere.getDateEnchere()));
				pstmt.setInt(3, enchere.getArticle().getNoArticle());
				pstmt.setInt(4, enchere.getUtilisateur().getNoUtilisateur());
				pstmt.executeUpdate();
			} else {
				pstmt = cnx.prepareStatement(INSERT_ENCHERE);
				pstmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
				pstmt.setInt(2, enchere.getArticle().getNoArticle());
				pstmt.setDate(3, Date.valueOf(enchere.getDateEnchere()));
				pstmt.setInt(4, enchere.getMontantEnchere());
				pstmt.executeUpdate();
			}
			rs.close();
			pstmt.close();
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
			
			rs.close();
			stmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			throw new DALException("problème avec la méthode selectByNoArticle de EnchereDAO", e);
		}

		return encheres;
	}

}
