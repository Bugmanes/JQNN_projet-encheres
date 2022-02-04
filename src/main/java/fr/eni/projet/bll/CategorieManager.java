package fr.eni.projet.bll;

import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import fr.eni.projet.bo.Categorie;
import fr.eni.projet.dal.CategorieDAO;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;

public class CategorieManager {

	private static CategorieManager instance;
	private static ArrayList<Categorie> categories = new ArrayList<>();
	private static CategorieDAO cDAO;

	private CategorieManager() {

	}

	public static CategorieManager getInstance() throws DALException {
		cDAO = DAOFactory.getCategorieDAO();
		categories = cDAO.selectAll();
		//parametrage de l'instance
		if (instance == null) {
			instance = new CategorieManager();
		}
		//renvoie de l'instance
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
