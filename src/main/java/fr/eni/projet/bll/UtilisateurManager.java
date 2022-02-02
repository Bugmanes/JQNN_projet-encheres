package fr.eni.projet.bll;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurManager instance;

	private UtilisateurManager() {

	}
	
	public static UtilisateurManager getInstance()   {
		if (instance == null) {
			instance = new UtilisateurManager();
			UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();			
		
		}
		
		return instance;
	}
	
	public Utilisateur authentification(Utilisateur utilisateur) {
		Utilisateur user = null;
		
		return user;
		
	}

	//			( {
//
//				Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
//						motDePasse, credit, administrateur);
//
//				UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
//				dao.newUtilisateur(utilisateur);
//			}
//		
		
		
		

}
