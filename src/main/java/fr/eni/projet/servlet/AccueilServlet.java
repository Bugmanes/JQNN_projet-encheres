package fr.eni.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bll.VenteManager;
import fr.eni.projet.bo.Article;
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
			request.setAttribute("liste", articles);
			
        		for(Article article : articles) {
				System.out.println(article.getNomArticle());
			System.out.println(article.getPrixInitial());
				System.out.println(article.getDateFinEncheres());
				System.out.println(article.getVendeur());
				
			}
			
		} catch (DALException e) {
			throw new ServletException("probl�me dans la m�thode doGet de la servlet Accueil", e);
		}

		getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			//cr�eation d'un objet de type Categoriemanager
			CategorieManager cm = CategorieManager.getInstance();
			//je cr�e un liste d'Aticle 
			List<Article> articles = null;
			request.setAttribute("listeCat", articles);
			String cat = request.getParameter("categorie");
			int categorie = Integer.parseInt(cat);
			System.out.println(categorie);
		} catch (DALException e) {
			throw new ServletException("probl�me dans la m�thode doPost de la servlet Accueil", e);
		}
		
		

		
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);

	}
}
