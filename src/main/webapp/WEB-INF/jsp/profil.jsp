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
        <div class="profil">
            <ul>
            	<%Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %>
          <div> Pseudo :</div>      <li>${utilisateur.pseudo}</li>
          <div> nom :</div>      <li>${utilisateur.nom}</li>
          <div> prenom :</div>      <li>${utilisateur.prenom }</li>
          <div> email :</div>      <li>${utilisateur.email }</li>
           <div> telephone :</div>     <li>${utilisateur.telephone }</li>
           <div> rue :</div>     <li>${utilisateur.rue}</li>
           <div> codePostal :</div>     <li>${utilisateur.codePostal}</li>
           <div> ville :</div>     <li>${utilisateur.ville }</li>
            </ul>
            <% if (request.getAttribute("ok") != null){
           		boolean ok = (boolean) request.getAttribute("ok");
            	if(ok){%>
            	<a href="<%=request.getContextPath()%>/modifierProfil">
            <button type="submit" value="modifier" name="modifier" >Modifier</button>					
            	</a>
			<%}
            	}%>	
        </div>
    </section>

 
</body>
</html>