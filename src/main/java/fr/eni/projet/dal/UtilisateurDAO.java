package fr.eni.projet.dal;

import fr.eni.projet.bo.Utilisateur;

public interface UtilisateurDAO {
//methode pour création d'utlisateur
	public void newUtilisateur(Utilisateur utilisateur) throws DALException;

	// methode de selection par pseudo
	public abstract Utilisateur selectByPseudo(String pseudo) throws DALException;

	public Utilisateur selectById(int id) throws DALException;

	public void updateUtilisateur(Utilisateur utilisateur);
	
	public Utilisateur selectConnexion(String identifiant, String password);
}
