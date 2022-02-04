package fr.eni.projet.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.bo.Article;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.ArticleDAO;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;

public class VenteManager {

	private static VenteManager instance;

	private VenteManager() {
 
	}

	public static VenteManager getInstance() {
		if (instance == null) {
			instance = new VenteManager();
		}
		return instance;
	}

	public List<Article> listerArticles() throws DALException {

		ArticleDAO adao = DAOFactory.getArticleDAO();
		//insertion d'une liste d'article
		List<Article> liste = adao.selectAll();

		return liste;
	};

	//methode pour créer une nouvelle vente
	public void nouvelleVente(String nom, String description, LocalDate debut, LocalDate fin, int prixInitial,
			Utilisateur utilisateur, Categorie categorie) throws DALException {

		Article article = new Article(nom, description, debut, fin, prixInitial, utilisateur, categorie);
		ArticleDAO aDAO = DAOFactory.getArticleDAO();
		aDAO.insertArticle(article);
	}

	public Article obtenirArticle(int id) {
		
		Article article = null;
		
		return article;
	}
}
