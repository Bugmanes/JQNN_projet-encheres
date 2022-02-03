package fr.eni.projet.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

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
		// transmission de l'utilisateur à la page nouvelle vente
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// créer une vente
		
		// récupération des paramètres
		String nom = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		int miseAPrix = Integer.parseInt(request.getParameter("prixInitial"));
		LocalDate dateDebut = LocalDate.parse(request.getParameter("debut"));
		LocalDate dateFin = LocalDate.parse(request.getParameter("fin"));
		
		// récupération de la catégorie
		String libelle = request.getParameter("categorie");
		CategorieManager cm = CategorieManager.getInstance();
		Categorie categorie = cm.chercherCategorie(libelle);
		
		// récupération d'utilisateur de la session
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		// récupération de l'image de l'article
		
		
		// envoi à la bll
		EnchereManager em = EnchereManager.getInstance();
		em.nouvelleVente(nom, description, dateDebut, dateFin, miseAPrix, utilisateur, categorie);
		
		//TODO navigation
	}

}
