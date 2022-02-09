package fr.eni.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bll.VenteManager;
import fr.eni.projet.bo.Article;
import fr.eni.projet.bo.Utilisateur;
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

			for (Article article : articles) {
				System.out.println(article.getNomArticle());
				System.out.println(article.getPrixInitial());
				System.out.println(article.getDateFinEncheres());
				System.out.println(article.getVendeur());
			}

			HttpSession session = request.getSession();
			request.setAttribute("utilisateur", session.getAttribute("utilisateur"));
			request.setAttribute("selection", articles);

		} catch (DALException e) {
			System.err.println(e.getMessage());
		}

		getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String motsClés = "";
		String categorie;
		VenteManager vm = VenteManager.getInstance();
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		List<Article> selection = null;
		List<Article> temp = null;

		// recuperation du formulaire
		motsClés = request.getParameter("recherche").trim();
		categorie = request.getParameter("categorie").trim();
		String[] resultats = request.getParameterValues("triAchats");
		if (resultats == null) {
			resultats = request.getParameterValues("triVentes");
		}
		List<String> result = Arrays.asList(resultats);

		// selection des encheres ouvertes d'achats
		if (result.indexOf("encheresOuvertes") != -1) {
			try {
				if (selection.isEmpty()) {
					selection = vm.triByEncheresOuvertes(user);
				} else {
					temp = vm.triByEncheresOuvertes(user);
					for (Article article : temp) {
						if (selection.indexOf(article) == -1) {
							selection.add(article);
						}
					}
				}
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		}

		// selection de mes encheres en cours
		if (result.indexOf("encheresEnCours") != -1) {
			try {
				if (selection.isEmpty()) {
					selection = vm.triByEncheresEnCours(user);
				} else {
					temp = vm.triByEncheresEnCours(user);
					for (Article article : temp) {
						if (selection.indexOf(article) == -1) {
							selection.add(article);
						}
					}
				}
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		}

		// tri par mes encheres remportees
		if (result.indexOf("encheresRemportees") != -1) {
			try {
				if (selection.isEmpty()) {
					selection = vm.triByEncheresRemportees(user);
				} else {
					temp = vm.triByEncheresRemportees(user);
					for (Article article : temp) {
						if (selection.indexOf(article) == -1) {
							selection.add(article);
						}
					}
				}
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		}

		// tri par mes ventes en cours
		if (result.indexOf("venteEnCours") != -1) {
			try {
				if (selection.isEmpty()) {
					selection = vm.triByVenteEnCours(user);
				} else {
					temp = vm.triByVenteEnCours(user);
					for (Article article : temp) {
						if (selection.indexOf(article) == -1) {
							selection.add(article);
						}
					}
				}
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		}

		// tri par mes ventes non debutees
		if (result.indexOf("ventesNonDebutees") != -1) {
			try {
				if (selection.isEmpty()) {
					selection = vm.triByVentesNonDebutees(user);
				} else {
					temp = vm.triByVentesNonDebutees(user);
					for (Article article : temp) {
						if (selection.indexOf(article) == -1) {
							selection.add(article);
						}
					}
				}
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		}

		// tri par mes ventes terminées
		if (result.indexOf("ventesNonDebutees") != -1) {
			try {
				if (selection.isEmpty()) {
					selection = vm.triByVentesTerminees(user);
				} else {
					temp = vm.triByVentesTerminees(user);
					for (Article article : temp) {
						if (selection.indexOf(article) == -1) {
							selection.add(article);
						}
					}
				}
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		}
		// tri par mots cles
		if (motsClés != null) {
			try {
				if (selection.isEmpty()) {
					selection = vm.triByMotsCles(motsClés);
				} else {
					temp = vm.triByMotsCles(motsClés);
					for (Article article : selection) {
						if (temp.indexOf(article) == -1) {
							selection.remove(article);
						}
					}
				}
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		}

		// tri par categorie
		if (!categorie.equals("all")) {
			int cat = Integer.parseInt(categorie);
			try {
				if (selection.isEmpty()) {
					selection = vm.triByCategorie(cat);
				} else {
					temp = vm.triByCategorie(cat);
					for (Article article : selection) {
						if (temp.indexOf(article) == -1) {
							selection.remove(article);
						}
					}
				}
			} catch (DALException e) {
				System.err.println(e.getMessage());
			}
		}

		request.setAttribute("selection", selection);
		request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp").forward(request, response);
	}
}
