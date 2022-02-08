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

@WebServlet("/InscriptionConnexion") 
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//envoie a la page inscription.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// gerer une nouvelle inscription
		
		// recuperation des saisies utilisateurs
		String pseudo = request.getParameter("pseudo").trim();
		String nom = request.getParameter("nom").trim();
		String prenom = request.getParameter("prenom").trim();
		String email = request.getParameter("email").trim();
		String telephone = request.getParameter("telephone").trim();
		String rue = request.getParameter("rue").trim();
		String codePostal = request.getParameter("codePostal").trim();
		String ville = request.getParameter("ville").trim();
		String motDePasse = request.getParameter("motDePasse").trim();
		String mdp = null;
		
		try {
			 mdp = Password.getSaltedHash(motDePasse);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		int credit = 1000;
		Boolean administrateur = false;
		UtilisateurManager um = UtilisateurManager.getInstance();
		
		// verification de la conformite des saisies utilisateurs
		boolean pseudoOK = um.verifPseudo(pseudo);
		boolean nomOK = um.verifNomPrenom(nom);
		boolean prenomOK = um.verifNomPrenom(prenom);
		boolean telOK = um.verifTel(telephone);
		boolean pseudoUniqueOK = false;
		boolean emailUniqueOK = false;
		try {
			pseudoUniqueOK = um.verifUniquePseudo(pseudo);
			emailUniqueOK = um.verifUniqueMail(email);
		} catch (DALException e) {
			System.err.println(e.getMessage());
		}
		
		// si une ou des requtes sont erronnes, demander une donnee valide
		if(!pseudoOK || !nomOK || !prenomOK || !telOK || !pseudoUniqueOK || !emailUniqueOK) {
			request.setAttribute("pseudoOK", pseudoOK);
			request.setAttribute("pseudoUniqueOK", pseudoUniqueOK);
			request.setAttribute("nomOK", nomOK);
			request.setAttribute("prenomOK", prenomOK);
			request.setAttribute("telOK", telOK);
			request.setAttribute("emailUniqueOK", emailUniqueOK);
			request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
			return;
		}
		
		try {
			// insertion des parametre dans un nouvel utilisateur
			um.nouvelUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp, credit,
					administrateur);
		} catch (DALException e) {
			System.err.println("rtyuiop");
		}

		request.getRequestDispatcher("/Connexion").forward(request, response);
		
	}

}
