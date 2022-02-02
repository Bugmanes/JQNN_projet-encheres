package fr.eni.projet.dal;

public class DAOFactory {

	//methode de création d'un utilisateur
	public static UtilisateurDAO getUtilisateurDAO() {
		
	UtilisateurDAO utilisateurDAo = new UtilisateurDaoImpl(); 
		//me return une new instance d'Utilisateur qui implémente les methode de UtilisateurDAO
		return  utilisateurDAo;
	}
	
	// méthode de création d'un catégorie DAO
	public static CategorieDAO getCategorieDAO() {
		CategorieDAO categorieDAO = new CategorieDaoImpl();
		return categorieDAO;
	}
	
	
}
