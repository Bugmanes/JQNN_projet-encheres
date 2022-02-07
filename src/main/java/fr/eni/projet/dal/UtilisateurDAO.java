package fr.eni.projet.dal;

import fr.eni.projet.bo.Utilisateur;

public interface UtilisateurDAO {
	//methode pour cr�ation d'utlisateur
	public void newUtilisateur(Utilisateur utilisateur) throws DALException;

	// methode de selection par pseudo
	public abstract Utilisateur selectByPseudo(String pseudo) throws DALException;

	//methode de selection par pseudo
	public Utilisateur selectById(int id) throws DALException;

	//methode de modification du profil
	public void updateUtilisateur(Utilisateur utilisateur,String oldPseudo) throws DALException;
	
	//methode de connection
	public Utilisateur selectConnexion(String identifiant, String password) throws DALException;
	
	// methode de verification de pseudo unique
	public boolean selectUniquePseudo(String pseudo) throws DALException;
	
	// methode de verification d'email unique
	public boolean selectUniqueMail(String mail) throws DALException;
	
	// methode de anonymiser  d'utilisateur
	public void deleteUtilisateur(Utilisateur utilisateur) throws DALException;
}
