package fr.eni.projet.servlet;

public class ServletException extends Exception {

	// Constructeurs
	public ServletException() {
		super();
	}

	public ServletException(String message) {
		super(message);
	}

	public ServletException(String message, Throwable exception) {
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
