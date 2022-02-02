package fr.eni.projet.bll;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurManager instance;

	private UtilisateurManager() {

	}
	
	private UtilisateurManager(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {

	}

	public static UtilisateurManager getInstance(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur)   {
		if (instance == null) {
			instance = new UtilisateurManager(pseudo,nom, prenom,email,telephone,rue,codePostal,ville,motDePasse,credit,administrateur);
			UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
			dao.getUtilisateurDAO(UtilisateurManager);
		
		}
		
		return instance;
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
