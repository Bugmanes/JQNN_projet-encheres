package fr.eni.projet.bo;

import java.sql.Date;

public class Enchere {

	// Declaratio des attributes
	private Date dateEnchere;
	private int montantEnchere;
	private Utilisateur utilisateur;
	private Article article;

	// Constracteur vide
	public Enchere() {
	}

	// constructeur surchargé
	public Enchere(Date dateEnchere, int montantEnchere, Utilisateur utilisateur, Article article) {
		setDateEnchere(dateEnchere);
		setMontantEnchere(montantEnchere);
		setUtilisateur(utilisateur);
		setArticle(article);
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
