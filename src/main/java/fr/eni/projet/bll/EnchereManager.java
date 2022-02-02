package fr.eni.projet.bll;

public class EnchereManager {
	
	private static EnchereManager instance;
	
	private EnchereManager() {

	}
	
	public static EnchereManager getInstance() {
		if (instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}

}
