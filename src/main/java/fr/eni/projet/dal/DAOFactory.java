package fr.eni.projet.dal;

public class DAOFactory {

	//methode de création d'un utilisateur
	public static UtilisateurDAO getUtilisateurDAO() {
		
	UtilisateurDAO utilisateurDAo = new UtilisateurDaoImpl(); 
		//me return une new instance d'Utilisateur qui implémente les methode de UtilisateurDAO
		return  utilisateurDAo;
	}
	
	
}
