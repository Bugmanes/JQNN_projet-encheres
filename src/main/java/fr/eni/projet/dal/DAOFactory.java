package fr.eni.projet.dal;

public class DAOFactory {

	// methode de cr�ation d'un utilisateur
	public static UtilisateurDAO getUtilisateurDAO() {

		UtilisateurDAO utilisateurDAo = new UtilisateurDaoImpl();
		return utilisateurDAo;
	}

	// m�thode de cr�ation d'un cat�gorie DAO
	public static CategorieDAO getCategorieDAO() {
		
		CategorieDAO categorieDAO = new CategorieDaoImpl();
		return categorieDAO;
	}

	// m�thode de cr�ation d'un enchereDAO
	public static EnchereDAO getEnchereDAO() {
		
		EnchereDAO enchereDAO = new EnchereDaoImpl();
		return enchereDAO;
	}

	// m�thode de cr�ation d'un articleDAO
	public static ArticleDAO getArticleDAO() {
		
		ArticleDAO art = new ArticleDaoImpl();
		return art;
	}
	
	public static RetraitDAO getRetraitDAO() {
		RetraitDAO rdao = new RetraitDaoImpl();
		return rdao;
	}

}
