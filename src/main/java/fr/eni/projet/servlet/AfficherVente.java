package fr.eni.projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bll.VenteManager;
import fr.eni.projet.bo.Article;

@WebServlet("/Encherir")
public class AfficherVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idArt;
		Article article = null;
		VenteManager vm;
		
		// recuperer l'id de l'article
		idArt = Integer.parseInt(request.getParameter("idArticle"));
		
		//recuperer l'article à partir de son id
		vm = VenteManager.getInstance();
		vm.obtenirArticle(idArt);		
		
		// passage de l'article en attribut de requete
		request.setAttribute("article", article);
		
		// envoi des attributs dans à la jsp
		request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// faire une enchère sur une vente
		int enchere = Integer.parseInt(request.getParameter("enchere"));
	}

}
