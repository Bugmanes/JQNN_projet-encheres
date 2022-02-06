package fr.eni.projet.bll;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;
import java.util.regex.*;

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

	// methode d'authentification par identifiant et mot de passe
	public Utilisateur authentification(String identifiant, String motDePasse) throws DALException {

		Utilisateur user = null;
		UtilisateurDAO uDao = null;
		uDao = DAOFactory.getUtilisateurDAO();
		user = uDao.selectConnexion(identifiant, motDePasse);

		return user;
	}

	// methode pour creer un nouvel utilisateur
	public void nouvelUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur)
			throws DALException {

		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse,
				credit, administrateur);
		UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();
		userDAO.newUtilisateur(user);
	}

	// methode pour chercher un utilisateur
	public int cherche(String pseudo, String nom, String prenom, String email, String telephone, String rue,
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

	// methode pour modifier un utilisateur
	public Utilisateur modifierUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, Utilisateur utilisateur)
			throws DALException {
		String oldPseudo = "";
		if (utilisateur.getPseudo().equals(pseudo)) {
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);
		} else {
			oldPseudo = utilisateur.getPseudo();
			utilisateur.setPseudo(pseudo);
		}
		UtilisateurDAO udao = DAOFactory.getUtilisateurDAO();
		udao.updateUtilisateur(utilisateur, oldPseudo);
		return utilisateur;
	}

	// methode pour verifier les caracteres alphanumerique du pseudo nom et prenom
	public boolean verifPseudoNomPrenom(String str) {

		Pattern p;
		Matcher m;
		boolean ok;

		p = Pattern.compile("[^a-zA-Z_0-9]");
		m = p.matcher(str);
		ok = m.matches();
		ok = !ok;

		return ok;
	}

	// methode pour verifier que le numero de telephone ne contient pas de lettre
	public boolean verifTel(String str) {

		Pattern p;
		Matcher m;
		boolean ok;

		p = Pattern.compile("[a-zA-Z]");
		m = p.matcher(str);
		ok = m.matches();
		ok = !ok;

		return ok;
	}

	// methode pour verifier que le code postal ne contient que des chiffres
	public boolean verifCP(String str) {

		Pattern p;
		Matcher m;
		boolean ok;

		p = Pattern.compile("[^0-9]");
		m = p.matcher(str);
		ok = m.matches();
		ok = !ok;

		return ok;
	}

	// methode pour verifier que le pseudo est unique
	public boolean verifUniquePseudo(String pseudo) throws DALException {

		UtilisateurDAO udao = DAOFactory.getUtilisateurDAO();
		boolean ok;

		ok = udao.selectUniquePseudo(pseudo);

		return ok;
	}

	// methode pour verifier que le mail est unique
	public boolean verifUniqueMail(String mail) throws DALException {

		UtilisateurDAO udao = DAOFactory.getUtilisateurDAO();
		boolean ok;

		ok = udao.selectUniquePseudo(mail);

		return ok;
	}

}
