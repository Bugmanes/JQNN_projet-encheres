package fr.eni.projet.dal;

import fr.eni.projet.bo.Utilisateur;

public interface UtilisateurDAO {
//methode pour création d'utlisateur
	public void newUtilisateur(Utilisateur utilisateur);

	// methode de selection par pseudo
	public abstract Utilisateur selectByPseudo(String pseudo);

	// methode de selection par pseudo
	public abstract Utilisateur selectByPseudoConnexion(String identifiant, String motDePasse);

	public Utilisateur selectById(int id);

}
