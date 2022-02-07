<%@page import="fr.eni.projet.bo.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail de l'enchère</title>
<%@include file="headerInvite.jsp" %>
<link rel="stylesheet" href="asset/css/style.css">
</head>
 <body>
    <div class="container">
      <header></header>
      <main>
        <h2>Détail vente</h2>
        <div class="corpsVente">
          <p>${article.nomArticle}</p>
          <div class="left">
            <div>Description :</div>
            <div>Catégorie :</div>
            <div>Meilleure offre :</div>
            <div>Mise à prix :</div>
            <div>Fin de l'enchère :</div>
            <div>Retrait :</div>
            <div>Vendeur :</div>
          </div>
          <div class="right">
            <div>${article.description}</div>
            <div>${article.categorie.libelle}</div>
            <div>${article.prixVentes} pts par ${article.acheteur.pseudo}</div>
            <div>${article.prixInitial}</div>
            <div>${article.dateFinEncheres}</div>
            <div>${article.retrait.rue}<br>
            	${article.retrait.codePostal} ${article.retrait.ville}
            </div>
            <div>${article.vendeur.pseudo}</div>
          </div>
        </div>
        <form method="post" action="<%=request.getContextPath()%>/encherir">
          <label for="enchere">Ma proposition : </label>
          <input type="number" name="enchere" id="enchere" />
          <%
				if (request.getAttribute("enchereOK")!=null){
					boolean enchereOK = (boolean) request.getAttribute("enchereOK");
					if (!enchereOK){
			%>
				<div class="messageErreur">
					<a>L'enchère doit être supérieur à la précédente</a>
				</div>
			<%
					}
				}
			%>
          <input type="submit" value="Enchérir" />
        </form>
      </main>
      <footer></footer>
    </div>
  </body>
</html>