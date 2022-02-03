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
      	<%Article article = (Article) request.getAttribute("article"); %>
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
            <div><%=article.getCategorie().getLibelle() %></div>
            <div>${article.prixVentes} par <%=article.getAcheteur().getPseudo()%></div>
            <div>${article.prixInitial}</div>
            <div>${article.dateFinEncheres}</div>
            <div><%=article.getRetrait().getRue()%><br>
            	<%=article.getRetrait().getCodePostal() + " " + article.getRetrait().getVille()%>
            </div>
            <div><%=article.getVendeur().getPseudo()%></div>
          </div>
        </div>
        <form method="post" action="#">
          <label for="enchere">Ma proposition : </label>
          <input type="number" name="enchere" id="enchere" />
          <input type="submit" value="Enchérir" />
        </form>
      </main>
      <footer></footer>
    </div>
  </body>
</html>