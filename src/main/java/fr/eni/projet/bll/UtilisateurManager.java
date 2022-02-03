package fr.eni.projet.bll;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurManager instance;

	private UtilisateurManager() {

	}

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
			UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
		}
		return instance;
	}

	public Utilisateur authentification(String identifiant, String motDePasse) {
		
		

	}

	public void nouvelUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse,
				credit, administrateur);
		UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();
		userDAO.newUtilisateur(user);

	}

}
