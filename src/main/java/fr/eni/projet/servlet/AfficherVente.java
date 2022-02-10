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
		request.setAttribute("article", article);
		request.setAttribute("utilisateur", utilisateur);
		request.setAttribute("proprio", false);

		if (enchereNbOK) {
			enchere = Integer.parseInt(enchereTemp);
		} else {
			request.setAttribute("enchereNbOK", enchereNbOK);
			request.getRequestDispatcher("WEB-INF/jsp/detailVente.jsp").forward(request, response);
			return;
		}

		boolean valeurOK = vm.verifEnchere(article, enchere);

		if (valeurOK) {
			boolean budgetOK;
			if(enchere > utilisateur.getCredit()) {
				budgetOK = false;
				request.setAttribute("budgetOK", budgetOK);
				request.getRequestDispatcher("WEB-INF/jsp/detailVente.jsp").forward(request, response);
				return;
			}
			try {
				vm.encherir(utilisateur, article, enchere);
				response.sendRedirect(request.getContextPath() + "/afficherVente?idArticle=" + article.getNoArticle());
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		} else {
			request.setAttribute("enchereValeurOK", valeurOK);
			request.getRequestDispatcher("WEB-INF/jsp/detailVente.jsp").forward(request, response);
		}
	}

}
