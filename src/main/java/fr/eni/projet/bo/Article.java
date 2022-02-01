package fr.eni.projet.bo;

import java.time.LocalDate;

public class Article {
	//Attribut de la classe Article
private int noArticle;
private String nomArticle;
private String description;
private LocalDate dateDebutEncheres;
private LocalDate dateFinEncheres;
private int prixInitial;
private int prixVentes;


//constructeur par defaut de la classe Article
public Article() {
	
}


//coonstructeur surcharger de la classe Article
public Article(int noArticle,String nomArticle,  String description, LocalDate dateDebutEncheres,
		LocalDate dateFinEncheres, int prixInitial, int prixVentes) {
	
	setNoArticle(noArticle);
	//ertyuzertyui
	setNomArticle(nomArticle);
	setDescription(description);
	setDateDebutEncheres(dateDebutEncheres);
	setDateFinEncheres( dateFinEncheres);
	setPrixInitial(prixInitial);
	setPrixVentes( prixVentes);
}

//getter and setter
public int getNoArticle() {
	return noArticle;
}


public void setNoArticle(int noArticle) {
	this.noArticle = noArticle;
}

public String getNomArticle() {
	return nomArticle;
}

public void setNomArticle(String nomArticle) {
	this.nomArticle = nomArticle;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public LocalDate getDateDebutEncheres() {
	return dateDebutEncheres;
}


public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
	this.dateDebutEncheres = dateDebutEncheres;
}


public LocalDate getDateFinEncheres() {
	return dateFinEncheres;
}


public void setDateFinEncheres(LocalDate dateFinEncheres) {
	this.dateFinEncheres = dateFinEncheres;
}


public int getPrixInitial() {
	return prixInitial;
}


public void setPrixInitial(int prixInitial) {
	this.prixInitial = prixInitial;
}


public int getPrixVentes() {
	return prixVentes;
}


public void setPrixVentes(int prixVentes) {
	this.prixVentes = prixVentes;
}






}
