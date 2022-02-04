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

@WebServlet("/InscriptionConnexion")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// gérer une nouvelle inscription
		// attribut que l'on vient hydrater grace au valeur reçu par la jsp

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		int credit = 1000;
		Boolean administrateur = false;
		UtilisateurManager um = UtilisateurManager.getInstance();
		try {
			um.nouvelUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit,
					administrateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO navigation
		
	}

}
