<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enchère terminée</title>
<link rel="stylesheet" href="asset/css/style.css">
</head>
<body>
    <div class="container">
      <header></header>
      <main>
        <h2>Vous avez remporté la vente</h2>
        <div class="photo"></div>
        <div class="corpsVente">
          <p>${article.nomArticle}</p>
          <div class="left">
            <div>Description :</div>
            <div>Meilleure offre :</div>
            <div>Mise à prix :</div>
            <div>Fin de l'enchère :</div>
            <div>Retrait :</div>
            <div>Vendeur :</div>
          </div>
          <div class="right">
            <div>${article.description}</div>
            <div>${article.prixVentes} pts par ${article.acheteur.pseudo}</div>
            <div>${article.prixInitial}</div>
            <div>${article.dateFinEncheres}</div>
            <div>
              ${article.retrait.rue}<br />
              ${article.retrait.codePostal} ${article.retrait.ville}
            </div>
            <div>${article.vendeur.pseudo}</div>
            <div>${article.vendeur.telephone}</div>
          </div>
          <div class="bouton">
            <a href="#"><button>Retrait effectué</button></a>
            <a href="#"><button>Back</button></a>
          </div>
        </div>
      </main>
      <footer></footer>
    </div>
  </body>
</html>