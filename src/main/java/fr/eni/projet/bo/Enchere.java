package fr.eni.projet.bo;

import java.time.LocalDate;

public class Enchere {

	// Declaratio des attributes
	private LocalDate dateEnchere;
	private int montantEnchere;
	private Utilisateur utilisateur;
	private Article article;

	// Constracteur vide
	public Enchere() {
	}

	// constructeur surchargé
	public Enchere(LocalDate dateEnchere, int montantEnchere, Utilisateur utilisateur, Article article) {
		
		//insertion des paramétres
		setDateEnchere(dateEnchere);
		setMontantEnchere(montantEnchere);
		setUtilisateur(utilisateur);
		setArticle(article);
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
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
