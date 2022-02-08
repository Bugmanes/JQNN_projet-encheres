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
	
	public void deleteArticle(Article article) throws DALException;

	public List<Article> selectByMotsCles (String motsCles) throws DALException;
	
	public List<Article> selectEncheresOuvertes (Utilisateur user1) throws DALException;
	
	public List<Article> selectMesEncheresEnCours (Utilisateur user1) throws DALException;
	
	public List<Article> selectMesEncheresremportees (Utilisateur user1) throws DALException;
}
