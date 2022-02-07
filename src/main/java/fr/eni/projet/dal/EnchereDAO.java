package fr.eni.projet.dal;

import fr.eni.projet.bo.Enchere;

public interface EnchereDAO {
	
	public void deleteEnchere(int numUtil) throws DALException;
	public void insertEnchere(Enchere enchere) throws DALException; 
}
