		<!-- ----------------------------------------Nael---------------------------------------- -->
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
	<% if (request.getAttribute("utilisateur") == null){ %>
		<%@include file="headerInvite.jsp"%>
	<%} else {%>
		<%@include file="headerConnecter.jsp"%>
	<%} %>
<main>
			<div class="text-center m-3">
				<h3>Liste des Enchères</h3>
			</div>
			
	<form action="<%=request.getContextPath()%>/accueil.html" method="post">
				
				<div class="row p-3">
					<h5>Filtres :</h5>
						<input class="form-control " type="search"
						placeholder="Le nom de l'article contient" aria-label="Search">
				</div>
				
		<div class="row ">
			<div class="categorie">
				<label for="categorie">Catégorie :</label> <select name="categorie"
					id="categorie">
					<option value="all">Toutes</option>
					<option value="3">Informatique</option>
					<option value="4">Ameublement</option>
					<option value="5">Vetement</option>
					<option value="6">Sport and Loisirs</option>
				</select>
			</div>
		</div>
	 
		<div class="border border-dark m-2">
			<% if (request.getAttribute("utilisateur") != null){ %>
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
				<%} %>
				
				<div>
					<div class="d-grid col-3 mx-auto p-2" class="btn btn-primary">
						<input type="submit" value="Rechercher">
					</div>
				</div>
			</div>
		</div>

		<% if (request.getAttribute("selection") != null){
		List<Article> selection = (List) request.getAttribute("selection"); 
		if (!selection.isEmpty()){
		for (Article article : selection){
		%>
       <%--  <div class="row  m-5  ">
            <div class="card col-auto " style="width: 18rem;">
                <img src="#" class="card-img-top" alt="...">
                
                <ul class="list-group list-group-flush ">
                <li class="list-group-item">
                <a href="<%=request.getContextPath()%>/afficherVente?idArticle=<%=article.getNoArticle()%>"><%=article.getNomArticle()%></a>
                </li>
                <li class="list-group-item">Prix : <%=article.getPrixVentes()%> points</li>
                <li class="list-group-item">Fin date enchère : <%=article.getDateFinEncheres()%></li>
                <li class="list-group-item">Vendeur : 
                <a href="<%=request.getContextPath()%>/afficherProfil?id=<%=article.getVendeur().getNoUtilisateur()%>"><%=article.getVendeur().getPseudo()%></a>
                </li>
                </ul>
                <div class="card-body">
                </div>
            </div>
        </div> --%>
        
        
        
          <div class="card border-primary mb-3" style="max-width: 18rem;">
                        <div class="card-header text-center">Header</div>
                        <div class="card-body text-primary">
                         
                            <ul class="list-group list-group-flush ">
                                <li class="list-group-item">
                                <a href="<%=request.getContextPath()%>/afficherVente?idArticle=<%=article.getNoArticle()%>"><%=article.getNomArticle()%></a>
                                </li>
                                <li class="list-group-item">Prix : <%=article.getPrixVentes()%> points</li>
                                <li class="list-group-item">Fin date enchère : <%=article.getDateFinEncheres()%></li>
                                <li class="list-group-item">Vendeur : 
                                <a href="<%=request.getContextPath()%>/afficherProfil?id=<%=article.getVendeur().getNoUtilisateur()%>"><%=article.getVendeur().getPseudo()%></a>
                                </li>
                                </ul>
                         
                        </div>

                    </div>   
        <%}
		}
		else {%>
			<h5>La boutique est fermée</h5>
			<%}
		}%>
	</form>
</main>	
		<footer></footer>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</div>
</body>
</html>
		