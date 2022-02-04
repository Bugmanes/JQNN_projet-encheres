package fr.eni.projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;

@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/seConnecter.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utilisateur user = null;
		String identifiant = "";
		String motDePasse = "";
		UtilisateurManager um = null;

		identifiant = request.getParameter("identifiant");
		motDePasse = request.getParameter("password");
		um = UtilisateurManager.getInstance();
		user = new Utilisateur();
		user = um.authentification(identifiant, motDePasse);

		HttpSession session = request.getSession();
		session.setAttribute("utilisateur", user);
		if (user == null) {
			request.setAttribute("erreur", false);
			request.getRequestDispatcher("/WEB-INF/jsp/seConnecter.jsp").forward(request, response);
		} else {
			// monte en session user

			// je vais sur la page accueil connecte
			request.getRequestDispatcher("/WEB-INF/jsp/seConnecter.jsp").forward(request, response);

		}

	}

}
