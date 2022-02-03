<%@page import="fr.eni.projet.bll.UtilisateurManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon profil</title>
</head>
<body>
<%@include file="headerConnecter.jsp" %>
<form action="" method="POST">
      
      Pseudo : <input type="text" placeholder="Saisissez votre user Pseudo :" autocomplete="${utilisateur.pseudo}" ><br>
      Saisissez votre Nom :<input type="text" placeholder="Saisissez votre nom :"autocomplete="${utilisateur.nom}"><br>
      Saisissez votre prenom :<input type="text" placeholder="Saisissez votre prenom :"autocomplete="${utilisateur.prenom }"><br>
      Saisissez votre email:<input type="email" placeholder="Saisissez votre email:"autocomplete="${utilisateur.email }"><br>
      Saisissez votre Telephone :<input type="text" placeholder="Saisissez votre telephone :"autocomplete="${utilisateur.telephone }"><br>
      Mot de passe Actuel :<input type="password" placeholder=" password Actuel :"><br>
      Saisissez nouveau password :<input type="password" placeholder="Saisissez nouveau password :"><br>
      Confirmation :<input type="password" placeholder="Conform your password :"><br>
      Saisissez votre Rue:<input type="email" placeholder="Saisissez votre Rue:"autocomplete="${utilisateur.rue}"><br>
      Saisissez votre Ville:<input type="email" placeholder="Saisissez votre Ville :"autocomplete="${utilisateur.ville }"><br>
      Saisissez votre Code_Postal:<input type="text" placeholder="Saisissez votre Code Pstal:"autocomplete="${utilisateur.codePostal}"><br>
	  
	  Crédit :${utilisateur.credit} 
	  	 	      
      <input type="submit" value="modifier"  name = "modifier" >
      <input type="submit" value="Supprimer mon compte " name ="supprimer">
    </form>
	

</body>
</html>