package fr.eni.projet.bo;

public class Retrait {

	//déclaration de mes variables
	private String rue;
	private String codePostal;
	private String ville;
	private Article article;

	public Retrait() {
	}

	//methode pour avoir des informations sur un retrait
	public Retrait(String rue, String codePostal, String ville, Article article) {
		
		//insertion des paramétres
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setArticle(article);
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
