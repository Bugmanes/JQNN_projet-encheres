package fr.eni.projet.servlet;

import java.io.IOException;
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

@WebServlet("/encherir")
public class AfficherVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		int idArt;
		Article article = null;
		VenteManager vm;
		HttpSession session = request.getSession();
		
		// recuperer l'id de l'article
		idArt = Integer.parseInt(request.getParameter("idArticle"));
		
		//recuperer l'article à partir de son id
		vm = VenteManager.getInstance();
		try {
			article = vm.obtenirArticle(idArt);
		} catch (DALException e) {
			System.err.println(e.getMessage());
		}
		
		// passage de l'article en attribut de requete
		request.setAttribute("article", article);
		
		// passage de l'article en attribut de session si l'utilisateur encheri
		session.setAttribute("article", article);
		
		// envoi des attributs dans à la jsp
		request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// faire une enchere sur une vente
		
		// recuperation de l'utilisateur, de l'article et du montant de l'enchere
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		Article article = (Article) session.getAttribute("article");
		int enchere = Integer.parseInt(request.getParameter("enchere"));
		
		// verification que l'enchere est bien superieure a la precedente
		VenteManager vm = VenteManager.getInstance();
		boolean ok = vm.verifEnchere(article, enchere);
		
		//selon la verification, enregistrement de l'enchere ou retour avec message d'erreur
		if (ok) {
			try {
				vm.encherir(utilisateur, article, enchere);
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		} else {
			request.setAttribute("enchereOK", ok);
			request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp").forward(request, response);
		}
	}

}
