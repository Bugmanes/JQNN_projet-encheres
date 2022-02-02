package fr.eni.projet.dal;

import fr.eni.projet.bo.Utilisateur;

public interface UtilisateurDAO {
//methode pour crée un nuovelle utlisateur
public void newUtilisateur(Utilisateur utilisateur);


public abstract Utilisateur selectByPseudo(String pseudo) ; 



	
}
