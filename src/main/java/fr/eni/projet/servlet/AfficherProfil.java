package fr.eni.projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bll.VenteManager;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;

@WebServlet("/AfficherProfil")
public class AfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		boolean proprio;
		
		if(id != user.getNoUtilisateur()) {
			proprio = false;
			UtilisateurManager um = UtilisateurManager.getInstance();
			try {
				user = um.chercherUtilisateur(id);
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		} else {
			proprio = true;
		}
		
		request.setAttribute("ok", proprio);
		request.setAttribute("utilisateur", user);
		request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

}
