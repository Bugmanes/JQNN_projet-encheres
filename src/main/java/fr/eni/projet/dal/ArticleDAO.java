package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Article;

public interface ArticleDAO {

	public void insertArticle(Article article) throws DALException;

	public List<Article> selectAll() throws DALException;

	public Article selectById(int id) throws DALException;

	public List<Article> selectByCat(int id) throws DALException;

	public List<Article> selectByNomUtilisateur(Article article) throws DALException;

}
