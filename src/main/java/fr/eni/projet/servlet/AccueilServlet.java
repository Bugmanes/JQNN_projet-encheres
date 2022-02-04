package fr.eni.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bll.EnchereManager;
import fr.eni.projet.bo.Article;

@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if (!request.getParameter("recherche").equalsIgnoreCase("1")) {
//			request.getRequestDispatcher("/WEB-INF/jsp/acceuil.jsp").forward(request, response);
//		
//		}else 
//		// afficher la liste d'enchères
//		
		EnchereManager em = EnchereManager.getInstance();
		
		List<Article> articles = em.listerArticles();

		request.setAttribute("liste", articles);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
	}

}
