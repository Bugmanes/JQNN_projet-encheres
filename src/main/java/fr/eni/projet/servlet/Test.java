package fr.eni.projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bo.Password;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	getServletContext().getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String motDePasse = request.getParameter("pseudo").trim();
		Password mdp = new Password();
		try {
			motDePasse = mdp.getSaltedHash(motDePasse);
		} catch (Exception e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(request.getParameter("pseudo"));
		System.out.println(motDePasse);

	getServletContext().getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
	
	}
}
