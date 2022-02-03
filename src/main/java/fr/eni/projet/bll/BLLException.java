package fr.eni.projet.bll;

public class BLLException extends Exception {

	// Constructeurs
	public BLLException() {
		super();
	}

	public BLLException(String message) {
		super(message);
	}

	public BLLException(String message, Throwable exception) {
		super(message, exception);
	}

	// Methodes
	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder("Couche BLL - ");
		sb.append(super.getMessage());
		return sb.toString();
	}
}
