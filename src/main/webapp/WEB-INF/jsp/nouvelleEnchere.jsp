<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle enchère</title>
<link rel="stylesheet" href="asset/css/style.css">
</head>
<body>
    <div class="container">
      <header></header>
      <main>
        <div id="photo"></div>
        <div class="corpsVente">
          <form method="post" action="<%=request.getContextPath()%>/GestionVente">
            <label for="nomArticle">Article : </label>
            <input id="nomArticle" type="text" name="nomArticle" />
            <label for="description">Description : </label>
            <textarea
              name="description"
              rows="6"
              cols="40"
              id="description"
            ></textarea>
            <label for="categorie">Catégorie </label>
            <select name="categorie" id="categorie">
              <option value="#"></option>
              <option value="#"></option>
              <option value="#"></option>
              <option value="#"></option>
            </select>
            <label for="photo">Photo de l'article : </label>
            <input type="file" name="photo" id="photo">
            <label for="prixInitial">Mise à prix : </label>
            <input type="number" name="prixInitial" id="prixInitial" />
            <label for="debut">Début de l'enchère : </label>
            <input type="date" id="debut" name="debut" />
            <label for="fin">Fin de l'enchère : </label>
            <input type="date" id="fin" name="fin" />
            <div id="retrait">
              <label for="rue">Rue : </label>
              <input type="text" id="rue" name="rue">
              <label for="codePostal">Code Postal :</label>
              <input type="text" id="codePostal" name="codePostal">
              <label for="ville">Ville :</label>
              <input type="text" name="ville" id="ville">
            </div>
            <input type="submit" value="Enregistrer">
            <input type="reset" value="Annuler">
          </form>
        </div>
      </main>
      <footer></footer>
    </div>
  </body>
</html>