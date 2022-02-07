package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Article;
import fr.eni.projet.bo.Utilisateur;

public interface ArticleDAO {

	public void insertArticle(Article article) throws DALException;

	public List<Article> selectAll() throws DALException;

	public Article selectById(int id) throws DALException;

	public List<Article> selectByCat(int id) throws DALException;

	public List<Article> selectByNoUtilisateur(Utilisateur user) throws DALException;

}
