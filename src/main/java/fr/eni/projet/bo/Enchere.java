package fr.eni.projet.bo;

import java.sql.Date;

public class Enchere {
	
	//Declaratio des attributes
	private Date dateEnchere;
	private int montantEnchere;
	private Utilisateur utilisateur;
	private Article article;
	
	//Constracteur vide 
	public Enchere() {
	}

	public Enchere(Date dateEnchere, int montantEnchere, Utilisateur utilisateur, Article article) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.article = article;
	}
	
	

}
