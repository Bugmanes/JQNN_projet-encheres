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
        <h2>D�tail vente</h2>
        <div class="corpsVente">
          <p>nom de la vente</p>
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
            <div>contenu de la description</div>
            <div>la Cat�gorie</div>
            <div>la meilleure offre</div>
            <div>le prix initial</div>
            <div>date de fin d'ench�re</div>
            <div>adresse de retrait</div>
            <div>pseudo du vendeur</div>
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