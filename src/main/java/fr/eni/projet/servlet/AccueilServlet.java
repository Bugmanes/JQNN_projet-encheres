package fr.eni.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bll.VenteManager;
import fr.eni.projet.bo.Article;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;

@WebServlet("/accueil.html")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// recuperation d'un objet de type EnchereManager
			VenteManager em = VenteManager.getInstance();

			// creation d'une liste d'articles
			List<Article> articles = null;

			// attribution a l'article le retour de la methode em.listerArticles();
			articles = em.listerArticles();

			for (Article article : articles) {
				System.out.println(article.getNomArticle());
				System.out.println(article.getPrixInitial());
				System.out.println(article.getDateFinEncheres());
				System.out.println(article.getVendeur());
			}

			request.setAttribute("selection", articles);

		} catch (DALException e) {
			System.err.println(e.getMessage());
		}

		getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String motsClés;
		String categorie;
		VenteManager vm = VenteManager.getInstance();
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		List<Article> selection = null;
		List<Article> temp = null;

		// recuperation du formulaire
		motsClés = request.getParameter("recherche").trim();
		categorie = request.getParameter("categorie").trim();
		String[] resultats = request.getParameterValues("triAchats");
		if (resultats == null) {
			resultats = request.getParameterValues("triVentes");
		}
		
		// tri par mots cles
		if (motsClés != null) {
			try {
				selection = vm.triByMotsCles(motsClés);
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		}
		
		//tri par categorie
		if (!categorie.equals("all")) {
			int cat = Integer.parseInt(categorie);
			try {
				if (selection.isEmpty()) {
					selection = vm.triByCategorie(cat);					
				} else {
					temp = vm.triByCategorie(cat);
					for (Article article : temp) {
						if (selection.indexOf(article) == -1) {
							selection.add(article);
						}
					}
				}
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		}
		
		
		
		request.setAttribute("selection", selection);
		request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp");

//		
//		try {
//			
//			// Ont parse
//			int categorie = Integer.parseInt(cat);
//			// On vient instancier cette liste avec les article de cette categorie
//			articles = vm.listerArticlesCat(categorie);
//			// je cree un liste d'Aticle
//			request.setAttribute("listeCat", articles);
//
//			System.out.println(categorie);
//
//			if (articles != null) {
//				for (Article article : articles) {
//					System.out.println(article.getNomArticle());
//					System.out.println(article.getPrixInitial());
//					System.out.println(article.getDateFinEncheres());
//					System.out.println(article.getVendeur().getPseudo());
//				}
//
//			}
//			System.out.println(categorie + "aucun article dans cette catégorie");
//
//		} catch (DALException e) {
//			throw new ServletException("problème dans la méthode doPost de la servlet Accueil", e);
//		}
//
//		ArrayList listeAB = new ArrayList();

		getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);

	}
}
