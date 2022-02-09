<%@page import="fr.eni.projet.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil</title>
</head>
<body>
<% if (request.getAttribute("utilisateur") == null){ %>
		<%@include file="headerInvite.jsp"%>
	<%} else {%>
		<%@include file="headerConnecter.jsp"%>
	<%} %>
	<section>
        <form action="<%=request.getContextPath()+"/afficherProfil" %>" method="post">
            <ul>
            	<%Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %>
          <label> Pseudo :</label>      <li>${utilisateur.pseudo}</li>
          <label> nom :</label>      <li>${utilisateur.nom}</li>
          <label> prenom :</label>      <li>${utilisateur.prenom }</li>
          <label> email :</label>      <li>${utilisateur.email }</li>
           <label> telephone :</label>     <li>${utilisateur.telephone }</li>
           <label> rue :</label>     <li>${utilisateur.rue}</li>
           <label> codePostal :</label>     <li>${utilisateur.codePostal}</li>
           <label> ville :</label>     <li>${utilisateur.ville }</li>
            </ul>
            <% if (request.getAttribute("ok") != null){
           		boolean ok = (boolean) request.getAttribute("ok");
            	if(ok){%>
            <button type="submit" value="modifier" name="modifier" >Modifier</button>					
			<%}
            	}%>
					
        </form>
    </section>

 
</body>
</html>