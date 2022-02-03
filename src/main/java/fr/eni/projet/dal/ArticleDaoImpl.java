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
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class ArticleDaoImpl implements ArticleDAO {

	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date-debut-encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?);";
private static final String SELECT_ARTICLE="SELECT (nom_article, description, date-debut-encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie)FROM ARTICLES_VENDUS";
	
	@Override
	public void insertArticle(Article article) {

		try {
			Connection cnx = ConnexionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
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
			rs.close();
			stmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Article> selectAll() {
		List<Article> liste_article = new ArrayList<>();
		try {
			//déclaration de mes variable
			Connection cnx;
			Statement stmt ;
			ResultSet rs;
			//hydrataion de mes varibales
			cnx = ConnexionProvider.getConnection();
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(SELECT_ARTICLE);
			
			Article art = new Article();
			while(rs.next()) {
//				Date date = LocalDate.valueOf(date);
//				LocalDate local;
//				date.toLocalDate();
				Utilisateur user;
				user.getNoUtilisateur();                                                                        
			 art = new Article(rs.getString("nom_article"), rs.getString("description"),
					 rs.getDate("date-debut-encheres").toLocalDate(), rs.getDate("date-fin-encheres").toLocalDate(),
					 rs.getInt("prix_initial"),rs.getInt("no_utilisateur"),rs.getInt("no_categorie") );
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
