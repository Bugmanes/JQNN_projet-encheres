<%@page import="fr.eni.projet.bo.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail de l'ench�re</title>
<%@include file="headerInvite.jsp" %>
<link rel="stylesheet" href="asset/css/style.css">
</head>
 <body>
    <div class="container">
      <header></header>
      <main>
      	<%Article article = (Article) request.getAttribute("article"); %>
        <h2>D�tail vente</h2>
        <div class="corpsVente">
          <p>${article.nomArticle}</p>
          <div class="left">
            <div>Description :</div>
            <div>Cat�gorie :</div>
            <div>Meilleure offre :</div>
            <div>Mise � prix :</div>
            <div>Fin de l'ench�re :</div>
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
          <input type="submit" value="Ench�rir" />
        </form>
      </main>
      <footer></footer>
    </div>
  </body>
</html>