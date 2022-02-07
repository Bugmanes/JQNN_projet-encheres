package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.bo.Article;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class ArticleDaoImpl implements ArticleDAO {

	// insertion des requettes SQL
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
	private final static String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?;";
	private final static String SELECT_BY_CAT = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie=? ;";

	@Override
	public void insertArticle(Article article) throws DALException {

		try {
			Connection cnx = ConnexionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			// insertion des parametres dans la base de données
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
			stmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			stmt.setInt(5, article.getPrixInitial());
			stmt.setInt(6, article.getVendeur().getNoUtilisateur());
			stmt.setInt(7, article.getCategorie().getNoCategorie());
			stmt.executeQuery();
			ResultSet rs = stmt.getGeneratedKeys();
			article.setNoArticle(rs.getInt(1));
			// fermeture de connection...
			rs.close();
			stmt.close();
			cnx.close();

		} catch (SQLException e) {
			throw new DALException("problème dans la méthode insertArticle", e);
		}

	}

	@Override
	public List<Article> selectAll() throws DALException {
		// creation d'une liste "article"
		List<Article> liste_article = new ArrayList<>();
		// parametre de la liste
		Article art;
		Categorie cat;
		Utilisateur user;
		UtilisateurDAO udao = DAOFactory.getUtilisateurDAO();
		CategorieDAO cdao = DAOFactory.getCategorieDAO();
		try {
			// déclaration de mes variable
			Connection cnx;
			Statement stmt;
			ResultSet rs;
			// hydrataion de mes varibales
			cnx = ConnexionProvider.getConnection();
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);

			while (rs.next()) {

				user = udao.selectById(rs.getInt("no_utilisateur"));
				cat = cdao.selectById(rs.getInt("no_categorie"));

				art = new Article(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date-debut-encheres").toLocalDate(), rs.getDate("date-fin-encheres").toLocalDate(),
						rs.getInt("prix_initial"), user, cat);
				liste_article.add(art);

			}
		} catch (SQLException e) {
			throw new DALException("problème avec la méthode selectAll article", e);
		}
		return liste_article;
	}

	@Override
	public Article selectById(int id) throws DALException {

		Article article = null;
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Utilisateur user = null;
		Categorie cat = null;
		UtilisateurDAO udao = DAOFactory.getUtilisateurDAO();
		CategorieDAO cdao = DAOFactory.getCategorieDAO();

		try {
			cnx = ConnexionProvider.getConnection();
			stmt = cnx.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				user = udao.selectById(rs.getInt("no_utilisateur"));
				cat = cdao.selectById(rs.getInt("no_categorie"));
				article = new Article(rs.getString("nom_article"), rs.getString("descritpion"),
						rs.getDate("date_debut_enchere").toLocalDate(), rs.getDate("date_fin_enchere").toLocalDate(),
						rs.getInt("prix_initial"), user, cat);
				article.setNoArticle(id);
			}

		} catch (SQLException e) {
			throw new DALException("problème avec la méthode selectById d'article", e);
		}

		return article;
	}

	@Override
	public List<Article> selectByCat(int id) throws DALException {
		List<Article> liste_article = new ArrayList<>();
		Article article = null;
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Utilisateur user = null;
		Categorie cat = null;
		UtilisateurDAO udao = DAOFactory.getUtilisateurDAO();
		CategorieDAO cdao = DAOFactory.getCategorieDAO();

		try {
			cnx = ConnexionProvider.getConnection();
			pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = udao.selectById(rs.getInt("no_utilisateur"));
				cat = cdao.selectById(rs.getInt("no_categorie"));
				article = new Article(rs.getString("nom_article"), rs.getString("descritpion"),
						rs.getDate("date_debut_enchere").toLocalDate(), rs.getDate("date_fin_enchere").toLocalDate(),
						rs.getInt("prix_initial"), user, cat);
				article.setCategorie(cat);
				liste_article.add(article);
			}

		} catch (SQLException e) {
			throw new DALException("problème avec la méthode selectByCat d'article", e);
		}

		return liste_article;
	}
}
