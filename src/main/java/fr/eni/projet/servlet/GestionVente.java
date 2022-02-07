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
import fr.eni.projet.bll.VenteManager;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;

@WebServlet("/GestionVente")
public class GestionVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// transmission de l'utilisateur a la page nouvelle vente
		
		// recuperation de l'utilisateur de la session en cours
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		// parametrage des attributs à transmettre à la jsp
		request.setAttribute("rue", utilisateur.getRue());
		request.setAttribute("codePostal", utilisateur.getCodePostal());
		request.setAttribute("ville", utilisateur.getVille());
		
		// envoi a la jsp
		request.getRequestDispatcher("/WEB-INF/nouvelleVente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// creer une vente
		
		// recuperation des parametres
		String nom = request.getParameter("nomArticle").trim();
		String description = request.getParameter("description").trim();
		int miseAPrix = Integer.parseInt(request.getParameter("prixInitial"));
		LocalDate dateDebut = LocalDate.parse(request.getParameter("debut"));
		LocalDate dateFin = LocalDate.parse(request.getParameter("fin"));
		
		// recuperation de la categorie
		String libelle = request.getParameter("categorie").trim();
		CategorieManager cm = null;
		try {
			cm = CategorieManager.getInstance();
		} catch (DALException e) {
			System.err.println(e.getMessage());
		}
		Categorie categorie = cm.chercherCategorie(libelle);
		
		// recuperation d'utilisateur de la session
		HttpSession session = request.getSession();
		//recuperation d'utilisateur de la session
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		// recuperation de l'image de l'article
		
		
		// envoi à la bll
		VenteManager em = VenteManager.getInstance();
		//insertion des parametrage d'un nouvel utilisateur
		try {
			em.nouvelleVente(nom, description, dateDebut, dateFin, miseAPrix, utilisateur, categorie);
		} catch (DALException e) {
			System.err.println(e.getMessage());
		}
		
		// renvoi vers l'accueil
		request.getRequestDispatcher("/accueil").forward(request, response);
	}
}