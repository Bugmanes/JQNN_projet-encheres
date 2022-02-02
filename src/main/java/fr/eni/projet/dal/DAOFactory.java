package fr.eni.projet.dal;

public class DAOFactory {

	//methode de cr�ation d'un utilisateur
	public static UtilisateurDAO getUtilisateurDAO() {
		
	UtilisateurDAO utilisateurDAo = new UtilisateurDaoImpl(); 
		//me return une new instance d'Utilisateur qui impl�mente les methode de UtilisateurDAO
		return  utilisateurDAo;
	}
	
	// m�thode de cr�ation d'un cat�gorie DAO
	public static CategorieDAO getCategorieDAO() {
		CategorieDAO categorieDAO = new CategorieDaoImpl();
		return categorieDAO;
	}
	
	
}
