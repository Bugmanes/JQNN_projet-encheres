package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Article;

public interface ArticleDAO {

	public void insertArticle(Article article) throws DALException;

	
	public List<Article> selectAll() throws DALException;

		
	
}

