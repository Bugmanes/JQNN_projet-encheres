package fr.eni.projet.dal;

import java.util.ArrayList;

import fr.eni.projet.bo.Categorie;

public interface CategorieDAO {
	
	public ArrayList<Categorie> selectAll() throws DALException;

	public Categorie selectById(int id) throws DALException;

}
