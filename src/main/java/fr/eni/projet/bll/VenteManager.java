package fr.eni.projet.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import fr.eni.projet.bo.Article;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.ArticleDAO;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.EnchereDAO;
import fr.eni.projet.dal.RetraitDAO;

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
		List<Article> liste = adao.selectDebutToday();

		return liste;
	}

	// methode de listage d'article en fonction de la categorie
	public List<Article> triByCategorie(int id) throws DALException {

		List<Article> selection = null;
		ArticleDAO adao = null;

		adao = DAOFactory.getArticleDAO();
		selection = adao.selectByCat(id);

		return selection;
	}

	public List<Article> triByEncheresOuvertes(Utilisateur user) throws DALException {

		ArticleDAO adao = DAOFactory.getArticleDAO();
		List<Article> selection = adao.selectEncheresOuvertes(user);

		return selection;
	}

	public List<Article> triByEncheresEnCours(Utilisateur user) throws DALException {

		ArticleDAO adao = DAOFactory.getArticleDAO();
		List<Article> selection = adao.selectMesEncheresEnCours(user);

		return selection;
	}

	public List<Article> triByEncheresRemportees(Utilisateur user) throws DALException {

		ArticleDAO adao = DAOFactory.getArticleDAO();
		List<Article> selection = adao.selectMesEncheresremportees(user);

		return selection;
	}

	public List<Article> triByVenteEnCours(Utilisateur user) throws DALException {

		ArticleDAO adao = DAOFactory.getArticleDAO();
		List<Article> selection = adao.selectByNoUtilisateur(user);

		return selection;
	}

	public List<Article> triByVentesNonDebutees(Utilisateur user) throws DALException {

		ArticleDAO adao = DAOFactory.getArticleDAO();
		List<Article> selection = adao.selectVentesNonDebutees(user);

		return selection;
	}

	public List<Article> triByVentesTerminees(Utilisateur user) throws DALException {

		ArticleDAO adao = DAOFactory.getArticleDAO();
		List<Article> selection = adao.selectVentesTerminees(user);

		return selection;
	}

	public List<Article> triByMotsCles(String motsCles) throws DALException {

		List<Article> selection = null;
		ArticleDAO adao = null;

		adao = DAOFactory.getArticleDAO();
		selection = adao.selectByMotsCles(motsCles);

		return selection;
	}

	// methode pour creer une nouvelle vente
	public void nouvelleVente(String nom, String description, LocalDate debut, LocalDate fin, int prixInitial,
			Utilisateur utilisateur, Categorie categorie, String rue, String cp, String ville) throws DALException {

		Article article = new Article(nom, description, debut, fin, prixInitial, utilisateur, categorie);
		ArticleDAO aDAO = DAOFactory.getArticleDAO();
		aDAO.insertArticle(article);
		Retrait retrait = new Retrait(rue, cp, ville, article);
		RetraitDAO rdao = DAOFactory.getRetraitDAO();
		rdao.insertRetrait(retrait);
	}

	public Article obtenirArticle(int id) throws DALException {

		Article article;
		ArticleDAO adao;
		EnchereDAO edao;
		List<Enchere> encheres;
		Enchere meilleurOffre = null;

		// recuperation de l'article en BDD
		adao = DAOFactory.getArticleDAO();
		article = adao.selectById(id);

		// recuperation des encheres sur cet article en BDD
		edao = DAOFactory.getEnchereDAO();
		encheres = edao.selectByNoArticle(article);

		// ajout de la liste d'encheres � l'instance d'article
		article.setEncheres(encheres);

		// recherche de la meilleure offre et modification des parametres de l'article
		for (Enchere enchere : encheres) {
			if (meilleurOffre == null) {
				meilleurOffre = enchere;
			} else if (enchere.getMontantEnchere() > meilleurOffre.getMontantEnchere()) {
				meilleurOffre = enchere;
			}
		}
		if (meilleurOffre != null) {
			article.setAcheteur(meilleurOffre.getUtilisateur());
			article.setPrixVentes(meilleurOffre.getMontantEnchere());
		} else {
			article.setPrixVentes(article.getPrixInitial());
		}

		return article;
	}

	public void encherir(Utilisateur user, Article art, int montantEnchere) throws DALException {
		Enchere enchere = new Enchere(LocalDate.now(), montantEnchere, user, art);
		art.ajouterEnchere(user, enchere);
		EnchereDAO edao = DAOFactory.getEnchereDAO();
		edao.insertEnchere(enchere);
	}
	
	public boolean verifEnchereNombre(String str) {
		boolean ok; 
		char[] c = str.toCharArray();
		
		for (int i=0; i<c.length; i++) {
			ok = Character.isDigit(c[i]);
			if (!ok) {
				return ok;
			}
		}
		ok = true;
		return ok;
	}

	public boolean verifEnchere(Article art, int enchere) {

		boolean ok;

		if (enchere <= art.getPrixVentes()) {
			ok = false;
		} else {
			ok = true;
		}

		return ok;
	}
	
	public boolean verifBudget(Utilisateur user, int enchere) {
		
		boolean ok;
		
		if(enchere > user.getCredit()) {
			ok = false;
		} else {
			ok = true;
		}
		return ok;
	}

}
