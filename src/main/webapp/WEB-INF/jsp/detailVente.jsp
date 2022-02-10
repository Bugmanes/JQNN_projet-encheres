<%@page import="fr.eni.projet.bo.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail de l'ench�re</title>
<link rel="stylesheet" href="asset/css/style.css">
</head>
 <body>
    <div class="container">
<% if (request.getAttribute("utilisateur") == null){ %>
		<%@include file="headerInvite.jsp"%>
	<%} else {%>
		<%@include file="headerConnecter.jsp"%>
	<%} %>
      <main>
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
            <div>${article.categorie.libelle}</div>
            <div>${article.prixVentes} pts 
            <%Article art = (Article) request.getAttribute("article");
            if (art.getPrixInitial() != art.getPrixVentes()){
            %>
            par ${article.acheteur.pseudo}</div>
            <%} %>
            <div>${article.prixInitial} pts</div>
            <div>${article.dateFinEncheres}</div>
            <div>${article.retrait.rue}<br>
            	${article.retrait.codePostal} ${article.retrait.ville}
            </div>
            <div>${article.vendeur.pseudo}</div>
          </div>
        </div>
        <%
        boolean proprio = (boolean) request.getAttribute("proprio");
        if (!proprio) {
        %>
        <form method="post" action="<%=request.getContextPath()%>/afficherVente">
          <label for="enchere">Ma proposition : </label>
          <input type="text" name="enchere" id="enchere" />
          <input type="submit" value="Ench�rir" />
         
          	<%
				if (request.getAttribute("enchereValeurOK")!=null){
					boolean enchereValeurOK = (boolean) request.getAttribute("enchereValeurOK");
					if (!enchereValeurOK){
			%>
				<div class="messageErreur">
					<a>L'ench�re doit �tre sup�rieur � la pr�c�dente</a>
				</div>
			<%
					}
				}
			%>
			<%
				if (request.getAttribute("enchereNbOK")!=null){
					boolean enchereNbOK = (boolean) request.getAttribute("enchereNbOK");
					if (!enchereNbOK){
			%>
				<div class="enchereNbOK">
					<a>L'ench�re ne doit contenir que des chiffres</a>
				</div>
			<%
					}
				}
			%>
        </form>
        <%} %>
         <a href="<%=request.getContextPath()%>/accueil.html"><button>Retour � l'accueil</button></a>
      </main>
      <footer></footer>
    </div>
  </body>
</html>