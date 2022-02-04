<%@page import="java.util.List"%>
<%@page import="fr.eni.projet.bo.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des enchères</title>
<link rel="stylesheet" href="asset/css/style.css">
</head>
<body>
	<%@include file="headerInvite.jsp"%>
	<main>
		<div class="titre">
			<h3>Liste des enchères</h3>
		</div>
		<div class="filtre">
			<div class="titreFiltre">
				<h4>Filtres :</h4>
			</div>
			<div class="rechercher">
				<form action="<%=request.getContextPath()%>/AcceuilServlet"
					method="get">
					<div>
						<input type="search" id="maRecherche" name="q"
							placeholder="le nom de l'article contient " />
						<button>Rechercher</button>
					</div>
				</form>
			</div>
			<div class="categorie">
				<div class="choixCategorie">
					<label for="categorie">Catégorie :</label> 
					<form action="<%=request.getContextPath()%>/AcceuilServlet"
					methode="post">
					<select name="categorie"
						id="categorie">
						<!-- <option value="">Toutes</option> -->
						<option value="Informatique">Informatique</option>
						<option value="Ameublement">Ameublement</option>
						<option value="Vètement">Vètement</option>
						<option value="Sport&Loisirs">Sport&Loisirs</option>
					</select>
					<button type="submit">
					<p>rechercher</p>
					</button>
					</form>
				</div>
			</div>
			<div class="checkBox">
				<div>
					<input type="radio" id="achats" name="achats" checked /> <label
						for="achats">achats</label>
				</div>

				<div>
					<input type="checkbox" id="Ventes" name="Ventes" /> <label
						for="Ventes">Mes ventes</label>
				</div>
				<div>
					<input type="checkbox" id="Ventes" name="Ventes" /> <label
						for="Ventes">Mes ventes</label>
				</div>
				<div>
					<input type="checkbox" id="Ventes" name="Ventes" /> <label
						for="Ventes">Mes ventes</label>
				</div>
				<div>
					<input type="checkbox" id="Ventes" name="Ventes" /> <label
						for="Ventes">Mes ventes</label>
				</div>
				<div>
					<input type="checkbox" id="Ventes" name="Ventes" /> <label
						for="Ventes">Mes ventes</label>
				</div>
				<div>
					<input type="checkbox" id="Ventes" name="Ventes" /> <label
						for="Ventes">Mes ventes</label>
				</div>
				<div>
					<input type="checkbox" id="Ventes" name="Ventes" /> <label
						for="Ventes">Mes ventes</label>
				</div>
			</div>
		</div>
		<!-- 		<div class="annonce">
			<div class="annonce1">
				<div class="gauche">
					<div class="imgannonce1">
						<img src="illustrations1.jpg" alt="" width="210" />
					</div>
				</div>
				<div class="droite">
					<div class="titre1">
						<a href="#">enchere n1</a>
					</div>
					<div class="description">
						<div class="prix">
							<p>prix : 210 points</p>
						</div>
						<div class="fin">
							<p>Fin de l'enchere : 10/08/2018</p>
						</div>
						<div class="vendeur">
							<p>Vendeur : jooj44</p>
						</div>
					</div>
				</div>
			</div>
		</div> -->
		<div class="Articles">

			<%
			List<Article> liste = (List<Article>) request.getAttribute("liste");
			if (liste != null) {
				for (Article article : liste) {
					out.print("<p>" + article.getNomArticle() + "</p>");
					out.print("<p>" + article.getPrixInitial() + "</p>");
					out.print("<p>" + article.getDateFinEncheres() + "</p>");
					out.print("<p>" + article.getVendeur() + "</p>");
				}

			} else {
				out.print("<p>zertyuio</p>");
			}
			%>
		</div>
	</main>

</body>
</html>