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

@WebServlet("/modifierProfil")
public class ModifierProfil extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// creation de la session
		HttpSession session = request.getSession();

		// recuperation d'un utilisateur
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

		// parametrage d'un utilisateur
		request.setAttribute("Utilisateur", utilisateur);

		// envoi a la page monProfil.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/monProfil.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recuperation la session
		System.out.println("ok1");
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		String choix = "";
		UtilisateurManager um = UtilisateurManager.getInstance();

		if (request.getParameter("choix") != null) {
			choix = request.getParameter("choix").trim();
		}

		if (!choix.isEmpty()) {

			if (choix.equals("supprimer")) {
				request.setAttribute("suppression", "Votre compte vient d'etre supprimer");
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
				return;
			}
		} else {
			System.out.println("ok2");
			// parametrage de la requete
			String pseudo = request.getParameter("pseudo").trim();
			String nom = request.getParameter("nom").trim();
			String prenom = request.getParameter("prenom").trim();
			String email = request.getParameter("email").trim();
			String telephone = request.getParameter("tel").trim();
			String rue = request.getParameter("rue").trim();
			String codePostal = request.getParameter("codePostal").trim();
			String ville = request.getParameter("ville").trim();
			System.out.println("ok3");
//			String old_mdp = request.getParameter("old_mdp").trim();
//			String new_mdp = request.getParameter("new_mdp").trim();

			boolean pseudoOK = true;
			boolean nomOK = true;
			boolean prenomOK = true;
			boolean telOK = true;
			boolean pseudoUniqueOK = true;
			boolean emailUniqueOK = true;

			// verification si le pseudo est correspond
			if (!utilisateur.getPseudo().equals(pseudo)) {
				pseudoOK = um.verifPseudo(pseudo);
				try {
					pseudoUniqueOK = um.verifUniquePseudo(pseudo);
				} catch (DALException e) {
					System.err.println(e.getMessage());
				}
			}
			// verification si le nom est correspond
			if (!utilisateur.getNom().equals(nom)) {
				nomOK = um.verifNomPrenom(nom);
			}
			// verification si le prenom est correspond
			if (!utilisateur.getPrenom().equals(prenom)) {
				prenomOK = um.verifNomPrenom(prenom);
			}
			// verification si le numéro de téléphone est correspond
			if (!utilisateur.getTelephone().equals(telephone)) {
				telOK = um.verifTel(telephone);
			}
			// verification si le l'email est correspond
			if (!utilisateur.getEmail().equals(email)) {
				System.out.println("ok4");
				try {
					emailUniqueOK = um.verifUniqueMail(email);
				} catch (DALException e) {
					System.err.println(e.getMessage());
				}
			}

			// verification si un ou des parametres sont faux
			if (!pseudoOK || !nomOK || !prenomOK || !telOK || !pseudoUniqueOK || !emailUniqueOK) {
				System.out.println("pasOk");
				request.setAttribute("pseudoOK", pseudoOK);
				request.setAttribute("pseudoUniqueOK", pseudoUniqueOK);
				request.setAttribute("nomOK", nomOK);
				request.setAttribute("prenomOK", prenomOK);
				request.setAttribute("telOK", telOK);
				request.setAttribute("emailUniqueOK", emailUniqueOK);
				request.getRequestDispatcher("/WEB-INF/jsp/monProfil.jsp").forward(request, response);
				return;
			}

			try {
				System.out.println("ok5");
				// insertion de parametres dans modifierUtilisateur
				um.modifierUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, ville,
						utilisateur);
			} catch (DALException e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
			System.out.println("ok6");
			response.sendRedirect(request.getContextPath() + "/afficherProfil");
		}
	}

}
