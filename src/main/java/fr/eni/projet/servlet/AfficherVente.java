package fr.eni.projet.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.VenteManager;
import fr.eni.projet.bo.Article;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;

@WebServlet("/afficherVente")
public class AfficherVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idArt;
		Article article = null;
		VenteManager vm;
		HttpSession session = request.getSession();
		boolean proprio;

		// recuperer l'id de l'article
		idArt = Integer.parseInt(request.getParameter("idArticle"));

		// recuperer l'article à partir de son id
		vm = VenteManager.getInstance();
		try {
			article = vm.obtenirArticle(idArt);
		} catch (DALException e) {
			System.err.println(e.getMessage());
		}

		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		if (user.getNoUtilisateur() == article.getVendeur().getNoUtilisateur()) {
			proprio = true;
		} else {
			proprio = false;
		}

		if (request.getParameter("enchereValeurOK") != null) {
			request.setAttribute("enchereValeurOK", request.getParameter("enchereValeurOK"));
		}
		if(request.getParameter("enchereNbOK") != null) {
			request.setAttribute("enchereNbOK", request.getParameter("enchereNbOK"));
		}
		request.setAttribute("article", article);
		request.setAttribute("utilisateur", session.getAttribute("utilisateur"));
		request.setAttribute("proprio", proprio);

		// passage de l'article en attribut de session si l'utilisateur encheri
		session.setAttribute("article", article);

		// envoi des attributs dans à la jsp appropriee
		if (article.getDateFinEncheres().isAfter(LocalDate.now())) {
			request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/venteTerminee.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// faire une enchere sur une vente

		// recuperation de l'utilisateur, de l'article et du montant de l'enchere
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		Article article = (Article) session.getAttribute("article");
		VenteManager vm = VenteManager.getInstance();
		String enchereTemp = request.getParameter("enchere");
		boolean enchereNbOK = vm.verifEnchereNombre(enchereTemp);
		int enchere = 0;

		if (enchereNbOK) {
			enchere = Integer.parseInt(enchereTemp);
		}

		// verification que l'enchere est bien superieure a la precedente
		boolean valeurOK = vm.verifEnchere(article, enchere);

		// selon la verification, enregistrement de l'enchere ou retour avec message
		// d'erreur
		if (valeurOK) {
			try {
				vm.encherir(utilisateur, article, enchere);
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
			response.sendRedirect(request.getContextPath() + "/afficherVente?idArticle=" + article.getNoArticle());
		} else {
			response.sendRedirect(request.getContextPath() + "/afficherVente?enchereValeurOK=" + valeurOK + "&enchereNbOK=" + enchereNbOK + "&idArticle=" + article.getNoArticle());
		}
	}

}
