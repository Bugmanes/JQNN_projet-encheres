package fr.eni.projet.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.bo.Article;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.ArticleDAO;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.EnchereDAO;

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
		// insertion d'une liste d'article
		List<Article> liste = adao.selectAll();

		return liste;
	};

	//methode de listage d'article en fonction de la catégorie
	public List<Article> listerArticlesCat(int id) throws DALException {

		ArticleDAO adao = DAOFactory.getArticleDAO();
		//insertion d'une liste d'article
		List<Article> liste = adao.selectByCat(id);

		return liste;
	};
	
	// methode pour creer une nouvelle vente
	public void nouvelleVente(String nom, String description, LocalDate debut, LocalDate fin, int prixInitial,
			Utilisateur utilisateur, Categorie categorie) throws DALException {

		Article article = new Article(nom, description, debut, fin, prixInitial, utilisateur, categorie);
		ArticleDAO aDAO = DAOFactory.getArticleDAO();
		aDAO.insertArticle(article);
	}

	public Article obtenirArticle(int id) throws DALException {

		Article article = null;
		ArticleDAO adao = null;

		adao = DAOFactory.getArticleDAO();
		article = adao.selectById(id);

		return article;
	}

	public void encherir(Utilisateur user, Article art, int montantEnchere) throws DALException {
		Enchere enchere = new Enchere(LocalDate.now(), montantEnchere, user, art);
		art.ajouterEnchere(user, enchere);
		EnchereDAO edao = DAOFactory.getEnchereDAO();
		edao.insertEnchere(enchere);
	}

	public boolean verifEnchere(Article art, int enchere) {

		boolean ok = true;

		if (enchere <= art.getPrixVentes()) {
			ok = false;
		}

		return ok;
	}
}
