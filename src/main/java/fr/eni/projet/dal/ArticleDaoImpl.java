package fr.eni.projet.dal;

import fr.eni.projet.bo.Article;

public class ArticleDaoImpl implements ArticleDAO {

	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date-debut-encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?);";

	@Override
	public void insertArticle(Article article) {
		// TODO Auto-generated method stub

	}
}
