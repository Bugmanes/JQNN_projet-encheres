package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;

import fr.eni.projet.bo.Article;
import fr.eni.projet.util.ConnexionProvider;

public class ArticleDaoImpl implements ArticleDAO {

	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date-debut-encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?);";

	@Override
	public void insertArticle(Article article) {

		try {
			Connection cnx = ConnexionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			//DateFormat form = new SimpleDateFormat("yyyy-mm-dd");
			ZoneId defaultZoneId = ZoneId.systemDefault();
			stmt.setDate(3, Date.from(article.getDateDebutEncheres().atStartOfDay(defaultZoneId).toInstant()));
			stmt.setDate(4, article.getDateFinEncheres());
			stmt.setInt(5, article.getPrixInitial());
			stmt.setInt(6, article.getVendeur().getNoUtilisateur());
			stmt.setInt(7, article.getCategorie().getNoCategorie());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
