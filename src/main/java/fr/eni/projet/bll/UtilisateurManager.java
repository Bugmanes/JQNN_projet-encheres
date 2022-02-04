package fr.eni.projet.bll;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurManager instance;

	private UtilisateurManager() {

	}

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	public Utilisateur authentification(String identifiant, String motDePasse) {
		
		Utilisateur user = null;
		UtilisateurDAO uDao = null;
		uDao= DAOFactory.getUtilisateurDAO();
		
		return user;

	}

	public void nouvelUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws DALException {
		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse,
				credit, administrateur);
		UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();
		userDAO.newUtilisateur(user);

	}
	
	public int cherche (String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse,
				credit, administrateur);
		UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();
		try {
			userDAO.selectById(user.getNoUtilisateur());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return user.getNoUtilisateur();

	}
	public Utilisateur modifierUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse,Utilisateur utilisateur) {
		utilisateur.setPseudo(pseudo);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setTelephone(telephone);
		utilisateur.setRue(rue);
		utilisateur.setCodePostal(codePostal);
		utilisateur.setVille(ville);
		
		UtilisateurDAO udao =DAOFactory.getUtilisateurDAO();
		udao.updateUtilisateur(utilisateur);
		return utilisateur;
	}
	
}
