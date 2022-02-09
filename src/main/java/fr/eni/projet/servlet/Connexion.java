package fr.eni.projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Password;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;

@WebServlet("/connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		try {

			um = UtilisateurManager.getInstance();
			user = um.authentification(identifiant, motDePasse);
			if (user != null) {

				HttpSession session = request.getSession();
				session.setAttribute("utilisateur", user);
				request.setAttribute("utilisateur", user);

				// envoie a la page accueil.jsp
				request.getRequestDispatcher("accueil.html").forward(request, response);
			} else {

				request.setAttribute("connexion", false);
				// envoie a la page seConnecter.jsp
				request.getRequestDispatcher("/WEB-INF/jsp/seConnecter.jsp").forward(request, response);
			}

		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}
