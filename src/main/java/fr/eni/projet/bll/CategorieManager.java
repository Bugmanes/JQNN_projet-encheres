package fr.eni.projet.bll;

public class CategorieManager {
	
	private static CategorieManager instance;
	
	private CategorieManager() {
	
	}
	
	public static CategorieManager getInstance() {
		if (instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}

}
