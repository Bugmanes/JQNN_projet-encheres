package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Article;
import fr.eni.projet.bo.Enchere;

public interface EnchereDAO {
	
	public void deleteEnchere(int numUtil) throws DALException;
	public void insertEnchere(Enchere enchere) throws DALException; 
	public List<Enchere> selectByNoArticle (Article art) throws DALException;
}
