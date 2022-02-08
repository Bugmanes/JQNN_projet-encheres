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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
</head> 
<body>
	<div class="container">
		<%@include file="headerInvite.jsp"%>
	</div>

		<!-- ----------------------------------------Nael---------------------------------------- -->

<main>
			<div class="text-center m-3">
				<h3>Liste des Enchères</h3>
			</div>
			
	<form action="<%=request.getContextPath()%>/accueil.html" method="post">
				
				<div class="row p-3">
						<input class="form-control " type="search"
						placeholder="Le nom de l'article contient" aria-label="Search">
				</div>
				
		<div class="row ">
			<div class="categorie">
				<label for="categorie">Catégorie :</label> <select name="categorie"
					id="categorie">
					<option value="all">Toutes</option>
					<option value="1">Informatique</option>
					<option value="2">Ameublement</option>
					<option value="3">Vetement</option>
					<option value="4">Sport and Loisirs</option>
				</select>
			</div>
		</div>
	
		<div class="border border-dark">
	
			<div class="row m-3">
				<div class="  col-6 achats  ">
					<label for="achats">Achats</label> <input type="radio" id="achats"
						name="choix" checked value="achats" />
					<div class="p-2">
						<input type="checkbox" id="encheresOuvertes" name="triAchats"
							value="encheresOuvertes" /> <label for="encheresOuvertes">enchères
							ouvertes</label><br> <input type="checkbox" id="encheresEnCours"
							name="triAchats" value="encheresEnCours" /> <label
							for="encheresEnCours">Mes enchères en cours</label><br> <input
							type="checkbox" id="encheresRemportees" name="triAchats"
							value="encheresRemportees" /> <label for="encheresRemportees">Mes
							enchères remportées</label>
					</div>
				</div>
				<div class="col col-6 ventes ">
					<label for="ventes">Mes ventes</label> <input type="radio"
						id="ventes" name="choix" value="ventes" />
					<div class="p-2">
						<input type="checkbox" id="venteEnCours" name="triVentes"
								value="venteEnCours" /> <label for="venteEnCours">mes
								ventes en cours</label><br> <input type="checkbox"
								id="ventesNonDebutees" name="triVentes" value="ventesNonDebutees" />
							<label for="ventesNonDebutees">ventes non débutées</label><br>
							<input type="checkbox" id="ventesTerminees" name="triVentes"
									value="ventesTerminees" /> <label for="ventesTerminees">ventes
							terminées</label>
					</div>
				</div>
				
				<div>
					<div class="d-grid col-3 mx-auto " class="btn btn-primary">
						<input type="submit" value="Rechercher">
					</div>
				</div>
			</div>
	
		</div>
	</form>
</main>		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	<!-- ----------------------------------Orginal---------------------------------------- -->
<!-- 		
		 <main>
		
			<div class="titre">
				<h3>Liste des enchères</h3>
			</div>
			<div class="selection">
			<div class="titreFiltre">
				<h4>Filtres :</h4>
			</div>
			<form action="<%=request.getContextPath()%>/accueil.html" method="post">
				<div class="rechercher">
					<input type="search" id="recherche" name="recherche" 
						placeholder="le nom de l'article contient " />
				</div>
				<div class="categorie">
					<label for="categorie">Catégorie :</label>
					<select name="categorie" id="categorie">
						<option value="all">Toutes</option>
						<option value="1">Informatique</option>
						<option value="2">Ameublement</option>
						<option value="3">Vetement</option>
						<option value="4">Sport&Loisirs</option>
					</select>
				</div>
				<div class="filtres">
					<div class="achats">
						<label for="achats">achats</label>
						<input type="radio" id="achats" name="choix" checked value="achats"/>
						<div class="checkbox">
							<input type="checkbox" id="encheresOuvertes" name="triAchats" value="encheresOuvertes"/>
							<label for="encheresOuvertes">enchères ouvertes</label>
							<input type="checkbox" id="encheresEnCours" name="triAchats" value="encheresEnCours"/> 
							<label for="encheresEnCours">Mes enchères en cours</label>
							<input type="checkbox" id="encheresRemportees" name="triAchats" value="encheresRemportees"/>
							<label for="encheresRemportees">Mes enchères remportées</label>
						</div>
					</div>
					<div class="ventes">
						<label for="ventes">Mes ventes</label>
						<input type="radio" id="ventes" name="choix" value="ventes"/>
						<div class="checkbox">
							<input type="checkbox" id="venteEnCours" name="triVentes" value="venteEnCours"/>
							<label for="venteEnCours">mes ventes en cours</label>
							<input type="checkbox" id="ventesNonDebutees" name="triVentes" value="ventesNonDebutees"/> 
							<label for="ventesNonDebutees">ventes non débutées</label>
							<input type="checkbox" id="ventesTerminees" name="triVentes" value="ventesTerminees" />
							<label for="ventesTerminees">ventes terminées</label>
						</div>
					</div>
				</div>
				<div class="submit">
					<input type="submit" value="Rechercher">
				</div>
			</form>
			</div>  -->
<!-- ------------------------------------------------------------------------------- -->








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
		</div> 
	<div class="Articles">
		<table>
			<thead>
				<th>titre</th>
				<th>prix</th>
				<th>date de fin</th>
				<th>Vendeur</th>
			</thead>
			<tbody>
				<%-- <%
				List<Article> liste = (List<Article>) request.getAttribute("liste");
				if (liste != null && liste.size() > 0) {
					for (Article article : liste) {
						out.print("<tr>");
						out.print("<td>" + article.getNomArticle() + "</td>");
						out.print("<td>" + article.getPrixInitial() + "</td>");
						out.print("<td>" + article.getDateFinEncheres() + "</td>");
						out.print("<td>" + article.getVendeur().getPseudo() + "</td>");
						out.print("</tr>");
					}

					out.print("</tbody>");
					out.print("</table>");

				} else

				{

					out.print("<p>La Boutique est fermée</p>");

				}
				%>





				<%
				List<Article> listeC = (List<Article>) request.getAttribute("listeCat");
				%>

				<%
				if (listeC != null && listeC.size() > 0) {

					for (Article article : listeC) {
						out.print("<tr>");
						out.print("<td>" + article.getNomArticle() + "</td>");
						out.print("<td>" + article.getPrixInitial() + "</td>");
						out.print("<td>" + article.getDateFinEncheres() + "</td>");
						out.print("<td>" + article.getVendeur().getPseudo() + "</td>");
						out.print("</tr>");
					}

					out.print("</tbody>");
					out.print("</table>");

				} else

				{

					out.print("<p>La Boutique est fermée</p>");

				}
				%> --%>



			</tbody>
		</table>-->

		
		<footer></footer>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>