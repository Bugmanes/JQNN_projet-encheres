<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil</title>
</head>
<body>
	<section>
        <form action="<%=request.getContextPath()+"/GestionProfil" %>>" method="POST">
            <ul>
                <li>${utilisateur.pseudo}</li>
                <li>${utilisateur.nom}</li>
                <li>${utilisateur.prenom }</li>
                <li>${utilisateur.email }</li>
                <li>${utilisateur.telephone }</li>
                <li>${utilisateur.rue}</li>
                <li>${utilisateur.codePostal}</li>
                <li>${utilisateur.ville }</li>
            </ul>
            <button type="submit" value="modifier">Modifier</button>					
					
        </form>
    </section>

 
</body>
</html>