package fr.eni.projet.bll;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurDAO dao= null;
	private static UtilisateurManager instance;

	private UtilisateurManager() {

	}

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
			dao = DAOFactory.getUtilisateurDAO();
		}
		return instance;
	}

	public Utilisateur authentification(String identifiant, String motDePasse) {
		Utilisateur user = new Utilisateur (identifiant, motDePasse);
		//contacte la dal
		user = dao.getClass()
		return user;

	}

	public void nouvelUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws DALException {
		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse,
				credit, administrateur);
		UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();
		userDAO.newUtilisateur(user);

	}
	
	public Utilisateur cherche (String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws DALException {
		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse,
				credit, administrateur);
		UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();
		userDAO.newUtilisateur(user);
		
		return user;
	}
	
}
