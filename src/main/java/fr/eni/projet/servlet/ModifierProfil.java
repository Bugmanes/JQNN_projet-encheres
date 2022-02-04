package fr.eni.projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bo.Utilisateur;

@WebServlet("/ModifierProfil")
public class ModifierProfil extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur =(Utilisateur) session.getAttribute("utilisateur");
		request.setAttribute(getServletInfo(), utilisateur);
		// envoi à la page monProfil.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/monProfil.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}

