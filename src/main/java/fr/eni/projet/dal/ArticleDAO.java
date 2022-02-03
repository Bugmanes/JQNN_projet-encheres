package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Article;

public interface ArticleDAO {

	public void insertArticle(Article article);

	
	public List<Article> selectAll();

		
	
}

