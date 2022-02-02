package fr.eni.projet.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bll.EnchereManager;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Utilisateur;

/**
 * Servlet implementation class GestionVente
 */
@WebServlet("/GestionVente")
public class GestionVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// afficher une vente en particulier
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// créer une vente
		String nom = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		int miseAPrix = Integer.parseInt(request.getParameter("prixInitial"));
		LocalDate dateDebut = LocalDate.parse(request.getParameter("debut"));
		LocalDate dateFin = LocalDate.parse(request.getParameter("fin"));
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		String libelle = request.getParameter("categorie");
		CategorieManager cm = CategorieManager.getInstance();
		Categorie categorie = cm.chercherCategorie(libelle);
		EnchereManager em = EnchereManager.getInstance();
		em.nouvelleVente(nom, description, dateDebut, dateFin, miseAPrix, utilisateur, categorie);
	}

}
