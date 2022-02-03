package fr.eni.projet.bll;

import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import fr.eni.projet.bo.Categorie;
import fr.eni.projet.dal.CategorieDAO;
import fr.eni.projet.dal.DAOFactory;

public class CategorieManager {
	
	private static CategorieManager instance;
	private static ArrayList<Categorie> categories = new ArrayList<>();
	private static CategorieDAO categorieDAO;
	
	private CategorieManager() {
	
	}
	
	public static CategorieManager getInstance() {
		categorieDAO = DAOFactory.getCategorieDAO();
		categories = categorieDAO.selectAll();
		if (instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}
	
	public Categorie chercherCategorie(String libelle) {
		Categorie categorie = null;
		
		for (Categorie cat : categories) {
			if (cat.getLibelle().equals(libelle)) {
				categorie = cat;
				break;
			}
		}
		return categorie;
	}

}
