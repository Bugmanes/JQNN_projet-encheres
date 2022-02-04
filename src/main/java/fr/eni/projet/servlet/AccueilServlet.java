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
import fr.eni.projet.dal.DALException;

@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// je crée un objet de type EncherManager
			EnchereManager em = EnchereManager.getInstance();
			// je crée un eliste d'article
			List<Article> articles = null;
			// j'attribu a mon article le retour de la methode em.listerArticles();
			request.setAttribute("liste", articles);
			articles = em.listerArticles();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);

	}

}
