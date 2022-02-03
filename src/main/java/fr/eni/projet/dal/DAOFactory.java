package fr.eni.projet.dal;

public class DAOFactory {

	// methode de création d'un utilisateur
	public static UtilisateurDAO getUtilisateurDAO() {

		UtilisateurDAO utilisateurDAo = new UtilisateurDaoImpl();
		return utilisateurDAo;
	}

	// méthode de création d'un catégorie DAO
	public static CategorieDAO getCategorieDAO() {
		
		CategorieDAO categorieDAO = new CategorieDaoImpl();
		return categorieDAO;
	}

	// méthode de création d'un enchereDAO
	public static EnchereDAO getEnchereDAO() {
		
		EnchereDAO enchereDAO = new EnchereDaoImpl();
		return enchereDAO;
	}

	// méthode de création d'un articleDAO
	public static ArticleDAO getArticleDAO() {
		
		ArticleDAO art = new ArticleDaoImpl();
		return art;
	}

}
