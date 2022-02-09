package fr.eni.projet.bo;

public class Retrait {

	private String rue;
	private String codePostal;
	private String ville;
	private Article article;
	private boolean retire;

	public boolean isRetire() {
		return retire;
	}

	public void setRetire(boolean retire) {
		this.retire = retire;
	}

	public Retrait() {
	}

	// methode pour avoir des informations sur un retrait
	public Retrait(String rue, String codePostal, String ville, Article article) {
		
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setArticle(article);
		setRetire(false);
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
