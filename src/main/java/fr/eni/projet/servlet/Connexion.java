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
		try {
			user = um.authentification(identifiant, motDePasse);
		} catch (DALException e) {
			System.err.println(e.getMessage());
		}

		if (user == null) {
			request.setAttribute("connexion", false);
			//envoie a la page seConnecter.jsp
			request.getRequestDispatcher("/WEB-INF/jsp/seConnecter.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", user);

			// envoie a la page accueil.jsp
			request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);

		}

	}

}
