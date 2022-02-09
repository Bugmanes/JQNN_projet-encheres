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
      <header> <%@include file="headerConnecter.jsp" %></header>

    <div class="container">
  
  		<main>
  			 <form method="post"  class="" action="<%=request.getContextPath()%>/GestionVente">

                        <div class="row"> 
                                <div class="col-3"> 
                                    <label  class="d-flex flex-column bd-highlight fw-bold text-light form-label " for="nomArticle">Article : </label><br><br>
                                    
                                    <label class="d-flex flex-column bd-highlight fw-bold text-light form-label " for="description">Description : </label><br><br>

                                    <label class="d-flex flex-column bd-highlight fw-bold text-light form-label" for="categorie">Catégorie </label> <br>

                                    <label class="d-flex flex-column bd-highlight fw-bold text-light form-label" for="photo">Photo de l'article : </label> <br>

                                    <label class="d-flex flex-column bd-highlight fw-bold text-light form-label form-label " for="prixInitial">Mise à prix : </label><br>

                                    <label class="d-flex flex-column bd-highlight fw-bold text-light form-label" for="debut">Début de l'enchère : </label><br>

                                    <label class="d-flex flex-column bd-highlight fw-bold text-light form-label" for="fin">Fin de l'enchère : </label><br>

                                    <label class="d-flex flex-column bd-highlight fw-bold text-light form-label" for="rue">Rue : </label><br>

                                    <label  class="d-flex flex-column bd-highlight fw-bold text-light form-label"for="codePostal">Code Postal :</label><br>
                                    
                                    <label class="d-flex flex-column bd-highlight fw-bold text-light form-label" for="ville">Ville :</label><br>

                                </div> 


                                <div class="col-6 ">

                                    <input id="nomArticle"  class="float-right mb-2" type="text" name="nomArticle" /> <br>

                                    <textarea class="justify-content-center" name="description"rows="4"cols="30"id="description" ></textarea><br>
                        
                                    <select name="categorie" id="categorie" class="mb-3">
                                        <option value="#"></option>
                                        <option value="#"></option>
                                        <option value="#"></option>
                                        <option value="#"></option>
                                    </select>
                        
                                    <input type="file" name="photo" class="d-flex justify-content-center mb-3 form-control" id="photo">
                        
                                    <input type="number" name="prixInitial" class="d-flex justify-content-center mb-4 form-control" id="prixInitial" />
                        
                                    <input type="date" id="debut" class="d-flex justify-content-center mb-3 form-control" name="debut" />
                        
                                    <input type="date" id="fin" class="d-flex justify-content-center mb-3 form-control" name="fin" />
                        
                                    <div id="retrait">
                                            <input type="text" id="rue" class="d-flex justify-content-center mb-4 form-control" name="rue" value=<%=request.getAttribute("rue")%>>
                        
                                            <input type="text" id="codePostal" class="d-flex justify-content-center mb-1 form-control" name="codePostal" value=<%=request.getAttribute("codePostal")%>>
                        
                                             <input type="text" name="ville" class="d-flex justify-content-center mb-1 form-control" id="ville" value=<%=request.getAttribute("ville")%>>
                        
                                    </div>

                                    <div>
                                            <input type="submit" class="btn btn-success" value="Enregistrer">
                                            <input type="reset" class="btn btn-danger" value="Annuler">
                                       
                                    </div>
                                </div>  


                            
                        </div> 
                                
                </form>
  		
  		</main>
  
  
      <footer></footer>
    </div>
  </body>
</html>







<!-- ----------------------------------------------Orginal----------------------------- -->


  <%--   <main> 
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
              <input type="text" id="rue" name="rue" value=<%=request.getAttribute("rue")%>>
              <label for="codePostal">Code Postal :</label>
              <input type="text" id="codePostal" name="codePostal" value=<%=request.getAttribute("codePostal")%>>
              <label for="ville">Ville :</label>
              <input type="text" name="ville" id="ville" value=<%=request.getAttribute("ville")%>>
            </div>
            <input type="submit" value="Enregistrer">
          
          
            <input type="reset" value="Annuler">
          
          </form>
          
        </div>
      </main> --%>