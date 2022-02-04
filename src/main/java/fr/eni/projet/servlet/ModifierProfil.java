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

@WebServlet("/ModifierProfil")
public class ModifierProfil extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//création de la session
		HttpSession session = request.getSession();
		//récuperation d'un utilisateur
		Utilisateur utilisateur =(Utilisateur) session.getAttribute("utilisateur");
		//paramétrage d'un utilisateur
		request.setAttribute("Utilisateur", utilisateur);
		// envoi a la page monProfil.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/monProfil.jsp").forward(request, response);
		
	}
//envoie de la requte
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//parametrage de la requete
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		//String old_mdp = request.getParameter("old_mdp");
		//String new_mdp = request.getParameter("new_mdp");
		
		//création de la session
		HttpSession session = request.getSession();
		//récuperation d'un utilisateur
		Utilisateur utilisateur =(Utilisateur) session.getAttribute("utilisateur");
		//paramétrage d'un utilisateur
		request.setAttribute("Utilisateur", utilisateur);
		UtilisateurManager um = UtilisateurManager.getInstance();
		//insertion de paramétre dans modifierUtilisateur
		try {
			um.modifierUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, ville, utilisateur);
		} catch (DALException e) {
			System.err.println(e.getMessage());
		}
	}		
}

