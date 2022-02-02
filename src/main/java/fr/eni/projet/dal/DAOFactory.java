package fr.eni.projet.dal;

public class DAOFactory {

	//methode de création d'un utilisateur
	public static UtilisateurDAO createUtilisateurDAO() {
		
		//me return une new instance d'Utilisateur qui implémente les methode de UtilisateurDAO
		return new UtilisateurDaoImpl();
	}
	
	
}
