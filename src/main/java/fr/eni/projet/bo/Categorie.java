package fr.eni.projet.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	private int noCategorie;
	private String libelle;
	private List<Article> articles = new ArrayList<Article>();

	public Categorie() {
	}

	public Categorie(String libelle) {
		setLibelle(libelle);
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
