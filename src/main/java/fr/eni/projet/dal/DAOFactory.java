package fr.eni.projet.dal;

public class DAOFactory {

	//methode de cr�ation d'un utilisateur
	public static UtilisateurDAO createUtilisateurDAO() {
		
		//me return une new instance d'Utilisateur qui impl�mente les methode de UtilisateurDAO
		return new UtilisateurDaoImpl();
	}
	
	
}
