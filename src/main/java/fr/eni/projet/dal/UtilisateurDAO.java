package fr.eni.projet.dal;

import fr.eni.projet.bo.Utilisateur;

public interface UtilisateurDAO {

	//methode pour cr�er un nouvelle utlisateur
	public void newUtilisateur(Utilisateur utilisateur);

	// m�thode pour s�lectionner un utilisateur par son pseudo
	public abstract Utilisateur selectByPseudo(Utilisateur utilisateur);

}
